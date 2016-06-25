package lapr.project.model;

import java.util.Timer;
import java.util.TimerTask;
import lapr.project.timerTasks.expo.AlterarParaAbertaCandidaturas;
import lapr.project.utils.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G29
 */
public class AgendavelTest {

    public AgendavelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private Agendavel instance;
    private Exposicao e;

    @Before
    public void setUp() {
        CentroExposicoes ce = new CentroExposicoes();
        e = new Exposicao(ce);
        instance = new AgendavelImpl();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of schedule method, of class Agendavel.
     */
    @Test
    public void testSchedule() {
        System.out.println("schedule");
        TimerTask m_tt = new AlterarParaAbertaCandidaturas(e);
        Data date = new Data(2016, 8, 15);
        instance.schedule(m_tt, date);
    }

    public class AgendavelImpl implements Agendavel {

        public void schedule(TimerTask m_tt, Data date) {
            Timer timer = new Timer();
            timer.schedule(m_tt, date.toDate());
        }
    }

}
