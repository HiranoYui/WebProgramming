package model;
import java.io.Serializable;

public class Users implements Serializable{
	private String userName;
	private String password;

	public Users() {}
	public Users(String userName,String password) {
		this.userName=userName;
		this.password=password;
	}
	public String getUserName() {return userName;}
	public String getPassword() {return password;}



}
