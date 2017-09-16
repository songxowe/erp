package com.softfactory.core.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softfactory.core.service.ScPmService;
import com.softfactory.pojo.dto.Pm;

/**
 * 产品设计单物料处理器
 * @author shengchen
 *
 */
@Controller
@RequestMapping("/pm")
public class ScPmController {
	@Resource(name = "pmService")
	private ScPmService pmService;
	
	@RequestMapping("/goMaterial")
	public String goMaterial(String ProductId, HttpServletRequest request){
		List<Pm> pms = pmService.findByProductId(ProductId);
		request.setAttribute("pms", pms);
		return "material";
	}

}
