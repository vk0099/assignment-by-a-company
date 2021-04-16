package vk1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int Id=Integer.valueOf(request.getParameter("id"));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		int eid=Integer.valueOf(request.getParameter("eid"));
		String sdate=request.getParameter("sdate");
		String designation=request.getParameter("designation");
		String dep=request.getParameter("dep");
		String edate=request.getParameter("edate");
		String stat1=request.getParameter("stat1");
		String dob=request.getParameter("dob");
		String rm=request.getParameter("rm");
		String g=request.getParameter("g");
		String bg=request.getParameter("bg");
		String address=request.getParameter("address");
		
		
		Emp e=new Emp();
		e.setId(Id);
		e.setfname(fname);
		e.setlname(lname);
		e.seteid(eid);
		e.setsdate(sdate);
		e.setdesignation(designation);
		e.setdep(dep);
		e.setsdate(edate);
		e.setstat1(stat1);
		e.setdob(dob);
		e.setrm(rm);
		e.setg(g);
		e.setbg(bg);
		e.setaddress(address);
		
		int status=EmpDao.save(e);
		if(status>0){
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}
