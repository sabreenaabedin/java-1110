// Sabreena Abedin (Sa7cx) lab 102

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PersonTest {

	@Test(timeout = 100)
	public void testAddBook1() {
		Person p = new Person("Alex", 14); // Create a person
		Book b = new Book("some title", "some author"); // Create a Book
		assertTrue(p.addBook(b)); // Does addBook() return true?
		ArrayList<Book> readList = p.getRead(); // Get Person p's ArrayList of
												// Books (read)
		assertTrue(readList.contains(b)); // Is Book b contained in this
											// ArrayList?
	}

	@Test(timeout = 100)
	public void testAdd2Books() {
		Person p = new Person("Alex", 14); // Create a person
		Book b = new Book("some title", "some author"); // Create a Book
		Book b2 = new Book("different title", "different author"); // Create a
																	// Book
		assertTrue(p.addBook(b));
		assertTrue(p.addBook(b2));
		ArrayList<Book> readList = p.getRead(); // Get Person p's ArrayList
		assertTrue(readList.contains(b));
		assertTrue(readList.contains(b2));
	}

	@Test(timeout = 100)
	public void testAddSameBook() {
		Person p = new Person("Alex", 14); // Create a person
		Book b = new Book("some title", "some author"); // Create a Book
		Book b2 = new Book("some title", "some author");

		assertTrue(p.addBook(b));
		assertFalse(p.addBook(b2));

		ArrayList<Book> readList = p.getRead(); // Get Person p's ArrayList
		assertTrue(readList.size() == 1);

	}
	
	@Test(timeout = 100)
	public void testForgetBook() {
		Person p = new Person("Alex", 14); // Create a person
		Book b = new Book("some title", "some author"); // Create a Book
		Book b2 = new Book("some title", "some author");
		p.addBook(b);
		assertTrue(p.forgetBook(b));
	}

	@Test(timeout = 100)
	public void testForgetWrongBook() {
		Person p = new Person("Alex", 14); // Create a person
		Book b = new Book("some title", "some author"); // Create a Book
		Book b2 = new Book("different title", "different author");
		p.addBook(b);
		assertFalse(p.forgetBook(b2));
	}
	
	@Test(timeout = 100)
	public void testBookRemoved() {
		Person p = new Person("Alex", 14); // Create a person
		Book b = new Book("some title", "some author"); // Create a Book
		Book b2 = new Book("different title", "different author");
		p.addBook(b);
		p.addBook(b2);
		p.forgetBook(b2);
		ArrayList<Book> readList = p.getRead(); // Get Person p's ArrayList
		assertTrue(readList.size() == 1);
	}
	
}
