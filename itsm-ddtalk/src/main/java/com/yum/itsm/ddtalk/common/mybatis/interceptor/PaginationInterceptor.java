package com.yum.itsm.ddtalk.common.mybatis.interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.RowBounds;

import com.yum.itsm.ddtalk.common.jdbc.dialect.Dialect;
import com.yum.itsm.ddtalk.common.jdbc.dialect.DialectFactory;


/**
 * 为Mybatis提供基于方言(Dialect)的分页查询的插件
 * 
 * 通过拦截<code>StatementHandler</code>的<code>prepare</code>方法，重写sql语句实现物理分页。
 * 签名里要拦截的类型只能是接口。
 * 
 * 配置文件内容:
 * 
 * <pre>
 * 	&lt;plugins>
 * 	&lt;plugin interceptor="com.ciicsh.personnel.common.mybatis.interceptor.PaginationInterceptor">
 * 		&lt;property name="dialect" value="oracle"/>
 * 	&lt;/plugin>
 * &lt;/plugins>
 * </pre>
 * 
 * @author Wesley Su
 * 
 */
// @Intercepts({ @Signature(type = Executor.class, method = "query", args = {
// MappedStatement.class,
// Object.class,
// RowBounds.class,
// ResultHandler.class }) })
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PaginationInterceptor
		implements Interceptor {
	private static final Log logger = LogFactory.getLog(PaginationInterceptor.class);

	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();

	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

	private static Dialect dialect = null;

	/**
	 * 
	 * 拦截后要执行的方法
	 * 
	 * @param invocation
	 *          Invocation(Object target, Method method, Object[] args)
	 * 
	 */
	@Override
	public Object intercept(Invocation invocation)
			throws Throwable {
		pagination(invocation);

		// 将执行权交给下一个拦截器
		return invocation.proceed();
	}

	/**
	 * 
	 * 包装处理器，处理器包括结果，语句，参数，执行
	 * 
	 * @param target
	 *          可能的值有StatementHander（对应JDBC的Statement，STATEMENT、
	 *          PREPARED和CALLABLE三种类型
	 *          ）、Executor（对应executorType，BatchExecutor、ReuseExecutor
	 *          、SimpleExecutor、CachingExecutor）、ParameterHandler、ResultSetHandler
	 * 
	 */
	@Override
	public Object plugin(Object target) {
		// 当目标类是StatementHandler类型时，才包装目标类，否者直接返回目标本身,减少目标被代理的 次数
		if (target instanceof StatementHandler) {
			return Plugin.wrap(	target,
													this);
		} else {
			return target;
		}
	}

	/**
	 * 设置注册拦截器时设定的属性
	 */
	@Override
	public void setProperties(Properties properties) {
		// To change body of implemented methods use File | Settings | File
		// Templates.
		String dialect = (String) properties.get("dialect");
		PaginationInterceptor.dialect = new DialectFactory().getDialect(dialect);
	}

	/**
	 * 
	 * pagination:(物理分页). <br/>
	 * (对所有Select语句进行分页，).<br/>
	 * 先判断是否需要分页，分页必须满足以下条件（sql类型为select，执行方法为prepare，
	 * 并且参数中包含了PageContext类型的元素或调用的是带有offset和limit参数的select方法）<br/>
	 * 生成分页Sql，重置原有的BoundSql的sql和RowBounds的值为分页的值<br/>
	 * 参数中包含PageContext类型的对象（Map的元素或Bean的属性或参数本身就是PageContext）
	 * 或调用了SqlSession的带offset和limit参数的select方法.<br/>
	 * 
	 * @param invocation
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private void pagination(Invocation invocation)
			throws InvocationTargetException, IllegalAccessException {
		Method method = invocation.getMethod();
		Object target = invocation.getTarget();
		// 当目标类是StatementHandler类型时，才包装目标类，否者直接返回目标本身,减少目标被代理的次数
		// 注解已经指定，不需要再判断
		// if (!(target instanceof StatementHandler)) {
		// return invocation.proceed();
		// }

		StatementHandler statementHandler = (StatementHandler) target;
		MetaObject metaStatementHandler = MetaObject.forObject(	statementHandler,
																														DEFAULT_OBJECT_FACTORY,
																														DEFAULT_OBJECT_WRAPPER_FACTORY);
		// 拦截query方法时使用
		// MappedStatement mappedStatement = (MappedStatement)
		// invocation.getArgs()[MAPPED_STATEMENT_INDEX];
		// Object parameter = invocation.getArgs()[PARAMETER_INDEX];
		// RowBounds rowBounds = (RowBounds) invocation.getArgs()[ROWBOUNDS_INDEX];
		// ResultHandler resultHandler = (ResultHandler)
		// invocation.getArgs()[RESULT_HANDLER_INDEX];

		// 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环可以分离出最原始的的目标类)
		while (metaStatementHandler.hasGetter("h")) {
			Object object = metaStatementHandler.getValue("h");
			metaStatementHandler = MetaObject.forObject(object,
																									DEFAULT_OBJECT_FACTORY,
																									DEFAULT_OBJECT_WRAPPER_FACTORY);
		}
		// 分离最后一个代理对象的目标类
		while (metaStatementHandler.hasGetter("target")) {
			Object object = metaStatementHandler.getValue("target");
			metaStatementHandler = MetaObject.forObject(object,
																									DEFAULT_OBJECT_FACTORY,
																									DEFAULT_OBJECT_WRAPPER_FACTORY);
		}

		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
		RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");

		// method name is method name of StatementHandler : prepare, query, batch,
		// parameterize, update
		String methodName = method.getName();
		// Mapper文件中的SQL语句映射<SELECT/>、<UPDATE/>、<DELETE/>
		String sqlType = mappedStatement.getSqlCommandType().name();

//		logger.debug("Mybatis intercepted method name is [" + methodName + "]");
//		logger.debug("Mybatis intercepted sql type is [" + sqlType + "]");

		// 只拦截query方法
		if (!sqlType.equals("SELECT"))
			return;

		// 分页参数作为参数对象parameterObject的一个属性
		BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
		// BoundSql boundSql = mappedStatement.getBoundSql(parameterObject);
		Object parameterObject = metaStatementHandler.getValue("delegate.boundSql.parameterObject");
		// Object parameterObject = boundSql.getParameterObject();

		String originalSql = boundSql.getSql().trim();

		// 判断是否需要分页
		// if (page == null && (rowBounds == null || rowBounds ==
		// RowBounds.DEFAULT)) {
		if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {
			return;
		}

		if(dialect.supportPaginal()) {
			String pageSql = dialect.getPaginationSql(originalSql, rowBounds.getOffset(), rowBounds.getLimit());
			// 重写sql
			metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
			
			// 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数
			metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
			metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
			
			// logger.debug("生成分页SQL : " + boundSql.getSql());
		} else {
			return;
		}
	}

}
