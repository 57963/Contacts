package com.contacts.contactList;
import java.util.ArrayList;
import java.util.List;

import com.contacts.contact.*;
public class ContactList {
	private List<Contact> list = new ArrayList<>();
	public ContactList(){
		
	}
	public List<Contact> search(String name) {
		List<Contact> ret = new ArrayList<>();
		for(Contact c: list){
			if(c.getName().equals(name)){
				ret.add(c);
			}
		}
		return ret;
	}
	public void printList(){
		System.out.println(list);
	}
	public void add(Contact contact){
		list.add(contact);
	}
	public List<Contact> getList() {
		return list;
	}
	public void setList(List<Contact> list) {
		this.list = list;
	}
}