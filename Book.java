
public class Book {

	private String title;
	private String author;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle(Book book) {
		return book.title;
	}

	public String getAuthor(Book book) {
		return book.author;
	}

	public boolean equals(Object o) {
		boolean answer = false;

		if (o instanceof Book) {
			Book checkBook = (Book) o;

			answer = (title == getTitle(checkBook)) & (author == getAuthor(checkBook));

		}
		return answer;
	}

	public String toString() {

		return "Title: " + this.title + " Author: " + this.author;
	}

	public static void main(String[] args) {
		Book bookA = new Book("Test Book", "Test Author");
		System.out.println(bookA.getTitle(bookA));
		System.out.println(bookA.getAuthor(bookA));
		Book bookB = new Book("Testing", "Test Author");
		System.out.println(bookA.equals(bookB));

	}

}
