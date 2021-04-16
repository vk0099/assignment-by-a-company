package vk1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<button onclick=\"document.location='index.html'\">Add New Employee</button>  <button onclick=\"document.location='home.html'\">Home</button>");
		out.println("<h1>Employees List</h1>");
		
		List<Emp> list=EmpDao.getAllEmployees();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>First Name</th><th>Last Name</th>"
				+ "<th>Employee Id</th><th>Start Date</th>"
				+ "<th>Designation</th><th>Department</th><th>End Date</th><th>Status</th><th>Date of Birth</th><th>Reporting Manager</th><th>Gender</th><th>Blood Group</th><th>Address</th><th>Edit</th><th>Delete</th></tr>");
		for(Emp e:list){
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getfname()+"</td><td>"+e.getlname()+"</td><td>"+e.geteid()+"</td><td>"+e.getsdate()+"</td><td>"+e.getdesignation()+"</td><td>"+e.getdep()+"</td>"
					+ "<td>"+e.getedate()+"</td><td>"+e.getstat1()+"</td><td>"+e.getdob()+"</td><td>"+e.getrm()+"</td><td>"+e.getg()+"</td><td>"+e.getbg()+"</td><td>"+e.getaddress()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
