package com.softfactory.core.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softfactory.core.service.ScMdProcedureService;
import com.softfactory.core.service.ScMdpDetailsService;
import com.softfactory.core.service.ScModuleService;
import com.softfactory.pojo.MdpDetails;
import com.softfactory.pojo.MdpModule;

/**
 * 新增数据到产品生产工序物料明细表处理器
 * @author shengchen
 *
 */
@Controller
@RequestMapping("/Modul")
public class ScMdpModulControllere {
	@Resource(name = "moduleService")
	private ScModuleService moduleService;
	@Resource(name = "mdpDetailsService")
	private ScMdpDetailsService mdpDetailsService;
	@Resource(name = "mdProcedureService")
	private ScMdProcedureService mdProcedureService;
	//将数据存储到产品生产工序物料明细表，修改设计标志跳转到预览页面
	@RequestMapping("/goPreview")
	public String goPreview(HttpServletRequest request){
		String [] productName = request.getParameterValues("productName");
		String [] productId = request.getParameterValues("productId");
		String [] detailsNumber = request.getParameterValues("detailsNumber");
		String [] amount = request.getParameterValues("amount");
		String [] productDescribe = request.getParameterValues("productDescribe");
		String [] amountUnit = request.getParameterValues("amountUnit");
		String [] costPrice = request.getParameterValues("costPrice");
		Integer parentId =Integer.valueOf(request.getParameter("parentId"));
		Integer id = Integer.parseInt(request.getParameter("id"));
		Double subtotalAll = 0.00;
		for(int j =0;j<detailsNumber.length;j++){
			MdpModule m = new MdpModule();
			Integer n = Integer.valueOf(detailsNumber[j]);
			String pId = productId[j];
			String pName = productName[j];
			String type = request.getParameter("type");
			Double am = Double.valueOf(amount[j]);
			String pDescribe = productDescribe[j];
			String aUnit = amountUnit[j];
			Double cPrice = Double.valueOf(costPrice[j]);
			Double subtotal = am*cPrice;
			m.setParentId(parentId);
			m.setDetailsNumber(n);
			m.setProductId(pId);
			m.setProductName(pName);
			m.setType(type);
			m.setAmount(am);
			m.setProductDescribe(pDescribe);
			m.setAmountUnit(aUnit);
			m.setCostPrice(cPrice);
			m.setSubtotal(subtotal);
			moduleService.addMdpModule(m);
			subtotalAll+=subtotal;
		}
		Double d = subtotalAll;
		//产品生产工序明细当前工序物料标志更改为已设计
		mdpDetailsService.modifydesignModuleTagTod0021(id);
		String designId = request.getParameter("designId");
		//生产工序单所用物料设计完成后修改工序物料设计标志为G002-1: 已提交
		mdProcedureService.modifyModuleTag(designId);
		List<MdpDetails> l =mdpDetailsService.findAll1(designId);
		request.setAttribute("MdpDetails", l);
		//物料总成本
		System.out.println(l.size());
		request.getSession().setAttribute("SubtotalAll", d);
		return "a";
		
	}
}
