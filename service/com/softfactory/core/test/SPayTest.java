package com.softfactory.core.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softfactory.core.service.HZJSPayServisce;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.SPay;

/**
 * 入库测试类
 * @author Administrator
 *
 */
public class SPayTest {
	private HZJSPayServisce hzjspayService;

	  @Test
	  public void findPager() {
	    // easyi 必需的参数 
	    Integer page = 1;
	    Integer rows = 5;
	    String sort = "payId";
	    String order = "asc";

	    // 条件查询的参数
	    String payId = null;
	    //  = "%S%";

	    // 处理记录的开始页/结束页
	    Integer pageno = (page - 1) * rows;
	    Integer pagesize = page * rows;

	    Pager<SPay> pager = hzjspayService.findPager(pageno, pagesize, sort, order, payId);
	    System.out.println("总记录数: " + pager.getTotal());
	    for (SPay spay : pager.getRows()) {
	      System.out.println(spay.getPayId() + " " + spay.getAttmper());
	    }
	  }

	  @SuppressWarnings("resource")
	  @Before
	  public void init() {
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	    hzjspayService = ctx.getBean("hzjspayService", HZJSPayServisce.class);
	  }
}
