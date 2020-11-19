package com.ws.server;

public class State {

	private String name;
	private String abbreviation;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
	
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	@Override
	public String toString() {
		return "State [name=" + name + ", abbreviation=" + abbreviation + "]";
	}
}
