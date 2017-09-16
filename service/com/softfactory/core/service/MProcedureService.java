package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.MProcedureMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Mprocedure;

@Service("mprocedureService")
public class MProcedureService {

	@Resource(name = "mprocedureMapper")
	private MProcedureMapper procedureMapper;

	public Pager<Mprocedure> findPager(Integer pageno, Integer pagesize,
			String sort, String order, Integer id, String procedureName) {
		Pager<Mprocedure> pager = new Pager<Mprocedure>();
		pager.setRows(procedureMapper.findPager(pageno, pagesize, sort, order,
				id, procedureName));
		pager.setTotal(procedureMapper.findPagerTotal(id, procedureName));
		return pager;
	}

	public int add(Mprocedure pd) {
		return procedureMapper.add(pd);
	}

	/**
	 * @author
	 * @param prentId
	 * @return
	 */
	public List<Mprocedure> findByPrentId(Integer prentId) {
		return procedureMapper.findByPrentId(prentId);
	}

	/**
	 * @author
	 * @param id
	 * @return
	 */
	public Mprocedure findById(Integer id) {
		return procedureMapper.findById(id);
	}
}
