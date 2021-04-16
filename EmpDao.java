package vk1;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.NullPointerException;

public class EmpDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			//Class.forName("com.mysql.jdbc.Driver");
			final String url="jdbc:mysql://127.0.0.1:3306/icf?useSSL=false";
			final String user="root";
			final String password="root";
			con=DriverManager.getConnection(url,user,password);
			if(con!=null)System.out.print("cong");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(Emp e){
		int status = 0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into employee values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,e.getId());
			ps.setString(2,e.getfname());
			ps.setString(3,e.getlname());
			ps.setInt(4,e.geteid());
			ps.setString(5,e.getsdate());
			ps.setString(6,e.getdesignation());
			ps.setString(7,e.getdep());
			ps.setString(8,e.getedate());
			ps.setString(9,e.getstat1());
			ps.setString(10,e.getdob());
			ps.setString(11,e.getrm());
			ps.setString(12,e.getg());
			ps.setString(13,e.getbg());
			ps.setString(14,e.getaddress());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Emp e){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update employee set ID=?, First_Name=?, Last_Name=?, Employment_ID=?, Start_Date=?, Designation=?, Department=?,End_date=?,Status=?, DOB=?, Reporting_Manager=?, gender=?, blood_group=?, address=? where ID=?");
			ps.setInt(1,e.getId());
			ps.setString(2,e.getfname());
			ps.setString(3,e.getlname());
			ps.setInt(4,e.geteid());
			ps.setString(5,e.getsdate());
			ps.setString(6,e.getdesignation());
			ps.setString(7,e.getdep());
			ps.setString(8,e.getedate());
			ps.setString(9,e.getstat1());
			ps.setString(10,e.getdob());
			ps.setString(11,e.getrm());
			ps.setString(12,e.getg());
			ps.setString(13,e.getbg());
			ps.setString(14,e.getaddress());
			ps.setInt(15,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Emp getEmployeeById(int id){
		Emp e=new Emp();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employee where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setfname(rs.getString(2));
				e.setlname(rs.getString(3));
				e.seteid(rs.getInt(4));
				e.setsdate(rs.getString(5));
				e.setdesignation(rs.getString(6));
				e.setdep(rs.getString(7));
				e.setedate(rs.getString(8));
				e.setstat1(rs.getString(9));
				e.setdob(rs.getString(10));
				e.setrm(rs.getString(11));
				e.setg(rs.getString(12));
				e.setbg(rs.getString(13));
				e.setaddress(rs.getString(14));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Emp> getAllEmployees(){
		List<Emp> list=new ArrayList<Emp>();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				e.setId(rs.getInt(1));
				e.setfname(rs.getString(2));
				e.setlname(rs.getString(3));
				e.seteid(rs.getInt(4));
				e.setsdate(rs.getString(5));
				e.setdesignation(rs.getString(6));
				e.setdep(rs.getString(7));
				e.setedate(rs.getString(8));
				e.setstat1(rs.getString(9));
				e.setdob(rs.getString(10));
				e.setrm(rs.getString(11));
				e.setg(rs.getString(12));
				e.setbg(rs.getString(13));
				e.setaddress(rs.getString(14));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
