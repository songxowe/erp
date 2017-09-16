package com.softfactory.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.ZjsSgDetailsMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.SgDetails;

@Service("zjsSgDetailsService")
public class ZjsSgDetailsService {
	@Resource(name = "zjsSgDetailsMapper")
	private ZjsSgDetailsMapper zjsSgDetailsMapper;
	
	
	public Pager<SgDetails> findPager(Integer pageno, Integer pagesize, String sort, String order, String parentId) {
	    Pager<SgDetails> pager = new Pager<SgDetails>();
	    // 设置分页数据
	    pager.setRows(zjsSgDetailsMapper.findPager(pageno, pagesize, sort, order, parentId));
	    // 设置数据总数
	    pager.setTotal(zjsSgDetailsMapper.findPagerTotal(parentId));
	    return pager;
	  }
	 public int add(SgDetails sgDetails){
		 return zjsSgDetailsMapper.add(sgDetails);
	 }
	 public SgDetails findById(String  productId){
		 return zjsSgDetailsMapper.findById(productId);
	 }

}
