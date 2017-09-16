package com.softfactory.core.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softfactory.core.service.HZJSPayDetailsServisce;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.SPayDetails;

/**
 * 入库明细测试类
 * @author Administrator
 *
 */
public class SPayDetailsText {
	private HZJSPayDetailsServisce hzjspaydetailsServisce;

	  @Test
	  public void findPager() {
	    // easyi 必需的参数 
	    Integer page = 1;
	    Integer rows = 5;
	    String sort = "parentId";
	    String order = "asc";

	    // 条件查询的参数
	    String parentId = null;
	    //  = "%S%";

	    // 处理记录的开始页/结束页
	    Integer pageno = (page - 1) * rows;
	    Integer pagesize = page * rows;

	    Pager<SPayDetails> pager = hzjspaydetailsServisce.findPager(pageno, pagesize, sort, order, parentId);
	    System.out.println("总记录数: " + pager.getTotal());
	    for (SPayDetails sapyDetails : pager.getRows()) {
	      System.out.println(sapyDetails.getParentId() + " " + sapyDetails.getPayTag());
	    }
	  }

	  @SuppressWarnings("resource")
	  @Before
	  public void init() {
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	    hzjspaydetailsServisce = ctx.getBean("hzjspaydetailsServisce", HZJSPayDetailsServisce.class);
	  }
}
