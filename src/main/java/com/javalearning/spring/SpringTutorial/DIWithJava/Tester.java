package com.javalearning.spring.SpringTutorial.DIWithJava;

public class Tester {
public static void main(String[] args) {
	String msg = "Hi Rahul";
	String email = "rahul@abc.com";
	String phone = "87898765678";
	MessageServiceInjector injector=null;
	Consumer application=null;
	//Send email
	injector=new EmailServiceInjector();
	application=injector.getConsumer();
	application.processMessage(msg, email);
	//Send Message
	injector=new SMSServiceInjector();
	application=injector.getConsumer();
	application.processMessage(msg, phone);
	
	
}
}
