package edu.miu.badge.controllers;

import edu.miu.badge.dto.RequestTransactionDTO;
import edu.miu.badge.dto.ResponseTransactionDTO;
import edu.miu.badge.exceptions.TransactionNotFoundException;
import edu.miu.badge.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/transactions")
    public ResponseEntity<?> createTransaction(@RequestBody RequestTransactionDTO requestTransactionDTO){
        return new ResponseEntity<>(transactionService.createTransactiony(requestTransactionDTO), HttpStatus.OK);
    }
    @GetMapping("/transactions/{id}")
    public ResponseEntity<?> getTransaction(@PathVariable int id){
        try{
            ResponseTransactionDTO transaction = transactionService.getTransaction(id);
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        }catch (TransactionNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/transactions/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable int id, @RequestBody ResponseTransactionDTO transaction){
        try {
            ResponseTransactionDTO updatedTransaction = transactionService.updateTransaction(id, transaction);
            return new ResponseEntity<ResponseTransactionDTO> (updatedTransaction, HttpStatus.OK);
        }catch (TransactionNotFoundException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable int id){
        try {
            return new ResponseEntity<String> (transactionService.deleteTransaction(id), HttpStatus.OK);
        }catch (TransactionNotFoundException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/transactions")
    public List<ResponseTransactionDTO> getAllTransactions(){
        return transactionService.getAllTransactions();
    }


}
