package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 出库调度类
 * @author caiqg
 *
 */
public class StorageScheduleOut implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;//出库表的主键ID						1
	private String gatherId;//出库单序号GATHER_ID					1	2	3
	private String productId;//产品编号PRODUCT_ID				2	3
	private String productName;//产品名称PROUCT_NAME			2	3
	private Double costPrice;//成本单价COST_PRICE				3
	private Integer demandAmounta;//应出库件数DEMAND_AMOUNTA
	private Integer demandAmountAlla;// 应出库总件数DEMAND_AMOUNT_ALLA
	private Integer realAmouta;// 已出库件数REAL_AMOUNTA		2
	private Integer nowAmounta;// 本次出库数NOW_AMOUNTA		2	3
	private String reason;// 出库理由REASON				1	2
	private String reasonexact;//出库详细理由REASONEXACT	1	2
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
	private Integer demandSalAlla;//应出库总成本
	private Integer realAmountAlla;//已出库总件数
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public String getGatherId() {
		return gatherId;
	}
	public void setGatherId(String gatherId) {
		this.gatherId = gatherId;
	}
	public Integer getDemandAmounta() {
		return demandAmounta;
	}
	public void setDemandAmounta(Integer demandAmounta) {
		this.demandAmounta = demandAmounta;
	}
	public Integer getDemandAmountAlla() {
		return demandAmountAlla;
	}
	public void setDemandAmountAlla(Integer demandAmountAlla) {
		this.demandAmountAlla = demandAmountAlla;
	}
	public Integer getRealAmouta() {
		return realAmouta;
	}
	public void setRealAmouta(Integer realAmouta) {
		this.realAmouta = realAmouta;
	}
	public Integer getNowAmounta() {
		return nowAmounta;
	}
	public void setNowAmounta(Integer nowAmounta) {
		this.nowAmounta = nowAmounta;
	}
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
	public Integer getDemandSalAlla() {
		return demandSalAlla;
	}
	public void setDemandSalAlla(Integer demandSalAlla) {
		this.demandSalAlla = demandSalAlla;
	}
	public Integer getRealAmountAlla() {
		return realAmountAlla;
	}
	public void setRealAmountAlla(Integer realAmountAlla) {
		this.realAmountAlla = realAmountAlla;
	}
	
	
}
