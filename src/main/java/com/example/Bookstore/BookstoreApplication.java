package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			crepository.deleteAll();
			crepository.save(new Category("Drama"));
			crepository.save(new Category("Crime"));
			crepository.save(new Category("Children's"));
			
			Book b1 = new Book("Satukirja", "Sinikka Nopola", "2002", "0010090-0", "19,99", crepository.findByName("Children's").get(0));
			Book b2 = new Book("Komisario Palmu", "Mika Waltari", "1940", "0020080-0", "9,99", crepository.findByName("Crime").get(0));

			repository.save(b1);
			repository.save(b2);
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@hotmail.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@hotmail.com", "ADMIN");
			urepository.deleteAll();
			urepository.save(user1);
			urepository.save(user2);
		};
	}
}