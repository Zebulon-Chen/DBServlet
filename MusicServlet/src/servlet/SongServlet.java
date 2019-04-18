package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;

/**
 * Servlet implementation class SongServlet
 */
@WebServlet("/SongServlet")
public class SongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SongServlet() {
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
			if(code.equals("list")){
				int al_id=Integer.parseInt(request.getParameter("al_id"));
				jsonStr=DAOFactory.getIObjectDAOInstance().initSongList(al_id);
			}
			else if(code.equals("songinfo")){
				int so_id=Integer.parseInt(request.getParameter("so_id"));
				jsonStr=DAOFactory.getIObjectDAOInstance().initSongInfo(so_id);
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
