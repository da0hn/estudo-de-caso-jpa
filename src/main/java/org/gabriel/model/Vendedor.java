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
import javax.persistence.OneToMany;
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
public class Vendedor implements ValueObject {
    @Id @Getter @GeneratedValue(strategy = GenerationType.SEQUENCE) private Integer codigo;

    @NonNull @Getter @Setter private String nome;

    @NonNull @Getter @Setter private Float perComissao;

    @Getter @Setter
    @OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Venda> vendas = new ArrayList<>();

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
}
