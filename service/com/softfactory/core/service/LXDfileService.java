package com.softfactory.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.LXDfileMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Dfile;

/**
 * 产品档案服务类by李翔 需整合
 * 
 * @author Administrator
 * 
 */
@Service("lxDfileService")
public class LXDfileService {
	@Resource(name = "dfileMapper")
	private LXDfileMapper lxDfileMapper;

	public Dfile selectFromApply(String productId) {
		return lxDfileMapper.selectFromApply(productId);
	}

	/**
	 * 新生产计划查询所有已通过档案
	 * 
	 * @return
	 */
	public Pager<Dfile> selectAllFromApply(int pageno, int pagesize,
			String sort, String order, String productId) {
		Pager<Dfile> pager = new Pager<Dfile>();
		pager.setRows(lxDfileMapper.selectAllFromApply(pageno, pagesize, sort,
				order, productId));
		pager.setTotal(lxDfileMapper.findPagerTotal());
		return pager;
	}

}
