package io.github.mma.money_management_application.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private LocalDate billDate;

    @Column(name = "balance", precision = 15, scale = 2, nullable = false)
    private BigDecimal amount;

    private String flow;

    private String description;

    private String subCategory;

    private String category;

    private Long accountId;

    private String methodId;

    private LocalDate paidDate;
}
