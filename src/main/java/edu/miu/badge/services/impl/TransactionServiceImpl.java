package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Transaction;
import edu.miu.badge.dto.TransactionDTO;
import edu.miu.badge.exceptions.TransactionNotFoundException;
import edu.miu.badge.repositories.TransactionRepository;
import edu.miu.badge.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public TransactionDTO createTransaction(TransactionDTO transaction) {
        Transaction convertedTransaction = modelMapper.map(transaction, Transaction.class);
        //create Audit like an event

        return modelMapper.map(transactionRepository.save(convertedTransaction), TransactionDTO.class);
    }

    @Override
    public TransactionDTO getTransaction(int id)throws TransactionNotFoundException {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if(transaction == null){
            throw new TransactionNotFoundException("Transaction with ID " + id + " not found");
        }
        return modelMapper.map(transaction, TransactionDTO.class);
    }

    @Override
    public TransactionDTO updateTransaction(int transactionId,TransactionDTO transaction)throws TransactionNotFoundException {
        Transaction transactionToBeUpdated = transactionRepository.findById(transactionId).orElse(null);
        if (transactionToBeUpdated == null){
            throw new TransactionNotFoundException("Transaction with ID " + transactionId + " not found");
        }
        transactionToBeUpdated.setDate(transaction.getDate());
        transactionToBeUpdated.setMember(transaction.getMember());
        transactionToBeUpdated.setMembership(transaction.getMembership());
        transactionToBeUpdated.setLocation(transaction.getLocation());
        transactionToBeUpdated.setType(transaction.getType());
        return modelMapper.map(transactionRepository.save(transactionToBeUpdated), TransactionDTO.class) ;
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
    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionDTO> transactionDTOS = new ArrayList<>();
        for (Transaction transaction: transactions) {
            transactionDTOS.add(modelMapper.map(transaction, TransactionDTO.class));
        }
        return transactionDTOS;
    }
}
