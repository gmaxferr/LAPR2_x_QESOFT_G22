package lapr.project.model;

import java.util.TimerTask;
import lapr.project.utils.Data;

/**
 *
 * @author G29
 */
public interface Agendavel {
    public void schedule(TimerTask m_tt, Data date);
}
