package com.softfactory.core.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.XyfDfileMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Dfile;
import com.softfactory.pojo.Dkind;

@Service("xyfDfileService")
public class XyfDfileService {

	@Resource(name = "xyfDfileMapper")
	private XyfDfileMapper xyfDfileMapper;

	public int add(Dfile dfile) {
		return xyfDfileMapper.add(dfile);
	}

	public int modify(Dfile dfile) {
		return xyfDfileMapper.modify(dfile);
	}

	public int remove(Integer id) {
		return xyfDfileMapper.remove(id);
	}

	public Dfile findById(Integer id) {
		return xyfDfileMapper.findById(id);
	}

	public Pager<Dfile> findPager(Integer pageno, Integer pagesize,
			String sort, String order, String firstKindName,
			String secondKindName, String thirdKindName, String type,
			Date beginTime, Date endTime) {
		Pager<Dfile> pager = new Pager<Dfile>();
		pager.setRows(xyfDfileMapper.findPager(pageno, pagesize, sort, order,
				firstKindName, secondKindName, thirdKindName, type, beginTime,
				endTime));
		pager.setTotal(xyfDfileMapper.findPagerTotal(firstKindName,
				secondKindName, thirdKindName, type, beginTime, endTime));
		return pager;
	}

	public Pager<Dfile> findUncheckedPager(Integer pageno, Integer pagesize,
			String sort, String order, String firstKindName,
			String secondKindName, String thirdKindName, String type,
			Date beginTime, Date endTime) {
		Pager<Dfile> pager = new Pager<Dfile>();
		pager.setRows(xyfDfileMapper.findUncheckedPager(pageno, pagesize, sort,
				order, firstKindName, secondKindName, thirdKindName, type,
				beginTime, endTime));
		pager.setTotal(xyfDfileMapper.findUncheckedPagerTotal(firstKindName,
				secondKindName, thirdKindName, type, beginTime, endTime));
		return pager;
	}

	public String findMaxProductId() {
		return xyfDfileMapper.findMaxProductId();
	}

	public List<Dfile> findByCheckTag(String checkTag) {
		return xyfDfileMapper.findByCheckTag(checkTag);
	}

	public int findNumByCheckTag(String checkTag) {
		return xyfDfileMapper.findNumByCheckTag(checkTag);
	}

	public List<Dkind> findAll(Integer pid) {
		return xyfDfileMapper.findAll(pid);
	}

	public Dkind findDkindById(Integer id) {
		return xyfDfileMapper.findDkindById(id);
	}
	
	public String findKindIdById(Integer id){
		return xyfDfileMapper.findKindIdById(id);
	}

	public List<Dkind> findfirst() {
		return xyfDfileMapper.findfirst();
	}
	
	public Dkind findByName(String name){
		return xyfDfileMapper.findByName(name);
	}
	public boolean productNameIsExist(String productName) {
		boolean flag = false;
		int count = xyfDfileMapper.productNameIsExist(productName);
		if(count==0){
			flag=true;
		}else{
			flag=false;
		}
		return flag;
	}

	public Pager<Dfile> findRecoveryPager(int pageno, int pagesize,
			String sort, String order) {
		Pager<Dfile> pager = new Pager<Dfile>();
		pager.setRows(xyfDfileMapper.findRecoveryPager(pageno, pagesize,
			sort, order));
		pager.setTotal(xyfDfileMapper.findRecoveryPagerTotal());
		return pager;
	}

}
