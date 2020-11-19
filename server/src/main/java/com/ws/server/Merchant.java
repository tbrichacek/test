package com.ws.server;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Merchant {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("signUpDate")
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date signUpDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}

	@Override
	public String toString() {
		return "Merchant [name=" + name + ", signUpDate=" + signUpDate + "]";
	}

}
