package org.gabriel.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
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
public class Fornecedor implements ValueObject {

    @Id @Getter @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    @Getter @Setter @NonNull
    private String razaoSocial;
    @Getter @ManyToMany(mappedBy = "fornecedores", fetch = FetchType.LAZY, cascade =
            CascadeType.ALL)
    private List<Produto> produtos = new ArrayList<>();

    public void addProduto(Produto produto) {
        produtos.add(produto);
        if(produto.getFornecedores().contains(this)) return;
        produto.addFornecedor(this);
    }

    public void addProdutos(List<Produto> produtos) {
        produtos.forEach(this::addProduto);
    }

    public void removeProduto(Produto produto) {
        produto.getFornecedores().remove(this);
        produtos.remove(produto);
    }
}
