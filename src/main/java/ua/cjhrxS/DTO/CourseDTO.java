package ua.cjhrxS.DTO;

import java.time.LocalDate;

public class CourseDTO {
	
	private Long id;
	private String name_courses;
	private Integer price;
	private LocalDate start_date;
	private LocalDate end_date;
	private Long teacher_id;
	private Long user_id;
	
	public CourseDTO() {
		
	}
	
	public CourseDTO(Long id, String name_courses, Integer price, LocalDate start_date, LocalDate end_date,
			Long teacher_id, Long user_id) {
		this.id = id;
		this.name_courses = name_courses;
		this.price = price;
		this.start_date = start_date;
		this.end_date = end_date;
		this.teacher_id = teacher_id;
		this.user_id = user_id;
	}

	
	public Long getId() {
		return id;
	}

	/**
	 * @return the name_courses
	 */
	public String getName_courses() {
		return name_courses;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @param name_courses the name_courses to set
	 */
	public void setName_courses(String name_courses) {
		this.name_courses = name_courses;
	}
	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
	/**
	 * @return the start_date
	 */
	public LocalDate getStart_date() {
		return start_date;
	}
	/**
	 * @param start_date the start_date to set
	 */
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	/**
	 * @return the end_date
	 */
	public LocalDate getEnd_date() {
		return end_date;
	}
	/**
	 * @param end_date the end_date to set
	 */
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	/**
	 * @return the teacher_id
	 */
	public Long getTeacher_id() {
		return teacher_id;
	}
	/**
	 * @param teacher_id the teacher_id to set
	 */
	public void setTeacher_id(Long teacher_id) {
		this.teacher_id = teacher_id;
	}
	/**
	 * @return the user_id
	 */
	public Long getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "CourseDTO [id=" + id + ", name_courses=" + name_courses + ", price=" + price + ", start_date="
				+ start_date + ", end_date=" + end_date + ", teacher_id=" + teacher_id + ", user_id=" + user_id + "]";
	}

	
	
	
}
