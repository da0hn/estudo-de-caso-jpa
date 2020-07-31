package org.gabriel.repositories;

import org.gabriel.model.GrupoProduto;

import javax.persistence.EntityManager;

/**
 * @author daohn on 31/07/2020
 * @project ExercicioMapeamentoJPA
 */
public class GrupoProdutoDAO extends DAO<GrupoProduto> {

    public GrupoProdutoDAO(EntityManager manager) {
        super(manager, GrupoProduto.class);
    }
}
