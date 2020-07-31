package org.gabriel.repositories;

import org.gabriel.model.Cliente;

import javax.persistence.EntityManager;

/**
 * @author daohn on 31/07/2020
 * @project ExercicioMapeamentoJPA
 */
public class ClienteDAO extends DAO<Cliente> {

    public ClienteDAO(EntityManager manager) {
        super(manager, Cliente.class);
    }
}
