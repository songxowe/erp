package com.softfactory.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.HZJSPayDetailsServisce;
import com.softfactory.core.service.HZJSPayServisce;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.SPay;
import com.softfactory.pojo.SPayDetails;

/**
 * 入库控制器
 * 
 * @author Administrator
 * 
 */
@Controller
public class HZJSPayController {
	@Resource(name = "hzjspayService")
	private HZJSPayServisce hzjspayService;

	@Resource(name = "hzjspaydetailsServisce")
	private HZJSPayDetailsServisce hzjspaydetailsServisce;

	/**
	 * 审核分页
	 * 
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param payId
	 * @param response
	 */
	@RequestMapping("hzjspayController")
	public void list(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "payId") String payId,
			HttpServletResponse response) {

		try {
			if (!StringUtils.isEmpty(payId)) {
				payId = "%" + payId.toUpperCase() + "%";
			}

			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;

			Pager<SPay> pager = hzjspayService.findPager(pageno, pagesize,
					sort, order, payId);

			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class,
					new JsonDateValueProcessor());

			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);

			PrintWriter out = response.getWriter();

			out.println(json.toString());
			out.flush();
			out.close();
			System.out.println("查询");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("hzjspayController_save")
	public void save(SPay spay, HttpServletResponse response) {
		int count = 0;
		if (spay != null && spay.getPayId() != null) {
			count = hzjspayService.modify(spay);
		} else {
			count = hzjspayService.add(spay);
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
	 * 审核弹出明细窗口
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("hzjspayController_view")
	public String view(@RequestParam(required = true, value = "id") Integer id,
			ModelMap modelMap) {
		System.out.println("审核进来了");
		if (id != null) {
			List<SPayDetails> spaydetails2 = hzjspaydetailsServisce
					.findById(id);
			SPay spay = hzjspayService.findById(id);
			modelMap.put("spay", spay);
			modelMap.put("spaydetails2", spaydetails2);

			System.out.println("审核出去了");
		}
		return "hzjSPayDetailsview";
	}

	/**
	 * 审核确认
	 * 
	 * @param payId
	 * @param checker
	 * @param checkTag
	 * @param remark
	 * @param response
	 */
	@RequestMapping("hzjspayController_check")
	public void check(
			@RequestParam(required = false, value = "payId") String payId,
			@RequestParam(required = false, value = "checker") String checker,
			@RequestParam(required = false, value = "checkTag") String checkTag,
			@RequestParam(required = false, value = "remark") String remark,
			HttpServletResponse response) {
		System.out.println("确认进来了");
		int count = 0;
		SPay s = new SPay();
		s.setPayId(payId);
		s.setChecker(checker);
		s.setCheckTag(checkTag);
		s.setCheckTime(new Date());
		s.setRemark(remark);
		count = hzjspayService.modify(s);
		System.out.println("确认出去了");
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
	 * 登记查询
	 * 
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param payId
	 * @param response
	 */
	@RequestMapping("hzjspayController_query")
	public void list2(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "payId") String payId,
			HttpServletResponse response) {

		try {
			if (!StringUtils.isEmpty(payId)) {
				payId = "%" + payId.toUpperCase() + "%";
			}

			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;

			Pager<SPay> pager = hzjspayService.findPager2(pageno, pagesize,
					sort, order, payId);

			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class,
					new JsonDateValueProcessor());

			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);

			PrintWriter out = response.getWriter();

			out.println(json.toString());
			out.flush();
			out.close();
			System.out.println("查询");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
