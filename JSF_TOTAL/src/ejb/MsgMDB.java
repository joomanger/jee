package ejb;

import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/Queue")
public class MsgMDB implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		try {
			System.out.println("MDB принял сообщение: " + ((TextMessage) msg).getText());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
