package Entity;
/*
 * javabean 标配 构造器和get,set方法
 * 
 */


public class User {
	
	private int no; //账号
	private  String  phoneNumber;//电话号码
	private   String userName;//昵称
	private  String  pswd;//密码
	private  String  address;//住址
	
	public User() {
		super();
	}
	
	
	

	public User(int no, String phoneNumber, String pswd) {
		super();
		this.no = no;
		this.phoneNumber = phoneNumber;
		this.pswd = pswd;
	}




	public User(int no, String pswd) {
		super();
		this.no = no;
		this.pswd = pswd;
	}




	public User(String phoneNumber, String userName, String pswd, String address) {
		super();
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.pswd = pswd;
		this.address = address;
	}




	public User(int no, String phoneNumber, String userName, String pswd, String address) {
		super();
		this.no = no;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.pswd = pswd;
		this.address = address;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	
	
	


	
}
