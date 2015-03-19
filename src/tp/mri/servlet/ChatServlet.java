package tp.mri.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StringBuffer chatContent;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChatServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		chatContent = new StringBuffer();
		chatContent.append("Bienvenue sur le chat\n");
		chatContent.append("Soyez vulgaire\n");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String html = " " + "<!DOCTYPE html>" + "<html>" + "<head>"
				+ "<title>Title of the document</title>" + "</head>" + "<body>"
				+ "<form name=\"chatForm\" action=\"chat\" method=\"post\">"
				+ "<input type=\"text\" name=\"ligne\" value=\"\">"
				+ "<input type=\"submit\" name=\"action\" value=\"submit\">"
				+ "<input type=\"submit\" name=\"action\" value=\"refresh\">"
				+ "<pre>" + chatContent.toString() + "</pre>" + "</body>"
				+ "</html> ";
		response.getWriter().append(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if (action != null && action.equals("submit")) {
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
			chatContent.append(sdf.format(new Date()) + ": "
					+ request.getParameter("ligne") + "\n");

		}
		String html = " " + "<!DOCTYPE html>" + "<html>" + "<head>"
				+ "<title>Title of the document</title>" + "</head>" + "<body>"
				+ "<form name=\"chatForm\" action=\"chat\" method=\"post\">"
				+ "<input type=\"text\" name=\"ligne\" value=\"\">"
				+ "<input type=\"submit\" name=\"action\" value=\"submit\">"
				+ "<input type=\"submit\" name=\"action\" value=\"refresh\">"
				+ "<pre>" + chatContent.toString() + "</pre>" + "</body>"
				+ "</html> ";
		response.getWriter().append(html);
	}

}
