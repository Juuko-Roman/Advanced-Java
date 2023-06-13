import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class TopicSubscriber implements MessageListener {

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

            // Create Connection, Session, and MessageConsumer
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer subscriber = session.createConsumer(topic);

            // Set message listener
            TopicSubscriber topicSubscriber = new TopicSubscriber();
            subscriber.setMessageListener(topicSubscriber);

            // Start connection
            connection.start();

            // Wait for messages
            System.out.println("Waiting for messages. Press Ctrl+C to exit.");
            Thread.sleep(Long.MAX_VALUE);

            // Clean up
            subscriber.close();
            session.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String text = textMessage.getText();
                System.out.println("Received message: " + text);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
