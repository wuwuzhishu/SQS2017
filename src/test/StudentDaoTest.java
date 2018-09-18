package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import model.Student;

public class StudentDaoTest {
	//声明StudentDao对象
	private static StudentDao sd ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//创建对象
		sd = new StudentDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegister() {
		Student stu = new Student();
		stu.setStuId("李四");
		stu.setStuName("张三");
		stu.setStuPwd("123456");
		stu.setStuBirth(new Date());
		stu.setStuMajor("软件技术");
		assertTrue(sd.register(stu));
	}
	
	@Test
	public void testSignin() {
		assertTrue(sd.signin("李四", "123456"));
	}
	
	
	
	

}
