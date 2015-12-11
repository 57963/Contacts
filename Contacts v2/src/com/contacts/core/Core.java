package com.contacts.core;


import com.contacts.contact.Contact;
import com.contacts.contactList.ContactList;
import com.contacts.meetingList.MeetingList;

public class Core {
	public ContactList contactList = new ContactList();
	MeetingList meetingList = new MeetingList();
	public static void main(String[] args){
		@SuppressWarnings("unused")
		Core core = new Core();
	}
	
	public Core(){
		contactList.add(new Contact());
		contactList.edit(0,"number","01202 564758");
		printContact(contactList.getJustAdded());
	}
	
	public void printContact(Contact contact){
		System.out.println("First Name: "+contact.getFirstName());
		System.out.println("Surname: "+contact.getSurName());
		System.out.println("Home Number: "+contact.getHomeNumber());
		System.out.println("Mobile Number: "+contact.getMobileNumber());
		System.out.println("City: "+contact.getCity());
	}
}
