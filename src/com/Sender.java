package com;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Sender {
	/**
	 * Users need to enter in their own Account ID and phone numbers 
	 */
  private static final String ACCOUNT_SID = "";
  private static final String AUTH_TOKEN = "";
  private static final String toNumberString = "";
  private static final String fromNumberString = "";

 public static void sendMessage(String messageText){
	 try{
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    PhoneNumber toNumber = new PhoneNumber(toNumberString);
    PhoneNumber fromNumber = new PhoneNumber(fromNumberString);
  
    Message message = Message.creator(toNumber, fromNumber, messageText).create();
	 }
	 catch(Exception e){
		 
	 }
    
            
         
  }
}