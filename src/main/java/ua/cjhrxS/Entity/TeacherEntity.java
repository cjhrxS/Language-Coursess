package ua.cjhrxS.Entity;



public class TeacherEntity implements BaseEntity {

	// query for this table

	public static enum TeacherEntityQueries {
		CREATE(SqlQueries.CREATE,
				"CREATE TABLE IF NOT EXISTS teacher(" 
						+ "id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
						+ "first_name VARCHAR(80) NOT NULL," 
						+ "last_name VARCHAR(80) NOT NULL,"
						+ "expierence INT" 
						+ ");"),
		INSERT(SqlQueries.INSERT,
				"INSERT INTO teacher (first_name, last_name, expierence) VALUES ('%s', '%s', '%s');"),
		GET_BY_ID(SqlQueries.GET_BY_ID,
				"SELECT id, first_name, last_name, expierence FROM teacher WHERE id = %s;"),
		GET_BY_FIELD(SqlQueries.GET_BY_FIELD,
				"SELECT id, first_name, last_name, expierence FROM teacher WHERE %s = '%s';"),
		GET_ALL(SqlQueries.GET_ALL,
				"SELECT id, first_name, last_name, expierence FROM teacher;"),
		UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID,
				"UPDATE teacher SET first_name = '%s', last_name = '%s', expierence = '%s' WHERE id = %s;"),
		UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE teacher SET %s = '%s' WHERE %s = '%s';"),
		DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM teacher WHERE id = %s;"),
		DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM teacher WHERE %s = '%s';");
		//
		private SqlQueries sqlQuery;
		private String query;

		private TeacherEntityQueries(SqlQueries sqlQuery, String query) {
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

	// Variable

	private Long id;
	private String first_name;
	private String last_name;
	private Long expierence;


	// Constructor

	public TeacherEntity() {

	}

	public TeacherEntity(Long id, String first_name, String last_name, Long expierence) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.expierence = expierence;
		
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

	public Long getExpierence() {
		return expierence;
	}

	public void setExpierence(Long expierence) {
		this.expierence = expierence;
	}


	// To String

	@Override
	public String toString() {
		return "TeacherEntity [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", expierence=" + expierence + "]";
	}

}
