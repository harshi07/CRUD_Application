/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns = {"/list1"})
public class list1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){ 
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdata2","root","root");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from info");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            //out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>");
            //out.println("<script src=\'https://code.jquery.com/jquery-3.2.1.slim.min.js\' integrity=\'sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\' crossorigin=\'anonymous\'></script>");
            //out.println("<script src=\'https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\' integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\' crossorigin=\'anonymous\'></script>");
            //out.println("<script src=\'https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\' integrity=\'sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\' crossorigin=\'anonymous\'></script>");
            out.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
            out.println("<title>Servlet list</title>");            
            out.println("</head>");
            out.println("<body>"); 
            out.println("<center><a href='insert.html'>Insert new user</a></center>");
            out.println("<table border='1' align='center' width='50%' class='table table-dark'><tr><th>uname</th><th>password</th><th>mail</th><th>salary</th><th>location</th><th colspan='2'>OPERATION</th></tr>");
            while(rs.next())
            {
                out.println("<tr><td>"+rs.getString("uname")+"</td><td>"+rs.getString("password")+"</td><td>"+rs.getString("mail")+"</td><td>"+rs.getInt("salary")+"</td><td>"+rs.getString("location")+"</td><td><a href='newupdate?uname="+rs.getString("uname")+"'>Update</a></td><td><a href='delete?uname="+rs.getString("uname")+"'>Delete</a></td></tr>");
            }
            
        }catch(ClassNotFoundException e)
        {
            out.println(e);
        }
        catch(SQLException e)
        {
            out.println(e);
        }
        catch(Exception e)
        {
            out.println(e);
        }
        
            out.println("</body>");
            out.println("</html>");
    }
    }
    
        

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
