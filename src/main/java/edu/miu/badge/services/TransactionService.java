package edu.miu.badge.services;

import edu.miu.badge.enumeration.TransactionDeclinedException;
import edu.miu.badge.dto.RequestTransactionDTO;
import edu.miu.badge.dto.ResponseTransactionDTO;

import java.util.List;

public interface TransactionService {
    ResponseTransactionDTO createTransaction(RequestTransactionDTO transaction) throws Exception;
    ResponseTransactionDTO getTransaction(int id) throws TransactionDeclinedException;
    List<ResponseTransactionDTO> getAllTransactions();
}
