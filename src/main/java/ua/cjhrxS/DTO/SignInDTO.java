package ua.cjhrxS.DTO;

public class SignInDTO {
	
	private String user_name;
	private String pass_word;
	
	
	public SignInDTO(String user_name, String pass_word) {
		this.user_name = user_name;
		this.pass_word = pass_word;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return pass_word;
	}
	public void setPassword(String pass_word) {
		this.pass_word = pass_word;
	}

	@Override
	public String toString() {
		return "SignInDTO [user_name=" + user_name + ", pass_word=" + pass_word + "]";
	}
	
	

}
