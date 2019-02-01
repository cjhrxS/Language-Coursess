package ua.cjhrxS.Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.cjhrxS.DTO.SignInDTO;
import ua.cjhrxS.IocContainer.IocContainer;
import ua.cjhrxS.Services.CreatorService;
import ua.cjhrxS.Services.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet({ "/", "/signin" })
public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private CreatorService creatorService;

	private boolean isFirstStart;

	public SignInController() {
		userService = IocContainer.get().getUserService();
		creatorService = new CreatorService();
		isFirstStart = true;

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (isFirstStart) {
			isFirstStart = false;
			creatorService.createTable();
			
		}
			req.setAttribute(ControllerUrls.LOGIN_SERVLET.toString(), req.getRequestURL().toString());
			getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.SIGNIN_JSP.toString()).forward(req,
					resp);
		

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		SignInDTO signIn = new SignInDTO(req.getParameter("Username"), 
					    			     req.getParameter("Password"));
		System.out.println(signIn);
		if(userService.isValid(signIn)) {
			HttpSession session = req.getSession(true);
			session.setAttribute("username", signIn);
			session.setMaxInactiveInterval(600000);
			
			Cookie cookie = new Cookie("id_session", session.getId());
			resp.addCookie(cookie);
			
			resp.sendRedirect(req.getContextPath() + ControllerUrls.USER_COURSE_SERVLET.toString());
			
			
		} else {
			
			req.setAttribute("Error", "Bad UserName or Password");
			getServletConfig()
			.getServletContext()
			.getRequestDispatcher(ViewUrls.SIGNIN_JSP.toString())
			.forward(req, resp);
			
		}
		
	}

}
