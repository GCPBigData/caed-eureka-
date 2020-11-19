package com.multbroker.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Jose R F Junior
 * Web2ajax@gmail.com
 */

@Builder
@Entity
@Table(name = "emoluments",schema = "multbroker")
@ToString(exclude="id")
@EqualsAndHashCode
@Data
@Getter
@Setter
public class Emoluments implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_emoluments")
    @SequenceGenerator(name = "sq_emoluments", sequenceName = "sq_emoluments", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "negotiation",nullable = false)
    private BigDecimal negotiation;

    @Column(name = "saleoff",  nullable = false)
    private BigDecimal saleoff;

    @Column(name = "records", nullable = false)
    private BigDecimal records;

    @Column(name="dedo_duro")
    private BigDecimal dedoDuro;

    @Column(name = "irpf")
    private BigDecimal irpf;

    //TODO: criar enum
    /*
     * - AÇÕES Swing Trade
     * - AÇÕES Day Trade
     * - OPÇÕES  Swing Trade
     * - OPÇÕES Day Trade
     * - TERMO Swing Trade
     * TERMO Day Trade
     *
     */
    @Column(name = "tipo")
    private String tipo;
}
