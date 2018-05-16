import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Delete_database extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Delete_database</title>");            
            out.println("</head>");
            out.println("<body>");
           try
           {
                   String q;
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdata2","root","root");
                   Statement st=con.createStatement();
                   q="drop database newdata2";
                   st.executeUpdate(q);
                   out.println("Database is Delete");
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
