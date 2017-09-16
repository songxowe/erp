package com.softfactory.core.controller;

import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.ManufactureService;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Manufacture;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/")
public class ManufactureController {

	@Resource(name = "manufactureService")
	private ManufactureService manufactureService;
	
	@RequestMapping("/manufactureController")
	public void list(@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = false, value = "productName") String productName, HttpServletResponse response) {

		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页
		Pager<Manufacture> pager = manufactureService.findPager(pageno, pagesize, sort, order, id,productName);
		JsonConfig jsonConfig = new JsonConfig();
		try {
			PrintWriter out = response.getWriter();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
