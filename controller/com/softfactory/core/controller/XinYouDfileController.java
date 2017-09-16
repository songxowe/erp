package com.softfactory.core.controller;

import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.XinYouDfileService;
import com.softfactory.core.service.XinYouDmoduleService;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Dfile;
import com.softfactory.pojo.DmDetails;
import com.softfactory.pojo.Dmodule;

@Controller
public class XinYouDfileController {
	
	@Resource(name = "xinYouDfileService")
	private XinYouDfileService xinYouDfileService;
	@Resource(name = "xinYouDmoduleService")
	private XinYouDmoduleService xinYouDmoduleService;
	/**
	 * 物料的分页查询方法
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param productId
	 * @param productName
	 * @param factoryName
	 * @param firstKindName
	 * @param secondKindName
	 * @param thirdKindName
	 * @param productDescribe
	 * @param responsiblePerson
	 * @param response
	 */
	@RequestMapping("/dfileController_list")
	public void listDfileMaterial(
			  @RequestParam(required = true, value = "page") Integer page,
		      @RequestParam(required = true, value = "rows") Integer rows,
		      @RequestParam(required = true, value = "sort") String sort,
		      @RequestParam(required = true, value = "order") String order,
		      @RequestParam(required = false, value = "productId") String productId,
		      @RequestParam(required = false, value = "productName") String productName,
		      @RequestParam(required = false, value = "factoryName") String factoryName,
		      @RequestParam(required = false, value = "firstKindName") String firstKindName,
		      @RequestParam(required = false, value = "secondKindName") String secondKindName,
		      @RequestParam(required = false, value = "thirdKindName") String thirdKindName,
		      @RequestParam(required = false, value = "productDescribe") String productDescribe,
		      @RequestParam(required = false, value = "responsiblePerson") String responsiblePerson
		      , HttpServletResponse response
			){
			if (!StringUtils.isEmpty(productName)) {
			productName = "%" + productName + "%";
		    }
		    if (!StringUtils.isEmpty(productId)) {
		    	productId ="%"+ productId + "%";
		    }
		    if (!StringUtils.isEmpty(factoryName)) {
		    	factoryName = "%" + factoryName + "%";
			}
			if (!StringUtils.isEmpty(firstKindName)) {
				firstKindName ="%"+ firstKindName + "%";
			}
			if (!StringUtils.isEmpty(productName)) {
					productName = "%" + productName + "%";
			}
			if (!StringUtils.isEmpty(secondKindName)) {
				secondKindName ="%"+ secondKindName + "%";
			}
			if (!StringUtils.isEmpty(thirdKindName)) {
				thirdKindName = "%" + thirdKindName + "%";
			}
			if (!StringUtils.isEmpty(responsiblePerson)) {
				responsiblePerson ="%"+ responsiblePerson + "%";
			}
			int pageno = (page - 1) * rows; // 开始页
		    int pagesize = page * rows; // 结束页
		    Pager<Dfile> pager = xinYouDfileService.findMaterialPager(pageno, pagesize, sort, order, 
		    		productId, productName, factoryName, firstKindName, secondKindName, 
		    		thirdKindName, productDescribe, responsiblePerson);
		    JsonConfig jsonConfig = new JsonConfig();
		    try {
		      PrintWriter out = response.getWriter();
		      JSONObject json = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);
		      out.println(json.toString());
		      out.flush();
		      out.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }		
		
	}
	
	
	
	/**
	 * 商品的分页查询
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param productId
	 * @param productName
	 * @param factoryName
	 * @param firstKindName
	 * @param secondKindName
	 * @param thirdKindName
	 * @param productDescribe
	 * @param responsiblePerson
	 * @param registerTime
	 * @param response
	 */
	@RequestMapping("/dfileController")
	public void listDfileCommodity(
			  @RequestParam(required = true, value = "page") Integer page,
		      @RequestParam(required = true, value = "rows") Integer rows,
		      @RequestParam(required = true, value = "sort") String sort,
		      @RequestParam(required = true, value = "order") String order,
		      @RequestParam(required = false, value = "productId") String productId,
		      @RequestParam(required = false, value = "productName") String productName,
		      @RequestParam(required = false, value = "factoryName") String factoryName,
		      @RequestParam(required = false, value = "firstKindName") String firstKindName,
		      @RequestParam(required = false, value = "secondKindName") String secondKindName,
		      @RequestParam(required = false, value = "thirdKindName") String thirdKindName,
		      @RequestParam(required = false, value = "productDescribe") String productDescribe,
		      @RequestParam(required = false, value = "responsiblePerson") String responsiblePerson,
		      @RequestParam(required = false, value = "registerTime") Date registerTime,
		      HttpServletResponse response
			){
			if (!StringUtils.isEmpty(productName)) {
			productName = "%" + productName + "%";
		    }
		    if (!StringUtils.isEmpty(productId)) {
		    	productId ="%"+ productId + "%";
		    }
		    if (!StringUtils.isEmpty(factoryName)) {
		    	factoryName = "%" + factoryName + "%";
			}
			if (!StringUtils.isEmpty(firstKindName)) {
				firstKindName ="%"+ firstKindName + "%";
			}
			if (!StringUtils.isEmpty(productName)) {
					productName = "%" + productName + "%";
			}
			if (!StringUtils.isEmpty(secondKindName)) {
				secondKindName ="%"+ secondKindName + "%";
			}
			if (!StringUtils.isEmpty(thirdKindName)) {
				thirdKindName = "%" + thirdKindName + "%";
			}
			if (!StringUtils.isEmpty(responsiblePerson)) {
				responsiblePerson ="%"+ responsiblePerson + "%";
			}

			int pageno = (page - 1) * rows; // 开始页
		    int pagesize = page * rows; // 结束页
		    Pager<Dfile> pager = xinYouDfileService.findCommodityPager(pageno, pagesize, sort, order, 
		    		productId, productName, factoryName, firstKindName, secondKindName, 
		    		thirdKindName, productDescribe, responsiblePerson,registerTime);
		    JsonConfig jsonConfig = new JsonConfig();
		    try {
		      PrintWriter out = response.getWriter();
		      JSONObject json = (JSONObject) JSONSerializer.toJSON(pager, jsonConfig);
		      out.println(json.toString());
		      out.flush();
		      out.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }		
		
	}
	
	@RequestMapping("/dfileControllerlist")
	public String dfileControllerlist(Integer id,HttpServletRequest request){
		Dfile dfile = xinYouDfileService.findById(id);
		request.getSession().setAttribute("dfile", dfile);
		Dmodule dmodule = xinYouDmoduleService.findByproductId(dfile.getProductId());
		request.getSession().setAttribute("dmodule", dmodule);		
		return "dmodule5";
		
	}
	
//	@RequestMapping("/dddsubmitlist")
//	public void dddsubmitlist(
//			@RequestParam(required = true, value = "designer") String designer,
//			@RequestParam(required = true, value = "registerTime") Date registerTime,
//			@RequestParam(required = true, value = "moduleDescribe") String moduleDescribe,
//			@RequestParam(required = true, value = "amounts") Double amount,
//			@RequestParam(required = true, value = "subtotals") Double subtotal,
//			@RequestParam(required = true, value = "productId1") String productId1,
//			@RequestParam(required = true, value = "productName1") String productName1,
//			HttpServletRequest request, HttpServletResponse response
//			){
//		Double[] amounts = amount.split(",");
//		Double[] subtotals = subtotal.split(",");
//		int count = 0;
//		DmDetails dmdetails = null;
//		Dmodule dmodule = null;
//		dmodule = new Dmodule();
//		dmodule.setProductId(productId1);
//		dmodule.setProductName(productName1);
//		dmodule.setDesigner(designer);
//		dmodule.setRegisterTime(registerTime);
//		dmodule.setModuleDescribe(moduleDescribe);
//		count += xinYouDmoduleService.add(dmodule);
//		for(int i=0;i<subtotals.length;i++){
//			dmdetails = new DmDetails();
//			dmdetails.setAmount(amounts[i]);
//		}
//		
//	}
//	
	
}
