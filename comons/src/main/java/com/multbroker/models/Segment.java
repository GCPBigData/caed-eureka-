package com.multbroker.models;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "segment",schema = "multbroker")
@Data
@EqualsAndHashCode
@ToString
public class Segment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_segment")
    @SequenceGenerator(name = "sq_segment", sequenceName = "sq_segment", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

    public Segment() {
    }

    public Segment(Long id, String description, Company company) {
        super();
        this.id = id;
        this.description = description;
        this.company = company;
    }
}
