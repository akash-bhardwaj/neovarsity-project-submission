package com.scaler.neovarsityproject.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
    private String ticketId;
    private Integer amount;
    private PaymentMode mode;
    private PaymentStatus status;
}
