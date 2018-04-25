package com.javalearning.spring.SpringTutorial.DIWithJava;

public class ConsumerApplication implements Consumer {

	private MessageService service;
	public ConsumerApplication(MessageService messageService)
	{
	this.service=messageService;
	}
	@Override
	public void processMessage(String msg, String reciever) {
		
		service.sendMessage(msg, reciever);
		
	}

}
