package examjdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex04 {
 public static void main(String[] args) {
	 Connection conn = null;
	 PreparedStatement pstmt = null;
	 int result = 0;
	 JdbcConnectionUtil util = JdbcConnectionUtil.getInstance();

		try {
			conn = util.getConnection();
			System.out.println("���� ����");
			
			StringBuffer query = new StringBuffer();
			query.append("insert into member ");
			query.append("(num, memberid, memberpw, nickname, regdate) ");
			query.append("values (MEMBER_SEQ.nextval, ?, ?, ?, sysdate)");
			System.out.println(query.toString());
			
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, "tester");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "testernick");
			result = pstmt.executeUpdate(); // ���� �����ؼ� ��� 
			System.out.println(result + "���� ���ԵǾ����ϴ�.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt);
			util.close(conn);
		}
}
}