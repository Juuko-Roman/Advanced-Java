/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package applicationclient1consumer;
import jakarta.jms.*;
import javax.naming.InitialContext;

public class JmsReceiver implements MessageListener {

   public static void main(String[] args) throws Exception {

      // Obtain a JNDI connection context to the GlassFish server
      InitialContext context = new InitialContext();

      // Lookup the JMS Queue by its JNDI name
      Queue queue = (Queue) context.lookup("MyQueue");

      // Obtain a JMS Connection Factory using the GlassFish JNDI name
      ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/ConnectionFactory");

      // Create a JMS Connection using the Connection Factory
      Connection connection = connectionFactory.createConnection();

      // Start the JMS Connection
      connection.start();

      // Create a JMS Session using the Connection
      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

      // Create a JMS Message Consumer to receive messages from the Queue
      MessageConsumer consumer = session.createConsumer(queue);

      // Set the MessageListener on the Consumer to receive messages asynchronously
      consumer.setMessageListener(new JmsReceiver());

      System.out.println("Waiting for messages...");

      // Close the JMS objects
      consumer.close();
      session.close();
      connection.close();
   }

   // Implement the onMessage method of the MessageListener interface
   public void onMessage(Message message) {
      try {
         // Cast the JMS Message to a Text Message
         TextMessage textMessage = (TextMessage) message;

         // Print the text of the message
         System.out.println("Received message: " + textMessage.getText());
      } catch (JMSException e) {
         System.err.println("Error receiving message: " + e.getMessage());
      }
   }
}
