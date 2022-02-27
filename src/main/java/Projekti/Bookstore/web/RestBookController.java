package Projekti.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Projekti.Bookstore.domain.Book;
import Projekti.Bookstore.domain.BookRepository;

@RestController
public class RestBookController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("books")
	Iterable<Book> getAll() {
		return bookRepository.findAll();
	}
	
	@PostMapping("books")
	Book newBook(@RequestBody Book newBook) {
		return bookRepository.save(newBook);
	}
	
	@PutMapping("/books/{id}")
	Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {
		newBook.setId(id);
		return bookRepository.save(newBook);
	}
	
	@DeleteMapping("/books/{id}")
	void deleteBook(@PathVariable Long id) {
		bookRepository.deleteById(id);
	}
}
