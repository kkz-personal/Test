package com.oracle.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.service.CommonService;

@Controller
@RequestMapping("/class")
public class CommonController {
	
	@Autowired
	CommonService commonService;
	
	@RequestMapping(value="/getState/{type}/{stateId}",produces="text/html;charset=utf-8")
	@ResponseBody
	public String getSubject(@PathVariable("type") Integer type,@PathVariable("stateId") Integer stateId){
		
		String str=commonService.getState(type, stateId);
		
		return str;
	}
	
	@RequestMapping(value="/getTeacher/{teacherId}",produces="text/html;charset=utf-8")
	@ResponseBody
	public String getTeacher(@PathVariable("teacherId") Integer teacherId){
		
		String str=commonService.getTeacher(teacherId);
		
		return str;
	}
	
	@RequestMapping(value="/getGuides/{type}/{guideId}",produces="text/html;charset=utf-8")
	@ResponseBody
	public String getGuide(@PathVariable("type") Integer type,@PathVariable("guideId") Integer guideId){
		
		String str=commonService.getGuides(type,guideId);
		
		return str;
	}
	
}
