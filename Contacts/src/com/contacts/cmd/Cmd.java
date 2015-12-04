package com.contacts.cmd;

import java.util.List;
import java.util.Scanner;

import com.contacts.contact.Contact;
import com.contacts.returns.Returns;

public class Cmd {
	private static Scanner keyboard = new Scanner(System.in);
	private static String[] input = new String[1];
	private static Contact contactRet;
	private static String nameRet;
	public Cmd() {
		
	}
	
	public static Returns run(){
		input = recieve("Enter a command: ").split(" ");
		switch (input[0]) {
		case "add":
			try {
				addContact(input[1]);
			} catch (ArrayIndexOutOfBoundsException ex) {
				error("Please specify a contact name.");
				return Returns.CONTINUE;
			}
			return Returns.ADD;
		case "stop":
			return Returns.STOP;
		case "search":
			try {
				searchContactReq(input[1]);
			} catch (ArrayIndexOutOfBoundsException ex) {
				error("Please specify a contact name.");
				return Returns.CONTINUE;
			}
			return Returns.SEARCH;
		default:
			error("Please enter a valid command.");
		}
		
		return Returns.CONTINUE;
	}
	
	public static void error(String hint){
		send("/---ERROR----------------\\");
		for(int i = 0; i<Math.round(hint.length()/24+0.5);i++){
			send("|"+hint.substring(i*24, Math.min((i+1)*24,hint.length()))+"                        ".substring(0, 24+(i*24- Math.min((i+1)*24,hint.length())))+"|");
		}
	}

	public static String recieve(String hint) {
		System.out.print(hint);
		return keyboard.nextLine();
	}

	public static void send(String hint) {
		System.out.println(hint);
	}

	public static void addContact(String name) {
		send("adding contact " + name);
		setContactRet(new Contact(name));
	}
	
	public static void searchContactReq(String name){
		setNameRet(name);
	}
	
	public void searchContactView(List<Contact> list){
		send("/---Search Results-------\\");
		for(Contact c:list){
			send(c.getName());
		}
	}

	public Contact getContactRet() {
		return contactRet;
	}

	public static void setContactRet(Contact contactReti) {
		contactRet = contactReti;
	}

	public String getNameRet() {
		return nameRet;
	}

	public static void setNameRet(String nameRet) {
		Cmd.nameRet = nameRet;
	}
}