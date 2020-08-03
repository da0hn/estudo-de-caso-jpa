package org.gabriel.consulta;

import org.gabriel.model.Venda;
import org.gabriel.repositories.EntityManagerUtil;

import java.util.Locale;

import static org.gabriel.util.StringUtil.center;

/**
 * @author daohn on 02/08/2020
 * @project ExercicioMapeamentoJPA
 */
public class ItemD {
    public static void main(String[] args) {
        var manager = EntityManagerUtil.getEntityManager();
        var query = manager.createQuery("select v from Venda v order by v.dataVenda", Venda.class);
        var vendas = query.getResultList();
        var format = "%1$20s%2$-2s%3$20s\n";
        for(var v : vendas) {
            System.out.format(format, center("Código", 20), "|", v.getCodigo());
            System.out.format(format, center("Data da venda", 20), "|", v.getDataVenda());
            System.out.format(format, center("Valor total", 20), "|", String.format(
                    Locale.US,
                    "%.2f", v.getValorTotal()
            ));
            System.out.println("-=-".repeat(20));
            for(var i : v.getItensVenda()) {
                System.out.format(format, center("Código", 20), "|", i.getCodigo());
                System.out.format(format, center("Quantidade", 20), "|", i.getQuantidade());
                System.out.format(format, center("Preço da venda", 20), "|", i.getPrecoVenda());
                System.out.format(format, center("Desconto", 20), "|", i.getPerDesconto());
                System.out.println("-".repeat(60));
            }
            System.out.println("-".repeat(60));
        }
    }
}
