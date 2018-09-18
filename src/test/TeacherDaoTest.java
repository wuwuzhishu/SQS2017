package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.StudentDao;
import dao.TeacherDao;
import dao.impl.StudentDaoImpl;
import dao.impl.TeacherDaoImpl;
import model.Student;
import model.Teacher;

public class TeacherDaoTest {
	//声明StudentDao对象
	private static TeacherDao td ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//创建对象
		td = new TeacherDaoImpl();
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
		Teacher teacher = new Teacher();
		teacher.setTecId("1712205103");
		teacher.setTecName("张三");
		teacher.setTecPwd("123456");
		teacher.setTecBirth(new Date());
		teacher.setTecDept("计算机科学系");
		assertTrue(td.register(teacher));
	}
	
	@Test
	public void testSignin() {
		assertTrue(td.signin("1712205104", "123456"));
	}
	
	
	
	

}
