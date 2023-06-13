import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class TopicProducer {

    public static void main(String[] args) {
        try {
            // Set up JNDI properties
            Properties properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            properties.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");

            // Create InitialContext
            Context context = new InitialContext(properties);

            // Look up ConnectionFactory and Topic
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
            Topic topic = (Topic) context.lookup("topic/topic1");

            // Create Connection, Session, and MessageProducer
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(topic);

            // Create and send messages
            for (int i = 1; i <= 10; i++) {
                String messageText = "Message " + i;
                TextMessage message = session.createTextMessage(messageText);
                producer.send(message);
                System.out.println("Sent message: " + messageText);
            }

            // Clean up
            producer.close();
            session.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
