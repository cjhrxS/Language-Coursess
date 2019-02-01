package ua.cjhrxS.IocContainer;

import ua.cjhrxS.DAO.CourseDao;
import ua.cjhrxS.DAO.TeacherDao;
import ua.cjhrxS.DAO.UsersDao;
import ua.cjhrxS.Services.CourseService;
import ua.cjhrxS.Services.TeacherServices;
import ua.cjhrxS.Services.UserCourseService;
import ua.cjhrxS.Services.UserService;

public final class IocContainer {

	private static volatile IocContainer instance = null;
	//
	private UsersDao userDao;
	private TeacherDao teacherDao;
	private CourseDao courseDao;
	//
	private UserService userService;
	private TeacherServices teacherService;
	private CourseService courseServise;
	private UserCourseService userCourseService;

	private IocContainer() {
		initDaos();
		initServices();
	}
	
	private void initDaos() {
		userDao = new UsersDao();
		teacherDao = new TeacherDao();
		courseDao = new CourseDao();
	}

	private void initServices() {
		userService = new UserService(userDao);
		teacherService = new TeacherServices(teacherDao);
		courseServise = new CourseService(courseDao);
		userCourseService = new UserCourseService(userDao, courseDao);
	}

	
	public static IocContainer get() {
		if (instance == null) {
			synchronized (IocContainer.class) {
				if (instance == null) {
					instance = new IocContainer();
				}
			}
		}
		return instance;
	}
	



	/**
	 * @return the userDao
	 */
	public UsersDao getUserDao() {
		return userDao;
	}
	

	/**
	 * @return the teacherDao
	 */
	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	/**
	 * @return the courseDao
	 */
	public CourseDao getCourseDao() {
		return courseDao;
	}

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @return the teacherService
	 */
	public TeacherServices getTeacherService() {
		return teacherService;
	}

	/**
	 * @return the courseServise
	 */
	public CourseService getCourseServise() {
		return courseServise;
	}
	
	/**
	 * @return the userCourseService
	 */
	public UserCourseService getUserCourseService() {
		return userCourseService;
	}

	

}
