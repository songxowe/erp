package com.softfactory.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.softfactory.pojo.dto.Pm;

/**
 * 工序物料设计单处理接口
 * 
 * @author shengchen
 * 
 */
@Repository("pmMapper")
public interface ScPmMapper {
	/**
	 * 多表查询 单个产品所有物料数据
	 */
	public List<Pm> findByProductId(String ProductId);

}
