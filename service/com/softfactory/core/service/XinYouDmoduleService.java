package com.softfactory.core.service;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.softfactory.core.dao.XinYouDmDetailsMapper;
import com.softfactory.core.dao.XinYouDmoduleMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.core.util.PrimaryGenerater;
import com.softfactory.pojo.DmDetails;
import com.softfactory.pojo.Dmodule;

/**
 * 产品物料组成Service
 * 
 * @author Administrator
 * 
 */
@Service("xinYouDmoduleService")
public class XinYouDmoduleService {
	@Resource(name = "xinYouDmoduleMapper")
	private XinYouDmoduleMapper xinYouDmoduleMapper;
	@Resource(name = "xinYouDmDetailsMapper")
	private XinYouDmDetailsMapper xinYouDmDetailsMapper;

	public int add(String prodcutId, String[] productId1, String[] subtotal,
			String remark, String[] productDescribe, String designer) {
		int j = 0;
		Dmodule dmodule = xinYouDmoduleMapper.FindByInsert(prodcutId);
		dmodule.setDesignId("200"
				+ PrimaryGenerater.getInstance().generaterNextNumber(
						xinYouDmoduleMapper.FindBy()));
		dmodule.setCostPriceSum(0.00);
		dmodule.setModuleDescribe(remark);
		dmodule.setDesigner(designer);
		dmodule.setCheckTag("S001-0");
		dmodule.setChangeTag("B002-0");
		xinYouDmoduleMapper.add(dmodule);
		int b = xinYouDmoduleMapper.FindByInsert1(prodcutId);
		double c = 0.0;
		for (int i = 0; i < productId1.length; i++) {
			DmDetails dmdetatils = xinYouDmDetailsMapper
					.SelectInsert(productId1[i]);
			dmdetatils.setAmount(Double.parseDouble(subtotal[i]));
			dmdetatils.setParentId(b);
			dmdetatils.setDetailsNumber(b);
			dmdetatils.setProductDescribe(productDescribe[i]);
			dmdetatils.setSubtotal(dmdetatils.getCostPrice()
					* Double.parseDouble(subtotal[i]));
			c += dmdetatils.getCostPrice() * Double.parseDouble(subtotal[i]);
			dmdetatils.setResidualAmount(Double.parseDouble(subtotal[i]));
			xinYouDmDetailsMapper.add(dmdetatils);
		}
		xinYouDmoduleMapper.updateSum(c, prodcutId);
		xinYouDmoduleMapper.updateState(prodcutId);
		return j;

	}

	public int modify(Dmodule dmodule) {
		return xinYouDmoduleMapper.modify(dmodule);

	}

	/**
	 * 审核
	 * 
	 * @param id
	 * @param costPriceSum
	 * @param checkTag
	 * @param register
	 * @return
	 */
	public int modify1(Integer id, Double costPriceSum, String checkTag,
			String register, Date checkTime) {
		return xinYouDmoduleMapper.modify1(id, costPriceSum, checkTag,
				register, checkTime);
	}

	public int remove(Integer id) {
		return xinYouDmoduleMapper.remove(id);

	}

	public Dmodule findById(Integer id) {
		return xinYouDmoduleMapper.findById(id);
	}

	public Dmodule findByproductId(String productId) {
		return xinYouDmoduleMapper.findByproductId(productId);

	}

	public Pager<Dmodule> findPager(Integer pageno, Integer pagesize,
			String sort, String order, Integer id, String designId,
			String productId, String productName, String firstKindName,
			String secondKindName, String thirdKindName, String designer,
			String register, Date registerTime, String checker, String changer,
			String checkTag, String changeTag) {
		Pager<Dmodule> pager = new Pager<Dmodule>();
		pager.setRows(xinYouDmoduleMapper.findPager(pageno, pagesize, sort,
				order, id, designId, productId, productName, firstKindName,
				secondKindName, thirdKindName, designer, register,
				registerTime, checker, changer, checkTag, changeTag));
		pager.setTotal(xinYouDmoduleMapper.findPagerTotal(id, designId,
				productId, productName, firstKindName, secondKindName,
				thirdKindName, designer, register, registerTime, checker,
				changer, checkTag, changeTag));
		return pager;
	}

	/**
	 * 物料组成设计单查询
	 */
	public Pager<Dmodule> findPager2(Integer pageno, Integer pagesize,
			String sort, String order, Integer id, String designId,
			String productId, String productName, String firstKindName,
			String secondKindName, String thirdKindName, String designer,
			String register, Date registerTime, String checker, String changer,
			String checkTag, String changeTag) {
		Pager<Dmodule> pager = new Pager<Dmodule>();
		pager.setRows(xinYouDmoduleMapper.findPager2(pageno, pagesize, sort,
				order, id, designId, productId, productName, firstKindName,
				secondKindName, thirdKindName, designer, register,
				registerTime, checker, changer, checkTag, changeTag));
		pager.setTotal(xinYouDmoduleMapper.findPagerTotal2(id, designId,
				productId, productName, firstKindName, secondKindName,
				thirdKindName, designer, register, registerTime, checker,
				changer, checkTag, changeTag));
		return pager;
	}

	/**
	 * 物料组成设计单变更
	 */
	public Pager<Dmodule> findPager3(Integer pageno, Integer pagesize,
			String sort, String order, Integer id, String designId,
			String productId, String productName, String firstKindName,
			String secondKindName, String thirdKindName, String designer,
			String register, Date registerTime, String checker, String changer,
			String checkTag, String changeTag) {
		Pager<Dmodule> pager = new Pager<Dmodule>();
		pager.setRows(xinYouDmoduleMapper.findPager3(pageno, pagesize, sort,
				order, id, designId, productId, productName, firstKindName,
				secondKindName, thirdKindName, designer, register,
				registerTime, checker, changer, checkTag, changeTag));
		pager.setTotal(xinYouDmoduleMapper.findPagerTotal3(id, designId,
				productId, productName, firstKindName, secondKindName,
				thirdKindName, designer, register, registerTime, checker,
				changer, checkTag, changeTag));
		return pager;
	}

	public Dmodule FindByInsert(String productId) {
		return xinYouDmoduleMapper.FindByInsert(productId);
	}

	public String FindBy() {
		return xinYouDmoduleMapper.FindBy();
	}

	public void UpdateState1(String checker, String checkTag, String designId) {
		xinYouDmoduleMapper.UpdateState1(checker, checkTag,designId);
	}
}
