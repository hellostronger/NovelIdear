package Entity;

/**
 * 群成员表
 * @author bjq
 *
 */
public class Group {
	private int groupno;
	private int  no;
	private int id;
	private String mygroupnameString;
	private String type;
	
	
	public Group() {
		super();
	}
	
	
	



	public Group(int groupno, int no, int id, String mygroupnameString, String type) {
		super();
		this.groupno = groupno;
		this.no = no;
		this.id = id;
		this.mygroupnameString = mygroupnameString;
		this.type = type;
	}






	public Group(int groupno, int no, int id, String mygroupnameString) {
		super();
		this.groupno = groupno;
		this.no = no;
		this.id = id;
		this.mygroupnameString = mygroupnameString;
	}



	public int getGroupno() {
		return groupno;
	}



	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}
	
	



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getMygroupnameString() {
		return mygroupnameString;
	}



	public void setMygroupnameString(String mygroupnameString) {
		this.mygroupnameString = mygroupnameString;
	}






	
	

}
