package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDao;
import dao.impl.TeacherDaoImpl;
import model.Teacher;
import util.DateConvert;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TeacherDao td;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
        td = new TeacherDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//解决表单中中文乱码的问题，为了解决写入数据库中乱码的问题，此条语句必须写在第一条哈
		request.setCharacterEncoding("utf-8");
		//通过页面中action参数来决定属于什么操作，然后相应的调用不同的方法
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
	//注册方法
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//得到前端表单中的信息
		String id = request.getParameter("ID");
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		String dept = request.getParameter("dept");//部门，与学生不同的地方
		String birth = request.getParameter("birth");
		String type = request.getParameter("type");
		//声明创建Teacher对象，并把表单中的内容封装到对象中
		Teacher teacher = new Teacher();
		teacher.setTecId(id);
		teacher.setTecName(name);
		teacher.setTecPwd(password);
		teacher.setTecDept(dept);
		teacher.setTecBirth(DateConvert.stringToDate(birth));
		teacher.setTypeId(Integer.parseInt(type));
		if(td.register(teacher)){
			response.sendRedirect("success.html");
		}else{
			response.sendRedirect("success.html");
		}
	}
	//登录方法
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到前端表单中的信息
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		//调用DAO层中的各个类及方法，再来决定转向哪个页面
		if(td.signin(name, password)) {
			response.sendRedirect("success.html");//登录成功
		}else {
			response.sendRedirect("failure.html");//登录失败
		}		
	}

}
