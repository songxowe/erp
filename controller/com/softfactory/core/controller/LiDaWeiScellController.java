package com.softfactory.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.LiDaWeiScellService;
import com.softfactory.core.util.Constants;
import com.softfactory.core.util.ErpUtils;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Dkind;
import com.softfactory.pojo.Scell;
import com.softfactory.pojo.User;

@Controller
public class LiDaWeiScellController {
	@Resource(name = "scellSerice")
	private LiDaWeiScellService scellSerice;
	
	/**
	 * 查询第一个页面（安全库存配置单制定主页面）
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param firstKingName
	 * @param secondKingName
	 * @param thirdKingName
	 * @param beginDate
	 * @param endDate
	 * @param str
	 * @param response
	 */
	@RequestMapping("/scellController_one")
	public void list(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "firstKingName") String firstKingName,
			@RequestParam(required = false, value = "secondKingName") String secondKingName,
			@RequestParam(required = false, value = "thirdKingName") String thirdKingName,
			@RequestParam(required = false, value = "beginDate") String beginDate,
			@RequestParam(required = false, value = "endDate") String endDate,
			@RequestParam(required = false, value = "str") String str,
			HttpServletResponse response) {

		try {
			if (!StringUtils.isEmpty(str)) {
				str = "%" + str + "%";
			}

			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			Date date1=null;
			Date date2=null;
			if(beginDate !=null && beginDate !=""){
			date1=df.parse(beginDate);
			}
			if(endDate !=null && endDate !=""){
				date2=df.parse(endDate);
				}
			String firstid=null;
			String secondid=null;
			String thirdid=null;
			if(firstKingName !=null && firstKingName !=""){
				if(!firstKingName.equals("-1")){
					firstid=scellSerice.findKindById(Integer.valueOf(firstKingName));
				}
			}
			if(secondKingName !=null && secondKingName !=""){
				if(!secondKingName.equals("-1")){
			secondid=scellSerice.findKindById(Integer.valueOf(secondKingName));
				}
			}
			if(thirdKingName !=null && thirdKingName !=""){
				if(!thirdKingName.equals("-1")){
			thirdid=scellSerice.findKindById(Integer.valueOf(thirdKingName));
				}
			}
			Pager<Scell> pager = scellSerice.findOnePager(pageno, pagesize,
					sort, order, firstid, secondid, thirdid,
					date1, date2, str);
			List<Scell> scell=pager.getRows();
			for(Scell s:scell){
				if(null!=s.getProductType()&&!"".equals(s.getProductType())){
					if(s.getProductType().equals("Y001-1")){
						s.setProductType("商品");
					}else{
						s.setProductType("物料");
					}
				}
				if(null!=s.getProductClass()&&!"".equals(s.getProductClass())){
				if(s.getProductClass().equals("D001-1")){
					s.setProductClass("高档");
				}else if(s.getProductClass().equals("D001-2")){
					s.setProductClass("中档");
				}else{
					s.setProductClass("低挡");
				}
				}
				}
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class,
					new JsonDateValueProcessor());

			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);

			PrintWriter out = response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询第二个页面（安全库存配置单复核）
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param response
	 */
	@RequestMapping("/scellController_two")
	public void list2(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			HttpServletResponse response) {

		try {

			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;

			Pager<Scell> pager = scellSerice.findTwoPager(pageno, pagesize, sort, order);

			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class,
					new JsonDateValueProcessor());

			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);

			PrintWriter out = response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询第三个页面（安全库存配置单查询）
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param firstKingName
	 * @param secondKingName
	 * @param thirdKingName
	 * @param checkTag
	 * @param firstdate
	 * @param lastdate
	 * @param str
	 * @param response
	 */
	@RequestMapping("/scellController_three")
	public void list3(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "firstKingName") String firstKingName,
			@RequestParam(required = false, value = "secondKingName") String secondKingName,
			@RequestParam(required = false, value = "thirdKingName") String thirdKingName,
			@RequestParam(required = false, value = "checkTag") String checkTag,
			@RequestParam(required = false, value = "firstdate")String firstdate,
			@RequestParam(required = false, value = "lastdate")String  lastdate,
			@RequestParam(required = false, value = "str") String str,
			HttpServletResponse response) {

		try {
			if (!StringUtils.isEmpty(str)) {
				str = "%" + str + "%";
			}
			if (!StringUtils.isEmpty(checkTag)) {
				checkTag = "%" + checkTag + "%";
			}
			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			Date date1=null;
			Date date2=null;
			if(firstdate !=null && firstdate !=""){
			date1=df.parse(firstdate);
			}
			if(lastdate !=null && lastdate !=""){
				date2=df.parse(lastdate);
				}
			String firstid=null;
			String secondid=null;
			String thirdid=null;
			if(firstKingName !=null && firstKingName !=""){
				if(!firstKingName.equals("-1")){
					firstid=scellSerice.findKindById(Integer.valueOf(firstKingName));
				}
			}
			if(secondKingName !=null && secondKingName !=""){
				if(!secondKingName.equals("-1")){
			secondid=scellSerice.findKindById(Integer.valueOf(secondKingName));
				}
			}
			if(thirdKingName !=null && thirdKingName !=""){
				if(!thirdKingName.equals("-1")){
			thirdid=scellSerice.findKindById(Integer.valueOf(thirdKingName));
				}
			}
			Pager<Scell> pager = scellSerice.findThreePager(pageno, pagesize, sort, order, firstid, secondid, thirdid, checkTag, date1, date2, str);
			List<Scell> list=pager.getRows();
			for(Scell scell:list){
				String checktag=scell.getCheckTag();
				if("S005-2".equals(checktag)){
					scell.setCheckTag("审核通过");
					scell.setProductClass("完成");
				}else {
					if("S005-1".equals(checktag)){
						scell.setProductClass("等待");
					}else{
						scell.setProductClass("执行");
					}
					scell.setCheckTag("等待审核");
				}
			}
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class,
					new JsonDateValueProcessor());

			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);

			PrintWriter out = response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询第四个页面（安全库存配置单变更）
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param firstKingName
	 * @param secondKingName
	 * @param thirdKingName
	 * @param beginDate
	 * @param endDate
	 * @param str
	 * @param response
	 */
	@RequestMapping("/scellController_four")
	public void list4(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "firstKingName") String firstKingName,
			@RequestParam(required = false, value = "secondKingName") String secondKingName,
			@RequestParam(required = false, value = "thirdKingName") String thirdKingName,
			@RequestParam(required = false, value = "beginDate") String beginDate,
			@RequestParam(required = false, value = "endDate") String endDate,
			@RequestParam(required = false, value = "str") String str,
			HttpServletResponse response) {

		try {
			if (!StringUtils.isEmpty(str)) {
				str = "%" + str + "%";
			}

			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			Date date1=null;
			Date date2=null;
			if(beginDate !=null && beginDate !=""){
			date1=df.parse(beginDate);
			}
			if(endDate !=null && endDate !=""){
				date2=df.parse(endDate);
				}
			String firstid=null;
			String secondid=null;
			String thirdid=null;
			if(firstKingName !=null && firstKingName !=""){
				if(!firstKingName.equals("-1")){
					firstid=scellSerice.findKindById(Integer.valueOf(firstKingName));
				}
			}
			if(secondKingName !=null && secondKingName !=""){
				if(!secondKingName.equals("-1")){
			secondid=scellSerice.findKindById(Integer.valueOf(secondKingName));
				}
			}
			if(thirdKingName !=null && thirdKingName !=""){
				if(!thirdKingName.equals("-1")){
			thirdid=scellSerice.findKindById(Integer.valueOf(thirdKingName));
				}
			}
			Pager<Scell> pager = scellSerice.findFourPager(pageno, pagesize, sort, order, firstid, secondid, thirdid, date1, date2, str);

			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class,
					new JsonDateValueProcessor());

			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);

			PrintWriter out = response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询第五个页面（动态库存）
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param firstKingName
	 * @param secondKingName
	 * @param thirdKingName
	 * @param str
	 * @param response
	 */
	@RequestMapping("/scellController_five")
	public void list5(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "firstKingName") String firstKingName,
			@RequestParam(required = false, value = "secondKingName") String secondKingName,
			@RequestParam(required = false, value = "thirdKingName") String thirdKingName,
			@RequestParam(required = false, value = "str") String str,
			HttpServletResponse response) {

		try {
			if (!StringUtils.isEmpty(str)) {
				str = "%" + str + "%";
			}
			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;
			String firstid=null;
			String secondid=null;
			String thirdid=null;
			if(firstKingName !=null && firstKingName !=""){
				if(!firstKingName.equals("-1")){
					firstid=scellSerice.findKindById(Integer.valueOf(firstKingName));
				}
			}
			if(secondKingName !=null && secondKingName !=""){
				if(!secondKingName.equals("-1")){
			secondid=scellSerice.findKindById(Integer.valueOf(secondKingName));
				}
			}
			if(thirdKingName !=null && thirdKingName !=""){
				if(!thirdKingName.equals("-1")){
			thirdid=scellSerice.findKindById(Integer.valueOf(thirdKingName));
				}
			}
			Pager<Scell> pager = scellSerice.findFivePager(pageno, pagesize, sort, order, firstid, secondid, thirdid, str);

			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class,
					new JsonDateValueProcessor());

			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);

			PrintWriter out = response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 安全库存配置单审核提交操作
	 * @param scell
	 * @param request
	 * @return
	 */
	@RequestMapping("/scellController_modify")
	public String scellmodify(Scell scell,HttpServletRequest request){
		User user = (User) request.getSession().getAttribute(Constants.USER_IN_SESSION);
		String name=user.getUsername();
		scell.setRegister(name);
		String checkTag="S005-3";
		scell.setCheckTag(checkTag);
		Date date =new Date();
		scell.setRegisterTime(date);
		scellSerice.modifyScellById(scell);
		return "scellmodify1";
	}
	
	/**
	 * 安全库存配置单制定页面数据查询
	 * @param proid
	 * @param modelmap
	 * @return
	 */
	@RequestMapping("/scellController_add1")
	public String getDfile(@RequestParam(required = true, value = "proid") String proid,ModelMap modelmap){
		Scell scell=scellSerice.findById(proid);
		modelmap.put("scell", scell);
		return "scelladd";
	}
	
	/**
	 * 安全库存配置单审核显示页面操作
	 * @param proid
	 * @param modelmap
	 * @return
	 */
	@RequestMapping("/scellController_check")
	public String findScellById(@RequestParam(required = true, value = "proid") String proid,ModelMap modelmap){
		Scell scell=scellSerice.findScellById(proid);
		modelmap.put("scell2", scell);
		return "scellcheck1";
	}
	
	/**
	 * 安全库存配置单变更显示页面数据来源
	 * @param proid
	 * @param modelmap
	 * @return
	 */
	@RequestMapping("/scellController_check1")
	public String findScellById2(@RequestParam(required = true, value = "proid") String proid,ModelMap modelmap){
		Scell scell=scellSerice.findScellById(proid);
		modelmap.put("scell3", scell);
		return "scellmodify2";
	}
	
	/**
	 * 配置单超链接点击显示
	 * @param proid
	 * @param modelmap
	 * @return
	 */
	@RequestMapping("/scellController_check3")
	public String findScellById3(@RequestParam(required = true, value = "proid") String proid,ModelMap modelmap){
		Scell scell=scellSerice.findScellById(proid);
		modelmap.put("scell2", scell);
		return "scellsearchall";
	}
	
	/**
	 * 安全库存配置单审核
	 * @param scell
	 * @param request
	 * @param response
	 */
	@RequestMapping("/scellController_check2")
	public void scellCheck(Scell scell,HttpServletRequest request,HttpServletResponse response){
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		User user = (User) request.getSession().getAttribute(Constants.USER_IN_SESSION);
		String name=user.getUsername();
		scell.setChecker(name);
		String checkTag="S005-2";
		scell.setCheckTag(checkTag);
		Date date =new Date();
		scell.setCheckTime(date);
		int a=scellSerice.modifyScell(scell);
		if(a==1){
			out.println("1");
		}else{
			out.println("0");
		}
	}
	
	
	/**
	 * 安全库存配置单添加
	 * @param scell
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/scellController_add")
	public String  scellAdd(Scell scell,HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String num=null;
		try{
		 num=scellSerice.findMaxNum();
		}catch(Exception e){
			e.printStackTrace();
		}
		ErpUtils erputil=new ErpUtils();
		String storeid=erputil.getNumber("400", num);
		scell.setStoreId(storeid);
		scell.setCheckTag("S005-1");
		Long lo=(long)0;
		scell.setAmount(lo);
		String scellTag="K001-1";
		Date date=new Date();
		scell.setRegisterTime(date);
		scellSerice.addScell(scell,scellTag,scell.getProductId());
		return "scellist";
	}
	
	/**
	 * 三级联动
	 * @param response
	 * @param request
	 */
	@RequestMapping("/scellController_findAll")
	public void findAll(HttpServletResponse response,HttpServletRequest request ){
		PrintWriter out=null;
		try {
			 out =response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int pid = null == request.getParameter("pid") ? 0 : Integer
				.parseInt(request.getParameter("pid"));
		Dkind dkind=new Dkind();
		dkind.setPid(pid);
		List<Dkind> list = scellSerice.findAll(dkind);
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

