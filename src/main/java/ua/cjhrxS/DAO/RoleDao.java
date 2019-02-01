package ua.cjhrxS.DAO;

import java.util.ArrayList;

import javax.management.relation.Role;

import ua.cjhrxS.Entity.RoleEntity;
import ua.cjhrxS.Entity.RoleEntity.RoleEntityQueries;

public final class RoleDao extends ADaoCRUD<RoleEntity> {
	private final static String ROLE_FIELDNAME = "name_roles";

	public RoleDao() {
		super();
		init();
	}

	// TODO Create abstract method in ADao
	protected void init() {
		for (RoleEntityQueries roleEntityQueries : RoleEntityQueries.values()) {
			sqlQueries.put(roleEntityQueries.getSqlQuery(), roleEntityQueries);
		}
	}

	protected RoleEntity createInstance(ArrayList<String> arr) {
		return new RoleEntity(
				Long.parseLong(arr.get(0) == null ? "0" : arr.get(0)),
				arr.get(1) == null ? "0" : arr.get(1));
	}

	protected String[] getUpdateFields(RoleEntity entity) {
		String[] result = new String[2];
		String[] allFields = getFields(entity);
		result[0] = allFields[1]; // name
		result[1] = allFields[0]; // id
		return result;
	}

	protected String[] getFields(RoleEntity entity) {
		//String[] fields = new String[Role.class.getDeclaredFields().length];
		String[] fields = new String[2];
		fields[0] = entity.getId().toString();
		fields[1] = entity.getName();
		return fields;
	}

	public RoleEntity getRoleEntityByName(String name) {
		return getByFieldName(ROLE_FIELDNAME, name).get(0);
	}
	
	

}
