package dao;

import model.Teacher;

public interface TeacherDao {
	//注册方法
	boolean register(Teacher teacher);
	//登录方法
	boolean signin(String id ,String password);

}
