package com.apress.prospringmvc.bookstore.service;

import com.apress.prospringmvc.bookstore.document.Account;
import reactor.core.publisher.Mono;

/**
 * on 27/07/2025
 */
public interface AccountService {

	Mono<Account> save(Account account);

	Mono<Account> getAccount(String username);

	/**
	 * Loading only data for Authentication and Authorization
	 * 
	 * @param username
	 * @return
	 */
	Mono<Account> getAccountLight(String username);
}
