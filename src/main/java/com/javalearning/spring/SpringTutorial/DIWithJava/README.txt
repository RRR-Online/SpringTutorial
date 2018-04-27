let’s see how we can apply java dependency injection pattern to solve all the problems with above 
implementation. Dependency Injection in java requires at least following:
Service components should be designed with base class or interface. 
It’s better to prefer interfaces or abstract classes that would define contract for the services.
Consumer classes should be written in terms of service interface.
Injector classes that will initialize the services and then the consumer classes.

Java Dependency Injection – Service Components
For our case, we can have MessageService that will declare the contract for service implementations.
/**
 * 
 */
package com.javalearning.spring.SpringTutorial.DIWithJava;

/**
 * @author Rahat
 *
 */
public interface MessageService {
	
	void sendMessage(String msg,String receiver);

}
Now let’s say we have Email and SMS services that implement above interfaces.

package com.javalearning.spring.SpringTutorial.DIWithJava;

public class EmailServiceImpl implements MessageService{

	@Override
	public void sendMessage(String msg, String receiver) {
		System.out.println("Email sent to "+receiver+ " with Message="+msg);
		
	}

}

package com.javalearning.spring.SpringTutorial.DIWithJava;

public class SMSServiceImpl implements MessageService{

	@Override
	public void sendMessage(String msg, String receiver) {
		System.out.println("SMS sent to "+receiver+ " with Message="+msg);
		
	}

}

Our dependency injection java services are ready and now we can write our consumer class.

Java Dependency Injection – Service Consumer
We are not required to have base interfaces for consumer classes but I will have a Consumer interface declaring contract for consumer classes.

package com.javalearning.spring.SpringTutorial.DIWithJava;

public interface Consumer {
	
	void processMessage(String msg,String reciever);

}
My consumer class implementation is like below.

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
Notice that our application class is just using the service. It does not initialize the service that leads to better “separation of concerns“. Also use of service interface allows us to easily test the application by mocking the MessageService and bind the services at runtime rather than compile time.

Now we are ready to write java dependency injector classes that will initialize the service and also consumer classes.

Java Dependency Injection – Injectors Classes
Let’s have an interface MessageServiceInjector with method declaration that returns the Consumer class.

package com.javalearning.spring.SpringTutorial.DIWithJava;

public interface MessageServiceInjector {
	
	public Consumer getConsumer();
}

package com.javalearning.spring.SpringTutorial.DIWithJava;

public class EmailServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		
		return new ConsumerApplication(new EmailServiceImpl());
	}

}


package com.javalearning.spring.SpringTutorial.DIWithJava;

public class SMSServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		
		return new ConsumerApplication(new SMSServiceImpl());
	}

}

Now let’s see how our client applications will use the application with a simple program.

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



