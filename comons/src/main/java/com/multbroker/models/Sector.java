package com.multbroker.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Jose R F Junior
 * Web2ajax@gmail.com
 */
@Entity
@Table(name = "sector",schema = "multbroker")
@Data
@EqualsAndHashCode
@ToString
public class Sector implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_sector")
    @SequenceGenerator(name = "sq_sector", sequenceName = "sq_sector", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private String description;

    public Sector() {
    }

    public Sector(Long id, String description) {
        super();
        this.id = id;
        this.description = description;
    }
}
