package Projekti.Bookstore;

import org.springframework.data.repository.CrudRepository;

import Projekti.Bookstore.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
