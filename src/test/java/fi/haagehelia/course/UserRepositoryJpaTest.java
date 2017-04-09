package fi.haagehelia.course;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import fi.haagehelia.course.domain.User;
import fi.haagehelia.course.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

public class UserRepositoryJpaTest {
	
	private UserRepository Urepository;
	
	@Autowired
	public void setUserRepository(UserRepository Urepository){
		this.Urepository = Urepository;
	}
	
	
	//create
	@Test
	public void createNewUser(){
		User user = new User("user", "$2a$05$gCvlf2Q4A5qD7BvcJdbX4u3zmEj287tFzizBgtgFJFMNimzNrEw2a", "USER");
    	if (Urepository.findByUsername(user.getUsername()) == null) { // Check if user exists
    		Urepository.save(user);
    		assertThat(user.getId()).isNotNull();
    	}
    	else assertNull(user.getId());
		
	}
	
	/*//delete
	@Test
	public void deleteUser(){
		
	}*/
	
	//user log in validation successful
	public void validateUser(){
		User user = new User("user", "$2a$05$gCvlf2Q4A5qD7BvcJdbX4u3zmEj287tFzizBgtgFJFMNimzNrEw2a", "USER");
		Urepository.save(user);
		String username = "user";
		User curruser = Urepository.findByUsername(username);
		assertNotNull(curruser.getUsername());
	}
	
}
