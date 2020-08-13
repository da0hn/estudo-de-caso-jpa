package org.gabriel.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@Getter
public class Cliente extends PessoaFisica implements ValueObject {

    @Builder
    public Cliente(Float limiteCredito, String nome, String RG, String CPF) {
        super(nome, RG, CPF);
        this.limiteCredito = limiteCredito;
        this.vendas = new ArrayList<>();
    }

    @Setter @Column(precision = 2)
    private Float limiteCredito;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Venda> vendas;

    public void addVendas(Venda venda) {
        venda.setCliente(this);
        vendas.add(venda);
    }

    public void removeVendas(Venda venda) {
        vendas.remove(venda);
        venda.setCliente(null);
    }

    public void addVendas(List<Venda> vendas) {
        vendas.forEach(this::addVendas);
    }
}
