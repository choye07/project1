package Main;

public class MemberVo {
	   private String name;
	   private String email;
	   private String id;
	   private String pwd;
	   

	   @Override
	   public String toString() {
	      return "Vo [id=" + id  + ", pwd=" + pwd + ", email=" + email + "]";
	   }
	   public MemberVo(String id, String pwd,String name, String email) {

		   this.id = id;
		   this.pwd = pwd;
	      this.email = email;
	      this.name = name;
	   }
	   
	   public String getName() {
	      return name;
	   }
	   

	   public String getEmail() {
	      return email;
	   }
	   
	   
	   public String getId() {
	      return  id;
	   }
	   
	   
	   public String getPwd() {
	      return pwd;
	   }
	   

	}
