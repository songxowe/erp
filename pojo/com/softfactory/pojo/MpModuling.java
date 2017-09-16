package com.softfactory.pojo;

import java.io.Serializable;

/**
 * 生产物料过程记录
 * */
public class MpModuling implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// 序号
	private Integer parentId;// 派工单工序序号
	private Integer detailsNumber;// 本工序物料序号
	private String productId;// 产品编号
	private String productName;// 产品名称
	private double costPrice;// 物料单价
	private double amount;//本次使用数量
	private double subtotal;//物料成本
	
	public MpModuling(){
		
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

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	
}
