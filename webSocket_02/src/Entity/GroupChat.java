package Entity;


/**
 * 群聊信息记录
 * @author bjq
 *
 */
public class GroupChat {
	private int groupno;
	private int fromno;
	private long time;
	private String message;
	
	
	
	
	public GroupChat() {
		super();
	}

	public GroupChat(int groupno, int fromno, long time, String message) {
		super();
		this.groupno = groupno;
		this.fromno = fromno;
		this.time = time;
		this.message = message;
	}
	
	public int getGroupno() {
		return groupno;
	}
	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}
	public int getFromno() {
		return fromno;
	}
	public void setFromno(int fromno) {
		this.fromno = fromno;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
