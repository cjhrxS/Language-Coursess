package ua.cjhrxS.DTO;

import java.util.ArrayList;
import java.util.List;

public class UserCourseDTO {

	private final int DEFAULT_PAGE_OFFSET = 10;
	//
	private String userName;
	private List<CourseDTO> courses;
	private int pageCount;
	private int pageOffset;

	public UserCourseDTO(String userName) {
		this.userName = userName;
		this.courses = new ArrayList<>();
		this.pageCount = courses.size() / DEFAULT_PAGE_OFFSET + 1;
		this.pageOffset = DEFAULT_PAGE_OFFSET;
	}

	public UserCourseDTO(String userName, List<CourseDTO> courses) {
		this.userName = userName;
		this.courses = courses;
		this.pageCount = courses.size() / DEFAULT_PAGE_OFFSET + 1;
		this.pageOffset = DEFAULT_PAGE_OFFSET;
	}
	
	//Setters

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setCourses(List<CourseDTO> courses) {
		this.courses = courses;
	}

	public void addCourseDTO(CourseDTO course) {

		courses.add(course);

	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
	
	//Getters


	public String getUserName() {
		return userName;
	}


	public List<CourseDTO> getCourses() {
		return courses;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getPageOffset() {
		return pageOffset;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserCourseDTO [userName=" + userName + ", courses=" + courses + ", pageCount=" + pageCount
				+ ", pageOffset=" + pageOffset + "]";
	}
	
	
	
	
	
	

}
