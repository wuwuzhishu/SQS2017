package model;

import java.util.Date;
//JavaBean，与数据库中的student表对应
public class Teacher {
	private String tecId;
	private String tecName;
	private String tecPwd;
	private String tecDept;
	private Date tecBirth;
	private int typeId;
	public String getTecId() {
		return tecId;
	}
	public void setTecId(String tecId) {
		this.tecId = tecId;
	}
	public String getTecName() {
		return tecName;
	}
	public void setTecName(String tecName) {
		this.tecName = tecName;
	}
	public String getTecPwd() {
		return tecPwd;
	}
	public void setTecPwd(String tecPwd) {
		this.tecPwd = tecPwd;
	}
	public String getTecDept() {
		return tecDept;
	}
	public void setTecDept(String tecDept) {
		this.tecDept = tecDept;
	}
	public Date getTecBirth() {
		return tecBirth;
	}
	public void setTecBirth(Date tecBirth) {
		this.tecBirth = tecBirth;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
}
