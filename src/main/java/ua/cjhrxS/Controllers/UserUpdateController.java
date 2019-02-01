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
import ua.cjhrxS.DTO.UserDTO;
import ua.cjhrxS.IocContainer.IocContainer;
import ua.cjhrxS.Services.UserService;

@WebServlet("/useredit")
public class UserUpdateController extends HttpServlet {

	private static final long serialVersionUID = -3573964689194165632L;
	private UserService userService;
	
	public UserUpdateController() {
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
				UserDTO userDTO1 = userService.getUserDtoById(Long.parseLong(request.getParameter("idUser")));
				session.setAttribute("userDTO1", userDTO1);
				getServletConfig()
				.getServletContext()
				.getRequestDispatcher(ViewUrls.USER_EDIT_JSP.toString())
				.forward(request, response);
			}
		
		
		}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			
			UserDTO useridDTO = (UserDTO) session.getAttribute("userDTO1");
			Long idEditUser = useridDTO.getId();
			
			UserDTO userDTO = new UserDTO(idEditUser, 
											request.getParameter("firstname"), 
											request.getParameter("lastname"), 
											request.getParameter("username"), 
											request.getParameter("password"),
											Long.parseLong(request.getParameter("roleId")));
			System.out.println(userDTO);
			userService.setUserDto(userDTO);
			getServletConfig()
			.getServletContext()
			.getRequestDispatcher(ControllerUrls.ADMIN_USER_SERVLET.toString())
			.forward(request, response);
		}
	}
	

}
