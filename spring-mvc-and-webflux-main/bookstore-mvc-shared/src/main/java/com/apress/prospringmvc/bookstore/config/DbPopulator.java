/*
Freeware License, some rights reserved

Copyright (c) 

Permission is hereby granted, free of charge, to anyone obtaining a copy 
of this software and associated documentation files (the "Software"), 
to work with the Software within the limits of freeware distribution and fair use. 
This includes the rights to use, copy, and modify the Software for personal use. 
Users are also allowed and encouraged to submit corrections and modifications 
to the Software for the benefit of other users.

It is not allowed to reuse,  modify, or redistribute the Software for 
commercial use in any way, or for a user's educational materials such as books 
or blog articles without prior permission from the copyright holder. 

The above copyright notice and this permission notice need to be included 
in all copies or substantial portions of the software.


*/
package com.apress.prospringmvc.bookstore.config;

import com.apress.prospringmvc.bookstore.domain.Book;
import com.apress.prospringmvc.bookstore.domain.Category;
import com.apress.prospringmvc.bookstore.repository.BookRepository;
import com.apress.prospringmvc.bookstore.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

/**
 *  on 07/06/2025
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class DbPopulator {
	private Logger logger = LoggerFactory.getLogger(DbPopulator.class);

	private BookRepository bookRepository;

	private CategoryRepository categoryRepository;

	public DbPopulator(BookRepository bookRepository, CategoryRepository categoryRepository) {
		this.bookRepository = bookRepository;
		this.categoryRepository = categoryRepository;
	}

	@PostConstruct
	private void init(){
		logger.info(" -->> Starting database initialization...");
		List<Category> categories = List.of(new Category("Spring"), new Category("Java"), new Category("Web"));
		categoryRepository.saveAll(categories);

		List<Book> books = List.of(
				new Book("Spring Boot 2 Recipes", BigDecimal.valueOf(37.44), 2017,"", "9781484227893", categoryRepository.findByName("Spring").get()),
				new Book("Pivotal Certified Professional Core Spring 5 Developer Exam", BigDecimal.valueOf(54.99), 2018,"Isamarth", "9781484251355", categoryRepository.findByName("Spring").get()),
				new Book("Java for Absolute Beginners", BigDecimal.valueOf(24.99), 2025,"Isamarth", "9781484237779", categoryRepository.findByName("Java").get())
		);

		bookRepository.saveAll(books);
		logger.info(" -->> Database initialization completed.");
	}
}
