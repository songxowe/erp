package com.softfactory.core.service;



import javax.annotation.Resource; 

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.ZjsSgatherMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Scell;
import com.softfactory.pojo.Sgather;

@Service("zjsSgatherService")
public class ZjsSgatherService {
	@Resource(name = "zjsSgatherMapper")
	private ZjsSgatherMapper zjsSgatherMapper;
	
	public Pager<Sgather> findOnePager(Integer pageno, Integer pagesize, String sort, String order, String gatherId) {
	    Pager<Sgather> pager = new Pager<Sgather>();
	    // 设置分页数据
	    pager.setRows(zjsSgatherMapper.findOnePager(pageno, pagesize, sort, order, gatherId));
	    // 设置数据总数
	    pager.setTotal(zjsSgatherMapper.findOnePagerTotal(gatherId));
	    return pager;
	  }
	
	public String findMaxNum() {
		return zjsSgatherMapper.findMaxNum();
	}
	
	public Pager<Sgather> findTwoPager(Integer pageno, Integer pagesize, String sort, String order, String gatherId) {
	    Pager<Sgather> pager = new Pager<Sgather>();
	    // 设置分页数据
	    pager.setRows(zjsSgatherMapper.findTwoPager(pageno, pagesize, sort, order, gatherId));
	    // 设置数据总数
	    pager.setTotal(zjsSgatherMapper.findTwoPagerTotal(gatherId));
	    return pager;
	  }
	
	public Pager<Sgather> findThreePager(Integer pageno, Integer pagesize, String sort, String order, String gatherId) {
	    Pager<Sgather> pager = new Pager<Sgather>();
	    // 设置分页数据
	    pager.setRows(zjsSgatherMapper.findThreePager(pageno, pagesize, sort, order, gatherId));
	    // 设置数据总数
	    pager.setTotal(zjsSgatherMapper.findThreePagerTotal(gatherId));
	    return pager;
	  }
	 public int add(Sgather sgather){
		 return zjsSgatherMapper.add(sgather);
	 }
	 public int modify(Sgather sgather){
		 return zjsSgatherMapper.modify(sgather);
	 }
	 public Sgather findById(String gatherId){
		 return zjsSgatherMapper.findById(gatherId);
	 }
	 public void modifyStoreTag(String gatherId,String register,Integer nowAmounta){
		 zjsSgatherMapper.modifyStoreTag(gatherId, register, nowAmounta);
	 }
	 public Integer findByGatherId(String gatherId){
		 return zjsSgatherMapper.findByGatherId(gatherId);
	 }
	 
	 public void modifyCheckTag(String gatherId){
		  zjsSgatherMapper.modifyCheckTag(gatherId);
	 }
	 public void modifyCheckTagNo(String gatherId){
		 zjsSgatherMapper.modifyCheckTagNo(gatherId);
	 }
	 public Scell findscellById(String productId){
		 return zjsSgatherMapper.findscellById(productId);
	 }
}
