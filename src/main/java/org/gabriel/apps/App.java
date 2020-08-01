package org.gabriel.apps;

import org.gabriel.model.Cliente;
import org.gabriel.model.Fornecedor;
import org.gabriel.model.GrupoProduto;
import org.gabriel.model.ItemVenda;
import org.gabriel.model.Produto;
import org.gabriel.model.Venda;
import org.gabriel.model.Vendedor;
import org.gabriel.repositories.DAO;
import org.gabriel.repositories.EntityManagerUtil;

import java.time.LocalDate;
import java.util.Collections;

import static java.util.Arrays.asList;

/**
 * @author daohn on 30/07/2020
 * @project ExercicioMapeamentoJPA
 */
public class App {
    public static void main(String... args) {
        populate();
    }

    private static void populate() {
        var dao = new DAO<>(EntityManagerUtil.getEntityManager());

        var grupoProduto1 = new GrupoProduto("grupoproduto1");
        var grupoProduto2 = new GrupoProduto("grupoproduto2");
        var grupoProduto3 = new GrupoProduto("grupoproduto6");
        var grupoProduto4 = new GrupoProduto("grupoproduto7");

        var produto1 = new Produto("produto1", 25.79f, grupoProduto1);
        var produto2 = new Produto("produto2", 28.12f, grupoProduto2);
        var produto3 = new Produto("produto3", 123.53f, grupoProduto2);
        var produto4 = new Produto("produto4", 2745.42f, grupoProduto3);
        var produto5 = new Produto("produto7", 213.86f, grupoProduto3);
        var produto6 = new Produto("produto8", 124.7f, grupoProduto4);

        var fornecedor1 = new Fornecedor("fornecedor1");
        var fornecedor2 = new Fornecedor("fornecedor2");
        var fornecedor3 = new Fornecedor("fornecedor3");
        var fornecedor4 = new Fornecedor("fornecedor4");
        var fornecedor5 = new Fornecedor("fornecedor5");

        produto1.addFornecedores(asList(fornecedor1, fornecedor2, fornecedor3));
        produto2.addFornecedores(asList(fornecedor2, fornecedor3, fornecedor5));
        produto3.addFornecedores(asList(fornecedor1, fornecedor3, fornecedor4));
        produto4.addFornecedores(asList(fornecedor1, fornecedor2, fornecedor4, fornecedor5));
        produto5.addFornecedores(asList(fornecedor4, fornecedor5));
        produto6.addFornecedores(asList(fornecedor1, fornecedor3, fornecedor5));

        var itemVenda1 = new ItemVenda(1, 31.34, 43.98, produto1);
        var itemVenda2 = new ItemVenda(7, 21.75, 12.87, produto1);
        var itemVenda3 = new ItemVenda(1, 41.122, 15.67, produto2);
        var itemVenda4 = new ItemVenda(11, 11.875, 83.15, produto2);
        var itemVenda5 = new ItemVenda(21, 11.124, 74.12, produto2);
        var itemVenda6 = new ItemVenda(10, 64.864, 56.99, produto1);
        var itemVenda7 = new ItemVenda(7, 75.785, 89.57, produto3);
        var itemVenda8 = new ItemVenda(8, 90.124, 99.53, produto4);
        var itemVenda9 = new ItemVenda(14, 1.99, 12.68, produto4);
        var itemVenda10 = new ItemVenda(6, 2.89, 125.64, produto4);
        var itemVenda11 = new ItemVenda(57, 90.124, 99.53, produto3);
        var itemVenda12 = new ItemVenda(34, 1.99, 12.68, produto5);
        var itemVenda13 = new ItemVenda(12, 2.89, 125.64, produto5);
        var itemVenda14 = new ItemVenda(74, 90.124, 99.53, produto6);
        var itemVenda15 = new ItemVenda(1, 1.99, 12.68, produto6);
        var itemVenda16 = new ItemVenda(6, 2.89, 125.64, produto3);


        var venda1 = new Venda(LocalDate.now()
                                       .minusDays(11)
                                       .minusMonths(35)
                                       .plusDays(12));
        var venda2 = new Venda(LocalDate.now()
                                       .minusDays(9)
                                       .minusMonths(13));
        var venda3 = new Venda(LocalDate.now()
                                       .minusDays(24)
                                       .minusMonths(57));
        var venda4 = new Venda(LocalDate.now()
                                       .minusDays(12)
                                       .minusMonths(12));
        var venda5 = new Venda(LocalDate.now()
                                       .minusDays(8)
                                       .minusMonths(4));
        var venda6 = new Venda(LocalDate.now()
                                       .minusDays(3)
                                       .minusMonths(5));
        var venda7 = new Venda(LocalDate.now()
                                       .minusDays(1)
                                       .minusMonths(2));

        var vendedor1 = new Vendedor("vendedor1", 15f);
        var vendedor2 = new Vendedor("vendedor2", 15f);
        var vendedor3 = new Vendedor("vendedor3", 15f);

        var cliente1 = new Cliente("cliente1");
        var cliente2 = new Cliente("cliente2");
        var cliente3 = new Cliente("cliente3");

        venda1.setItensVenda(asList(itemVenda1, itemVenda2));
        venda2.setItensVenda(asList(itemVenda3, itemVenda4, itemVenda5));
        venda3.setItensVenda(asList(itemVenda6, itemVenda1, itemVenda4));
        venda4.setItensVenda(asList(itemVenda7, itemVenda8, itemVenda4, itemVenda9));
        venda5.setItensVenda(asList(itemVenda10, itemVenda11, itemVenda16, itemVenda15));
        venda6.setItensVenda(asList(itemVenda12, itemVenda13, itemVenda14, itemVenda11));
        venda7.setItensVenda(asList(itemVenda15, itemVenda16));

        cliente1.addVendas(asList(venda1, venda2, venda3));
        cliente2.addVendas(asList(venda4, venda5));
        cliente3.addVendas(asList(venda6, venda7));

        vendedor1.addVendas(asList(venda1, venda4, venda5));
        vendedor2.addVendas(asList(venda2, venda3, venda6));
        vendedor3.addVendas(Collections.singletonList(venda7));


        dao.begin()
                .save(asList(grupoProduto1, grupoProduto2, grupoProduto3, grupoProduto4))
                .save(asList(fornecedor1, fornecedor2, fornecedor3, fornecedor4, fornecedor5))
                .save(asList(produto1, produto2, produto3, produto4, produto5, produto6))
                .save(asList(itemVenda1, itemVenda2, itemVenda3, itemVenda4, itemVenda5, itemVenda6,
                             itemVenda7, itemVenda8, itemVenda9, itemVenda10, itemVenda11,
                             itemVenda12, itemVenda13, itemVenda14, itemVenda15, itemVenda16
                ))
                .save(asList(venda1, venda2, venda3, venda4, venda5, venda6, venda7))
                .save(asList(vendedor1, vendedor2, vendedor3))
                .save(asList(cliente1, cliente2, cliente3))
                .commit();
        dao.fechar();
    }
}
