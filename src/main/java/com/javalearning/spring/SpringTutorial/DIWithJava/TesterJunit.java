package com.javalearning.spring.SpringTutorial.DIWithJava;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesterJunit {
	private MessageServiceInjector injector;
	@Before
	public void setUp(){
		//mock the injector with anonymous class
		injector=new MessageServiceInjector() {
			
			@Override
			public Consumer getConsumer() {
				// TODO Auto-generated method stub
				return new ConsumerApplication(new MessageService() {
					
					@Override
					public void sendMessage(String msg, String receiver) {
						System.out.println("Mock Message Service implementation");
						
					}
				});
			}
		};
				
	}
	@Test
	public void test() {
		Consumer consumer = injector.getConsumer();
		consumer.processMessage("Hi Ritesh", "ritya@kita.com");
	}
	
	@After
	public void tear(){
		injector = null;
	}

}
