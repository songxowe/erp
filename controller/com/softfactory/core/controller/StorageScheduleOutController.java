package com.softfactory.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.StorageScheduleOutService;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.StorageScheduleOut;

@Controller
@RequestMapping
public class StorageScheduleOutController {
	@Resource(name = "storageScheduleOutService")
	private StorageScheduleOutService storageScheduleOutService;
	 private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 第一页面查询
	 * 
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param response
	 */
	@RequestMapping("/storageScheduleOutController")
	public void list(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			HttpServletResponse response) {

		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页
		Pager<StorageScheduleOut> pager = storageScheduleOutService.findPager(
				pageno, pagesize, sort, order);
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
	@RequestMapping("/storageScheduleOutController_findById")
	public String findById(
			@RequestParam(required = true, value = "id") Integer id,
			ModelMap modelMap) {
		if (id != null) {
			StorageScheduleOut storageScheduleOut = new StorageScheduleOut();
			storageScheduleOut = storageScheduleOutService.findDetail(id);
			List<StorageScheduleOut> list = storageScheduleOutService
					.findById(id);
			modelMap.put("list", list);
			modelMap.put("storageScheduleOut", storageScheduleOut);
		}
		return "storageScheduleOutdetail";
	}

	/**
	 * 第三页面查询
	 * 
	 * @param productId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/storageScheduleOutController_modify")
	public String modify(
			@RequestParam(required = true, value = "productId") String productId,
			ModelMap modelMap) {
		StorageScheduleOut storageScheduleOut = storageScheduleOutService
				.findBypId(productId);
		modelMap.put("storageScheduleOut", storageScheduleOut);
		modelMap.put("registerTime", sdf.format(storageScheduleOut.getRegisterTime()));
		return "storageScheduleOutupdate";
	}

	/**
	 * 最后修改字段
	 * 
	 * @param productId
	 * @return
	 */
	@RequestMapping("/storageScheduleOutController_finally")
	public String modifyfinally(
			@RequestParam(required = true, value = "productId") String productId,
			HttpServletResponse response) {
		int count = 0;
		try {
			count = storageScheduleOutService.modify(productId);
			PrintWriter out = response.getWriter();
			out.println(count);
			out.flush();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "storageSchedulequery";
	}

}
