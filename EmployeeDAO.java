package com.veltech.dao;

import com.veltech.entity.Employee;
import java.sql.*;
import java.util.*;
public class EmployeeDAO{
	private Connection con=null;
	public EmployeeDAO(Connection con){
		this.con=con;
	}
	public boolean addEmployee(Employee e){
		boolean res=false;
		PreparedStatement ps=null;
		try{
			ps=con.prepareStatement("insert into emp values(?,?,?)");
			ps.setInt(1,e.getId());
			ps.setString(2,e.getName());
			ps.setDouble(3,e.getSal());
			int count=ps.executeUpdate();
			if(count>0) res=true;
		}
	catch(Exception s){s.printStackTrace();}
	return res;
	}
	public Employee getEmployee(int empid){
		Employee emp=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			pst=con.prepareStatement("select * form emp where eid=?");
			pst.setInt(1,empid);
			rs=pst.executeQuery();
			if(rs.next())
				emp=new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return emp;
	}
	public ArrayList<Employee> getAllEmployees(){
		ArrayList<Employee> elist=new ArrayList<Employee>();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			pst=con.prepareStatement("select * from emp");
			rs=pst.executeQuery();
			while(rs.next())
				elist.add(new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
		}
		catch(Exception e){e.printStackTrace();}
		return elist;
	}
	public boolean modifyEmployee(int empid){
		boolean res=false;
		PreparedStatement pst=null;
		try{
			pst=con.prepareStatement("update emp set esal=? where eid=?");
			pst.setDouble(1,786);
			pst.setInt(2,empid);
			int count=pst.executeUpdate();
			if(count>0) res=true;
		}
		catch(Exception e) {e.printStackTrace();}
		return res;
	}
	public boolean deleteEmployee(int empid){
		boolean res=false;
		PreparedStatement pst=null;
		try{
			pst=con.prepareStatement("delete emp where eid=?");
			pst.setInt(1,empid);
			int count=pst.executeUpdate();
			if(count>0) res=true;
		}
		catch(Exception e) {e.printStackTrace();}
		return res;
	}
}