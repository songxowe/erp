package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.MdpDetails;

/**
 * 产品生产工序明细接口
 * 
 * @author shengchen
 *
 */
@Repository("scMdpDetailsMapper")
public interface ScMdpDetailsMapper {
	/**
	 * 查询所有未设计的工序
	 * @return
	 */
	@Select("select id,DETAILS_NUMBER detailsNumber,PROCEDURE_NAME procedureName,"
			+ "PROCEDURE_ID procedureId,PROCEDURE_DESCRIBE procedureDescribe,"
			+ "LABOUR_HOUR_AMOUNT labourHourAmount,SUBTOTAL subtotal,"
			+ "MODULE_SUBTOTAL moduleSubtotal from M_DESIGN_PROCEDURE_DETAILS "
			+ "where DESIGN_MODULE_TAG='D002-0'")
	List<MdpDetails> findAll();
	
	/**
	 * 通过工序单编号查询所有已设计的工序
	 */
	@Select("select s.id,s.DETAILS_NUMBER detailsNumber,s.PROCEDURE_NAME procedureName,"
			+ "s.PROCEDURE_ID procedureId,s.PROCEDURE_DESCRIBE procedureDescribe,"
			+ "s.LABOUR_HOUR_AMOUNT labourHourAmount,s.SUBTOTAL subtotal,"
			+ "s.MODULE_SUBTOTAL moduleSubtotal from M_DESIGN_PROCEDURE_DETAILS s,M_DESIGN_PROCEDURE m "
			+ "where s.DESIGN_MODULE_TAG='D002-1' and m.DESIGN_ID=#{designId} ")
	List<MdpDetails> findAll1(String designId);
	/**
	 * 当前工序物料设计完成之后修改当前工序物料标志为D002-1: 已设计
	 */
	@Update("UPDATE M_DESIGN_PROCEDURE_DETAILS SET DESIGN_MODULE_TAG = 'D002-1' WHERE PARENT_ID = #{parentId}")
	void modifydesignModuleTagTod0021(Integer parentId);
	
	/**
	 * 分页查询 + 条件查询
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param procedureName 工序名称
	 * @return
	 */
	List<MdpDetails> findPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order, @Param("procedureName") String procedureName,
			@Param("designId") String designId);

	/**
	 * 查询分页记录总数 + 条件查询
	 * 
	 * @param procedureName 工序名称
	 * @return
	 */
	long findPagerTotal(@Param("procedureName") String procedureName,@Param("designId") String designId);
}
