package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Account;
import com.example.model.Txn;


@Repository
@Qualifier(value = "jpa")
public interface AccountRepository extends JpaRepository<Account, String>{
	
	@Query("from Account acc where acc.balance=?1")
	List<Account> findByAmount(double balance);
}