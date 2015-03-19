package tp.mri.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JSPChatServlet
 */
@WebServlet("/JSPChat")
public class JSPChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StringBuffer chatContent;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSPChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init() throws ServletException {
		super.init();
		chatContent = new StringBuffer();
		chatContent.append("Bienvenue sur le chat\n"); 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("login") == null){
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
			request.setAttribute("content", chatContent.toString());
			rd.include(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/chat_servlet.jsp");
			request.setAttribute("content", chatContent.toString());
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		if(login != null && login.length() > 0){
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
		}
		
		if(request.getSession().getAttribute("login") == null){
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
			request.setAttribute("content", chatContent.toString());
			rd.include(request, response);
		}else{
			String action = request.getParameter("action");
			if (action != null && action.equals("submit")) {
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
				chatContent.append(sdf.format(new Date()) + ": "
						+ request.getParameter("ligne") + "\n");
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/chat_servlet.jsp");
			request.setAttribute("content", chatContent.toString());
			rd.include(request, response);
		}
	}

}
