package org.gabriel.consulta;

import org.gabriel.model.Vendedor;
import org.gabriel.repositories.EntityManagerUtil;

import java.util.Locale;

import static org.gabriel.util.StringUtil.center;

/**
 * @author daohn on 02/08/2020
 * @project ExercicioMapeamentoJPA
 */
public class ItemE {
    public static void main(String[] args) {
        var manager = EntityManagerUtil.getEntityManager();
        var query = manager.createQuery("select v from Vendedor v order by v.nome", Vendedor.class);
        var vendedores = query.getResultList();
        var format = "%1$30s%2$-2s%3$20s\n";
        System.out.println("-".repeat(60));
        for(Vendedor v : vendedores) {
            System.out.format(format, center("Código", 30), "|", v.getCodigo());
            System.out.format(format, center("Nome", 30), "|", v.getNome());
            System.out.format(format, center("Comissão [%]", 30), "|", v.getPerComissao());
            System.out.println("-".repeat(60));
            for(var venda : v.getVendas()) {
                System.out.format(format, center("Código", 30), "|", venda.getCodigo());
                System.out.format(format, center("Nome", 30), "|", v.getNome());
                System.out.format(format, center("Data da venda", 30), "|", venda.getDataVenda());
                System.out.format(format, center("Comissão da venda", 30), "|",
                                  String.format(Locale.US, "%.2f", venda.getValorComissao()));
            }
            System.out.format(format, center("Valor total da comissão", 30), "|",
                              String.format(Locale.US, "%.2f", v.getValorTotalComissao()));
            System.out.println("=-=".repeat(20));
        }
    }
}
