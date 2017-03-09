package fi.haagehelia.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fi.haagehelia.course.domain.Book;
import fi.haagehelia.course.domain.BookRepository;
import fi.haagehelia.course.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
    private BookRepository repository;
   
	@Autowired
	private CategoryRepository Crepository;
    
/*	@ModelAttribute
    public Book newRequest(@RequestParam(required=false) Long id) {
        return (id != null ? repository.findOne(id) : new Book());
    }
	*/
	
	//show all books
    @RequestMapping(value="/booklist", method = RequestMethod.GET)
    public String bookList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
  
    //add new book
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", Crepository.findAll());
        return "addbook";
    }     
    
    //save new book
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }    

    //delete book
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.delete(bookId);
        return "redirect:../booklist";
    }    
    }