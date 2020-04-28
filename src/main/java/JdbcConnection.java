import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

	public static void main(String[] args) {
		
		//// Define the Connection
		Connection connection = null;
		
		
		try {
			//// 1. Connect with Database
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_name", "user", "password");
			
			//// 2. Create the Statement 
			Statement statement = connection.createStatement();
			
			//// 3. Execute the Statement and collect the Result
			ResultSet result = statement.executeQuery("SHOW TABLES");
			
			
			//// 4. Iterate the Result Set
			while (result.next()) {
				System.out.println(result.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
				//// 5. Close the Connection
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
