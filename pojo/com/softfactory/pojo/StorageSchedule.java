package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 入库调度类
 * @author caiqg
 *
 */
public class StorageSchedule implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;//入库表的主键ID						1
	private String payId;//入库单序号PAY_ID					1	2	3
	private String productId;//产品编号PRODUCT_ID				2	3
	private String productName;//产品名称PROUCT_NAME			2	3
	private Double productPrice;//成本单价COST_PRICE				3
	private Integer demandAmountb;//应入库件数DEMAND_AMOUNTB
	private Integer demandAmountAllb;// 应入库总件数DEMAND_AMOUNT_ALLB
	private Integer realAmoutb;// 已入库件数REAL_AMOUNTB		2
	private Integer nowAmountb;// 本次入库数NOW_AMOUNTB			2	3
	private String reason;// 入库理由REASON				1	2
	private String reasonexact;//入库详细理由REASONEXACT	1	2
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registerTime;//登记时间	REGISTER_TIME	1
	private Double amountSum;// 总件数AMOUNT_SUM			1
	private Double costPriceSum;// 总金额COST_PRICE_SUM	1
	private String storeName;//库房名称STORE_NAME				3
	private String locId;//存储地址编号LOC_ID				3
	private String locName;//存储地址名称LOC_NAME				3
	private String splName;//存储单元简称SPL_NAME			3
	private String currentAmount;//当前可存放量CURRENTAMOUNT		3
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date attemperTime;//调度时间ATTEMPER_TIME				3
	private String register;// 登记人
	private String payTag;//详单库存标志
	private String storeTag;//入库单库存标志

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
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
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getDemandAmountb() {
		return demandAmountb;
	}
	public void setDemandAmountb(Integer demandAmountb) {
		this.demandAmountb = demandAmountb;
	}
	public Integer getDemandAmountAllb() {
		return demandAmountAllb;
	}
	public void setDemandAmountAllb(Integer demandAmountAllb) {
		this.demandAmountAllb = demandAmountAllb;
	}
	public Integer getRealAmoutb() {
		return realAmoutb;
	}
	public void setRealAmoutb(Integer realAmoutb) {
		this.realAmoutb = realAmoutb;
	}
	public Integer getNowAmountb() {
		return nowAmountb;
	}
	public void setNowAmountb(Integer nowAmountb) {
		this.nowAmountb = nowAmountb;
	}
	/*
	 * public String getStoragLocation() {
		return storagLocation;
	}
	public void setStoragLocation(String storagLocation) {
		this.storagLocation = storagLocation;
	}
	*/
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReasonexact() {
		return reasonexact;
	}
	public void setReasonexact(String reasonexact) {
		this.reasonexact = reasonexact;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public Double getAmountSum() {
		return amountSum;
	}
	public void setAmountSum(Double amountSum) {
		this.amountSum = amountSum;
	}
	public Double getCostPriceSum() {
		return costPriceSum;
	}
	public void setCostPriceSum(Double costPriceSum) {
		this.costPriceSum = costPriceSum;
	}
	
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
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
	public String getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(String currentAmount) {
		this.currentAmount = currentAmount;
	}
	public Date getAttemperTime() {
		return attemperTime;
	}
	public void setAttemperTime(Date attemperTime) {
		this.attemperTime = attemperTime;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	
	public String getPayTag() {
		return payTag;
	}
	public void setPayTag(String payTag) {
		this.payTag = payTag;
	}
	public String getStoreTag() {
		return storeTag;
	}
	public void setStoreTag(String storeTag) {
		this.storeTag = storeTag;
	}
	@Override
	public String toString() {
		return "StorageSchedule [id=" + id + ", payId=" + payId
				+ ", productId=" + productId + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", demandAmountb="
				+ demandAmountb + ", demandAmountAllb=" + demandAmountAllb
				+ ", realAmoutb=" + realAmoutb + ", nowAmountb=" + nowAmountb
				+ ", reason=" + reason + ", reasonexact=" + reasonexact
				+ ", registerTime=" + registerTime + ", amountSum=" + amountSum
				+ ", costPriceSum=" + costPriceSum + ", storeName=" + storeName
				+ ", locId=" + locId + ", locName=" + locName + ", splName="
				+ splName + ", currentAmount=" + currentAmount
				+ ", attemperTime=" + attemperTime + "]";
	}
	
	
}
