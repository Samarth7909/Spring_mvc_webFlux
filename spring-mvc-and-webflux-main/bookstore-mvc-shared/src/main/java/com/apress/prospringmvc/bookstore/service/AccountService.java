package com.apress.prospringmvc.bookstore.service;

import com.apress.prospringmvc.bookstore.domain.Account;

/**
 * Contract for services that work with an {@link Account}.
 * 
 * @author 
 *
 */
public interface AccountService {

    Account save(Account account);

    Account getAccount(String username);
}
