package com.hjs.study.spring.bean;

import java.util.List;

/**
 * 系统菜单类
 * @author Administrator
 *
 */
public class Menu {

	private int id;
	
	private String text;
	
	private String url;
	
	private String urltent;
	
	private int location;
	
	private int isFolder;
	
	private int parent;
	
	private String parentText;
	
	private String template;
	
	private List<Menu> children;
	
	private String state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public int getIsFolder() {
		return isFolder;
	}

	public void setIsFolder(int isFolder) {
		this.isFolder = isFolder;
	}

	public String getParentText() {
		return parentText;
	}

	public void setParentText(String parentText) {
		this.parentText = parentText;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUrltent() {
		return urltent;
	}

	public void setUrltent(String urltent) {
		this.urltent = urltent;
	}
}
