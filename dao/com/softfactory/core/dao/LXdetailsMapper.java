package com.softfactory.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.softfactory.pojo.LXdetails;

/**
 * 自定义类1持久层
 * 
 * @author Administrator
 * 
 */
@Repository("lxDetailsMapper")
public interface LXdetailsMapper {
	List<LXdetails> findByPId(Integer id);
	List<LXdetails> findById(Integer id);
}
