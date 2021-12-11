package summer21jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class _02_JdbcExecuteUpdate01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCLCDB", "techpro", "12345");
		
		Statement st = con.createStatement();
		
//		//1.example: insert 104 and huavei into my_companies table
//		String q1 = "INSERT INTO my_companies VALUES(104, 'HUAVEI')";
//		int r1 = st.executeUpdate(q1);
//		
//		System.out.println(r1 + "row inserted");
//		
//		//check if huawei was inserted by looking at the table
//		String q2 = "SELECT * FROM my_companies";
//		ResultSet r2 = st.executeQuery(q2);
//		while(r2.next()) {
//			System.out.println(r2.getString("company_name"));
//		}
//		
//		
//		//2.Example: Change huavei to sumsung
//		String q3 = "UPDATE my_companies SET company_name='Samsung' WHERE company_id =104";
//		int r3 = st.executeUpdate(q3);
//		System.out.println(r3 + " row/s updated");
//		
//		
//		String q4 = "SELECT * FROM my_companies";
//		ResultSet r4 = st.executeQuery(q4);
//		while(r4.next()) {
//			System.out.println(r4.getString("company_name"));
//		}
//		
//		
//		
//		//3.Example: Delete all records whose company_id is 104
//		String q5 = "DELETE FROM my_companies WHERE company_id=104";
//		int r5 = st.executeUpdate(q5);
//		System.out.println(r5 + " row/s updated");
//		
//		
//		String q6 = "SELECT * FROM my_companies";
//		ResultSet r6 = st.executeQuery(q6);
//		while(r6.next()) {
//			System.out.println(r6.getString("company_name"));
//		}
					
		//4.Ex: How to insert multiple record into a table
		
		/*
		 1.step : Create a POJO Class
		 		  a)create private variables
		 		  b)create constructor without parameters
		 		  c)create constructor with all parameters
		 		  d)create getters and setters
		 		  e)create toString() method
		 2.step: Create a list whose elements are the POJO Class objects
		 3.step: by using for-each loop execute INSERT INTO Statement
		
		*/
		
		List<_06_MyCompaniesPojo> records = new ArrayList<>();
		records.add(new _06_MyCompaniesPojo(104, "HUAWEI"));
		records.add(new _06_MyCompaniesPojo(104, "SAMSUNG"));
		records.add(new _06_MyCompaniesPojo(104, "LG"));
		
		int counter = 0 ; 
		
for(_06_MyCompaniesPojo w : records) {
			
			String q7 = "INSERT INTO my_companies VALUES(" + w.getCompany_id() + ",'" + w.getCompany_name() + "')";
			counter = counter + st.executeUpdate(q7);
			
		}
		
		System.out.println(counter + " rows inserted");
		
		
		
		
		
		
		
		
		
		
//		con.close();
//		st.close();
//		
		
	}

}
