package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class DBConnection { 
	private final static String serverName = "localhost"; // 数据库主机名称
	private final static String portNumber = "3307"; // 数据库主机端口号
	private final static String mydatabase = "StuCourse";   // 数据库名称，不同的数据库修改数据库的名称
	private final static String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + mydatabase
					+"?useUnicode=true&characterEncoding=utf8";
	private final static String userName = "root";    //MySql用户名
	private final static String password = "";  //MySql密码         
    
    
    /* 获得数据库连接 */
    public static Connection getConnection() {
    	Connection con=null;
        try {
        	//1.加载MySQL JDBC 驱动程序名称
			Class.forName("com.mysql.jdbc.Driver");
			//2.//建立数据库连接
            con = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取数据库连接失败！");
        }
        return con;
    }    
    
    //关闭数据库连接的静态方法
  	public static void closeConnection(Connection conn) {
  		if (conn != null) { //连接是否有效
  			try {
  				if (!conn.isClosed()) { //连接是否已关闭
  					conn.close(); //关闭连接
  				}
  			} catch (SQLException ex1) {
  				ex1.printStackTrace();
  			}
  		}
  	}
    
    /*
	 * 将查询结果封装成List。<br>
	 * List中元素类型为封装一行数据的Map，
	 * Map key为字段名（大写），value为相应字段值
	 * 
	 */
	public static List resultToList(ResultSet rs) throws SQLException{
		if(rs==null)
			return Collections.EMPTY_LIST;
		ResultSetMetaData rsmd=rs.getMetaData();
		int columnCount=rsmd.getColumnCount();//得到一行列数
		
		List list=new ArrayList();
		Map rowData;
		while(rs.next()){//行
			rowData=new HashMap(columnCount);//创建hashmap对象		
			for(int i=1;i<=columnCount;i++){//访问每一行中的列			
				rowData.put(rsmd.getColumnName(i), rs.getObject(i));				
			}
			list.add(rowData);
		}
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();		
		String  result="";
		if (conn == null) {
				result="获得数据库连接错误.";
		}else {
			result="正常获得数据库连接." + conn;
		}	
		JOptionPane.showMessageDialog(null, result);		
		DBConnection.closeConnection(conn);
	}
}
