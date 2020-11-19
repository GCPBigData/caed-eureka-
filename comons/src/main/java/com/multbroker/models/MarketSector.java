package com.multbroker.models;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * A MarketSector.
 */
@Entity
@Table(name = "market_sector",schema = "multbroker")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@EqualsAndHashCode
@ToString
public class MarketSector implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_market_sector")
    @SequenceGenerator(name = "sq_market_sector", sequenceName = "sq_market_sector", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @OneToMany(mappedBy = "marketSector")
    private List<Stock> stocks;

    public MarketSector(){
    }

    public MarketSector(Long id, String name, List<Stock> stocks) {
        super();
        this.id = id;
        this.name = name;
        this.stocks = stocks;
    }
}
