package com.softfactory.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.DesignModuleMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.DesignModule;
@Service("designModuleService")
public class DesignModuleService {
	@Resource(name="designModuleMapper")
	private DesignModuleMapper designModuleMapper;
	public Pager<DesignModule> findPager(Integer pageno, Integer pagesize, String sort,
			String order, String productName,String checkTag){
		Pager<DesignModule> pager = new Pager<DesignModule>();
		pager.setRows(designModuleMapper.findPager(pageno, pagesize, sort, order, productName, checkTag));
		pager.setTotal(designModuleMapper.findPagerTotal(productName,checkTag));
		return pager;
	}
	
	public DesignModule findById(Integer id){
		return designModuleMapper.findById(id);
	}
}
