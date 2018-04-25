package com.javalearning.spring.SpringTutorial.DIWithJava;

public class EmailServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		
		return new ConsumerApplication(new EmailServiceImpl());
	}

}
