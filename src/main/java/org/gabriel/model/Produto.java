package org.gabriel.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

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

    @Id @Getter @GeneratedValue(strategy = GenerationType.SEQUENCE) private Integer codigo;
    @NonNull @Getter @Setter private String nome;
    @NonNull @Getter @Setter private Float precoVenda;
    @Getter @Setter @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "produto_fornecedor",
               joinColumns = {@JoinColumn(name = "produto_id")},
               inverseJoinColumns = {@JoinColumn(name = "fornecedor_id")})
    private List<Fornecedor> fornecedor;
    @Getter @Setter @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "grupo_produto_id")
    private GrupoProduto grupoProduto;
}
