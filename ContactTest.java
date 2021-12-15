package contact_service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.BeforeEach;

class ContactTest {

	@Test
	void testContactValid() {
		Contact testContact = new Contact("ID", "FirstName", "", "1234567890", "Address");
		assertEquals("ID", testContact.getContactID());
		assertEquals("FirstName", testContact.getFirstName());
		assertEquals("", testContact.getLastName());
		assertEquals("1234567890", testContact.getPhone());
		assertEquals("Address", testContact.getAddress());
	}

	@Test
	void testConctactIdInvalid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "FirstName", "LastName", "1234567890", "Address");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "FirstName", "LastName", "1234567890", "Address");
		});
	}
	
	@Test
	void testContactFirstNameInvalid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("ID", null, "LastName", "1234567890", "Address");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("ID", "12345678901", "LastName", "1234567890", "Address");
		});
	}
	
	@Test
	void testContactLastNameInvalid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("ID", "FirstName", null, "1234567890", "Address");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("ID", "FirstName", "12345678901", "1234567890", "Address");
		});
	}
	
	@Test
	void testContactPhoneInvalid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("ID", "FirstName", "LastName", null, "Address");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("ID", "FirstName", "LastName", "12345678901", "Address");
		});
	}
	
	@Test
	void testContactAddressInvalid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("ID", "FirstName", "LastName", "1234567890", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("ID", "FirstName", "LastName", "1234567890", "1234567890123456789012345678901");
		});
	}
	
	@Nested
	class testSetters {
		
		private Contact toTest;
		
		@BeforeEach
		void setUpSetters() {
			toTest = new Contact("ID", "FirstName", "LastName", "1234567890", "Address");
		}
		
		@Test
		void testValidFirstNameSet() {
			toTest.setFirstName("FN");
			assertEquals("FN", toTest.getFirstName());
		}
		
		@Test
		void testInvalidFirstNameSet() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				toTest.setFirstName(null);
			});
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				toTest.setFirstName("12345678901");
			});
		}
		
		@Test
		void testValidLastNameSet() {
			toTest.setLastName("LN");
			assertEquals("LN", toTest.getLastName());
		}
		
		@Test
		void testInvalidLastNameSet() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				toTest.setLastName(null);
			});
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				toTest.setLastName("12345678901");
			});
		}
		
		@Test
		void testValidPhoneSet() {
			toTest.setPhone("9876543210");
			assertEquals("9876543210", toTest.getPhone());
		}
		
		@Test
		void testInvalidPhoneSet() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				toTest.setPhone(null);
			});
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				toTest.setPhone("too short");
			});
		}
		
		@Test
		void testValidAddressSet() {
			toTest.setAddress("A");
			assertEquals("A", toTest.getAddress());
		}
		
		@Test
		void testInvalidAddressSet() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				toTest.setAddress(null);
			});
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				toTest.setAddress("1234567890123456789012345678901");
			});
		}
	}
	
}
