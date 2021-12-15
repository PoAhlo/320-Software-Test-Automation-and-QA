package contact_service;

public class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// constructor
	public Contact(String contactID, String firstName, String lastName, String phone, String address) { 
		if (contactID == null || contactID.length() > 10)
			throw new IllegalArgumentException("Invalid Contact ID");
		if (firstName == null || firstName.length() > 10)
			throw new IllegalArgumentException("Invalid First Name");
		if (lastName == null || lastName.length() > 10)
			throw new IllegalArgumentException("Invalid Last Name");
		if (phone == null || phone.length() != 10)
			throw new IllegalArgumentException("Invalid Phone Number");
		if (address == null || address.length() > 30)
			throw new IllegalArgumentException("Invalid Address");
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// getter functions
	
	public String getContactID() {
		return this.contactID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	// setter functions
	
	// the id cannot be changed - there is no setter for contactID
	
	public void setFirstName(String updatedFirstName) {
		if (updatedFirstName == null || updatedFirstName.length() > 10)
			throw new IllegalArgumentException("Invalid First Name");
		this.firstName = updatedFirstName;
	}
	
	public void setLastName(String updatedLastName) {
		if (updatedLastName == null || updatedLastName.length() > 10)
			throw new IllegalArgumentException("Invalid Last Name");
		this.lastName = updatedLastName;
	}
	
	public void setPhone(String updatedPhone) {
		if (updatedPhone == null || updatedPhone.length() != 10)
			throw new IllegalArgumentException("Invalid Phone Number");
		this.phone = updatedPhone;
	}
	
	public void setAddress(String updatedAddress) {
		if (updatedAddress == null || updatedAddress.length() > 30)
			throw new IllegalArgumentException("Invalid Address");
		this.address = updatedAddress;
	}
	
}
