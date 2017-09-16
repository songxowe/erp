package com.softfactory.core.dao;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.MdesignProcedureDetails;

@Repository("mdesignProcedureDetailsMapper")
public interface MdesignProcedureDetailsMapper {
	@Insert("insert into M_DESIGN_PROCEDURE_DETAILS(ID,PARENT_ID,DETAILS_NUMBER,PROCEDURE_ID,PROCEDURE_NAME,LABOUR_HOUR_AMOUNT,AMOUNT_UNIT,COST_PRICE,SUBTOTAL,REGISTER,REGISTER_TIME,DESIGN_MODULE_TAG,DESIGN_MODULE_CHANGE_TAG) values(#{id},#{parentId},#{detailsNumber},#{procedureId},#{procedureName},#{labourHourAmount},#{amountUnit},#{costPrice},#{subtotal},#{register},#{registerTime},#{designModuleTag},#{designModuleChangeTag})")
	@SelectKey(statement="select SEQ_M_DESIGN_PROCEDURE_DETAILS.NEXTVAL from DUAL",keyProperty="id",resultType=int.class,before=true)
	int add(MdesignProcedureDetails mdesignProcedureDetails);
	@Update("update M_DESIGN_PROCEDURE_DETAILS set PROCEDURE_ID = #{procedureId},PROCEDURE_NAME= #{procedureName},LABOUR_HOUR_AMOUNT= #{labourHourAmount},AMOUNT_UNIT= #{amountUnit},COST_PRICE= #{costPrice},SUBTOTAL= #{subtotal} where PARENT_ID = #{parentId}")
	int modfiy(MdesignProcedureDetails mdesignProcedureDetails);
	@Delete("delete from M_DESIGN_PROCEDURE_DETAILS where PARENT_ID = #{parentId}")
	int remove(Integer parentId);
//	@Select("select ID,PARENT_ID,DETAILS_NUMBER,PROCEDURE_ID,PROCEDURE_NAME,LABOUR_HOUR_AMOUNT,PROCEDURE_DESCRIBE,AMOUNT_UNIT,COST_PRICE,SUBTOTAL,MODULE_SUBTOTAL,REGISTER,REGISTER_TIME,DESIGN_MODULE_TAG,DESIGN_MODULE_CHANGE_TAG from M_DESIGN_PROCEDURE_DETAILS where ID = #{parentId}")
	List<MdesignProcedureDetails> findById(Integer parentId);
	
	String findID();
}
