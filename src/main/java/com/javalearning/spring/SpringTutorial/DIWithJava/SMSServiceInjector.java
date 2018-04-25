package com.javalearning.spring.SpringTutorial.DIWithJava;

public class SMSServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		
		return new ConsumerApplication(new SMSServiceImpl());
	}

}
