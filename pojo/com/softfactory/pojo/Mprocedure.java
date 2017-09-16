package com.softfactory.pojo;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 * 
 */
public class Mprocedure implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;// 序号
	private Integer parentId;// 派工单序号
	private Integer detailsNumber;// 工序序号
	private String procedureId;// 工序编号
	private String procedureName;// 工序名称
	private Double labourHourAmount;// 设计工时数
	private Double realLabourHourAmount;//实际工时数
	private Double subtotal;// 设计工时成本
	private Double realSubtotal;// 实际工时成本
	private Double moduleSubtotal;// 设计物料成本
	private Double realModuleSubtotal;// 实际物料成本
	private Double costPrice;// 单位工时成本
	private Double demandAmount;// 需求数量
	private Double realAmount;//实际数量
	private String procedureFinishTag;// 工序完成标(G004-0: 未开始G004-1: 已完成G004-2: 未完成	G004-3: 已审核)
	private String procedureTransferTag;// 工序交接标(G005-0: 未交接G005-1: 已交接G005-2: 已审核)
	
	public Mprocedure() {

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

	public Double getLabourHourAmount() {
		return labourHourAmount;
	}

	public void setLabourHourAmount(Double labourHourAmount) {
		this.labourHourAmount = labourHourAmount;
	}

	public Double getRealLabourHourAmount() {
		return realLabourHourAmount;
	}

	public void setRealLabourHourAmount(Double realLabourHourAmount) {
		this.realLabourHourAmount = realLabourHourAmount;
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

	public Double getModuleSubtotal() {
		return moduleSubtotal;
	}

	public void setModuleSubtotal(Double moduleSubtotal) {
		this.moduleSubtotal = moduleSubtotal;
	}

	public Double getRealModuleSubtotal() {
		return realModuleSubtotal;
	}

	public void setRealModuleSubtotal(Double realModuleSubtotal) {
		this.realModuleSubtotal = realModuleSubtotal;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Double getDemandAmount() {
		return demandAmount;
	}

	public void setDemandAmount(Double demandAmount) {
		this.demandAmount = demandAmount;
	}

	public Double getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(Double realAmount) {
		this.realAmount = realAmount;
	}

	public String getProcedureFinishTag() {
		return procedureFinishTag;
	}

	public void setProcedureFinishTag(String procedureFinishTag) {
		this.procedureFinishTag = procedureFinishTag;
	}

	public String getProcedureTransferTag() {
		return procedureTransferTag;
	}

	public void setProcedureTransferTag(String procedureTransferTag) {
		this.procedureTransferTag = procedureTransferTag;
	}

}
