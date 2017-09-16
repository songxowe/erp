package com.softfactory.core.dao;

import java.util.List;




import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softfactory.pojo.SPayDetails;

/**
 * 入库明细映射接口
 * @author Administrator
 *
 */
@Repository("fzjspaydetailsMapper")
public interface FZJSPayDetailsMapper {
	/**
	 * 新增入库明细 
	 */
	@Insert("insert into S_PAY_DETAILS(ID,PARENT_ID,PRODUCT_ID,PRODUCT_NAME,PRODUCT_DESCRIBE,AMOUNT,AMOUNT_UNIT,COST_PRICE,SUBTOTAL,PAID_AMOUNT,PAY_TAG)values(#{id,jdbcType=NUMERIC},#{parentId,jdbcType=NUMERIC},#{productId,jdbcType=VARCHAR},#{productName,jdbcType=VARCHAR},#{productDescribe,jdbcType=VARCHAR},#{amount,jdbcType=NUMERIC},#{amountUnit,jdbcType=VARCHAR},#{costPrice,jdbcType=NUMERIC},#{subtotal,jdbcType=NUMERIC},#{paidAmount,jdbcType=NUMERIC},#{payTag,jdbcType=VARCHAR})")
	@SelectKey(statement = "select SEQ_SYS_CODES.nextval from dual", keyProperty = "id", before = true, resultType = int.class)
	int add(SPayDetails spaydetails);

	

	/**
	 * 分页查询+条件查询入库明细
	 */
	List<SPayDetails> findPager(
			@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, 
			@Param("sort") String sort,
			@Param("order") String order, 
			@Param("productId") String parentId
			);
	/**
	   * 查询分页记录总数 + 条件查询
	   * @param payId
	   * @return
	   */
	  long findPagerTotal(@Param("productId") String productId);
	  
	  
	  /**
	   * 根据ID查询
	   * @param 
	   * @return
	   */
	  @Select("select * from S_PAY_DETAILS where PARENT_ID=#{id}")
	  @ResultMap("spaydetails-result")
	  List<SPayDetails> findById(Integer id);
	  
	  
	  
	  
}
