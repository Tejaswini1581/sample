package com.techwave.Bank.models.pojo;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transfer {
    @Id
    private String transferId;
    @ManyToOne
    @JoinColumn(name="accountNo", nullable=false )
    private Account sourceAccount;
    private String destinationAccountName;
    private Double amount;
    private Timestamp timeStamp;
    private String remarks;
    private String transferType;
    public Transfer() {
        super();
    }

    public Transfer(String transferId, Account sourceAccount, String destinationAccountName, Double amount,
            Timestamp timeStamp, String remarks, String transferType) {
        super();
        this.transferId = transferId;
        this.sourceAccount = sourceAccount;
        this.destinationAccountName = destinationAccountName;
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.remarks = remarks;
        this.transferType = transferType;
    }
    public String getTransferId() {
        return transferId;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }
    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }
    public String getDestinationAccountName() {
        return destinationAccountName;
    }

    public void setDestinationAccountName(String destinationAccountName) {
        this.destinationAccountName = destinationAccountName;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Timestamp getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getTransferType() {
        return transferType;
    }
    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

}