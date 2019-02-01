package ua.cjhrxS.Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.cjhrxS.DTO.SignUpDTO;
import ua.cjhrxS.IocContainer.IocContainer;
import ua.cjhrxS.Services.UserService;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {

	private static final long serialVersionUID = 7526235573909548238L;
	private UserService userService;
	private boolean isFirst;

	public SignUpController() {
		super();
		userService = IocContainer.get().getUserService();
		isFirst = true;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute(ControllerUrls.SIGNUP_SERVLET.toString(), req.getRequestURL().toString());
		getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.SIGNUP_JSP.toString()).forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         long idRole = 1L;
         if(isFirst) {
        	 isFirst=false;
        	 idRole = 2L;
        	 }
		SignUpDTO signUp = new SignUpDTO(req.getParameter("firstname"), req.getParameter("lastname"),
				req.getParameter("username"), req.getParameter("password"), idRole);

		userService.setSignUpDto(signUp);
		resp.setStatus(201);
		getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.SIGNIN_JSP.toString()).forward(req, resp);

	}

}
