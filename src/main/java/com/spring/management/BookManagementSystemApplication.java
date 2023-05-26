package com.spring.management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class BookManagementSystemApplication /*implements CommandLineRunner*/
{
	public static void main(String[] args) {
		SpringApplication.run(BookManagementSystemApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//
//	}
}

