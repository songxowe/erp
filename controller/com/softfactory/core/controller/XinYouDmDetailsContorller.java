package com.softfactory.core.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
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
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.DmDetails;

/**
 * 产品物料组成明细Contorller
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/")
public class XinYouDmDetailsContorller {

	@Resource(name = "xinYouDmDetailsService")
	private XinYouDmDetailsService xinYouDmDetailsService;

	@RequestMapping("/xinYouDmDetailsController_list")
	public void list(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = false, value = "parentId") Integer parentId,
			@RequestParam(required = false, value = "detailsNumber") Integer detailsNumber,
			@RequestParam(required = false, value = "productId") String productId,
			@RequestParam(required = false, value = "productName") String productName,
			HttpServletResponse response) {
		if (!StringUtils.isEmpty(productId)) {
			productId = "%" + productId + "%";
		}
		if (!StringUtils.isEmpty(productName)) {
			productName = "%" + productName + "%";
		}

		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页

		Pager<DmDetails> pager = xinYouDmDetailsService.findPager(pageno,
				pagesize, sort, order, id, parentId, detailsNumber, productId,
				productName);
		JsonConfig jsonConfig = new JsonConfig();
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

	@RequestMapping("/xinYouDmDetailsController_remove")
	public void remove(
			@RequestParam(required = true, value = "ids") String ids,
			HttpServletResponse response) {
		int count = 0;
		String[] dmDetails_ids = ids.split(", ");
		for (int i = 0; i < dmDetails_ids.length; i++) {
			Integer dmDetails_id = NumberUtils.createInteger(dmDetails_ids[i]);
			count += xinYouDmDetailsService.remove(dmDetails_id);
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

	@RequestMapping("/xinYouDmDetailsController_save")
	public void save(DmDetails dmDetails, HttpServletResponse response) {
		int count = 0;
		if (dmDetails != null && dmDetails.getId() != null) {
			count = xinYouDmDetailsService.modify(dmDetails);
		} else {
			count = xinYouDmDetailsService.add(dmDetails);
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
