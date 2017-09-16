package com.softfactory.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.LiDaWeiScellService;
import com.softfactory.core.service.ZjsSgDetailsService;
import com.softfactory.core.service.ZjsSgatherService;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Scell;
import com.softfactory.pojo.SgDetails;
import com.softfactory.pojo.Sgather;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/")
public class ZjsSgatherController {
	@Resource(name = "zjsSgatherService")
	private ZjsSgatherService zjsSgatherService;
	@Resource(name = "zjsSgDetailsService")
	private ZjsSgDetailsService zjsSgDetailsService;
	@Resource(name = "scellSerice")
	private LiDaWeiScellService scellSerice;
	
	@RequestMapping("/zjsSgatherController_list1")
	public void list1(@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "gatherId") String gatherId, HttpServletResponse response,
			@RequestParam(required = false, value = "storer") String storer) {

		try {
			if (!StringUtils.isEmpty(gatherId)) {
				gatherId = "%" + gatherId.toUpperCase() + "%";
			}
			if (!StringUtils.isEmpty(storer)) {
				storer = "%" + storer.toUpperCase() + "%";
			}

			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;

			Pager<Sgather> pager = zjsSgatherService.findOnePager(pageno, pagesize, sort, order, gatherId);

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
	@RequestMapping("/zjsSgatherController_list2")
	public void list2(@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "gatherId") String gatherId, HttpServletResponse response,
			@RequestParam(required = false, value = "storer") String storer) {

		try {
			if (!StringUtils.isEmpty(gatherId)) {
				gatherId = "%" + gatherId.toUpperCase() + "%";
			}
			if (!StringUtils.isEmpty(storer)) {
				storer = "%" + storer.toUpperCase() + "%";
			}

			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;

			Pager<Sgather> pager = zjsSgatherService.findTwoPager(pageno, pagesize, sort, order, gatherId);

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
	@RequestMapping("/zjsSgatherController_list3")
	public void list3(@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "gatherId") String gatherId, HttpServletResponse response,
			@RequestParam(required = false, value = "storer") String storer) {

		try {
			if (!StringUtils.isEmpty(gatherId)) {
				gatherId = "%" + gatherId.toUpperCase() + "%";
			}
			if (!StringUtils.isEmpty(storer)) {
				storer = "%" + storer.toUpperCase() + "%";
			}

			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;

			Pager<Sgather> pager = zjsSgatherService.findThreePager(pageno, pagesize, sort, order, gatherId);

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

	@RequestMapping("/zjsSgatherController_save")
	public void save(Sgather sgather, HttpServletResponse response) {
		int count = 0;
		if (sgather != null && sgather.getId() != null) {
			count = zjsSgatherService.modify(sgather);
		} else {
			count = zjsSgatherService.add(sgather);
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

	@RequestMapping("/zjsSgDetailsController_view")
	public String view(@RequestParam(required = true, value = "id") String id, ModelMap modelMap) {
		System.out.println("审核1");
		if (id != null) {
			SgDetails sgd = zjsSgDetailsService.findById(id);
			Sgather sga = zjsSgatherService.findById(id);
			System.out.println(sgd.getProductName()+" -----------------"+sgd.getProductId());
			String i = sgd.getProductId();
			Scell sce = zjsSgatherService.findscellById(i);
			modelMap.put("sce",sce);
			modelMap.put("sgd",sgd);
			modelMap.put("sga",sga);
			System.out.println("审核2");
			
		}
		return "sgatherview";
	}

	@RequestMapping("/zjsSgDetailsController_fuheview")
	public String fuheview(@RequestParam(required = true, value = "id") String id, ModelMap modelMap) {
		System.out.println("审核1");
		if (id != null) {
			SgDetails sgd = zjsSgDetailsService.findById(id);
			Sgather sga = zjsSgatherService.findById(id);
			String i = sgd.getProductId();
			Scell sce = zjsSgatherService.findscellById(i);
			modelMap.put("sce",sce);
			System.out.println(sga.getNowAmounta()+" -----------------"+sga.getRegister());
			modelMap.put("sgd",sgd);
			modelMap.put("sga",sga);
			System.out.println("审核2");
		}
		return "sgatherfuheview";
	}
	
	@RequestMapping("zjsSgDetailsController_check")
	public void check(@RequestParam(required = false, value = "parentId") Integer parentId,
			@RequestParam(required = false, value = "checker") String checker,
			@RequestParam(required = false, value = "checkTag") String checkTag,
			@RequestParam(required = false, value = "checkTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date checkTime,
			HttpServletResponse response) {
		int count = 0;
		Sgather sg = new Sgather();
		sg.setId(parentId);
		sg.setChecker(checker);
		sg.setCheckTag(checkTag);
		sg.setCheckTime(checkTime);
		count = zjsSgatherService.modify(sg);
		try {
			PrintWriter out = response.getWriter();
			out.println(count);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("zjsSgDetailsController_modifySotreTag")
	public String modifyStoreTag(
			@RequestParam(required = false, value = "gatherId") String gatherId,
			@RequestParam(required = false, value = "register") String register,
			@RequestParam(required = false, value = "nowAmounta") Integer nowAmounta){
		zjsSgatherService.modifyStoreTag(gatherId, register, nowAmounta);
		
		return "dengjisuccess";
	}
	
	@RequestMapping("zjsSgDetailsController_modifyCheckTag")
	public String modifyCheckTag(String gatherId){
		zjsSgatherService.modifyCheckTag(gatherId);
		
		return "fuhesuccess";
	}

}
