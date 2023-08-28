package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class TransferController {
    private TransferDao transferDao;
    //TODO: Need to make transfers add and subtract amount from balance and display in Postman

    @Autowired
    public TransferController(TransferDao transferDao) {
        this.transferDao = transferDao;
    }

    //pass in token- use principal
    //GET getTransferByTransferId /api/tenmo/transfer/{id}
    @RequestMapping(path = "/api/tenmo/transfer/{id}", method = RequestMethod.GET)
    public Transfer transferById(@PathVariable int id, @Valid Principal principal){
        Transfer transfer = transferDao.getTransferByTransferId(id);
        return transfer;

    } /* TODO:Getting the error below with GET http://localhost:8080/api/tenmo/transfer/1
    {
    "timestamp": "2023-08-26T05:00:59.108+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "StatementCallback; bad SQL grammar [SELECT transfer_id, amount, status, accountId_from, accountId_to FROM transfer WHERE transfer_id = ?;]; nested exception is org.postgresql.util.PSQLException: ERROR: syntax error at end of input\n  Position: 101",
    "path": "/api/tenmo/transfer/1"
}
*/


    //pass in token- use principal
 //   GET getAllTransfers /api/tenmo/transfer
 @RequestMapping(path = "/api/tenmo/transfer/user/{userId}", method = RequestMethod.GET)
    public List<Transfer> allTransfers(@PathVariable int userId, @Valid Principal principal) { //Principal principal //@PathVariable int userId
        List<Transfer> allTransfersInAccount = transferDao.getAllTransfers(userId);
        return allTransfersInAccount;
        //TODO: doesn't throw an error in Postman but also does not display a successful transfer
 }

    //pass in token- use principal
    // POST newTransfer /api/tenmo/transfer
    @RequestMapping(path = "/api/tenmo/transfer", method = RequestMethod.POST)
  public Transfer newTransfer(@RequestBody Transfer transfer, @Valid Principal principal) {
    Transfer newTransfer = transferDao.newTransfer(transfer.getAccountId_from(), transfer.getAccountId_to(), transfer.getAmount());
    return newTransfer;
    }
    //TODO: Need to fix status. Currently returns 'null'.
}
