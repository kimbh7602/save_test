package com.clustering.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clustering.project.dao.MemberDao;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	public Object getObject(String sqlMapId, Object dataMap) {
		sqlMapId = "member.read";
		
		Object resultObject = memberDao.getObject(sqlMapId, dataMap);
		return resultObject;
	}
	
	public Object getList(String sqlMapId, Object dataMap) {
		sqlMapId = "member.list";
		
		List resultList = memberDao.getList(sqlMapId, dataMap);
		return resultList;
	}
	
	public Object deleteObject(String sqlMapId, Object dataMap) {
		sqlMapId = "member.delete";
		
		Integer resultKey = (Integer)memberDao.deleteObject(sqlMapId, dataMap);
		sqlMapId = "member.list";
		List resultObject = memberDao.getList(sqlMapId, dataMap);
		return resultObject;
	}
	
	public Object insertObject(String sqlMapId, Object dataMap) {
		sqlMapId = "member.insert";
		Map resultMap = (Map)dataMap;
		resultMap.put("REGISTER_SEQ", resultMap.get("MEMBER_SEQ"));
		resultMap.put("MODIFIER_SEQ", resultMap.get("MEMBER_SEQ"));
		String date = "SYSDATE";
		resultMap.put("REGISTRY_DATE", date);
		resultMap.put("MODIFY_DATE", date);
		resultMap.put("ORGANIZATION_SEQ", "UUID-11-CIP5");
		
		Integer resultKey = (Integer)memberDao.saveObject(sqlMapId, resultMap);
		sqlMapId = "member.list";
		List resultObject = memberDao.getList(sqlMapId, dataMap);
		return resultObject;
	}
	
	public Object updateObject(String sqlMapId, Object dataMap) {
		sqlMapId = "member.update";
		
		Integer resultKey = (Integer)memberDao.saveObject(sqlMapId, dataMap);
		sqlMapId = "member.read";
		Map resultObject = (Map)memberDao.getObject(sqlMapId, dataMap);
		return resultObject;
	}
	
	
	
}
