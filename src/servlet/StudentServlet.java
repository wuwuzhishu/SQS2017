package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import model.Student;
import util.DateConvert;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao sd;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
        sd = new StudentDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		if(action.equals("login")) {
			login(request, response);//调用登录方法
		}else if(action.equals("register")){
			register(request, response);//调用注册方法
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//登录方法
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决表单中中文乱码的问题
		request.setCharacterEncoding("utf-8");
		//得到前端表单中的信息
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		//调用DAO层中的各个类及方法，再来决定转向哪个页面
		if(sd.signin(name, password)) {
			response.sendRedirect("success.html");//登录成功
		}else {
			response.sendRedirect("failure.html");//登录失败
		}		
	}

	//注册方法
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决表单中中文乱码的问题
		request.setCharacterEncoding("utf-8");
		//得到前端表单中的信息
		String id = request.getParameter("ID");
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		String major = request.getParameter("major");
		String birth = request.getParameter("birth");
		String type = request.getParameter("type");
		
		Student student = new Student();
		student.setStuId(id);
		student.setStuName(name);
		student.setStuPwd(password);
		student.setStuMajor(major);
		student.setStuBirth(DateConvert.stringToDate(birth));
		student.setTypeId(Integer.parseInt(type));
		//调用DAO层中的各个类及方法，再来决定转向哪个页面
		if(sd.register(student)) {
			response.sendRedirect("success.html");//登录成功
		}else {
			response.sendRedirect("failure.html");//登录失败
		}		
	}

}
