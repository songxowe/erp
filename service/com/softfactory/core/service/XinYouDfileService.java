package com.softfactory.core.service;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.softfactory.core.dao.XinYouDfileMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Dfile;


@Service("xinYouDfileService")
public class XinYouDfileService {
	@Resource(name = "xinYouDfileMapper")
	private XinYouDfileMapper xinYouDfileMapper;
	
	public Dfile findById(Integer id){
		return xinYouDfileMapper.findById(id);
		
	}
	/**
	 * 商品的分页查询
	 * @return
	 */
	public Pager<Dfile> findCommodityPager(Integer pageno, Integer pagesize,
			String sort, String order,String productId,String productName,String factoryName,
			String firstKindName,String secondKindName,String thirdKindName,String productDescribe,
			String responsiblePerson,Date registerTime){
		Pager<Dfile> pager = new Pager<Dfile>();
		pager.setRows(xinYouDfileMapper.findCommodityPager(pageno, pagesize, sort, order, productId, productName, 
				factoryName, firstKindName, secondKindName, thirdKindName, productDescribe, responsiblePerson,
				registerTime));
		pager.setTotal(xinYouDfileMapper.findCommodityTotal(pageno, pagesize, sort, order, productId,
				productName, factoryName, firstKindName, secondKindName, thirdKindName, 
				productDescribe, responsiblePerson, registerTime));
		return  pager;
		
	}
	
	/**
	 * 物料的分页查询
	 */
	public Pager<Dfile> findMaterialPager(Integer pageno, Integer pagesize,
			String sort, String order,String productId,String productName,String factoryName,
			String firstKindName,String secondKindName,String thirdKindName,String productDescribe,
			String responsiblePerson){
		Pager<Dfile> pager = new Pager<Dfile>();
		pager.setRows(xinYouDfileMapper.findMaterialPager(pageno, pagesize, sort, order, productId, productName, 
				factoryName, firstKindName, secondKindName, thirdKindName, productDescribe, responsiblePerson));
		pager.setTotal(xinYouDfileMapper.findMaterialTotal(pageno, pagesize, sort, order, productId,
				productName, factoryName, firstKindName, secondKindName, thirdKindName, 
				productDescribe, responsiblePerson));
		return  pager;
		
	}
	

}
