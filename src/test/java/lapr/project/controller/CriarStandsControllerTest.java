package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Stand;
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
public class CriarStandsControllerTest {

    public CriarStandsControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private CriarStandsController instance;
    private final String descricao = "desc";
    private final String id = "id1";
    private final String area = "15";
    private Stand stand;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        instance = new CriarStandsController(ce);
        stand = new Stand("desc", 20, "id2");
        ce.getRegistoStands().getListaStands().add(stand);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRegistoStands method, of class CriarStandsController.
     */
    @Test
    public void testGetRegistoStands() {
        System.out.println("getRegistoStands");
        instance.getRegistoStands();
    }

    /**
     * Test of getListaStands method, of class CriarStandsController.
     */
    @Test
    public void testGetListaStands() {
        System.out.println("getListaStands");
        List<Stand> expResult = new ArrayList();
        expResult.add(stand);
        instance.getRegistoStands();
        List<Stand> result = instance.getListaStands();
        assertEquals(expResult, result);
    }

    /**
     * Test of criarStand method, of class CriarStandsController.
     */
    @Test
    public void testCriarStand() {
        System.out.println("criarStand");
        boolean expResult = true;
        instance.getRegistoStands();
        boolean result = instance.criarStand(id, area, descricao);
        assertEquals(expResult, result);
    }

}
