package fi.haagehelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import fi.haagehelia.course.domain.Book;
import fi.haagehelia.course.domain.BookRepository;
import fi.haagehelia.course.domain.Category;
import fi.haagehelia.course.domain.CategoryRepository;
import fi.haagehelia.course.domain.User;
import fi.haagehelia.course.domain.UserRepository;
import fi.haagehelia.course.BookstoreApplication;

@SpringBootApplication
public class BookstoreApplication  extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder
	application) {
	return application.sources(BookstoreApplication.class);
	}
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository Crepository, UserRepository Urepository) {
		return (args) -> {
			
	
			log.info("save some book examples");
			
			Crepository.save(new Category("Novel"));
			Crepository.save(new Category("Drama"));
			Crepository.save(new Category("Comedy"));
			Crepository.save(new Category("Fiction"));
			Crepository.save(new Category("Detective"));
			
			
			repository.save(new Book("Rasor's edge", "Somerset Maugham",  1944, "123-456", 40,  Crepository.findByName("Novel").get(0)));
			repository.save(new Book("Drei Kameraden", "Erich Maria Remarque", 1936, "765-5432", 7, Crepository.findByName("Drama").get(0)));
			
			//adding some primary users
			User user1 = new User("user", "$2a$05$nydhuDIcWXa0c8ItFgUNRO6YwFAQOaFbj6bmU4wptsRrays0ivzG6", "USER");
			User user2 = new User("admin", "$2a$05$nydhuDIcWXa0c8ItFgUNRO6YwFAQOaFbj6bmU4wptsRrays0ivzG6", "ADMIN");
			Urepository.save(user1);
			Urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
