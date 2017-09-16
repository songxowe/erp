package com.softfactory.core.controller;

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

import com.softfactory.core.service.ScMdpDetailsService;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MdpDetails;

/**
 * 工序物料设计单显示处理器
 * @author shengchen
 *
 */
@Controller
@RequestMapping("/details")
public class ScMdpDetailsController {
	@Resource(name = "mdpDetailsService")
	private ScMdpDetailsService mdpDetailsService;
	
	@RequestMapping("/mdpDetailsController")
	public void list(@RequestParam(required = true, value = "page") Integer page,
		      @RequestParam(required = true, value = "rows") Integer rows,
		      @RequestParam(required = true, value = "sort") String sort,
		      @RequestParam(required = true, value = "order") String order,
		      @RequestParam(required = true, value = "designId") String designId,
		      @RequestParam(required = false, value = "procedureName") String procedureName, HttpServletResponse response) {

		    try {
		      if (!StringUtils.isEmpty(procedureName)) {
		    	  procedureName = "%" + procedureName.toUpperCase() + "%";
		      }

		      Integer pageno = (page - 1) * rows;
		      Integer pagesize = page * rows;

		      Pager<MdpDetails> pager = mdpDetailsService.findPager(pageno, pagesize, sort, order, procedureName, designId);

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
}
