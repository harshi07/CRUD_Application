

import static java.awt.AWTEventMulticaster.add;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;


public class login extends HttpServlet
{
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>login</title>");            
            out.println("</head>");
            out.println("<body>");
            try{
                    String username,password,unm;
                    username=request.getParameter("u");
                    password=request.getParameter("p");
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdata2","root","root");
                   Statement st=con.createStatement();
                   ResultSet rs=st.executeQuery("select * from info");
                   HttpSession s1=request.getSession();
                   s1.setAttribute("name",username);
                   Cookie ck=new Cookie("uname",username);
                   response.addCookie(ck);
                   while(rs.next())
                   {
                    if(username.equals(rs.getString(1))&&password.equals(rs.getString(2)))
                    {
                       RequestDispatcher rd=request.getRequestDispatcher("main.html");
                       rd.forward(request,response);
                    }
                    else if(username.equals(rs.getString(1))&&!password.equals(rs.getString(2)))
                    {
                       out.println("<b> You have entered incorrect password </b>");
                       RequestDispatcher rd=request.getRequestDispatcher("index.html");
                       rd.include(request,response);
                    }
                    
             }
            }
            catch(ClassNotFoundException e)
            {
                out.println(e);
            }
            catch(SQLException e)
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
