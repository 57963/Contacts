package com.contacts.init;

import com.contacts.cmd.Cmd;
import com.contacts.contactList.ContactList;
import com.contacts.returns.Returns;

public class Init {
	public static final String version = "v0.0.1alpha";
	private static Cmd cmd;
	private static ContactList list;
	private static Returns returned;
	private static boolean run = true;
	public static void main(String[] args) {
		System.out.println("Contacts " + version);
		cmd = new Cmd();
		list = new ContactList();
		while(run){
			returned = Cmd.run();
			switch(returned){
			case ADD:
				list.add(cmd.getContactRet());
				Cmd.setContactRet(null);
				break;
			case STOP:
				run = false;
				break;
			case SEARCH:
				if(cmd.getNameRet().equals("*")){
					cmd.searchContactView(list.getList());
				} else {
					cmd.searchContactView(list.search(cmd.getNameRet()));
				}
			default:
				break;
			}
			System.out.println("\\------------------------/");
		}
	}

}