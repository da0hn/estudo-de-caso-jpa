package org.gabriel.app;

import org.gabriel.model.GrupoProduto;
import org.gabriel.repositories.DAO;
import org.gabriel.repositories.EntityManagerUtil;

/**
 * @author daohn on 30/07/2020
 * @project ExercicioMapeamentoJPA
 */
public class App {
    public static void main(String... args) {
        var manager = EntityManagerUtil.getEntityManager();
        var dao = new DAO<>(manager);

        dao.open()
                .save(new GrupoProduto("grupoproduto1"))
                .save(new GrupoProduto("grupoproduto2"))
                .save(new GrupoProduto("grupoproduto3"))
                .commit();
    }
}
