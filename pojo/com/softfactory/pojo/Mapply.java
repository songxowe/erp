package com.softfactory.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * ��Ʒ�����ƻ�ʵ����
 * 
 * @author Administrator
 * 
 */
public class Mapply implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;// ���
	private String applyId;// �����ƻ����
	private String productId;// ��Ʒ���
	private String productName;// ��Ʒ����
	private String productDescribe;// ��Ʒ����
	private String type;// ��;����
	private Double amount;// ����
	private String designer;// �����
	private String remark;// ��ע
	private String register;// �Ǽ���
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	private Date registerTime;// �Ǽ�ʱ��
	private String checker;// ������
	private String checkSuggestion;// ������
	private Date checkTime;// ���ʱ��
	private String checkTag;// ��˱��
	private String manufactureTag;// �ɹ�״̬

	public Mapply() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
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

	public String getCheckSuggestion() {
		return checkSuggestion;
	}

	public void setCheckSuggestion(String checkSuggestion) {
		this.checkSuggestion = checkSuggestion;
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

	public String getManufactureTag() {
		return manufactureTag;
	}

	public void setManufactureTag(String manufactureTag) {
		this.manufactureTag = manufactureTag;
	}

}
