package ua.cjhrxS.Entity;



public class UsersEntity implements BaseEntity {

	// query for this Table

	public static enum UserEntityQueries {
		CREATE(SqlQueries.CREATE,
				"CREATE TABLE IF NOT EXISTS users(" + "id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
						+ "first_name VARCHAR(80) NOT NULL," 
						+ "last_name VARCHAR(80) NOT NULL,"
						+ "user_name VARCHAR(80) NOT NULL UNIQUE," 
						+ "pass_word VARCHAR(80) NOT NULL,"
						+ "roles_id INT(20) NOT NULL," 
						+ "foreign key (roles_id) references roles(id)"
						+ ");"),
		INSERT(SqlQueries.INSERT,
				"INSERT INTO users (first_name, last_name, user_name, pass_word, roles_id) VALUES ('%s', '%s', '%s', '%s', '%s');"),
		GET_BY_ID(SqlQueries.GET_BY_ID,
				"SELECT id, first_name, last_name, user_name, pass_word, roles_id FROM users WHERE id = '%s';"),
		GET_BY_FIELD(SqlQueries.GET_BY_FIELD,
				"SELECT id, first_name, last_name, user_name, pass_word, roles_id FROM users WHERE %s = '%s';"),
		GET_ALL(SqlQueries.GET_ALL,
				"SELECT id, first_name, last_name, user_name, pass_word, roles_id FROM users;"),
		UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID,
				"UPDATE users SET first_name = '%s', last_name = '%s', user_name = '%s', pass_word = '%s', roles_id = '%s' WHERE id = %s;"),
		UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE users SET %s = '%s' WHERE %s = '%s';"),
		DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM users WHERE id = %s;"),
		DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM users WHERE %s = '%s';");
		//
		private SqlQueries sqlQuery;
		private String query;

		private UserEntityQueries(SqlQueries sqlQuery, String query) {
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

	// Variable of Entity

	private Long id;
	private String first_name;
	private String last_name;
	private String user_name;
	private String pass_word;
	private Long roles_id;

	// Constructor
	
	public UsersEntity() {
		
	}

	public UsersEntity(Long id, String first_name, String last_name, String user_name,
			String pass_word, Long roles_id) {
		this.id =id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_name = user_name;
		this.pass_word = pass_word;
		this.roles_id = roles_id;
	}


	// Getter's and Setter's

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	
	

	public Long getRoles_id() {
		return roles_id;
	}

	public void setRoles_id(Long roles_id) {
		this.roles_id = roles_id;
	}

	// To String
	
	@Override
	public String toString() {
		return "UsersEntity [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", user_name="
				+ user_name + ", pass_word=" + pass_word + ", roles_id=" + roles_id + "]";
	}


}
