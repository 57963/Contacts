package goodui;

import java.util.ArrayList;

import com.contacts.Contact;
import com.contacts.Core;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class GoodUI extends PApplet {
	Core core;
	String state = "contacts";
	Contact toView;
	boolean mouse = true;

	public static void main(String _args[]) {
		PApplet.main(new String[] { goodui.GoodUI.class.getName() });
	}

	public void setup() {
		core = new Core();
		noStroke();
	}

	public void settings() {
		size(1000, 700);
	}

	public void draw() {
		background(250);
		switch (state) {
		case "contacts":
			if (input.length() == 0) {
				conScrollBox(core.getContactList().getList());
			} else {
				conScrollBox(core.getContactList().search(input));
			}
			searchBar();
			addButton();
			break;
		case "view":
			contactView();
			break;
		case "add":
			add();
		}
		fill(0);
		textSize(12);
		text("Contacts © Callum & Ollie 2015", 0, 12);
	}
	
	public boolean clickedSection(float x, float y, float w, float h){
		if(mousePressed && mouseX>x && mouseY>y && mouseX<x+w&&mouseY<y+h){
			return true;
		}
		return false;
	}
	int toEdit;
	public void contactEdit(int attr, Contact toEdit,String toAdd ){
		switch(attr){
		case 1:
			//toEdit.
		}
	}
	
	public void add() {
		fill(200);
		rect(20, 20, width - 40, height - 40);
		textSize(30);
		fill(150);
		for(int i = 0;i<5;i++){
			rect(25,31+40*i,width-50,36);
			if(mouse && clickedSection(25,31+40*i,width-50,36)){
				toEdit = i;
				println(toEdit);
				mouse = false;
			}
		}
		if (mousePressed && mouse) {
			state = "contacts";
			mouse = false;
		}
		fill(0);
		text("First Name: ", 30, 60);
		text("Surname: ", 30, 100);
		text("Home Number: ", 30, 140);
		text("Mobile Number: ", 30, 180);
		text("City: ", 30, 220);
	}

	private void addButton() {
		fill(200);
		rect(width-40,20,20,25);
		fill(50);
		rect(width-32,25,4,16);
		rect(width-37,31,14,4);
		if (mouse && clickedSection(width-40,20,20,35)) {
			state = "add";
			core.getContactList().add(new Contact());
			mouse = false;
		}
		
	}

	public void contactView() {
		fill(200);
		rect(20, 20, width - 40, height - 40);
		textSize(30);
		fill(0);
		text("Name: " + toView.getFirstName() + " " + toView.getSurName(), 30, 60);
		text("Home Number: " + toView.getHomeNumber(), 30, 100);
		text("Mobile Number: " + toView.getMobileNumber(), 30, 140);
		text("City: " + toView.getCity(), 30, 180);
		if (mousePressed && mouse) {
			state = "contacts";
			mouse = false;
		}
	}

	public void mouseWheel(MouseEvent event) {
		if(state == "contacts"){
			scrollerPos+=event.getCount()*10;
		}
	}

	public void mouseReleased() {
		mouse = true;
		scrolling = false;
	}

	String input = "";

	public void searchBar() {
		fill(200);
		rect(20, 20, width - 65, 25);
		fill(0);
		text(input, 30, 35);
	}

	public void keyPressed() {
		if (key == BACKSPACE) {
			if (input.length() > 0) {
				input = input.substring(0, input.length() - 1);
			}
		} else if (key != CODED && key != ENTER) {
			input += key;
		}
		if(state == "add"){
			
		}
	}

	float scrollerPos = 0;
	float scrollerHeight;
	boolean scrolling;

	public void conScrollBox(ArrayList<Contact> list) {
		textSize(12);
		scrollerHeight = (float) (((float) (height - 70) / ((list.size() * 110) - 10)) * (height - 70.0));
		if (clickedSection(width-40,scrollerPos+50,20,scrollerHeight)||scrolling) {
			scrollerPos += mouseY - pmouseY;
			scrolling = true;
			mouse = false;
		}
		scrollerHeight = constrain(scrollerHeight, 0, height - 70);
		scrollerPos = constrain(scrollerPos, 0, height - 70 - scrollerHeight);

		pushMatrix();
		translate(0, -scrollerPos * ((float) ((list.size() * 110) - 10) / (height - 70)));
		for (int i = 0; i < list.size(); i++) {
			Contact c = list.get(i);
			pushMatrix();
			translate(20, 50 + i * 110);
			fill(200);
			if (mouse &&
					clickedSection(20,50 + i * 110 - scrollerPos * ((float) ((list.size() * 110) - 10) / (height - 70)),width-65,100)
					&& !clickedSection(width-135,60 + i * 110 - scrollerPos * ((float) ((list.size() * 110) - 10) / (height - 70)),80,80)) {
				state = "view";
				toView = list.get(i);
				mouse = false;
			}
			if(mouse&&clickedSection(width-135,60 + i * 110 - scrollerPos * ((float) ((list.size() * 110) - 10) / (height - 70)),80,80)){
				core.getContactList().remove(i);
				mouse = false;
			}
			rect(0, 0, width - 65, 100);
			fill(0);
			text("Name: " + c.getFirstName() + " " + c.getSurName(), 10, 20);
			text("Home Number: " + c.getHomeNumber(), 10, 35);
			text("Mobile Number: " + c.getMobileNumber(), 10, 50);
			text("City: " + c.getCity(), 10, 65);
			fill(150);
			rect(width-155,10,80,80);
			fill(50);
			rect(width-135,45,40,10);
			popMatrix();
		}
		popMatrix();
		fill(150);
		rect(width - 40, 50, 20, height - 70);
		fill(200);
		rect(width - 40, scrollerPos + 50, 20, scrollerHeight);
		fill(250);
		rect(0, 0, width, 50);
		rect(0, height - 20, width, 20);
	}
}
