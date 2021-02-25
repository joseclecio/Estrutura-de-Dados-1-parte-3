
package br.edu.ifs.ed2.dados;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Marlos Tacio Silva
 *
 */
class TesteFila {

    /*
     * Instanciação de uma fila
     */
    private Fila<Integer> fila = new Fila<Integer>();

    /**
     * @throws java.lang.Exception
     */
    @AfterEach
    void tearDown() throws Exception {

        /*
         * Efetua a limpeza da fila antes de cada um dos testes
         */
        this.fila.limpar();
    }

    /**
     * Test method for {@link br.edu.ifs.ed2.dados.Fila#inserir(java.lang.Object)}.
     */
    @Test
    void testInserir() {

        /*
         * Teste de inserção do primeiro item
         */
        this.fila.inserir(1);
        assertEquals(this.fila.toString(), "1 -> *");

        /*
         * Teste de inserção do segundo item
         */
        this.fila.inserir(2);
        assertEquals(this.fila.toString(), "1 -> 2 -> *");

        /*
         * Teste de inserção do terceiro item
         */
        this.fila.inserir(3);
        assertEquals(this.fila.toString(), "1 -> 2 -> 3 -> *");
    }

    /**
     * Test method for {@link br.edu.ifs.ed2.dados.Fila#obterInicio()}.
     */
    @Test
    void testObterInicio() {

        /*
         * Teste de busca com a fila vazia
         */
        assertNull(this.fila.obterInicio());

        /*
         * Teste de início com a fila contendo um elemento
         */
        this.fila.inserir(1);

        assertEquals(this.fila.obterInicio(), 1);

        /*
         * Teste de início com a fila contendo mais do que um elemento
         */
        this.fila.inserir(2);

        assertEquals(this.fila.obterInicio(), 1);

        this.fila.inserir(3);

        assertEquals(this.fila.obterInicio(), 1);

        /*
         * Teste de início com a fila sendo esvaziada
         */
        this.fila.remover();

        assertEquals(this.fila.obterInicio(), 2);

        this.fila.remover();

        assertEquals(this.fila.obterInicio(), 3);

        this.fila.remover();

        assertNull(this.fila.obterInicio());
    }

    /**
     * Test method for {@link br.edu.ifs.ed2.dados.Fila#remover()}.
     */
    @Test
    void testRemover() {

        /*
         * Teste de remoção com a fila vazia
         */
        assertFalse(this.fila.remover());
        assertEquals(this.fila.toString(), "*");

        /*
         * Teste de remoção com a fila contendo um único elemento
         */
        this.fila.inserir(1);

        assertTrue(this.fila.remover());
        assertEquals(this.fila.toString(), "*");

        /*
         * Teste de remoção com a fila contendo mais do que um elemento
         */
        this.fila.inserir(1);
        this.fila.inserir(2);
        this.fila.inserir(3);

        assertTrue(this.fila.remover());
        assertEquals(this.fila.toString(), "2 -> 3 -> *");

        assertTrue(this.fila.remover());
        assertEquals(this.fila.toString(), "3 -> *");

        assertTrue(this.fila.remover());
        assertEquals(this.fila.toString(), "*");
    }

    /**
     * Test method for {@link br.edu.ifs.ed2.dados.Fila#limpar()}.
     */
    @Test
    void testLimpar() {

        /*
         * Teste de limpeza quando a fila já está vazia
         */
        this.fila.limpar();

        assertEquals(this.fila.toString(), "*");
        /*
         * Teste de limpeza quando a fila não está vazia
         */
        this.fila.inserir(1);
        this.fila.limpar();

        assertEquals(this.fila.toString(), "*");
    }
}
