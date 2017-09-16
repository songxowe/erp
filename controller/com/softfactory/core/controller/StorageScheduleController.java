package com.softfactory.core.controller;

import java.io.PrintWriter;
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

import com.softfactory.core.service.StorageScheduleService;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Scell;
import com.softfactory.pojo.StorageSchedule;

@Controller
@RequestMapping
public class StorageScheduleController {
	@Resource(name = "storageScheduleService")
	private StorageScheduleService storageScheduleService;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@RequestMapping("/storageScheduleController")
	public void list(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			HttpServletResponse response) {

		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页
		Pager<StorageSchedule> pager = storageScheduleService.findPager(pageno,
				pagesize, sort, order);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		try {
			response.setCharacterEncoding("UTF-8");
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
	 * 第二页面
	 */
	@RequestMapping("/storageScheduleController_findById")
	public String findById(
			@RequestParam(required = true, value = "id") Integer id,
			ModelMap modelMap) {
		if (id != null) {
			StorageSchedule storageSchedule = new StorageSchedule();
			storageSchedule = storageScheduleService.findDetail(id);
			List<StorageSchedule> list = storageScheduleService.findById(id);
			modelMap.put("list", list);
			modelMap.put("storageSchedule", storageSchedule);
		}
		return "storageScheduledetail";
	}

	/*
	 * 第2.1页面
	 */

	@RequestMapping("/storageScheduleController_modify")
	public String modify(
			@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = true, value = "productId") String productId,
			ModelMap modelMap, HttpServletRequest request) {
		StorageSchedule storageSchedule = storageScheduleService
				.findBypId(productId);
		modelMap.put("storageSchedule", storageSchedule);
		modelMap.put("registerTime",
				sdf.format(storageSchedule.getRegisterTime()));
		request.getSession().setAttribute("payId",
				request.getParameter("payId"));
		modelMap.put("sid", id);
		return "storageScheduleupdate";
	}

	@SuppressWarnings("unused")
	@RequestMapping("/storageScheduleController_finally")
	public String modifyfinally(
			@RequestParam(required = true, value = "productId") String productId,
			@RequestParam(required = false, value = "sid") Integer sid,@RequestParam(required=false,value="demandAmountb") Integer demandAmountb,ModelMap modelMap,
			HttpServletRequest request) {
		StorageSchedule storageSchedule = storageScheduleService
				.findBypId(productId);
		System.out.println(productId);
		storageScheduleService.modify(productId);
		List<StorageSchedule> list = storageScheduleService.findById(sid);
		boolean is = true;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPayTag() == "K002-1") {
				list.remove(i);
			}
		}
		if(list.size()==0){
			storageScheduleService.modifys(sid);
		 	return  "storageSchedulequery"; 
		}
		modelMap.put("list", list);
		modelMap.put("sid", sid);
		modelMap.put("storageSchedule", storageSchedule);
		request.getSession().setAttribute("payId",
				request.getParameter("payId"));
		return "storageScheduledetail";
	}
}
