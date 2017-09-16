package com.softfactory.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.ScMdProcedureMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MdProcedure;

@Service("mdProcedureService")
public class ScMdProcedureService {
	@Resource(name = "scMdProcedureMapper")
	private ScMdProcedureMapper scMdProcedureMapper;

	/**
	 * 通过ID查询单个生产工序单对象的八个需要属性
	 * 
	 * @param id
	 * @return
	 */
	public MdProcedure findById(Integer id) {
		return scMdProcedureMapper.findById(id);
	}

	/**
	 * 生产工序单所用物料设计完成后修改工序物料设计标志为G002-1: 已提交
	 */
	public void modifyModuleTag(String designId){
		scMdProcedureMapper.modifyModuleTag(designId);
	}
	
	/**
	 * 生产工序单审核通过后修改工序物料设计标志为G002-2 已审核
	 */
	public int modifydesignModuleTag(String checkTag,String designId){
		return scMdProcedureMapper.modifydesignModuleTag(checkTag,designId);
	}
	/**
	 * 分页显示数据
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param productId
	 * @return
	 */
	public Pager<MdProcedure> findPager(Integer pageno, Integer pagesize,
			String sort, String order, String productId) {
		Pager<MdProcedure> pager = new Pager<MdProcedure>();
		pager.setRows(scMdProcedureMapper.findPager(pageno, pagesize, sort,
				order, productId));
		pager.setTotal(scMdProcedureMapper.findPagerTotal(productId));

		return pager;

	}
	
	/**
	 * 分页显示数据
	 * 审核时分页
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param productId
	 * @return
	 */
	public Pager<MdProcedure> findPager1(Integer pageno, Integer pagesize,
			String sort, String order, String productId) {
		Pager<MdProcedure> pager = new Pager<MdProcedure>();
		pager.setRows(scMdProcedureMapper.findPager1(pageno, pagesize, sort,
				order, productId));
		pager.setTotal(scMdProcedureMapper.findPagerTotal1(productId));

		return pager;

	}
	
	/**
	 * 分页显示数据
	 * 最后审核结果查询时分页
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param productId
	 * @return
	 */
	public Pager<MdProcedure> findPager2(Integer pageno, Integer pagesize,
			String sort, String order) {
		Pager<MdProcedure> pager = new Pager<MdProcedure>();
		pager.setRows(scMdProcedureMapper.findPager2(pageno, pagesize, sort,
				order));
		pager.setTotal(scMdProcedureMapper.findPagerTotal2());

		return pager;

	}
}
