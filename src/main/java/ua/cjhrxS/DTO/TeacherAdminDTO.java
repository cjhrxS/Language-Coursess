package ua.cjhrxS.DTO;

import java.util.ArrayList;
import java.util.List;

public class TeacherAdminDTO {
	
private final int DEFAULT_PAGE_OFFSET = 10;
	
    
	private List<TeacherDTO> teachers;
	private int pageCount;
	private int pageOffset;
	
	public TeacherAdminDTO() {
		
		this.teachers = new ArrayList<TeacherDTO>();
		this.pageCount = teachers.size() / DEFAULT_PAGE_OFFSET + 1;
		this.pageOffset = DEFAULT_PAGE_OFFSET;
	}

	public TeacherAdminDTO(List<TeacherDTO> teachers, int pageCount, int pageOffset) {
		this.teachers = teachers;
		this.pageCount = teachers.size() / DEFAULT_PAGE_OFFSET + 1;
		this.pageOffset = DEFAULT_PAGE_OFFSET;
	}
	//Setters

	public void setTeachers(List<TeacherDTO> teachers) {
		this.teachers = teachers;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
	
	public void setAddTeacherDto(TeacherDTO teacherDTO) {
		
		teachers.add(teacherDTO);
		
	}
	
	//getters
	

	public List<TeacherDTO> getTeachers() {
		return teachers;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	@Override
	public String toString() {
		return "TeacherAdminDTO [teachers=" + teachers + ", pageCount=" + pageCount + ", pageOffset=" + pageOffset
				+ "]";
	}

	
	


	
	
	
	
	

}
