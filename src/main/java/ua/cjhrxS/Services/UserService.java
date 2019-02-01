package ua.cjhrxS.Services;

import ua.cjhrxS.Converter.Convetor;
import ua.cjhrxS.DAO.UsersDao;
import ua.cjhrxS.DTO.CourseDTO;
import ua.cjhrxS.DTO.SignInDTO;
import ua.cjhrxS.DTO.SignUpDTO;
import ua.cjhrxS.DTO.UserAdminDTO;
import ua.cjhrxS.DTO.UserCourseDTO;
import ua.cjhrxS.DTO.UserDTO;
import ua.cjhrxS.Entity.CourseEntity;
import ua.cjhrxS.Entity.UsersEntity;

public class UserService {
	
	private UsersDao userDao;
	
	public UserService() {
		this.userDao = new UsersDao();
	}

	public UserService(UsersDao userDao) {
		
		this.userDao = userDao;
	}
	
	public UserDTO getUserByName(String username) {
		
UsersEntity userEntity = userDao.getUserEntityByLogin(username);
		
		return new UserDTO(userEntity.getId(), 
						   userEntity.getFirst_name(), 
						   userEntity.getLast_name(), 
						   userEntity.getUser_name(), 
						   userEntity.getPass_word(), 
						   userEntity.getRoles_id());
		
	}
	
	public UserDTO getUserDTO(SignInDTO signInDTO) {
		
		UsersEntity userEntity = userDao.getUserEntityByLogin(signInDTO.getUser_name());
		
		return new UserDTO(userEntity.getId(), 
						   userEntity.getFirst_name(), 
						   userEntity.getLast_name(), 
						   userEntity.getUser_name(), 
						   userEntity.getPass_word(), 
						   userEntity.getRoles_id());
	}
	
	public UserDTO getUserDtoById(Long id) {
		
		UsersEntity userEntity = userDao.getById(id);
		return new UserDTO(userEntity.getId(), 
						   userEntity.getFirst_name(), 
						   userEntity.getLast_name(), 
						   userEntity.getUser_name(), 
						   userEntity.getPass_word(), 
						   userEntity.getRoles_id());
		
		
	}
	
	public boolean setUserDto(UserDTO userDto) {
		boolean result = false;
		UsersEntity userEntity = new UsersEntity(userDto.getId(), 
				   userDto.getFirst_name(), 
				   userDto.getLast_name(), 
				   userDto.getUser_name(), 
				   userDto.getPass_word(), 
				   userDto.getRoles_id());
		if (userDto.getId() > 0) {
			if (isExistUser(userEntity.getId())) {
				userDao.updateByEntity(userEntity);
				result = true;
			}
		} else {
			userDao.insert(userEntity);
			result = true;
		}
		return result;
	}
	
	/*
	 * transform DTO in Entity and insert it in DataBase
	 */
	public boolean setSignUpDto(SignUpDTO signUp){
		
		boolean result = false;
		
		UsersEntity user = new UsersEntity(0L, signUp.getFirst_name(), signUp.getLast_name(), signUp.getUser_name(), signUp.getPass_word(), signUp.getIdRole());
		userDao.insert(user);
		return result;
	}
	
	public boolean isExistUser(long id) {
		boolean result = true;
		try {
			userDao.getById(id);
		} catch (RuntimeException e) {
			// Logging Exception
			System.out.println("User not found, message: " + e.getMessage());
			result = false;
		}
		return result;
	}
	
	public boolean deleteUserById(long id) {
		boolean result = true;
		try {
			result = result && userDao.deleteById(id);
		} catch (RuntimeException e) {
			// Logging Exception
			result = false;
		}
		return result;
	}
	
	public boolean isValid(SignInDTO signInDto) {
		boolean result = true;
		UsersEntity userEntity = null;
		try {
			userEntity = userDao.getUserEntityByLogin(signInDto.getUser_name());
			
		} catch (Exception e) {
			
			System.out.println("User with user_name: "+ signInDto.getUser_name() + " is not exists ");
			result = false;
			
		}
		
		result = result && (userEntity.getPass_word().equals(signInDto.getPassword()));
		return result;
	}
	
	public UserAdminDTO getAdminUser(UserDTO userDto) {
		UsersEntity user = userDao.getUserEntityByLogin(userDto.getUser_name());
		UserAdminDTO userAdminDTO = new UserAdminDTO();
		
		for (UsersEntity users : userDao.getAll()) {
			UserDTO userDTO = new UserDTO(users.getId(), 
							  users.getFirst_name(),
							  users.getLast_name(), 
							  users.getUser_name(), 
							  users.getPass_word(), 
							  users.getRoles_id());
			userAdminDTO.setAddUserDto(userDTO);
		}
		return userAdminDTO;
	}
	
	

}
