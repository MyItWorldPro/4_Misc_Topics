package com.misc.twilio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SendWAMsgDto {

    @NotBlank
    @Size(min = 1, message = "message should have at least 1 character")
    private String message;
    @NotBlank
    @Size(min = 1, message = "customerWhatsAppNumber should have at least 1 character")
    private String customerWhatsAppNumber;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCustomerWhatsAppNumber() {
        return customerWhatsAppNumber;
    }

    public void setCustomerWhatsAppNumber(String customerWhatsAppNumber) {
        this.customerWhatsAppNumber = customerWhatsAppNumber;
    }

    @Override
    public String toString() {
        return "SendWAMsgDto{" +
                "message='" + message + '\'' +
                ", customerWhatsAppNumber='" + customerWhatsAppNumber + '\'' +
                '}';
    }
}
