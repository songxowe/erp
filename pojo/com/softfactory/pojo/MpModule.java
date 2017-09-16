package com.softfactory.pojo;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 * 
 */
public class MpModule implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;// 序号
	private Integer parentId;// 派工单工序序号
	private Integer detailsNumber;// 本工序物料序号
	private String productId;// 产品编号
	private String productName;//产品名称
	private Double costPrice;// 物料单价
	private Double amount;// 数量
	private Double renewAmount;// 补充数量
	private Double realAmount;// 实际数量
	private Double subtotal;// 物料小计
	private Double realSubtotal;// 实际物料小计

	public MpModule() {
		// TODO Auto-generated constructor stub
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

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getRenewAmount() {
		return renewAmount;
	}

	public void setRenewAmount(Double renewAmount) {
		this.renewAmount = renewAmount;
	}

	public Double getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(Double realAmount) {
		this.realAmount = realAmount;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getRealSubtotal() {
		return realSubtotal;
	}

	public void setRealSubtotal(Double realSubtotal) {
		this.realSubtotal = realSubtotal;
	}

	@Override
	public String toString() {
		return "MpModule [id=" + id + ", parentId=" + parentId
				+ ", detailsNumber=" + detailsNumber + ", productId="
				+ productId + ", productName=" + productName + ", costPrice="
				+ costPrice + ", amount=" + amount + ", renewAmount="
				+ renewAmount + ", realAmount=" + realAmount + ", subtotal="
				+ subtotal + ", realSubtotal=" + realSubtotal + "]";
	}
	
	

}
