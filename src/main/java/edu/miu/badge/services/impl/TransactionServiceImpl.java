package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Transaction;
import edu.miu.badge.repositories.TransactionRepository;
import edu.miu.badge.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransaction(int id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public String deleteTransaction(int id) {
        transactionRepository.deleteById(id);
        return "Transaction with ID " + id + " deleted";
    }

    @Override
    public Collection<Transaction> getAllTransactions() {
       return transactionRepository.findAll();
    }
}
