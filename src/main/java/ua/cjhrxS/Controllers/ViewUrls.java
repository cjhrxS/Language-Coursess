package ua.cjhrxS.Controllers;

public enum ViewUrls {
	SIGNIN_JSP("/WEB-INF/views/LogIn.jsp"),
	SIGNUP_JSP("/WEB-INF/views/SignUp.jsp"),
	USER_COURSE_JSP("/WEB-INF/views/Course.jsp"),
	ADMIN_PANEL_JSP("/WEB-INF/views/AdminPanel.jsp"),
	ADMIN_USER_JSP("/WEB-INF/views/AdminUser.jsp"),
	ADMIN_TEACHER_JSP("/WEB-INF/views/AdminTeacher.jsp"),
	ADMIN_COURSE_JSP("/WEB-INF/views/AdminCourse.jsp"),
	TEACHER_CREATE_JSP("/WEB-INF/views/teachercreate.jsp"),
	COURSE_CREATE_JSP("/WEB-INF/views/coursecreate.jsp"),
	USER_EDIT_JSP("/WEB-INF/views/useredit.jsp"),
	COURSE_EDIT_JSP("/WEB-INF/views/courseedit.jsp"),
	TEACHER_EDIT_JSP("/WEB-INF/views/teacheredit.jsp"),
	BUY_JSP("/WEB-INF/views/buy.jsp"),
	ERROR_JSP("/WEB-INF/views/commons/Error.jsp");
	//
	private String url;

	private ViewUrls(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return url;
	}
}
