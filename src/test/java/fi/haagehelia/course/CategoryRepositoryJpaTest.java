package fi.haagehelia.course;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagehelia.course.domain.Book;
import fi.haagehelia.course.domain.Category;
import fi.haagehelia.course.domain.CategoryRepository;

@RunWith(SpringRunner.class)
public class CategoryRepositoryJpaTest {
private CategoryRepository Crepository;
	
	@Autowired
	public void setCategoryRepository(CategoryRepository Crepository){
		this.Crepository = Crepository;
	}

//create
	@Test
	public void createCategory(){
		//create a book object
		Category category = new Category("science");
		//check that it is not in repository yet
		assertNull(category.getCategoryId());
		//save book object to repository
		Crepository.save(category);
		//check that now this book is in repository
		assertNotNull(category.getCategoryId());
	}
}