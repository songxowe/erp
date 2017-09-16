package com.softfactory.core.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Dmodule;

/**
 * 产品物料组成映射器接口
 * 
 * @author Administrator
 * 
 */
@Repository("xinYouDmoduleMapper")
public interface XinYouDmoduleMapper {
	void add(Dmodule dmodule);

	int modify(Dmodule dmodule);

	// 审核
	@Update("UPDATE D_MODULE SET REGISTER=#{register},CHECK_TAG=#{checkTag},COST_PRICE_SUM=#{costPriceSum} where ID =#{id}")
	int modify1(@Param(value = "id") Integer id,
			@Param(value = "costPriceSum") Double costPriceSum,
			@Param(value = "checkTag") String checkTag,
			@Param(value = "register") String register,
			@Param(value = "checkTime") Date checkTime);

	int remove(Integer id);

	Dmodule findById(Integer id);

	Dmodule findByproductId(String productId);

	/**
	 * 分页查询 + 条件查询
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param id
	 * @return
	 */
	List<Dmodule> findPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order, @Param("id") Integer id,
			@Param("designId") String designId,
			@Param("productId") String productId,
			@Param("productName") String productName,
			@Param("firstKindName") String firstKindName,
			@Param("secondKindName") String secondKindName,
			@Param("thirdKindName") String thirdKindName,
			@Param("designer") String designer,
			@Param("register") String register,
			@Param("registerTime") Date registerTime,
			@Param("checker") String checker, @Param("changer") String changer,
			@Param("checkTag") String checkTag,
			@Param("changeTag") String changeTag);

	long findPagerTotal(@Param("id") Integer id,
			@Param("designId") String designId,
			@Param("productId") String productId,
			@Param("productName") String productName,
			@Param("firstKindName") String firstKindName,
			@Param("secondKindName") String secondKindName,
			@Param("thirdKindName") String thirdKindName,
			@Param("designer") String designer,
			@Param("register") String register,
			@Param("registerTime") Date registerTime,
			@Param("checker") String checker, @Param("changer") String changer,
			@Param("checkTag") String checkTag,
			@Param("changeTag") String changeTag);

	/**
	 * 物料组成设计单查询
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param id
	 * @return
	 */
	List<Dmodule> findPager2(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order, @Param("id") Integer id,
			@Param("designId") String designId,
			@Param("productId") String productId,
			@Param("productName") String productName,
			@Param("firstKindName") String firstKindName,
			@Param("secondKindName") String secondKindName,
			@Param("thirdKindName") String thirdKindName,
			@Param("designer") String designer,
			@Param("register") String register,
			@Param("registerTime") Date registerTime,
			@Param("checker") String checker, @Param("changer") String changer,
			@Param("checkTag") String checkTag,
			@Param("changeTag") String changeTag);

	long findPagerTotal2(@Param("id") Integer id,
			@Param("designId") String designId,
			@Param("productId") String productId,
			@Param("productName") String productName,
			@Param("firstKindName") String firstKindName,
			@Param("secondKindName") String secondKindName,
			@Param("thirdKindName") String thirdKindName,
			@Param("designer") String designer,
			@Param("register") String register,
			@Param("registerTime") Date registerTime,
			@Param("checker") String checker, @Param("changer") String changer,
			@Param("checkTag") String checkTag,
			@Param("changeTag") String changeTag);

	/**
	 * 物料组成设计单变更
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param id
	 * @return
	 */
	List<Dmodule> findPager3(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order, @Param("id") Integer id,
			@Param("designId") String designId,
			@Param("productId") String productId,
			@Param("productName") String productName,
			@Param("firstKindName") String firstKindName,
			@Param("secondKindName") String secondKindName,
			@Param("thirdKindName") String thirdKindName,
			@Param("designer") String designer,
			@Param("register") String register,
			@Param("registerTime") Date registerTime,
			@Param("checker") String checker, @Param("changer") String changer,
			@Param("checkTag") String checkTag,
			@Param("changeTag") String changeTag);

	long findPagerTotal3(@Param("id") Integer id,
			@Param("designId") String designId,
			@Param("productId") String productId,
			@Param("productName") String productName,
			@Param("firstKindName") String firstKindName,
			@Param("secondKindName") String secondKindName,
			@Param("thirdKindName") String thirdKindName,
			@Param("designer") String designer,
			@Param("register") String register,
			@Param("registerTime") Date registerTime,
			@Param("checker") String checker, @Param("changer") String changer,
			@Param("checkTag") String checkTag,
			@Param("changeTag") String changeTag);

	Dmodule FindByInsert(@Param("productId") String productId);

	String FindBy();

	int FindByInsert1(@Param("productId") String productId);

	@Update("update D_MODULE t set t.cost_price_sum=#{c} where product_id=#{productId}")
	void updateSum(@Param("c") double c, @Param("productId") String productId);

	@Update("update D_FILE t set t.design_module_tag='W001-1' where t.product_id=#{productId}")
	void updateState(@Param("productId") String productId);

	@Update("update D_MODULE t set t.checker=#{checker},t.check_time=sysdate,t.check_tag=#{checkTag} where t.design_id=#{designId}")
	void UpdateState1(@Param("checker") String checker,
			@Param("checkTag") String checkTag,
			@Param("designId") String designId);
}
