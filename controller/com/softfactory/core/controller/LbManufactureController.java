package com.softfactory.core.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.LbManufactureService;
import com.softfactory.core.util.Constants;
import com.softfactory.core.util.ErpUtils;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Manufacture;
import com.softfactory.pojo.MpModule;
import com.softfactory.pojo.MpModuling;
import com.softfactory.pojo.Mprocedure;
import com.softfactory.pojo.Mproceduring;
import com.softfactory.pojo.SPayDetails;
import com.softfactory.pojo.Spays;
import com.softfactory.pojo.User;

@Controller
public class LbManufactureController {

	@Resource(name = "lbManufactureService")
	private LbManufactureService lbManufactureService;
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 1登记跳转页面列表
	 * */
	@RequestMapping("/lbManufactureController")
	public void worklist(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "manufactureProcedureTag") String manufactureProcedureTag,
			@RequestParam(required = false, value = "storeTag") String storeTag,
			HttpServletResponse response, HttpServletRequest request) {
		manufactureProcedureTag = "S002-0";
		storeTag = "K002-1";
		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页
		Pager<Manufacture> pager = lbManufactureService.findPager(pageno,
				pagesize, sort, order, manufactureProcedureTag, storeTag);
		request.getSession().setAttribute("ANUM", pager.getTotal());
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		try {
			PrintWriter out = response.getWriter();
			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);
			out.println(json.toString());
			/*out.println("<script language='javascript'>window.location.reload();</script>");*/
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 2点击列表登记按钮
	 * @param manufactureid
	 * @return 出库单号
	 * @return 工序生产 集合
	 * @return 登记时间
	 * @return 检查时间
	 * @return 生产总表对象
	 * @return session 存生产编号
	 * */
	@RequestMapping("/lbManufactureController_detail")
	public String detail(Manufacture manufacture, ModelMap modelMap,
			HttpServletRequest request) {
		manufacture = lbManufactureService.findByMid(manufacture
				.getManufactureId());
		List<Mprocedure> mlist = lbManufactureService
				.findByParentId(manufacture.getId());
		modelMap.put("mlist", mlist);
		String gatherId = lbManufactureService.findByMaId(manufacture.getId());
		modelMap.put("gatherId", gatherId);
		modelMap.put("registerTime", df.format(manufacture.getRegisterTime()));
		modelMap.put("checkTime", df.format(manufacture.getCheckTime()));
		modelMap.put("manufacture", manufacture);
		return "lbproducts";
	}

	/**
	 * 3点击页面登记跳转(生产派工单)
	 * @param id:生产总表ID
	 * @param mid生产工序表ID
	 * @return mplist生产工序物料表集合
	 * @return manufacture 生产总表对象
	 * @return mprocedure 生产 工序表对象
	 * @return 登记时间
	 * @session 工序表ID
	 * */
	@RequestMapping("/lbManufactureController_material")
	public String material(
			@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = false, value = "mid") Integer mid,
			ModelMap modelMap, HttpServletRequest request,HttpServletResponse response) {
		Manufacture manufacture = lbManufactureService.findById(id);
		Mprocedure mprocedure = lbManufactureService.findMprocedure(mid);
		List<MpModule> mpList = lbManufactureService.findByParent(mprocedure
				.getId());
		modelMap.put("mplist", mpList);
		modelMap.put("manufacture", manufacture);
		modelMap.put("mprocedure", mprocedure);
		modelMap.put("registerTime", df.format(new Date()));
		request.getSession().setAttribute("mid", mid);
		request.getSession().setAttribute("id",id);
		return "lbmaterial";
	}
	/**
	 * ajax验证
	 * */
	@RequestMapping("/lbManufactureController_ajax")
	public void ajax(
			@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = false, value = "mid") Integer mid,
			ModelMap modelMap, HttpServletRequest request,HttpServletResponse response) {
		Manufacture manufacture = lbManufactureService.findById(id);
		Mprocedure mprocedure = lbManufactureService.findMprocedure(mid);
		List<Mprocedure> mlist = lbManufactureService
				.findByParentId(manufacture.getId());
		for(int i=0;i<mlist.size();i++){
			if(mlist.get(i).getId()==mprocedure.getId()){
				if(i!=0){
					if(!mlist.get(i-1).getProcedureTransferTag().equals("G005-2")){
						try {
							PrintWriter out = response.getWriter();
							out.println("1");
							out.flush();
							out.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
/**
 * 登记点击未完成
 * */
	@RequestMapping("/lbManufactureController_undone")
	public String undone(){
		return "lbworkorder_list";
	}
	/**
	 * 4审核点击完成跳转
	 * @param mproceduring//生产工序过程
	 * @param mpModuling//生产工序物料过程记录
	 * 
	 * */
	@RequestMapping("/lbManufactureController_confirm")
	public String confirm(ModelMap modelMap, 
			@RequestParam(required = false, value = "procedureResponsiblePerson") String procedureResponsiblePerson,
			@RequestParam(required=false,value="labourHourAmount") double labourHourAmount,
			HttpServletRequest request) {
		int regCount=0;
		String[] lab=request.getParameterValues("amount");
		Integer id=(Integer)request.getSession().getAttribute("id");
		Integer mid=(Integer)request.getSession().getAttribute("mid");
		Manufacture manufacture = lbManufactureService.findById(id);
		Mprocedure mprocedure = lbManufactureService.findMprocedure(mid);
		List<Mprocedure> mlist = lbManufactureService
				.findByParentId(manufacture.getId());
		List<MpModule> mpList = lbManufactureService.findByParent(mprocedure
				.getId());
		List<Mproceduring>mmlist=lbManufactureService.findByMproceduring(id);
		if(null!=mmlist&&!"".equals(mmlist)&&mmlist.size()>0){
			regCount=mmlist.get(mmlist.size()-1).getRegCount();
		}
		Mproceduring mproceduring=addMproceduring(procedureResponsiblePerson, labourHourAmount,regCount, manufacture, mprocedure);
		mproceduring.setRegister(((User)request.getSession().getAttribute(Constants.USER_IN_SESSION)).getUsername());
		mproceduring.setRegisterTime(new Date());
		lbManufactureService.addMproceduring(mproceduring);
		for(int i=0;i<mpList.size();i++){
			Integer amount=Integer.valueOf(lab[i]);
			MpModuling mpModuling=addMpModuling(mproceduring, amount, mpList.get(i));
			 lbManufactureService.addMpModuling(mpModuling);
		}
		String gatherId = lbManufactureService.findByMaId(manufacture.getId());
		for(int i=0;i<mlist.size();i++){
			if(mlist.get(i).getId()==mprocedure.getId()){
				mlist.get(i).setProcedureFinishTag("G004-2");
				lbManufactureService.modifyMprocedure(mlist.get(i));
			}
		}
		manufacture.setManufactureProcedureTag("S002-1");
		lbManufactureService.modifyManufacture(manufacture);
		modelMap.put("gatherId", gatherId);
		modelMap.put("mlist", mlist);
		modelMap.put("manufacture", manufacture);
		modelMap.put("mprocedure", mprocedure);
		modelMap.put("registerTime", df.format(new Date()));
		modelMap.put("checkTime", df.format(manufacture.getCheckTime()));
		return "lbproducts";
	}

	/**
	 * 5点击菜单复核跳转列表页面
	 * */
	@RequestMapping("/lbManufactureController_review")
	public void review(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "manufactureProcedureTag") String manufactureProcedureTag,
			@RequestParam(required = false, value = "storeTag") String storeTag,
			HttpServletResponse response, HttpServletRequest request) {
		manufactureProcedureTag = "S002-1";
		storeTag = "K002-1";
		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页
		Pager<Manufacture> pager = lbManufactureService.findPager(pageno,
				pagesize, sort, order, manufactureProcedureTag, storeTag);
		request.getSession().setAttribute("BNUM", pager.getTotal());
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		try {
			PrintWriter out = response.getWriter();
			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 6、点击列表复核按钮跳转
	 * @param manufacture生产主表对象
	 * */
	@RequestMapping("/lbManufactureController_checkreview")
	public String checkreview(Manufacture manufacture, ModelMap modelMap,
			HttpServletRequest request) {
		manufacture = lbManufactureService.findByMid(manufacture
				.getManufactureId());
		List<Mprocedure> mlist = lbManufactureService
				.findByParentId(manufacture.getId());
		modelMap.put("mlist", mlist);
		String gatherId = lbManufactureService.findByMaId(manufacture.getId());
		modelMap.put("gatherId", gatherId);
		modelMap.put("registerTime", df.format(manufacture.getRegisterTime()));
		modelMap.put("checkTime", df.format(manufacture.getCheckTime()));
		modelMap.put("manufacture", manufacture);
		request.getSession().setAttribute("manufactureid",
				manufacture.getManufactureId());
		request.getSession().setAttribute("AAA", manufacture.getAmount());
		request.getSession().setAttribute("BBB", manufacture.getTestedAmount());
		return "lbcheckreview";
	}
	/**
	 *7、点击页面复核按钮 
	 *跳转至复核确认页面
	 * */
	@RequestMapping("/lbManufactureController_checkmaterial")
	public String checkmaterial(
			@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = false, value = "mid") Integer mid,
			ModelMap modelMap, HttpServletRequest request) {
		Manufacture manufacture = lbManufactureService.findById(id);
		Mprocedure mprocedure = lbManufactureService.findMprocedure(mid);
		List<MpModule> mpList = lbManufactureService.findByParent(mprocedure
				.getId());
		Mproceduring mproceduring=lbManufactureService.findMproceduring(mprocedure.getProcedureId());
		List<MpModuling> mpModuling=lbManufactureService.findMpModuling(mproceduring.getId());
		for(int i=0;i<mpList.size();i++){
			mpList.get(i).setSubtotal(mpModuling.get(i).getAmount());
		}
		modelMap.put("mproceduring", mproceduring);
		modelMap.put("mplist", mpList);
		modelMap.put("manufacture", manufacture);
		modelMap.put("mprocedure", mprocedure);
		modelMap.put("registerTime", df.format(new Date()));
		request.getSession().setAttribute("id", id);
		request.getSession().setAttribute("mid", mid);
		return "lbcheckmaterial";
	}
/**
 * 8、点击确认复核跳转至复核列表页面
 * */
	@RequestMapping("/lbManufactureController_confirmlist")
	public String confirmlist(ModelMap modelMap, 
			@RequestParam(required = false, value = "procedureResponsiblePerson") String procedureResponsiblePerson,
			@RequestParam(required=false,value="labourHourAmount") double labourHourAmount,
			HttpServletRequest request) {
		String[] lab=request.getParameterValues("amount");
		Integer id=(Integer)request.getSession().getAttribute("id");
		Integer mid=(Integer)request.getSession().getAttribute("mid");
		Manufacture manufacture = lbManufactureService.findById(id);
		Mprocedure mprocedure = lbManufactureService.findMprocedure(mid);
		List<Mprocedure> mlist = lbManufactureService
				.findByParentId(manufacture.getId());
		List<MpModule> mpList = lbManufactureService.findByParent(mprocedure
				.getId());
		double count=0;
		double num=0;
		for(int i=0;i<mpList.size();i++){
			Double amount=Double.valueOf(lab[i]);
			count+=amount*mpList.get(i).getCostPrice();
			num+=amount;
		}
		String gatherId = lbManufactureService.findByMaId(manufacture.getId());
		for(int i=0;i<mlist.size();i++){
			if(mlist.get(i).getId()==mprocedure.getId()){
				mlist.get(i).setProcedureFinishTag("G004-3");
				/*(mlist.get(i).setRealLabourHourAmount(labourHourAmount);
				mlist.get(i).setRealSubtotal(labourHourAmount*mlist.get(i).getCostPrice());
				mlist.get(i).setRealModuleSubtotal(count);
				mlist.get(i).setRealAmount(num);
				manufacture.setRealModuleCostPriceSum(manufacture.getRealModuleCostPriceSum()+count);
				manufacture.setRealLabourCostPriceSum(manufacture.getRealLabourCostPriceSum()+labourHourAmount*mlist.get(i).getCostPrice());*/
				manufacture.setManufactureProcedureTag("S002-0");
				lbManufactureService.modifyManufacture(manufacture);
				lbManufactureService.modifyMprocedure(mlist.get(i));
				
			}
		}
		modelMap.put("gatherId", gatherId);
		modelMap.put("mlist", mlist);
		modelMap.put("manufacture", manufacture);
		modelMap.put("mprocedure", mprocedure);
		modelMap.put("registerTime", df.format(new Date()));
		modelMap.put("checkTime", df.format(manufacture.getCheckTime()));
		return "lbreview";
	}

	
	/**
	 * 9、点击页面交接登记
	 * */
	@RequestMapping("/lbManufactureController_changecheck")
	public String changecheck(@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = false, value = "mid") Integer mid,
			@RequestParam(required = false, value = "ramount") Integer ramount,
			ModelMap modelMap, HttpServletRequest request,HttpServletResponse response) {
		Manufacture manufacture = lbManufactureService.findById(id);
		Mprocedure mprocedure = lbManufactureService.findMprocedure(mid);
		manufacture.setTestedAmount(ramount);
		mprocedure.setRealAmount((double)ramount);
		mprocedure.setProcedureTransferTag("G005-1");
		lbManufactureService.modifyMprocedure(mprocedure);
		manufacture.setManufactureProcedureTag("S002-1");
		lbManufactureService.modifyManufacture(manufacture);
		return "lbcheckverify";
	}
	
	/**
	 * 9、点击页面交接登记
	 * */
	@RequestMapping("/lbManufactureController_finish")
	public String finish(@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = false, value = "ramount") Integer ramount,
			ModelMap modelMap, HttpServletRequest request,HttpServletResponse response) {
		Manufacture manufacture = lbManufactureService.findById(id);
		List<Mproceduring> mmlist=lbManufactureService.findByMproceduring(id);
		int count=mmlist.get(mmlist.size()-1).getRegCount();
		List<Mprocedure>mlist=lbManufactureService.findByParentId(id);
		manufacture.setTestedAmount(ramount);
		mlist.get(count-1).setRealAmount((double)ramount);
		mlist.get(count-1).setProcedureTransferTag("G005-2");
		lbManufactureService.modifyMprocedure(mlist.get(count-1));
		boolean is=true;
		for(int i=0;i<mlist.size();i++){
			if(!mlist.get(i).getProcedureTransferTag().equals("G005-2")){
				is=false;
				break;
			}
		}
		if(!is){
			manufacture.setManufactureProcedureTag("S002-0");
			lbManufactureService.modifyManufacture(manufacture);
		}else{
			manufacture.setManufactureProcedureTag("S002-2");
			for(int i=0;i<mlist.size();i++){
				mlist.get(i).setProcedureFinishTag("G004-1");
				lbManufactureService.modifyMprocedure(mlist.get(i));
			}
			lbManufactureService.modifyManufacture(manufacture);
			lbManufactureService.addSpays(addSpays(manufacture, request));
			SPayDetails sPayDetails=addSPayDetails(manufacture, request);
			sPayDetails.setParentId(lbManufactureService.getSpays(lbManufactureService.getMaxGatherId()));
			lbManufactureService.addSPayDetails(sPayDetails);
		}
		return "lbreview";
	}
	//....................................................................................................
	/**
	 * 最后成品查询页面
	 * */
	@RequestMapping("/lbManufactureController_querylist")
	public void querylist(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "manufactureProcedureTag") String manufactureProcedureTag,
			@RequestParam(required = false, value = "storeTag") String storeTag,
			HttpServletResponse response, HttpServletRequest request) {
		manufactureProcedureTag = "S002-2";
		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页
		Pager<Manufacture> pager = lbManufactureService.findPager(pageno,
				pagesize, sort, order, manufactureProcedureTag, storeTag);
		request.getSession().setAttribute("CNUM", pager.getTotal());
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		try {
			PrintWriter out = response.getWriter();
			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	//*********************************工具方法**********************************************
	/**
	 * 生产工序过程记录
	 * */
	public Mproceduring addMproceduring(@RequestParam(required = false, value = "procedureResponsiblePerson") String procedureResponsiblePerson,
			@RequestParam(required=false,value="labourHourAmount") double labourHourAmount,@RequestParam(required=false,value="regCount") Integer regCount,
		Manufacture manufacture,Mprocedure mprocedure){
		Mproceduring mproceduring=new Mproceduring();
		mproceduring.setParentId(manufacture.getId());
		mproceduring.setDetailsNumber(mprocedure.getDetailsNumber());
		mproceduring.setProcedureId(mprocedure.getProcedureId());
		mproceduring.setProcedureName(mprocedure.getProcedureName());
		mproceduring.setLabourHourAmount(labourHourAmount);
		mproceduring.setCostPrice(mprocedure.getCostPrice());
		mproceduring.setSubtotal(labourHourAmount*mprocedure.getCostPrice());
		mproceduring.setRegCount(regCount+1);
		mproceduring.setProcedureResponsiblePerson(procedureResponsiblePerson);
		return mproceduring;
	}
	/**
	 * 生产工序物料过程记录
	 * */
	public MpModuling addMpModuling(Mproceduring mproceduring,
			@RequestParam(required=false,value="amount") double amount,MpModule mpModule){
		MpModuling mpModuling=new MpModuling();
		mpModuling.setParentId(mproceduring.getId());
		mpModuling.setDetailsNumber(mpModule.getDetailsNumber());
		mpModuling.setProductId(mpModule.getProductId());
		mpModuling.setProductName(mpModule.getProductName());
		mpModuling.setCostPrice(mpModule.getCostPrice());
		mpModuling.setAmount(amount);
		mpModuling.setSubtotal(mpModule.getCostPrice()*amount);
		return mpModuling;
	}
	
	/**
	 * 入库
	 * */
	public Spays addSpays(Manufacture manufacture,HttpServletRequest request){
		Spays spays=new Spays();
		String gatherId=lbManufactureService.getMaxGatherId();
		spays.setGatherId(ErpUtils.getNumber("401", gatherId));
		spays.setStore(((User)request.getSession().getAttribute(Constants.USER_IN_SESSION)).getUsername());
		spays.setReason("生产入库");
		spays.setAmountSum((double)manufacture.getTestedAmount());
		spays.setCostPriceSun(manufacture.getRealModuleCostPriceSum());
		spays.setRegister(((User)request.getSession().getAttribute(Constants.USER_IN_SESSION)).getUsername());
		spays.setRegisterTime(new Date());
		spays.setChecker(((User)request.getSession().getAttribute(Constants.USER_IN_SESSION)).getUsername());
		spays.setCheckTime(new Date());
		spays.setCheckTag("S001-1");
		spays.setProductId(manufacture.getProductId());
		spays.setStoreTag("K002-0");
		spays.setDemandAmountb(manufacture.getTestedAmount());
		spays.setRealAmoutb(0);
		return spays;
	}
	
	/**
	 * 入库明细
	 * */
	public SPayDetails addSPayDetails(Manufacture manufacture,HttpServletRequest request){
		SPayDetails sPayDetails=new SPayDetails();
		sPayDetails.setProductId(manufacture.getProductId());
		sPayDetails.setProductName(manufacture.getProductName());
		sPayDetails.setProductDescribe(manufacture.getProductDescribe());
		/*sPayDetails.setAmount((double)manufacture.getAmount());
		sPayDetails.setCostPrice(manufacture.getRealModuleCostPriceSum()/manufacture.getAmount());
		sPayDetails.setSubtotal(manufacture.getModuleCostPriceSum());
		sPayDetails.setPaidAmount(0);*/
		sPayDetails.setPayTag("K002-1");
		return sPayDetails;
	}
}
