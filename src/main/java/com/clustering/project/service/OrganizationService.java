package com.clustering.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clustering.project.dao.OrganizationDao;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationDao organizationDao;
	
	public Object getList(String sqlMapId, Object dataMap) {
		Object resultObject = organizationDao.getList(sqlMapId, dataMap);
		return resultObject;
	}
	public Object getObject(String sqlMapId, Object dataMap) {
		Object resultObject = organizationDao.getObject(sqlMapId, dataMap);
		return resultObject;
	}
	
	public Object deleteObject(String sqlMapId, Object dataMap) {
		sqlMapId = "organization.delete";
		Object resultObject = organizationDao.deleteObject(sqlMapId, dataMap);
		return resultObject;
	}
	
	public Object saveObject(String sqlMapId, Object dataMap) {
		sqlMapId = "organization.insert";
		Object resultObject = organizationDao.saveObject(sqlMapId, dataMap);
		return resultObject;
	}
	
	public Object updateObject(String sqlMapId, Object dataMap) {
		sqlMapId = "organization.update";
		Object resultObject = organizationDao.saveObject(sqlMapId, dataMap);
		return resultObject;
	}
}
