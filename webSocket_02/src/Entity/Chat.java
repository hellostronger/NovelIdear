package Entity;

public class Chat {
	private int from; //信息发送者
	private int to;//信息接收者
	private long time;//发送时间
	private String message;//发送内容
	
	
	public Chat() {
		super();
	}
	
	

	public Chat(int from, int to, long time, String message) {
		super();
		this.from = from;
		this.to = to;
		this.time = time;
		this.message = message;
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
