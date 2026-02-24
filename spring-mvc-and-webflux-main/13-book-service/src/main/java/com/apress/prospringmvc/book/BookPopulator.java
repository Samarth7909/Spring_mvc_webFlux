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

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS  BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.apress.prospringmvc.book;

import com.apress.prospringmvc.book.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * on 29/08/2025
 */
@Component
public class BookPopulator {

	private final Logger logger = LoggerFactory.getLogger(BookPopulator.class);

	private final BookRepository bookRepository;

	public BookPopulator(BookRepository bookRepository) {
		this.bookRepository = bookRepository;

		List<Book> books = List.of(
				new Book("Pro Spring MVC an Webdlux", BigDecimal.valueOf(50.99), 2025,
						"Isamarth & ", "9781484227123", Book.Category.WEB),
				new Book("Spring Boot 2 Recipes", BigDecimal.valueOf(37.44), 2017, "", "9781484227893",
						Book.Category.SPRING),
				new Book("Pivotal Certified Professional Core Spring 5 Developer Exam", BigDecimal.valueOf(54.99), 2018,
						"Isamarth", "9781484251355", Book.Category.SPRING),
				new Book("Java for Absolute Beginners", BigDecimal.valueOf(24.99), 2025, "Isamarth",
						"9781484237779", Book.Category.JAVA),
				new Book("Java for Absolute Beginners, 2nd Edition", BigDecimal.valueOf(54.99), 2021, "Isamarth",
						"9781484230042", Book.Category.JAVA));

		bookRepository.deleteAll().thenMany(
				bookRepository.saveAll(books))
				.thenMany(bookRepository.findAll())
				.subscribe(
						data -> logger.info("found books: {}", bookRepository),
						error -> logger.error("" + error),
						() -> logger.info(" -->> done books initialization..."));

	}

}
