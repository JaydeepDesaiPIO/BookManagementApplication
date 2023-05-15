package com.spring.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookManagementSystemApplication /*implements CommandLineRunner*/
{
	public static void main(String[] args) {
		SpringApplication.run(BookManagementSystemApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// Inserting the data in the mysql table.
//		Books b=new Books();
//		b.setId(1);
//		b.setAuthor("john");
//		b.setBookName("Horror Stories");
//		bookRepo.save(b);
//	}

}
