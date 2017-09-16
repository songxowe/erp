package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.StorageScheduleOut;

@Repository("storageScheduleOutMapper")
public interface StorageScheduleOutMapper {

	/**
	 * 查询：能在制定调度单显示的记录
	 * @return
	 */

	public List<StorageScheduleOut> findPager(@Param("pageno") Integer pageno, 
		      @Param("pagesize") Integer pagesize, 
		      @Param("sort") String sort,
		      @Param("order") String order);
	/**
	 * 根据id查询入库调度单明细
	 * @return
	 */
	
	public List<StorageScheduleOut> findById(@Param(value = "id") Integer id);
	/**
	 * 根据入库单编号id查询入库表的信息
	 * @return
	 */
	public StorageScheduleOut findDetail(@Param(value="id") Integer id);
	/**
	 * 查询总页数
	 * @return
	 */
	long findPagerTotal();
	/**
	 * 根据产品编号查入库表和详单表的信息第三页面显示
	 * @param productId
	 * @return
	 */
	public StorageScheduleOut findBypId(@Param(value="productId") String productId);
	/**
	 *  最后修改字段
	 * @param payId
	 * @return
	 */
	public int modify(@Param("pId")String pId);
}
