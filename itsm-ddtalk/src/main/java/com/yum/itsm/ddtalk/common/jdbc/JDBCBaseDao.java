package com.yum.itsm.ddtalk.common.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yum.itsm.ddtalk.common.page.Page;
import com.yum.itsm.ddtalk.common.page.PageContext;


@Repository
public class JDBCBaseDao {
	private static Logger logger = LoggerFactory.getLogger(JDBCBaseDao.class);

	public int batchSize = 20;

	public int fetchSize = 50;

	public void closeStatement(Statement stmt) {
		JDBCHelper.closeStatement(stmt);
	}

	public void closeResultSet(ResultSet rs) {
		JDBCHelper.closeResultSet(rs);
	}

	public void rollback(Connection con) {
		JDBCHelper.rollback(con);
	}

	/**
	 * FOR ORACLE
	 */
	public Long getSequence(Connection con, String seqName)
			throws SQLException {
		return JDBCHelper.getSequence(con, seqName);
	}

	public Date getCurrentDate(Connection con) {
		return JDBCHelper.getCurrentDate(con);
	}

	public void setStatementParam(PreparedStatement pstmt, Object[] params) {
		JDBCHelper.setStatementParam( pstmt, params);
	}

	public List<Map<String, Object>> query(	Connection con, String sql, Object[] params)
			throws Exception {
		return JDBCHelper.query(con, sql, params);
	}

	public Page<Map<String, Object>> paginate(Connection con, String sql, Object[] params, PageContext pageContext)
			throws Exception {
		return JDBCHelper.paginate(	con, sql, params, pageContext);
	}

	public static void executeSql(Connection con, String sql, Object[] params)
			throws Exception {
		JDBCHelper.executeSql(con, sql, params);
	}

}
