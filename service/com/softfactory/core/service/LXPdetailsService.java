package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.LXPdetailsMapper;
import com.softfactory.pojo.LXPdetails;

/**
 * 自定义类2服务层
 * 
 * @author Administrator
 * 
 */
@Service("lxPdetailsService")
public class LXPdetailsService {
	@Resource(name = "lxpdetailsMapper")
	private LXPdetailsMapper LxpdetailsMapper;

	public List<LXPdetails> findByPId(String productId) {
		return LxpdetailsMapper.findByPId(productId);
	}
	public LXPdetails findById(Integer id) {
		return LxpdetailsMapper.findById(id);
	}
}
