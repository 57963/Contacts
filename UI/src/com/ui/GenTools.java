package com.ui;

public class GenTools {
	public static boolean isOverRect(float mouseX,float mouseY, float x ,float y,float w,float h){
		if(mouseX<x+w && mouseX>x && mouseY<y+h && mouseY>y){
			return true;
		}
		return false;
	}
}
