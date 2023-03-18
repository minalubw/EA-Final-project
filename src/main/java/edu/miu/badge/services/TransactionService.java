package edu.miu.badge.services;

import edu.miu.badge.domains.Transaction;

import java.util.Collection;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);
    Transaction getTransaction(int id);
    Transaction updateTransaction(Transaction transaction);
    String deleteTransaction(int id);
    Collection<Transaction> getAllTransactions();
}
