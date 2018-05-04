package com.oracle.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.service.ClassService;
import com.oracle.vo.TbClass;
@Controller
@RequestMapping("/class")
public class ClassHandlle {  
    @Autowired
	ClassService classService;
	
	
	@RequestMapping("/{path}")
	public String path(@PathVariable("path")String path){
		
		return "class/"+path;
	}
	
	@RequestMapping("success")
	   public String getSuccess(){
		   return "success";
	   }
    @RequestMapping("/save")
	public String save(TbClass tbClass){
		
    	classService.save(tbClass);
    	
    	return "redirect:getAll/1";
	} 
	@RequestMapping(value="/getAll/{page}")
    public String getAll(@PathVariable("page") int page,Map<String ,Object> map){
    	//…Ë÷√¥Û–°
		PageHelper.startPage(page,10);
		
		PageInfo<Map<String,Object>> info=new PageInfo<Map<String,Object>>(classService.selectAll());
		map.put("info",info);
		return "class/listClass";
    }
}
