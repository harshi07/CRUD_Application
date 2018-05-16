/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class newupdate extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            try
            {
             Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdata2","root","root");
            Statement st=con.createStatement(); 
            ResultSet rs=st.executeQuery("select*from info");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet newupdate</title>");
            out.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='update' method='post'><table class='table table-dark'>");
            out.println("<tr><td>Username:</td><td><input type='text' name='u'value="+request.getParameter("uname")+"></td></tr>");
            out.println("<tr><td>EmailId:</td><td><input type='text' name='e'></td></tr>");
            out.println("<tr><td>Password:</td><td><input type='password' name='p'></td></tr>");
            out.println("<tr><td>Salary:</td><td><input type='text' name='s'></td></tr>");
            out.println("<tr><td colspan='2' align='center'><input type='submit' value='Update'></td></tr></form></table>");
            out.println("</body>");
            out.println("</html>");

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
            
            /* TODO output your page here. You may use following sample code. */
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
