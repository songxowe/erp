package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.SPay;

/**
 * 入库映射接口
 * 
 * @author Administrator
 * 
 */
@Repository("hzjspayMapper")
public interface HZJSPayMapper {
	/**
	 * 新增入库
	 */
	@Insert("insert into S_PAY(ID,PAY_ID,STORER,REASON,REASONEXACT,AMOUNT_SUM,COST_PRICE_SUM,PAID_AMOUNT_SUM,REMARK,REGISTER,REGISTER_TIME,CHECKER,CHECK_TIME,CHECK_TAG,ATTEMPER,ATTEMPER_TIME,PRODUCT_ID,STORE_TAG,REAL_AMOUNTB,NOW_AMOUNTB,DEMAND_AMOUNT_ALLB,REAL_AMOUNT_ALLB,DEMAND_SAL_ALLB,REAL_SAL_ALLB)values(#{id,jdbcType=NUMERIC},#{payId,jdbcType=VARCHAR},#{storer,jdbcType=VARCHAR},#{reason,jdbcType=VARCHAR},#{reasonexact,jdbcType=VARCHAR},#{amountSum,jdbcType=NUMERIC},#{costPriceSum,jdbcType=NUMERIC},#{paidAmountSum,jdbcType=NUMERIC},#{remark,jdbcType=VARCHAR},#{register,jdbcType=VARCHAR},#{registerTime,jdbcType=DATE},#{checker,jdbcType=VARCHAR},#{checkTime,jdbcType=DATE},#{checkTag,jdbcType=VARCHAR},#{attmper,jdbcType=VARCHAR},#{attemperTime,jdbcType=DATE},#{productId,jdbcType=NUMERIC},#{storeTag,jdbcType=VARCHAR},#{demandAmountb,jdbcType=NUMERIC},#{realAmoutb,jdbcType=NUMERIC},#{nowAmountb,jdbcType=NUMERIC},#{demandAmountAllb,jdbcType=NUMERIC},#{realAmountAllb,jdbcType=NUMERIC},#{demandSalAllb,jdbcType=NUMERIC},#{realSalAllb,jdbcType=NUMERIC})")
	@SelectKey(statement = "select SEQ_SYS_CODES.nextval from dual", keyProperty = "id", before = true, resultType = int.class)
	int add(SPay spay);
/**
 * 入库登记
 * @param spay
 * @return
 */
	@Insert("insert into S_PAY(ID,PAY_ID,STORER,REASON,AMOUNT_SUM,COST_PRICE_SUM,REMARK,REGISTER,REGISTER_TIME,CHECK_TAG,STORE_TAG)values(#{id,jdbcType=NUMERIC},#{payId,jdbcType=VARCHAR},#{storer,jdbcType=VARCHAR},#{reason,jdbcType=VARCHAR},#{amountSum,jdbcType=NUMERIC},#{costPriceSum,jdbcType=NUMERIC},#{remark,jdbcType=VARCHAR},#{register,jdbcType=VARCHAR},#{registerTime,jdbcType=DATE},#{checkTag,jdbcType=VARCHAR},#{storeTag,jdbcType=VARCHAR})")
	@SelectKey(statement = "select SEQ_SYS_CODES.nextval from dual", keyProperty = "id", before = true, resultType = int.class)
	int add2(SPay spay);

	/**
	 * 审核
	 */
	@Update("update S_PAY set CHECKER=#{checker},REMARK=#{remark},CHECK_TIME=#{checkTime},CHECK_TAG=#{checkTag} where PAY_ID=#{payId}")
	int modify(SPay spay);

	/**
	 * spay审核分页
	 */
	List<SPay> findPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order, @Param("payId") String payId);

	/**
	 * 审核查询分页记录总数 + 条件查询
	 * 
	 * @param payId
	 * @return
	 */
	long findPagerTotal(@Param("payId") String payId);

	/**
	 * 根据ID查询
	 * 
	 * @param Id
	 * @return
	 */
	@Select("select ID id,PAY_ID payId,STORER storer,REASON reason,REASONEXACT reasonexact,AMOUNT_SUM amountSum,COST_PRICE_SUM costPriceSum,PAID_AMOUNT_SUM paidAmountSum,REMARK remark,REGISTER register,REGISTER_TIME registerTime,CHECKER checker,CHECK_TIME checkTime,CHECK_TAG checkTag,ATTEMPER attmper,ATTEMPER_TIME attemperTime,PRODUCT_ID productId,STORE_TAG storeTag,DEMAND_AMOUNTB demandAmountb,REAL_AMOUNTB realAmoutb,NOW_AMOUNTB nowAmountb,DEMAND_AMOUNT_ALLB demandAmountAllb,REAL_AMOUNT_ALLB realAmountAllb,DEMAND_SAL_ALLB demandSalAllb,REAL_SAL_ALLB realSalAllb from S_PAY where ID=#{id}")
	SPay findById(Integer id);
	/**
	 * 根据ID查询
	 * 
	 * @param payId
	 * @return
	 */
	@Select("select ID id,PAY_ID payId,STORER storer,REASON reason,REASONEXACT reasonexact,AMOUNT_SUM amountSum,COST_PRICE_SUM costPriceSum,PAID_AMOUNT_SUM paidAmountSum,REMARK remark,REGISTER register,REGISTER_TIME registerTime,CHECKER checker,CHECK_TIME checkTime,CHECK_TAG checkTag,ATTEMPER attmper,ATTEMPER_TIME attemperTime,PRODUCT_ID productId,STORE_TAG storeTag,DEMAND_AMOUNTB demandAmountb,REAL_AMOUNTB realAmoutb,NOW_AMOUNTB nowAmountb,DEMAND_AMOUNT_ALLB demandAmountAllb,REAL_AMOUNT_ALLB realAmountAllb,DEMAND_SAL_ALLB demandSalAllb,REAL_SAL_ALLB realSalAllb from S_PAY where PAY_ID=#{payId}")
	SPay findByPayId(String payId);

	/**
	 * 入库查询分页
	 */
	List<SPay> findPager2(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order, @Param("payId") String payId);

	/**
	 * 入库查询分页记录总数 + 条件查询
	 * 
	 * @param payId
	 * @return
	 */
	long findPagerTotal2(@Param("payId") String payId);

	/**
	 * 查出编号的最大值
	 * 
	 * @return、
	 */
	@Select("select Max(PAY_ID) from S_PAY")
	String findMaxNum();
}
