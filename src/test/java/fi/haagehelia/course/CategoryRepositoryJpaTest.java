package fi.haagehelia.course;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagehelia.course.domain.Category;
import fi.haagehelia.course.domain.CategoryRepository;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryJpaTest {
	
    private CategoryRepository Crepository;
    @Autowired
	public void setCategoryRepository(CategoryRepository Crepository){
		this.Crepository = Crepository;
	}

    @Test
    public void findCategory() {
        List<Category> category = Crepository.findByName("Comedy");
        assertThat(category).hasSize(1);
    }
    
    @Test
    public void createCategory() {
    	Category category = new Category("Science");
    	Crepository.save(category);
    	assertThat(category.getCategoryId()).isNotNull();
    }    

}
