package com.example.repository;

import java.sql.Timestamp;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Account;
import com.example.model.Txn;

//@Component("jdbcAccountRepository")
@Repository("jdbcAccountRepository")
@Qualifier("jdbc")
public class JdbcAccountRepository implements AccountRepository {

	private static final Logger LOGGER = Logger.getLogger("App");
	private static int id=1;
	
	private JdbcTemplate jdbcTemplate;


	@Autowired
	public JdbcAccountRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		LOGGER.info("JdbcAccountRepository created with datasource");
	}

	public Account load(String accNum) {
		LOGGER.info("loading account : " + accNum);
		String sql = "select * from accounts where num=?";
		Account account = new Account();
		
		jdbcTemplate.queryForObject(sql, (rs,rowNum)->{
			account.setNumber(rs.getString("num"));
			account.setBalance(rs.getDouble("balance"));
			return account;
		},accNum);
		
		return account;
	}

	public Account update(Account account) {
		//
		LOGGER.info("updating account : " + account.getNumber());
		
		String sql="update accounts set balance =? where num=?";
		
		int rowCount = jdbcTemplate.update(sql, account.getBalance(),account.getNumber());
	
		return account;
	}
	
	@Override
	public void save(Txn txn) {
		AccountRepository.super.save(txn);
		String sql="insert into accounts_transaction values(id_seq.nextval,?,?,?,?,?)";
		
		jdbcTemplate.update(sql, 
				Timestamp.valueOf(txn.getLocalDateTime()),
				txn.getAmount(),
				txn.getType().name(),
				txn.getClosing_balance(),
				txn.getAccount().getNumber());
		

	}

}