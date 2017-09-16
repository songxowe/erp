package com.softfactory.core.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.softfactory.core.dao.LiDaWeiScellMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Dkind;
import com.softfactory.pojo.Scell;


@Service("scellSerice")
public class LiDaWeiScellService {
	@Resource(name="scellMapper")
	private LiDaWeiScellMapper scellMapper;
	
	//查询第二个页面
	public Pager<Scell>findTwoPager(Integer pageno, Integer pagesize, String sort,String order){
		Pager<Scell> pager=new Pager<Scell>();
		pager.setRows(scellMapper.findTwoPager(pageno, pagesize, sort, order));
		pager.setTotal(scellMapper.findTwoPagerTotal());
		return pager;
	}
	
	//查询第一个页面
	public Pager<Scell>findOnePager(Integer pageno, Integer pagesize, String sort,String order, String firstKingName,String secondKingName,
			String thirdKingName,Date beginDate,Date endDate,String str){
		Pager<Scell> pager=new Pager<Scell>();
		pager.setRows(scellMapper.findOnePager(pageno, pagesize, sort, order, firstKingName, secondKingName, thirdKingName, beginDate, endDate, str));
		pager.setTotal(scellMapper.findOnePagerTotal(firstKingName, secondKingName, thirdKingName, beginDate, endDate, str));
		return pager;
	}
	//查询第三个页面
	public Pager<Scell>findThreePager(Integer pageno, Integer pagesize, String sort,String order,String firstKingName,String secondKingName,
			String thirdKingName,String checkTag,
			Date firstdate,Date lastdate,String str){
		Pager<Scell> pager=new Pager<Scell>();
		pager.setRows(scellMapper.findThreePager(pageno, pagesize, sort, order, firstKingName, secondKingName, thirdKingName,  checkTag, firstdate, lastdate, str));
		pager.setTotal(scellMapper.findThreePagerTotal(firstKingName, secondKingName, thirdKingName,checkTag, firstdate, lastdate, str));
		return pager;
	}
	
	//查询第四个页面
	public Pager<Scell>findFourPager(Integer pageno, Integer pagesize, String sort,String order,String firstKingName,String secondKingName,
			String thirdKingName,
			Date firstdate,Date lastdate,String str){
		Pager<Scell> pager=new Pager<Scell>();
		pager.setRows(scellMapper.findFourPager(pageno, pagesize, sort, order, firstKingName, secondKingName, thirdKingName, firstdate, lastdate, str));
		pager.setTotal(scellMapper.findFourPagerTotal(firstKingName, secondKingName, thirdKingName, firstdate, lastdate, str));
		return pager;
	}
	
	//查询第五个页面
	public Pager<Scell>findFivePager(Integer pageno, Integer pagesize, String sort,String order,String firstKingName,String secondKingName,
			String thirdKingName,String str){
		Pager<Scell> pager=new Pager<Scell>();
		pager.setRows(scellMapper.findFivePager(pageno, pagesize, sort, order, firstKingName, secondKingName, thirdKingName, str));
		pager.setTotal(scellMapper.findFivePagerTotal(firstKingName, secondKingName, thirdKingName, str));
		return pager;
	}
	
	/**
	 * 增加数据
	 * @param scell
	 * @return
	 */
	public int addScell(Scell scell,String scellTag,String id){
		 scellMapper.addScell(scell);
		 return scellMapper.modifyDfile(scellTag, id);
	}
	
	/**
	 * 根据Id查询档案表数据
	 * @param id
	 * @return
	 */
	public Scell findById(String id){
		return scellMapper.findById(id);
	}
	
	/**
	 * 根据Id查询库存配置单表
	 * @param id
	 * @return
	 */
	public Scell findScellById(String id){
		return scellMapper.findScellById(id);
	}
	
	/**
	 * 查出配置单编号的最大值
	 * @return
	 */
	public String findMaxNum(){
		return scellMapper.findMaxNum();	
	}
	
	/**
	 * 修改配置单审核状态
	 */
	public int modifyScell(Scell scell){
		return scellMapper.modifyScell(scell);
	}
	
	/**
	 *变更库存配置单表 
	 */
	public int modifyScellById(Scell scell){
		return scellMapper.modifyScellById(scell);
	}
	
	/**
	 * 修改档案表
	 */
	public int modifyDfile(String scellTag,String id){
		return scellMapper.modifyDfile(scellTag, id);
	}
	/**
	 * 三级联动
	 */
	public List<Dkind>findAll(Dkind dkind){
		return scellMapper.findAll(dkind);
	}
	/**
	 * 根据ID查询产品分类设置
	 */
	public String findKindById(Integer id){
		return scellMapper.findKindById(id);
	}
}
