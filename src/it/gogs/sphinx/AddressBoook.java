package it.gogs.sphinx;

import java.sql.Date;

public class AddressBoook {

	private String Alias;
	private String Email;
	private String FName;
	private String LName;
	private String Location;
	private String PhoneNo;
	private String Title;
	private Date DOJ;
	private long Id;

	public String getAlias() {
		return Alias;
	}

	public void setAlias(String alias) {
		Alias = alias;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFName() {
		return FName;
	}

	public void setFName(String fName) {
		FName = fName;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Date getDOJ() {
		return DOJ;
	}

	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	@Override
	public String toString() {
		return "AddressBoook [Alias=" + Alias + ", Email=" + Email + ", FName="
				+ FName + ", LName=" + LName + ", Location=" + Location
				+ ", PhoneNo=" + PhoneNo + ", Title=" + Title + ", DOJ=" + DOJ
				+ ", Id=" + Id + "]";
	}

}
