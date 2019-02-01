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
import ua.cjhrxS.DTO.UserCourseDTO;
import ua.cjhrxS.DTO.UserDTO;
import ua.cjhrxS.IocContainer.IocContainer;
import ua.cjhrxS.Services.UserCourseService;
import ua.cjhrxS.Services.UserService;

@WebServlet("/admincourse")
public class CourseAdminController  extends HttpServlet{

	private static final long serialVersionUID = -255010083460930781L;
	private UserService userServ;
	private UserCourseService courseService;
	
	public CourseAdminController() {
		userServ = IocContainer.get().getUserService();
		courseService = IocContainer.get().getUserCourseService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		UserDTO userDto = userServ.getUserByName(user.getUser_name());
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
		

			UserCourseDTO userCourseDto = IocContainer.get()
					.getUserCourseService()
					.getUserCourse(IocContainer.get()
							.getUserService()
							.getUserDTO((SignInDTO) request.getSession(false).getAttribute("username")));
                        request.setAttribute("userCourseDto", userCourseDto);
			request.setAttribute("countCourses",
					String.valueOf(userCourseDto.getCourses().size()));
			
			Cookie visibleItemsCookie = null;
			for (Cookie currentCookie : request.getCookies()) {
				if (currentCookie.getName().equals("visible_items")) {
					visibleItemsCookie = currentCookie;
					break;
				}
			}
			
			String visibleItems = "1000";
			if (visibleItemsCookie != null) {
				visibleItems = visibleItemsCookie.getValue();
			}
			request.setAttribute("visibleItems", visibleItems);
			//
			int pageNumber = 5;
			if (request.getParameter("pageNumber") != null) {
				pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
			}
			request.setAttribute("pageNumber",
					String.valueOf(pageNumber));
			// TODO Get custom Items for userItemsDto, use visibleItems
			//
			getServletConfig()
				.getServletContext()
				.getRequestDispatcher(ViewUrls.ADMIN_COURSE_JSP.toString())
				.forward(request, response);
		}
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	
	}
}
