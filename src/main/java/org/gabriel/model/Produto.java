package org.gabriel.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author daohn on 30/07/2020
 * @project ExercicioMapeamentoJPA
 */
@Entity @NoArgsConstructor @RequiredArgsConstructor @ToString @EqualsAndHashCode
public class Produto implements ValueObject {

    @Id @Getter @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    @NonNull @Getter @Setter
    private String nome;
    @NonNull @Getter @Setter
    private Float precoVenda;
    @Getter @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "produto_fornecedor",
               joinColumns = {@JoinColumn(name = "produto_id")},
               inverseJoinColumns = {@JoinColumn(name = "fornecedor_id")}
    )
    private List<Fornecedor> fornecedores = new ArrayList<>();
    @NonNull @Getter @Setter @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupo_produto_id") private GrupoProduto grupoProduto;

    public void addFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
        if(fornecedor.getProdutos().contains(this)) return;
        fornecedor.addProduto(this);
    }

    public void addFornecedores(List<Fornecedor> fornecedores) {
        fornecedores.forEach(this::addFornecedor);
    }

    public void removeFornecedor(Fornecedor fornecedor) {
        fornecedor.getProdutos().remove(this);
        fornecedores.remove(fornecedor);
    }
}
