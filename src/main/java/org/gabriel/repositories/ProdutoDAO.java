package org.gabriel.repositories;

import org.gabriel.model.Produto;

import javax.persistence.EntityManager;

/**
 * @author daohn on 31/07/2020
 * @project ExercicioMapeamentoJPA
 */
public class ProdutoDAO extends DAO<Produto> {
    public ProdutoDAO(EntityManager manager) {
        super(manager, Produto.class);
    }
}
