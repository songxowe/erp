package com.softfactory.pojo;

import java.io.Serializable;

/**
 * 入库明细 
 * @author huzjian
 *
 */
public class SPayDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//序号
	private Integer parentId;//入库单序号
	private String productId;//产品编号
	private String productName;//产品名称
	private String productDescribe;//类型
	private Double amount;//数量
	private String amountUnit;//单位
	private Double costPrice;//单价
	private Double subtotal;//小计
	private Integer paidAmount;//确认入库件数
	private String payTag;//入库标志

	
	
	public SPayDetails(){
		
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
	public String getProductDescribe() {
		return productDescribe;
	}
	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
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
	public Integer getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Integer paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getPayTag() {
		return payTag;
	}
	public void setPayTag(String payTag) {
		this.payTag = payTag;
	}
	
	
	
	
}
