package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.AtribuicaoStand;

/**
 *
 * @author Ricardo Catalao
 */
public class RegistoAtribuicoesStands {

    private List<AtribuicaoStand> m_listaAtribuicoesStand;

    public RegistoAtribuicoesStands() {
        this.m_listaAtribuicoesStand = new ArrayList<>();
    }

    /**
     * @return the listaAtribuicoesStand
     */
    public List<AtribuicaoStand> getListaAtribuicoesStand() {
        return m_listaAtribuicoesStand;
    }

    /**
     * @param listaAtribuicoesStand the listaAtribuicoesStand to set
     */
    public void setListaAtribuicoesStand(List<AtribuicaoStand> listaAtribuicoesStand) {
        this.m_listaAtribuicoesStand = listaAtribuicoesStand;
    }

    /**
     * @param listAtr Adiciona todas as atribuicoes passadas como argumento à
     * lista de atribuicoes de stands
     */
    public void addAll(List<AtribuicaoStand> listAtr) {
        m_listaAtribuicoesStand.addAll(listAtr);
    }

}
