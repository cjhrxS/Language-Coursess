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
import ua.cjhrxS.Services.CourseService;
import ua.cjhrxS.Services.UserService;

@WebServlet("/coursedelete")
public class CourseDeleteController extends HttpServlet{

	private static final long serialVersionUID = -4062885187859813745L;
	private CourseService courseService;
	private UserService userService;
	
	public CourseDeleteController() {
		courseService = IocContainer.get().getCourseServise();
		userService = IocContainer.get().getUserService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isActiveSession = true;
		HttpSession session = request.getSession(false); 
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
           
			
			
			courseService.deleteCourseById(Long
					.parseLong(request.getParameter("idCourseDelete")));
			getServletConfig()
				.getServletContext()
				.getRequestDispatcher(ControllerUrls.ADMIN_COURSE_SERVLET.toString())
				.forward(request, response);
		}
		
	}

}
