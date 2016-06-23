/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.uiModel;

import lapr.project.uiModel.AbstractListModelConflitosDeInteresseCandidaturaAExposicao;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.ConflitoDeInteresse;
import lapr.project.model.Expositor;
import lapr.project.model.FAE;
import lapr.project.model.TipoConflito;
import lapr.project.model.Utilizador;
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
public class AbstractListModelConflitosDeInteresseCandidaturaAExposicaoTest {

    public AbstractListModelConflitosDeInteresseCandidaturaAExposicaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private AbstractListModelConflitosDeInteresseCandidaturaAExposicao instance;
    private List<ConflitoDeInteresse> listaConflitos;
    private ConflitoDeInteresse conf;

    @Before
    public void setUp() {

        listaConflitos = new ArrayList<>();
        conf = new ConflitoDeInteresse(new FAE(new Utilizador()), new CandidaturaAExposicao(new Expositor(new Utilizador())), new TipoConflito("idTipo"));
        listaConflitos.add(conf);
        instance = new AbstractListModelConflitosDeInteresseCandidaturaAExposicao(listaConflitos);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSize method, of class
     * AbstractListModelConflitosDeInteresseCandidaturaAExposicao.
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
     * AbstractListModelConflitosDeInteresseCandidaturaAExposicao.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int i = 0;
        ConflitoDeInteresse expResult = conf;
        ConflitoDeInteresse result = (ConflitoDeInteresse) instance.getElementAt(i);
        assertEquals(expResult, result);
    }

}
