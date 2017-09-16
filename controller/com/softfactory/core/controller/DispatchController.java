package com.softfactory.core.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.dao.LXPdetailsMapper;
import com.softfactory.core.service.LXdetailsService;
import com.softfactory.core.service.MProcedureService;
import com.softfactory.core.service.ManufactureService;
import com.softfactory.core.service.MapplyService;
import com.softfactory.core.service.MpModuleService;
import com.softfactory.core.service.ZjsSgDetailsService;
import com.softfactory.core.service.ZjsSgatherService;
import com.softfactory.core.util.ErpUtils;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Manufacture;
import com.softfactory.pojo.LXdetails;
import com.softfactory.pojo.LXPdetails;
import com.softfactory.pojo.Mapply;
import com.softfactory.pojo.MpModule;
import com.softfactory.pojo.Mprocedure;
import com.softfactory.pojo.SgDetails;
import com.softfactory.pojo.Sgather;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/")
public class DispatchController {

	@Resource(name = "mapplyService")
	private MapplyService applyService;

	@Resource(name = "lxpdetailsMapper")
	private LXPdetailsMapper lxpdetailsMapper;

	@Resource(name = "lxDetailsService")
	private LXdetailsService lxDetailsService;

	@Resource(name = "manufactureService")
	private ManufactureService manufactureService;

	@Resource(name = "mprocedureService")
	private MProcedureService mprocedureService;

	@Resource(name = "mpModuleService")
	private MpModuleService mpModuleService;

	@Resource(name = "zjsSgatherService")
	private ZjsSgatherService zjsSgatherService;

	@Resource(name = "zjsSgDetailsService")
	private ZjsSgDetailsService zjsSgDetailsService;

	@RequestMapping("/dispatchController")
	public void list(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "id") Integer id,
			HttpServletResponse response) {

		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页
		Pager<Mapply> pager = applyService.selectAllFromManufacture(pageno,
				pagesize, sort, order, id);
		JsonConfig jsonConfig = new JsonConfig();
		try {
			PrintWriter out = response.getWriter();
			jsonConfig.registerJsonValueProcessor(Date.class,
					new JsonDateValueProcessor());
			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/dispatchController_view")
	public String view(String productId, ModelMap modelMap) {
		System.out.println(productId);

		return "Dispatching/disview";
	}

	@RequestMapping("/dispatchController_add")
	public String add(Integer id, String productId, ModelMap modelMap) {
		System.out.println(productId);
		List<LXPdetails> list = lxpdetailsMapper.findByPId(productId);
		if (list.size() == 0) {
			return "Dispatching/error";
		}
		for (LXPdetails p : list) {
			p.setSubtotal(p.getLabourHourAmount() * p.getSubtotal());
		}
		modelMap.put("list", list);
		Mapply apply = applyService.findByIdFrom(id);
		apply.setRegisterTime(new Date());
		modelMap.put("apply", apply);
		return "Dispatching/dispatchadd";
	}

	@RequestMapping("/dispatchController_checkpage")
	public String checkpage(Integer id, String productId, ModelMap modelMap) {
		System.out.println(productId);
		Manufacture m = manufactureService.findById(id);
		m.setCheckTime(new Date());
		List<Mprocedure> list = mprocedureService.findByPrentId(id);
		modelMap.put("manu", m);
		modelMap.put("list", list);
		return "Dispatching/Manufacturecheck";
	}

	@RequestMapping("/dispatchController_check")
	public String check(String manufactureId, String checkTag, String remark,
			String checker, Double total, ModelMap modelMap) {
		Manufacture m = new Manufacture();
		Date date = new Date();
		m.setManufactureId(manufactureId);
		m.setCheckTag(checkTag);
		m.setChecker(checker);
		m.setCheckTime(date);
		m.setRemark(remark);
		int i = manufactureService.modify(m);
		if (i == 1) {
			if (remark != "S001-1") {
				Manufacture m1 = manufactureService
						.findByManufactureId(manufactureId);
				Sgather s = new Sgather();
				SgDetails sd = new SgDetails();
				s.setGatherId(ErpUtils.getNumber("402",
						zjsSgatherService.findMaxNum()));
				s.setReason("C002-1");
				s.setAmountSum((double) m1.getAmount());
				s.setCostPriceSum(m1.getAmount() * total);
				s.setGatheredAmountSum(0);
				s.setRemark(remark);
				s.setRegister(checker);
				s.setRegisterTime(date);
				s.setCheckTag("S001-1");
				s.setStoreTag("K002-1");
				s.setMaId(m1.getId());
				String gid = s.getGatherId();
				zjsSgatherService.add(s);

				sd.setParentId(zjsSgatherService.findByGatherId(gid));
				sd.setProductId(m1.getProductId());
				sd.setProductName(m1.getProductId());
				sd.setProductDescribe(m1.getProductDescribe());
				sd.setAmount((double) m1.getAmount());
				sd.setSubtotal(m1.getAmount() * total);
				sd.setGatherTag("D001-0");
				zjsSgDetailsService.add(sd);
			}
		}
		return "Dispatching/success";
	}

	@RequestMapping("/dispatchController_addd")
	public String add(Integer id, String productId, HttpServletRequest request) {
		System.out.println(id + productId);
		System.out.println(request.getParameter("proName"));
		List<LXPdetails> list = lxpdetailsMapper.findByPId(productId);
		List<LXdetails> list2 = new ArrayList<LXdetails>();
		try {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("list1.get(i).getParentId()"
						+ list.get(i).getParentId());
				list2.addAll(lxDetailsService.findByPId(list.get(i)
						.getParentId()));
			}
			for (int i = 0; i < list2.size() - 1; i++) {
				for (int j = list2.size() - 1; j > i; j--) {
					if (list2.get(j).getProductName()
							.equals(list2.get(i).getProductName())) {
						list2.remove(j);
					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (LXdetails m : list2) {
			System.out.println(m.getProcedureName() + "eeeeeeeeeeeeeeeeeee");
		}
		Mapply apply = applyService.findByIdFrom(id);
		System.out.println(apply.getProductName());
		apply.setManufactureTag("P001-1");
		apply.setRemark(request.getParameter("remark"));
		apply.setRegister(request.getParameter("register"));
		System.out.println(request.getParameter("remark"));
		System.out.println(apply.getRegister() + apply.getRegisterTime());
		int count = applyService.manufacture(apply);
		if (count > 0) {
			System.out.println("修改成功");
			Manufacture m = new Manufacture();
			m.setManufactureId(ErpUtils.getNumber("301",
					manufactureService.findMaxNum()));
			m.setProductId(apply.getProductId());
			m.setProductName(apply.getProductName());
			m.setAmount((int) apply.getAmount());
			m.setApplyIdGroup(apply.getApplyId());
			m.setProductDescribe(apply.getProductDescribe());
			// 工时总成本
			double tal = 0;
			for (LXPdetails p : list) {
				tal += p.getSubtotal();
			}
			m.setLabourCostPriceSum(tal);
			// 物料总成本
			double priceSum = 0;
			for (int i = 0; i < list2.size(); i++) {
				priceSum += apply.getAmount() * list2.get(i).getAmount()
						* list2.get(i).getCostPrice();
			}
			m.setModuleCostPriceSum(priceSum);
			// 工单指定人
			m.setDesigner(request.getParameter("proName"));
			m.setRegister(apply.getRegister());
			m.setRegisterTime(new Date());
			m.setRemark(apply.getRemark());
			m.setCheckTag("S001-0");
			m.setManufactureProcedureTag("S002-0");
			int count1 = manufactureService.add(m);
			List<Integer> it = new ArrayList<Integer>();
			if (count1 > 0) {
				System.out.println("插入成功");
				System.out.println(m.getId());
				int count2 = 0;
				Mprocedure mp = new Mprocedure();
				for (LXPdetails p : list) {
					mp.setParentId(m.getId());
					mp.setDetailsNumber(p.getId());
					mp.setProcedureId(p.getProcedureId());
					mp.setProcedureName(p.getProcedureName());
					mp.setLabourHourAmount(p.getLabourHourAmount());
					System.out.println(p.getSubtotal()
							* p.getLabourHourAmount());
					mp.setSubtotal(p.getSubtotal() * p.getLabourHourAmount());
					List<LXdetails> l = lxDetailsService.findByPId(p.getId());
					double modoule = 0;
					for (int i = 0; i < l.size(); i++) {
						modoule += l.get(i).getAmount()
								* l.get(i).getCostPrice();
					}
					mp.setModuleSubtotal(modoule);
					mp.setCostPrice(p.getCostPrice());
					mp.setDemandAmount(apply.getAmount());
					mp.setProcedureFinishTag("G004-0");
					mp.setProcedureTransferTag("G005-0");
					count2 = mprocedureService.add(mp);
					it.add(mp.getId());
					MpModule md = new MpModule();
					int count3 = 0;
					for (LXdetails mt : lxDetailsService.findByPId(p.getId())) {
						System.out.println(p.getId() + "我屮艸芔茻");
						md.setParentId(mp.getId());
						md.setDetailsNumber(mt.getDetailsNumber());
						md.setProductId(mt.getProductId());
						md.setProductName(mt.getProductName());
						md.setCostPrice(mt.getCostPrice());
						md.setAmount(mt.getAmount() * m.getAmount());
						md.setSubtotal(mt.getCostPrice() * mt.getAmount());
						count3 = mpModuleService.add(md);
					}
					if (count3 > 0) {
						System.out.println("生产工序物料表插入成功");
					}
				}
				if (count2 > 0) {
					System.out.println("生产工序插入成功");
				} else {
					System.out.println("生产工序插入失败");
				}
			} else {
				System.out.println("生产总表插入失败");
			}
		}
		return "Dispatching/newsuccess";
	}

	/**
	 * 查看物料
	 * 
	 * @param id
	 * @param amount
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/dispatchController_see")
	public String see(Integer id, Integer amount, ModelMap modelMap) {
		List<LXdetails> list = lxDetailsService.findByPId(id);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setAmount(amount * list.get(i).getAmount());
			list.get(i).setSubtotal(
					list.get(i).getAmount() * list.get(i).getCostPrice());
		}
		System.out.println(id + "查看物料");
		modelMap.put("list", list);
		System.out.println(list.get(0).getParentId());
		LXPdetails ms = lxpdetailsMapper.findById(id);
		System.out.println(ms.getDesignId());
		System.out.println();
		modelMap.put("ms", ms);
		return "Dispatching/dispatchsee";
	}
}
