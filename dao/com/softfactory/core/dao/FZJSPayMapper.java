package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.SPay;
import com.softfactory.pojo.Scell;

/**
 * 入库映射接口
 * 
 * @author Administrator
 * 
 */
@Repository("fzjspayMapper")
public interface FZJSPayMapper {
	/**
	 * 新增入库 
	 */
	@Insert("insert into S_PAY(ID,PAY_ID,STORER,REASON,REASONEXACT,AMOUNT_SUM,COST_PRICE_SUM,PAID_AMOUNT_SUM,REMARK,REGISTER,REGISTER_TIME,CHECKER,CHECK_TIME,CHECK_TAG,ATTEMPER,ATTEMPER_TIME,PRODUCT_ID,STORE_TAG,DEMAND_AMOUNTB,REAL_AMOUNTB,NOW_AMOUNTB,DEMAND_AMOUNT_ALLB,REAL_AMOUNT_ALLB,DEMAND_SAL_ALLB,REAL_SAL_ALLB)values(#{id,jdbcType=NUMERIC},#{payId,jdbcType=VARCHAR},#{storer,jdbcType=VARCHAR},#{reason,jdbcType=VARCHAR},#{reasonexact,jdbcType=VARCHAR},#{amountSum,jdbcType=NUMERIC},#{costPriceSum,jdbcType=NUMERIC},#{paidAmountSum,jdbcType=NUMERIC},#{remark,jdbcType=VARCHAR},#{register,jdbcType=VARCHAR},#{registerTime,jdbcType=DATE},#{checker,jdbcType=VARCHAR},#{checkTime,jdbcType=DATE},#{checkTag,jdbcType=VARCHAR},#{attmper,jdbcType=VARCHAR},#{attemperTime,jdbcType=DATE},#{productId,jdbcType=NUMERIC},#{storeTag,jdbcType=VARCHAR},#{demandAmountb,jdbcType=NUMERIC},#{realAmoutb,jdbcType=NUMERIC},#{nowAmountb,jdbcType=NUMERIC},#{demandAmountAllb,jdbcType=NUMERIC},#{realAmountAllb,jdbcType=NUMERIC},#{demandSalAllb,jdbcType=NUMERIC},#{realSalAllb,jdbcType=NUMERIC})")
	@SelectKey(statement = "select SEQ_SYS_CODES.nextval from dual", keyProperty = "id", before = true, resultType = int.class)
	int add(SPay spay);

	/**
	 * 修改入库
	 */
	@Update("update S_PAY set PAY_ID=#{payId,jdbcType=VARCHAR},STORER=#{storer,jdbcType=VARCHAR},REASON=#{reason,jdbcType=VARCHAR},REASONEXACT=#{reasonexact,jdbcType=VARCHAR},AMOUNT_SUM=#{amountSum,jdbcType=NUMERIC},COST_PRICE_SUM=#{costPriceSum,jdbcType=NUMERIC},PAID_AMOUNT_SUM=#{paidAmountSum,jdbcType=NUMERIC},REMARK=#{remark,jdbcType=VARCHAR},REGISTER=#{register,jdbcType=VARCHAR},REGISTER_TIME=#{registerTime,jdbcType=DATE},CHECKER=#{checkTag,jdbcType=VARCHAR},CHECK_TIME=#{checkTime,jdbcType=DATE},CHECK_TAG=#{checkTag,jdbcType=VARCHAR},ATTEMPER=#{attmper,jdbcType=VARCHAR},ATTEMPER_TIME=#{attemperTime,jdbcType=DATE},PRODUCT_ID=#{productId,jdbcType=NUMERIC},STORE_TAG=#{storeTag,jdbcType=VARCHAR},DEMAND_AMOUNTB=#{demandAmountb,jdbcType=NUMERIC},REAL_AMOUNTB=#{realAmoutb,jdbcType=NUMERIC},NOW_AMOUNTB=#{nowAmountb,jdbcType=NUMERIC},DEMAND_AMOUNT_ALLB=#{demandAmountAllb,jdbcType=NUMERIC},REAL_AMOUNT_ALLB=#{realAmountAllb,jdbcType=NUMERIC},DEMAND_SAL_ALLB=#{demandSalAllb,jdbcType=NUMERIC},REAL_SAL_ALLB=#{realSalAllb,jdbcType=NUMERIC} where ID=#{id,jdbcType=NUMERIC}")
	int modify(SPay spay);

	@Select("select Max(GATHER_ID) from S_GATHER")
	String findMaxNum();
	/**
	 * 分页查询+条件查询入库
	 */
	List<SPay> findOnePager(
			@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, 
			@Param("sort") String sort,
			@Param("order") String order, 
			@Param("payId") String payId
			);
	
	List<SPay> findTwoPager(
			@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, 
			@Param("sort") String sort,
			@Param("order") String order, 
			@Param("payId") String payId
			);
	
	List<SPay> findThreePager(
			@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, 
			@Param("sort") String sort,
			@Param("order") String order, 
			@Param("payId") String payId
			);
	/**
	   * 查询分页记录总数 + 条件查询
	   * @param payId
	   * @return
	   */
	  long findOnePagerTotal(@Param("payId") String payId);
	  long findTwoPagerTotal(@Param("payId") String payId);
	  long findThreePagerTotal(@Param("payId") String payId);
	  
	  /**
	   * 根据ID查询
	   * @param payId
	   * @return
	   */
	  @Select("select * from S_PAY where ID=#{id}")
	  @ResultMap("spay-result")
	  SPay findById(Integer id);
	  
	  
	  @Update("update S_PAY set STORE_TAG='K002-1', CHECK_TAG='S001-0', REGISTER=#{register,jdbcType=VARCHAR}, NOW_AMOUNTB=#{nowAmountb,jdbcType=NUMERIC} where PAY_ID=#{payId,jdbcType=VARCHAR}")
	  void modifyStoreTag(@Param(value="payId")String  payId, @Param(value="register")String register,@Param(value="nowAmountb")Integer nowAmountb);
	  
	  @Update("update S_PAY set CHECK_TAG='S001-1' where PAY_ID=#{payId,jdbcType=VARCHAR}")
	  void modifyCheckTag(String payId);
	  
	  @Update("update S_PAY set CHECK_TAG='S001-2' where PAY_ID=#{payId,jdbcType=VARCHAR}")
	  void modifyCheckTagNo(String payId);
	  
	  Scell findscellById(String productId);
	  

}
