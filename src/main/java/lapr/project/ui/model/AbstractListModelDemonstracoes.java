/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.model;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.Demonstracao;

/**
 *
 * @author guima
 */
public class AbstractListModelDemonstracoes extends AbstractListModel {

    private transient List<Demonstracao> m_listaDemonstracoes;

    public AbstractListModelDemonstracoes(List<Demonstracao> listaConflitos) {
        this.m_listaDemonstracoes = listaConflitos;
    }

    @Override
    public int getSize() {
        return m_listaDemonstracoes.size();
    }

    @Override
    public Object getElementAt(int i) {
        return m_listaDemonstracoes.get(i);
    }

}