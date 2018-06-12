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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.clustering.project.service.MemberService;
import com.clustering.project.util.CommonUtil;

@Controller
public class MemberController {
	private final static String MAPPING = "/member";
	@Autowired
	private MemberService memberService;
	@Autowired
	private CommonUtil commonUtil;
	
	@RequestMapping(value = MAPPING, method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView actionMethod(@RequestParam Map<String, Object> paramMap, ModelAndView modelandView) {

		String viewName = MAPPING + "/";
		String action = (String) paramMap.get("action") ;
		
		Map<String, Object> resultMap = new HashMap<String, Object>() ;
		List<Object> resultList = new ArrayList<Object>();

		// divided depending on action value
		if ("edit".equalsIgnoreCase(action)) {
			viewName = viewName + action;
			if(paramMap.get("MEMBER_SEQ") == null) {
				String seq = commonUtil.gerUniqueSequence();
				paramMap.put("MEMBER_SEQ", seq);
			}
			
		} else if ("read".equalsIgnoreCase(action)) {
			viewName = viewName + action;
			resultMap = (Map)memberService.getObject("", paramMap);
			
		} else if ("list".equalsIgnoreCase(action)) {
			viewName = viewName + action;
			resultList = (List)memberService.getList("", paramMap);
		} else if("insert".equals(action)) {
			viewName = viewName + "list";
			resultList = (List)memberService.insertObject("", paramMap);
		} else if("delete".equals(action)) {
			viewName = viewName + "list";
			resultList = (List)memberService.deleteObject("", paramMap);
		} else if("update".equals(action)) {
			viewName = viewName + "read";
			resultMap = (Map)memberService.updateObject("", paramMap);
		}

		modelandView.setViewName(viewName);

		modelandView.addObject("paramMap", paramMap);
		modelandView.addObject("resultMap", resultMap);
		modelandView.addObject("resultList", resultList);

		return modelandView;
	}
}