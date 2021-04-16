package vk1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Employee</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Emp e=EmpDao.getEmployeeById(id);
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td>ID</td><td>:<input type='number' name='id' value='"+e.getId()+"'/></td></tr>");
		out.print("<tr><td>First Name</td><td>:<input type='text'name='fname' value='"+e.getfname()+"'/></td></tr>");
		out.print("<tr><td>Last Name</td><td>:<input type='text' name='lname' value='"+e.getlname()+"'/></td></tr>");
		out.print("<tr><td>Employee ID</td><td>:<input type='number' name='eid' value='"+e.geteid()+"'></td></tr>");
		out.print("<tr><td>Start Date</td><td>:<input type='Date' name='sdate' value='"+e.getsdate()+"'/></td></tr>");
		out.print("<tr><td>Designation</td><td>:<input type='text' name='designation' value='"+e.getdesignation()+"'></td></tr>");
		out.print("<tr><td>Department</td><td>:<input type='text' name='dep' value='"+e.getdep()+"'/></td></tr>");
		out.print("<tr><td>End Date</td><td>:<input type='Date' name='edate'value='"+e.getdob()+"'/></td></tr>");
		out.print("<tr><td>Status</td><td>:");
		out.print("<select name='stat1' style='width:150px' value='"+e.getstat1()+"'>");
		out.print("<option>Full-time</option>");
		out.print("<option>Part-time</option>");
		out.print("<option>contract</option></select></td></tr>");
		out.print("<tr><td>Date of Birth</td><td>:<input type='Date' name='dob' value='"+e.getdob()+"'/></td></tr>");
		out.print("<tr><td>Reporting Manager</td><td>:<input type='text' name='rm'value='"+e.getrm()+"'/></td></tr>");
		out.print("<tr><td>Gender</td><td>:");
		out.print("<select name='gender' style='width:150px' value='"+e.getg()+"'/>");
		out.print("<option>male</option>");
		out.print("<option>female</option></select></td></tr>");
		out.print("<tr><td>Blood Group</td><td>:<input type='text' name='bg' value='"+e.getbg()+"'/></td></tr>");
		out.print("<tr><td>Address</td><td><textarea name='address' rows='4' cols='40' value='"+e.getaddress()+"'/></textarea></td></tr>");
		out.print("<tr><td><input type='submit' value='Save Employee'/></td>");
		out.print("<td><input type='reset'/></tr>");
		//out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
