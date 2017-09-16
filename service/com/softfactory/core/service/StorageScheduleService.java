package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.softfactory.core.dao.StorageScheduleMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Scell;
import com.softfactory.pojo.StorageSchedule;


@Service("storageScheduleService")
public class StorageScheduleService {

	@Resource(name="storageScheduleMapper")
	private StorageScheduleMapper storageScheduleMapper;
	/**
	 * 读取满足条件的记录
	 * @return
	 */
	
	 public Pager<StorageSchedule> findPager(Integer pageno, Integer pagesize, String sort, String order) {
		    Pager<StorageSchedule> pager = new Pager<StorageSchedule>();
		    // 设置分页数据
		    pager.setRows(storageScheduleMapper.findPager(pageno, pagesize, sort, order));
		    // 设置数据总数storageScheduleMapper
		    pager.setTotal(storageScheduleMapper.findPagerTotal());
		    return pager;
		  }
	/**
	 * 查询入库单编号一样的记录
	 * @param Id
	 * @return
	 */
	public List<StorageSchedule> findById(@Param("id")Integer id){
		return storageScheduleMapper.findById(id);
	}
	/**
	 * 根据入库单编号查入库单的信息
	 * @param id
	 * @return
	 */
	public StorageSchedule findDetail(Integer id){
		return storageScheduleMapper.findDetail(id);
	}
	/**
	 * 
	 * 根据产品编号查入库表和详单表的信息第三页面显示
	 * @param productId
	 * @return
	 */
	public StorageSchedule findBypId(@Param(value="productId") String productId){
		return storageScheduleMapper.findBypId(productId);
	}
	/**
	 * 调度后修改入库表中的一个字段
	 * @param Id
	 * @return
	 */
	public int modify(String pId){
		return storageScheduleMapper.modify(pId);
	}
	public Integer  modifys(Integer id) {
		return storageScheduleMapper.modifys(id);
	}
	public Scell findScell(String productId) {
		return storageScheduleMapper.findScell(productId);
	}
	public void modifyScell(Scell scell) {
		storageScheduleMapper.modifyScell(scell);
	}
}
