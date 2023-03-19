package edu.miu.badge.controllers;

import edu.miu.badge.domains.Transaction;
import edu.miu.badge.exceptions.TransactionNotFoundException;
import edu.miu.badge.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/transactions")
    public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction){
        return new ResponseEntity<String>(transactionService.createTransaction(transaction).toString(), HttpStatus.OK);
    }
    @GetMapping("/transactions/{id}")
    public ResponseEntity<?> getTransaction(@PathVariable int id){
        try{
            Transaction transaction = transactionService.getTransaction(id);
            return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
        }catch (TransactionNotFoundException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/transactions/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable int id, @RequestBody Transaction transaction){
        try {
            Transaction updatedTransaction = transactionService.updateTransaction(id, transaction);
            return new ResponseEntity<Transaction> (updatedTransaction, HttpStatus.OK);
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
    public String getAllTransactions(){
        return transactionService.getAllTransactions().toString();
    }


}
