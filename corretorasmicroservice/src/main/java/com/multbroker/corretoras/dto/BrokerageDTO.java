package com.multbroker.corretoras.dto;

import com.multbroker.models.Brokerage;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@ToString(exclude="id")
@EqualsAndHashCode
@Data
public class BrokerageDTO implements Serializable {
    private static final long serialVersionUID = 1L;

     private Long id;
     private String name;
     private String cnpj;
     private String address;
     private String addressNeighborhood;
     private String addressCity;
     private String addressState;
     private BigDecimal swingTrade;
     private BigDecimal dayTrade;
     private String loginEmail;
     private Boolean loginAccessCode;
     private Boolean loginCpf;
     private Boolean loginPassword;
     private Boolean loginToken;
     private BigDecimal iss;
     private String phone;
     private String website;
     private String email;
     private String logo;
     private String status;
     private String tipo;

    public BrokerageDTO(){}
    public BrokerageDTO(Brokerage objBrokerage) {
        super();
        id = objBrokerage.getId();
        name = objBrokerage.getName();
        cnpj = objBrokerage.getCnpj();
        address = objBrokerage.getAddress();
        addressNeighborhood = objBrokerage.getAddressNeighborhood();
        addressCity = objBrokerage.getAddressCity();
        addressState = objBrokerage.getAddressState();
        loginEmail = objBrokerage.getEmail();
        loginAccessCode = objBrokerage.getLoginAccessCode();
        loginCpf = objBrokerage.getLoginCpf();
        loginPassword = objBrokerage.getLoginPassword();
        loginToken = objBrokerage.getLoginToken();
        iss = objBrokerage.getIss();
        phone = objBrokerage.getPhone();
        website = objBrokerage.getWebsite();
        email = objBrokerage.getEmail();
        logo = objBrokerage.getLogo();
        status = objBrokerage.getStatus();
        swingTrade = objBrokerage.getSwingTrade();
        dayTrade = objBrokerage.getDayTrade();
    }
}
