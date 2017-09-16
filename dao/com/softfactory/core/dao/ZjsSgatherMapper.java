package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Scell;
import com.softfactory.pojo.Sgather;

@Repository("zjsSgatherMapper")
public interface ZjsSgatherMapper {

	@Insert("insert into S_GATHER(ID,GATHER_ID,STORER,REASON,REASONEXACT,AMOUNT_SUM,COST_PRICE_SUM,GATHERED_AMOUNT_SUM,REMARK,REGISTER,REGISTER_TIME,CHECKER,CHECK_TIME,CHECK_TAG,ATTEMPER,ATTEMPER_TIME,STORE_TAG,MaId,DEMAND_AMOUNTA,REAL_AMOUNA,NOW_AMOUNTA,DEMAND_AMOUNT_ALLA,REAL_AMOUNT_ALLA,DEMAND_SAL_ALLA,REAL_SAL_ALLA)values(#{id,jdbcType=NUMERIC},#{gatherId,jdbcType=VARCHAR},#{storer,jdbcType=VARCHAR},#{reason,jdbcType=VARCHAR},#{reasonexact,jdbcType=VARCHAR},#{amountSum,jdbcType=NUMERIC},#{costPriceSum,jdbcType=NUMERIC},#{gatheredAmountSum,jdbcType=NUMERIC},#{remark,jdbcType=VARCHAR},#{register,jdbcType=VARCHAR},#{registerTime,jdbcType=DATE},#{checker,jdbcType=VARCHAR},#{checkTime,jdbcType=DATE},#{checkTag,jdbcType=VARCHAR},#{attemper,jdbcType=VARCHAR},#{attemperTime,jdbcType=DATE},#{storeTag,jdbcType=VARCHAR},#{maId,jdbcType=NUMERIC},#{demandAmounta,jdbcType=NUMERIC},#{realAmounta,jdbcType=NUMERIC},#{nowAmounta,jdbcType=NUMERIC},#{demandAmountAlla,jdbcType=NUMERIC},#{realAmountAlla,jdbcType=NUMERIC},#{demandSalAlla,jdbcType=NUMERIC},#{realSalAlla,jdbcType=NUMERIC})")
	@SelectKey(statement = "select SEQ_SYS_CODES.nextval from dual", keyProperty = "id", before = true, resultType = int.class)
	int add(Sgather sgather);

	@Update("update S_GATHER set GATHER_ID=#{gatherId,jdbcType=VARCHAR},STORER=#{storer,jdbcType=VARCHAR},REASON=#{reason,jdbcType=VARCHAR},REASONEXACT=#{reasonexact,jdbcType=VARCHAR},AMOUNT_SUM=#{amountSum,jdbcType=NUMERIC},COST_PRICE_SUM=#{costPriceSum,jdbcType=NUMERIC},GATHERED_AMOUNT_SUM=#{gatheredAmountSum,jdbcType=NUMERIC},REMARK=#{remark,jdbcType=VARCHAR},REGISTER=#{register,jdbcType=VARCHAR},REGISTER_TIME=#{registerTime,jdbcType=DATE},CHECKER=#{checkTag,jdbcType=VARCHAR},CHECK_TIME=#{checkTime,jdbcType=DATE},CHECK_TAG=#{checkTag,jdbcType=VARCHAR},ATTEMPER=#{attemper,jdbcType=VARCHAR},ATTEMPER_TIME=#{attemperTime,jdbcType=DATE},STORE_TAG=#{storeTag,jdbcType=VARCHAR},MaId=#{maId,jdbcType=NUMERIC},DEMAND_AMOUNTA=#{demandAmounta,jdbcType=NUMERIC},REAL_AMOUNA=#{realAmounta,jdbcType=NUMERIC},NOW_AMOUNTA=#{nowAmounta,jdbcType=NUMERIC},DEMAND_AMOUNT_ALLA=#{demandAmountAlla,jdbcType=NUMERIC},REAL_AMOUNT_ALLA=#{realAmountAlla,jdbcType=NUMERIC},DEMAND_SAL_ALLA=#{demandSalAlla,jdbcType=NUMERIC},REAL_SAL_ALLA=#{realSalAlla,jdbcType=NUMERIC} where ID=#{id,jdbcType=NUMERIC}")
	int modify(Sgather sgather);
	
	@Select("select Max(GATHER_ID) from S_GATHER")
	String findMaxNum();
	
	List<Sgather> findOnePager(
	      @Param("pageno") Integer pageno, 
	      @Param("pagesize") Integer pagesize, 
	      @Param("sort") String sort,
	      @Param("order") String order, 
	      @Param("gatherId") String gatherId);

	
	List<Sgather> findTwoPager(
		      @Param("pageno") Integer pageno, 
		      @Param("pagesize") Integer pagesize, 
		      @Param("sort") String sort,
		      @Param("order") String order, 
		      @Param("gatherId") String gatherId);
	
	List<Sgather> findThreePager(
		      @Param("pageno") Integer pageno, 
		      @Param("pagesize") Integer pagesize, 
		      @Param("sort") String sort,
		      @Param("order") String order, 
		      @Param("gatherId") String gatherId);
	  /**
	   * 查询分页记录总数 + 条件查询
	   * @param gatherId
	   * @return
	   */
	  long findOnePagerTotal(@Param("gatherId") String gatherId);
	  
	  long findTwoPagerTotal(@Param("gatherId") String gatherId);
	  
	  long findThreePagerTotal(@Param("gatherId") String gatherId);
	  
	  @Update("update S_GATHER set STORE_TAG='K002-1', CHECK_TAG='S001-0', REGISTER=#{register,jdbcType=VARCHAR}, NOW_AMOUNTA=#{nowAmounta,jdbcType=NUMERIC} where GATHER_ID=#{gatherId,jdbcType=VARCHAR}")
	  void modifyStoreTag(@Param(value="gatherId")String  gatherId, @Param(value="register")String register,@Param(value="nowAmounta")Integer nowAmounta);
	 
	  Sgather findById(String gatherId);
	  
	  @Update("update S_GATHER set CHECK_TAG='S001-1' where GATHER_ID=#{gatherId}")
	  void modifyCheckTag(String gatherId);
	  
	  @Update("update S_GATHER set CHECK_TAG='S001-2' where GATHER_ID=#{gatherId}")
	  void modifyCheckTagNo(String gatherId);
	  
	  @Select("select ID id from S_GATHER where GATHER_ID=#{gatherId}")
		Integer findByGatherId(String gatherId);
	  
	Scell findscellById(String productId);

}
