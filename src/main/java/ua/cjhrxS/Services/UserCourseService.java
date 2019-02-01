package ua.cjhrxS.Services;

import java.util.List;

import javax.sql.DataSource;

import ua.cjhrxS.DAO.CourseDao;
import ua.cjhrxS.DAO.UsersDao;
import ua.cjhrxS.DB.ConnectionManager;
import ua.cjhrxS.DTO.CourseDTO;
import ua.cjhrxS.DTO.UserCourseDTO;
import ua.cjhrxS.DTO.UserDTO;
import ua.cjhrxS.Entity.CourseEntity;
import ua.cjhrxS.Entity.UsersEntity;

public class UserCourseService {
	
	private UsersDao userDao;
	private CourseDao courseDao;
	
	
	public UserCourseService(UsersDao userDao, CourseDao courseDao) {
		
		this.userDao = new UsersDao();
		this.courseDao = new CourseDao();
	}

	public UserCourseDTO getUserCourse(UserDTO userDto) {
		UsersEntity user = userDao.getUserEntityByLogin(userDto.getUser_name());
		UserCourseDTO userCourseDto = new UserCourseDTO(user.getUser_name());
		// TODO get fixed count
		for (CourseEntity course : courseDao.getAll()) {
			CourseDTO courseDTO = new CourseDTO(
					course.getId(),
					course.getName_courses(),
					course.getPrice(),
					course.getStart_date(),
					course.getEnd_date(),
					course.getTeacher_id(),
					course.getUser_id());
			userCourseDto.addCourseDTO(courseDTO);
		}
		return userCourseDto;
	}

}
