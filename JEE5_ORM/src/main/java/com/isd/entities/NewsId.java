package com.isd.entities;

import javax.persistence.Embeddable;

@Embeddable
public class NewsId {
	private String title;
	private String lang;

	public NewsId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewsId(String title, String lang) {
		super();
		this.title = title;
		this.lang = lang;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

}
