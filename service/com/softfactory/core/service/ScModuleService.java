package com.softfactory.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.ScMdpModuleMapper;
import com.softfactory.pojo.MdpModule;

@Service("moduleService")
public class ScModuleService {
	@Resource(name = "mdpModuleMapper")
	private ScMdpModuleMapper mdpModuleMapper;
	
	/**
	 * 将数据新增到产品生产工序物料明细中
	 */
	public void addMdpModule(MdpModule m){
		 mdpModuleMapper.addMdpModule(m);
	}
}
