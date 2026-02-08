package io.github.mma.money_management_application.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "method")
@Data
public class Method {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long methodId;

    private String methodName;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account accountId;
}
