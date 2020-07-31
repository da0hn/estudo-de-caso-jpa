package org.gabriel.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author daohn on 30/07/2020
 * @project ExercicioMapeamentoJPA
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Produto implements ValueObject {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    @NonNull @Getter @Setter
    private String nome;
    @NonNull @Getter @Setter
    private Float precoVenda;
}
