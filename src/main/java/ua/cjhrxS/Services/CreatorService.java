package ua.cjhrxS.Services;

import ua.cjhrxS.DAO.CourseDao;
import ua.cjhrxS.DAO.RoleDao;
import ua.cjhrxS.DAO.TeacherDao;
import ua.cjhrxS.DAO.UsersDao;
import ua.cjhrxS.Entity.RoleEntity;


public class CreatorService {

	private UsersDao userDao;
	private TeacherDao teacherDao;
	private RoleDao roleDao;
	private CourseDao courseDao;
	private boolean isFirst;

	public CreatorService() {
		roleDao = new RoleDao();
		userDao = new UsersDao();
		teacherDao = new TeacherDao();
		courseDao = new CourseDao();
		isFirst = true;
		
	}

	public boolean createTable() {
		boolean create = true;
		if(isFirst) {
			isFirst = false;
		    roleDao.create();
//		    roleDao.insert(new RoleEntity(1L, "USER"));
//		    roleDao.insert(new RoleEntity(2L, "ADMIN"));
			userDao.create(); 
			teacherDao.create(); 
			courseDao.create();
			
		} else {
			
			create = false;
		}
	

		return create;

	}

}
