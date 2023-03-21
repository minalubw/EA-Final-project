package edu.miu.badge.services;

import edu.miu.badge.dto.RequestTransactionDTO;
import edu.miu.badge.dto.ResponseTransactionDTO;

import java.util.List;

public interface TransactionService {
    ResponseTransactionDTO createTransaction(RequestTransactionDTO transaction) throws Exception;
    ResponseTransactionDTO getTransaction(int id);
    ResponseTransactionDTO updateTransaction(int transactionId, ResponseTransactionDTO transaction);
    String deleteTransaction(int id);
    List<ResponseTransactionDTO> getAllTransactions();
}
