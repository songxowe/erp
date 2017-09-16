package com.softfactory.pojo;

import java.io.Serializable;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 生产总表
 * 
 * @author Administrator
 * 
 */
public class Manufacture implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// 序号
	private String manufactureId;// 派工单编号
	private String productId;// 产品编号
	private String productName;// 产品名称
	private Integer amount;// 投产数量
	private Integer testedAmount;// 合格数量
	private String applyIdGroup;// 生产计划序号组
	private String productDescribe;// 产品描述
	private Double moduleCostPriceSum;// 设计物料总成本
	private Double realModuleCostPriceSum;// 实际物料总成本
	private Double labourCostPriceSum;// 设计工时总成本
	private Double realLabourCostPriceSum;// 实际工时总成本
	private String designer;// 工单指定人
	private String register;// 登记人
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date registerTime;// 登记时间
	private String checker;// 审核人
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date checkTime;// 审核时间
	private String remark;// 备注
	private String checkTag;// 审核标志S001-0: 等待审核; S001-1: 审核通过; S001-2: 审核不通过
	private String manufactureProcedureTag;// 生产过程标志 S002-0: 待登记;S002-1:
											// 未审核;S002-2: 已完工

	public Manufacture() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getManufactureId() {
		return manufactureId;
	}

	public void setManufactureId(String manufactureId) {
		this.manufactureId = manufactureId;
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getTestedAmount() {
		return testedAmount;
	}

	public void setTestedAmount(Integer testedAmount) {
		this.testedAmount = testedAmount;
	}

	public String getApplyIdGroup() {
		return applyIdGroup;
	}

	public void setApplyIdGroup(String applyIdGroup) {
		this.applyIdGroup = applyIdGroup;
	}

	public String getProductDescribe() {
		return productDescribe;
	}

	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}

	public Double getModuleCostPriceSum() {
		return moduleCostPriceSum;
	}

	public void setModuleCostPriceSum(Double moduleCostPriceSum) {
		this.moduleCostPriceSum = moduleCostPriceSum;
	}

	public Double getRealModuleCostPriceSum() {
		return realModuleCostPriceSum;
	}

	public void setRealModuleCostPriceSum(Double realModuleCostPriceSum) {
		this.realModuleCostPriceSum = realModuleCostPriceSum;
	}

	public Double getLabourCostPriceSum() {
		return labourCostPriceSum;
	}

	public void setLabourCostPriceSum(Double labourCostPriceSum) {
		this.labourCostPriceSum = labourCostPriceSum;
	}

	public Double getRealLabourCostPriceSum() {
		return realLabourCostPriceSum;
	}

	public void setRealLabourCostPriceSum(Double realLabourCostPriceSum) {
		this.realLabourCostPriceSum = realLabourCostPriceSum;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCheckTag() {
		return checkTag;
	}

	public void setCheckTag(String checkTag) {
		this.checkTag = checkTag;
	}

	public String getManufactureProcedureTag() {
		return manufactureProcedureTag;
	}

	public void setManufactureProcedureTag(String manufactureProcedureTag) {
		this.manufactureProcedureTag = manufactureProcedureTag;
	}

}
