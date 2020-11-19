package com.multbroker.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "estoque_acoes_usuario",schema = "multbroker")
@Data
@EqualsAndHashCode
@ToString
public class EstoqueAcoes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_estoque_acoes")
    @SequenceGenerator(name = "sq_estoque_acoes", sequenceName = "sq_estoque_acoes", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "action_fk", referencedColumnName = "id")
    private Action action;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_fk", referencedColumnName = "id")
    private UserEntity userEntity;

    private Integer quantidade;


}
