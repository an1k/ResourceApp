package com.resouce.app.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

	private String userName="";
	private int userId=0;
	private ArrayList<String> preferences;
	public User(int userId){
		this.userId=userId;
		init();
	}
	
	
	private void init(){
		
		//initialisation of this object goes here
		
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public ArrayList<String> getPreferences() {
		return preferences;
	}


	public void setPreferences(ArrayList<String> preferences) {
		this.preferences = preferences;
	}
	
	
}

