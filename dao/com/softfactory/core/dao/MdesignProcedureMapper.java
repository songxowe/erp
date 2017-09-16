package com.softfactory.core.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.MdesignProcedure;

@Repository("mdesignProcedureMapper")
public interface MdesignProcedureMapper {
	@Insert("insert into M_DESIGN_PROCEDURE(ID,DESIGN_ID,FIRST_KIND_ID,FIRST_KIND_NAME,SECOND_KIND_ID,SECOND_KIND_NAME,THIRD_KIND_ID,THIRD_KIND_NAME,PRODUCT_ID,PRODUCT_NAME,PROCEDURE_DESCRIBE,COST_PRICE_SUM,MODULE_COST_PRICE_SUM,DESIGNER,REGISTER,REGISTER_TIME,CHECK_TAG,CHANGE_TAG,DESIGN_MODULE_TAG,DESIGN_MODULE_CHANGE_TAG) values(#{id,jdbcType=NUMERIC},#{designId,jdbcType=VARCHAR},#{firstKindId,jdbcType=VARCHAR},#{firstKindName,jdbcType=VARCHAR},#{secondKindId,jdbcType=VARCHAR},#{secondKindName,jdbcType=VARCHAR},#{thirdKindId,jdbcType=VARCHAR},#{thirdKindName,jdbcType=VARCHAR},#{productId,jdbcType=VARCHAR},#{productName,jdbcType=VARCHAR},#{procedureDescribe,jdbcType=VARCHAR},#{costPriceSum,jdbcType=NUMERIC},#{moduleCostPriceSum,jdbcType=NUMERIC},#{designer,jdbcType=VARCHAR},#{register,jdbcType=VARCHAR},#{registerTime,jdbcType=DATE},#{checkTag,jdbcType=VARCHAR},#{changeTag,jdbcType=VARCHAR},#{designModuleTag,jdbcType=VARCHAR},#{designModuleChangeTag,jdbcType=VARCHAR})")
	@SelectKey(statement = "SELECT SEQ_SYS_ROLES.NEXTVAL from DUAL", keyProperty = "id", resultType = int.class, before = true)
	int add(MdesignProcedure mdesignProcedure);

	@Update("update M_DESIGN_PROCEDURE set CHECK_TAG=#{checkTag,jdbcType=VARCHAR} where ID = #{id,jdbcType=NUMERIC} ")
	int modfiy(MdesignProcedure mdesignProcedure);

	@Update("update M_DESIGN_PROCEDURE set CHECKER=#{checker},CHECK_TIME=#{checkTime},CHECK_SUGGESTION=#{checkSuggestion},CHECK_TAG=#{checkTag} where ID = #{id}")
	int check(Integer id, String checker, Date checkTime,
			String checkSuggestion, String checkTag);

	@Delete("delete from M_DESIGN_PROCEDURE where ID = #{id}")
	int remove(Integer id);

	MdesignProcedure findById(String id);

	MdesignProcedure checkfind(Integer id);

	List<MdesignProcedure> findPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order,
			@Param("productName") String productName,
			@Param("checkTag") String checkTag);

	long findPagerTotal(@Param("productName") String productName,
			@Param("checkTag") String checkTag);

}
