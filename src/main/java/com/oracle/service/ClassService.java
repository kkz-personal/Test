package com.oracle.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.dao.TbClassMapper;
import com.oracle.vo.TbClass;

@Service
public class ClassService {
	
	@Autowired
	TbClassMapper classdao;
	
	@Transactional
	public void save(TbClass tbClass){
		classdao.insert(tbClass);
		
	}
	
	@Transactional(readOnly=true)
	public List<Map<String,Object>> selectAll(){
		
		return classdao.selectAll();
	}
}
