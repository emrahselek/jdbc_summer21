package summer21jdbc;

import java.sql.*;

public class _07_JdbcCallableStatement01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCLCDB", "techpro", "12345");
	
	Statement st = con.createStatement();
	
	//How to call a function from DB by using JDBC
	
//	//Create a function which uses 2 integer parameters and returns the sum of the integers
//	String q1 = "CREATE OR REPLACE FUNCTION additionf(a NUMBER, b NUMBER) "
//			  + "RETURN NUMBER IS "
//			  + "BEGIN  return a+b; "
//			  + "END;";
//	boolean isFuncCreated = st.execute(q1);
//	System.out.println("Was the addition function created? " + !isFuncCreated);
//	
//	CallableStatement cst = con.prepareCall("{? = call additionf(?, ?)}");
//	
//	cst.registerOutParameter(1, Types.INTEGER);
//	cst.setInt(2, 5);
//	cst.setInt(3, 7);
//	
//	cst.execute();
//	
//	System.out.println(" The result: " + cst.getInt(1));//12
	
	//Create a function which returns the name of a student from students table when you enter student id
	String q2 = "CREATE OR REPLACE FUNCTION getNamef(id NUMBER) RETURN VARCHAR2 IS "
			+ "s_name students.std_name%TYPE; "
			+ "s_id students.std_id%TYPE; "
			+ "BEGIN "
			+ "SELECT std_name INTO s_name FROM students WHERE std_id = id; "
			+ "RETURN s_name "
			+ "END"; 
	
	boolean isGetNameFuncCreated = st.execute(q2);
	System.out.println("Was the getNamef() created? " + !isGetNameFuncCreated);
	
	
	//Call the getNamef()
	CallableStatement cst = con.prepareCall("{? = call getNamef(?)}"); 
	
	cst.registerOutParameter(1, Types.VARCHAR);
	cst.setInt(2, 102);
	
	cst.execute();
	
	System.out.println(cst.getString(1));//Veli Han
	
	con.close();
	st.close();
	cst.close();
    	
	
	
	

    	
    	
    	
    	
	}

}