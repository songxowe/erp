package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 入库  
 * @author huzujian
 *
 */
public class SPay implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;// 序号
	private String payId;// 入库单编号
	private String storer;// 入库人
	private String reason;// 入库理由
	private String reasonexact;// 入库详细理由
	private Double amountSum;// 总件数
	private Double costPriceSum;// 总金额
	private Double paidAmountSum;// 确认入库总件数
	private String remark;// 备注
	private String register;// 登记人
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date registerTime;// 登记时间
	private String checker;// 复核人
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkTime;// 复核时间
	private String checkTag;//审核标志
	private String attmper;//调度人
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date attemperTime;//调度时间
	private String productId;//商品ID
	private String storeTag;//库存标志
	private Integer demandAmountb;//应入库件数
	private Integer realAmoutb;// 已入库件数
	private Integer nowAmountb;// 本次入库数量
	private Integer demandAmountAllb;// 应入库总件数
	private Integer realAmountAllb;// 已出库总件数
	private Integer demandSalAllb;// 应出库总件数
	private Integer realSalAllb;// 已出库总成本
	
	
	public SPay(){
		
	}
	
	
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
	public String getStorer() {
		return storer;
	}
	public void setStorer(String storer) {
		this.storer = storer;
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
	public Double getCostPriceSum() {
		return costPriceSum;
	}
	public void setCostPriceSum(Double costPriceSum) {
		this.costPriceSum = costPriceSum;
	}
	public Double getPaidAmountSum() {
		return paidAmountSum;
	}
	public void setPaidAmountSum(Double paidAmountSum) {
		this.paidAmountSum = paidAmountSum;
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
	public String getAttmper() {
		return attmper;
	}
	public void setAttmper(String attmper) {
		this.attmper = attmper;
	}
	public Date getAttemperTime() {
		return attemperTime;
	}
	public void setAttemperTime(Date attemperTime) {
		this.attemperTime = attemperTime;
	}
	
	
	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getStoreTag() {
		return storeTag;
	}
	public void setStoreTag(String storeTag) {
		this.storeTag = storeTag;
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
	public void setNowAmountb(Integer mowAmountb) {
		this.nowAmountb = mowAmountb;
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
