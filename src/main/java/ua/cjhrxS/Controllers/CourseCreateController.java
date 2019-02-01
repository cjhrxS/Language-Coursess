package ua.cjhrxS.Controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.cjhrxS.DTO.CourseDTO;
import ua.cjhrxS.DTO.SignInDTO;

import ua.cjhrxS.DTO.UserDTO;
import ua.cjhrxS.IocContainer.IocContainer;
import ua.cjhrxS.Services.CourseService;
import ua.cjhrxS.Services.UserService;

@WebServlet("/coursecreate")
public class CourseCreateController extends HttpServlet {

	private static final long serialVersionUID = -9157178309537318324L;
	private CourseService courseService;
	private UserService userService;

	public CourseCreateController() {
		courseService = IocContainer.get().getCourseServise();
		userService = IocContainer.get().getUserService();
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
		UserDTO userDto = userService.getUserByName(user.getUser_name());
		long roleId = userDto.getRoles_id();
		long userId = userDto.getId();
		session.setAttribute("roleId", roleId);
		session.setAttribute("userId", userId);

		isActiveSession = isActiveSession && (session != null) && (session.getAttribute("username") != null)
				&& (((SignInDTO) (session.getAttribute("username"))).getUser_name() != null)
				&& (idSessionCookie != null);
		isActiveSession = isActiveSession && (idSessionCookie.getValue().equals(session.getId()));
		//
		if (!isActiveSession) {
			getServletConfig().getServletContext().getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
					.forward(request, response);
		} else {

			request.setAttribute(ControllerUrls.COURSE_CREATE_SERVLET.toString(), request.getRequestURL().toString());
			getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.COURSE_CREATE_JSP.toString())
					.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long userid = (long) req.getSession().getAttribute("userId");
		CourseDTO courseDTO = new CourseDTO(0L, req.getParameter("name_courses"),
				Integer.parseInt(req.getParameter("price")), LocalDate.parse(req.getParameter("start_date")),
				LocalDate.parse(req.getParameter("end_date")), Long.parseLong(req.getParameter("teacher_id")), userid);

		courseService.setCourseDto(courseDTO);
		resp.setStatus(201);
		getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.ADMIN_COURSE_JSP.toString()).forward(req,
				resp);

	}

}
