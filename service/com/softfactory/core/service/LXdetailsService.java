package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.LXdetailsMapper;
import com.softfactory.pojo.LXdetails;

/**
 * 自定义类1服务层
 * 
 * @author Administrator
 * 
 */
@Service("lxDetailsService")
public class LXdetailsService {

	@Resource(name = "lxDetailsMapper")
	private LXdetailsMapper lxDetailsMapper;

	public List<LXdetails> findByPId(Integer id) {
		return lxDetailsMapper.findByPId(id);
	}

	public List<LXdetails> findById(Integer id) {
		return lxDetailsMapper.findById(id);
	}
}
