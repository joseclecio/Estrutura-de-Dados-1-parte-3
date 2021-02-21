/**
 *
 */
package br.edu.ifs.ed2.dados;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * @author Marlos Tacio Silva
 *
 */
class TesteListaDupla {

    /*
     * Instanciação de uma lista duplamente encadeada
     */
    private Lista<Integer> lista = new ListaDupla<Integer>();

    /**
     * @throws java.lang.Exception
     */
    @AfterEach
    void tearDown() throws Exception {

        /*
         * Efetua a limpeza da lista antes de cada um dos testes
         */
        this.lista.limpar();
    }

    /**
     * Test method for
     * {@link br.edu.ifs.ed2.dados.ListaDupla#inserirInicio(java.lang.Object)}.
     */
    @Test
    void testInserirInicio() {

        /*
         * Teste de inserção do primeiro item
         */
        this.lista.inserirInicio(1);
        assertEquals(this.lista.toString(), "* <-> 1 <-> *");

        /*
         * Teste de inserção do segundo item
         */
        this.lista.inserirInicio(2);
        assertEquals(this.lista.toString(), "* <-> 2 <-> 1 <-> *");

        /*
         * Teste de inserção do terceiro item
         */
        this.lista.inserirInicio(3);
        assertEquals(this.lista.toString(), "* <-> 3 <-> 2 <-> 1 <-> *");
    }

    /**
     * Test method for
     * {@link br.edu.ifs.ed2.dados.ListaDupla#inserirFim(java.lang.Object)}.
     */
    @Test
    void testInserirFim() {

        /*
         * Teste de inserção do primeiro item
         */
        this.lista.inserirFim(1);
        assertEquals(this.lista.toString(), "* <-> 1 <-> *");

        /*
         * Teste de inserção do primeiro item
         */
        this.lista.inserirFim(2);
        assertEquals(this.lista.toString(), "* <-> 1 <-> 2 <-> *");

        /*
         * Teste de inserção do primeiro item
         */
        this.lista.inserirFim(3);
        assertEquals(this.lista.toString(), "* <-> 1 <-> 2 <-> 3 <-> *");
    }

    /**
     * Test method for
     * {@link br.edu.ifs.ed2.dados.ListaDupla#remover(java.lang.Object)}.
     */
    @Test
    void testRemover() {

        /*
         * Teste de remoção com a lista vazia
         */
        assertFalse(this.lista.remover(1));
        assertEquals(this.lista.toString(), "*");

        /*
         * Teste de remoção com a lista contendo um único elemento
         */
        this.lista.inserirInicio(1);

        assertTrue(this.lista.remover(1));
        assertEquals(this.lista.toString(), "*");

        /*
         * Teste de remoção com a lista contendo mais do que um elemento
         */
        this.lista.inserirInicio(1);
        this.lista.inserirInicio(2);
        this.lista.inserirInicio(3);

        assertTrue(this.lista.remover(2));
        assertEquals(this.lista.toString(), "* <-> 3 <-> 1 <-> *");

        /*
         * Teste de remoção com a lista não contendo o elemento a ser removido
         */
        assertFalse(this.lista.remover(2));
        assertEquals(this.lista.toString(), "* <-> 3 <-> 1 <-> *");
    }

    /**
     * Test method for {@link br.edu.ifs.ed2.dados.ListaDupla#removerInicio()}.
     */
    @Test
    void testRemoverInicio() {

        /*
         * Teste de remoção com a lista vazia
         */
        assertFalse(this.lista.removerInicio());
        assertEquals(this.lista.toString(), "*");

        /*
         * Teste de remoção com a lista contendo um único elemento
         */
        this.lista.inserirInicio(1);

        assertTrue(this.lista.removerInicio());
        assertEquals(this.lista.toString(), "*");

        /*
         * Teste de remoção com a lista contendo mais do que um elemento
         */
        this.lista.inserirInicio(1);
        this.lista.inserirInicio(2);

        assertTrue(this.lista.removerInicio());
        assertEquals(this.lista.toString(), "* <-> 1 <-> *");
    }

    /**
     * Test method for {@link br.edu.ifs.ed2.dados.ListaDupla#removerFim()}.
     */
    @Test
    void testRemoverFim() {

        /*
         * Teste de remoção com a lista vazia
         */
        assertFalse(this.lista.removerFim());
        assertEquals(this.lista.toString(), "*");

        /*
         * Teste de remoção com a lista contendo um único elemento
         */
        this.lista.inserirInicio(1);

        assertTrue(this.lista.removerFim());
        assertEquals(this.lista.toString(), "*");

        /*
         * Teste de remoção com a lista contendo mais do que um elemento
         */
        this.lista.inserirInicio(1);
        this.lista.inserirInicio(2);

        assertTrue(this.lista.removerFim());
        assertEquals(this.lista.toString(), "* <-> 2 <-> *");
    }

    /**
     * Test method for
     * {@link br.edu.ifs.ed2.dados.ListaDupla#buscar(java.lang.Object)}.
     */
    @Test
    void testBuscar() {

        /*
         * Teste de busca com a lista vazia
         */
        assertNull(this.lista.buscar(1));

        /*
         * Teste de busca com a lista contendo um elemento
         */
        this.lista.inserirInicio(1);

        assertEquals(this.lista.buscar(1).getConteudo(), 1);

        /*
         * Teste de busca com a lista contendo mais do que um elemento
         */
        this.lista.inserirInicio(1);
        this.lista.inserirInicio(2);
        this.lista.inserirInicio(3);

        assertEquals(this.lista.buscar(2).getConteudo(), 2);
        assertEquals(this.lista.buscar(3).getConteudo(), 3);

        /*
         * Teste de busca com a lista não contendo o elemento a ser buscado
         */
        assertNull(this.lista.buscar(4));
    }

    /**
     * Test method for {@link br.edu.ifs.ed2.dados.ListaDupla#estaVazia()}.
     */
    @Test
    void testEstaVazia() {

        /*
         * Teste quando a lista está vazia
         */
        assertTrue(this.lista.estaVazia());

        /*
         * Teste quando a lista não está vazia
         */
        this.lista.inserirInicio(1);

        assertFalse(this.lista.estaVazia());
    }

    /**
     * Test method for {@link br.edu.ifs.ed2.dados.ListaDupla#limpar()}.
     */
    @Test
    void testLimpar() {

        /*
         * Teste de limpeza quando a lista já está vazia
         */
        this.lista.limpar();

        assertTrue(this.lista.estaVazia());

        /*
         * Teste de limpeza quando a lista não está vazia
         */
        this.lista.inserirInicio(1);
        this.lista.limpar();

        assertTrue(this.lista.estaVazia());
    }
}
