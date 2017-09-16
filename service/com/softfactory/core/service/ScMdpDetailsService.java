package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.ScMdpDetailsMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MdpDetails;

@Service("mdpDetailsService")
public class ScMdpDetailsService {
	@Resource(name = "scMdpDetailsMapper")
	private ScMdpDetailsMapper scMdpDetailsMapper;

	public List<MdpDetails> findAll() {
		return scMdpDetailsMapper.findAll();
	}
	
	public List<MdpDetails> findAll1(String designId){
		return scMdpDetailsMapper.findAll1(designId);
		
	}

	public void modifydesignModuleTagTod0021(Integer parentId) {
		scMdpDetailsMapper.modifydesignModuleTagTod0021(parentId);
	}

	/**
	 * 分页查询 + 条件查询
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param procedureName
	 *            工序名称
	 * @return
	 */
	public Pager<MdpDetails> findPager( Integer pageno,
			 Integer pagesize, String sort,
			 String order, String procedureName,
			 String designId) {
		Pager<MdpDetails> pager = new Pager<MdpDetails>();
		List<MdpDetails> l = scMdpDetailsMapper.findPager(pageno, pagesize, sort,
				order, procedureName, designId);
		pager.setRows(l);
		pager.setTotal(scMdpDetailsMapper.findPagerTotal(procedureName, designId));
		return pager;

	}
}
