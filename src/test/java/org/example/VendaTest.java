package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendaTest {
    private Produto produto;
    private Venda venda;

    @BeforeEach
    public void setUp() {
        produto = new Produto("Copo", 4.6, 14);
    }

    @Test
    public void vendaComQuantidadeMenorQueEstoque() {

        int quantidade = 12;

        venda = new Venda(produto, quantidade);
        venda.realizarVenda();

        Assertions.assertEquals(produto, venda.getProduto());
        Assertions.assertEquals(quantidade, venda.getQuantidadeVendida());

    }

    @Test
    public void vendaComQuantidadeIgualEstoque() {

        int quantidade = 14;

        venda = new Venda(produto, quantidade);
        venda.realizarVenda();

        Assertions.assertEquals(produto, venda.getProduto());
        Assertions.assertEquals(quantidade, venda.getQuantidadeVendida());

    }

    @Test
    public void vendaComQuantidadeMaiorQueEstoque() {

        int quantidade = 16;

        venda = new Venda(produto, quantidade);
        venda.realizarVenda();


        Assertions.assertEquals(produto, venda.getProduto());
        Assertions.assertEquals(quantidade, venda.getQuantidadeVendida());

    }

    @Test
    public void calculoTotalDaVenda() {

        int quantidade = 12;

        venda = new Venda(produto, quantidade);
        venda.realizarVenda();

        double valorTotal = venda.getQuantidadeVendida() * produto.getPreco();


        Assertions.assertEquals(valorTotal, venda.getTotalVenda());


    }

    @Test
    public void valorTotalAposVenda() {

        int quantidade = 12;

        venda = new Venda(produto, quantidade);
        venda.realizarVenda();

        double valorTotal = venda.getQuantidadeVendida() * produto.getPreco();


        Assertions.assertEquals(valorTotal, venda.getTotalVenda());


    }

    @Test
    public void venderProdutoInexistente(){
        int quantidade = 12;

        venda = new Venda(produto, quantidade);
        boolean resultado = venda.realizarVenda();

        Assertions.assertEquals(true,resultado); //nao consegui fazer

    }

    @Test
    public void vendaComQuantidadeNegativa(){
        int quantidade = -4;
        venda = new Venda(produto,quantidade);


        Assertions.assertEquals(produto,venda.getProduto());
        Assertions.assertEquals(quantidade, venda.getQuantidadeVendida());
    }

    @Test
    public void alteracaoDoEstoqueAposEstoqueInsuficienteNaVenda() {

        int quantidade = 16;
        int esperado = produto.getEstoque() + 12;

        venda = new Venda(produto, quantidade);
        venda.realizarVenda();



        produto.aumentarEstoque(12);
        int resultado = produto.getEstoque();


        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void criarVariosProdutosEVender(){
        int estoque = 12;

        Produto produto1 = new Produto("Colher",2.2, estoque);
        venda = new Venda(produto1,2);
        venda.realizarVenda();

        Produto produto2 = new Produto("Faca",3.0, produto1.getEstoque());
        Venda venda2 = new Venda(produto2,2);
        venda2.realizarVenda();

        Assertions.assertEquals(10, produto1.getEstoque());
        Assertions.assertEquals(8, produto2.getEstoque());
    }

    @Test
    public void vendaComPrecoAlteradoAntesDaVenda(){
        produto.setPreco(12.00);

        venda = new Venda(produto, 5);
        venda.getTotalVenda();
        double valor = 12*5;

        venda.realizarVenda();

        Assertions.assertEquals(valor,venda.getTotalVenda());
    }

    @Test
    public void vendaComEstoqueZero(){
        Produto produto1 = new Produto("camisa",30.0,0);

        venda = new Venda(produto1, 2);


        Assertions.assertEquals(false,venda.realizarVenda());
    }

    @Test
    public void alterarEstoqueEVender(){
        produto.setEstoque(12);

        venda = new Venda(produto, 5);

        Assertions.assertEquals(true,venda.realizarVenda());

    }



}
