package com.cho.HibPractice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "UserId", unique = true)
	private int id;

	@Column(name = "FName", nullable = false)
	private String FName;
	
	@Column(name = "LName", nullable = false)
	private String LName;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFName() {
		return FName;
	}
	
	public void setFName(String fName) {
		this.FName = fName;
	}
	
	public String getLName() {
		return LName;
	}
	
	public void setLName(String lName) {
		this.LName = lName;
	}
	
	public void printUser(){
		System.out.println("ID: " + this.id);
		System.out.println("Name: " + this.FName + " " + this.LName);
	}
}
