package com.softfactory.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.XyfDfileService;
import com.softfactory.core.util.ErpUtils;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Dfile;
import com.softfactory.pojo.Dkind;

@Controller
@RequestMapping("/")
public class XyfDfileController {

	@Resource(name = "xyfDfileService")
	private XyfDfileService xyfDfileService;

	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	// 显示已过审的产品档案列表
	@RequestMapping("xyfDfileController")
	public void list(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "firstKindName") String firstKindName,
			@RequestParam(required = false, value = "secondKindName") String secondKindName,
			@RequestParam(required = false, value = "thirdKindName") String thirdKindName,
			@RequestParam(required = false, value = "type") String type,
			@RequestParam(required = false, value = "beginTime") String beginTime,
			@RequestParam(required = false, value = "endTime") String endTime,
			HttpServletResponse response, HttpServletRequest request) {
		String firstid = null;
		String secondid = null;
		String thirdid = null;
		if (firstKindName != null && firstKindName != "") {
			if (!firstKindName.equals("-1")) {
				firstid = xyfDfileService.findKindIdById(Integer
						.valueOf(firstKindName));
			}
		}
		if (secondKindName != null && secondKindName != "") {
			if (!secondKindName.equals("-1")) {
				secondid = xyfDfileService.findKindIdById(Integer
						.valueOf(secondKindName));
			}
		}
		if (thirdKindName != null && thirdKindName != "") {
			if (!thirdKindName.equals("-1")) {
				thirdid = xyfDfileService.findKindIdById(Integer
						.valueOf(thirdKindName));
			}
		}

		int pageno = (page - 1) * rows; // 开始行
		int pagesize = page * rows; // 结束行

		Date date1 = null;
		Date date2 = null;

		try {
			if (beginTime != null && beginTime != "") {
				date1 = df.parse(beginTime);
			}
			if (endTime != null && endTime != "") {
				date2 = df.parse(endTime);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		Pager<Dfile> pager = xyfDfileService.findPager(pageno, pagesize, sort,
				order, firstid, secondid, thirdid, type, date1, date2);

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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 产品档案登记
	@RequestMapping("xyfDfileController_save")
	public String save(Dfile dfile, HttpServletRequest request) {
		int id1 = Integer.parseInt(request.getParameter("firstKindName"));
		int id2 = Integer.parseInt(request.getParameter("secondKindName"));
		int id3 = Integer.parseInt(request.getParameter("thirdKindName"));
		Dkind dkind1 = xyfDfileService.findDkindById(id1);
		Dkind dkind2 = xyfDfileService.findDkindById(id2);
		Dkind dkind3 = xyfDfileService.findDkindById(id3);
		String firstKindId = dkind1.getKindId();
		String secondKindId = dkind2.getKindId();
		String thirdKindId = dkind3.getKindId();
		String firstKindName = dkind1.getKindName();
		String secondKindName = dkind2.getKindName();
		String thirdKindName = dkind3.getKindName();
		String maxProductId = xyfDfileService.findMaxProductId();
		System.out.println(maxProductId);
		Long num = Long.parseLong("000001");
		if (maxProductId != null) {
			num = Long.valueOf(maxProductId.substring(9, 15)) + 1;
		}
		String productId = "100" + firstKindId + secondKindId + thirdKindId
				+ ErpUtils.goStringl(num);
		dfile.setProductId(productId);
		dfile.setFirstKindId(firstKindId);
		dfile.setSecondKindId(secondKindId);
		dfile.setThirdKindId(thirdKindId);
		dfile.setFirstKindName(firstKindName);
		dfile.setSecondKindName(secondKindName);
		dfile.setThirdKindName(thirdKindName);
		dfile.setRegisterTime(new Date());
		dfile.setCheckTag("S001-0");
		dfile.setChangeTag("D001-0");
		dfile.setPriceChangeTag("J001-0");
		dfile.setDeleteTag("C001-0");
		dfile.setDesignModuleTag("W001-0");
		dfile.setDesignProcedureTag("G001-0");
		dfile.setDesignCellTag("K001-0");
		xyfDfileService.add(dfile);

		return "xyfdfilesavesuccess";

	}

	// 产品档案登记表单验证
	@RequestMapping("xyfDfileController_validate")
	public void validate(
			@RequestParam(required = false, value = "productName") String productName,
			HttpServletResponse response) {
		boolean flag = false;
		flag = xyfDfileService.productNameIsExist(productName);
		if (flag) {
			try {
				PrintWriter out = response.getWriter();
				out.println(flag);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 显示待审核（包括未审核和未过审）的产品档案列表
			@RequestMapping("xyfDfileController_checkList")
			public void checkList(
					@RequestParam(required = true, value = "page") Integer page,
					@RequestParam(required = true, value = "rows") Integer rows,
					@RequestParam(required = true, value = "sort") String sort,
					@RequestParam(required = true, value = "order") String order,
					@RequestParam(required = false, value = "firstKindName") String firstKindName,
					@RequestParam(required = false, value = "secondKindName") String secondKindName,
					@RequestParam(required = false, value = "thirdKindName") String thirdKindName,
					@RequestParam(required = false, value = "type") String type,
					@RequestParam(required = false, value = "beginTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginTime,
					@RequestParam(required = false, value = "endTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime,
					HttpServletResponse response) {

				int pageno = (page - 1) * rows; // 开始行
				int pagesize = page * rows; // 结束行

				Pager<Dfile> pager = xyfDfileService.findUncheckedPager(pageno,
						pagesize, sort, order, firstKindName, secondKindName,
						thirdKindName, type, beginTime, endTime);

				JsonConfig jsonConfig = new JsonConfig();
				try {
					PrintWriter out = response.getWriter();
					JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
							jsonConfig);
					out.println(json.toString());
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	
	

	// 产品档案登记复核，跳转到审核页面
	@RequestMapping("xyfDfileController_check")
	public String check(
			@RequestParam(required = true, value = "id") Integer id,
			ModelMap modelMap) {
		List<Dkind> dlist = xyfDfileService.findfirst();
		Dfile dfile = xyfDfileService.findById(id);
		String regisTime = df.format(dfile.getRegisterTime());
		if (regisTime != null && regisTime != "") {
			modelMap.put("regisTime", regisTime);
		}
		modelMap.put("dfile", dfile);
		modelMap.put("id", id);
		modelMap.put("dlist", dlist);
		return "xyfdfilecheck";
	}

	// 产品档案登记复核通过，跳转到审核列表页面
	@RequestMapping("xyfDfileController_checked")
	public String checked(Dfile dfile, HttpServletRequest request) {
		// System.out.println("ID:"+dfile.getId()+" 产品编号："+dfile.getProductId()+" 产品名称："+dfile.getProductName());
		String regex = "^[0-9]*$";
		if (regex.matches(request.getParameter("secondKindName"))) {
			System.out.println("哈哈哈");
			int id1 = Integer.parseInt(request.getParameter("firstKindName"));
			int id2 = Integer.parseInt(request.getParameter("secondKindName"));
			int id3 = Integer.parseInt(request.getParameter("thirdKindName"));
			Dkind dkind1 = xyfDfileService.findDkindById(id1);
			Dkind dkind2 = xyfDfileService.findDkindById(id2);
			Dkind dkind3 = xyfDfileService.findDkindById(id3);
			String firstKindId = dkind1.getKindId();
			String secondKindId = dkind2.getKindId();
			String thirdKindId = dkind3.getKindId();
			String firstKindName = dkind1.getKindName();
			String secondKindName = dkind2.getKindName();
			String thirdKindName = dkind3.getKindName();
			dfile.setFirstKindId(firstKindId);
			dfile.setSecondKindId(secondKindId);
			dfile.setThirdKindId(thirdKindId);
			dfile.setFirstKindName(firstKindName);
			dfile.setSecondKindName(secondKindName);
			dfile.setThirdKindName(thirdKindName);
		}
		dfile.setFirstKindId(xyfDfileService.findByName(
				request.getParameter("firstKindName")).getKindId());
		dfile.setSecondKindId(xyfDfileService.findByName(
				request.getParameter("secondKindName")).getKindId());
		dfile.setThirdKindId(xyfDfileService.findByName(
				request.getParameter("thirdKindName")).getKindId());
		dfile.setCheckTime(new Date());
		dfile.setCheckTag("S001-1");
		dfile.setChangeTag("D001-0");
		dfile.setDeleteTag("C001-0");
		xyfDfileService.modify(dfile);
		return "xyfdfilechecklist";
	}

	@RequestMapping("xyfDfileController_findDfile")
	public String findDfile(
			@RequestParam(required = true, value = "id") Integer id,
			ModelMap modelMap) {
		Dfile dfile = xyfDfileService.findById(id);
		modelMap.put("dfile", dfile);
		modelMap.put("id", id);
		return "xyfdfiledetails";
	}
	
	// 产品档案变更，跳转到档案变更页面
		@RequestMapping("xyfDfileController_change")
		public String change(
				@RequestParam(required = true, value = "id") Integer id,
				ModelMap modelMap) {
			List<Dkind> dlist = xyfDfileService.findfirst();
			Dfile dfile = xyfDfileService.findById(id);
			String regisTime = df.format(dfile.getRegisterTime());
			if (regisTime != null && regisTime != "") {
				modelMap.put("regisTime", regisTime);
			}
			modelMap.put("dfile", dfile);
			modelMap.put("id", id);
			modelMap.put("dlist", dlist);
			return "xyfdfilechange";
		}
		
	@RequestMapping("xyfDfileController_changed")
	public String changed(Dfile dfile, HttpServletRequest request){
		String regex = "^[0-9]*$";
		if (regex.matches(request.getParameter("secondKindName"))) {
			int id1 = Integer.parseInt(request.getParameter("firstKindName"));
			int id2 = Integer.parseInt(request.getParameter("secondKindName"));
			int id3 = Integer.parseInt(request.getParameter("thirdKindName"));
			Dkind dkind1 = xyfDfileService.findDkindById(id1);
			Dkind dkind2 = xyfDfileService.findDkindById(id2);
			Dkind dkind3 = xyfDfileService.findDkindById(id3);
			String firstKindId = dkind1.getKindId();
			String secondKindId = dkind2.getKindId();
			String thirdKindId = dkind3.getKindId();
			String firstKindName = dkind1.getKindName();
			String secondKindName = dkind2.getKindName();
			String thirdKindName = dkind3.getKindName();
			dfile.setFirstKindId(firstKindId);
			dfile.setSecondKindId(secondKindId);
			dfile.setThirdKindId(thirdKindId);
			dfile.setFirstKindName(firstKindName);
			dfile.setSecondKindName(secondKindName);
			dfile.setThirdKindName(thirdKindName);
		}
		dfile.setFirstKindId(xyfDfileService.findByName(
				request.getParameter("firstKindName")).getKindId());
		dfile.setSecondKindId(xyfDfileService.findByName(
				request.getParameter("secondKindName")).getKindId());
		dfile.setThirdKindId(xyfDfileService.findByName(
				request.getParameter("thirdKindName")).getKindId());
		dfile.setChangeTime(new Date());
		dfile.setCheckTag("S001-0");
		dfile.setChangeTag("D001-1");
		dfile.setDeleteTag("C001-0");
		xyfDfileService.modify(dfile);
		return "xyfdfilechangesuccess";
	}
	
	@RequestMapping("xyfDfileController_delete")
	public String delete(
			@RequestParam(required = true, value = "id") Integer id) {
		Dfile dfile = xyfDfileService.findById(id);
		dfile.setDeleteTag("C001-1");
		xyfDfileService.modify(dfile);
		return "xyfdfiledelete";
	}
	
	// 显示可恢复的产品档案列表
	@RequestMapping("xyfDfileController_recoveryList")
	public void recoveryList(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			HttpServletResponse response) {

		int pageno = (page - 1) * rows; // 开始行
		int pagesize = page * rows; // 结束行

		Pager<Dfile> pager = xyfDfileService.findRecoveryPager(pageno,
				pagesize, sort, order);

		JsonConfig jsonConfig = new JsonConfig();
		try {
			PrintWriter out = response.getWriter();
			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("xyfDfileController_recovery")
	public String recovery(
			@RequestParam(required = true, value = "id") Integer id) {
		Dfile dfile = xyfDfileService.findById(id);
		dfile.setCheckTag("S001-0");
		dfile.setDeleteTag("C001-0");
		xyfDfileService.modify(dfile);
		return "xyfdfilerecovered";
	}
	
	@RequestMapping("xyfDfileController_realDelete")
	public String realDelete(
			@RequestParam(required = true, value = "id") Integer id){
		xyfDfileService.remove(id);
		return "xyfdfilerealdelete";
		
	}

	@RequestMapping("/xyfDfileController_findAll")
	public void findAll(
			@RequestParam(required = false, value = "pid") Integer pid,
			HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Dkind> list = xyfDfileService.findAll(pid);
		out.println("<types>");
		out.println("<type>");
		out.println("<id>-1</id>");
		out.println("<name>请选择</name>");
		out.println("</type>");
		if (null != list && list.size() > 0) {
			for (Dkind d : list) {
				out.println("<type>");
				out.println("<id>" + d.getId() + "</id>");
				out.println("<name>" + d.getKindName() + "</name>");
				out.println("</type>");

			}
		}
		out.println("</types>");
		out.flush();
		out.close();
	}

	@RequestMapping("/xyfDfileController_findAl")
	public void findAl(
			@RequestParam(required = false, value = "name") String name,
			HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Dkind> list = xyfDfileService.findAll(xyfDfileService.findByName(
				name).getId());
		out.println("<types>");
		out.println("<type>");
		out.println("<id>-1</id>");
		out.println("<name>请选择</name>");
		out.println("</type>");
		if (null != list && list.size() > 0) {
			for (Dkind d : list) {
				out.println("<type>");
				out.println("<id>" + d.getId() + "</id>");
				out.println("<name>" + d.getKindName() + "</name>");
				out.println("</type>");

			}
		}
		out.println("</types>");
		out.flush();
		out.close();
	}

}
