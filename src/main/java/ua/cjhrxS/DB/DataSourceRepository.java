package ua.cjhrxS.DB;

import java.sql.Driver;
import java.sql.SQLException;

public final class DataSourceRepository {
	private final static String FAILED_JDBC_DRIVER = "Failed to Create JDBC Driver";

	private DataSourceRepository() {
	}

	public static DataSource getDefault() {
		return getMySqlLocalHost();
	}
     
	public static DataSource getMySqlLocalHost() {
		Driver sqlDriver;
		try {
			//sqlDriver = new com.mysql.jdbc.Driver();
		sqlDriver = new com.mysql.cj.jdbc.Driver(); 
		} catch (SQLException e) {
			// Develop Custom Exceptions
			throw new RuntimeException(FAILED_JDBC_DRIVER);
		}
		return new DataSource(sqlDriver,
				"jdbc:mysql://localhost:3306/firstdemo?createDatabaseIfNotExist=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				System.getenv().get("MY_SQL_LOGIN"),
				System.getenv().get("MY_SQL_PASSWORD"));
	}

}