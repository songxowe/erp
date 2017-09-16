package com.softfactory.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.softfactory.pojo.LXPdetails;
/**
 * 自定义类2持久层
 * @author Administrator
 *
 */
@Repository("lxpdetailsMapper")
public interface LXPdetailsMapper {
	
	List<LXPdetails> findByPId(String productId);
	
	LXPdetails findById(Integer id);
}
