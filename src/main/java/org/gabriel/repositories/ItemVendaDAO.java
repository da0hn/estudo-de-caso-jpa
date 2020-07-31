package org.gabriel.repositories;

import org.gabriel.model.ItemVenda;

import javax.persistence.EntityManager;

/**
 * @author daohn on 31/07/2020
 * @project ExercicioMapeamentoJPA
 */
public class ItemVendaDAO extends DAO<ItemVenda> {

    public ItemVendaDAO(EntityManager manager) {
        super(manager, ItemVenda.class);
    }
}
