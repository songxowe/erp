package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Scell;
import com.softfactory.pojo.StorageSchedule;

@Repository("storageScheduleMapper")
public interface StorageScheduleMapper {

	/**
	 * 查询：能在制定调度单显示的记录
	 * @return
	 */

	public List<StorageSchedule> findPager(@Param("pageno") Integer pageno, 
		      @Param("pagesize") Integer pagesize, 
		      @Param("sort") String sort,
		      @Param("order") String order);
	/**
	 * 根据id查询入库调度单明细
	 * @return
	 */
	
	public List<StorageSchedule> findById(@Param(value = "id") Integer id);
	
	/**
	 * 根据入库单编号id查询入库表的信息
	 * @return
	 */
	public StorageSchedule findDetail(@Param(value="id") Integer id);
	long findPagerTotal();
	/**
	 * 根据产品编号查入库表和详单表的信息第三页面显示
	 * @param productId
	 * @return
	 */
	public StorageSchedule findBypId(@Param(value="productId") String productId);
	/**
	 *  最后修改字段
	 * @param payId
	 * @return
	 */
	public int modify(@Param("pId")String pId);
	
	@Update("update S_PAY set STORE_TAG='K002-1' where ID=#{id,jdbcType=NUMERIC}")
	Integer modifys(Integer id);
	
	Scell findScell(String productId);
	
	@Update("upsate S_CELL set AMOUNT=#{amount} where PRODUCT_ID=#{productId}")
	 void modifyScell(Scell scell);
}
