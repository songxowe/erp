package com.softfactory.pojo;

import java.io.Serializable;

public class QueryResult implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String manufactureId;//派工单编号
	private String productId;//产品编号
	private String productName;//产品名称
	private Double amount;//投产数量
	private Double testedAmount;//合格数量
	private String procedureFinishTag;//工序完成标(G004-0: 未开始G004-1: 已完成G004-2: 未完成	G004-3: 已审核)
	private String manufactureProcedureTag;//生产过程标志
	public QueryResult(){
		
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


	public String getProcedureFinishTag() {
		return procedureFinishTag;
	}
	public void setProcedureFinishTag(String procedureFinishTag) {
		this.procedureFinishTag = procedureFinishTag;
	}
	public String getManufactureProcedureTag() {
		return manufactureProcedureTag;
	}
	public void setManufactureProcedureTag(String manufactureProcedureTag) {
		this.manufactureProcedureTag = manufactureProcedureTag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getTestedAmount() {
		return testedAmount;
	}

	public void setTestedAmount(Double testedAmount) {
		this.testedAmount = testedAmount;
	}
	
	

}
