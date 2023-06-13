/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
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
@WebServlet(urlPatterns = {"/ElectionProducer"})
public class ElectionProducer extends HttpServlet {
    @Resource(mappedName = "jms/electionConnectionFactory")
    private ConnectionFactory connectionFactory;
  
    @Resource(mappedName = "jms/electionQueue")
    Queue myQueue;

    Connection con=null;
    Session session = null;
    MessageProducer msgpd = null;
    TextMessage message=null;
    String themessage = null;


    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        themessage = request.getParameter("message");
        PrintWriter out = response.getWriter();    
        response.setContentType("text/html;charset=UTF-8");       
        try {
            con = connectionFactory.createConnection();
            session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            msgpd = session.createProducer(myQueue);
            //message = session.createMessage();
            message = session.createTextMessage();
            message.setText(themessage);
            msgpd.send(message);


            con.close();
            session.close();

            out.println("Message has beensent to queue ");
           
        } catch (JMSException ex) {
           Logger.getLogger(ElectionProducer.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }  
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
