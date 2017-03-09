package fi.haagehelia.course.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>
{
	//List<Book> FindAll();
	List<Book> findByTitle(String title);
}