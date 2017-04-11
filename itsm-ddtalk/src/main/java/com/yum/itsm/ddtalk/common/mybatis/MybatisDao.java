package com.yum.itsm.ddtalk.common.mybatis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.lang3.math.NumberUtils;
import org.mybatis.spring.SqlSessionTemplate;

/**
 * 
 * Project Name: OSHA <br/>
 * Package Name: com.ciicsh.personnel.common.mybatis <br/>
 * ClassName: MyBatisDao <br/>
 * Function: MyBatis基础DAO类，提供SqlSession的注入方法. <br/>
 * Date: 2014-1-23 下午10:44:26 <br/>
 * 
 * @version
 * @author Walker mailto: zuwei.su@qq.com
 * @date 2014-1-23 下午10:44:26
 */
public class MybatisDao {
	protected SqlSessionTemplate sqlSession;

	protected String namespace = null;

	public MybatisDao() {
	}

	@Resource
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	protected String fullSqlMapName(String sqlMapId) {
		return namespace + "." + sqlMapId;
	}

}
