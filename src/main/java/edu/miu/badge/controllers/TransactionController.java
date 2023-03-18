package edu.miu.badge.controllers;

import edu.miu.badge.domains.Transaction;
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
        return new ResponseEntity<String>(transactionService.getTransaction(id).toString(), HttpStatus.OK);
    }
    @PutMapping("/transactions/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable int id, @RequestBody Transaction transaction){
        return new ResponseEntity<String> (transactionService.updateTransaction(transaction).toString(), HttpStatus.OK);
    }
    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable int id){
       return new ResponseEntity<String> (transactionService.deleteTransaction(id), HttpStatus.OK);
    }
    @GetMapping("/transactions")
    public String getAllTransactions(){
        return transactionService.getAllTransactions().toString();
    }


}
