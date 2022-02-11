package Projekti.Bookstore;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Projekti.Bookstore.domain.Book;
import Projekti.Bookstore.domain.BookRepository;
import Projekti.Bookstore.domain.Category;
import Projekti.Bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner bookstore(BookRepository bookRepo, CategoryRepository categoryRepo) {
//		return (args) -> {
//			
//			categoryRepo.save(new Category("Dokkarit"));
//			categoryRepo.save(new Category("Dekkarit"));
//			categoryRepo.save(new Category("Pokkarit"));
//			
//			bookRepo.save(new Book("Kasvoton kuolema", "Hennig Mankell", 2002, 12, 1,
//			categoryRepo.findByName("Dekkarit").get(0)));
//			bookRepo.save(new Book("Riian verikoirat", "Hennig Mankell", 2003, 13, 1,
//			categoryRepo.findByName("Dekkarit").get(0)));
//			bookRepo.save(new Book("Koira", "Nina Mäki-Kihniä", 2004, 12, 5,
//			categoryRepo.findByName("Dokkarit").get(0)));
//			
//			System.out.println("fecth all books from the database");
//			for (Book book : bookRepo.findAll()) {
//				System.out.println("kirja: " + book.toString());
//			}
//		};
//	}

}
