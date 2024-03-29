package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.model.core.ID;

import factory.DAOFactory;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GradeServlet
 */
@WebServlet("/GradeServlet")
public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		System.out.println("get request: "+code);
		String jsonStr="";
	    try {
			if(code.equals("info")){
				int so_id=Integer.parseInt(request.getParameter("so_id"));
				jsonStr=DAOFactory.getIObjectDAOInstance().initGrade(so_id);
			}
			else if(code.equals("add_grade")){
				String grade_info=request.getParameter("grade_info");
				if(DAOFactory.getIObjectDAOInstance().addGrade(grade_info))
					jsonStr="succeed";
				else
					jsonStr="failed";
			}else if(code.equals("so_web_scores")){
				int so_id=Integer.parseInt(request.getParameter("so_id"));
				jsonStr=DAOFactory.getIObjectDAOInstance().getSongScores(so_id);
			}else if(code.equals("fav_grade_list")){
				int u_id=Integer.parseInt(request.getParameter("u_id"));
				jsonStr=DAOFactory.getIObjectDAOInstance().getFavGradeList(u_id);
			}else if(code.equals("cancel_fav_grade")){
				int u_id=Integer.parseInt(request.getParameter("u_id"));
				int g_id=Integer.parseInt(request.getParameter("g_id"));
				jsonStr=DAOFactory.getIObjectDAOInstance().cancelFavGrade(u_id, g_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式  
	    response.setCharacterEncoding("UTF-8");//setContentType与setCharacterEncoding的顺序不能调换，否则还是无法解决中文乱码的问题  
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
