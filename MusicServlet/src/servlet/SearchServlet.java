package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;
import javafx.util.Pair;
import vo.GenericPair;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		String str=request.getParameter("str");
		System.out.println("get request: "+code);
		String jsonStr="";
	    try {
	    	String[] strings=str.split(" ");
	    	int size=strings.length;
	    	if(size==1){
	    		Pair<String, Integer> pair=DAOFactory.getIObjectDAOInstance().searchSingleString(strings[0]);
	    		jsonStr="{\"type\":\""+pair.getKey()+"\",\"id\":"+pair.getValue()+"}";
	    	}else if(size==2){
				GenericPair<String, String> pair=DAOFactory.getIObjectDAOInstance().searchList(strings);
				jsonStr="{\"type\":\""+pair.getFirst()+"\",\"mList\":"+pair.getSecond()+"}";
	    	}else{
	    		jsonStr="{\"type\":\"error\"}";
	    	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    response.setContentType("application/json;charset=utf-8");//ָ�����صĸ�ʽΪJSON��ʽ  
	    response.setCharacterEncoding("UTF-8");//setContentType��setCharacterEncoding��˳���ܵ������������޷�����������������  
	    PrintWriter out =null ;  
	    out =response.getWriter();
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
