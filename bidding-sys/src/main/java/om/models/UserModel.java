package om.models;


import om.entities.User;

public class UserModel {

	private int id;	
	private String name;
	private String email;
	private String contact;
	

	public UserModel() { }
	
	public UserModel(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	
	
}
