package edu.miu.badge.services.impl;

import edu.miu.badge.domains.*;
import edu.miu.badge.dto.RequestTransactionDTO;
import edu.miu.badge.dto.ResponseTransactionDTO;
import edu.miu.badge.exceptions.TransactionNotFoundException;
import edu.miu.badge.repositories.BadgeRepository;
import edu.miu.badge.repositories.LocationRepository;
import edu.miu.badge.repositories.TransactionRepository;
import edu.miu.badge.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    private BadgeRepository badgeRepository;

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseTransactionDTO createTransaction(RequestTransactionDTO requestTransactionDTO) throws Exception {
        Optional<Badge> badgeOptional = badgeRepository.getBadgeByBadgeNumber(requestTransactionDTO.getBadgeId());
        if (badgeOptional.isPresent()) {
            Member member = badgeOptional.get().getMember();
            List<Membership> memberships = member.getMemberships();
            Membership msToBeUSed = null;
            Plan planToBeUsed = null;
            boolean flag = false;
            for (Membership ms : memberships) {
                if (ms.getPlan().getId() == requestTransactionDTO.getPlanId()) {
                    flag = true;
                    msToBeUSed = ms;
                    break;
                }
            }
            if (!flag) {
                throw new TransactionNotFoundException("You are not allowed to use this service!");
            }

            // Is Membership is expired or not.
            boolean isExpiredMemberShip = LocalDateTime.now().isAfter(msToBeUSed.getEndDate().atStartOfDay()) &&
                    LocalDateTime.now().isBefore(msToBeUSed.getStartDate().atStartOfDay());

            planToBeUsed = msToBeUSed.getPlan();
            List<Location> locations = planToBeUsed.getLocations();

        }
        // Check the member is attended in the right time slot or not
        Location location = locationRepository.findById(requestTransactionDTO.getLocationId().longValue())
                .orElseThrow(() -> {
                    return new Exception("Location cannot find.");
                });
        boolean isCorrectTimeSlot = location.getTimeSlots().stream()
                .anyMatch(timeSlot -> LocalDateTime.now().isBefore(timeSlot.getStartTime()) && LocalDateTime.now().isAfter(timeSlot.getEndTime())
                        && !LocalDateTime.now().getDayOfWeek().toString().equals(timeSlot.getDay().toString()));

        return null;
    }

    @Override
    public ResponseTransactionDTO getTransaction(int id) throws TransactionNotFoundException {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction with ID " + id + " not found");
        }
        return modelMapper.map(transaction, ResponseTransactionDTO.class);
    }

    @Override
    public ResponseTransactionDTO updateTransaction(int transactionId, ResponseTransactionDTO transaction) throws TransactionNotFoundException {
        Transaction transactionToBeUpdated = transactionRepository.findById(transactionId).orElse(null);
        if (transactionToBeUpdated == null) {
            throw new TransactionNotFoundException("Transaction with ID " + transactionId + " not found");
        }
        transactionToBeUpdated.setDate(transaction.getDate());
        transactionToBeUpdated.setMember(modelMapper.map(transaction.getMember(), Member.class));
        transactionToBeUpdated.setMembership(modelMapper.map(transaction.getMembership(), Membership.class));
        transactionToBeUpdated.setLocation(modelMapper.map(transaction.getLocation(), Location.class));
        transactionToBeUpdated.setType(transaction.getType());
        return modelMapper.map(transactionRepository.save(transactionToBeUpdated), ResponseTransactionDTO.class);
    }

    @Override
    public String deleteTransaction(int id) throws TransactionNotFoundException {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction with ID " + id + " not found");
        }
        transactionRepository.deleteById(id);
        return "Transaction with ID " + id + " deleted";
    }

    @Override
    public List<ResponseTransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<ResponseTransactionDTO> responseTransactionDTOS = new ArrayList<>();
        for (Transaction transaction : transactions) {
            responseTransactionDTOS.add(modelMapper.map(transaction, ResponseTransactionDTO.class));
        }
        return responseTransactionDTOS;
    }
}
