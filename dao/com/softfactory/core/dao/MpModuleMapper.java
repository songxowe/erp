package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.MpModule;

@Repository("mpModuleMapper")
public interface MpModuleMapper {

	@Insert("insert into M_PROCEDURE_MODULE(ID,PARENT_ID,DETAILS_NUMBER,PRODUCT_ID,PRODUCT_NAME,COST_PRICE,AMOUNT,SUBTOTAL) values(#{id,jdbcType=NUMERIC},#{parentId,jdbcType=NUMERIC},#{detailsNumber,jdbcType=NUMERIC},#{productId,jdbcType=VARCHAR},#{productName,jdbcType=VARCHAR},#{costPrice,jdbcType=NUMERIC},#{amount,jdbcType=NUMERIC},#{subtotal,jdbcType=NUMERIC})")
	@SelectKey(statement = "select SEQ_M_PROCEDURE_MODULE.nextval from dual", keyProperty = "id", resultType = int.class, before = true)
	int add(MpModule pm);

	List<MpModule> findPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order, @Param("id") Integer id,
			@Param("productName") String productName);

	long findPagerTotal(@Param("id") Integer id,
			@Param("productName") String productName);

	/**
	 * @author GuangxiangLong
	 * @param prentId
	 * @return
	 */
	List<MpModule> findByPrentId(Integer prentId);
}
