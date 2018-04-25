package com.javalearning.spring.SpringTutorial.DIWithJava;

public class SMSServiceImpl implements MessageService{

	@Override
	public void sendMessage(String msg, String receiver) {
		System.out.println("SMS sent to "+receiver+ " with Message="+msg);
		
	}

}
