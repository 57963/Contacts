package com.contacts;

import java.util.ArrayList;
import java.util.Date;

public class Meeting {
	private String name;
	private Contact owner;
	private ArrayList<Contact> admins = new ArrayList<>();
	private ArrayList<Contact> members = new ArrayList<>();
	private Date dateTime = new Date();
	public Meeting(Contact owner){
		addMember(owner);
		addAdmin(0);
		setOwner(0);
	}
	
	public void addMember(Contact contact){
		members.add(contact);
	}
	public void addAdmin(int index){
		admins.add(members.get(index));
	}
	public void setOwner(int index) {
		this.owner = admins.get(index);
	}
	
	
	public Contact getOwner() {
		return owner;
	}
	public ArrayList<Contact> getAdmins() {
		return admins;
	}
	public void setAdmins(ArrayList<Contact> admins) {
		this.admins = admins;
	}
	public ArrayList<Contact> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<Contact> members) {
		this.members = members;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}