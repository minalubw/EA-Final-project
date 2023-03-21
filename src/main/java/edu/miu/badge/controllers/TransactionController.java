package edu.miu.badge.controllers;

import edu.miu.badge.dto.TransactionDTO;
import edu.miu.badge.exceptions.ResourceNotFoundException;
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
    public ResponseEntity<?> createTransaction(@RequestBody TransactionDTO transaction){
        return new ResponseEntity<String>(transactionService.createTransaction(transaction).toString(), HttpStatus.OK);
    }
    @GetMapping("/transactions/{id}")
    public ResponseEntity<?> getTransaction(@PathVariable int id){
        try{
            TransactionDTO transaction = transactionService.getTransaction(id);
            return new ResponseEntity<TransactionDTO>(transaction, HttpStatus.OK);
        }catch (ResourceNotFoundException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/transactions/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable int id, @RequestBody TransactionDTO transaction){
        try {
            TransactionDTO updatedTransaction = transactionService.updateTransaction(id, transaction);
            return new ResponseEntity<TransactionDTO> (updatedTransaction, HttpStatus.OK);
        }catch (ResourceNotFoundException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable int id){
        try {
            return new ResponseEntity<String> (transactionService.deleteTransaction(id), HttpStatus.OK);
        }catch (ResourceNotFoundException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/transactions")
    public List<TransactionDTO> getAllTransactions(){
        return transactionService.getAllTransactions();
    }


}
