package ua.cjhrxS.Controllers;

public enum ControllerUrls {
	ROOT_SERVLET("/"),			
	LOGIN_SERVLET("/signin"),	
	SIGNUP_SERVLET("signup"),
	LOGOUT_SERVLET("/signout"),	
	//
	ADMIN_PANEL_SERVLET("/admin"),
	ADMIN_USER_SERVLET("/adminuser"),
	ADMIN_COURSE_SERVLET("/admincourse"),
	ADMIN_TEACHER_SERVLET("/adminteacher"),
	//
	USER_CREATE_SERVLET("/usercreate"),	 
	USER_EDIT_SERVLET("/useredit"),		
	USER_UPDATE_SERVLET("/userupdate"),
	USER_DELETE_SERVLET("/userdelete"),
	
	//
	TEACHER_CREATE_SERVLET("/teachercreate"),	
	TEACHER_EDIT_SERVLET("/teacheredit"),		
	TEACHER_UPDATE_SERVLET("/teacherupdate"), 
	TEACHER_DELETE_SERVLET("/teacherdelete"),  
	
	//
	COURSE_CREATE_SERVLET("/coursecreate"), 
	COURSE_EDIT_SERVLET("/courseedit"),
	COURSE_UPDATE_SERVLET("/courseupdate"),
	COURSE_DELETE_SERVLET("/coursedelete"),
	//
	TEACHER_COURSE_SERVLET("/teachercourse"), 
	BUY_SERVLET("/buy"), 
	USER_COURSE_SERVLET("/usercourse"); 
	//
	private String url;

	private ControllerUrls(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return url;
	}
}
