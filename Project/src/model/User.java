package model;
import java.util.Date;

public class User {
	private String id;
	private String loginId;
	private String name;
	private Date birthDate;
	private String password;
	private String pwc;
	private String createDate;
	private String updateDate;

	public User(String loginId,String name) {
		this.loginId=loginId;
		this.name=name;
	}
	public User(String id,String loginId,String name,Date birthDate,String password,String createDate,String updateDate) {
		this.id=id;
		this.loginId=loginId;
		this.name=name;
		this.birthDate=birthDate;
		this.password=password;
		this.createDate=createDate;
		this.updateDate=updateDate;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {

		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getPwc() {
		return pwc;
	}
	public void setPwc(String pwc) {
		this.pwc = pwc;
	}





}













