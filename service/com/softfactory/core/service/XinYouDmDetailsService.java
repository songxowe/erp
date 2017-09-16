package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.XinYouDmDetailsMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.DmDetails;
/**
 * 产品物料组成明细Service
 * @author Administrator
 *
 */
@Service("xinYouDmDetailsService")
public class XinYouDmDetailsService {
	@Resource(name = "xinYouDmDetailsMapper")
	private XinYouDmDetailsMapper xinYouDmDetailsMapper;
	
	public int add(DmDetails dmDetails){
		return xinYouDmDetailsMapper.add(dmDetails);
		
	}
	public int modify(DmDetails dmDetails){
		return xinYouDmDetailsMapper.modify(dmDetails);
		
	}
	public int remove(Integer id){
		return xinYouDmDetailsMapper.remove(id);
	}
	public List<DmDetails> findById(Integer id) {
		return xinYouDmDetailsMapper.findById(id);
		
	}
	public Pager<DmDetails> findPager(Integer pageno, Integer pagesize,String sort, String order,
			Integer id,Integer parentId,Integer detailsNumber,String productId,String productName) {
		Pager<DmDetails> pager = new Pager<DmDetails>();
		pager.setRows(xinYouDmDetailsMapper
				.findPager(pageno, pagesize, sort, order, id,parentId,detailsNumber,productId,productName));
		pager.setTotal(xinYouDmDetailsMapper.findPagerTotal(id,parentId,detailsNumber,productId,productName));
		return  pager;
	}

}
