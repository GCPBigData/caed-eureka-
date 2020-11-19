package com.multbroker.corretoras.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@ToString(exclude = "id")
@EqualsAndHashCode
@Data
public class BrokerageAccountDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7018016911060807187L;

    Long id;
    Long userId;
    Long brokerageId;
    String brokerageName;
    String loginEmail;
    String loginAccessCode;
    String loginCpf;
    String loginPassword;
    private BigDecimal swingTrade;
    private BigDecimal dayTrade;
    private BigDecimal issSwing;
    private BigDecimal issDay;
    private String signature;

    public BrokerageAccountDTO(){}

    public BrokerageAccountDTO(Long id, Long userId, Long brokerageId, String brokerageName, String loginEmail, String loginAccessCode, String loginCpf, String loginPassword, BigDecimal swingTrade, BigDecimal dayTrade, BigDecimal issSwing, BigDecimal issDay, String signature) {
        super();
        this.id = id;
        this.userId = userId;
        this.brokerageId = brokerageId;
        this.brokerageName = brokerageName;
        this.loginEmail = loginEmail;
        this.loginAccessCode = loginAccessCode;
        this.loginCpf = loginCpf;
        this.loginPassword = loginPassword;
        this.swingTrade = swingTrade;
        this.dayTrade = dayTrade;
        this.issSwing = issSwing;
        this.issDay = issDay;
        this.signature = signature;
    }
}
