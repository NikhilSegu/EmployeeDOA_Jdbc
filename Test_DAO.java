import java.util.*;
import java.io.*;
import java.sql.*;
import com.veltech.dao.EmployeeDAO;
import com.veltech.entity.Employee;
class Test_DAO{
public static void main(String[] args){
 String url="jdbc:oracle:thin:@localhost:1521:xe";
 Connection con=null;
 try{
   Class.forName("oracle.jdbc.driver.OracleDriver");
   con=DriverManager.getConnection(url,"system","manager");
   EmployeeDAO edao=new EmployeeDAO(con);
   Employee e1=new Employee(111,"jara",987897);
   edao.addEmployee(e1);
   Employee e2=edao.getEmployee(5);
   if(e2!=null)
          System.out.println(e2.getName()+" "+e2.getSal());
   else
       System.out.println("Employee 5 does not exist");
	if(edao.deleteEmployee(101))
	   System.out.println("Deleted Sucessfully");
	else
		System.out.println("Employee 101 does not exist");
List<Employee> elist=edao.getAllEmployees();
for(Employee e: elist)
System.out.println(e.getId()+" "+e.getName()+" "+e.getSal());		

   }
   catch(Exception e){System.out.println(e);}
}
}
