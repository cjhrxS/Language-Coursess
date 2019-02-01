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
import ua.cjhrxS.DTO.SignUpDTO;
import ua.cjhrxS.DTO.UserDTO;
import ua.cjhrxS.IocContainer.IocContainer;
import ua.cjhrxS.Services.UserService;

@WebServlet("/usercreate")
public class UserCreateAdmin extends HttpServlet {

	private static final long serialVersionUID = -3647601323902141985L;
	private UserService userService;
	
	public UserCreateAdmin() {
		userService = IocContainer.get().getUserService();
	}
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	boolean isActiveSession = true;
		HttpSession session = request.getSession(false); // Do not Create new Session
		Cookie idSessionCookie = null;
		for (Cookie currentCookie : request.getCookies()) {
			if (currentCookie.getName().equals("id_session")) {
				idSessionCookie = currentCookie;
				break;
			}
		}
		
		
		SignInDTO user = (SignInDTO) session.getAttribute("username");
		UserDTO userDto = userService.getUserByName(user.getUser_name());
		long roleId = userDto.getRoles_id();
		session.setAttribute("roleId", roleId);
		
		
		isActiveSession = isActiveSession && (session != null) && (session.getAttribute("username") != null)
				&& (((SignInDTO) (session.getAttribute("username"))).getUser_name() != null)
				&& (idSessionCookie != null);
		isActiveSession = isActiveSession && (idSessionCookie.getValue().equals(session.getId()));
		//
		if (!isActiveSession) {
			getServletConfig().getServletContext().getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
					.forward(request, response);
		} else {
    	
    	
    	request.setAttribute(ControllerUrls.USER_CREATE_SERVLET.toString(), request.getRequestURL().toString());
    	getServletConfig().
    	getServletContext().
    	getRequestDispatcher(ViewUrls.SIGNUP_JSP.toString()).
    	forward(request, response);
		}
    	
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	SignUpDTO signUp = new SignUpDTO(req.getParameter("firstname"), req.getParameter("lastname"), req.getParameter("username"), req.getParameter("password"), 1L);
        
		    userService.setSignUpDto(signUp);
			resp.setStatus(201);
			getServletConfig()
			.getServletContext()
			.getRequestDispatcher(ViewUrls.ADMIN_USER_JSP.toString()).forward(req, resp);
		
    	
    }

}
