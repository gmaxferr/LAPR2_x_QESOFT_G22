package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoAceite;
import lapr.project.estados.Exposicao.EstadoExposicaoCandidaturasDecididas;
import lapr.project.estados.Exposicao.EstadoExposicaoDemonstracoesDecididas;
import lapr.project.model.AtribuicaoStand;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Expositor;
import lapr.project.model.Stand;
import lapr.project.model.Utilizador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guilherme
 */
public class AtribuirStandsControllerTest {

    public AtribuirStandsControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private AtribuirStandsController instance;
    private CentroExposicoes ce;
    private Exposicao e;
    private CandidaturaAExposicao cand;
    private Stand stand;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);
        stand = new Stand("d", 10, "id");
        cand = new CandidaturaAExposicao(new Expositor(new Utilizador()));
        cand.setEstado(new EstadoCandidaturaAExposicaoAceite(cand));
        ce.getRegistoStands().getListaStands().add(stand);
        e.getRegistoCandidaturasAExposicao().getListaCandidaturas().add(cand);
        e.setEstado(new EstadoExposicaoDemonstracoesDecididas(e));
        ce.getRegistoExposicoes().getListaExposicoes().add(e);
        instance = new AtribuirStandsController(ce);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getListaExposicoes method, of class AtribuirStandsController.
     */
    @Test
    public void testGetListaExposicoes() {
        System.out.println("getListaExposicoes");
        List<Exposicao> expResult = new ArrayList();
        expResult.add(e);
        List<Exposicao> result = instance.getListaExposicoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaCand method, of class AtribuirStandsController.
     */
    @Test
    public void testGetListaCand() {
        System.out.println("getListaCand");
        List<CandidaturaAExposicao> expResult = new ArrayList();
        expResult.add(cand);
        instance.select(e);
        List<CandidaturaAExposicao> result = instance.getListaCand();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaStands method, of class AtribuirStandsController.
     */
    @Test
    public void testGetListaStands() {
        System.out.println("getListaStands");
        List<Stand> expResult = new ArrayList();
        expResult.add(stand);
        List<Stand> result = instance.getListaStands();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAtribuicoes method, of class AtribuirStandsController.
     */
    @Test
    public void testSetAtribuicoes() {
        System.out.println("setAtribuicoes");
        List<AtribuicaoStand> listAtr = new ArrayList();
        instance.setAtribuicoes(listAtr);
    }

    /**
     * Test of confirm method, of class AtribuirStandsController.
     */
    @Test
    public void testConfirm() {
        System.out.println("confirm");
        instance.select(e);
        instance.getListaExposicoes();
        instance.getListaCand();
        instance.confirm();
    }

    /**
     * Test of select method, of class AtribuirStandsController.
     */
    @Test
    public void testSelect() {
        System.out.println("select");
        instance.select(e);
    }

}
