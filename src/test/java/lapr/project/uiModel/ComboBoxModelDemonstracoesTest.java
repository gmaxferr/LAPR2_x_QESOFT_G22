/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.uiModel;

import lapr.project.uiModel.ComboBoxModelDemonstracoes;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstracao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guima
 */
public class ComboBoxModelDemonstracoesTest {

    public ComboBoxModelDemonstracoesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private ComboBoxModelDemonstracoes instance;
    List<Demonstracao> listaDemonstracoes;
    private Demonstracao demo;
    private String descricao;

    @Before
    public void setUp() {
        descricao = "desc";
        demo = new Demonstracao(descricao);
        listaDemonstracoes = new ArrayList<>();
        listaDemonstracoes.add(demo);
        instance = new ComboBoxModelDemonstracoes(listaDemonstracoes);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSize method, of class
     * ComboBoxModelDemonstracoes.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getElementAt method, of class
     * ComboBoxModelDemonstracoes.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int index = 0;
        Object expResult = demo.getCodigoIdentificacao();
        Object result = instance.getElementAt(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of setSelectedItem method, of class
     * ComboBoxModelDemonstracoes.
     */
    @Test
    public void testSetSelectedItem() {
        System.out.println("setSelectedItem");
        Object anItem = demo.getCodigoIdentificacao();
        instance.setSelectedItem(anItem);
    }

    /**
     * Test of getSelectedItem method, of class
     * ComboBoxModelDemonstracoes.
     */
    @Test
    public void testGetSelectedItem() {
        System.out.println("getSelectedItem");

        instance.setSelectedItem(demo.getCodigoIdentificacao());
        Object expResult = demo.getCodigoIdentificacao();
        Object result = instance.getSelectedItem();
        assertEquals(expResult, result);
    }

}
