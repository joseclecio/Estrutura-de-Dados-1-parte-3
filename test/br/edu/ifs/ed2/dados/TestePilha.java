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
class TestePilha {

    /*
     * Instanciação de uma pilha
     */
    private Pilha<Integer> pilha = new Pilha<Integer>();

    /**
     * @throws java.lang.Exception
     */
    @AfterEach
    void tearDown() throws Exception {

        /*
         * Efetua a limpeza da pilha antes de cada um dos testes
         */
        this.pilha.limpar();
    }

    /**
     * Test method for {@link br.edu.ifs.ed2.dados.Pilha#inserir(java.lang.Object)}.
     */
    @Test
    void testInserir() {

        /*
         * Teste de inserção do primeiro item
         */
        this.pilha.inserir(1);
        assertEquals(this.pilha.toString(), "1\n*");

        /*
         * Teste de inserção do segundo item
         */
        this.pilha.inserir(2);
        assertEquals(this.pilha.toString(), "2\n1\n*");

        /*
         * Teste de inserção do terceiro item
         */
        this.pilha.inserir(3);
        assertEquals(this.pilha.toString(), "3\n2\n1\n*");
    }

    /**
     * Test method for {@link br.edu.ifs.ed2.dados.Pilha#obterTopo()}.
     */
    @Test
    void testObterTopo() {

        /*
         * Teste de busca com a pilha vazia
         */
        assertNull(this.pilha.obterTopo());

        /*
         * Teste de topo com a pilha contendo um elemento
         */
        this.pilha.inserir(1);

        assertEquals(this.pilha.obterTopo(), 1);

        /*
         * Teste de topo com a pilha contendo mais do que um elemento
         */
        this.pilha.inserir(2);

        assertEquals(this.pilha.obterTopo(), 2);

        this.pilha.inserir(3);

        assertEquals(this.pilha.obterTopo(), 3);

        /*
         * Teste de topo com a pilha sendo esvaziada
         */
        this.pilha.remover();

        assertEquals(this.pilha.obterTopo(), 2);

        this.pilha.remover();

        assertEquals(this.pilha.obterTopo(), 1);

        this.pilha.remover();

        assertNull(this.pilha.obterTopo());
    }

    /**
     * Test method for {@link br.edu.ifs.ed2.dados.Pilha#remover()}.
     */
    @Test
    void testRemover() {

        /*
         * Teste de remoção com a pilha vazia
         */
        assertFalse(this.pilha.remover());
        assertEquals(this.pilha.toString(), "*");

        /*
         * Teste de remoção com a pilha contendo um único elemento
         */
        this.pilha.inserir(1);

        assertTrue(this.pilha.remover());
        assertEquals(this.pilha.toString(), "*");

        /*
         * Teste de remoção com a pilha contendo mais do que um elemento
         */
        this.pilha.inserir(1);
        this.pilha.inserir(2);
        this.pilha.inserir(3);

        assertTrue(this.pilha.remover());
        assertEquals(this.pilha.toString(), "2\n1\n*");

        assertTrue(this.pilha.remover());
        assertEquals(this.pilha.toString(), "1\n*");

        assertTrue(this.pilha.remover());
        assertEquals(this.pilha.toString(), "*");
    }

    /**
     * Test method for {@link br.edu.ifs.ed2.dados.Pilha#limpar()}.
     */
    @Test
    void testLimpar() {

        /*
         * Teste de limpeza quando a pilha já está vazia
         */
        this.pilha.limpar();

        assertEquals(this.pilha.toString(), "*");
        /*
         * Teste de limpeza quando a pilha não está vazia
         */
        this.pilha.inserir(1);
        this.pilha.limpar();

        assertEquals(this.pilha.toString(), "*");
    }
}
