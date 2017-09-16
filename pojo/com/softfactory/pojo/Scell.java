package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 安全库存配置pojo类
 * 
 * @author 李大为
 * 
 */
public class Scell implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id; // 序号
	private String storeId;// 库存编号
	private String storeName;// 库存名称
	private String productId;// 产品编号
	private String productName;// 产品名称
	private String firstKingId;// 一级分类ID
	private String firstKingName;// 一级分类名称
	private String secondKingId;// 二级分类ID
	private String secondKingName;// 二级分类名称
	private String thirdKingId;// 三级分类ID
	private String thirdKingName;// 三级分类名称
	private Long minAmount;// 报警下限
	private Long maxAmount;// 报警上限
	private Long maxCapacityAmount;// 最大库存量
	private String locId;// 库存地址编号
	private String locName;// 库存地址名称
	private String splName;// 储存单元简称
	private String storageUnit;// 储存单位
	private Long amount;// 当前储存量
	private String config;// 配置要求
	private String designer;// 设计人
	private String register;// 登记人
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date registerTime;// 登记时间
	private String checker;// 复核人
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date checkTime;// 复核时间
	private String checkTag;// 复核标记
	private String productType;// 产品类型
	private String productClass;// 产品档次

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
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

	public String getFirstKingName() {
		return firstKingName;
	}

	public void setFirstKingName(String firstKingName) {
		this.firstKingName = firstKingName;
	}

	public String getSecondKingName() {
		return secondKingName;
	}

	public void setSecondKingName(String secondKingName) {
		this.secondKingName = secondKingName;
	}

	public String getThirdKingName() {
		return thirdKingName;
	}

	public void setThirdKingName(String thirdKingName) {
		this.thirdKingName = thirdKingName;
	}

	public Long getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(Long minAmount) {
		this.minAmount = minAmount;
	}

	public Long getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(Long maxAmount) {
		this.maxAmount = maxAmount;
	}

	public Long getMaxCapacityAmount() {
		return maxCapacityAmount;
	}

	public void setMaxCapacityAmount(Long maxCapacityAmount) {
		this.maxCapacityAmount = maxCapacityAmount;
	}

	public String getLocId() {
		return locId;
	}

	public void setLocId(String locId) {
		this.locId = locId;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	public String getSplName() {
		return splName;
	}

	public void setSplName(String splName) {
		this.splName = splName;
	}

	public String getStorageUnit() {
		return storageUnit;
	}

	public void setStorageUnit(String storageUnit) {
		this.storageUnit = storageUnit;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
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

	public String getCheckTag() {
		return checkTag;
	}

	public void setCheckTag(String checkTag) {
		this.checkTag = checkTag;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductClass() {
		return productClass;
	}

	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}

	public String getFirstKingId() {
		return firstKingId;
	}

	public void setFirstKingId(String firstKingId) {
		this.firstKingId = firstKingId;
	}

	public String getSecondKingId() {
		return secondKingId;
	}

	public void setSecondKingId(String secondKingId) {
		this.secondKingId = secondKingId;
	}

	public String getThirdKingId() {
		return thirdKingId;
	}

	public void setThirdKingId(String thirdKingId) {
		this.thirdKingId = thirdKingId;
	}
}
