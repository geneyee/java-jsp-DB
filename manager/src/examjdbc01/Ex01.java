package examjdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex01 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			// oracle.jdbc.driver.OracleDriver
			System.out.println("Ŭ���� �ε�");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"jspuser",
					"1234");
			System.out.println("���� ����");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}