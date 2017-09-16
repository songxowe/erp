package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.FZJSPayDetailsMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.SPayDetails;
/**
 * 入库明细业务逻辑
 * @author Administrator
 *
 */
@Service("fzjspaydetailsServisce")
public class FZJSPayDetailsServisce {
	@Resource(name = "fzjspaydetailsMapper")
	private FZJSPayDetailsMapper fzjspaydetailsMapper;

	public Pager<SPayDetails> findPager(Integer pageno, Integer pagesize, String sort,
			String order, String parentId) {
		Pager<SPayDetails> pager = new Pager<SPayDetails>();
		// 设置分页数据 
		pager.setRows(fzjspaydetailsMapper.findPager(pageno, pagesize, sort, order,
				parentId));
		// 设置数据总数
		pager.setTotal(fzjspaydetailsMapper.findPagerTotal(parentId));
		return pager;
	}

	public int add(SPayDetails spaydetails) {
		return fzjspaydetailsMapper.add(spaydetails);
	}


	public List<SPayDetails> findById(Integer id) {
		return fzjspaydetailsMapper.findById(id);
	}
}
