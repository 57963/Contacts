package com.contacts.core;


import com.contacts.contact.Contact;
import com.contacts.contactList.ContactList;

public class Core {
	ContactList list = new ContactList();
	public static void main(String[] args){
		@SuppressWarnings("unused")
		Core core = new Core();
	}
	
	public Core(){
		list.add(new Contact());
		list.edit(0,"number","01202 564758");
		printContact(list.getJustAdded());
	}
	
	public void printContact(Contact contact){
		System.out.println("First Name: "+contact.getFirstName());
		System.out.println("Surname: "+contact.getSurName());
		System.out.println("Home Number: "+contact.getHomeNumber());
		System.out.println("Mobile Number: "+contact.getMobileNumber());
		System.out.println("City: "+contact.getCity());
	}
}