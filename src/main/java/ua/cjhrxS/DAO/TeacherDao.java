package ua.cjhrxS.DAO;

import java.util.ArrayList;
import java.util.List;

import ua.cjhrxS.Entity.TeacherEntity;
import ua.cjhrxS.Entity.TeacherEntity.TeacherEntityQueries;



public final class TeacherDao extends ADaoCRUD<TeacherEntity> {
	private final static String ID_TEACHER_FIELDNAME = "id";

	public TeacherDao() {
		super();
		init();
	}

	// TODO Create abstract method in ADao
	protected void init() {
		for (TeacherEntityQueries teacherEntityQueries : TeacherEntityQueries.values()) {
			sqlQueries.put(teacherEntityQueries.getSqlQuery(), teacherEntityQueries);
		}
	}

	protected TeacherEntity createInstance(ArrayList<String> arr) {
		return new TeacherEntity(
				Long.parseLong(arr.get(0) == null ? "0" : arr.get(0)),
				arr.get(1) == null ? "0" : arr.get(1),
				arr.get(2) == null ? "0" : arr.get(2),
				Long.parseLong(arr.get(3) == null ? "0" : arr.get(3)));
	}

	protected String[] getUpdateFields(TeacherEntity teacherEntity) {
		String[] result = new String[4];
		String[] allFields = getFields(teacherEntity);
		result[0] = allFields[1]; // experience
		result[1] = allFields[2]; // lastName
		result[2] = allFields[3]; // firstName
		result[3] = allFields[0]; // id
		// id
		return result;
	}

	protected String[] getFields(TeacherEntity teacherEntity) {
		//String[] fields = new String[Item.class.getDeclaredFields().length];
		String[] fields = new String[4];
		fields[0] = teacherEntity.getId().toString();
		fields[1] = teacherEntity.getFirst_name();
		fields[2] = teacherEntity.getLast_name();
		fields[3] = teacherEntity.getExpierence().toString();

		
		
		return fields;
	}

	public List<TeacherEntity> getItemEntityByIdUser(Long id) {
		return getByFieldName(ID_TEACHER_FIELDNAME, id.toString());
	}

}
