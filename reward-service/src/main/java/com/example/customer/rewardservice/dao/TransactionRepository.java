package com.example.customer.rewardservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customer.rewardservice.beans.Transaction;


/**
 * Repository interface for transaction data access.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
