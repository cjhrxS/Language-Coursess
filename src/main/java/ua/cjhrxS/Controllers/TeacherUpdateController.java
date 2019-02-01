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
import ua.cjhrxS.DTO.TeacherDTO;
import ua.cjhrxS.DTO.UserDTO;
import ua.cjhrxS.IocContainer.IocContainer;
import ua.cjhrxS.Services.TeacherServices;
import ua.cjhrxS.Services.UserService;

@WebServlet("/teacheredit")
public class TeacherUpdateController extends HttpServlet{

	private static final long serialVersionUID = -6319458172299408845L;
	private TeacherServices teacherService;
	private UserService userService;
	
	public TeacherUpdateController() {
		teacherService = IocContainer.get().getTeacherService();
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
			
			TeacherDTO teacherDTO = teacherService.getTeacherDto(Long.parseLong(request.getParameter("idTeacher")));
			session.setAttribute("teacherDTO", teacherDTO);

			getServletConfig()
			.getServletContext()
			.getRequestDispatcher(ViewUrls.TEACHER_EDIT_JSP.toString())
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
			
			TeacherDTO teacherDTO1 = (TeacherDTO) session.getAttribute("teacherDTO");
			Long idEditTeacher = teacherDTO1.getId();
			
			TeacherDTO teacherDTO = new TeacherDTO(idEditTeacher, 
					request.getParameter("firstname"), request.getParameter("lastname"), Long.parseLong(request.getParameter("experience")));
			

			System.out.println(teacherDTO);
			teacherService.setTeacherDto(teacherDTO);
			
			getServletConfig()
			.getServletContext()
			.getRequestDispatcher(ControllerUrls.ADMIN_TEACHER_SERVLET.toString())
			.forward(request, response);
		}
	}
}
