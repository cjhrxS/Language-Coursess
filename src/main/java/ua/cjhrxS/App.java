package ua.cjhrxS;

import ua.cjhrxS.DAO.CourseDao;
import ua.cjhrxS.DAO.TeacherDao;
import ua.cjhrxS.DAO.UsersDao;
import ua.cjhrxS.DTO.UserDTO;
import ua.cjhrxS.Entity.TeacherEntity;
import ua.cjhrxS.Entity.UsersEntity;
import ua.cjhrxS.Services.UserService;

public class App {
	public static void main(String[] args) {

		UserService userSer = new UserService();
		UsersDao userDao = new UsersDao();
		CourseDao curse = new CourseDao();
		TeacherDao teacher = new TeacherDao();
	
		UsersEntity user = new UsersEntity(9L, "oleg", "oleg", "oleg", "oleg", 0L);
	    userDao.updateByEntity(user);
		//teacher.updateByEntity(new TeacherEntity(6L, "Anna","Anna", 100500L));
	    
		
		
	}
}
