package com.apress.prospringmvc.book.repository;

import com.apress.prospringmvc.book.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Flux;

/**
 * on 26/07/2025
 */
public interface CustomBookRepository {
	Flux<Book> findRandom(Pageable pageable);

	Flux<Book> findAll(Query query);
}
