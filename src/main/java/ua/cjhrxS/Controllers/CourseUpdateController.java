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

@WebServlet("/courseedit")
public class CourseUpdateController extends HttpServlet{

	private static final long serialVersionUID = -3680306764363359226L;
	private CourseService courseService;
	private UserService userService;
	
	public CourseUpdateController() {
		courseService = IocContainer.get().getCourseServise();
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
			
			
			CourseDTO courseDTO = courseService.getCourseDtoById(Long.parseLong(request.getParameter("idCourse")));
			session.setAttribute("courseDTO", courseDTO);
			getServletConfig()
			.getServletContext()
			.getRequestDispatcher(ViewUrls.COURSE_EDIT_JSP.toString())
			.forward(request, response);
			

		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			
			CourseDTO courseDTO1 = (CourseDTO) session.getAttribute("courseDTO");
			Long idEditCourse = courseDTO1.getId();
			
			
			CourseDTO courseDTO = new CourseDTO(idEditCourse, 
					request.getParameter("name_courses"),
					Integer.parseInt(request.getParameter("price")), 
					LocalDate.parse(request.getParameter("start_date")),
					LocalDate.parse(request.getParameter("end_date")), 
					Long.parseLong(request.getParameter("teacher_id")), 
					roleId);
			

			System.out.println(courseDTO);
			courseService.setCourseDto(courseDTO);
			getServletConfig()
			.getServletContext()
			.getRequestDispatcher(ControllerUrls.ADMIN_COURSE_SERVLET.toString())
			.forward(request, response);
		}
	
	}
	
	
	

}
