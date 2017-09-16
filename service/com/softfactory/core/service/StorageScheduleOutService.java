package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.softfactory.core.dao.StorageScheduleOutMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.StorageScheduleOut;


@Service("storageScheduleOutService")
public class StorageScheduleOutService {

	@Resource(name="storageScheduleOutMapper")
	private StorageScheduleOutMapper storageScheduleOutMapper;
	/**
	 * 读取满足条件的记录
	 * @return
	 */
	
	 public Pager<StorageScheduleOut> findPager(Integer pageno, Integer pagesize, String sort, String order) {
		    Pager<StorageScheduleOut> pager = new Pager<StorageScheduleOut>();
		    // 设置分页数据
		    pager.setRows(storageScheduleOutMapper.findPager(pageno, pagesize, sort, order));
		    // 设置数据总数storageScheduleMapper
		    pager.setTotal(storageScheduleOutMapper.findPagerTotal());
		    return pager;
		  }
	/**
	 * 查询单条记录
	 * @param Id
	 * @return
	 */
	public List<StorageScheduleOut> findById(Integer id){
		return storageScheduleOutMapper.findById(id);
	}
	/**
	 * 根据入库单编号id查询入库表的信息
	 * @return
	 */
	public StorageScheduleOut findDetail(@Param(value="id") Integer id){
		return storageScheduleOutMapper.findDetail(id);
	}
	/**
	 * 根据产品编号查入库表和详单表的信息第三页面显示
	 * @param productId
	 * @return
	 */
	public StorageScheduleOut findBypId(@Param(value="productId") String productId){
		return storageScheduleOutMapper.findBypId(productId);
	}
	/**
	 * 调度后修改入库表中的一个字段
	 * @param Id
	 * @return
	 */
	public int modify(String pId){
		return storageScheduleOutMapper.modify(pId);
	}
}
