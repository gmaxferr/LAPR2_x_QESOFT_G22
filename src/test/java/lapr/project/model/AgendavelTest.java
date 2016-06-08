/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.TimerTask;
import lapr.project.utils.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Catalao
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
    
    @Before
    public void setUp() {
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
        TimerTask m_tt = null;
        Data date = null;
        Agendavel instance = new AgendavelImpl();
        instance.schedule(m_tt, date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AgendavelImpl implements Agendavel {

        public void schedule(TimerTask m_tt, Data date) {
        }
    }
}
