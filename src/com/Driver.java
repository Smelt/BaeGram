package com;

public class Driver {

	public static void main(String[] args) {
		//message List contains the different messages we send
		MessageList messageList = new MessageList();
		
		//requestLog tracks every time the Button has been pressed including the most
		//recent execution
		RequestLog requestLog = new RequestLog();
		TimeOfDay frame = requestLog.getTimeFrame();
		String message = messageList.getMessage(frame);
		Sender.sendMessage(message);
	
	}

}
