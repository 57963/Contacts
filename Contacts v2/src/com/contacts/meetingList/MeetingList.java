package com.contacts.meetingList;

import java.util.ArrayList;
import com.contacts.meeting.Meeting;

public class MeetingList {
	private ArrayList <Meeting> list = new ArrayList<>();
	private Meeting justAdded;
	public MeetingList(){
		
	}
	public ArrayList <Meeting> getList() {
		return list;
	}
	public void setList(ArrayList <Meeting> list) {
		this.list = list;
	}
	public Meeting add(Meeting meeting){
		list.add(0,meeting);
		justAdded = meeting;
		return meeting;
	}
	
	public void remove(int index){
		list.remove(index);
	}

	public void edit(int index, String attr, String newVal) {
		switch(attr){
		case "name":
			list.get(index).setName(newVal);
			break;
		default:
			break;
		}
	}

	public Meeting get(int index) {
		return list.get(index);
	}

	public ArrayList<Meeting> search(String... names) {
		ArrayList<Meeting> out = new ArrayList<>();
		/*ArrayList<Meeting> temp = list;
		for(Meeting m: temp){
			for(String name:names){
				if(m.getFirstName().equals(name)||m.getSurName().equals(name)){
					out.add(m);
					temp.set(temp.indexOf(m), null);
				}
			}
		}*/
		return out;
	}

	public Meeting getJustAdded() {
		return justAdded;
	}

	public void setJustAdded(Meeting justAdded) {
		this.justAdded = justAdded;
	}
}
