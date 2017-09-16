package com.softfactory.pojo;

import java.io.Serializable;

/**
 * 产品分类设置
 * 
 * @author XU
 * 
 */
public class Dkind implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// 序号，not null
	private Integer pid;// 父级序号
	private String kindId;// 分类编号，not null
	private String kindName;// 分类名称，not null

	public Dkind() {

	}

	public Integer getId() {
		return id;
	}

	public Integer getPid() {
		return pid;
	}

	public String getKindId() {
		return kindId;
	}

	public String getKindName() {
		return kindName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setKindId(String kindId) {
		this.kindId = kindId;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

}
