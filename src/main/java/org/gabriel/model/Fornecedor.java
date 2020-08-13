package org.gabriel.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author daohn on 30/07/2020
 * @project ExercicioMapeamentoJPA
 */
@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Fornecedor extends PessoaJuridica implements ValueObject {

    @Builder
    public Fornecedor(String razaoSocial, String nomeFantasia) {
        super(razaoSocial, nomeFantasia);
        this.produtos = new ArrayList<>();
    }

    @Getter @ManyToMany(mappedBy = "fornecedores", fetch = FetchType.LAZY, cascade =
            CascadeType.ALL)
    private List<Produto> produtos;

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
