package org.gabriel.app;

import org.gabriel.model.Venda;
import org.gabriel.repositories.base.DAO;
import org.gabriel.repositories.base.EntityManagerUtil;

import javax.persistence.EntityManager;

/**
 * @author daohn on 30/07/2020
 * @project ExercicioMapeamentoJPA
 */
public class App {
    public static void main(String[] args) {
        var manager = EntityManagerUtil.getEntityManager();
        DAO<Venda> vendaDAO = new DAO<>(manager, Venda.class);
    }
}
