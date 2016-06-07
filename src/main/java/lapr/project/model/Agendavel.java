/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.TimerTask;
import lapr.project.utils.Data;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public interface Agendavel {
    public void schedule(TimerTask m_tt, Data date);
}
