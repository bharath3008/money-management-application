package io.github.mma.money_management_application.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name="account")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;
    private String accountName;
    @Column(name = "balance", precision = 15, scale = 2, nullable = false)
    private BigDecimal balance;

}
