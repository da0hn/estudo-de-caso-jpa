package org.gabriel.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
@Getter
public class Vendedor extends PessoaFisica implements ValueObject {

    @Builder
    public Vendedor(Float perComissao, String nome, String RG, String CPF) {
        super(nome, RG, CPF);
        this.perComissao = perComissao;
        this.vendas = new ArrayList<>();
    }

    @Setter
    private Float perComissao;

    @OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Venda> vendas;

    public void addVendas(Venda venda) {
        venda.setVendedor(this);
        vendas.add(venda);
    }

    public void removeVendas(Venda venda) {
        vendas.remove(venda);
        venda.setVendedor(null);
    }

    public void addVendas(List<Venda> vendas) {
        vendas.forEach(this::addVendas);
    }

    public double getValorTotalComissao() {
        return getVendas().stream().mapToDouble(Venda::getValorComissao).sum();
    }
}
