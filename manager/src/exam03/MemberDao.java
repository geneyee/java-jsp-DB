package exam03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	private JdbcConnectionUtil util;
	
	public MemberDao() {
		util = JdbcConnectionUtil.getInstance();
	}
	
	// C
	public int insertMember(MemberVo vo) {
		Connection conn = null;
		 PreparedStatement pstmt = null;
		 int result = 0;

			try {
				conn = util.getConnection();
				System.out.println("접속 성공");
				
				StringBuffer query = new StringBuffer();
				query.append("insert into member ");
				query.append("(num, memberid, memberpw, nickname, regdate) ");
				query.append("values (MEMBER_SEQ.nextval, ?, ?, ?, sysdate)");
				System.out.println(query.toString());
				
				
				pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, vo.getMemberId());
				pstmt.setString(2, vo.getMemberPw());
				pstmt.setString(3, vo.getNickName());
				result = pstmt.executeUpdate(); // 쿼리 전송해서 결과 
				System.out.println(result + "행이 삽입되었습니다.");
				
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return result;
	}
	
	// R
	public MemberVo selectMember(int num) {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 MemberVo result = null;
		 
			try {
				conn = util.getConnection();
				System.out.println("접속 성공");
				pstmt = conn.prepareStatement("select * from member where num = ?");
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery(); // 쿼리 전송해서 결과 
				
				if(rs.next()) {
					result = new MemberVo(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4));
					
					result.setRegdate(rs.getDate("regdate"));
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return result;
	}
	
	public List<MemberVo> selectAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> result = new ArrayList<>();

		try {
			conn = util.getConnection();
			System.out.println("접속 성공");
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery(); // 쿼리 전송해서 결과

			while (rs.next()) {
				MemberVo vo = new MemberVo(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString("memberpw"), 
						rs.getString(4));

				vo.setRegdate(rs.getDate("regdate"));
				
				result.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	// U
	public int updateMember(MemberVo vo) {
		Connection conn = null;
		 PreparedStatement pstmt = null;
		 int result = 0;
		 
			try {
				conn = util.getConnection();
				System.out.println("접속 성공");
				
				StringBuffer query = new StringBuffer();
				query.append("update member ");
				query.append("set memberPw = ?, nickname = ? ");
				query.append("where num = ?");
				System.out.println(query.toString());
				
				
				pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, vo.getMemberPw());
				pstmt.setString(2, vo.getNickName());
				pstmt.setInt(3, vo.getNum());
				result = pstmt.executeUpdate(); // 쿼리 전송해서 결과 
				System.out.println(result + "행이 수정되었습니다.");
				
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return result;
	}
	
	// D
	public int deleteMember(int num) {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 int result = 0;
		
			try {
				conn = util.getConnection();
				System.out.println("접속 성공");
				
				StringBuffer query = new StringBuffer();
				query.append("delete from member ");
				query.append("where num = ?");
				System.out.println(query.toString());
				
				pstmt = conn.prepareStatement(query.toString());
				pstmt.setInt(1, num);
				result = pstmt.executeUpdate(); // 쿼리 전송해서 결과 
				System.out.println(result + "행이 삭제되었습니다.");
				
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return result;
	}
}
