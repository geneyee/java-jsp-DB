package examjdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex06 {
 public static void main(String[] args) {
	 Connection conn = null;
	 PreparedStatement pstmt = null;
	 int result = 0;
	 JdbcConnectionUtil util = JdbcConnectionUtil.getInstance();

		try {
			conn = util.getConnection();
			System.out.println("접속 성공");
			
			StringBuffer query = new StringBuffer();
			query.append("delete from member ");
			query.append("where num = ?");
			System.out.println(query.toString());
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, 6);
			result = pstmt.executeUpdate(); // 쿼리 전송해서 결과 
			System.out.println(result + "행이 삭제되었습니다.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt);
			util.close(conn);
		}
}
}
