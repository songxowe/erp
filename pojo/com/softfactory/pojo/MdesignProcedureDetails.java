package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

public class MdesignProcedureDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer parentId;
	private Integer detailsNumber;
	private String procedureId;
	private String procedureName;
	private Double labourHourAmount;
	private String procedureDescribe;
	private String amountUnit;
	private Double costPrice;
	private Double subtotal;
	private Double moduleSubtotal;
	private String register;
	private Date registerTime;
	private String designModuleTag;
	private String designModuleChangeTag;

	public MdesignProcedureDetails() {
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

	public String getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(String procedureId) {
		this.procedureId = procedureId;
	}
	
}
