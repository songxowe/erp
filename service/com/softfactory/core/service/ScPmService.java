package com.softfactory.core.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.ScPmMapper;
import com.softfactory.pojo.dto.Pm;

@Service("pmService")
public class ScPmService {
	@Resource(name ="pmMapper")
	private ScPmMapper pmMapper;
	
	public List<Pm> findByProductId(String ProductId){		
		return pmMapper.findByProductId(ProductId);		
	}
}
