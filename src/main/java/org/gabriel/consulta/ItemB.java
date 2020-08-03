package org.gabriel.consulta;

import org.gabriel.model.Produto;
import org.gabriel.repositories.EntityManagerUtil;
import org.gabriel.repositories.ProdutoDAO;

import static org.gabriel.util.StringUtil.center;

/**
 * @author daohn on 02/08/2020
 * @project ExercicioMapeamentoJPA
 */
public class ItemB {
    /**
     * Listar todos os produtos cadastrador, ordenados por nome (código, nome, preço de venda, nome
     * do grupo de produto e seus fornecedores (código e razão social))
     */
    public static void main(String[] args) {
        var dao = new ProdutoDAO(EntityManagerUtil.getEntityManager());
        var produtos = dao.findAll();

        var format = "%1$20s%2$-2s%3$20s\n";
        System.out.println("-".repeat(50));
        for(Produto p : produtos) {
            System.out.format(format, center("Código", 20), "|", p.getCodigo());
            System.out.format(format, center("Nome", 20), "|", p.getNome());
            System.out.format(format, center("Preço de venda", 20), "|", p.getPrecoVenda());
            System.out.format(format, center("Grupo do produto", 20), "|",
                              p.getGrupoProduto().getNome()
            );
            System.out.println("-".repeat(50));
            for(var f : p.getFornecedores()) {
                System.out.format(format, center("Nome Produto", 20), "|", p.getNome());
                System.out.format(format, center("Código", 20), "|", f.getCodigo());
                System.out.format(format, center("Nome", 20), "|", f.getRazaoSocial());
                System.out.println("-".repeat(50));
            }
        }
    }
}
