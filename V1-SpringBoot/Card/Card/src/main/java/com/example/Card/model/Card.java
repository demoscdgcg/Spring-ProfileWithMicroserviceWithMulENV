package com.example.Card.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "card")
public class Card extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardId;

    @Column(name = "mobileNo")
    private String mobileNo;

    @Column(name="cardNo")
    private String cardNo;

    @Column(name="cardType")
    private String cardType;

    @Column(name="totalLimit")
    private int totalLimit;

    @Column(name = "amountUsed")
    private int amountUsed;

    @Column(name = "availableAmount")
    private int availableAmount;
}
