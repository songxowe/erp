package com.softfactory.pojo.dto;

import java.io.Serializable;

/**
 * 工序物料设计单单个产品所有物料数据DTO
 * 
 * @author shengchen
 * 
 */
public class Pm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer detid;// 序号
	private String productName;// 物料名称
	private String productId;// 物料编号
	private String productDescribe;// 描述
	private Double amount;// 数量
	private String amountUnit;// 单位
	private Double costPrice;// 单价

	public Pm() {

	}

	public Integer getDetid() {
		return detid;
	}

	public void setDetid(Integer detid) {
		this.detid = detid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	@Override
	public String toString() {
		return "Pm [detid=" + detid + ", productName=" + productName
				+ ", productId=" + productId + ", productDescribe="
				+ productDescribe + ", amount=" + amount + ", amountUnit="
				+ amountUnit + ", costPrice=" + costPrice + "]";
	}

}
