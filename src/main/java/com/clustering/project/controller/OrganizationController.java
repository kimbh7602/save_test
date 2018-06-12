/**
 * It's Designed For incubation Center
 * @author ohsanghun
 * @version     %I%, %G%
 * @since       1.0
 */
package com.clustering.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.clustering.project.service.OrganizationService;
import com.clustering.project.util.CommonUtil;

/**
 * @author ohsanghun
 * get it Mapping classlevel (JavaBean, HttpServletRequest, Model, View, ModelAndView)
 */

// ? delete @Controller, 
//@Controller
@Component
@RequestMapping(value = "/organization")
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private CommonUtil commonUtil;

	// ? add View class
	@RequestMapping(value = "/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public Model edit(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, Model model) {
		
		if(paramMap.get("ORGANIZATION_SEQ") == null) {
			String seq = commonUtil.gerUniqueSequence();
			paramMap.put("ORGANIZATION_SEQ", seq);
		}
		
		model.addAttribute("resultMap", paramMap);
		
		
		return model;
	}

	
	// ? delete only method = RequestMethod.GET in @RequestMapping 
	@RequestMapping(value = "/read", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView read(@RequestParam Map<String, Object> paramMap, ModelAndView modelandView) {
		
		String viewName = "/organization/read";
		
		Map resultMap = new HashMap();
		resultMap = (Map) organizationService.getObject("organization.read", paramMap);
		
		modelandView.setViewName(viewName);

		modelandView.addObject("resultMap", resultMap);
		return modelandView;

	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView list(@RequestParam Map<String, Object> paramMap, ModelAndView modelandView) {
		
		String viewName = "/organization/list";

		List<Object> resultList = new ArrayList<Object>();

		resultList = (List<Object>) organizationService.getList("organization.list", paramMap);

		modelandView.setViewName(viewName);

		modelandView.addObject("resultList", resultList);
		
		return modelandView;

	}
	
	@RequestMapping(value = "/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView insert(@RequestParam Map<String, Object> paramMap, ModelAndView modelandView) {
			
		organizationService.saveObject("", paramMap);
		
		String viewName = "/organization/list";
		List<Object> resultList = new ArrayList<Object>();
		resultList = (List<Object>) organizationService.getList("organization.list", paramMap);
		modelandView.setViewName(viewName);
		modelandView.addObject("resultList", resultList);
		return modelandView;
	}
	
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView delete(@RequestParam Map<String, Object> paramMap, ModelAndView modelandView) {
			
		
		organizationService.deleteObject("", paramMap);
		
		return list(paramMap, modelandView);
	}
	
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView update(@RequestParam Map<String, Object> paramMap, ModelAndView modelandView) {
			
		
		organizationService.updateObject("", paramMap);
		
		return read(paramMap, modelandView);
	}
}
