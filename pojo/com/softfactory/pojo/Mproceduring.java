package com.softfactory.pojo;

import java.io.Serializable;
/**
 * 生产工序过程记录
 * */
import java.util.Date;
public class Mproceduring implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;//序号
	private Integer parentId;//派工单序号
	private Integer detailsNumber;//工序序号
	private String procedureId;//工序编号
	private String procedureName;//工序名称
	private double labourHourAmount;//本次工时数
	private double costPrice;//单位工时成本
	private double subtotal;//工时成本小计
	private String rocedureDescribe;//工序描述
	private Integer regCount;//登记次数
	private String procedureResponsiblePerson;//负责人
	private String register;//登记人
	private Date registerTime;//登记时间
	private String checker;//审核人
	private Date checkTime;//审核时间
	
	public Mproceduring(){
		
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

	public String getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(String procedureId) {
		this.procedureId = procedureId;
	}

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public double getLabourHourAmount() {
		return labourHourAmount;
	}

	public void setLabourHourAmount(double labourHourAmount) {
		this.labourHourAmount = labourHourAmount;
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

	public String getRocedureDescribe() {
		return rocedureDescribe;
	}

	public void setRocedureDescribe(String rocedureDescribe) {
		this.rocedureDescribe = rocedureDescribe;
	}

	public Integer getRegCount() {
		return regCount;
	}

	public void setRegCount(Integer regCount) {
		this.regCount = regCount;
	}

	public String getProcedureResponsiblePerson() {
		return procedureResponsiblePerson;
	}

	public void setProcedureResponsiblePerson(String procedureResponsiblePerson) {
		this.procedureResponsiblePerson = procedureResponsiblePerson;
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
	
	
}
