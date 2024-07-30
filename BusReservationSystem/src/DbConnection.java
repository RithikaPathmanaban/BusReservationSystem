
import java.sql.*;

public class DbConnection {
		private static final String URL = "jdbc:mysql://localhost:3306/BusResv";
		private static final String UserName = "root";
		private static final String Password = "root";

		public static Connection getConnection() throws SQLException{
			return DriverManager.getConnection(URL,UserName,Password);
		}
}
