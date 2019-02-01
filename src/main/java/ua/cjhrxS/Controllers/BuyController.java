package ua.cjhrxS.Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buy")
public class BuyController extends HttpServlet{

	private static final long serialVersionUID = -5244698511608810888L;
	
	public BuyController() {
		
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute(ControllerUrls.BUY_SERVLET.toString(), req.getRequestURL().toString());
		getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.BUY_JSP.toString()).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doGet(req, resp);
		
	}
}
