package com.isd.entities;

import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Transient;

@Entity
public class News {

	// ��������� ��������� ����
	@EmbeddedId
	private NewsId id;

	// ������ ������� �� ����� ������ � ������� News
	@Transient
	private String notIntoDataBase;

	// LAZY content �� ����� ����� ��������, ���� �� ��������� � ��� �������
	@Basic(fetch = FetchType.LAZY)
	private String content;

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	public News(String content) {
		super();
		this.content = content;
	}

	public NewsId getId() {
		return id;
	}

	public void setId(NewsId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "News title:" + id.getTitle() + "; lang:" + id.getLang() + "; content:" + content;
	}

}
