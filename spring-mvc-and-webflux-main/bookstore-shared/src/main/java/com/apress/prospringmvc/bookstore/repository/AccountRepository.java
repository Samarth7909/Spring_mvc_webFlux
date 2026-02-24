package com.apress.prospringmvc.bookstore.repository;

import com.apress.prospringmvc.bookstore.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for working with {@link Account} domain objects
 * 
 * @author 

 *
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);


}
