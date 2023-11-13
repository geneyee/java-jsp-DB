package exam03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	private static MemberDao instance;
	private DataSource ds;
	// private JdbcConnectionUtil instance;
	
	private MemberDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/TestDB");	// JNDI경로
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 싱글톤 패턴 적용
	public static MemberDao getInstance() {
		synchronized (MemberDao.class) {// 멀티쓰레딩 공부
			if(instance == null) {
				instance = new MemberDao();
			}
		}
		return instance;
	}
	
	// C
	public int insertMember(MemberVo vo) {
		Connection conn = null;
		 PreparedStatement pstmt = null;
		 int result = 0;

			try {
				conn = ds.getConnection();
				System.out.println("DB 연결");
				
				StringBuffer query = new StringBuffer();
				query.append("insert into member ");
				query.append("(num, memberid, memberpw, nickname, regdate) ");
				query.append("values (MEMBER_SEQ.nextval, ?, ?, ?, sysdate)");
				System.out.println(query.toString());
				
				
				pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, vo.getMemberId());
				pstmt.setString(2, vo.getMemberPw());
				pstmt.setString(3, vo.getNickName());
				result = pstmt.executeUpdate(); // 쿼리 제대로 실행하면 int 반환해줌 
				System.out.println(result + "행이 등록되었습니다.");
				
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
				conn = ds.getConnection();
				System.out.println("DB 연결");
				pstmt = conn.prepareStatement("select * from member where num = ?");
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery(); //쿼리 실행해서 결과값 rs에 저장
				
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
			conn = ds.getConnection();
			System.out.println("DB 연결");
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery(); // 쿼리 실행해서 결과값 rs에 저장

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
				conn = ds.getConnection();
				System.out.println("DB 연결");
				
				StringBuffer query = new StringBuffer();
				query.append("update member ");
				query.append("set memberPw = ?, nickname = ? ");
				query.append("where num = ?");
				System.out.println(query.toString());
				
				
				pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, vo.getMemberPw());
				pstmt.setString(2, vo.getNickName());
				pstmt.setInt(3, vo.getNum());
				result = pstmt.executeUpdate(); // 쿼리 실행해서 성공하면 int 반환
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
				conn = ds.getConnection();
				System.out.println("DB 연결");
				
				StringBuffer query = new StringBuffer();
				query.append("delete from member ");
				query.append("where num = ?");
				System.out.println(query.toString());
				
				pstmt = conn.prepareStatement(query.toString());
				pstmt.setInt(1, num);
				result = pstmt.executeUpdate(); // 쿼리 실행해서 성공하면 int 반환
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
