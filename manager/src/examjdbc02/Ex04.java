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
			System.out.println("접속 성공");
			
			StringBuffer query = new StringBuffer();
			query.append("insert into member ");
			query.append("(num, memberid, memberpw, nickname, regdate) ");
			query.append("values (MEMBER_SEQ.nextval, ?, ?, ?, sysdate)");
			System.out.println(query.toString());
			
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, "tester");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "testernick");
			result = pstmt.executeUpdate(); // 쿼리 전송해서 결과 
			System.out.println(result + "행이 삽입되었습니다.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt);
			util.close(conn);
		}
}
}
