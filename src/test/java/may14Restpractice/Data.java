package may14Restpractice;

import java.util.List;

public class Data 
	{
		Integer id;
		String email;
		String first_name;
		String last_name;
		String avatar;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFirst_name() {
			return first_name;
		}
		public List<Data> setFirst_name(String first_name) {
			this.first_name = first_name;
			return null;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public String getAvatar() {
			return avatar;
		}
		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}
		
	}
