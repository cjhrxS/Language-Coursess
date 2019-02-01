package ua.cjhrxS.Services;

import java.util.List;

import ua.cjhrxS.Converter.Convetor;
import ua.cjhrxS.DAO.CourseDao;
import ua.cjhrxS.DTO.CourseDTO;
import ua.cjhrxS.Entity.CourseEntity;

public class CourseService {

	private CourseDao courseDao;
	private CourseDTO courseDto;
	private Convetor convetor;

	public CourseService() {

		this.courseDao = new CourseDao();
        this.courseDto = new CourseDTO();
        this.convetor = new Convetor();
        
	}

	public CourseService(CourseDao courseDao) {

		this.courseDao = courseDao;

	}

	public CourseDTO getCourseDtoById(Long id) {

		CourseEntity course = courseDao.getById(id);

		return new CourseDTO(course.getId(), course.getName_courses(), course.getPrice(), course.getStart_date(),
				course.getEnd_date(), course.getTeacher_id(), 0L);

	}

	public boolean setCourseDto(CourseDTO courseDto) {
		boolean result = false;
		CourseEntity course = new CourseEntity(courseDto.getId(), courseDto.getName_courses(), courseDto.getPrice(),
				courseDto.getStart_date(), courseDto.getEnd_date(), courseDto.getTeacher_id(), 0L);

		
			if (isExistCourse(course.getId())) {

				courseDao.updateByEntity(course);
				result = true;

			
		} else {
			courseDao.insert(course);
			result = true;
		}
		
		return result;

	}

	public boolean isExistCourse(long id) {
		boolean result = true;
		try {
			courseDao.getById(id);
		} catch (RuntimeException e) {
			// Logging Exception
			System.out.println("Course not found, message: " + e.getMessage());
			result = false;
		}
		return result;
	}
	
	
	
public List<CourseDTO> getAll() {
	
	List<CourseEntity> courses = courseDao.getAll();
	List<CourseDTO> courseDTO = convetor.transformAllCEntityInDto(courses);
	return courseDTO;
		
	
	}
	
	public boolean deleteCourseById(Long id) {
		
		boolean result = true;
		try {
			result = result && courseDao.deleteById(id);
		} catch (RuntimeException e) {

		result = false;
			
		}
		
		return result;
	}

}
