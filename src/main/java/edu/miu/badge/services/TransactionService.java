package edu.miu.badge.services;

import edu.miu.badge.domains.Transaction;
import edu.miu.badge.dto.TransactionDTO;

import java.util.Collection;
import java.util.List;

public interface TransactionService {
    TransactionDTO createTransaction(TransactionDTO transaction);
    TransactionDTO getTransaction(int id);
    TransactionDTO updateTransaction(int transactionId,TransactionDTO transaction);
    String deleteTransaction(int id);
    List<TransactionDTO> getAllTransactions();
}
