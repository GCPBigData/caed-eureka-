package com.multbroker.models;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "company",schema = "multbroker")
@ToString(exclude="id")
@EqualsAndHashCode
@Data
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_company")
    @SequenceGenerator(name = "sq_company", sequenceName = "sq_company", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "main_activity", length = 100, nullable = false)
    private String mainActivity;

    @Column(name = "site", length = 100, nullable = false)
    private String site;

    @Column(name = "market", length = 100, nullable = false)
    private String market;

    @Column(name = "cnpj", length = 100, nullable = false)
    private String cnpj;

    @Column(name = "status", length = 100, nullable = false)
    private String status;

    @Column(name = "setorial_classification", length = 100, nullable = false)
    private String setorialClassification;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sector_fk", referencedColumnName = "id")
    private Sector sector;

    @OneToMany(mappedBy="company")
    private List<Action> actions = new ArrayList<>();

    @OneToMany(mappedBy="company")
    private List<Segment> segments = new ArrayList<>();

    public Company() {
    }

    public Company(Long id,
                   String name,
                   String mainActivity,
                   String site,
                   String market,
                   String cnpj,
                   String setorialClassification,
                   String status
                   ) {
        super();
        this.id = id;
        this.name = name;
        this.mainActivity = mainActivity;
        this.site = site;
        this.market = market;
        this.cnpj = cnpj;
        this.setorialClassification = setorialClassification;
        this.status = status;
    }
}
