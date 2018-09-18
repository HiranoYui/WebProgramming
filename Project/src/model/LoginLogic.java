package model;

public class LoginLogic {
	public boolean execute(User user) {
		if(user.getPassword().equals("")) {return true;}
		return false;
	}
}
