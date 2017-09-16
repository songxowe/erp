package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 入库添加数据表
 * */
public class Spays implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;//ID	bigint	序号
	private String gatherId;//GATHER_ID	varchar(50)	入库单编号
	private String store;//STORER	varchar(50)	入库人
	private String reason;//REASON	varchar(20)	入库理由R001-1: 生产入库
	private String reasonexact;//REASONEXACT	varchar(50)	入库详细理由
	private Double amountSum;//AMOUNT_SUM	numeric(12,2)	总件数
	private Double costPriceSun;//COST_PRICE_SUM	numeric(12,2)	总金额
	private Double gatheredAmountSum;//GATHERED_AMOUNT_SUM	numeric(12,2)	已出库总件数
	private String remark;//REMARK	varchar(400)	备注
	private String register;//REGISTER	varchar(50)	登记人
	private Date registerTime;//REGISTER_TIME	datetime	登记时间
	private String checker;//CHECKER	varchar(50)	复核人
	private Date checkTime;//CHECK_TIME	datetime	复核时间
	private String checkTag;//CHECK_TAG	varchar(20)	审核标志S001-1: 审核通过
	private String attemper;//ATTEMPER	varchar(50)	调度人
	private Date attemperTime;//ATTEMPER_TIME	datetime	调度时间
	private String productId;//PRODUCT_ID      NUMBER,商品序号
	private String storeTag;//STORE_TAG	varchar(20)	库存标志K002-1: 已登记K002-2: 已调度
	private Integer demandAmountb;//应入库件数
	private Integer realAmoutb;// 已入库件数
	private Integer nowAmountb;// 本次入库数量
	private Integer demandAmountAllb;// 应入库总件数
	private Integer realAmountAllb;// 已出库总件数
	private Integer demandSalAllb;// 应出库总件数
	private Integer realSalAllb;// 已出库总成本
	
	public Spays(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGatherId() {
		return gatherId;
	}

	public void setGatherId(String gatherId) {
		this.gatherId = gatherId;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
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

	public Double getAmountSum() {
		return amountSum;
	}

	public void setAmountSum(Double amountSum) {
		this.amountSum = amountSum;
	}

	public Double getCostPriceSun() {
		return costPriceSun;
	}

	public void setCostPriceSun(Double costPriceSun) {
		this.costPriceSun = costPriceSun;
	}

	public Double getGatheredAmountSum() {
		return gatheredAmountSum;
	}

	public void setGatheredAmountSum(Double gatheredAmountSum) {
		this.gatheredAmountSum = gatheredAmountSum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckTag() {
		return checkTag;
	}

	public void setCheckTag(String checkTag) {
		this.checkTag = checkTag;
	}

	public String getAttemper() {
		return attemper;
	}

	public void setAttemper(String attemper) {
		this.attemper = attemper;
	}

	public Date getAttemperTime() {
		return attemperTime;
	}

	public void setAttemperTime(Date attemperTime) {
		this.attemperTime = attemperTime;
	}

	public String getStoreTag() {
		return storeTag;
	}

	public void setStoreTag(String storeTag) {
		this.storeTag = storeTag;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getDemandAmountb() {
		return demandAmountb;
	}

	public void setDemandAmountb(Integer demandAmountb) {
		this.demandAmountb = demandAmountb;
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

	public Integer getDemandAmountAllb() {
		return demandAmountAllb;
	}

	public void setDemandAmountAllb(Integer demandAmountAllb) {
		this.demandAmountAllb = demandAmountAllb;
	}

	public Integer getRealAmountAllb() {
		return realAmountAllb;
	}

	public void setRealAmountAllb(Integer realAmountAllb) {
		this.realAmountAllb = realAmountAllb;
	}

	public Integer getDemandSalAllb() {
		return demandSalAllb;
	}

	public void setDemandSalAllb(Integer demandSalAllb) {
		this.demandSalAllb = demandSalAllb;
	}

	public Integer getRealSalAllb() {
		return realSalAllb;
	}

	public void setRealSalAllb(Integer realSalAllb) {
		this.realSalAllb = realSalAllb;
	}
	
	
	
}
