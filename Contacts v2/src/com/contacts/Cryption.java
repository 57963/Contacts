package com.contacts;

public class Cryption {
	public Cryption(){
	}
	
	public String encrypt(String toEncrypt,String key){
		String out = "";
		toEncrypt = key + toEncrypt;
		for(char c: toEncrypt.toCharArray()){
			out += (char)(((int)c)+1+key.length());
		}
		return out;
	}
	
	public String decrypt(String toDecrypt,String key){
		String out = "";
		for(char c: toDecrypt.toCharArray()){
			out += (char)(((int)c)-1-key.length());
		}
		if(!out.substring(0,key.length()).equals(key)){
			return null;
		}
		out = out.substring(key.length());
		return out;
	}
}
