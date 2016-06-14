/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.Utilizador;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class ModeloJListPotenciaisOrganizadores extends AbstractListModel {

    private List<Utilizador> lstUtilizadores;

    public void setList(List<Utilizador>list){
        lstUtilizadores = list;
    }
    
    public void add(Utilizador user){
        lstUtilizadores.add(user);
    }
    
    public void remove(int index){
        lstUtilizadores.remove(index);
    }
    
    @Override
    public int getSize() {
        return lstUtilizadores.size();
    }

    @Override
    public Object getElementAt(int index) {
        return lstUtilizadores.get(index);
    }

}
