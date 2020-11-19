package com.multbroker.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "saldo_usuario",schema = "multbroker")
@Data
@EqualsAndHashCode
@ToString
public class SaldoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_saldo_user")
    @SequenceGenerator(name = "sq_saldo_user", sequenceName = "sq_saldo_user", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_fk", referencedColumnName = "id")
    private UserEntity userEntity;

    private BigDecimal saldo;

    private Date data;


}
