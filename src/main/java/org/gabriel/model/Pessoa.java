package org.gabriel.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author daohn on 13/08/2020
 * @project ExercicioMapeamentoJPA
 */
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    public Pessoa(String nome) {
        this.nome = nome;
    }

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codigo;

    @Getter @Setter
    protected String nome;
}
