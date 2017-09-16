package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.DesignModule;


@Repository("designModuleMapper")
public interface DesignModuleMapper {

	
	List<DesignModule> findPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order,
			@Param("productName") String productName,@Param("checkTag")String checkTag);

	/**
	 * 统计总数+条件查询
	 * 
	 * @param ename
	 * @return
	 */
	long findPagerTotal(@Param("productName") String productName,@Param("checkTag")String checkTag);
	
	DesignModule findById(Integer id);
}
