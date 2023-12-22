package DTO;

public class User extends Game {
	String pw;
	String nickName;

	public User(String id, String pw, String nickName) {
		super(id);
		this.pw = pw;
		this.nickName = nickName;
	}

	public String getId() {
		return super.getId();
	}

	public String getPw() {
		return pw;
	}

	public String getNickName() {
		return nickName;
	}

	@Override
	public String toString() {
		return super.toString() + " pw : " + pw + " nickName : " + nickName;
	}
}
