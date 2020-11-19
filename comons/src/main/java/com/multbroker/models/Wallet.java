package com.multbroker.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Jose R F Junior
 * Web2ajax@gmail.com
 */

@Entity
@Table(name = "wallet", schema = "multbroker")
@ToString(exclude = "id")
@EqualsAndHashCode
@Data
public class Wallet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_wallet")
    @SequenceGenerator(name = "sq_wallet", sequenceName = "sq_wallet", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "modality", length = 100, nullable = false)
    private String modality;

    @Column(name = "amount", length = 100, nullable = false)
    private Integer amount;

    @Column(name = "situation", length = 100, nullable = false)
    private Integer situation;

    @Column(name = "type", length = 100, nullable = false)
    private String type;

    @Column(name = "purchase_data", length = 100, nullable = false)
    private LocalDateTime purchaseData;

    @Column(name = "sale_date", length = 100, nullable = false)
    private LocalDateTime saleDate;

    @Column(name = "price_action_day", length = 100, nullable = false)
    private BigDecimal priceActionDay;

    @Column(name = "price_action", length = 100, nullable = false)
    private BigDecimal priceAction;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brokerage_account_fk", referencedColumnName = "id")
    private BrokerageAccount brokerageAccount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "action_fk", referencedColumnName = "id")
    private Action action;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_fk", referencedColumnName = "id")
    private UserEntity userEntity;

    @Column(name = "swing_trade", length = 100)
    private BigDecimal swingTrade;

    @Column(name = "iss_swing", length = 100)
    private BigDecimal issSwing;

    @Column(name = "day_trade", length = 100)
    private BigDecimal dayTrade;

    @Column(name = "iss_day", length = 100)
    private BigDecimal issDayTrade;

    public Wallet() {
    }

    public Wallet(String modality,
                  Integer amount,
                  Integer situation,
                  String type,
                  LocalDateTime purchaseData,
                  LocalDateTime saleDate,
                  BigDecimal priceActionDay,
                  BigDecimal priceAction,
                  BrokerageAccount brokerage,
                  Action action,
                  UserEntity userEntity) {
        super();
        this.modality = modality;
        this.amount = amount;
        this.situation = situation;
        this.type = type;
        this.purchaseData = purchaseData;
        this.saleDate = saleDate;
        this.priceActionDay = priceActionDay;
        this.priceAction = priceAction;
        this.brokerageAccount = brokerage;
        this.action = action;
        this.userEntity = userEntity;
    }
}
