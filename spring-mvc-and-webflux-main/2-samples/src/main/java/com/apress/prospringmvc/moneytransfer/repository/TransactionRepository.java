package com.apress.prospringmvc.moneytransfer.repository;

import com.apress.prospringmvc.moneytransfer.domain.Account;
import com.apress.prospringmvc.moneytransfer.domain.Transaction;

/**
 * Repository to store and retrieve {@code Transaction}s.
 *
 * @author 
 */
public interface TransactionRepository {

	Transaction store(Transaction transaction);

	Iterable<Transaction> find(Account account);

}
