package com.softfactory.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.DesignModuleService;
import com.softfactory.core.service.MdesignProcedureDetailsService;
import com.softfactory.core.service.MdesignProcedureService;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.DesignModule;
import com.softfactory.pojo.MdesignProcedure;
import com.softfactory.pojo.MdesignProcedureDetails;

@Controller
public class MdesignProcedureController {
	@Resource(name = "mdesignProcedureDetailsService")
	private MdesignProcedureDetailsService mdesignProcedureDetailsService;
	@Resource(name="mdesignProcedureService")
	private MdesignProcedureService mdesignProcedureService;
	@Resource(name="designModuleService")
	private DesignModuleService designModuleService;
	/**
	 * 查询功能（已审核）
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param productName
	 * @param response
	 */
	@RequestMapping("/mdesignProcedure")
	public void list(@RequestParam(required=true,value = "page") Integer page,
			@RequestParam(required=true,value = "rows") Integer rows,
			@RequestParam(required=true,value = "sort") String sort,
			@RequestParam(required=true,value = "order") String order,
			@RequestParam(required=false,value = "productName") String productName,HttpServletResponse response){
		String checkTag="S001-1";
		if(!StringUtils.isEmpty(productName)){
			productName = "%"+productName+"%";
		}
		Integer pageno = (page-1)*rows;
		Integer pagesize = page*rows;
		Pager<MdesignProcedure> pager = mdesignProcedureService.findPager(pageno, pagesize, sort, order, productName,checkTag);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,jsonConfig);
		try {
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 审核列表分页查询
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param productName
	 * @param response
	 */
	@RequestMapping("mdesignProcedure_checklist")
	public void checkList(@RequestParam(required=true,value = "page") Integer page,
			@RequestParam(required=true,value = "rows") Integer rows,
			@RequestParam(required=true,value = "sort") String sort,
			@RequestParam(required=true,value = "order") String order,
			@RequestParam(required=false,value = "productName") String productName,HttpServletResponse response){
		String checkTag="S001-0";
		if(!StringUtils.isEmpty(productName)){
			productName = "%"+productName+"%";
		}
		Integer pageno = (page-1)*rows;
		Integer pagesize = page*rows;
		Pager<MdesignProcedure> pager = mdesignProcedureService.findPager(pageno, pagesize, sort, order, productName,checkTag);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,jsonConfig);
		try {
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 为查询功能查询单个对象的详细信息
	 */
	@RequestMapping("/mdesignProcedure_query")
	public String findById(@RequestParam(value="productId")String productId,ModelMap modelMap){
		MdesignProcedure m = mdesignProcedureService.findById(productId);
		List<MdesignProcedureDetails> list= mdesignProcedureDetailsService.findById(m.getId());
		modelMap.put("mdesignProcedure",m);
		modelMap.put("list",list);
		return "proceduredesignselect";
		//
	}
	/**
	 * 查询产品档案信息
	 * 产品工序设计
	 * @param id
	 * @param procedureId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/mdesignProcedure_findById")
	public String findById(@RequestParam(value="id")Integer id,ModelMap modelMap,HttpServletRequest request){
		//根据ID查询对应的产品档案
		DesignModule d = designModuleService.findById(id);//改为档案表
		modelMap.put("designModule", d);
		
//		List<Procedure> list = new ArrayList<Procedure>();
//		for(int i = 0;i<procedureId.length;i++){
//			if(procedureId[i].equals("1")){
//				Procedure p = new Procedure();
//				p.setProcedureId("1");
//				p.setProcedureName("组装");
//				list.add(p);
//			}else if(procedureId[i].equals("2")){
//				Procedure p1 = new Procedure();
//				p1.setProcedureId("2");
//				p1.setProcedureName("包装");
//				list.add(p1);
//			}
//		}
//		modelMap.put("list",list);
		return "proceduredesign";
	}
//	@RequestMapping("/mdesignProcedure_check")
//	public 
	/**
	 * 审核查询单个对象的详细信息
	 * @param parentId
	 * @param modelMap
	 */
	@RequestMapping("/mdesignProcedure_checkfind")
	public String checkfind(String productId,ModelMap modelMap){
		MdesignProcedure m = mdesignProcedureService.findById(productId);
		List<MdesignProcedureDetails> list= mdesignProcedureDetailsService.findById(m.getId());
		modelMap.put("mdesignProcedure",m);
		modelMap.put("list",list);
		return "proceduredesigncheck";
	}
	/**
	 * 审核
	 * @param id
	 * @param checkId
	 */
	@RequestMapping("mdesignProcedure_check")
	public void check(@RequestParam(required=false,value="did")Integer id,@RequestParam(required=false,value="did")Integer checkId,@RequestParam(required=false,value="checker")String checker,HttpServletResponse response){
		//判断checkId是否为通过
		if(id==1){
			Date date = new Date();
			String checkSuggestion = "没意见";
			String checkTag = "S001-1";
			mdesignProcedureService.check(id, checker, date, checkSuggestion, checkTag);
		}else{
			mdesignProcedureDetailsService.remove(id);
			mdesignProcedureService.remove(id);
			//设置档案表工序组成标志为G001-0 未设计
		}
		try {
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>alert('提交成功，页面刷新！');parent.location.reload();</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
