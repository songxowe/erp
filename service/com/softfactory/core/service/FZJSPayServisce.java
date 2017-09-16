package com.softfactory.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.FZJSPayMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.SPay;
import com.softfactory.pojo.Scell;
/**
 * 入库业务逻辑
 * @author Administrator
 *
 */
@Service("fzjspayService")
public class FZJSPayServisce {
	@Resource(name = "fzjspayMapper")
	private FZJSPayMapper fzjspayMapper;

	public Pager<SPay> findOnePager(Integer pageno, Integer pagesize, String sort,
			String order, String payId) {
		Pager<SPay> pager = new Pager<SPay>();
		// 设置分页数据
		pager.setRows(fzjspayMapper.findOnePager(pageno, pagesize, sort, order,
				payId));
		// 设置数据总数 
		pager.setTotal(fzjspayMapper.findOnePagerTotal(payId));
		return pager;
	}
	
	public Pager<SPay> findTwoPager(Integer pageno, Integer pagesize, String sort,
			String order, String payId) {
		Pager<SPay> pager = new Pager<SPay>();
		// 设置分页数据
		pager.setRows(fzjspayMapper.findTwoPager(pageno, pagesize, sort, order,
				payId));
		// 设置数据总数 
		pager.setTotal(fzjspayMapper.findTwoPagerTotal(payId));
		return pager;
	}
	
	public Pager<SPay> findThreePager(Integer pageno, Integer pagesize, String sort,
			String order, String payId) {
		Pager<SPay> pager = new Pager<SPay>();
		// 设置分页数据
		pager.setRows(fzjspayMapper.findThreePager(pageno, pagesize, sort, order,
				payId));
		// 设置数据总数 
		pager.setTotal(fzjspayMapper.findThreePagerTotal(payId));
		return pager;
	}
	
	public String findMaxNum() {
		return fzjspayMapper.findMaxNum();
	}

	public int add(SPay spay) {
		return fzjspayMapper.add(spay);
	}

	public int modify(SPay spay) {
		return fzjspayMapper.modify(spay);
	}


	public SPay findById(Integer id) {
		return fzjspayMapper.findById(id);
	}
	
	 public void modifyStoreTag(String payId,String register,Integer nowAmounta){
		 fzjspayMapper.modifyStoreTag(payId, register, nowAmounta);
	 }
	 public void modifyCheckTag(String payId){
		 fzjspayMapper.modifyCheckTag(payId);
	 }
	 public void modifyCheckTagNo(String payId){
		 fzjspayMapper.modifyCheckTagNo(payId);
	 }
	 public Scell findscellById(String productId){
		 return fzjspayMapper.findscellById(productId);
	 }
	 
}
