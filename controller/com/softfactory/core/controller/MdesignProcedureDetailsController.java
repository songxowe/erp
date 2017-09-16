package com.softfactory.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.DesignModuleService;
import com.softfactory.core.service.MdesignProcedureDetailsService;
import com.softfactory.core.service.MdesignProcedureService;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.core.util.PrimaryGenerater;
import com.softfactory.pojo.DesignModule;
import com.softfactory.pojo.MdesignProcedure;
import com.softfactory.pojo.MdesignProcedureDetails;

@Controller
public class MdesignProcedureDetailsController {
	@Resource(name = "mdesignProcedureDetailsService")
	private MdesignProcedureDetailsService mdesignProcedureDetailsService;
	@Resource(name = "mdesignProcedureService")
	private MdesignProcedureService mdesignProcedureService;
	@Resource(name="designModuleService")
	private DesignModuleService designModuleService;
	/**
	 * 查询产品档案中通过审核以及工序组成为未设计的记录
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param productName
	 * @param response
	 */
	@RequestMapping("/mdesignProcedureDetails")
	public void list(@RequestParam(required=true,value = "page") Integer page,
			@RequestParam(required=true,value = "rows") Integer rows,
			@RequestParam(required=true,value = "sort") String sort,
			@RequestParam(required=true,value = "order") String order,
			@RequestParam(required=false,value = "productName") String productName,HttpServletResponse response){
		String checkTag="S001-1";
		//换成档案表再加上条件工序组成为未设计 
		if(!StringUtils.isEmpty(productName)){
			productName = "%"+productName+"%";
		}
		Integer pageno = (page-1)*rows;
		Integer pagesize = page*rows;
		Pager<DesignModule> pager = designModuleService.findPager(pageno, pagesize, sort, order, productName,checkTag);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,jsonConfig);
		try {
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 为产品添加工序
	 * @param mdesignProcedure
	 * @param did
	 * @param procedureName
	 * @param procedureID
	 * @param costPrice
	 * @param amountUnit
	 * @param labourHourAmount
	 * @return
	 */
	@RequestMapping("/mpd_save")
	public void save(MdesignProcedure mdesignProcedure,
			@RequestParam(required=false,value = "did") Integer did,
			@RequestParam(required=false,value = "procedureName")String[] procedureName,
			@RequestParam(required=false,value = "procedureID") String[] procedureID,
			@RequestParam(required=false,value = "costPriceSum") Double[] costPriceSum,
			@RequestParam(required=false,value = "amountUnit")String[] amountUnit,
			@RequestParam(required=false,value = "labourHourAmount") Double[] labourHourAmount,
			HttpServletResponse response) {
		//设置档案表工序组成为G001-1  已设计
		DesignModule d = designModuleService.findById(did);//改为档案表
		if(null!=d){
			mdesignProcedure.setDesignId(d.getDesignId());
			mdesignProcedure.setFirstKindId(d.getFirstKindId());
			mdesignProcedure.setFirstKindName(d.getFirstKindName());
			mdesignProcedure.setSecondKindId(d.getSecondKindId());
			mdesignProcedure.setSecondKindName(d.getSecondKindName());
			mdesignProcedure.setThirdKindId(d.getThirdKindId());
			mdesignProcedure.setThirdKindName(d.getThirdKindName());
			mdesignProcedure.setProcedureDescribe("产品描述");
		}
		
		double k = 0;
		if(null!=costPriceSum&&null!=labourHourAmount){
		for(int i =0;i<costPriceSum.length;i++){
			Double j = (costPriceSum[i]*labourHourAmount[i]);
			k+=j;
		}
		}
		mdesignProcedure.setCostPriceSum(k);
		mdesignProcedure.setModuleCostPriceSum(0.0);
		mdesignProcedure.setRegisterTime(new Date());
		mdesignProcedure.setCheckTag("S001-0");
		mdesignProcedure.setChangeTag("B002-0");
		mdesignProcedure.setDesignModuleTag("G002-0");
		mdesignProcedure.setDesignModuleChangeTag("G003-0");
		mdesignProcedureService.add(mdesignProcedure);
		MdesignProcedureDetails mdesignProcedureDetails = new MdesignProcedureDetails();
		MdesignProcedure m1 = mdesignProcedureService.findById(mdesignProcedure.getProductId());
		mdesignProcedureDetails.setParentId(m1.getId());	
		if(null!=costPriceSum){
			for(int i =0;i<costPriceSum.length;i++){
				mdesignProcedureDetails.setDetailsNumber(Integer.parseInt(procedureID[i]));
				mdesignProcedureDetails.setProcedureName(procedureName[i]);
				String ss = mdesignProcedureDetailsService.findID();
				String sss = PrimaryGenerater.getInstance().generaterNextNumber(ss);
				mdesignProcedureDetails.setProcedureId("3000"+sss);
				mdesignProcedureDetails.setCostPrice(costPriceSum[i]);
				mdesignProcedureDetails.setLabourHourAmount(labourHourAmount[i]);
				mdesignProcedureDetails.setAmountUnit(amountUnit[i]);
				mdesignProcedureDetails.setSubtotal(costPriceSum[i]*labourHourAmount[i]);
				mdesignProcedureDetails.setRegister(mdesignProcedure.getRegister());
				mdesignProcedureDetails.setRegisterTime(new Date());
				mdesignProcedureDetails.setDesignModuleTag("D002-0");
				mdesignProcedureDetails.setDesignModuleChangeTag("D003-0");
				mdesignProcedureDetailsService.add(mdesignProcedureDetails);
		}
		}
		
		try {
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>alert('提交成功，页面刷新！');parent.location.reload();</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 变更功能
	 * @param parentId
	 * @param procedureId
	 * @param costPrice
	 * @param labourHourAmount
	 */
	@RequestMapping("/mpd_modfiy")
	public void modfiy(MdesignProcedure mdesignProcedure,
			@RequestParam(required=false,value = "did") Integer did,
			@RequestParam(required=false,value = "procedureName")String[] procedureName,
			@RequestParam(required=false,value = "procedureID") String[] procedureID,
			@RequestParam(required=false,value = "costPriceSum") Double[] costPriceSum,
			@RequestParam(required=false,value = "amountUnit")String[] amountUnit,
			@RequestParam(required=false,value = "labourHourAmount") Double[] labourHourAmount,
			HttpServletResponse response) {
		double k = 0;
		if(null!=costPriceSum&&null!=labourHourAmount){
		for(int i =0;i<costPriceSum.length;i++){
			Double j = (costPriceSum[i]*labourHourAmount[i]);
			k+=j;
		}
		}
		mdesignProcedure.setCostPriceSum(k);
		mdesignProcedure.setModuleCostPriceSum(0.0);
		mdesignProcedure.setRegisterTime(new Date());
		mdesignProcedure.setCheckTag("S001-1");
		mdesignProcedure.setChangeTag("B002-0");
		mdesignProcedure.setDesignModuleTag("G002-0");
		mdesignProcedure.setDesignModuleChangeTag("G003-0");
		mdesignProcedure.setId(did);
		mdesignProcedureService.modfiy(mdesignProcedure);
		MdesignProcedureDetails mdesignProcedureDetails = new MdesignProcedureDetails();
		MdesignProcedure m1 = mdesignProcedureService.findById(mdesignProcedure.getProductId());
		mdesignProcedureDetails.setParentId(m1.getId());	
		if(null!=costPriceSum){
			for(int i =0;i<costPriceSum.length;i++){
				mdesignProcedureDetails.setDetailsNumber(Integer.parseInt(procedureID[i]));
				mdesignProcedureDetails.setProcedureName(procedureName[i]);
				String ss = mdesignProcedureDetailsService.findID();
				String sss = PrimaryGenerater.getInstance().generaterNextNumber(ss);
				mdesignProcedureDetails.setProcedureId("3000"+sss);
				mdesignProcedureDetails.setCostPrice(costPriceSum[i]);
				mdesignProcedureDetails.setLabourHourAmount(labourHourAmount[i]);
				mdesignProcedureDetails.setAmountUnit(amountUnit[i]);
				mdesignProcedureDetails.setSubtotal(costPriceSum[i]*labourHourAmount[i]);
				mdesignProcedureDetails.setRegister(mdesignProcedure.getRegister());
				mdesignProcedureDetails.setRegisterTime(new Date());
				mdesignProcedureDetails.setDesignModuleTag("D002-0");
				mdesignProcedureDetails.setDesignModuleChangeTag("D003-0");
				mdesignProcedureDetailsService.modfiy(mdesignProcedureDetails);
		}
		}
		
		try {
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>alert('提交成功，页面刷新！');parent.location.reload();</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
