package org.gabriel.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * @author daohn on 13/08/2020
 * @project ExercicioMapeamentoJPA
 */

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class PessoaJuridica extends Pessoa {

    public PessoaJuridica(String razaoSocial, String nomeFantasia) {
        super(nomeFantasia);
        this.razaoSocial = razaoSocial;
    }

    @NonNull @Getter @Setter
    private String razaoSocial;

    public String getNomeFantasia() {
        return super.nome;
    }

    public void setNomeFantasia(String nome) {
        super.nome = nome;
    }
}
