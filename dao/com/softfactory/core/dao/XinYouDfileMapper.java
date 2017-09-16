package com.softfactory.core.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Dfile;

@Repository("xinYouDfileMapper")
public interface XinYouDfileMapper {
	int add(Dfile dfile);

	int modify(Dfile dfile);

	int remove(Integer id);
	
	
	Dfile findById(Integer id);

	List<Dfile> findByCheckTag(String checkTag);

	List<Dfile> findPager(
			@Param("pageno") Integer pageno,@Param("pagesize") Integer pagesize,
			@Param("sort") String sort,@Param("order") String order, 
			@Param("firstKindName") String firstKindName,@Param("secondKindName")String secondKindName, 
			@Param("thirdKindName") String thirdKindName,@Param("type") String type,
			@Param("beginTime") Date beginTime,@Param("endTime") Date endTime);

	long findPagerTotal(
			@Param("firstKindName") String firstKindName,@Param("secondKindName")String secondKindName, 
			@Param("thirdKindName") String thirdKindName,@Param("type") String type,
			@Param("beginTime") Date beginTime,@Param("endTime") Date endTime);
	/**
	 * 商品的分页查询
	 * @return
	 */
	List<Dfile> findCommodityPager(
			@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize,
			@Param("sort") String sort,
			@Param("order") String order,
			@Param("productId") String productId,
			@Param("productName") String productName,
			@Param("factoryName") String factoryName,
			@Param("firstKindName") String firstKindName,
			@Param("secondKindName") String secondKindName,
			@Param("thirdKindName") String thirdKindName,
			@Param("productDescribe") String productDescribe,
			@Param("responsiblePerson") String responsiblePerson,
			@Param("registerTime") Date registerTime
			);
	long findCommodityTotal(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize,
			@Param("sort") String sort,
			@Param("order") String order,
			@Param("productId") String productId,
			@Param("productName") String productName,
			@Param("factoryName") String factoryName,
			@Param("firstKindName") String firstKindName,
			@Param("secondKindName") String secondKindName,
			@Param("thirdKindName") String thirdKindName,
			@Param("productDescribe") String productDescribe,
			@Param("responsiblePerson") String responsiblePerson,
			@Param("registerTime") Date registerTime);
	/**
	 * 物料的分页查询
	 */
	List<Dfile> findMaterialPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize,
			@Param("sort") String sort,
			@Param("order") String order,
			@Param("productId") String productId,
			@Param("productName") String productName,
			@Param("factoryName") String factoryName,
			@Param("firstKindName") String firstKindName,
			@Param("secondKindName") String secondKindName,
			@Param("thirdKindName") String thirdKindName,
			@Param("productDescribe") String productDescribe,
			@Param("responsiblePerson") String responsiblePerson);
			
	long findMaterialTotal(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize,
			@Param("sort") String sort,
			@Param("order") String order,
			@Param("productId") String productId,
			@Param("productName") String productName,
			@Param("factoryName") String factoryName,
			@Param("firstKindName") String firstKindName,
			@Param("secondKindName") String secondKindName,
			@Param("thirdKindName") String thirdKindName,
			@Param("productDescribe") String productDescribe,
			@Param("responsiblePerson") String responsiblePerson
			);
}
