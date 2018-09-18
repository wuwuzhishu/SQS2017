package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.StudentDao;
import dao.TeacherDao;
import model.Student;
import model.Teacher;
import util.DBConnection;
import util.DateConvert;

public class TeacherDaoImpl implements TeacherDao{

	@Override
	public boolean register(Teacher teacher) {
		boolean flag = false;
		//1.建立数据库的连接
		Connection con = DBConnection.getConnection();
		//2.要执行的SQL语句
		String sql = "insert into teacher value(?,?,?,?,?,?)";
		//3.声明一个Statement
		PreparedStatement psm = null;
		try {
			//3.创建Statement对象
			psm = con.prepareStatement(sql);
			//4.给参数传值
			psm.setString(1, teacher.getTecId());//学号
			psm.setString(2, teacher.getTecName());//姓名
			psm.setString(3, teacher.getTecPwd());//密码
			psm.setString(4, teacher.getTecDept());//部门
			psm.setDate(5, DateConvert.dateToSQLDate(teacher.getTecBirth()));//生日
			psm.setInt(6, 2);
			//5.执行数据更新操作
			int n = psm.executeUpdate();
			if(n > 0) {
				flag = true;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//6.关闭Statement
			try {
				psm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//7.关闭连接
			DBConnection.closeConnection(con);
		}
		
		return flag;
	}

	@Override
	public boolean signin(String id, String password) {
		// TODO Auto-generated method stub
		boolean flag = false;
		//1.建立数据库的连接
		Connection con = DBConnection.getConnection();
		//2.要执行的SQL语句
		String sql = "select * from teacher where tecId=? and tecPwd=?";
		//3.声明一个Statement
		PreparedStatement psm = null;
		//3.声明一个ResultSet对象
		ResultSet rs = null;
		try {
			//3.创建Statement对象
			psm = con.prepareStatement(sql);
			//4.给参数传值
			psm.setString(1, id);
			psm.setString(2, password);
			//5.执行数据查询操作
			rs = psm.executeQuery();	
			if(rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//6.关闭结果集
				rs.close();	
				//6.关闭Statement
				psm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//7.关闭连接
			DBConnection.closeConnection(con);
		}
		
		return flag;
	}
	

}
