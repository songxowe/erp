package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Dfile;

/**
 * 档案映射接口 李翔
 * 
 * @author Administrator
 * 
 */
@Repository("dfileMapper")
public interface LXDfileMapper {

	/**
	 * 制定新生产计划所需查询
	 */
	@Select("select PRODUCT_ID productId,PRODUCT_NAME productName,TYPE type,PERSONAL_UNIT personalUnit,PRODUCT_DESCRIBE productDescribe,LIST_PRICE listPrice from D_FILE where CHECK_TAG='S001-1' and PRODUCT_ID=#{productId,jdbcType=VARCHAR}")
	public Dfile selectFromApply(String productId);

	/**
	 * 新生产计划查询所有已通过档案
	 */
	public List<Dfile> selectAllFromApply(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order, @Param("productId") String productId);

	/**
	 * 查询分页记录总数 + 条件查询
	 * 
	 * @param ename
	 * @return
	 */
	public long findPagerTotal();
}
