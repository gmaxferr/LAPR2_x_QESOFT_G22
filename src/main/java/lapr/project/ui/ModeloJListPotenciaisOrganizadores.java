/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.Organizador;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class ModeloJListPotenciaisOrganizadores extends AbstractListModel {

    private List<Organizador> lstOrganizadores;

    public void setList(List<Organizador>list){
        lstOrganizadores = list;
    }
    
    public void add(Organizador user){
        lstOrganizadores.add(user);
    }
    
    public void remove(int index){
        lstOrganizadores.remove(index);
    }
    
    public List<Organizador> getList(){
        return lstOrganizadores;
    }
    
    @Override
    public int getSize() {
        return lstOrganizadores.size();
    }

    @Override
    public Object getElementAt(int index) {
        return lstOrganizadores.get(index);
    }

}
