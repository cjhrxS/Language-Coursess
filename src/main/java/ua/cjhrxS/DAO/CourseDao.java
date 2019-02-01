package ua.cjhrxS.DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ua.cjhrxS.Entity.CourseEntity;
import ua.cjhrxS.Entity.CourseEntity.CourseEntityQueries;


public final class CourseDao extends ADaoCRUD<CourseEntity> {
	private final static String ID_COURSE_FIELDNAME = "id";

	public CourseDao() {
		super();
		init();
	}

	// TODO Create abstract method in ADao
	protected void init() {
		for (CourseEntityQueries courseEntityQueries : CourseEntityQueries.values()) {
			sqlQueries.put(courseEntityQueries.getSqlQuery(), courseEntityQueries);
		}
	}

	
	protected CourseEntity createInstance(ArrayList<String> arr) {
		return new CourseEntity(
				Long.parseLong(arr.get(0) == null ? "0" : arr.get(0)),
				arr.get(1) == null ? "0" : arr.get(1),
				Integer.parseInt(arr.get(2) == null ? "0" : arr.get(2)),
				LocalDate.parse(arr.get(3) == null ? "0" : arr.get(3)),
				LocalDate.parse(arr.get(4) == null ? "0" : arr.get(4)),
				Long.parseLong(arr.get(5) == null ? "0" : arr.get(5)),
				Long.parseLong(arr.get(6) == null ? "0" : arr.get(6)));
	}

	protected String[] getUpdateFields(CourseEntity courseEntity) {
		String[] result = new String[7];
		String[] allFields = getFields(courseEntity);
		result[0] = allFields[1]; // user_id
		result[1] = allFields[2]; // teacher_id
		result[2] = allFields[3]; // endDate
		result[3] = allFields[4]; // startDate
		result[4] = allFields[5]; // price
		result[5] = allFields[6]; // nameCourse 
		result[6] = allFields[0]; // id	
		return result;
	}
	
	//name_courses = '%s', price = '%s', start_date = '%s', end_date = '%s', teacher_id = '%s', user_id = '%s' WHERE id = %s;"),

	protected String[] getFields(CourseEntity courseEntity) {
		
		String[] fields = new String[7];
		fields[0] = courseEntity.getId().toString();
		fields[1] = courseEntity.getName_courses();
		fields[2] = courseEntity.getPrice().toString();
		fields[3] = courseEntity.getStart_date().toString();
		fields[4] = courseEntity.getEnd_date().toString();
		fields[5] = courseEntity.getTeacher_id().toString();
		fields[6] = courseEntity.getUser_id().toString();
		return fields;
	}

	public List<CourseEntity> getItemEntityByIdUser(Long id) {
		return getByFieldName(ID_COURSE_FIELDNAME, id.toString());
	}

}
