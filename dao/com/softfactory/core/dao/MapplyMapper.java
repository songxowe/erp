package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Mapply;

/**
 * 产品生产计划 映射器接口
 * 
 * @author Administrator
 * 
 */
@Repository("mapplyMapper")
public interface MapplyMapper {
	/**
	 * 根据产品编号查询单条数据
	 */
	@Select("select APPLY_ID applyId,PRODUCT_ID productId,PRODUCT_NAME productName,PRODUCT_DESCRIBE productDescribe,AMOUNT amount,DESIGNER designer,REGISTER register,REGISTER_TIME registerTime,REMARK remark from M_APPLY where APPLY_ID=#{applyId,jdbcType=VARCHAR}")
	public Mapply findById(String applyId);

	/**
	 * 新增
	 */
	@Insert("insert into M_APPLY(ID,APPLY_ID,PRODUCT_ID,PRODUCT_NAME,PRODUCT_DESCRIBE,TYPE,AMOUNT,DESIGNER,REMARK,REGISTER,REGISTER_TIME,CHECK_TAG,MANUFACTURE_TAG) values(#{id,jdbcType=NUMERIC},#{applyId,jdbcType=VARCHAR},#{productId,jdbcType=VARCHAR},#{productName,jdbcType=VARCHAR},#{productDescribe,jdbcType=VARCHAR},#{type,jdbcType=VARCHAR},#{amount,jdbcType=NUMERIC},#{designer,jdbcType=VARCHAR},#{remark,jdbcType=VARCHAR},#{register,jdbcType=VARCHAR},#{registerTime,jdbcType=DATE},'S001-0','P001-0')")
	@SelectKey(statement = "select SEQ_M_APPLY.NEXTVAL from dual", keyProperty = "id", resultType = int.class, before = true)
	public int add(Mapply mapply);

	/**
	 * 审核
	 */
	@Update("update M_APPLY set CHECKER=#{checker,jdbcType=VARCHAR},CHECK_TIME=#{checkTime,jdbcType=DATE},CHECK_TAG=#{checkTag,jdbcType=VARCHAR} where APPLY_ID=#{applyId,jdbcType=VARCHAR}")
	public int check(Mapply mapply);

	/**
	 * 查询所有未审核数据
	 * 
	 * @return
	 */
	public List<Mapply> selectAllFromCheck(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order, @Param("applyid") String applyid);

	/**
	 * 查询分页记录总数 + 条件查询
	 * 
	 * @param ename
	 * @return
	 */
	public long findPagerTotal();

	/**
	 * 派工所需查询已审核未派单数据
	 * 
	 * @return
	 */
	List<Mapply> findByNoManufactureTag();

	/**
	 * 派工所需根据id查询单条数据
	 * 
	 * @param applyId
	 * @return
	 */
	@Select("select ID id,APPLY_ID applyId,PRODUCT_ID productId,PRODUCT_NAME productName,PRODUCT_DESCRIBE productDescribe,AMOUNT amount,DESIGNER designer,REGISTER register,REGISTER_TIME registerTime,CHECK_TIME checkTime,CHECK_TAG checkTag,REMARK remark,MANUFACTURE_TAG manufactureTag from M_APPLY where ID=#{id,jdbcType=NUMERIC}")
	public Mapply findByIdFrom(Integer id);

	/**
	 * 将未派单修改为已派单
	 * 
	 * @param m
	 * @return
	 */
	@Update("update M_APPLY set REGISTER = #{register}, MANUFACTURE_TAG = 'P001-1',REMARK = #{remark} where ID = #{id}")
	int manufacture(Mapply m);

	/**
	 * 派工所需分页+条件查询
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param id
	 * @return
	 */
	List<Mapply> selectAllFromManufacture(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order, @Param("id") Integer id);

	/**
	 * 派工所需分页total
	 * 
	 * @param id
	 * @return
	 */
	long findPagerTotal1(@Param("id") Integer id);
	
	@Select("select max(APPLY_ID) from M_APPLY")
	 String findMax();
}
