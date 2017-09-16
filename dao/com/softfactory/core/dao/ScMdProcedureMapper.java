package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.MdProcedure;

/**
 * 产品生产工序接口
 * 
 * @author shengchen
 * 
 */
@Repository("scMdProcedureMapper")
public interface ScMdProcedureMapper {
	/**
	 * 通过ID查询单个生产工序单对象的八个需要属性
	 * 
	 * @param id
	 * @return
	 */
	@Select("select id, DESIGN_ID designId,PRODUCT_ID productId,PRODUCT_NAME productName,"
			+ "DESIGNER designer,REGISTER_TIME registerTime,COST_PRICE_SUM costPriceSum,"
			+ "PROCEDURE_DESCRIBE procedureDescribe,MODULE_COST_PRICE_SUM moduleCostPriceSum "
			+ "from M_DESIGN_PROCEDURE where id=#{id} and DESIGN_MODULE_TAG='G002-0'and CHECK_TAG='S001-1'")
	public MdProcedure findById(Integer id);
	
	/**
	 * 生产工序单所用物料设计完成后修改工序物料设计标志为G002-1: 已提交
	 */
	@Update("UPDATE M_DESIGN_PROCEDURE SET DESIGN_MODULE_TAG = 'G002-1' WHERE DESIGN_ID = #{designId}")
	public void modifyModuleTag(String designId);
	
	/**
	 * 生产工序单审核通过后修改工序物料设计标志为G002-2 已审核
	 */
	@Update("UPDATE M_DESIGN_PROCEDURE SET DESIGN_MODULE_TAG = 'G002-2',CHECK_TAG=#{checkTag} WHERE DESIGN_ID = #{designId}")
	public int modifydesignModuleTag(@Param("checkTag")String checkTag,@Param("designId")String designId);

	/**
	 * 分页查询 + 条件查询
	 * 制定查询
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param productId 产品编号
	 * @return
	 */
	List<MdProcedure> findPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order, @Param("productId") String productId);
	

	/**
	 * 查询分页记录总数 + 条件查询
	 * 
	 * @param productId  产品编号
	 * @return
	 */
	long findPagerTotal(@Param("productId") String productId);
	
	/**
	 * 分页查询   审核查询
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param productId
	 * @return
	 */
	List<MdProcedure> findPager1(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order, @Param("productId") String productId);
	
	/**
	 * 查询分页记录总数 + 条件查询
	 * 审核查询
	 * @param productId  产品编号
	 * @return
	 */
	long findPagerTotal1(@Param("productId") String productId);
	
	/**
	 * 分页查询   最后审核状态查询
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param productId
	 * @return
	 */
	List<MdProcedure> findPager2(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order);
	
	/**
	 * 查询分页记录总数 + 条件查询
	 * 最后审核状态查询
	 * @param productId  产品编号
	 * @return
	 */
	long findPagerTotal2();
}
