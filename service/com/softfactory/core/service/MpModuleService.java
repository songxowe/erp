package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.MpModuleMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MpModule;

@Service("mpModuleService")
public class MpModuleService {

	@Resource(name = "mpModuleMapper")
	private MpModuleMapper mpModuleMapper;

	public Pager<MpModule> findPager(Integer pageno, Integer pagesize,
			String sort, String order, Integer id, String productName) {
		Pager<MpModule> pager = new Pager<MpModule>();
		pager.setRows(mpModuleMapper.findPager(pageno, pagesize, sort, order,
				id, productName));
		pager.setTotal(mpModuleMapper.findPagerTotal(id, productName));
		return pager;
	}

	public int add(MpModule pd) {
		return mpModuleMapper.add(pd);
	}

	/**
	 * @author GuangxiangLong
	 * @param prentId
	 * @return
	 */
	public List<MpModule> findByPrentId(Integer prentId) {
		return mpModuleMapper.findByPrentId(prentId);
	}
}
