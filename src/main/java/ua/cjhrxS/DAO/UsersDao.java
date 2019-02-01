package ua.cjhrxS.DAO;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import ua.cjhrxS.Entity.UsersEntity;
import ua.cjhrxS.Entity.UsersEntity.UserEntityQueries;



public final class UsersDao extends ADaoCRUD<UsersEntity> {
	private final static String LOGIN_FIELDNAME = "user_name";

	public UsersDao() {
		
		init();
	}

	// TODO Create abstract method in ADao
	protected void init() {
		for (UserEntityQueries userEntityQueries : UserEntityQueries.values()) {
			sqlQueries.put(userEntityQueries.getSqlQuery(), userEntityQueries);
		}
	}

	protected UsersEntity createInstance(ArrayList<String> arr) {
		return new UsersEntity(
				Long.parseLong(arr.get(0) == null ? "0" : arr.get(0)),
				arr.get(1) == null ? "0" : arr.get(1),
				arr.get(2) == null ? "0" : arr.get(2),
				arr.get(3) == null ? "0" : arr.get(3),
				arr.get(4) == null ? "0" : arr.get(4),
				Long.parseLong(arr.get(5) == null ? "0" : arr.get(5)));
	}

	protected String[] getUpdateFields(UsersEntity userEntity) {
		String[] result = new String[6];
		String[] allFields = getFields(userEntity);
		result[0] = allFields[1]; // role_id
		result[1] = allFields[2]; // password
		result[2] = allFields[3]; // userName
		result[3] = allFields[4]; // lastName
		result[4] = allFields[5]; // firstName
		result[5] = allFields[0]; //id
		return result;
	}

	protected String[] getFields(UsersEntity userEntity) {
		String[] fields = new String[6];
//		List<String> fields = Arrays.asList(
//				userEntity.getId().toString(),
//				userEntity.getFirst_name(),
//				userEntity.getLast_name(),
//				userEntity.getUser_name(),
//				userEntity.getPass_word(),
//				userEntity.getRoles_id().toString());
		fields[0] = userEntity.getId().toString();
		fields[1] = userEntity.getFirst_name();
		fields[2] = userEntity.getLast_name();
		fields[3] = userEntity.getUser_name();
		fields[4] = userEntity.getPass_word();
		fields[5] = userEntity.getRoles_id().toString();
		return fields;
	}

	public UsersEntity getUserEntityByLogin(String user_name) {
		return getByFieldName(LOGIN_FIELDNAME, user_name).get(0);
	}

}
