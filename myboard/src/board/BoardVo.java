package board;

import java.util.Date;

public class BoardVo {
	
	private int num;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	public BoardVo() {}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public BoardVo(int num, String title, String content) {
		this.num = num;
		this.title = title;
		this.content = content;
	}

	public BoardVo(int num, String title, String writer, String content, Date regDate, int cnt) {
		super();
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
		this.cnt = cnt;
	}
}
