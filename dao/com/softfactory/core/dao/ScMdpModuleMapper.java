package com.softfactory.core.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.MdpModule;

/**
 * 产品生产工序物料明细接口
 * @author shengchen
 *
 */
@Repository("mdpModuleMapper")
public interface ScMdpModuleMapper {
	/**
	 * 将数据新增到产品生产工序物料明细中
	 */
	@Insert("insert into M_DESIGN_PROCEDURE_MODULE(ID,PARENT_ID,DETAILS_NUMBER,PRODUCT_ID,PRODUCT_NAME,TYPE,"
			+ "AMOUNT,PRODUCT_DESCRIBE,AMOUNT_UNIT,COST_PRICE,SUBTOTAL) "
			+ "VALUES(#{id},#{parentId},#{detailsNumber},#{productId},#{productName},"
			+ "#{type},#{amount},#{productDescribe},#{amountUnit},#{costPrice},#{subtotal})")
	@SelectKey(statement="select SEQ_M_DESIGN_PROCEDURE_MODULE.NEXTVAL from dual",
	before = true, keyProperty = "id", resultType = int.class)
	public void addMdpModule(MdpModule m);
	
}
