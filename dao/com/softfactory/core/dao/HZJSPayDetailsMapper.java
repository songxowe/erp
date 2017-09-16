package com.softfactory.core.dao;

import java.util.List;




import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.SPayDetails;

/**
 * 入库明细映射接口
 * @author Administrator
 *
 */
@Repository("hzjspaydetailsMapper")
public interface HZJSPayDetailsMapper {
	/**
	 * 新增入库明细 
	 */
	@Insert("insert into S_PAY_DETAILS (ID,PARENT_ID,PRODUCT_ID,PRODUCT_NAME,AMOUNT,AMOUNT_UNIT,COST_PRICE,SUBTOTAL,PAY_TAG)"
			+"values(#{id},#{parentId},#{productId},#{productName},#{amount},#{amountUnit},#{costPrice},#{subtotal},#{payTag,jdbcType=VARCHAR})"
			)
	@SelectKey(statement = "select SEQ_SYS_CODES.nextval from dual", keyProperty = "id", before = true, resultType = int.class)
	int add(SPayDetails spaydetails);

	

	/**
	 * 产品分页查询+条件查询入库明细
	 */
	List<SPayDetails> findPager(
			@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, 
			@Param("sort") String sort,
			@Param("order") String order, 
			@Param("productName") String productName
			);
	/**
	   * 查询产品分页记录总数 + 条件查询
	   * @param payId
	   * @return
	   */
	  long findPagerTotal(@Param("productName") String productName);
	  
	  
	  /**
	   * 审核时根据parentId查询得到入库明细集合
	   * @param 
	   * @return
	   */
	  @Select("select ID id,PARENT_ID parentId,PRODUCT_ID productId,PRODUCT_NAME productName,PRODUCT_DESCRIBE productDescribe,AMOUNT amount,AMOUNT_UNIT amountUnit,COST_PRICE costPrice,SUBTOTAL subtotal,PAID_AMOUNT paidAmount,PAY_TAG payTag from S_PAY_DETAILS where PARENT_ID=#{parentId}")
	  List<SPayDetails> findById(Integer parentId);
	  
	  
	  
	  
}
