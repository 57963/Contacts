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
	private static Contact editRet;
	private static String[] editArgs;
	private static List<Contact> lastSearch;
	private static String lastSearchReq;
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
			send("/---STOPPING-------------\\");
			return Returns.STOP;
		case "search":
			try {
				searchContactReq(input[1]);
			} catch (ArrayIndexOutOfBoundsException ex) {
				error("Please specify a contact name.");
				return Returns.CONTINUE;
			}
			return Returns.SEARCH;
		case "view":
			try {
				viewContact(input[1]);
			} catch (ArrayIndexOutOfBoundsException ex) {
				error("Please specify a search selection.");
				return Returns.CONTINUE;
			}
			break;
		case "edit":
			try {
				editContact(input[1],input[2],input[3]);
			} catch (Exception ex) {
				error("Please specify a search selection, attribute and new value.");
				return Returns.CONTINUE;
			}
			return Returns.EDIT;
		default:
			error("Please enter a valid command.");
		}
		
		return Returns.CONTINUE;
	}
	
	private static void editContact(String index, String attr, String newVal) {
		editRet = lastSearch.get(Integer.parseInt(index));
		editArgs = (index+" "+newVal).split(" ");
	}

	private static void viewContact(String index) {
		int ind = Integer.parseInt(index);
		try {
			send("/---View-----------------\\");
			sendInBox("Name: "+lastSearch.get(ind).getFirstName()+" "+lastSearch.get(ind).getSurName());
		} catch (ArrayIndexOutOfBoundsException ex) {
			error("Please specify a valid search selection.");
		} catch (NullPointerException ex){
			error("Please make a search first.");
		}
	}

	public static void error(String hint){
		send("/---ERROR----------------\\");
		sendInBox(hint);
	}

	public static String recieve(String hint) {
		System.out.print(hint);
		return keyboard.nextLine();
	}

	public static void send(String hint) {
		System.out.println(hint);
	}

	public static void addContact(String name) {
		send("/---Add Contact----------\\");
		sendInBox(name);
		setContactRet(new Contact(name));
	}
	
	public static void searchContactReq(String name){
		setLastSearchReq(name);
		setNameRet(name);
	}
	
	public void searchContactView(List<Contact> list){
		setLastSearch(list);
		send("/---Search Results-------\\");
		for(Contact c:list){
			sendInBox(c.getFirstName()+"            ".substring(0, Math.max(12-c.getFirstName().length(),0))+ list.indexOf(c));
		}
	}
	
	public static void sendInBox(String text){
		for(int i = 0; i<Math.round(text.length()/24+0.5);i++){
			send("|"+text.substring(i*24, Math.min((i+1)*24,text.length()))+"                        ".substring(0, ((i+1)*24- Math.min((i+1)*24,text.length())))+"|");
		}
	}

	public Contact getContactRet() {
		return contactRet;
	}

	public static void setContactRet(Contact contactRet) {
		Cmd.contactRet = contactRet;
	}

	public String getNameRet() {
		return nameRet;
	}

	public static void setNameRet(String nameRet) {
		Cmd.nameRet = nameRet;
	}

	public static List<Contact> getLastSearch() {
		return lastSearch;
	}

	public static void setLastSearch(List<Contact> lastSearch) {
		Cmd.lastSearch = lastSearch;
	}

	public static Contact getEditRet() {
		return editRet;
	}

	public static void setEditRet(Contact editRet) {
		Cmd.editRet = editRet;
	}

	public static String[] getEditArgs() {
		return editArgs;
	}

	public void setEditArgs(String[] editArgs) {
		Cmd.editArgs = editArgs;
	}

	public static String getLastSearchReq() {
		return lastSearchReq;
	}

	public static void setLastSearchReq(String lastSearchReq) {
		Cmd.lastSearchReq = lastSearchReq;
	}
}
