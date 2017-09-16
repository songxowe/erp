package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 产品生产工序
 * 
 * @author 
 * 
 */
public class MdProcedure implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;// 序号
	private String designId;// 设计编号
	private String firstKindId;// 产品I级分类编号
	private String firstKindName;// 产品I级分类名称
	private String secondKindId;// 产品II级分类编号
	private String secondKindName;// 产品II级分类名称
	private String thirdKindId;// 产品III级分类编号
	private String thirdKindName;// 产品III级分类名称
	private String productId;// 产品编号
	private String productName;// 产品名称
	private String procedureDescribe;// 设计要求
	private Double costPriceSum;// 工时总成本
	private Double moduleCostPriceSum;// 物料总成本
	private String designer;// 设计人
	private String register;// 登记人
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date registerTime;// 登记时间
	private String checker;// 复核人
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date checkTime;// 审核时间
	private String checkSuggestion;// 审核意见
	private String checkTag;// 审核标志 S001-0: 等待审核 S001-1: 审核通过 S001-2: 审核不通过
	private String changer;// 变更人
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date changeTime;// 变更时间
	private String changeTag;// 变更标志 B002-0: 未变更 B002-1: 已变更
	private String designModuleTag;// 工序物料设计标志 G002-0: 未设计 G002-1: 已提交 G002-2:
									// 已审核
	private String designModuleChangeTag;// 工序物料变更标志 G003-0: 未变更 G003-1: 已变更

	public MdProcedure() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesignId() {
		return designId;
	}

	public void setDesignId(String designId) {
		this.designId = designId;
	}

	public String getFirstKindId() {
		return firstKindId;
	}

	public void setFirstKindId(String firstKindId) {
		this.firstKindId = firstKindId;
	}

	public String getFirstKindName() {
		return firstKindName;
	}

	public void setFirstKindName(String firstKindName) {
		this.firstKindName = firstKindName;
	}

	public String getSecondKindId() {
		return secondKindId;
	}

	public void setSecondKindId(String secondKindId) {
		this.secondKindId = secondKindId;
	}

	public String getSecondKindName() {
		return secondKindName;
	}

	public void setSecondKindName(String secondKindName) {
		this.secondKindName = secondKindName;
	}

	public String getThirdKindId() {
		return thirdKindId;
	}

	public void setThirdKindId(String thirdKindId) {
		this.thirdKindId = thirdKindId;
	}

	public String getThirdKindName() {
		return thirdKindName;
	}

	public void setThirdKindName(String thirdKindName) {
		this.thirdKindName = thirdKindName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProcedureDescribe() {
		return procedureDescribe;
	}

	public void setProcedureDescribe(String procedureDescribe) {
		this.procedureDescribe = procedureDescribe;
	}

	public Double getCostPriceSum() {
		return costPriceSum;
	}

	public void setCostPriceSum(Double costPriceSum) {
		this.costPriceSum = costPriceSum;
	}

	public Double getModuleCostPriceSum() {
		return moduleCostPriceSum;
	}

	public void setModuleCostPriceSum(Double moduleCostPriceSum) {
		this.moduleCostPriceSum = moduleCostPriceSum;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckSuggestion() {
		return checkSuggestion;
	}

	public void setCheckSuggestion(String checkSuggestion) {
		this.checkSuggestion = checkSuggestion;
	}

	public String getCheckTag() {
		return checkTag;
	}

	public void setCheckTag(String checkTag) {
		this.checkTag = checkTag;
	}

	public String getChanger() {
		return changer;
	}

	public void setChanger(String changer) {
		this.changer = changer;
	}

	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	public String getChangeTag() {
		return changeTag;
	}

	public void setChangeTag(String changeTag) {
		this.changeTag = changeTag;
	}

	public String getDesignModuleTag() {
		return designModuleTag;
	}

	public void setDesignModuleTag(String designModuleTag) {
		this.designModuleTag = designModuleTag;
	}

	public String getDesignModuleChangeTag() {
		return designModuleChangeTag;
	}

	public void setDesignModuleChangeTag(String designModuleChangeTag) {
		this.designModuleChangeTag = designModuleChangeTag;
	}

}
