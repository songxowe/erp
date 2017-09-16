package com.softfactory.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.LXDfileService;
import com.softfactory.core.service.MapplyService;
import com.softfactory.core.util.ErpUtils;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Dfile;
import com.softfactory.pojo.Mapply;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/mapplyController")
public class MapplyController {
	@Resource(name = "lxDfileService")
	private LXDfileService lxDfileService;
	@Resource(name = "mapplyService")
	private MapplyService mapplyService;

	// ** CRUD *********************************************************
	/**
	 * 过审产品列表
	 * 
	 * @param user
	 * @param response
	 */
	@RequestMapping("/filelist")
	public void fileList(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "productName") String productName,
			HttpServletResponse response) {

		if (!StringUtils.isEmpty(productName)) {
			productName = "%" + productName + "%";
		}

		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页

		Pager<Dfile> pager = lxDfileService.selectAllFromApply(pageno,
				pagesize, sort, order, productName);
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

	/**
	 * 审核列表
	 * 
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param applyid
	 * @param response
	 */
	@RequestMapping("/list")
	public void list(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "applyId") String applyid,
			HttpServletResponse response) {

		if (!StringUtils.isEmpty(applyid)) {
			applyid = "%" + applyid + "%";
		}

		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页

		Pager<Mapply> pager = mapplyService.selectAllFromCheck(pageno,
				pagesize, sort, order, applyid);
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

	/**
	 * 审核详情
	 * 
	 * @param applyId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/checkPage")
	public String checkPage(
			@RequestParam(required = false, value = "applyId") String applyId,
			ModelMap modelMap) {
		if (applyId != null) {
			Mapply mapply = mapplyService.findById(applyId);
			modelMap.put("mapply", mapply);
		}
		return "mapply_check";
	}

	/**
	 * 通过/未通过审核处理
	 * 
	 * @param applyId
	 * @param checker
	 * @param checkTag
	 * @param response
	 */
	@RequestMapping("/check")
	public void check(
			// @RequestParam(required = true, value = "checkForm") List<String>
			// List,
			@RequestParam(required = true, value = "mapplyId") String applyId,
			@RequestParam(required = false, value = "checker") String checker,
			@RequestParam(required = true, value = "checkTag") String checkTag,
			HttpServletResponse response) {
		int count = 0;		
		Mapply m = new Mapply();
		m.setApplyId(applyId);
		m.setChecker(checker);
		m.setCheckTag(checkTag);
		m.setCheckTime(new Date());
		count = mapplyService.check(m);
		try {
			PrintWriter out = response.getWriter();
			out.println(count);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/submitlist")
	public void submitlist(
			@RequestParam(required = true, value = "productIds") String productId,
			@RequestParam(required = true, value = "amounts") String amount,
			@RequestParam(required = false, value = "register") String register,
			@RequestParam(required = true, value = "remark") String remark,
			HttpServletRequest request, HttpServletResponse response) {
		String[] productIds = productId.split(",");
		String[] amounts = amount.split(",");
		int count = 0;
		Mapply m = null;
		
		for (int i = 0; i < productIds.length; i++) {
			m = new Mapply();
			String num=mapplyService.findMax();
			m.setApplyId(ErpUtils.getNumber("300", num));
			Dfile d = lxDfileService.selectFromApply(productIds[i]);
			m.setProductId(d.getProductId());
			m.setProductName(d.getProductName());
			m.setProductDescribe(d.getProductDescribe());
			m.setType(d.getType());
			m.setAmount(NumberUtils.createDouble(amounts[i]));
			m.setDesigner(d.getRegister());
			m.setRegister(register);
			m.setRegisterTime(new Date());
			m.setRemark(remark);
			count += mapplyService.add(m);
		}
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
