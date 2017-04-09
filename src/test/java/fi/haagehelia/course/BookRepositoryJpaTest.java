package fi.haagehelia.course;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagehelia.course.domain.Book;
import fi.haagehelia.course.domain.BookRepository;
import fi.haagehelia.course.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryJpaTest {
private BookRepository Brepository;
	
	@Autowired
	public void setBookRepository(BookRepository Brepository){
		this.Brepository = Brepository;
	}
	
	//add book
	@Test
	public void addBook(){
		//create a book object
		Book book = new Book("title", "author", 2017,"isbn123",100, new Category("science"));
		//check that it is not in repository yet
		assertNull(book.getId());
		//save book object to repository
		Brepository.save(book);
		//check that now this book is in repository
		assertNotNull(book.getId());
	}
	
	//search book
	@Test
	public void searchBook(){
		Book book = new Book("title", "author", 2017,"isbn123",100, new Category("science"));
		Brepository.save(book);
		Book findBook = Brepository.findOne(book.getId());
		assertNotNull(findBook);
	}
	
	//delete book
	@Test
	//@WithMockUser(roles={"ADMIN"})
	public void deleteBook(){
		//first create
		Book book = new Book("title", "author", 2017,"isbn123",100, new Category("science"));
		Brepository.save(book);
		//make sure it is there
		Book findBook = Brepository.findOne(book.getId());
		assertNotNull(findBook);
		//delete
		Brepository.delete(book.getId());
		//make sure there is no book anymore
		findBook = Brepository.findOne(book.getId());
		assertNull(findBook);
		
	}
}
