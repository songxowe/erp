package com.softfactory.core.controller;

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

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.LbQueryService;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Manufacture;
import com.softfactory.pojo.MpModule;
import com.softfactory.pojo.Mprocedure;
import com.softfactory.pojo.QueryResult;

@Controller
public class LbQueryController {

	@Resource(name = "lbQueryService")
	private LbQueryService lbQueryService;
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 1登记跳转页面列表
	 * @throws ParseException 
	 * */
	@RequestMapping("/lbQueryController")
	public void worklist(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "manufactureProcedureTag") String manufactureProcedureTag,
			@RequestParam(required = false, value = "manufactureId") String manufactureId,
			@RequestParam(required = false, value = "detailsNumber") Integer detailsNumber,
			@RequestParam(required = false, value = "checkTag") String checkTag,
			@RequestParam(required = false, value = "keyword") String keyword,
			@RequestParam(required = false, value = "status") String status,
			@RequestParam(required = false, value = "beginTime" ) String beginTime,
			@RequestParam(required = false, value = "endTime") String endTime,
			HttpServletResponse response, HttpServletRequest request) throws ParseException {
		if(null!=manufactureId&&!"".equals(manufactureId)){
			manufactureId="%"+manufactureId+"%";
		}
		if(null!=keyword&&!"".equals(keyword)){
			keyword="%"+keyword+"%";
		}
		if(null!=status&&!"".equals(status)){
			if("00".equals(status)){
				status="G004-0";
			}else if("10".equals(status)){
				status="G004-1";
			}else if("01".equals(status)){
				status="G004-2";
			}
		}
		checkTag="S001-1";
		detailsNumber=1;
		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页
		Pager<QueryResult> pager=null;
		if(null==beginTime||"".equals(beginTime)||null==endTime||"".equals(endTime)){
			pager = lbQueryService.findPager(pageno, pagesize,
					sort, order, manufactureProcedureTag, manufactureId,
					detailsNumber, checkTag, keyword, status, null, null);
		}else{
			pager = lbQueryService.findPager(pageno, pagesize,
					sort, order, manufactureProcedureTag, manufactureId,
					detailsNumber, checkTag, keyword, status, sdf.parse(beginTime), sdf.parse(endTime));
		}
		request.getSession().setAttribute("NNUM", pager.getTotal());
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/lbQueryController_detail")
	public String detail(Manufacture manufacture, ModelMap modelMap,
			HttpServletRequest request) {
		manufacture = lbQueryService.findByMid(manufacture
				.getManufactureId());
		List<Mprocedure> mlist = lbQueryService
				.findByParentId(manufacture.getId());
		modelMap.put("mlist", mlist);
		String gatherId = lbQueryService.findByMaId(manufacture.getId());
		modelMap.put("gatherId", gatherId);
		modelMap.put("registerTime", df.format(manufacture.getRegisterTime()));
		modelMap.put("checkTime", df.format(manufacture.getCheckTime()));
		modelMap.put("manufacture", manufacture);
		return "lbquery_details";
	}
	
	@RequestMapping("/lbQueryController_labor")
	public String labor(
			@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = false, value = "mid") Integer mid,
			ModelMap modelMap, HttpServletRequest request,HttpServletResponse response) {
		Manufacture manufacture = lbQueryService.findById(id);
		Mprocedure mprocedure = lbQueryService.findMprocedure(mid);
		modelMap.put("manufacture", manufacture);
		modelMap.put("mprocedure", mprocedure);
		modelMap.put("registerTime", df.format(new Date()));
		return "lbquery_labor";
	}
	
	@RequestMapping("/lbQueryController_material")
	public String material(
			@RequestParam(required = false, value = "id") Integer id,
			@RequestParam(required = false, value = "mid") Integer mid,
			ModelMap modelMap, HttpServletRequest request,HttpServletResponse response) {
		Manufacture manufacture = lbQueryService.findById(id);
		Mprocedure mprocedure = lbQueryService.findMprocedure(mid);
		List<MpModule> mpList = lbQueryService.findByParent(mprocedure
				.getId());
		modelMap.put("mplist", mpList);
		modelMap.put("manufacture", manufacture);
		modelMap.put("mprocedure", mprocedure);
		modelMap.put("registerTime", df.format(manufacture.getRegisterTime()));
		return "lbquery_material";
	}

}
