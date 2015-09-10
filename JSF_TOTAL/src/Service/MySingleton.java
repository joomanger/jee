package Service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import ejb.Messagez;

@Singleton
@Startup
public class MySingleton {
	@EJB
	private Messagez messages;

	@PostConstruct
	public void init() {
		try {
			System.out.println("Тестим JMS");
			messages.sendMessage("AsyncAlex");
			messages.sendMessage("AsyncSavin");
			messages.receiveAsyncMessage();
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
		}

	}
}
