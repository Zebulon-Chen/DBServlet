package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;
import javafx.util.Pair;
import vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取信息，构造User对象
		String userName=request.getParameter("name");
		String userPassword=request.getParameter("password");
		User user=new User();
		user.setName(userName);
		user.setPassword(userPassword);
		
		//保存返回代码及信息
        String code = "";  
        int u_id=0;

        //调用dao方法，检查登录合法性
		try {
			Pair<Boolean, Integer> pair=new Pair<Boolean, Integer>(false, 0);
			pair=DAOFactory.getIUserDAOInstance().findLogin(user);
			if(pair.getKey()){
                code = "succeed";
                u_id=pair.getValue();
			}
			else{
				code = "failed";  
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	    response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式  
	    response.setCharacterEncoding("UTF-8");//setContentType与setCharacterEncoding的顺序不能调换，否则还是无法解决中文乱码的问题  
	    String jsonStr ="{\"code\":\""+code+"\",\"u_id\":"+u_id+"}";
	    PrintWriter out =null ;  
	    out =response.getWriter() ;  
	    out.write(jsonStr);  
	    out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
