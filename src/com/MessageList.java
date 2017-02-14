package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Shivam Satyarthi
 *
 *This Class contains 3 ArrayLists that contain the possible messages we send out.
 *The text messages are loaded from the TextMessage.txt file
 */

public class MessageList {
	
	private ArrayList<String> morningMessages;
	private ArrayList<String> afternoonMessages;
	private ArrayList<String> nightMessages;
	
	
	private final String fileName = "Res/TextMessages.txt";

	
	public MessageList(){
		
		//we initialize the ArrayLists
		morningMessages = new ArrayList<String>();
		afternoonMessages = new ArrayList<String>();
		nightMessages = new ArrayList<String>();
		//we then parse the file for information
		File messageFile = new File(fileName);
		parseMessageFile(messageFile);
		
	}
	/**
	 * This function takes a time of day and returns a randomized text message 
	 * depending on the time of day
	 * @param time
	 * @return
	 */
	public String getMessage(TimeOfDay time){
		Random r = new Random(System.currentTimeMillis());
		int random = r.nextInt(10000);
		switch(time){
		case MORNING:
			return morningMessages.get(random%morningMessages.size());
		case AFTERNOON:
			return afternoonMessages.get(random%afternoonMessages.size());
		case NIGHT:
			return nightMessages.get(random%nightMessages.size());
		default:
			return "Hey babe :)";
		}
	}
	/**
	 * This function takes in the message file and parses through it and records the 
	 * possible array values in their respective arrays
	 * @param messageFile
	 */
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
	/**
	 * This is a helper function that takes in a time of Day and line from our TextMessage 
	 * File and inserts it into the proper ArrayList
	 * @param category
	 * @param str
	 */
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
