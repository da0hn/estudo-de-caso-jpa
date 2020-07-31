package org.gabriel.repositories.base;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author daohn on 30/07/2020
 * @project ExercicioMapeamentoJPA
 */
public class EntityManagerUtil {
    private static EntityManagerFactory factory = null;

    private EntityManagerUtil() {
    }

    static {
        factory = Persistence.createEntityManagerFactory("Vendas");
    }

    public static EntityManager getEntityManager() {
        if(factory == null) throw new IllegalStateException("Unidade de persistencia não iniciada");
        return factory.createEntityManager();
    }
}
