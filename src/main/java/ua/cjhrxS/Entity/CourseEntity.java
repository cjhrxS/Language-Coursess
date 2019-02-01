package ua.cjhrxS.Entity;

import java.time.LocalDate;

public class CourseEntity implements BaseEntity {

	// SQL query for Table

	public static enum CourseEntityQueries {
		CREATE(SqlQueries.CREATE,
				"CREATE TABLE if NOT EXISTS course(" 
						+ "id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
						+ "name_courses VARCHAR(30) NOT NULL UNIQUE," 
						+ "price INT NOT NULL ,"
						+ "start_date DATE NOT NULL," 
						+ "end_date DATE NOT NULL," 
						+ "teacher_id INT NOT NULL,"
						+ "foreign key (teacher_id) references teacher(id) ON DELETE CASCADE,"
						+ "user_id INT DEFAULT 0"
						+ ");"),
		INSERT(SqlQueries.INSERT,
				"INSERT INTO course (name_courses, price, start_date, end_date, teacher_id, user_id) VALUES ('%s','%s','%s', '%s', '%s', %s);"),
		GET_BY_ID(SqlQueries.GET_BY_ID,
				"SELECT id, name_courses, price, start_date, end_date, teacher_id, user_id FROM course WHERE id = %s;"),
		GET_BY_FIELD(SqlQueries.GET_BY_FIELD,
				"SELECT id, name_courses, price, start_date, end_date, teacher_id, user_id FROM course WHERE %s = '%s';"),
		GET_ALL(SqlQueries.GET_ALL, "SELECT id, name_courses, price, start_date, end_date, teacher_id, user_id FROM course;"),
		GET_ALL_SPECIAL(SqlQueries.GET_ALL_SPECIAL, "SELECT c.id, c.name_courses, c.price, c.start_date, c.end_date, t.first_name AS teacher_name  FROM course c \r\n" + 
				"JOIN teacher t ON c.teacher_id = t.id;"),
		UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID,
				"UPDATE course SET name_courses = '%s', price = '%s', start_date = '%s', end_date = '%s', teacher_id = '%s', user_id = '%s' WHERE id = %s;"),
		UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE course SET %s = '%s' WHERE %s = '%s';"),
		DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM course WHERE id = %s;"),
		DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM course WHERE %s = '%s';");
		//
		private SqlQueries sqlQuery;
		private String query;

		private CourseEntityQueries(SqlQueries sqlQuery, String query) {
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

	// Variables

	private Long id;
	private String name_courses;
	private Integer price;
	private LocalDate start_date;
	private LocalDate end_date;
	private Long teacher_id;
	private Long user_id;

	// Constructor

	public CourseEntity() {

	}

	public CourseEntity(Long id, String name_courses, Integer price, LocalDate start_date, LocalDate end_date,
			Long teacher_id, Long user_id) {
		this.id = id;
		this.name_courses = name_courses;
		this.price = price;
		this.start_date = start_date;
		this.end_date = end_date;
		this.teacher_id = teacher_id;
		this.user_id = user_id;
	}

	// Getter's and Setter's

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName_courses() {
		return name_courses;
	}

	public void setName_courses(String name_courses) {
		this.name_courses = name_courses;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public Long getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Long teacher_id) {
		this.teacher_id = teacher_id;
	}
	
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	

	// To String

	@Override
	public String toString() {
		return "CourseEntity [id=" + id + ", name_courses=" + name_courses + ", price=" + price + ", start_date="
				+ start_date + ", end_date=" + end_date + ", teacher_id=" + teacher_id + ", user_id=" + user_id + "]";
	}


}
