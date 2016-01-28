package com.contacts.contact;

public class Contact {
	private String firstName = "";
	private String surName = "";
	private String homeNumber = "";
	private String mobileNumber = "";
	private String city = "";
	
	public Contact(){
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setNumber(String number) {
		number = number.replaceAll(" ", "");
		switch(number.substring(0, 2)){
		case "01":
			setHomeNumber(number);
			break;
		case "02": setMobileNumber(number);break;
		case "03": setMobileNumber(number);break;
		case "04": setMobileNumber(number);break;
		case "05": setMobileNumber(number);break;
		case "06": setMobileNumber(number);break;
		case "07":
			setMobileNumber(number);
			break;
		case "08": setMobileNumber(number);break;
		case "09": setMobileNumber(number);break;
		default:
			System.out.println("All UK numbers must start with 0, no changes have been made");
		}
	}
	public String getHomeNumber() {
		return homeNumber;
	}
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
