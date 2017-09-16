package com.softfactory.pojo;

import java.io.Serializable;

public class MdpModule implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;//ID	bigint	序号
	private Integer parentId;//PARENT_ID	bigint	产品工序序号
	private Integer detailsNumber;//DETAILS_NUMBER	bigint	本工序物料序号
	private String productId;//PRODUCT_ID	varchar(50)	物料编号
	private String productName;//PRODUCT_NAME	varchar(50)	物料名称
	private String type;//TYPE	varchar(20)	用途类型
	private double amount;//AMOUNT	numeric(12,2)	本工序数量
	private String productDescribe;//PRODUCT_DESCRIBE	varchar(400)	描述
	private String amountUnit;//AMOUNT_UNIT	varchar(20)	单位
	private double costPrice;//COST_PRICE	numeric(12,2)	单价
	private double subtotal;//SUBTOTAL	numeric(12,2)	小计
	
	public MdpModule(){
		
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getProductDescribe() {
		return productDescribe;
	}

	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}

	public String getAmountUnit() {
		return amountUnit;
	}

	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
}
