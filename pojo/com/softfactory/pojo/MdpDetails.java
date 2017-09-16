package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 产品生产工序明细
 * 
 */
public class MdpDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;// 序号
	private Integer parentId;// 产品序号
	private Integer detailsNumber;// 工序序号
	private String procedureId;// 工序编号
	private String procedureName;// 工序名称
	private Double labourHourAmount;// 工时数
	private String procedureDescribe;// 工序描述
	private String amountUnit;// 单位
	private Double costPrice;// 单位工时成本
	private Double subtotal;// 工时成本小计
	private Double moduleSubtotal;// 物料成本小计
	private String register;// 登记人
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date registerTime;// 登记时间
	private String designModuleTag;// 当前工序物料标志 D002-0: 未设计 D002-1: 已设计
	private String designModuleChangeTag;// 当前工序物料变更标志 D003-0: 未变更 D003-0: 已变更

	public MdpDetails() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getDetailsNumber() {
		return detailsNumber;
	}

	public void setDetailsNumber(Integer detailsNumber) {
		this.detailsNumber = detailsNumber;
	}

	public String getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(String procedureId) {
		this.procedureId = procedureId;
	}

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public Double getLabourHourAmount() {
		return labourHourAmount;
	}

	public void setLabourHourAmount(Double labourHourAmount) {
		this.labourHourAmount = labourHourAmount;
	}

	public String getProcedureDescribe() {
		return procedureDescribe;
	}

	public void setProcedureDescribe(String procedureDescribe) {
		this.procedureDescribe = procedureDescribe;
	}

	public String getAmountUnit() {
		return amountUnit;
	}

	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getModuleSubtotal() {
		return moduleSubtotal;
	}

	public void setModuleSubtotal(Double moduleSubtotal) {
		this.moduleSubtotal = moduleSubtotal;
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
