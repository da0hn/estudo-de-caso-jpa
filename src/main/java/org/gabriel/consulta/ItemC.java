package org.gabriel.consulta;

import org.gabriel.model.Cliente;
import org.gabriel.model.Venda;
import org.gabriel.repositories.EntityManagerUtil;

import static org.gabriel.util.StringUtil.center;

/**
 * @author daohn on 02/08/2020
 * @project ExercicioMapeamentoJPA
 */
public class ItemC {
    /**
     * Listar todos os clientes cadastrados, ordenados por nome (código, nome, quantidade
     * de vendas que já foram realizadas para ele).
     */
    public static void main(String[] args) {
        var manager = EntityManagerUtil.getEntityManager();
        var query = manager.createQuery("select c from Cliente c order by c.nome", Cliente.class);
        var clientes = query.getResultList();
        var format = "%1$20s%2$-2s%3$20s\n";
        for(Cliente c : clientes) {
            System.out.format(format, center("Código", 20), "|", c.getCodigo());
            System.out.format(format, center("Nome", 20), "|", c.getNome());
            System.out.format(format, center("Quantidade de vendas", 20), "|", c.getVendas().size());
            System.out.println("-".repeat(50));
            for(Venda v : c.getVendas()) {
                System.out.format(format, center("Código", 20), "|", v.getCodigo());
                System.out.format(format, center("Nome do Cliente", 20), "|", c.getNome());
                System.out.format(format, center("Data da venda", 20), "|", v.getDataVenda());
                System.out.println("-".repeat(50));
            }
        }
    }
}
