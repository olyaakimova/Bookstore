package fi.haagehelia.course.domain;

public class Book {
	private String title;
	private String author;
	private int year;
	private String isbn;
	private int price;
	
	public Book(String title, String author, int year, String isbn, int price){
		this.setTitle(title);
		this.setAuthor(author);
		this.setYear(year);
		this.setIsbn(isbn);
		this.setPrice(price);
	}
	
	public Book(){}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString(){
		return title + author + year + isbn + price;
	}
	

}
