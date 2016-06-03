package lapr.project.model;

import classesREMOVIDAS.Expositor;
import classesREMOVIDAS.FAE;
import classesREMOVIDAS.Organizador;
import classesREMOVIDAS.Cargo;
import classesREMOVIDAS.Exposicao;
import classesREMOVIDAS.CentroExposicoes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * Representação de uma ComboBoxModel de utilizadores.
 * 
 * @author Ricardo Osório e Ana Leite
 */
public class ComboBoxModelUtilizadores extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista de Utilizadores.
     */
    private List<Cargo> listaUtilizadores;

    /**
     * Objeto selecionado.
     */
    Object selection;

    /**
     * Construtor de objetos do tipo ComboBoxModelUtilizadores cpm o parâmetro 
     * centro de exposições.
     * 
     * @param centroExposicoes centro de exposições.
     */
    public ComboBoxModelUtilizadores(CentroExposicoes centroExposicoes) {
        this.selection = null;
        this.listaUtilizadores = criarListaUtilizadores(centroExposicoes);
    }

    /**
     * Devolve o tamanho da lista de utilizadores.
     * 
     * @return tamanho da lista de utilizadores.
     */
    @Override
    public int getSize() {
        return this.listaUtilizadores.size();
    }

    /**
     * Devolve uma string com o que é mostrado na comboBox quando se faz clique.
     * 
     * @param index posição do utilizador.
     * @return string com o que é mostrado na comboBox quando se faz clique.
     */
    @Override
    public Object getElementAt(int index) {
        Cargo utilizador = this.listaUtilizadores.get(index);
        if (utilizador instanceof Organizador) {
            Organizador org = (Organizador) utilizador;
            return "Org: " + org.getUsername();
        } else if (utilizador instanceof FAE) {
            FAE fae = (FAE) utilizador;
            return "Fae: " + fae.getUtilizador().getUsername();
        } else {
            Expositor exp = (Expositor) utilizador;
            return "Exp: " + exp.getUsername();
        }
    }

    /**
     * Define o item selecionado.
     * 
     * @return item selecionado.
     */
    @Override
    public Object getSelectedItem() {
        return selection;
    }

    /**
     * Devolve o item selecionado.
     * @param anItem item selecionado.
     */
    @Override
    public void setSelectedItem(Object anItem) {
        selection = anItem;
    }

    /**
     * Devolve a lista de utilizadores.
     * 
     * @param centroExposicoes centro de exposições.
     * 
     * @return lista de utilizadores.
     */
    private List<Cargo> criarListaUtilizadores(CentroExposicoes centroExposicoes) {
        List<Cargo> listaUtilizadores = new ArrayList<>();
        for (Exposicao expo : centroExposicoes.getRegistoExposicoes().getListaExposicoes()) {
            for (Organizador organizador : expo.getRegistoOrganizadores().getListaOrganizadores()) {
                listaUtilizadores.add(organizador);
            }
            for (FAE fae : expo.getRegistoFAE().getListaFAE()) {
                listaUtilizadores.add(fae);
            }
        }
        for (Expositor expositor : centroExposicoes.getRegistoExpositor().getListaExpositor()) {
            listaUtilizadores.add(expositor);
        }
        return listaUtilizadores;
    }

}
