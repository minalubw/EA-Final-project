package edu.miu.badge.services;

import edu.miu.badge.controllers.TransactionNotFoundException;
import edu.miu.badge.dto.RequestTransactionDTO;
import edu.miu.badge.dto.ResponseTransactionDTO;

import java.util.List;

public interface TransactionService {
    ResponseTransactionDTO createTransaction(RequestTransactionDTO transaction) throws Exception;
    ResponseTransactionDTO getTransaction(int id) throws TransactionNotFoundException;
    ResponseTransactionDTO updateTransaction(int transactionId, ResponseTransactionDTO transaction) throws TransactionNotFoundException;
    String deleteTransaction(int id) throws TransactionNotFoundException;
    List<ResponseTransactionDTO> getAllTransactions();
}
