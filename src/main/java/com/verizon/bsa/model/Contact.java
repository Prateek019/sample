package com.verizon.bsa.model;

public class Contact {
	private int contactID;
	private String contactName;
	private String contactNumber;
	public int getContactID() {
		return contactID;
	}
	public void setContactID(int contactID) {
		this.contactID = contactID;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Contact(int contactID, String contactName, String contactNumber) {
		super();
		this.contactID = contactID;
		this.contactName = contactName;
		this.contactNumber = contactNumber;
	}
	public Contact() {
		
	}
	
}
