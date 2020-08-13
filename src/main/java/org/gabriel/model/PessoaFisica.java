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
public class PessoaFisica extends Pessoa{

    public PessoaFisica(String nome, String RG, String CPF) {
        super(nome);
        this.RG = RG;
        this.CPF = CPF;
    }

    @NonNull @Getter @Setter
    private String RG;
    @NonNull @Getter @Setter
    private String CPF;

    public String getNome() {
        return super.nome;
    }

    public void setNome(String nome) {
        super.nome = nome;
    }

}
