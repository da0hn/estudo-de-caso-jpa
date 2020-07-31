package org.gabriel.repositories;

import org.gabriel.model.Fornecedor;

import javax.persistence.EntityManager;

/**
 * @author daohn on 31/07/2020
 * @project ExercicioMapeamentoJPA
 */
public class FornecedorDAO extends DAO<Fornecedor>{

    public FornecedorDAO(EntityManager manager) {
        super(manager, Fornecedor.class);
    }
}
