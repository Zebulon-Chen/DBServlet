package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;
import vo.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//构造User对象
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("password");
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setPassword(password);
		

		//保存返回代码及信息
        String code="";
        String message = "";  

        //调用dao方法，检查注册合法性
		try {
			int res=DAOFactory.getIUserDAOInstance().signUp(user);
			if(res==1){
                code = "200";  
                message = "Sign up succeed.";  
			}
			else if(res==0){
				code = "100";  
                message = "Sign up failed.This account has been existed.";  
			}
			else {
				code="300";
				message="Sign up failed.Please check your information.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    String jsonStr ="{\"code\":\""+code+"\"}";
	    PrintWriter out =null ;  
	    out =response.getWriter() ;  
	    out.write(jsonStr);  
	    out.close(); 
		//response.getWriter().append(code);
		//response.getWriter().append("code:").append(code).append(";message:").append(message);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
