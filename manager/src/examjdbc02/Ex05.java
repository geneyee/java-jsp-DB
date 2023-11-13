package examjdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex05 {
 public static void main(String[] args) {
	 Connection conn = null;
	 PreparedStatement pstmt = null;
	 int result = 0;
	 JdbcConnectionUtil util = JdbcConnectionUtil.getInstance();

		try {
			conn = util.getConnection();
			System.out.println("���� ����");
			
			StringBuffer query = new StringBuffer();
			query.append("update member ");
			query.append("set memberPw = ?, nickname = ? ");
			query.append("where num = ?");
			System.out.println(query.toString());
			
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, "54123");
			pstmt.setString(2, "update");
			pstmt.setInt(3, 6);
			result = pstmt.executeUpdate(); // ���� �����ؼ� ��� 
			System.out.println(result + "���� �����Ǿ����ϴ�.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt);
			util.close(conn);
		}
}
}