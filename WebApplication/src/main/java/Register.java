import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/regForm")
public class Register  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter writer= resp.getWriter();   
		
		String name =req.getParameter("name1");
		String email=req.getParameter("email");
		String password = req.getParameter("password");
		String gender=req.getParameter("gender");
		String city= req.getParameter("city");
		
		
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mywebapp","root", "root");
		PreparedStatement ps = con.prepareStatement("insert into register(name,email,password,gender,city) values(?,?,?,?,?)");
		
		
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, password);
		ps.setString(4, gender);
		ps.setString(5, city);
		
		
		int count =ps.executeUpdate();
		
		if(count > 0) {
			
			resp.setContentType("text/html");
			
			writer.print("<h2 style='color:green'>Successfully registered</h2>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/registration.jsp");
			rd.include(req, resp);
			
		}
		else {
            resp.setContentType("text/html");
			
			writer.print("<h2 style='color:red'>Not Registered  Due to Some problem ....... Please try again After Sometime !!</h2>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/registration.jsp");
			rd.include(req, resp);
			
		}
		
		} catch (Exception e) {
		
			
			writer.print(e);
			
		}
		
		
		
		
	}

}
