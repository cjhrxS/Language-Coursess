package ua.cjhrxS.Converter;

import java.util.ArrayList;
import java.util.List;

import ua.cjhrxS.DTO.CourseDTO;
import ua.cjhrxS.DTO.TeacherDTO;
import ua.cjhrxS.DTO.UserDTO;
import ua.cjhrxS.Entity.CourseEntity;
import ua.cjhrxS.Entity.TeacherEntity;
import ua.cjhrxS.Entity.UsersEntity;

public class Convetor {

	/*
	 * Methods for transform DTO in Entity , Entity in DTO for table users
	 */
	public UsersEntity transformUDtoInEntity(UserDTO userDTO) {

		UsersEntity userEntity = new UsersEntity(0L, userDTO.getFirst_name(), userDTO.getLast_name(),
				userDTO.getUser_name(), userDTO.getPass_word(), userDTO.getRoles_id());

		return userEntity;

	}

	public UserDTO transformUEntityInDto(UsersEntity userEntity) {

		UserDTO userDTO = new UserDTO(userEntity.getId(), userEntity.getFirst_name(), userEntity.getLast_name(),
				userEntity.getUser_name(), userEntity.getPass_word(), userEntity.getRoles_id());

		return userDTO;
	}

	public List<UserDTO> transformAllEntityInDto(List<UsersEntity> userEntity) {

		List<UserDTO> userDTO = new ArrayList<UserDTO>();
		for (UsersEntity element : userEntity) {

			userDTO.add(transformUEntityInDto(element));

		}

		return userDTO;

	}

	/*
	 * Methods for transform DTO in Entity , Entity in DTO for table course
	 */
	public CourseEntity transformCDtoInEntity(CourseDTO courseDTO) {

		CourseEntity courseEntity = new CourseEntity(0L, courseDTO.getName_courses(), courseDTO.getPrice(),
				courseDTO.getStart_date(), courseDTO.getEnd_date(), courseDTO.getTeacher_id(), courseDTO.getUser_id());

		return courseEntity;

	}

	public CourseDTO transformCEntityInDto(CourseEntity courseEntity) {

		CourseDTO courseDTO = new CourseDTO(courseEntity.getId(),courseEntity.getName_courses(), courseEntity.getPrice(),
			courseEntity.getStart_date(), courseEntity.getEnd_date(),courseEntity.getTeacher_id(), courseEntity.getUser_id());

		return courseDTO;
	}

	public List<CourseDTO> transformAllCEntityInDto(List<CourseEntity> courseEntity) {

		List<CourseDTO> courseDTO = new ArrayList<CourseDTO>();
		for (CourseEntity element : courseEntity) {

			courseDTO.add(transformCEntityInDto(element));

		}

		return courseDTO;

	}

	/*
	 * Methods for transform DTO in Entity , Entity in DTO for table teacher
	 */
	public TeacherEntity transformTDtoInEntity(TeacherDTO teacherDTO) {

		TeacherEntity teacherEntity = new TeacherEntity(0L, teacherDTO.getFirst_name(), teacherDTO.getLast_name(),
				teacherDTO.getExpierence());

		return teacherEntity;

	}

	public TeacherDTO transformTEntityInDto(TeacherEntity teacherEntity) {

		TeacherDTO teacherDTO = new TeacherDTO(teacherEntity.getId(), teacherEntity.getFirst_name(),
				teacherEntity.getLast_name(), teacherEntity.getExpierence());

		return teacherDTO;
	}
	
	public List<TeacherDTO> transformAllTEntityInDto(List<TeacherEntity> teacherEntity) {

		List<TeacherDTO> teacherDTO = new ArrayList<TeacherDTO>();
		for (TeacherEntity element : teacherEntity) {

			teacherDTO.add(transformTEntityInDto(element));

		}

		return teacherDTO;

	}

}
