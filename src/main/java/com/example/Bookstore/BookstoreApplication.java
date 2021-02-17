package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			
			crepository.save(new Category("Drama"));
			crepository.save(new Category("Crime"));
			crepository.save(new Category("Children's"));
			
			Book b1 = new Book("Satukirja", "Sinikka Nopola", "2002", "0010090-0", "19,99", crepository.findByName("Children's").get(0));
			Book b2 = new Book("Komisario Palmu", "Mika Waltari", "1940", "0020080-0", "9,99", crepository.findByName("Crime").get(0));

			repository.save(b1);
			repository.save(b2);
			
		};
	}
}
