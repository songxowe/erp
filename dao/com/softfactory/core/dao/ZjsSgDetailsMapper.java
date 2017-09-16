package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.SgDetails;

@Repository("zjsSgDetailsMapper")
public interface ZjsSgDetailsMapper {

	@Insert("insert into S_GATHER_DETAILS(ID,PARENT_ID,PRODUCT_ID,PRODUCT_NAME,"
			+ "PRODUCT_DESCRIBE,AMOUNT,AMOUNT_UNIT,COST_PRICE,SUBTOTAL,GATHERED_AMOUNT,GATHER_TAG)values(#{id,jdbcType=NUMERIC},"
			+ "#{parentId,jdbcType=NUMERIC},#{productId,jdbcType=VARCHAR},#{productName,jdbcType=VARCHAR},"
			+ "#{productDescribe,jdbcType=VARCHAR},#{amount,jdbcType=NUMERIC},#{amountUnit,jdbcType=VARCHAR},"
			+ "#{costPrice,jdbcType=NUMERIC},#{subtotal,jdbcType=NUMERIC},#{gatheredAmount,jdbcType=NUMERIC},"
			+ "#{gatherTag,jdbcType=VARCHAR})")
	@SelectKey(statement = "select SEQ_SYS_CODES.nextval from dual", keyProperty = "id", before = true, resultType = int.class)
	int add(SgDetails sgDetails);

	SgDetails findById(String productId);

	/**
	 * 分页查询 + 条件查询
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param gatherId
	 * @return
	 */
	List<SgDetails> findPager(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize,
			@Param("sort") String sort, @Param("order") String order, @Param("parentId") String parentId);

	/**
	 * 查询分页记录总数 + 条件查询
	 * 
	 * @param gatherId
	 * @return
	 */
	long findPagerTotal(@Param("parentId") String parentId);
}
