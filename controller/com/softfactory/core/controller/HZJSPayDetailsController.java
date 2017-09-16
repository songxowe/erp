package com.softfactory.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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

import com.softfactory.core.service.HZJSPayDetailsServisce;
import com.softfactory.core.service.HZJSPayServisce;
import com.softfactory.core.util.ErpUtils;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.SPay;
import com.softfactory.pojo.SPayDetails;

/**
 * 入库明细控制器
 * 
 * @author Administrator
 * 
 */
@Controller
public class HZJSPayDetailsController {
	@Resource(name = "hzjspaydetailsServisce")
	private HZJSPayDetailsServisce hzjspaydetailsServisce;

	@Resource(name = "hzjspayService")
	private HZJSPayServisce hzjspayService;

	/**
	 * 添加产品分页
	 * 
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param productName
	 * @param response
	 */
	@RequestMapping("/hzjspaydetailsController")
	public void list(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			@RequestParam(required = false, value = "productName") String productName,
			HttpServletResponse response) {

		try {
			if (!StringUtils.isEmpty(productName)) {
				productName = "%" + productName.toUpperCase() + "%";
			}

			Integer pageno = (page - 1) * rows;
			Integer pagesize = page * rows;

			Pager<SPayDetails> pager = hzjspaydetailsServisce.findPager(pageno,
					pagesize, sort, order, productName);

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

	@RequestMapping("/hzjspaydetailsController_save")
	public void save(SPayDetails spaydetails, HttpServletResponse response) {
		int count = 0;

		count = hzjspaydetailsServisce.add(spaydetails);

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
	 * 提交申请单
	 * 
	 * @param id
	 * @param productId
	 * @param productName
	 * @param personalUnit
	 * @param realCostPrice
	 * @param amount
	 * @param subtotal
	 * @param type
	 * @param storer
	 * @param reason
	 * @param amountSum
	 * @param costPriceSum
	 * @param register
	 * @param remark
	 * @param registerTime
	 * @return
	 */
	@RequestMapping("/paystorebuildController")
	public String SaveList(
			@RequestParam(required = true, value = "id") Integer[] id,
			@RequestParam(required = true, value = "productId") String[] productId,
			@RequestParam(required = true, value = "productName") String[] productName,
			@RequestParam(required = true, value = "personalUnit") String[] personalUnit,
			@RequestParam(required = true, value = "costPrice") Double[] costPrice,
			@RequestParam(required = true, value = "amount") Double[] amount,
			@RequestParam(required = true, value = "subtotal") Double[] subtotal,
			@RequestParam(required = true, value = "type") String[] type,
			// 获取入库单所需要元素
			@RequestParam(required = false, value = "storer") String storer,
			@RequestParam(required = false, value = "reason") String reason,
			@RequestParam(required = false, value = "amountSum") Double amountSum,
			@RequestParam(required = false, value = "costPriceSum") Double costPriceSum,
			@RequestParam(required = false, value = "register") String register,
			@RequestParam(required = false, value = "remark") String remark,
			@RequestParam(required = false, value = "registerTime") String registerTime) {
		SPay spay = new SPay();
		String num = null;
		try {
			num = hzjspayService.findMaxNum();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String payId = ErpUtils.getNumber("401", num);
		spay.setPayId(payId);
		spay.setStorer(storer);
		spay.setReason(reason);
		spay.setAmountSum(amountSum);
		spay.setCostPriceSum(costPriceSum);
		spay.setRemark(remark);
		spay.setRegister(register);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = sdf.parse(registerTime);
			spay.setRegisterTime(date);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		spay.setCheckTag("S001-0");
		spay.setStoreTag("K002-0");
		hzjspayService.add2(spay);
		for (int i = 0; i < id.length; i++) {
			SPayDetails details = new SPayDetails();
			SPay spay1 = hzjspayService.findByPayId(spay.getPayId());
			Integer id1 = spay1.getId();
			details.setParentId(id1);
			details.setProductName(productName[i]);
			details.setProductId(productId[i]);
			details.setProductDescribe(type[i]);
			details.setAmountUnit(personalUnit[i]);
			details.setCostPrice(costPrice[i]);
			details.setAmount(amount[i]);
			details.setSubtotal(subtotal[i]);
			details.setPayTag("K002-0");
			hzjspaydetailsServisce.add(details);
			System.out.println("ok");
		}

		return "checkok";
	}
}
