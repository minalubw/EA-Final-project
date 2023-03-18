package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Transaction;
import edu.miu.badge.exceptions.TransactionNotFoundException;
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
    public Transaction getTransaction(int id)throws TransactionNotFoundException {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if(transaction == null){
            throw new TransactionNotFoundException("Transaction with ID " + id + " not found");
        }
        return transaction;
    }

    @Override
    public Transaction updateTransaction(int transactionId,Transaction transaction)throws TransactionNotFoundException {
        Transaction transactionToBeUpdated = transactionRepository.findById(transactionId).orElse(null);
        if (transactionToBeUpdated == null){
            throw new TransactionNotFoundException("Transaction with ID " + transactionId + " not found");
        }
        transactionToBeUpdated.setDate(transaction.getDate());
        transactionToBeUpdated.setMember(transaction.getMember());
        transactionToBeUpdated.setMembership(transaction.getMembership());
        transactionToBeUpdated.setLocation(transaction.getLocation());
        transactionToBeUpdated.setType(transaction.getType());
        return transactionRepository.save(transactionToBeUpdated);
    }

    @Override
    public String deleteTransaction(int id)throws TransactionNotFoundException {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if(transaction == null){
            throw new TransactionNotFoundException("Transaction with ID " + id + " not found");
        }
        transactionRepository.deleteById(id);
        return "Transaction with ID " + id + " deleted";
    }

    @Override
    public Collection<Transaction> getAllTransactions() {
       return transactionRepository.findAll();
    }
}
