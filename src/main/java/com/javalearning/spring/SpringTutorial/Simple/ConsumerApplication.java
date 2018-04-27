package com.javalearning.spring.SpringTutorial.Simple;

public class ConsumerApplication {
private EmailService email = new EmailService();
	
	public void processMessages(String msg, String rec){
		//do some msg validation, manipulation logic etc
		this.email.sendEmail(msg, rec);
	}

}
