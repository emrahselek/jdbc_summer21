package summer21jdbc;

//1.step: having phone means " importing SQL package"
import java.sql.*;

public class _01_JdbcExecuteQuery01 {

//If you use “SELECT” statement use executeQuery() method
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//2.step: Registering gsm operator means " registering to our driver(Oracle Driver)"
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//3.step:Call your friend means " establish connection with the database" 
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCLCDB", "techpro", "12345");
		
		//4.step: create some sentences to tell your friend means " create statement"
		Statement st = con.createStatement();
		
		//5.step: Start to talk with your friend means " Create SQL Query and execute it"
		
		//1.Example:
		String q1 = "SELECT * FROM my_companies";
		ResultSet r1 = st.executeQuery(q1);
		
		//6.step: Do some actions according to result
		while(r1.next()) {
			System.out.println(r1.getInt(1) + " - " + r1.getString(2));
		}
		
		System.out.println("====================");
		
		//2.Example:
		String q2 = "SELECT * FROM my_companies WHERE company_id < 102";
		
		ResultSet r2 = st.executeQuery(q2);
		//Note: Inside the get methods both column name and index can be used 
		while(r2.next()) {
			System.out.println(r2.getString("company_name"));
		}
		
		System.out.println("=====================");
		
		//3.Example: select third company_id and company_name after sorting descending
		String q3 = "SELECT company_id, company_name FROM my_companies ORDER BY company_id DESC OFFSET 2 ROW FETCH NEXT 1 ROW ONLY";
		ResultSet r3 = st.executeQuery(q3);
		while(r3.next()){
			System.out.println(r3.getInt("company_id") + " --> " + r3.getString("company_name"));
		}
		
		System.out.println("=====================");
		
		//4.Examples: Select the company whose id is the second lowest
		String q4 = "SELECT company_name FROM my_companies ORDER BY company_id ASC OFFSET 1 ROW FETCH NEXT 1 ROW ONLY";
		ResultSet r4 = st.executeQuery(q4);
		while(r4.next()) {
			System.out.println(r4.getString("company_name"));
		}
		
						
		//7.step: End the call means " Close the DB connection"
		con.close();
		st.close();
		r1.close();
		r2.close();
		r3.close();
		r4.close();
		
		
		
		
	
	}

}