package com.yum.itsm.ddtalk.common.jdbc.dialect;

/**
 * 
 * @description MySQL数据库实现
 * 
 */
public class MySqlDialect implements Dialect {
	protected static final String SQL_END_DELIMITER = ";";
	
	@Override
	public boolean supportPaginal() {
		return true;
	}

	@Override
	public String getPaginationSql(String sql, int offset, int limit) {
		return MySqlPageHepler.getPageSql(	sql, offset,limit);
	}
}
