package in.project.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	
	private JdbcUtil() {
	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnnection() throws SQLException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\ganes\\eclipse-workspace\\JdbcMvcApp\\src\\main\\java\\in\\project\\files\\db.properties");
		Properties properties=new Properties();
		properties.load(fis);
		String url=properties.getProperty("url");
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
		Connection connection= DriverManager.getConnection(url,user,password);
		return connection;
		
	}
}
