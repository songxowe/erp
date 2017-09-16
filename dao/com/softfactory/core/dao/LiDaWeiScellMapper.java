package com.softfactory.core.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Dkind;
import com.softfactory.pojo.Scell;

@Repository("scellMapper")
public interface LiDaWeiScellMapper {

	// ==========================分页1====================================
	long findOnePagerTotal(@Param("firstKingName") String firstKingName,
			@Param("secondKingName") String secondKingName,
			@Param("thirdKingName") String thirdKingName,
			@Param("beginDate") Date beginDate, @Param("endDate") Date endDate,
			@Param("str") String str);

	List<Scell> findOnePager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order,
			@Param("firstKingName") String firstKingName,
			@Param("secondKingName") String secondKingName,
			@Param("thirdKingName") String thirdKingName,
			@Param("beginDate") Date beginDate, @Param("endDate") Date endDate,
			@Param("str") String str);

	// ==========================分页1====================================
	// ==========================分页2====================================
	long findTwoPagerTotal();

	List<Scell> findTwoPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order);

	// ==========================分页2====================================
	// ==========================分页3====================================
	long findThreePagerTotal(@Param("firstKingName") String firstKingName,
			@Param("secondKingName") String secondKingName,
			@Param("thirdKingName") String thirdKingName,
			@Param("checkTag") String checkTag,
			@Param("firstdate") Date firstdate,
			@Param("lastdate") Date lastdate, @Param("str") String str);

	List<Scell> findThreePager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order,
			@Param("firstKingName") String firstKingName,
			@Param("secondKingName") String secondKingName,
			@Param("thirdKingName") String thirdKingName,
			@Param("checkTag") String checkTag,
			@Param("firstdate") Date firstdate,
			@Param("lastdate") Date lastdate, @Param("str") String str);

	// ==========================分页3====================================
	// ==========================分页4====================================
	long findFourPagerTotal(@Param("firstKingName") String firstKingName,
			@Param("secondKingName") String secondKingName,
			@Param("thirdKingName") String thirdKingName,
			@Param("firstdate") Date firstdate,
			@Param("lastdate") Date lastdate, @Param("str") String str);

	List<Scell> findFourPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order,
			@Param("firstKingName") String firstKingName,
			@Param("secondKingName") String secondKingName,
			@Param("thirdKingName") String thirdKingName,
			@Param("firstdate") Date firstdate,
			@Param("lastdate") Date lastdate, @Param("str") String str);

	// ==========================分页4====================================
	// ==========================分页5====================================
	long findFivePagerTotal(@Param("firstKingName") String firstKingName,
			@Param("secondKingName") String secondKingName,
			@Param("thirdKingName") String thirdKingName,
			@Param("str") String str);

	List<Scell> findFivePager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order,
			@Param("firstKingName") String firstKingName,
			@Param("secondKingName") String secondKingName,
			@Param("thirdKingName") String thirdKingName,
			@Param("str") String str);

	// ==========================分页5====================================

	/**
	 * 数据增加
	 */
	@Insert("insert into S_CELL(ID,STORE_ID,STORE_NAME,PRODUCT_ID,PRODUCT_NAME,FIRST_KIND_ID,FIRST_KIND_NAME,SECOND_KIND_ID,SECOND_KIND_NAME,THIRD_KIND_ID,THIRD_KIND_NAME,MIN_AMOUNT,MAX_AMOUNT,MAX_CAPACITY_AMOUNT,LOC_ID,LOC_NAME,SPL_NAME,STORAGE_UNIT,AMOUNT,CONFIG,DESIGNER,REGISTER,REGISTER_TIME,CHECKER,CHECK_TIME,CHECK_TAG) values(#{id,jdbcType=NUMERIC},#{storeId,jdbcType=VARCHAR},#{storeName,jdbcType=VARCHAR},#{productId,jdbcType=VARCHAR},#{productName,jdbcType=VARCHAR},#{firstKingId,jdbcType=VARCHAR},#{firstKingName,jdbcType=VARCHAR},#{secondKingId,jdbcType=VARCHAR},#{secondKingName,jdbcType=VARCHAR},#{thirdKingId,jdbcType=VARCHAR},#{thirdKingName,jdbcType=VARCHAR},#{minAmount,jdbcType=NUMERIC},#{maxAmount,jdbcType=NUMERIC},#{maxCapacityAmount,jdbcType=NUMERIC},#{locId,jdbcType=VARCHAR},#{locName,jdbcType=VARCHAR},#{splName,jdbcType=VARCHAR},#{storageUnit,jdbcType=VARCHAR},#{amount,jdbcType=NUMERIC},#{config,jdbcType=VARCHAR},#{designer,jdbcType=VARCHAR},#{register,jdbcType=VARCHAR},#{registerTime,jdbcType=DATE},#{checker,jdbcType=VARCHAR},#{checkTime,jdbcType=DATE},#{checkTag,jdbcType=VARCHAR})")
	@SelectKey(statement = "select SEQ_SYS_CODES.nextval from dual", before = true, keyProperty = "id", resultType = int.class)
	int addScell(Scell scell);

	/**
	 * 数据删除
	 * 
	 * @param id
	 * @return
	 */
	@Delete("delete table from S_CELL where ID=#{id}")
	int remove(Integer id);

	/**
	 * 审核修改配置单数据
	 * 
	 * @param scell
	 * @return
	 */
	@Update("update S_CELL set CHECKER=#{checker,jdbcType=VARCHAR},CHECK_TIME=#{checkTime,jdbcType=DATE},CHECK_TAG=#{checkTag,jdbcType=VARCHAR} where STORE_ID=#{storeId,jdbcType=VARCHAR}")
	int modifyScell(Scell scell);

	/**
	 * 变更配置单数据
	 */
	@Update("update S_CELL set MIN_AMOUNT=#{minAmount,jdbcType=NUMERIC},MAX_AMOUNT=#{maxAmount,jdbcType=NUMERIC},REGISTER=#{register,jdbcType=VARCHAR},STORE_NAME=#{storeName,jdbcType=VARCHAR},SPL_NAME=#{splName,jdbcType=VARCHAR},MAX_CAPACITY_AMOUNT=#{maxCapacityAmount,jdbcType=NUMERIC},STORAGE_UNIT=#{storageUnit,jdbcType=VARCHAR},CONFIG=#{config,jdbcType=VARCHAR},CHECK_TAG=#{checkTag,jdbcType=VARCHAR} where STORE_ID=#{storeId,jdbcType=VARCHAR}")
	int modifyScellById(Scell scell);

	/**
	 * 根据Id查询档案表数据
	 * 
	 * @param id
	 * @return
	 */
	Scell findById(String id);

	/**
	 * 根据Id查询库存配置单表
	 */
	@Select("select * from S_CELL where STORE_ID=#{id}")
	@ResultMap("scell-result")
	Scell findScellById(String id);

	/**
	 * 查出配置单编号的最大值
	 * 
	 * @return
	 */
	@Select("select Max(STORE_ID) from S_CELL")
	String findMaxNum();

	/**
	 * 修改档案表
	 */
	@Update("update D_FILE set DESIGN_CELL_TAG=#{scellTag} where PRODUCT_ID=#{id}")
	int modifyDfile(@Param("scellTag") String scellTag, @Param("id") String id);

	/**
	 * 三级联动
	 */
	List<Dkind> findAll(Dkind dkind);

	/**
	 * 根据ID查询产品分类设置
	 */
	@Select("select KIND_ID from D_CONFIG_FILE_KIND where ID=#{id}")
	String findKindById(Integer id);
}
