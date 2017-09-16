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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.ScMdProcedureService;
import com.softfactory.core.service.ScMdpDetailsService;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MdProcedure;
import com.softfactory.pojo.MdpDetails;

/**
 * 设计单处理器
 * 
 * @author shengchen
 * 
 */
@Controller
public class ScProcedureController {
	@Resource(name = "mdProcedureService")
	private ScMdProcedureService procedureService;
	@Resource(name = "mdpDetailsService")
	private ScMdpDetailsService mdpDetailsService;
	@RequestMapping("/procedureController")
	public void list(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "productId") String productId,
			HttpServletResponse response) {

		try {
			if (!StringUtils.isEmpty(productId)) {
				productId = "%" + productId.toUpperCase() + "%";
			}

			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;

			Pager<MdProcedure> pager = procedureService.findPager(pageno,
					pagesize, sort, order, productId);

			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class,
					new JsonDateValueProcessor());

			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);

			PrintWriter out = response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/procedureController1")
	public void list1(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "productId") String productId,
			HttpServletResponse response) {

		try {
			if (!StringUtils.isEmpty(productId)) {
				productId = "%" + productId.toUpperCase() + "%";
			}

			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;

			Pager<MdProcedure> pager = procedureService.findPager1(pageno,
					pagesize, sort, order, productId);

			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class,
					new JsonDateValueProcessor());

			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);

			PrintWriter out = response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/procedureController2")
	public void list2(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			HttpServletResponse response) {
			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;

			Pager<MdProcedure> pager = procedureService.findPager2(pageno,
					pagesize, sort, order);

			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class,
					new JsonDateValueProcessor());

			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);

			PrintWriter out;
			try {
				out = response.getWriter();
				out.println(json.toString());
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	
	
	//物料设计页面
	@RequestMapping("/goDetails")
	public String goDetails(Integer id, HttpServletRequest request) {
		MdProcedure l = procedureService.findById(id);
		System.out.println(l.getId());
		request.getSession().setAttribute("MdProcedure", l);
		return "detailslist";
	}
	//审核页面
	@RequestMapping("/goAudits")
	public String goaudits(String designId, HttpServletRequest request) {
		List<MdpDetails> l =mdpDetailsService.findAll1(designId);
		request.setAttribute("MdpDetails", l);
		return "b";
	}
	
	@RequestMapping("/goAuditss")
	public String goauditss(String designId, HttpServletRequest request) {
		List<MdpDetails> l =mdpDetailsService.findAll1(designId);
		request.setAttribute("MdpDetails", l);
		return "bb";
	} 
	//AJXA返回审核结果个数
	@RequestMapping("/returncount")
	public void addCount(String checkTag,String designId, HttpServletResponse response){
		int count = 0;
		if(checkTag.equals("不通过")){
			checkTag="S001-2";
		}if(checkTag.equals("通过")){
			checkTag="S001-1";
		}
		count = procedureService.modifydesignModuleTag(checkTag,designId);
		   try {
			      PrintWriter out = response.getWriter();
			      out.println(count);
			      out.flush();
			      out.close();
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
		}
}
