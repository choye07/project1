package Main;

public class StudyStartjcgVo {

	String Sname;
	String jcgStudy1;
	String jcgStudy2;
	String jcgStudy3;
	String jcgstdt;
	String jcgstt;

	public String toString() {
		return "Vo [id=" + LoginVo.userid.getId() + ", sname=" + Sname + ", jvstdt=" + jcgstdt+", jcgStudy1=" +  jcgStudy1 + ", jcgStudy2="
				+ jcgStudy2 + ", jcgStudy3=" + jcgStudy3  + ", jvstt=" + jcgstt + "]";
	}

	public StudyStartjcgVo(String Sname, String jcgstdt,String jcgStudy1, String jcgStudy2, String jcgStudy3, String jcgstt) {
		this.Sname = Sname;
		this.jcgStudy1 = jcgStudy1;
		this.jcgStudy2 = jcgStudy2;
		this.jcgStudy3 = jcgStudy3;
		this.jcgstdt = jcgstdt;
		this.jcgstt = jcgstt;

	}

	public String getSname() {
		return Sname;
	}

	public String getjcgStudy1() {
		return jcgStudy1;
	}

	public String getjcgStudy2() {
		return jcgStudy2;
	}

	public String getjcgStudy3() {
		return jcgStudy3;
	}

	public String getjcgstdt() {
		return jcgstdt;
	}

	public String getjcgstt() {
		return jcgstt;
	}

}
