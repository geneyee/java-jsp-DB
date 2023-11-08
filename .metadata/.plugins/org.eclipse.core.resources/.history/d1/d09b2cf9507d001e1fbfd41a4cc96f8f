package examjdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// ½Ì±ÛÅæ(Singleton) Àû¿ë
public class JdbcConnectionUtil {
	
	private static JdbcConnectionUtil instance;
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "jspuser";
	private String password ="1234";
	
	private JdbcConnectionUtil() {
		
	}
	public static JdbcConnectionUtil getInstance() {
		synchronized (JdbcConnectionUtil.class) {
			if(instance == null) {
				instance = new JdbcConnectionUtil();
			}
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}
