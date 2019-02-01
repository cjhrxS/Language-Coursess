package ua.cjhrxS.Entity;

public class RoleEntity implements BaseEntity {

    public static enum RoleEntityQueries {
		CREATE(SqlQueries.CREATE, "CREATE TABLE IF NOT EXISTS roles(" 
				+ "id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
				+ "name_roles VARCHAR(30) NOT NULL UNIQUE" 
				+ ");"), 
        INSERT(SqlQueries.INSERT, "INSERT INTO roles (name_roles) VALUES ('%s');"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, name_roles FROM roles WHERE id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, name_roles FROM roles WHERE %s = '%s';"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, name_roles FROM roles;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE roles SET name_roles = '%s' WHERE id = %s;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE roles SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM roles WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM roles WHERE %s = '%s';");
    	//
        private SqlQueries sqlQuery;
        private String query;

        private RoleEntityQueries(SqlQueries sqlQuery, String query) {
        	this.sqlQuery = sqlQuery;
            this.query = query;
        }

        public SqlQueries getSqlQuery() {
            return sqlQuery;
        }

        @Override
        public String toString() {
            return query;
        }
    }

	private Long id;
	private String name_roles;
	
	public RoleEntity(Long id, String name) {
		this.id = id;
		this.name_roles = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name_roles;
	}

	public void setName(String name) {
		this.name_roles = name;
	}

	@Override
	public String toString() {
		return "(" + "id=" + id 
				+ " name=" + name_roles + ")";
	}

}
