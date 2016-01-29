package com.ui;

import java.util.ArrayList;
import com.contacts.*;
import processing.core.PApplet;

public class ContactDisplay{
	float width;
	float height;
	PApplet main;
	ArrayList<Contact> list;
	float scrollPos;
	public ContactDisplay(float width, float height, ArrayList<Contact> list, PApplet main){
		this.width = width;
		this.height = height;
		this.main = main;
		this.list = list;
	}
	
	public void draw(){
		main.noStroke();
		main.fill(200);
		main.rect(0,0,width,height);
		
		
		for(int i = 0;i<list.size();i++){
			main.pushMatrix();
			main.translate(5,5+(100*i)+scrollPos);
			main.fill(100);
			main.rect(0,0,width-30,95);
			main.fill(0);
			main.text(list.get(i).getFirstName()+" "+list.get(i).getSurName(), 10, 20);
			main.popMatrix();
		}
		
	}
}