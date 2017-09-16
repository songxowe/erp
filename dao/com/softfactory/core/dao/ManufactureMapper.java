package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Manufacture;

@Repository("manufactureMapper")
public interface ManufactureMapper {

	@Update("update M_MANUFACTURE set CHECK_TAG=#{checkTag},CHECKER=#{checker},CHECK_TIME=#{checkTime},REMARK=#{remark} where MANUFACTURE_ID = #{manufactureId}")
	int modify(Manufacture mf);

	@Insert("insert into M_MANUFACTURE(ID,MANUFACTURE_ID,PRODUCT_ID,PRODUCT_NAME,AMOUNT,"
			+ "APPLY_ID_GROUP,PRODUCT_DESCRIBE,MODULE_COST_PRICE_SUM,"
			+ "LABOUR_COST_PRICE_SUM,DESIGNER,REGISTER,REGISTER_TIME,"
			+ "REMARK,CHECK_TAG,MANUFACTURE_PROCEDURE_TAG) "
			+ "values(#{id,jdbcType=NUMERIC},#{manufactureId,jdbcType=VARCHAR},#{productId,jdbcType=VARCHAR},#{productName,jdbcType=VARCHAR},"
			+ "#{amount,jdbcType=NUMERIC},#{applyIdGroup,jdbcType=VARCHAR},#{productDescribe,jdbcType=VARCHAR},#{moduleCostPriceSum,jdbcType=NUMERIC},"
			+ "#{labourCostPriceSum,jdbcType=NUMERIC},#{designer,jdbcType=VARCHAR},"
			+ "#{register,jdbcType=VARCHAR},#{registerTime,jdbcType=DATE},#{remark,jdbcType=VARCHAR},#{checkTag,jdbcType=VARCHAR},"
			+ "#{manufactureProcedureTag,jdbcType=VARCHAR})")
	@SelectKey(statement = "select SEQ_M_MANUFACTURE.nextval from dual", keyProperty = "id", resultType = int.class, before = true)
	int add(Manufacture mf);

	List<Manufacture> findPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order, @Param("id") Integer id,
			@Param("productName") String productName);

	long findPagerTotal(@Param("id") Integer id,
			@Param("productName") String productName);

	/**
	 * 通过主键加载记录
	 * 
	 * @param id
	 * @return
	 */
	Manufacture findById(Integer id);
	
	/**
	 * 通过主键加载记录
	 * 
	 * @param id
	 * @return
	 */
	Manufacture findByManufactureId(String manufactureId);
	/**
	 * 
	 * @return 查找通过审核的生产计划
	 * 
	 */
	List<Manufacture> findPassedMFG(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order,
			@Param("manufacture") Manufacture manufacture);

	/**
	 * 通过审核的生产计划总记录数
	 * 
	 * @author GuangxiangLong
	 * @param manufacture
	 * @return
	 */
	long findPassedMFGTotal(@Param("manufacture") Manufacture manufacture);

	@Select("select Max(MANUFACTURE_ID) from M_MANUFACTURE")
	String findMaxNum();

}
