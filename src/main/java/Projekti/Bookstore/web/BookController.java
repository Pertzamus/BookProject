package Projekti.Bookstore.web;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Projekti.Bookstore.domain.Book;
import Projekti.Bookstore.domain.BookRepository;



@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(value= {"/", "/booklist"})
	public String bookList(Model model) {
		model.addAttribute("books", bookRepository.findAll());	
	return "booklist";
	}
	
    @RequestMapping(value = "/newBook")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "newBook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	@RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long BookId, Model model) {
		bookRepository.deleteById(BookId);
		return "redirect:/booklist";
	}
	
}
