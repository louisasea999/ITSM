package com.yum.itsm.ddtalk.common.mybatis;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisCommonDao extends MybatisDao {
	private static final Logger logger = LoggerFactory.getLogger(MybatisCommonDao.class);

	MybatisCommonDao() {
		super();
		namespace = "com.ciicsh.common.mybatis.mapper.CommonMapper";
	}

	public int insert(String sql) {
		return sqlSession.insert(fullSqlMapName("insert"), sql);
	}

	public int update(String sql) {
		return sqlSession.update(fullSqlMapName("update"), sql);
	}

	public int delete(String sql) {
		return sqlSession.delete(fullSqlMapName("delete"), sql);
	}

	public List<Map<String, Object>> query(String sql) {
		return sqlSession.selectList(fullSqlMapName("query"), sql);
	}
	
	public Date getCurrentDate() {
		return sqlSession.selectOne(fullSqlMapName("getCurrentDate"));
	}
	
//	public Long getCustomSequence(String objName) {
//		return sqlSession.selectOne(fullSqlMapName("getCustomSequence"), objName);
//	}
	
	public String getNextCode(String prefix, int includeYear, int includeMonth, int len) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("prefix", prefix);
		params.put("year", includeYear);
		params.put("month", includeMonth);
		params.put("length", len);
		
		return sqlSession.selectOne(fullSqlMapName("getNextCode"), params);
	}
} 
