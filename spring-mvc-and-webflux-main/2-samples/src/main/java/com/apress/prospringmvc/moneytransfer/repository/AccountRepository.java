package com.apress.prospringmvc.moneytransfer.repository;

import com.apress.prospringmvc.moneytransfer.domain.Account;

/**
 * @author 
 */
public interface AccountRepository {

	Account find(String number);

}
