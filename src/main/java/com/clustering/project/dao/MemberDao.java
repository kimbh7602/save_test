package com.clustering.project.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	public List<Object> getList(String sqlMapId, Object dataMap){
		List<Object> result = sqlSession.selectList(sqlMapId, dataMap);
		return result;
	}
	public Object getObject(String sqlMapId, Object dataMap) {
		Object result = sqlSession.selectOne(sqlMapId, dataMap);
		return result;
	}
	
	public Object saveObject(String sqlMapId, Object dataMap) {
		Integer result = sqlSession.insert(sqlMapId, dataMap);
		return result;
	}
	
	public Object deleteObject(String sqlMapId, Object dataMap) {
		Integer result = sqlSession.delete(sqlMapId, dataMap);
		return result;
	}
}
