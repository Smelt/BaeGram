package com;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;



public class RequestLog {

	private final String fileName = "Res/RequestLog.txt";
	private ArrayList<Timestamp> requests;


	/**
	 * This class takes the RequestLog.txt and transforms it into an ArrayList. Right now
	 * we don't do anything with that information however in the future that could be of utility.
	 * 
	 * It also appends the current time onto the textFile.
	 */	
	public RequestLog(){
		requests = new ArrayList<Timestamp>();
		addRequest();
		parseRequestFile();

	}
	/**
	 * This method takes the last request (the time when the program was called and returns the time 
	 * of day using switch statements. 
	 * @return
	 */
	public TimeOfDay getTimeFrame(){
		Timestamp recent = requests.get(requests.size() - 1);
		@SuppressWarnings("deprecation")
		int hour = recent.getHours();
		switch(hour){
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			return TimeOfDay.MORNING;
		case 11:
		case 12:
		case 13:
		case 14:
		case 15:
		case 16:
		case 17:
		case 18:
		case 19:
		case 20:
			return TimeOfDay.AFTERNOON;
		default:
			return TimeOfDay.NIGHT;
		
		}
	}

	/**
	 * This method appends the current time to the Request File
	 */
	public void addRequest(){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		File requestFile = new File(fileName);
		try{
			PrintWriter writer = new PrintWriter(new FileWriter(requestFile, true));
			writer.println(timestamp.toString());
			writer.close();
		} catch (IOException e) {
			//eventually we will write errors to a log file. 
		}
	}
	
	/**
	 * This method parses the RequestLog.txt into the Requests ArrayList
	 */
	private void parseRequestFile() {
		File requestFile = new File(fileName);
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(requestFile);

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			while(sc.hasNext()){
				String str = sc.nextLine();
				java.util.Date parsedDate = dateFormat.parse(str);
			    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
			    requests.add(timestamp);
			}
	


		} catch (FileNotFoundException | ParseException e) {
			// Ideally this will write to a log file. 
			e.printStackTrace();
		}

	}



}
