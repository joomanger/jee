package ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQTextMessage;

@Stateless
public class Messagez {
	@Resource
	private ConnectionFactory connectionFactory;

	@Resource(name = "jms/Queue")
	private Queue chatQueue;

	public void sendMessage(String text) throws JMSException {

		Connection connection = null;
		Session session = null;

		try {
			connection = connectionFactory.createConnection();
			connection.start();

			// Create a Session
			/*
			 * В транзакционных сессиях подтверждение происходит автоматически
			 * при успешном завершении транзакции. Если транзакция откатывается,
			 * все потреблен- ные сообщения доставляются повторно. В
			 * нетранзакционных же сеансах должен быть указан режим
			 * подтверждения.  AUTO_ACKNOWLEDGE — сеанс автоматически
			 * подтверждает получение сообщения.  CLIENT_ACKNOWLEDGE — клиент
			 * подтверждает сообщение явным вызовом метода Message.acknowledge()
			 * .  DUPS_OK_ACKNOWLEDGE — этот параметр указывает сеансу неспешно
			 * подтвердить доставку сообщения. Это может привести к многократной
			 * доставке некоторых сообщений, если происходит сбой поставщика
			 * JMS, поэтому его следует ис- пользовать потребителям, которые
			 * могут допускать дублирование сообщений. Если сообщение было
			 * доставлено повторно, поставщик устанавливает значение поля
			 * заголовка JMSRedelivered в true
			 */
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Create a MessageProducer from the Session to the Topic or Queue
			MessageProducer producer = session.createProducer(chatQueue);
			// Задание стойкости сообщения.
			/*
			 * JMS поддерживает два режима доставки сообщений: стойкую и
			 * нестойкую. Стойкая доставка гарантирует, что сообщение
			 * доставляется потребителю только один раз, в случае нестойкой
			 * сообщение может быть и не доставлено. Стойкая доставка (ис-
			 * пользуемая по умолчанию) надежнее, но это стоит
			 * производительности, так как она предотвращает потери сообщения,
			 * если произошел сбой поставщика.
			 */
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			// Create a message
			TextMessage message = session.createTextMessage(text);

			// Tell the producer to send the message
			producer.send(message);

		} finally {
			// Clean up
			if (session != null)
				session.close();
			if (connection != null)
				connection.close();
		}
	}

	public void receiveMessage() throws JMSException {

		Connection connection = null;
		Session session = null;
		MessageConsumer consumer = null;
		try {
			connection = connectionFactory.createConnection();
			connection.start();

			// Create a Session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Create a MessageConsumer from the Session to the Topic or Queue
			consumer = session.createConsumer(chatQueue);

			// Wait for a message
			while (true) {
				System.out.println(((TextMessage) consumer.receive(1000)).getText());
			}
			/*
			 * TextMessage message = (TextMessage) consumer.receive(1000);
			 * 
			 * return message.getText() + new Date();
			 */
		} finally {
			if (consumer != null)
				consumer.close();
			if (session != null)
				session.close();
			if (connection != null)
				connection.close();
		}
	}

	public void receiveAsyncMessage() throws Exception {
		Connection connection = null;
		Session session = null;
		MessageConsumer consumer = null;
		try {
			connection = connectionFactory.createConnection();

			// Create a Session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Create a MessageConsumer from the Session to the Topic or Queue
			consumer = session.createConsumer(chatQueue);
			consumer.setMessageListener(new MessageListener() {

				@Override
				public void onMessage(Message msg) {
					// TODO Auto-generated method stub
					try {
						System.out.println("Получено асинхронное сообщение: " + ((ActiveMQTextMessage) msg).getText());
					} catch (JMSException ex) {
						System.out.println(ex.getMessage());
					}
				}
			});
			connection.start();
			Thread.sleep(1000);
		} finally {
			if (consumer != null)
				consumer.close();
			if (session != null)
				session.close();
			if (connection != null)
				connection.close();
		}
	}
}
