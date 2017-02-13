package com;

import java.io.File;
import java.util.ArrayList;

public class MessageList {
	
	private static ArrayList<String> morningMessges;
	private static ArrayList<String> afternoonMessages;
	private static ArrayList<String> nightMessages;
	
	private final String filePath;
	
	public MessageList(String fileName){
		String fileLocation = "/Res/";
		
		this.filePath = fileLocation + fileName;
		System.out.println(filePath);
	}
	
	

}
