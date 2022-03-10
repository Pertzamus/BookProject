package Projekti.Bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


import Projekti.Bookstore.domain.Book;
import Projekti.Bookstore.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void FindByAuthorShouldReturnAuthor () {
		List<Book> books = bookRepository.findByAuthor("Hennig Mankell");
		assertThat(books.get(0).getAuthor()).isEqualTo("Hennig Mankell");		
	}
	
	@Test
	public void findByAuthorShouldReturnSize() {
		List<Book> books = bookRepository.findByAuthor("Hennig Mankell");
		assertThat(books).hasSize(3);
	}
	
	@Test
	public void insertNewBook() {
		Book book = new Book("Kauhukakara", "SuperNanny", 2020);
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
		
	}
}
