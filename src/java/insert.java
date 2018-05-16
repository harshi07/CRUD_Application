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
public class insert extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet insert</title>");            
            out.println("</head>");
            out.println("<body>");
            try{
                 String unm,pwd,eml,loc;
                 int sal;
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdata2","root","root");
                 Statement st=con.createStatement();
                 unm=request.getParameter("u");
                 pwd=request.getParameter("p");
                 eml=request.getParameter("e");
                 loc=request.getParameter("l");
                 sal=Integer.parseInt(request.getParameter("s"));
                 String query="insert into info values('"+unm+"','"+pwd+"','"+eml+"',"+sal+",'"+loc+"')";
                 st.executeUpdate(query);
                 out.println("Data Inserted");
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


