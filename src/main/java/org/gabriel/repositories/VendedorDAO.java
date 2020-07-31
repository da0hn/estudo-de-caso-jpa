package org.gabriel.repositories;

import org.gabriel.model.Vendedor;

import javax.persistence.EntityManager;

/**
 * @author daohn on 31/07/2020
 * @project ExercicioMapeamentoJPA
 */
public class VendedorDAO extends DAO<Vendedor> {
    public VendedorDAO(EntityManager manager) {
        super(manager, Vendedor.class);
    }
}
