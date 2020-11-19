package com.multbroker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "action",schema = "multbroker")
@Data
@EqualsAndHashCode
@ToString
public class Action implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_action")
    @SequenceGenerator(name = "sq_action", sequenceName = "sq_action", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private String description;
    private String status;

    @ManyToOne
    @JoinColumn(name="company_id")
    @JsonIgnore
    private Company company;

    public Action() {
    }

    public Action(Long id, String description, String status) {
        super();
        this.description = description;
        this.status = status;
    }
}
