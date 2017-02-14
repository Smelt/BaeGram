package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

enum TimeOfDay{
	MORNING, AFTERNOON, NIGHT;
}

public class MessageList {
	
	private static ArrayList<String> morningMessages;
	private static ArrayList<String> afternoonMessages;
	private static ArrayList<String> nightMessages;
	
	private final String filePath;
	static final String fileHeading = "Res/";
	
	public MessageList(String fileName){
		
		//we initialize the ArrayLists
		morningMessages = new ArrayList<String>();
		afternoonMessages = new ArrayList<String>();
		nightMessages = new ArrayList<String>();

		
		this.filePath = "Res/" + fileName;
		File messageFile = new File(filePath);
		parseMessageFile(messageFile);
		
	}
	
	private void parseMessageFile(File messageFile){	
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(messageFile);
			TimeOfDay category = TimeOfDay.MORNING;
			while(sc.hasNext()){
				
				String str = sc.nextLine();
				if(str.equals("Morning:")){
					category = TimeOfDay.MORNING;
				}
				if(str.equals("Afternoon:")){
					category = TimeOfDay.AFTERNOON;
				}
				if(str.equals("Night:")){
					category = TimeOfDay.NIGHT;
				}
				addToCategory(category, str);
			}
			morningMessages.remove("Morning:");
			afternoonMessages.remove("Afternoon:");
			nightMessages.remove("Night");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addToCategory(TimeOfDay category, String str){
		
		if(category == TimeOfDay.MORNING){
			morningMessages.add(str);

		}
		if(category == TimeOfDay.AFTERNOON){
			afternoonMessages.add(str);
			
		}
		if(category == TimeOfDay.NIGHT){
			nightMessages.add(str);
			
		}
		
	}
	
	

}
