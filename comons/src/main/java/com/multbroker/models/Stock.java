package com.multbroker.models;


import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;


import java.io.Serializable;

/**
 * A Stock.
 */
@Entity
@Table(name = "stock",schema = "multbroker")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@EqualsAndHashCode
@ToString
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_stock")
    @SequenceGenerator(name = "sq_stock", sequenceName = "sq_stock", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;


    @Column(name = "symbol", length = 100, nullable = false)
    private String symbol;


    @Column(name = "company", length = 200, nullable = false)
    private String company;


    @Column(name = "bdr", length = 30, nullable = false)
    private String bdr;


    @Column(name = "cnpj", length = 18)
    private String cnpj;


    @Column(name = "main_activity", length = 300)
    private String main_activity;


    @Column(name = "market_sector", length = 200)
    private String market_sector;


    @Column(name = "website", length = 100)
    private String website;


    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @ManyToOne(optional = false)
    private MarketSector marketSector;

    public Stock(){
    }

    public Stock(Long id, String symbol, String company, String bdr, String cnpj, String main_activity, String market_sector, String website, Boolean enabled, MarketSector marketSector) {
        super();
        this.id = id;
        this.symbol = symbol;
        this.company = company;
        this.bdr = bdr;
        this.cnpj = cnpj;
        this.main_activity = main_activity;
        this.market_sector = market_sector;
        this.website = website;
        this.enabled = enabled;
        this.marketSector = marketSector;
    }
}
