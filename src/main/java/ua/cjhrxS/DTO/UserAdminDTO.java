package ua.cjhrxS.DTO;

import java.util.ArrayList;
import java.util.List;

public class UserAdminDTO {
	
	private final int DEFAULT_PAGE_OFFSET = 10;
	
	private List<UserDTO> users;
	private int pageCount;
	private int pageOffset;
	
	public UserAdminDTO() {
		
		this.users = new ArrayList<UserDTO>();
		this.pageCount = users.size() / DEFAULT_PAGE_OFFSET + 1;
		this.pageOffset = DEFAULT_PAGE_OFFSET;
	}
	
	
	public UserAdminDTO(List<UserDTO> users, int pageCount, int pageOffset) {
		
		
		this.users = users;
		this.pageCount = users.size() / DEFAULT_PAGE_OFFSET + 1;
		this.pageOffset = DEFAULT_PAGE_OFFSET;
	}
	
	//setters
	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
	
	public void setAddUserDto(UserDTO userDTO) {
		
		users.add(userDTO);
	}

	//getters
	public List<UserDTO> getUsers() {
		return users;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	@Override
	public String toString() {
		return "UserAdminDTO [users=" + users + ", pageCount=" + pageCount + ", pageOffset=" + pageOffset + "]";
	}
	
	
	
	
	
	
	
	
	

}
