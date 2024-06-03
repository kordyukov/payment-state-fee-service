package ru.integration.paymentstatefeeservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@SuperBuilder
public class PaymentStateFeeResponseDTO {
    @JsonProperty("UPI")
    private String upi;
    @JsonProperty("Amount")
    private BigDecimal amount;
    @JsonProperty("PaymentDate")
    private LocalDateTime paymentDate;
    @JsonProperty("Purpose")
    private String purpose;
    @JsonProperty("PayeeOktmo")
    private String payeeOktmo;
    @JsonProperty("PayerInn")
    private String payerInn;
    @JsonProperty("PayerKpp")
    private String payerKpp;
    @JsonProperty("PayerName")
    private String payerName;
}
