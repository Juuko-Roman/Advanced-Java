/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author spectre
 */
@WebServlet(urlPatterns = {"/ElectionConsumer"})
public class ElectionConsumer extends HttpServlet {
    @Resource(mappedName = "jms/electionConnectionFactory")
        private ConnectionFactory connectionFactory;
      
    @Resource(mappedName = "jms/electionQueue")
        Queue myQueue;
    
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();      
       
       Connection connection;
        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueBrowser queueBrowser=session.createBrowser(myQueue);
            Enumeration enumeration = queueBrowser.getEnumeration();
            while (enumeration.hasMoreElements()) {
                TextMessage msg = (TextMessage) enumeration.nextElement();
                out.println("message is "+ msg.getText()); 
            }        
         } catch (JMSException ex) {
            Logger.getLogger(ElectionConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
 


