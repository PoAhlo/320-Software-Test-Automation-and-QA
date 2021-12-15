package contact_service;

import java.util.ArrayList;

public class ContactService {
	
	// List to hold all the contacts
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	// Default constructor has a list with nothing in it
	public ContactService() {
	}
	
	// getter function
	public ArrayList<Contact> getContacts(){
		return contacts;
	}
	
	// adds a contact with a unique id
	public void addContact(Contact toAdd) {
		for (Contact c : contacts) {
			if (c.getContactID() == toAdd.getContactID())
				throw new RuntimeException("ID is not unique");
		}
		contacts.add(toAdd);
	}
	
	// delete a contact using contact id
	public void deleteContact(String idToDelete) {
		boolean deleteSuccessful = false;
		for (Contact c : contacts) {
			if (c.getContactID() == idToDelete) {
				deleteSuccessful = true;
				contacts.remove(c);
				break;
			}
		}
		if (!deleteSuccessful)
			throw new RuntimeException("Nothing deleted");
	}
	
	// update first name
	public void updateFirstName(String id, String newFirstName) {
		Boolean idValid = false;
		for (Contact c : contacts) {
			if(c.getContactID() == id) {
				idValid = true;
				c.setFirstName(newFirstName);
			}
		}
		if (!idValid)
			throw new RuntimeException("ID invalid, nothing updated");
	}
	
	// update last name
	public void updateLastName(String id, String newLastName) {
		Boolean idValid = false;
		for (Contact c : contacts) {
			if(c.getContactID() == id) {
				idValid = true;
				c.setLastName(newLastName);
			}
		}
		if (!idValid)
			throw new RuntimeException("ID invalid, nothing updated");
	}
	
	// update phone number
	public void updatePhone(String id, String newPhone) {
		Boolean idValid = false;
		for (Contact c : contacts) {
			if(c.getContactID() == id) {
				idValid = true;
				c.setPhone(newPhone);
			}
		}
		if (!idValid)
			throw new RuntimeException("ID invalid, nothing updated");
	}
	
	// update address
	public void updateAddress(String id, String newAddress) {
		Boolean idValid = false;
		for (Contact c : contacts) {
			if(c.getContactID() == id) {
				idValid = true;
				c.setAddress(newAddress);
			}
		}
		if (!idValid)
			throw new RuntimeException("ID invalid, nothing updated");
	}
	
}
