package com.softfactory.core.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Manufacture;
import com.softfactory.pojo.MpModule;
import com.softfactory.pojo.Mprocedure;
import com.softfactory.pojo.QueryResult;

@Repository("lbQueryMapper")
public interface LbQueryMapper {
	
	List<QueryResult>findPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order,@Param("manufactureProcedureTag") String manufactureProcedureTag,
			@Param("manufactureId") String manufactureId,@Param("detailsNumber") Integer detailsNumber,
			@Param("checkTag") String checkTag,	@Param("keyword") String keyword,@Param("status") String status,@Param("beginTime") Date beginTime,@Param("endTime") Date endTime);
	
	Long findPagerTotal(@Param("manufactureProcedureTag") String manufactureProcedureTag,
			@Param("manufactureId") String manufactureId,@Param("detailsNumber") Integer detailsNumber,
			@Param("checkTag") String checkTag,	@Param("keyword") String keyword,@Param("status") String status,@Param("beginTime") Date beginTime,@Param("endTime") Date endTime);

	Manufacture findByMid(String manufactureId);

	List<Mprocedure> findByParentId(Integer id);

	@Select("select GATHER_ID from S_GATHER where MaId=#{id}")
	String findByMaId(Integer id);

	Manufacture findById(Integer id);

	Mprocedure findMprocedure(Integer mid);

	List<MpModule> findByParent(Integer id);
}
