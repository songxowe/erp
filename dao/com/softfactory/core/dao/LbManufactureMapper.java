package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Manufacture;
import com.softfactory.pojo.MdpDetails;
import com.softfactory.pojo.MdpModule;
import com.softfactory.pojo.MpModule;
import com.softfactory.pojo.MpModuling;
import com.softfactory.pojo.Mprocedure;
import com.softfactory.pojo.Mproceduring;
import com.softfactory.pojo.SPayDetails;
import com.softfactory.pojo.Spays;

@Repository("lbManufactureMapper")
public interface LbManufactureMapper {

	@SelectKey(statement = "select SEQ_SYS_MENUS.nextval from dual", keyProperty = "id", resultType = int.class, before = true)
	@Insert("insert into M_PROCEDURING(ID,PARENT_ID,DETAILS_NUMBER,PROCEDURE_ID,PROCEDURE_NAME,LABOUR_HOUR_AMOUNT,"
			+ "COST_PRICE,SUBTOTAL,PROCEDURE_DESCRIBE,REG_COUNT,PROCEDURE_RESPONSIBLE_PERSON,REGISTER,"
			+ "REGISTER_TIME,CHECKER,CHECK_TIME) values(#{id,jdbcType=NUMERIC},#{parentId,jdbcType=NUMERIC},#{detailsNumber,jdbcType=NUMERIC},#{procedureId,jdbcType=VARCHAR},"
			+ "#{procedureName,jdbcType=VARCHAR},#{labourHourAmount,jdbcType=NUMERIC},#{costPrice,jdbcType=NUMERIC},#{subtotal,jdbcType=NUMERIC},#{rocedureDescribe,jdbcType=VARCHAR},"
			+ "#{regCount,jdbcType=NUMERIC},#{procedureResponsiblePerson,jdbcType=VARCHAR},#{register,jdbcType=VARCHAR},#{registerTime,jdbcType=DATE},#{checker,jdbcType=VARCHAR},#{checkTime,jdbcType=DATE})")
	Integer addMproceduring(Mproceduring mproceduring);

	@SelectKey(statement = "select SEQ_SYS_ROLES.nextval from dual", keyProperty = "id", resultType = int.class, before = true)
	@Insert("insert into M_PROCEDURE_MODULING(ID,PARENT_ID,DETAILS_NUMBER,PRODUCT_ID,PRODUCT_NAME,COST_PRICE,AMOUNT,SUBTOTAL) values(#{id,jdbcType=NUMERIC},#{parentId,jdbcType=NUMERIC},#{detailsNumber,jdbcType=NUMERIC},#{productId,jdbcType=VARCHAR},#{productName,jdbcType=VARCHAR},#{costPrice,jdbcType=NUMERIC},#{amount,jdbcType=NUMERIC},#{subtotal,jdbcType=NUMERIC})")
	Integer addMpModuling(MpModuling mpModuling);

	@Update("update M_MANUFACTURE set MANUFACTURE_ID=#{manufactureId,jdbcType=VARCHAR},"
			+ "PRODUCT_ID=#{productId,jdbcType=VARCHAR},"
			+ "PRODUCT_NAME=#{productName,jdbcType=VARCHAR},"
			+ "AMOUNT=#{amount,jdbcType=NUMERIC},"
			+ "TESTED_AMOUNT=#{testedAmount,jdbcType=NUMERIC},"
			+ "APPLY_ID_GROUP=#{applyIdGroup,jdbcType=VARCHAR},"
			+ "PRODUCT_DESCRIBE=#{productDescribe,jdbcType=VARCHAR},"
			+ "MODULE_COST_PRICE_SUM=#{moduleCostPriceSum,jdbcType=NUMERIC},"
			+ "REAL_MODULE_COST_PRICE_SUM=#{realModuleCostPriceSum,jdbcType=NUMERIC},"
			+ "LABOUR_COST_PRICE_SUM=#{labourCostPriceSum,jdbcType=NUMERIC},"
			+ "REAL_LABOUR_COST_PRICE_SUM=#{realLabourCostPriceSum,jdbcType=NUMERIC},"
			+ "DESIGNER=#{designer,jdbcType=VARCHAR},"
			+ "REGISTER=#{register,jdbcType=VARCHAR},"
			+ "REGISTER_TIME=#{registerTime,jdbcType=DATE},"
			+ "CHECKER=#{checker,jdbcType=VARCHAR},"
			+ "CHECK_TIME=#{checkTime,jdbcType=DATE},"
			+ "REMARK=#{remark,jdbcType=VARCHAR},"
			+ "CHECK_TAG=#{checkTag,jdbcType=VARCHAR},"
			+ "MANUFACTURE_PROCEDURE_TAG=#{manufactureProcedureTag,jdbcType=VARCHAR}"
			+ "where ID=#{id,jdbcType=NUMERIC}")
	Integer modifyManufacture(Manufacture manufacture);

	@Update("update M_PROCEDURE set PARENT_ID=#{parentId,jdbcType=NUMERIC}, "
			+ "DETAILS_NUMBER=#{detailsNumber,jdbcType=NUMERIC}, "
			+ "PROCEDURE_ID=#{procedureId,jdbcType=VARCHAR}, "
			+ "PROCEDURE_NAME=#{procedureName,jdbcType=VARCHAR}, "
			+ "LABOUR_HOUR_AMOUNT=#{labourHourAmount,jdbcType=NUMERIC}, "
			+ "REAL_LABOUR_HOUR_AMOUNT=#{realLabourHourAmount,jdbcType=NUMERIC}, "
			+ "SUBTOTAL=#{subtotal,jdbcType=NUMERIC}, "
			+ "REAL_SUBTOTAL=#{realSubtotal,jdbcType=NUMERIC},"
			+ "MODULE_SUBTOTAL=#{moduleSubtotal,jdbcType=NUMERIC}, "
			+ "REAL_MODULE_SUBTOTAL=#{realModuleSubtotal,jdbcType=NUMERIC}, "
			+ "COST_PRICE=#{costPrice,jdbcType=NUMERIC}, "
			+ "DEMAND_AMOUNT=#{demandAmount,jdbcType=NUMERIC},"
			+ "REAL_AMOUNT=#{realAmount,jdbcType=NUMERIC}, "
			+ "PROCEDURE_FINISH_TAG=#{procedureFinishTag,jdbcType=NUMERIC},"
			+ "PROCEDURE_TRANSFER_TAG=#{procedureTransferTag,jdbcType=NUMERIC} "
			+ " where ID=#{id,jdbcType=NUMERIC}")
	Integer modifyMprocedure(Mprocedure mprocedure);

	List<Manufacture> findPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order,
			@Param("manufactureProcedureTag") String manufactureProcedureTag,
			@Param("storeTag") String storeTag);

	Manufacture findByMid(@Param("manufactureId")String manufactureId);

	long findPagerTotal(
			@Param("manufactureProcedureTag") String manufactureProcedureTag,
			@Param("storeTag") String storeTag);

	@Select("select GATHER_ID from S_GATHER where MaId=#{id}")
	String findByMaId(Integer id);

	Manufacture findById(Integer id);

	List<Mprocedure> findByParentId(Integer parentId);

	List<MpModule> findByParent(Integer id);

	Mprocedure findMprocedure(@Param("id")Integer id);

	List<MdpDetails> findMdpDetails(Integer id, String name);

	List<MdpModule> findMdpModule(Integer id);
	
	Mproceduring findMproceduring(String procedureId);
	
	List<MpModuling> findMpModuling(Integer parentId);

	List<Mproceduring> findByMproceduring(Integer id);
	
	@SelectKey(statement = "select SEQ_SYS_MENUS.nextval from dual", keyProperty = "id", resultType = int.class, before = true)
	@Insert("insert into S_PAY(ID,PAY_ID,STORER,REASON,REASONEXACT,AMOUNT_SUM,"
			+ "COST_PRICE_SUM,PAID_AMOUNT_SUM,REMARK,REGISTER,REGISTER_TIME,"
			+ "CHECKER,CHECK_TIME,CHECK_TAG,ATTEMPER,ATTEMPER_TIME,"
			+ "PRODUCT_ID,STORE_TAG) values (#{id,jdbcType=NUMERIC},"
			+ "#{gatherId,jdbcType=VARCHAR},#{store,jdbcType=VARCHAR},"
			+ "#{reason,jdbcType=VARCHAR},#{reasonexact,jdbcType=VARCHAR},"
			+ "#{amountSum,jdbcType=NUMERIC},#{costPriceSun,jdbcType=NUMERIC},"
			+ "#{gatheredAmountSum,jdbcType=NUMERIC},#{remark,jdbcType=VARCHAR},"
			+ "#{register,jdbcType=VARCHAR},#{registerTime,jdbcType=DATE},"
			+ "#{checker,jdbcType=VARCHAR},#{checkTime,jdbcType=DATE},"
			+ "#{checkTag,jdbcType=VARCHAR},#{attemper,jdbcType=VARCHAR},"
			+ "#{attemperTime,jdbcType=DATE},#{productId,jdbcType=NUMERIC},"
			+ "#{storeTag,jdbcType=VARCHAR})")
	Integer addSpays(Spays spays);

	@Select("select max(PAY_ID) from S_PAY")
	String getMaxGatherId();
	
	@SelectKey(statement = "select SEQ_SYS_MENUS.nextval from dual", keyProperty = "id", resultType = int.class, before = true)
	@Insert("insert into S_PAY_DETAILS (ID,PARENT_ID,PRODUCT_ID,PRODUCT_NAME,PRODUCT_DESCRIBE,AMOUNT,AMOUNT_UNIT,COST_PRICE,SUBTOTAL,PAID_AMOUNT,PAY_TAG) values (#{id,jdbcType=NUMERIC},#{parentId,jdbcType=NUMERIC},#{productId,jdbcType=VARCHAR},#{productName,jdbcType=VARCHAR},#{productDescribe,jdbcType=VARCHAR},#{amount,jdbcType=NUMERIC},#{amountUnit,jdbcType=VARCHAR},#{costPrice,jdbcType=NUMERIC},#{subtotal,jdbcType=NUMERIC},#{paidAmount,jdbcType=NUMERIC},#{payTag,jdbcType=VARCHAR})")
	Integer addSPayDetails(SPayDetails sPayDetails);

	@Select("select ID from S_PAY where PAY_ID=#{maxValue,jdbcType=VARCHAR}")
	Integer getSpays(@Param("maxValue")String maxValue);
}
