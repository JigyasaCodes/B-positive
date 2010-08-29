package com.barefoot.bpositive.models;


public class Donor {
	
	private String firstName;
	private String lastName;
	private String birthDate;
	private String bloodGroup;
	private int id;

	public Donor(int id, String firstName, String lastName, String birthDate, String bloodGroup) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.bloodGroup = bloodGroup;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getBirthDate() {
		return this.birthDate;
	}
	public String getBloodGroup() {
		return this.bloodGroup;
	}
	
	public int getAge()  {
		return 0;
	}
	
	@Override
	public String toString() {
		StringBuilder donor = new StringBuilder("Donor First Name:");
		donor.append(getFirstName());
		donor.append(" ");
		donor.append("Last Name:");
		donor.append(getLastName());
		donor.append(" ");
		donor.append("Birth Date:");
		donor.append(getBirthDate());
		donor.append(" ");
		donor.append("Blood Group");
		donor.append(getBloodGroup());
		return donor.toString();
	}

}
