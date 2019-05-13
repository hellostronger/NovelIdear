package Entity;

public class Friend {
	private int from; //添加朋友账号
	private int to; //被添加朋友账号
	private int statement; //添加状态，同意与否
	private String  friendUserName;
	private String  giveName;
	private String acceptName;
	public Friend() {
		super();
	}

	public Friend(int from, int to, int statement) {
		super();
		this.from = from;
		this.to = to;
		this.statement = statement;
	}
	
	
	
	public Friend(int from, int to, int statement, String friendUserName, String giveName, String acceptName) {
		super();
		this.from = from;
		this.to = to;
		this.statement = statement;
		this.friendUserName = friendUserName;
		this.giveName = giveName;
		this.acceptName = acceptName;
	}

	public Friend(int from, int to, int statement, String friendUserName, String giveName) {
		super();
		this.from = from;
		this.to = to;
		this.statement = statement;
		this.friendUserName = friendUserName;
		this.giveName = giveName;
	}

	

	public String getAcceptName() {
		return acceptName;
	}

	public void setAcceptName(String acceptName) {
		this.acceptName = acceptName;
	}

	public String getFriendUserName() {
		return friendUserName;
	}

	public void setFriendUserName(String friendUserName) {
		this.friendUserName = friendUserName;
	}

	
	
	public Friend(int from, int to, String friendUserName, String giveName) {
		super();
		this.from = from;
		this.to = to;
		this.friendUserName = friendUserName;
		this.giveName = giveName;
	}

	public String getGiveName() {
		return giveName;
	}

	public void setGiveName(String giveName) {
		this.giveName = giveName;
	}

	public Friend(int from, int to) {
		super();
		this.from = from;
		this.to = to;
	}

	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public int getStatement() {
		return statement;
	}
	public void setStatement(int statement) {
		this.statement = statement;
	}
	
	
	

}
