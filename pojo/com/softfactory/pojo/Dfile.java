package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品档案实体类
 * 
 * @author XU
 * 
 */
public class Dfile implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// 序号，not null
	private String productId;// 产品编号，not null
	private String productName;// 产品名称，not null
	private String factoryName;// 制造商
	private String firstKindId;// 产品I级分类编号
	private String firstKindName;// 产品I级分类名称
	private String secondKindId;// 产品II级分类编号
	private String secondKindName;// 产品II级分类名称
	private String thirdKindId;// 产品III级分类编号
	private String thirdKindName;// 产品III级分类名称
	private String productNick;// 产品简称
	private String type;// 用途类型 Y001-1:商品 Y001-2:物料
	private String productClass;// 档次级别 D001-1:高档 D001-2:中档 D001-3:低档
	private String personalUnit;// 计量单位
	private String personalValue;// 计量值
	private String providerGroup;//供应商集合 PROVIDER_GROUP
	private Double listPrice;// 市场单价，not null
	private Double costPrice;// 计划成本单价，not null
	private Double realCostPrice;// 成本单价
	private String amountUnit;//单位 AMOUNT_UNIT          
	private String productDescribe;// 产品描述
	private String responsiblePerson;// 产品经理
	private String register;// 登记人
	private Date registerTime;// 建档时间
	private String checker;// 复核人
	private Date checkTime;// 复核时间
	private String checkTag;// 审核标志，not null，S001-0:等待审核 S001-1:审核通过
							// S001-2:审核不通过
	private String changer;// 变更人
	private Date changeTime;// 变更时间
	private String changeTag;// 档案变更标志，not null，D001-0:未变更 D001-1:已变更
	private String priceChangeTag;// 价格变更标志，not null，J001-0:未变更 J001-1:已变更
	private Integer fileChangeAmount;// 档案变更累计
	private String deleteTag;// 产品删除标志，not null，C001-0:未删除 C001-1:已删除
	private String designModuleTag;// 物料组成标志，not null，W001-0:未设计 W001-1:已设计
	private String designProcedureTag;// 工序组成标志 ，not null，G001-0:未设计 G001-1:已设计
	private String designCellTag;// 库存分配标志 ，not null，K001-0:未设计 K001-1:已设计

	public Dfile() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
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

	public String getProductNick() {
		return productNick;
	}

	public void setProductNick(String productNick) {
		this.productNick = productNick;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProductClass() {
		return productClass;
	}

	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}

	public String getPersonalUnit() {
		return personalUnit;
	}

	public void setPersonalUnit(String personalUnit) {
		this.personalUnit = personalUnit;
	}

	public String getPersonalValue() {
		return personalValue;
	}

	public void setPersonalValue(String personalValue) {
		this.personalValue = personalValue;
	}

	public String getProviderGroup() {
		return providerGroup;
	}

	public void setProviderGroup(String providerGroup) {
		this.providerGroup = providerGroup;
	}

	public Double getListPrice() {
		return listPrice;
	}

	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Double getRealCostPrice() {
		return realCostPrice;
	}

	public void setRealCostPrice(Double realCostPrice) {
		this.realCostPrice = realCostPrice;
	}

	public String getAmountUnit() {
		return amountUnit;
	}

	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
	}

	public String getProductDescribe() {
		return productDescribe;
	}

	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}

	public String getResponsiblePerson() {
		return responsiblePerson;
	}

	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
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

	public String getPriceChangeTag() {
		return priceChangeTag;
	}

	public void setPriceChangeTag(String priceChangeTag) {
		this.priceChangeTag = priceChangeTag;
	}

	public Integer getFileChangeAmount() {
		return fileChangeAmount;
	}

	public void setFileChangeAmount(Integer fileChangeAmount) {
		this.fileChangeAmount = fileChangeAmount;
	}

	public String getDeleteTag() {
		return deleteTag;
	}

	public void setDeleteTag(String deleteTag) {
		this.deleteTag = deleteTag;
	}

	public String getDesignModuleTag() {
		return designModuleTag;
	}

	public void setDesignModuleTag(String designModuleTag) {
		this.designModuleTag = designModuleTag;
	}

	public String getDesignProcedureTag() {
		return designProcedureTag;
	}

	public void setDesignProcedureTag(String designProcedureTag) {
		this.designProcedureTag = designProcedureTag;
	}

	public String getDesignCellTag() {
		return designCellTag;
	}

	public void setDesignCellTag(String designCellTag) {
		this.designCellTag = designCellTag;
	}

	
}
