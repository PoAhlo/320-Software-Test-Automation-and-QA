package contact_service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ContactServiceTest {
	
	private ContactService serv;
	
	@BeforeEach
	void setUp() {
		serv = new ContactService();
		Contact add1 = new Contact("01", "FN", "LN", "1234567890", "A");
		Contact add2 = new Contact("02", "FN", "LN", "1234567890", "A");
		Contact add3 = new Contact("03", "FN", "LN", "1234567890", "A");
		serv.addContact(add1);
		serv.addContact(add2);
		serv.addContact(add3);
	}
	
	@Test
	void testAddedValidID() {
		assertEquals(3, serv.getContacts().size());
	}
	
	@Test
	void testAddedInvalidID() {
		Contact invalid = new Contact("01", "First", "Last", "1234567890", "A");
		Assertions.assertThrows(RuntimeException.class, () -> {
			serv.addContact(invalid);
		});
	}
	
	@Test
	void testDeleteValidID() {
		serv.deleteContact("02");
		assertEquals(2, serv.getContacts().size());
	}
	
	@Test
	void testDeleteInvalidID() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			serv.deleteContact("invalid");
		});
	}

	@Test
	void testValidFirstNameUpdate() {
		serv.updateFirstName("01", "FirstName");
		assertEquals("FirstName", serv.getContacts().get(0).getFirstName());
	}
	
	@Test
	void testInvalidFirstNameUpdate() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			serv.updateFirstName("", "FirstName");
		});
	}
	
	@Test
	void testValidLastNameUpdate() {
		serv.updateLastName("01", "LastName");
		assertEquals("LastName", serv.getContacts().get(0).getLastName());
	}
	
	@Test
	void testInvalidLastNameUpdate() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			serv.updateLastName("invalid", "LastName");
		});
	}
	
	@Test
	void testValidPhoneUpdate() {
		serv.updatePhone("02", "0987654321");
		assertEquals("0987654321", serv.getContacts().get(1).getPhone());
	}
	
	@Test
	void testInvalidPhoneUpdate() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			serv.updatePhone("04", "0987654321");
		});
	}
	
	@Test
	void testValidAddresUpdate() {
		serv.updateAddress("03", "Address");
		assertEquals("Address", serv.getContacts().get(2).getAddress());
	}
	
	@Test
	void testInvalidAddressUpdate() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			serv.updateAddress(null, "Address");
		});
	}
}
