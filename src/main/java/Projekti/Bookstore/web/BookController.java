package Projekti.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Projekti.Bookstore.domain.Book;
import Projekti.Bookstore.domain.BookRepository;
import Projekti.Bookstore.domain.CategoryRepository;



@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	@RequestMapping(value= {"/", "/booklist"})
	public String bookList(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		model.addAttribute("categories", categoryRepository.findAll());
	return "booklist";
	}
	
    @RequestMapping(value = "/newBook")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", categoryRepository.findAll());
        return "newBook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	@RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteBook(@PathVariable("id") Long BookId, Model model) {
		bookRepository.deleteById(BookId);
		return "redirect:/booklist";
	}
	
    @RequestMapping(value = "/editBook/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editBook(@PathVariable("id") Long BookId, Model model) {
    	model.addAttribute("book", bookRepository.findById(BookId));
    	model.addAttribute("categories", categoryRepository.findAll());
    	return "editBook";
    }
}
