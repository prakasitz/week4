/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.praka.servlet.assign4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author praka
 */
public class CheckTime extends HttpServlet {
    
    @Override
       protected void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = getServletContext().getInitParameter("email");
        String phone = getServletContext().getInitParameter("phone");
        
        String open = getServletConfig().getInitParameter("openTime");
        
        String[] openTime = open.split(":");
        Calendar openCalendar = Calendar.getInstance(); // return วันที่และเวลาปัจจุบัน ถ้าไม่ set จะเป็นเวลาตอนรัน
        openCalendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(openTime[0])); //set ชั่วโมง 10
        openCalendar.set(Calendar.MINUTE, Integer.parseInt(openTime[1])); // นาที 00
        openCalendar.set(Calendar.SECOND, Integer.parseInt(openTime[2])); // วินาที 00
        
        String close = this.getInitParameter("closeTime");
        String[] closeTime = close.split(":");
        Calendar closeCalendar = Calendar.getInstance();
        closeCalendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(closeTime[0]));
        closeCalendar.set(Calendar.MINUTE, Integer.parseInt(closeTime[1]));
        closeCalendar.set(Calendar.SECOND, Integer.parseInt(closeTime[2]));
        
        Calendar now = Calendar.getInstance();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>"); 
            out.println("</head>");
            out.println("<body>");
            
            if (now.after(openCalendar) && now.before(closeCalendar)){
                out.println("<div><p>Now:"+openCalendar+"</p>");
                out.println("<form action='./LoginServlet' method='POST'>");
                out.println("username: <input type='text' name='username'><br/>");
                out.println("password: <input type='password' name='password'><br/>");
                out.println("<input type='submit' name='submit' value='Login'><br/>");
                out.println("</form>");
                out.println("</div>");
            }
            else{
                out.println("<h2>We are closing</h2>");
                out.println("<p>Open: " + open + " - " + close + "</p1>");
                
            }
            out.println("<br/><div style='background-color:gray;padding:5px;width:30%;font-size:70%;'>Contact: " + email + ", Phone: " + phone + "</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
