package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class MdesignProcedure implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String designId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String thirdKindId;
	private String thirdKindName;
	private String productId;
	private String productName;
	private String procedureDescribe;
	private Double costPriceSum;
	private Double moduleCostPriceSum;
	private String designer;
	private String register;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date registerTime;;
	private String checker;
	private Date checkTime;
	private String checkSuggestion;
	private String checkTag;
	private String changer;
	private Date changeTime;
	private String changeTag;
	private String designModuleTag;
	private String designModuleChangeTag;

	public MdesignProcedure() {
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
