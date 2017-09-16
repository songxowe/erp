package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import com.softfactory.core.dao.MapplyMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Mapply;

@Service("mapplyService")
public class MapplyService {
	@Resource(name = "mapplyMapper")
	private MapplyMapper mapplyMapper;

	/**
	 * 添加
	 * 
	 * @param mapply
	 * @return
	 */
	public int add(Mapply mapply) {
		return mapplyMapper.add(mapply);
	}

	/**
	 * 根据ID查询单条数据
	 * 
	 * @param applyId
	 * @return
	 */
	public Mapply findById(String applyId) {
		return mapplyMapper.findById(applyId);
	}

	/**
	 * 审核
	 * 
	 * @param applyId
	 * @param mapply
	 * @return
	 */
	public int check(Mapply mapply) {
		return mapplyMapper.check(mapply);
	}

	/**
	 * 查询所有+分页
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @return
	 */
	public Pager<Mapply> selectAllFromCheck(Integer pageno, Integer pagesize,
			String sort, String order, String applyid) {
		Pager<Mapply> pager = new Pager<Mapply>();
		pager.setRows(mapplyMapper.selectAllFromCheck(pageno, pagesize, sort,
				order, applyid));
		pager.setTotal(mapplyMapper.findPagerTotal());
		return pager;
	}

	/**
	 * 派工所需查询已审核未派单数据
	 * 
	 * @return
	 */
	public List<Mapply> findByNoManufactureTag() {
		return mapplyMapper.findByNoManufactureTag();
	}

	/**
	 * 派工所需根据id查询单条数据
	 * 
	 * @param applyId
	 * @return
	 */
	@Select("select ID id,APPLY_ID applyId,PRODUCT_ID productId,PRODUCT_NAME productName,PRODUCT_DESCRIBE productDescribe,AMOUNT amount,DESIGNER designer,REGISTER register,REGISTER_TIME registerTime,CHECK_TIME checkTime,CHECK_TAG checkTag,REMARK remark,MANUFACTURE_TAG manufactureTag from M_APPLY where ID=#{id,jdbcType=NUMERIC}")
	public Mapply findByIdFrom(Integer id) {
		return mapplyMapper.findByIdFrom(id);
	}

	/**
	 * 将未派单修改为已派单
	 * 
	 * @param m
	 * @return
	 */
	@Update("update M_APPLY set REGISTER = #{register}, MANUFACTURE_TAG = 'P001-1',REMARK = #{remark} where ID = #{id}")
	public int manufacture(Mapply m) {
		return mapplyMapper.manufacture(m);
	}

	/**
	 * 派工所需分页+条件查询
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param id
	 * @return
	 */
	public Pager<Mapply> selectAllFromManufacture(Integer pageno,
			Integer pagesize, String sort, String order, Integer id) {
		Pager<Mapply> pager = new Pager<Mapply>();
		pager.setRows(mapplyMapper.selectAllFromManufacture(pageno, pagesize,
				sort, order, id));
		pager.setTotal(mapplyMapper.findPagerTotal1(id));
		return pager;
	}

	/**
	 * 派工所需分页total
	 * 
	 * @param id
	 * @return
	 */
	public long findPagerTotal1(@Param("id") Integer id) {
		return mapplyMapper.findPagerTotal1(id);
	}

	public String findMax() {
		return mapplyMapper.findMax();
	}

}
