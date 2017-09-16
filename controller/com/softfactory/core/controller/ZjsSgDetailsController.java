package com.softfactory.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.ZjsSgDetailsService;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.SgDetails;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class ZjsSgDetailsController {

	@Resource(name = "zjsSgDetailsService")
	private ZjsSgDetailsService zjsSgDetailsService;

	@RequestMapping("/zjsSgDetailsController")
	public void list(@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "parentId") String parentId, HttpServletResponse response) {

		try {
			if (!StringUtils.isEmpty(parentId)) {
				parentId = "%" + parentId.toUpperCase() + "%";
			}
			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;

     		Pager<SgDetails> pager = zjsSgDetailsService.findPager(pageno, pagesize, sort, order, parentId);

			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

 			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);

			PrintWriter out = response.getWriter();
 			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/zjsSgDetailsController_save")
	public void save(SgDetails sgDetails, HttpServletResponse response) {
		int count = 0;
			count = zjsSgDetailsService.add(sgDetails);
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
