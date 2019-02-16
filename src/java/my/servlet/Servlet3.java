/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("john", new Student("100", "John", "Doe")); //มองเป็นคีย์ และ value
        //ก้อนกลมๆ แล้วมี obj join อยุในก้อนนั้นๆ
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Servlet4");
        dispatcher.forward(request, response);
        //ใชเ dispatcher ส่ง ไปที่ url ตัวไหน ซื่ง ส่งไปที่ /S4
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    
}
