package com.spartanHardware.model.entity;

import com.spartanHardware.model.enums.PaymentType;
import com.spartanHardware.model.enums.Provider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "payment_methods")
@Entity
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(STRING)
    @Column(name = "payment_method")
    private PaymentType paymentType;

    @Enumerated(STRING)
    @Column(name = "provider_entity")
    private Provider provider;

    @Column(name = "card_number")
    private Integer accountNumber;

    @Column(name = "expires_at")
    private LocalDateTime expiryDate;

    @Column(name = "default_payment")
    private boolean defaultMethod;
}
