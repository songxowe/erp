package com.softfactory.core.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.MdesignProcedureDetailsMapper;
import com.softfactory.pojo.MdesignProcedureDetails;

@Service("mdesignProcedureDetailsService")
public class MdesignProcedureDetailsService {
	@Resource(name="mdesignProcedureDetailsMapper")
	private MdesignProcedureDetailsMapper MdesignProcedureDetailsMapper;
	
	public int add(MdesignProcedureDetails mdesignProcedureDetails){
		return MdesignProcedureDetailsMapper.add(mdesignProcedureDetails);
	}
	public int modfiy(MdesignProcedureDetails mdesignProcedureDetails){
		return MdesignProcedureDetailsMapper.modfiy(mdesignProcedureDetails);
	}
	public int remove(Integer parentId){
		return MdesignProcedureDetailsMapper.remove(parentId);
	}
	public List<MdesignProcedureDetails> findById(Integer parentId){
		return MdesignProcedureDetailsMapper.findById(parentId);
	}
	public String findID(){
		return MdesignProcedureDetailsMapper.findID();
	}
}
