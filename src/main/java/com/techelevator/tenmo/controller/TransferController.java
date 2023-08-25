package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated")
public class TransferController {
    private TransferDao transferDao;
    //TODO: implement GETs and such to transfer controller.

    //GET getTransferByTransferId /api/tenmo/transfer/{id}
    @RequestMapping(path = "/api/tenmo/transfer/{id}", method = RequestMethod.GET)
    public Transfer getTransfer(@PathVariable int id){
        Transfer transfer = transferDao.getTransferByTransferId(id);
        return transfer;
    }

 //   GET getAllTransfers /api/tenmo/transfer
 @RequestMapping(path = "/api/tenmo/transfer/{userId}", method = RequestMethod.GET)
    public List<Transfer> allTransfers(@PathVariable int userId) {
        List<Transfer> allTransfersInAccount = transferDao.getAllTransfers(userId);
        return allTransfersInAccount;
 }

   // POST newTransfer /api/tenmo/transfer
    @RequestMapping(path = "/api/tenmo/transfer", method = RequestMethod.POST)
  public Transfer newTransfer(@RequestBody Transfer transfer) {
    Transfer newTransfer = transferDao.newTransfer(transfer.getAccountId_from(), transfer.getAccountId_to(), transfer.getAmount());
    return newTransfer;
    }
}
