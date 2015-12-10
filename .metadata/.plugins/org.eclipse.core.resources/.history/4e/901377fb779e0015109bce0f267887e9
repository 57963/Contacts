package com.contacts.contactList;

import java.util.ArrayList;

import com.contacts.contact.Contact;

public class ContactList {
	private ArrayList <Contact> list = new ArrayList<>();
	private Contact justAdded;
	public ContactList(){
		
	}
	
	public ArrayList <Contact> getList() {
		return list;
	}
	
	public void setList(ArrayList <Contact> list) {
		this.list = list;
	}
	
	public Contact add(Contact contact){
		list.add(contact);
		justAdded = contact;
		return contact;
	}
	
	public void remove(int index){
		list.remove(index);
	}

	public void edit(int index, String attr, String newVal) {
		switch(attr){
		case "firstName":
			list.get(index).setFirstName(newVal);
			break;
		case "surName":
			list.get(index).setSurName(newVal);
		case "number":
			list.get(index).setNumber(newVal);
		}
	}

	public Contact get(int index) {
		return list.get(index);
	}

	public ArrayList<Contact> search(String... names) {
		ArrayList<Contact> out = new ArrayList<>();
		ArrayList<Contact> temp = list;
		for(Contact c: temp){
			for(String name:names){
				if(c.getFirstName().equals(name)||c.getSurName().equals(name)){
					out.add(c);
					temp.set(temp.indexOf(c), null);
				}
			}
		}
		return out;
	}

	public Contact getJustAdded() {
		return justAdded;
	}

	public void setJustAdded(Contact justAdded) {
		this.justAdded = justAdded;
	}
}
