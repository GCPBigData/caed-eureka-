package com.multbroker.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "brokerage",schema = "multbroker")
@ToString(exclude="id")
@EqualsAndHashCode
@Data
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Brokerage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_brokerage")
    @SequenceGenerator(name = "sq_brokerage", sequenceName = "sq_brokerage", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

     @Column(name = "name", length = 100, nullable = false)
     private String name;
     @Column(name = "cnpj", length = 18, unique = true)
     private String cnpj;
     @Column(name = "address", length = 100)
     private String address;
     @Column(name = "address_neighborhood", length = 100)
     private String addressNeighborhood;
     @Column(name = "address_city", length = 100)
     private String addressCity;
     @Column(name = "address_state", length = 50)
     private String addressState;
     @Column(name = "swing_trade", precision = 10, scale = 2)
     private BigDecimal swingTrade;
     @Column(name = "day_trade", precision = 10, scale = 2)
     private BigDecimal dayTrade;
     @Column(name = "login_email", nullable = false)
     private Boolean loginEmail;
     @Column(name = "login_access_code", nullable = false)
     private Boolean loginAccessCode;
     @Column(name = "login_cpf", nullable = false)
     private Boolean loginCpf;
     @Column(name = "login_password", nullable = false)
     private Boolean loginPassword;
     @Column(name = "login_token", nullable = false)
     private Boolean loginToken;
     @Column(name = "iss", precision = 10, scale = 2)
     private BigDecimal iss;
     @Column(name = "phone", length = 50)
     private String phone;
     @Column(name = "website", length = 100)
     private String website;
     @Column(name = "email", length = 100)
     private String email;
     @Column(name = "logo", length = 50)
     private String logo;
     @Column(name="status", length = 20)
     private String status;
     @Column(name = "tipo", length = 50)
     private String tipo;




    public Brokerage(){
    }

    public Brokerage(String name, String cnpj, String address, String addressNeighborhood, String addressCity, String addressState, BigDecimal swingTrade, BigDecimal dayTrade, Boolean loginEmail, Boolean loginAccessCode, Boolean loginCpf, Boolean loginPassword, Boolean loginToken, BigDecimal iss, String phone, String website, String email, String logo, String status, String tipo) {
        super();
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
        this.addressNeighborhood = addressNeighborhood;
        this.addressCity = addressCity;
        this.addressState = addressState;
        this.swingTrade = swingTrade;
        this.dayTrade = dayTrade;
        this.loginEmail = loginEmail;
        this.loginAccessCode = loginAccessCode;
        this.loginCpf = loginCpf;
        this.loginPassword = loginPassword;
        this.loginToken = loginToken;
        this.iss = iss;
        this.phone = phone;
        this.website = website;
        this.email = email;
        this.logo = logo;
        this.status = status;
        this.tipo = tipo;
    }

}
