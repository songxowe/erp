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

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.XinYouDmDetailsService;
import com.softfactory.core.service.XinYouDmoduleService;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.DmDetails;
import com.softfactory.pojo.Dmodule;

/**
 * 产品物料组成Controller
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/")
public class XinYouDmoduleController {
	@Resource(name = "xinYouDmoduleService")
	private XinYouDmoduleService xinYouDmoduleService;
	@Resource(name = "xinYouDmDetailsService")
	private XinYouDmDetailsService xinYouDmDetailsService;

	@RequestMapping("/xinYouDmoduleController_list")
	public void listDmodule(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = false, value = "designId") String designId,
			@RequestParam(required = false, value = "productId") String productId,
			@RequestParam(required = false, value = "productName") String productName,
			@RequestParam(required = false, value = "firstKindName") String firstKindName,
			@RequestParam(required = false, value = "secondKindName") String secondKindName,
			@RequestParam(required = false, value = "thirdKindName") String thirdKindName,
			@RequestParam(required = false, value = "designer") String designer,
			@RequestParam(required = false, value = "register") String register,
			@RequestParam(required = false, value = "registerTime") Date registerTime,
			@RequestParam(required = false, value = "checker") String checker,
			@RequestParam(required = false, value = "changer") String changer,
			@RequestParam(required = false, value = "checkTag") String checkTag,
			@RequestParam(required = false, value = "changeTag") String changeTag,
			HttpServletResponse response) {
		if (!StringUtils.isEmpty(productName)) {
			productName = "%" + productName + "%";
		}
		if (!StringUtils.isEmpty(designId)) {
			designId = "%" + designId + "%";
		}
		if (!StringUtils.isEmpty(productId)) {
			productId = "%" + productId + "%";
		}
		if (!StringUtils.isEmpty(firstKindName)) {
			firstKindName = "%" + firstKindName + "%";
		}
		if (!StringUtils.isEmpty(secondKindName)) {
			secondKindName = "%" + secondKindName + "%";
		}
		if (!StringUtils.isEmpty(thirdKindName)) {
			thirdKindName = "%" + thirdKindName + "%";
		}
		if (!StringUtils.isEmpty(designer)) {
			designer = "%" + designer + "%";
		}
		if (!StringUtils.isEmpty(register)) {
			register = "%" + register + "%";
		}
		if (!StringUtils.isEmpty(checker)) {
			checker = "%" + checker + "%";
		}
		if (!StringUtils.isEmpty(changer)) {
			changer = "%" + changer + "%";
		}
		if (!StringUtils.isEmpty(checkTag)) {
			checkTag = "%" + checkTag + "%";
		}
		if (!StringUtils.isEmpty(changeTag)) {
			changeTag = "%" + changeTag + "%";
		}

		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页

		Pager<Dmodule> pager = xinYouDmoduleService.findPager(pageno, pagesize,
				sort, order, id, designId, productId, productName,
				firstKindName, secondKindName, thirdKindName, designer,
				register, registerTime, checker, changer, checkTag, changeTag);
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
	 * 删除
	 * 
	 * @param ids
	 * @param response
	 */
	@RequestMapping("/xinYouDmoduleController_remove")
	public void remove(
			@RequestParam(required = true, value = "ids") String ids,
			HttpServletResponse response) {
		int count = 0;
		String[] dmodule_ids = ids.split(", ");
		for (int i = 0; i < dmodule_ids.length; i++) {
			Integer dmodule_id = NumberUtils.createInteger(dmodule_ids[i]);
			count += xinYouDmoduleService.remove(dmodule_id);
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

	/**
	 * 保存
	 * 
	 * @param dmodule
	 * @param response
	 */
	@RequestMapping("/xinYouDmoduleController_save")
	public void save(HttpServletRequest request, HttpServletResponse response) {
		int count = 0;
		String prodcutId = request.getParameter("productId2");
		String[] productId1 = request.getParameterValues("productId");
		String[] subtotal = request.getParameterValues("amount");
		String remark = request.getParameter("remark");
		String[] productDescribe = request
				.getParameterValues("productDescribe");
		String designer = request.getParameter("designer");
		count = xinYouDmoduleService.add(prodcutId, productId1, subtotal,
				remark, productDescribe, designer);

		try {
			PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>alert('设计成功"
					+ "！');parent.location.reload();</script>");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 物料组成设计单审核查询列表
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/dmoduleControllerlist")
	public String dmoduleControllerlist(Integer id, HttpServletRequest request) {
		double o = 0.00;
		Dmodule dmodule = xinYouDmoduleService.findById(id);
		request.getSession().setAttribute("dmodule", dmodule);
		List<DmDetails> dmDetails = xinYouDmDetailsService.findById(id);
		request.getSession().setAttribute("dmDetails", dmDetails);
		for (DmDetails dmDetails2 : dmDetails) {
			o += dmDetails2.getSubtotal();
		}
		request.setAttribute("subt", o);
		return "dmodule12";

	}

	/**
	 * 物料组成设计单审核
	 * 
	 * @param id
	 * @param register
	 * @param checkTag
	 * @param costPriceSum
	 * @param response
	 */
	@RequestMapping("/dmoduleControllermodify")
	public void modify1(
			@RequestParam(required = true, value = "id") Integer id,
			@RequestParam(required = true, value = "register") String register,
			@RequestParam(required = true, value = "checkTag") String checkTag,
			@RequestParam(required = true, value = "costPriceSum") Double costPriceSum,
			HttpServletResponse response) {
		Date checkTime = new Date();
		xinYouDmoduleService.modify1(id, costPriceSum, checkTag, register,
				checkTime);
		try {
			PrintWriter out = response.getWriter();
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 物料组成设计单查询
	 * 
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param id
	 * @param designId
	 * @param productId
	 * @param productName
	 * @param response
	 */
	@RequestMapping("/xinYouDmoduleControllerlist2")
	public void xinYouDmoduleControllerlist2(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = false, value = "designId") String designId,
			@RequestParam(required = false, value = "productId") String productId,
			@RequestParam(required = false, value = "productName") String productName,
			@RequestParam(required = false, value = "firstKindName") String firstKindName,
			@RequestParam(required = false, value = "secondKindName") String secondKindName,
			@RequestParam(required = false, value = "thirdKindName") String thirdKindName,
			@RequestParam(required = false, value = "designer") String designer,
			@RequestParam(required = false, value = "register") String register,
			@RequestParam(required = false, value = "registerTime") Date registerTime,
			@RequestParam(required = false, value = "checker") String checker,
			@RequestParam(required = false, value = "changer") String changer,
			@RequestParam(required = false, value = "checkTag") String checkTag,
			@RequestParam(required = false, value = "changeTag") String changeTag,
			HttpServletResponse response) {
		if (!StringUtils.isEmpty(productName)) {
			productName = "%" + productName + "%";
		}
		if (!StringUtils.isEmpty(designId)) {
			designId = "%" + designId + "%";
		}
		if (!StringUtils.isEmpty(productId)) {
			productId = "%" + productId + "%";
		}
		if (!StringUtils.isEmpty(firstKindName)) {
			firstKindName = "%" + firstKindName + "%";
		}
		if (!StringUtils.isEmpty(secondKindName)) {
			secondKindName = "%" + secondKindName + "%";
		}
		if (!StringUtils.isEmpty(thirdKindName)) {
			thirdKindName = "%" + thirdKindName + "%";
		}
		if (!StringUtils.isEmpty(designer)) {
			designer = "%" + designer + "%";
		}
		if (!StringUtils.isEmpty(register)) {
			register = "%" + register + "%";
		}
		if (!StringUtils.isEmpty(checker)) {
			checker = "%" + checker + "%";
		}
		if (!StringUtils.isEmpty(changer)) {
			changer = "%" + changer + "%";
		}
		if (!StringUtils.isEmpty(checkTag)) {
			checkTag = "%" + checkTag + "%";
		}
		if (!StringUtils.isEmpty(changeTag)) {
			changeTag = "%" + changeTag + "%";
		}
		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页

		Pager<Dmodule> pager = xinYouDmoduleService.findPager2(pageno,
				pagesize, sort, order, id, designId, productId, productName,
				firstKindName, secondKindName, thirdKindName, designer,
				register, registerTime, checker, changer, checkTag, changeTag);
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
	 * 查看详单
	 */
	@RequestMapping("/dmoduleControllernotice")
	public String dmoduleControllernotice(Integer id, HttpServletRequest request) {
		double o = 0.00;
		Dmodule dmodule = xinYouDmoduleService.findById(id);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		request.getSession().setAttribute("dmodule1", dmodule);
		List<DmDetails> dmDetails = xinYouDmDetailsService.findById(id);
		request.getSession().setAttribute("dmDetails1", dmDetails);
		for (DmDetails dmDetails2 : dmDetails) {
			o += dmDetails2.getSubtotal();
		}
		request.setAttribute("subt", o);
		return "dmodule22";

	}

	/**
	 * 物料组成设计单变更
	 * 
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param id
	 * @param designId
	 * @param productId
	 * @param productName
	 * @param response
	 */
	@RequestMapping("/xinYouDmoduleControllerlist3")
	public void xinYouDmoduleControllerlist3(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = false, value = "designId") String designId,
			@RequestParam(required = false, value = "productId") String productId,
			@RequestParam(required = false, value = "productName") String productName,
			@RequestParam(required = false, value = "firstKindName") String firstKindName,
			@RequestParam(required = false, value = "secondKindName") String secondKindName,
			@RequestParam(required = false, value = "thirdKindName") String thirdKindName,
			@RequestParam(required = false, value = "designer") String designer,
			@RequestParam(required = false, value = "register") String register,
			@RequestParam(required = false, value = "registerTime") Date registerTime,
			@RequestParam(required = false, value = "checker") String checker,
			@RequestParam(required = false, value = "changer") String changer,
			@RequestParam(required = false, value = "checkTag") String checkTag,
			@RequestParam(required = false, value = "changeTag") String changeTag,
			HttpServletResponse response) {
		if (!StringUtils.isEmpty(productName)) {
			productName = "%" + productName + "%";
		}
		if (!StringUtils.isEmpty(designId)) {
			designId = "%" + designId + "%";
		}
		if (!StringUtils.isEmpty(productId)) {
			productId = "%" + productId + "%";
		}
		if (!StringUtils.isEmpty(firstKindName)) {
			firstKindName = "%" + firstKindName + "%";
		}
		if (!StringUtils.isEmpty(secondKindName)) {
			secondKindName = "%" + secondKindName + "%";
		}
		if (!StringUtils.isEmpty(thirdKindName)) {
			thirdKindName = "%" + thirdKindName + "%";
		}
		if (!StringUtils.isEmpty(designer)) {
			designer = "%" + designer + "%";
		}
		if (!StringUtils.isEmpty(register)) {
			register = "%" + register + "%";
		}
		if (!StringUtils.isEmpty(checker)) {
			checker = "%" + checker + "%";
		}
		if (!StringUtils.isEmpty(changer)) {
			changer = "%" + changer + "%";
		}
		if (!StringUtils.isEmpty(checkTag)) {
			checkTag = "%" + checkTag + "%";
		}
		if (!StringUtils.isEmpty(changeTag)) {
			changeTag = "%" + changeTag + "%";
		}
		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页

		Pager<Dmodule> pager = xinYouDmoduleService.findPager3(pageno,
				pagesize, sort, order, id, designId, productId, productName,
				firstKindName, secondKindName, thirdKindName, designer,
				register, registerTime, checker, changer, checkTag, changeTag);
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
	 * 根据设计单号修改物料设计状态
	 */
	@RequestMapping("/UpdateState")
	public void updateState1(@RequestParam("checkTag") String checkTag,
			@RequestParam("checker") String checker,
			@RequestParam("designId") String designId,
			HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String checkTag1 = null;
		try {
			xinYouDmoduleService.UpdateState1(checker, checkTag, designId);
			if (checkTag.equals("S001-1")) {
				checkTag1 = "审核通过";
			} else {
				checkTag1 = "审核不通过";
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		out.print("<script language='javascript'>alert('" + checkTag1
				+ "！');parent.location.reload();</script>");
		out.flush();
		out.close();
	}
}
