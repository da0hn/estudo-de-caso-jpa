package org.gabriel.repositories;

import org.gabriel.model.Venda;

import javax.persistence.EntityManager;

/**
 * @author daohn on 31/07/2020
 * @project ExercicioMapeamentoJPA
 */
public class VendaDAO extends DAO<Venda> {

    public VendaDAO(EntityManager manager) {
        super(manager, Venda.class);
    }
}
