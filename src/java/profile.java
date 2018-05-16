

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class profile extends HttpServlet {
    @Override
            protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
        out.println("</head>");
        out.println("<body>");
        try{
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdata2","root","root");
                     Cookie[] ck=request.getCookies();
                     String s1=ck[0].getName();
                     String s2=ck[0].getValue();
                     PreparedStatement st=con.prepareStatement("select * from info where uname=?");
                     st.setString(1,s2);
                     ResultSet rs=st.executeQuery();
                    
                    while(rs.next())
                    {
                        out.println("<table border='1' align='center' class='table table-dark'>");
                        out.println("<tr><td>Username:</td><td>"+rs.getString("uname")+"</td></tr>");
                        out.println("<tr><td>Password:</td><td>"+rs.getString("password")+"</td><tr>");
                        out.println("<tr><td>Emailid:</td><td>"+rs.getString("mail")+"</td><tr>");
                        out.println("<tr><td>Salary:</td><td>"+rs.getInt("salary")+"</td></tr>");
                        out.println("<tr><td>Location:</td><td>"+rs.getString("location")+"</td></tr>");
                    }
        }  
        catch (ClassNotFoundException | SQLException ex) {
          System.out.println(ex);
        }  
        catch(Exception e){System.out.println(e);}
            out.println("</body>");
            out.println("</html>");
}  
  

}
