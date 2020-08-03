package org.gabriel.consulta;

import org.gabriel.model.Fornecedor;
import org.gabriel.model.Produto;
import org.gabriel.repositories.EntityManagerUtil;

import java.sql.SQLOutput;

/**
 * @author daohn on 02/08/2020
 * @project ExercicioMapeamentoJPA
 */
public class ItemA {

    /**
     * Listar todos os fornecedores cadastrados, ordenados por razão social (código e nome) e os
     * produtos que ele fornece (código, nome do produto)
     */
    public static void main(String[] args) {
        var manager = EntityManagerUtil.getEntityManager();
        var query = manager.createQuery(
                "select f from Fornecedor f order by f.razaoSocial",
                Fornecedor.class
        );
        var resultado = query.getResultList();

        for(Fornecedor f : resultado) {
            System.out.println("Id: " + f.getCodigo());
            System.out.println("Razão social: " + f.getRazaoSocial());

            for(Produto p : f.getProdutos()) {
                System.out.println("\t\tId: " + p.getCodigo());
                System.out.println("\t\tNome: " + p.getNome());
            }
        }
    }
}
