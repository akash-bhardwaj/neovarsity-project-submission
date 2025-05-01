package com.scaler.neovarsityproject.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@SuperBuilder
public class InvoiceDetails extends BaseModel {

    private String invoiceId;
    private Date exitTime;
    private String ticketId;
    private TicketDetails ticket;
    private double amount;
    private String paymentId;
    private Payment payment;

}
