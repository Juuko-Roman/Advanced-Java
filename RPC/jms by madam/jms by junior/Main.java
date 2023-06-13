/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package applicationclient1producer;
import jakarta.jms.*;
import javax.naming.InitialContext;

public class Main {
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

      // Create a JMS Message Producer to send messages to the Queue
      MessageProducer producer = session.createProducer(queue);
      
       System.out.println("Sending mesage to queue");

      // Create a JMS Text Message
      TextMessage message = session.createTextMessage("Hello, World!");

      // Send the JMS Message to the Queue
      producer.send(message);

      // Close the JMS objects
      producer.close();
      session.close();
      connection.close();
   }
}

    

