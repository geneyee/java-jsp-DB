package examjdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex03 {
 public static void main(String[] args) {
	 Connection conn = null;
	 PreparedStatement pstmt = null;
	 ResultSet rs = null;
	 
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"jspuser",
					"1234");
			System.out.println("접속 성공");
			pstmt = conn.prepareStatement("select * from member where num = ?");
			pstmt.setInt(1, 2);
			rs = pstmt.executeQuery(); // 쿼리 전송해서 결과 
			
			if(rs.next()) {
				MemberVo vo = new MemberVo(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4));
				
				vo.setRegdate(rs.getDate("regdate"));
				System.out.println(vo);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
