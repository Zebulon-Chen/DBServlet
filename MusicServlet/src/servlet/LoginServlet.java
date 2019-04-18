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
		//��ȡ��Ϣ������User����
		String userName=request.getParameter("name");
		String userPassword=request.getParameter("password");
		User user=new User();
		user.setName(userName);
		user.setPassword(userPassword);
		
		//���淵�ش��뼰��Ϣ
        String code = "";  
        int u_id=0;

        //����dao����������¼�Ϸ���
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
		
	    response.setContentType("application/json;charset=utf-8");//ָ�����صĸ�ʽΪJSON��ʽ  
	    response.setCharacterEncoding("UTF-8");//setContentType��setCharacterEncoding��˳���ܵ������������޷�����������������  
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
