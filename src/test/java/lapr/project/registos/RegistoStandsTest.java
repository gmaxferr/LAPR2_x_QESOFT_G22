package lapr.project.registos;

import lapr.project.exceptions.AreaErradaException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author G29
 */
public class RegistoStandsTest {

    public RegistoStandsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of criarStand method, of class RegistoStands. Testa quando é
     * introduzida uma área inválida
     */
    @Test
    public void testCriarStandComAreaInvalida() {
        System.out.println("criarStandComAreaInvalida");
        RegistoStands rStands = new RegistoStands();
        try {
            rStands.criarStand("ID1", "-15", "descricao"); //invalido - manda exceção se detetar area invalida
            fail("A area errada passou na verificação");
        } catch (AreaErradaException ex) {
            assertEquals(true, true);
        }
    }

    /**
     * Test of criarStand method, of class RegistoStands. Testa adicionar um
     * Stand com ID de outro já existente
     */
    @Test
    public void testCriarStandIDRepetido() {
        System.out.println("criarStandComIDRepetido");
        RegistoStands rStands = new RegistoStands();
        rStands.criarStand("ID1", "15", "descricao"); //valido
        boolean valida = rStands.criarStand("ID1", "16", "descricao"); //id repetido
        assertEquals(false, valida);
    }

    /**
     * Test of criarStand method, of class RegistoStands. Testa adicionar um
     * Stand com ID de outro já existente
     */
    @Test
    public void testCriarStand() {
        System.out.println("criarStand");
        RegistoStands rStands = new RegistoStands();
        rStands.criarStand("ID1", "15", "descricao"); //valido
        boolean valida = rStands.criarStand("ID2", "16", "descricao"); //id repetido
        assertEquals(true, valida);
    }
}
