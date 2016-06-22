/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.model;

import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.ConflitoDeInteresseDemonstracao;

/**
 *
 * @author guilherme
 */
public class AbstractListModelConflitosDeInteresseCandidaturaADemonstracao extends AbstractListModel {

    private List<ConflitoDeInteresseDemonstracao> listaConflitos;

    public AbstractListModelConflitosDeInteresseCandidaturaADemonstracao(List<ConflitoDeInteresseDemonstracao> listaConflitos) {
        this.listaConflitos = listaConflitos;
    }

    @Override
    public int getSize() {
        return listaConflitos.size();
    }

    @Override
    public String getElementAt(int i) {
        return listaConflitos.get(i).getCandidatura().getDadosCandidatura();
    }
}
