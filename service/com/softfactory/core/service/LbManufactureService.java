package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.LbManufactureMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Manufacture;
import com.softfactory.pojo.MdpDetails;
import com.softfactory.pojo.MdpModule;
import com.softfactory.pojo.MpModule;
import com.softfactory.pojo.MpModuling;
import com.softfactory.pojo.Mprocedure;
import com.softfactory.pojo.Mproceduring;
import com.softfactory.pojo.SPayDetails;
import com.softfactory.pojo.Spays;

@Service("lbManufactureService")
public class LbManufactureService {

	@Resource(name = "lbManufactureMapper")
	private LbManufactureMapper lbManufactureMapper;

	public Manufacture findByMid(String manufactureid) {
		return lbManufactureMapper.findByMid(manufactureid);
	}

	public Manufacture findById(Integer id) {
		return lbManufactureMapper.findById(id);
	}

	public Pager<Manufacture> findPager(Integer pageno, Integer pagesize,
			String sort, String order, String manufactureProcedureTag,
			String storeTag) {
		Pager<Manufacture> pager = new Pager<Manufacture>();
		pager.setRows(lbManufactureMapper.findPager(pageno, pagesize, sort,
				order, manufactureProcedureTag, storeTag));
		pager.setTotal(lbManufactureMapper.findPagerTotal(
				manufactureProcedureTag, storeTag));
		return pager;
	}

	public String findByMaId(Integer id) {
		return lbManufactureMapper.findByMaId(id);
	}

	public List<Mprocedure> findByParentId(Integer parentId) {
		return lbManufactureMapper.findByParentId(parentId);
	}

	public List<MpModule> findByParent(Integer id) {
		return lbManufactureMapper.findByParent(id);
	}

	public Mprocedure findMprocedure(Integer id) {
		return lbManufactureMapper.findMprocedure(id);
	}

	public Integer modifyManufacture(Manufacture manufacture) {
		return lbManufactureMapper.modifyManufacture(manufacture);
	}

	public Integer modifyMprocedure(Mprocedure mprocedure) {
		return lbManufactureMapper.modifyMprocedure(mprocedure);
	}

	List<MdpDetails> findMdpDetails(Integer id, String name) {
		return lbManufactureMapper.findMdpDetails(id, name);
	}

	List<MdpModule> findMdpModule(Integer id) {
		return lbManufactureMapper.findMdpModule(id);
	}
	
	public Integer addMproceduring(Mproceduring mproceduring){
		return lbManufactureMapper.addMproceduring(mproceduring);
	}
	
	public Integer addMpModuling(MpModuling mpModuling){
		return lbManufactureMapper.addMpModuling(mpModuling);
	}
	
	public Mproceduring findMproceduring(String procedureId){
		return lbManufactureMapper.findMproceduring(procedureId);
	}
	
	public List<MpModuling> findMpModuling(Integer parentId){
		return lbManufactureMapper.findMpModuling(parentId);
	}

	public List<Mproceduring> findByMproceduring(Integer id) {
		return lbManufactureMapper.findByMproceduring(id);
	}
	
	public Integer addSpays(Spays spays){
		return lbManufactureMapper.addSpays(spays);
	}

	public String getMaxGatherId() {
		return lbManufactureMapper.getMaxGatherId();
	}
	
	public Integer addSPayDetails(SPayDetails sPayDetails){
		return lbManufactureMapper.addSPayDetails(sPayDetails);
	}

	public Integer getSpays(String maxValue) {
		return lbManufactureMapper.getSpays(maxValue);
	}
}
