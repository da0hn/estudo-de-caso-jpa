package org.gabriel.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author daohn on 30/07/2020
 * @project ExercicioMapeamentoJPA
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class ItemVenda implements ValueObject {

    @Id @Getter @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    @NonNull @Getter @Setter
    private Integer quantidade;
    @NonNull @Getter @Setter @Column(precision = 2)
    private Double precoVenda;
    @NonNull @Getter @Setter @Column(precision = 2)
    private Double perDesconto;
    @NonNull @Getter @Setter @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "produto_id")
    private Produto produto;
}
