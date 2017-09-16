package com.softfactory.core.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.LbQueryMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Manufacture;
import com.softfactory.pojo.MpModule;
import com.softfactory.pojo.Mprocedure;
import com.softfactory.pojo.QueryResult;

@Service("lbQueryService")
public class LbQueryService {

	@Resource(name = "lbQueryMapper")
	private LbQueryMapper lbQueryMapper;

	public Pager<QueryResult> findPager(Integer pageno, Integer pagesize,
			String sort, String order, String manufactureProcedureTag,
			String manufactureId, Integer detailsNumber, String checkTag,
			String keyword, String status, Date beginTime, Date endTime) {
		Pager<QueryResult> pager = new Pager<QueryResult>();
		pager.setRows(lbQueryMapper.findPager(pageno, pagesize, sort, order,
				manufactureProcedureTag, manufactureId, detailsNumber,
				checkTag, keyword, status, beginTime, endTime));
		pager.setTotal(lbQueryMapper.findPagerTotal(manufactureProcedureTag,
				manufactureId, detailsNumber, checkTag, keyword, status,
				beginTime, endTime));
		return pager;
	}

	public Manufacture findByMid(String manufactureid) {
		return lbQueryMapper.findByMid(manufactureid);
	}

	public List<Mprocedure> findByParentId(Integer id) {
		return lbQueryMapper.findByParentId(id);
	}

	public String findByMaId(Integer id) {
		return lbQueryMapper.findByMaId(id);
	}

	public Manufacture findById(Integer id) {
		return lbQueryMapper.findById(id);
	}

	public Mprocedure findMprocedure(Integer mid) {
		return lbQueryMapper.findMprocedure(mid);
	}

	public List<MpModule> findByParent(Integer id) {
		return lbQueryMapper.findByParent(id);
	}

}
