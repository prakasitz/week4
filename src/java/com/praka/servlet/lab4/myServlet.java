/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.praka.servlet.lab4;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author praka
 */
public class myServlet extends HttpServlet {
   
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int c = 1/0;
        int []a = new int[1];
        a[0] = a[2] + a[1];
    }
    
}
