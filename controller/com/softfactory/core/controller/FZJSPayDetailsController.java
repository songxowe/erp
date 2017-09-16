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

import com.softfactory.core.service.FZJSPayDetailsServisce;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.SPayDetails;

/**
 * 入库明细控制器
 * @author Administrator
 *
 */
@Controller
public class FZJSPayDetailsController {
	  @Resource(name = "fzjspaydetailsServisce")
	  private FZJSPayDetailsServisce fzjspaydetailsServisce;

	  @RequestMapping("/fzjspaydetailsController")
	  public void list(@RequestParam(required = true, value = "page") Integer page,
	      @RequestParam(required = true, value = "rows") Integer rows,
	      @RequestParam(required = true, value = "sort") String sort,
	      @RequestParam(required = true, value = "order") String order,
	      @RequestParam(required = false, value = "productId") String productId, HttpServletResponse response) {

	    try {
	      if (!StringUtils.isEmpty(productId)) {
	    	  productId = "%" + productId.toUpperCase() + "%";
	      }

	      Integer pageno = (page - 1) * rows;
	      Integer pagesize = page * rows;

	      Pager<SPayDetails> pager = fzjspaydetailsServisce.findPager(pageno, pagesize, sort, order, productId);

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


	  @RequestMapping("/fzjspaydetailsController_save")
	  public void save(SPayDetails spaydetails, HttpServletResponse response) {
	    int count = 0;
	    
	      count = fzjspaydetailsServisce.add(spaydetails);
	    

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
