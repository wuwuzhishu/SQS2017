package model;

import java.util.Date;
//JavaBean，与数据库中的student表对应
public class Student {
	private String stuId;
	private String stuName;
	private String stuPwd;
	private String stuMajor;
	private Date stuBirth;
	private int typeId;
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuPwd() {
		return stuPwd;
	}
	public void setStuPwd(String stuPwd) {
		this.stuPwd = stuPwd;
	}
	public String getStuMajor() {
		return stuMajor;
	}
	public void setStuMajor(String stuMajor) {
		this.stuMajor = stuMajor;
	}
	public Date getStuBirth() {
		return stuBirth;
	}
	public void setStuBirth(Date stuBirth) {
		this.stuBirth = stuBirth;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	

}
