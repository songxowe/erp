package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.DmDetails;

/**
 * 产品物料组成明细映射器接口
 * 
 * @author Administrator
 * 
 */
@Repository("xinYouDmDetailsMapper")
public interface XinYouDmDetailsMapper {
	int add(DmDetails dmDetails);

	int modify(DmDetails dmDetails);

	int remove(Integer id);

	List<DmDetails> findById(Integer id);

	/**
	 * 分页查询 + 条件查询
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param id
	 * @return
	 */

	List<DmDetails> findPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order, @Param("id") Integer id,
			@Param("parentId") Integer parentId,
			@Param("detailsNumber") Integer detailsNumber,
			@Param("productId") String productId,
			@Param("productName") String productName);

	long findPagerTotal(@Param("id") Integer id,
			@Param("parentId") Integer parentId,
			@Param("detailsNumber") Integer detailsNumber,
			@Param("productId") String productId,
			@Param("productName") String productName);

	DmDetails SelectInsert(@Param("productId") String productId);

}
