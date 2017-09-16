package com.softfactory.core.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Dfile;
import com.softfactory.pojo.Dkind;

@Repository("xyfDfileMapper")
public interface XyfDfileMapper {
	int add(Dfile dfile);

	/**
	 * 修改产品信息
	 * @param dfile
	 * @return
	 */
	int modify(Dfile dfile);

	int remove(Integer id);

	Dfile findById(Integer id);

	/**
	 * 
	 * 分页1 查询产品档案（条件查询）
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param firstKindName
	 * @param secondKindName
	 * @param thirdKindName
	 * @param type
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	List<Dfile> findPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order,
			@Param("firstKindName") String firstKindName,
			@Param("secondKindName") String secondKindName,
			@Param("thirdKindName") String thirdKindName,
			@Param("type") String type, @Param("beginTime") Date beginTime,
			@Param("endTime") Date endTime);

	long findPagerTotal(@Param("firstKindName") String firstKindName,
			@Param("secondKindName") String secondKindName,
			@Param("thirdKindName") String thirdKindName,
			@Param("type") String type, @Param("beginTime") Date beginTime,
			@Param("endTime") Date endTime);

	/**
	 * 分页2 查询未审核的产品档案（条件查询）
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param firstKindName
	 * @param secondKindName
	 * @param thirdKindName
	 * @param type
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	List<Dfile> findUncheckedPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order,
			@Param("firstKindName") String firstKindName,
			@Param("secondKindName") String secondKindName,
			@Param("thirdKindName") String thirdKindName,
			@Param("type") String type, @Param("beginTime") Date beginTime,
			@Param("endTime") Date endTime);

	long findUncheckedPagerTotal(@Param("firstKindName") String firstKindName,
			@Param("secondKindName") String secondKindName,
			@Param("thirdKindName") String thirdKindName,
			@Param("type") String type, @Param("beginTime") Date beginTime,
			@Param("endTime") Date endTime);

	/**
	 * 查询最序号最大即最新插入的产品
	 * 
	 * @return
	 */
	@Select("select PRODUCT_ID from D_FILE where ID=(select max(ID) from D_FILE)")
	String findMaxProductId();

	/**
	 * 根据审核标志查询产品档案
	 * 
	 * @param checkTag
	 * @return
	 */
	List<Dfile> findByCheckTag(String checkTag);

	/**
	 * 根据审核标志查询产品数量
	 * 
	 * @param checkTag
	 * @return
	 */
	@Select("select count(ID) from D_FILE where CHECK_TAG=#{checkTag}")
	int findNumByCheckTag(String checkTag);

	/**
	 * 三级联动
	 */
	List<Dkind> findAll(@Param("pid")Integer pid);
	
	/**
	 * 根据序号ID查询类别
	 * 
	 * @param id
	 * @return
	 */
	Dkind findDkindById(Integer id);
	
	/**
	 * 根据ID查询产品分类设置
	 */
	@Select("select KIND_ID from D_CONFIG_FILE_KIND where ID=#{id}")
	String findKindIdById(Integer id);
	
	List<Dkind> findfirst();

	/**
	 * 查询产品名称是否存在
	 * @param productName
	 * @return
	 */
	@Select("select count(ID) from D_FILE where PRODUCT_NAME=#{productName}")
	int productNameIsExist(String productName);

	Dkind findByName(@Param("name")String name);

	/**
	 * 
	 * 分页3 查询可恢复的产品档案
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @return
	 */
	List<Dfile> findRecoveryPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order);

	long findRecoveryPagerTotal();
}
