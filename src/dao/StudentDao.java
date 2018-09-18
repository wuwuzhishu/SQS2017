package dao;

import model.Student;

public interface StudentDao {
	//注册方法
	boolean register(Student student);
	//登录方法
	boolean signin(String id ,String password);

}
