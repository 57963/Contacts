package com.contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ContactList {
	private ArrayList<Contact> list = new ArrayList<>();
	private Contact justAdded;

	public ContactList() {

	}

	public ArrayList<Contact> getList() {
		return list;
	}

	public void setList(ArrayList<Contact> list) {
		this.list = list;
	}

	public Contact add(Contact contact) {
		list.add(0, contact);
		justAdded = contact;
		return contact;
	}

	public void remove(int index) {
		list.remove(index);
	}

	public void edit(int index, String attr, String newVal) {
		switch (attr) {
		case "firstName":
			list.get(index).setFirstName(newVal);
			break;
		case "surName":
			list.get(index).setSurName(newVal);
			break;
		case "number":
			list.get(index).setNumber(newVal);
			break;
		}
	}

	public Contact get(int index) {
		return list.get(index);
	}
	
	public ArrayList<Contact> search(String names) {
		names = names.replaceAll(" ", "");
		Set<Contact> ret = new HashSet<Contact>();
		for(Contact c: list){
			for (String name : names.split(",")) {
				if ((c.getFirstName().toLowerCase()+c.getSurName().toLowerCase()).contains(name.toLowerCase())) {
					ret.add(c);
				}

			}
		}
		ArrayList<Contact> out = new ArrayList<>(ret);
		return out;
	}

	public Contact getJustAdded() {
		return justAdded;
	}

	public void setJustAdded(Contact justAdded) {
		this.justAdded = justAdded;
	}
}
