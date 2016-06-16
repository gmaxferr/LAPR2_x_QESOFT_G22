/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.Organizador;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class ModeloJListPotenciaisOrganizadores extends AbstractListModel {

    private List<Organizador> lstOrganizadores = new ArrayList<>();
    private Organizador orgSelecionado;
    
    public ModeloJListPotenciaisOrganizadores(List<Organizador> list) {
        lstOrganizadores = list;
    }

    public void setList(List<Organizador> list) {
        lstOrganizadores = list;
    }

    public List<Organizador> getList() {
        return lstOrganizadores;
    }

    public void setSelectedItem(int index){
        orgSelecionado = lstOrganizadores.get(index);
    }
    
    public Organizador getOrganizador() {
        Organizador o = orgSelecionado;
        lstOrganizadores.remove(orgSelecionado);
        return o;
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
