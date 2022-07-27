package Main;

public class LoginVo {
	private String id;
	private String pwd;
	static LoginVo userid;
	static LoginVo userpwd;
	
	
	static void user(LoginVo v) {
		userid = v;
	}
	static void user1(LoginVo v2) {
		userpwd =v2;

	}
	LoginVo(){
		
	}
	public LoginVo(String id, String password) {
		this.id = id;
		this.pwd = password;
		
	}
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return pwd;
	}


}
