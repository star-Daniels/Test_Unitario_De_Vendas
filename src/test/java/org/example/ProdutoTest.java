

package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProdutoTest {
    private Produto produto;
    private Venda venda;

    @Test
    public void criarProdutoComValoresValidos() {

        String nome = "Faca";
        Double preco = 12.0;
        int estoque = 7;

        this.produto = new Produto(nome, preco, estoque);

        Assertions.assertEquals(nome, this.produto.getNome());
        Assertions.assertEquals(preco, this.produto.getPreco());
        Assertions.assertEquals(estoque, this.produto.getEstoque());
    }

    @Test
    public void criarProdutoComPrecoNegativo() {

        String nome = "liquidificador";
        Double preco = -42.0;
        int estoque = 7;

        this.produto = new Produto(nome, preco, estoque);

        Assertions.assertEquals(nome, this.produto.getNome());
        Assertions.assertEquals(preco, this.produto.getPreco());
        Assertions.assertEquals(estoque, this.produto.getEstoque());
    }

    @Test
    public void criarProdutoComEstoqueNegativo() {

        String nome = "garfo";
        Double preco = 3.0;
        int estoque = -39;

        this.produto = new Produto(nome, preco, estoque);

        Assertions.assertEquals(nome, this.produto.getNome());
        Assertions.assertEquals(preco, this.produto.getPreco());
        Assertions.assertEquals(estoque, this.produto.getEstoque());
    }

    @Test
    public void alterarNomeDoProdutoParaValorValido() {

        String nome = "Faca";
        Double preco = 12.0;
        int estoque = 7;

        this.produto = new Produto(nome, preco, estoque);
        this.produto.setNome("Colher");

        Assertions.assertEquals("Colher", this.produto.getNome());
    }

    @Test
    public void mudarPrecoDoProdutoParaValorValido() {

        String nome = "liquidificador";
        Double preco = -42.0;
        int estoque = 7;

        this.produto = new Produto(nome, preco, estoque);
        this.produto.setPreco(42.0);

        Assertions.assertEquals(42.0, this.produto.getPreco());
    }

    @Test
    public void mudarEstoqueDoProdutoParaValorValido() {

        String nome = "garfo";
        Double preco = 3.0;
        int estoque = -9;

        this.produto = new Produto(nome, preco, estoque);
        this.produto.setEstoque(39);

        Assertions.assertEquals(39, this.produto.getEstoque());
    }

    @Test
    public void mudarPrecoDoProdutoParaValorNegativo() {

        String nome = "garfo";
        Double preco = 3.0;
        int estoque = 9;

        this.produto = new Produto(nome, preco, estoque);
        this.produto.setPreco(-2.5);

        Assertions.assertEquals(-2.5, this.produto.getPreco());
    }

    @Test
    public void aumentarEstoqueDepoisDaVenda() {

        String nome = "garfo";
        Double preco = 3.0;
        int estoque = 9;
        int aumento = 5;
        int quantidade = 1;

        produto = new Produto(nome, preco, estoque);
        venda = new Venda(produto,quantidade);

        venda.realizarVenda();
        int novoEstoque = produto.getEstoque() + aumento;
        produto.aumentarEstoque(aumento);

        Assertions.assertEquals(novoEstoque, this.produto.getEstoque());
    }

    @Test
    public void diminuirEstoqueDepoisDaVenda() {

        String nome = "garfo";
        Double preco = 3.0;
        int estoque = 9;
        int decremento = 4;
        int quantidade = 1;


        produto = new Produto(nome, preco, estoque);
        venda = new Venda(produto,quantidade);
        venda.realizarVenda();

        int novoEstoque = produto.getEstoque();





        Assertions.assertEquals(novoEstoque, produto.getEstoque());
    }

    @Test
    public void diminuirEstoqueDepoisDaVendaComVendaMaiorQueEstoque() {

        String nome = "garfo";
        Double preco = 3.0;
        int estoque = 6;
        int decremento = 19;
        int novoEstoque = estoque - decremento;

        this.produto = new Produto(nome, preco, estoque);
        this.produto.diminuirEstoque(decremento);


        Assertions.assertEquals(estoque, this.produto.getEstoque());
    }
}
