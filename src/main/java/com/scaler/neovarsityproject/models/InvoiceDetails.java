package com.scaler.neovarsityproject.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class InvoiceDetails extends BaseModel {

    private String invoiceId;
    private Date exitTime;
    private String ticketId;
    private Ticket ticket;
    private double amount;
    private String paymentId;
    private Payment payment;

}
