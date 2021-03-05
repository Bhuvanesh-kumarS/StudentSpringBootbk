package guru.springframework.commands;

import java.sql.Date;

/**
 * Created by Bhuvaneshkumar on 24/02/2021.
 */

public class StudentForm {
	private Long id;
	private int rollNo;
	private String name;
	 private String email;
	    private String password;
	    private Date createdDate;
	    private Date lastLoginDate;

	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public int getRollNo() {
			return rollNo;
		}
		public void setRollNo(int rollNo) {
			this.rollNo = rollNo;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Date getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}
		public Date getLastLoginDate() {
			return lastLoginDate;
		}
		public void setLastLoginDate(Date lastLoginDate) {
			this.lastLoginDate = lastLoginDate;
    }
}
