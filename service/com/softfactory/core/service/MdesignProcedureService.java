package com.softfactory.core.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.MdesignProcedureMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MdesignProcedure;

@Service("mdesignProcedureService")
public class MdesignProcedureService {
	@Resource(name="mdesignProcedureMapper")
	private MdesignProcedureMapper mdesignProcedureMapper;
	
	public int add(MdesignProcedure mdesignProcedure){
		return mdesignProcedureMapper.add(mdesignProcedure);
	}
	public int modfiy(MdesignProcedure mdesignProcedure){
		return mdesignProcedureMapper.modfiy(mdesignProcedure);
	}
	public int remove(Integer id){
		return mdesignProcedureMapper.remove(id);
	}
	public MdesignProcedure findById(String id){
		return mdesignProcedureMapper.findById(id);
	}
	public int check(Integer id,String checker,Date checkTime,String checkSuggestion,String checkTag){
		return mdesignProcedureMapper.check(id, checker, checkTime, checkSuggestion, checkTag);
	}
	public MdesignProcedure checkfind(Integer id){
		return mdesignProcedureMapper.checkfind(id);
	}
	
	public Pager<MdesignProcedure> findPager(Integer pageno, Integer pagesize, String sort,
			String order, String productName,String checkTag){
		Pager<MdesignProcedure> pager = new Pager<MdesignProcedure>();
		pager.setRows(mdesignProcedureMapper.findPager(pageno, pagesize, sort, order, productName,checkTag));
		pager.setTotal(mdesignProcedureMapper.findPagerTotal(productName,checkTag));
		return pager;
	}
}
