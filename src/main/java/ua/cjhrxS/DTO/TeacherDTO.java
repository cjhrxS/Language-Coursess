package ua.cjhrxS.DTO;

public class TeacherDTO {
	
	private Long id;
	private String first_name;
	private String last_name;
	private Long expierence;
	
	public TeacherDTO(Long id, String first_name, String last_name, Long expierence) {
	
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.expierence = expierence;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the expierence
	 */
	public Long getExpierence() {
		return expierence;
	}

	/**
	 * @param expierence the expierence to set
	 */
	public void setExpierence(Long expierence) {
		this.expierence = expierence;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TeacherDTO [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", expierence="
				+ expierence + "]";
	}
	
	

	

}
