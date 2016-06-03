package classesREMOVIDAS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import classesREMOVIDAS.FAE;
import classesREMOVIDAS.FaeDecisao;

/**
 * Representação de um registo de FaeDecisão.
 *
 * @author Ricardo Osório e Ana Leite
 */
public class RegistoFaeDecisao implements Serializable {

    /**
     * Lista de FaeDecisão.
     */
    private List<FaeDecisao> listaFaeDecisao;

    /**
     * Construtor de objetos do tipo RegistoFaeDecisão sem parâmetros.
     */
    public RegistoFaeDecisao() {
        this.listaFaeDecisao = new ArrayList<>();
    }

    /**
     * Devolve a lista de fae.
     *
     * @return lista de fae.
     */
    public List<FAE> getListaFAE() {
        List<FAE> listaFAE = new ArrayList<>();
        for (FaeDecisao faeDecisao : this.listaFaeDecisao) {
            listaFAE.add(faeDecisao.getFAE());
        }
        return listaFAE;
    }

    /**
     * Devolvea lista de faeDecisao.
     *
     * @return lista de faeDecisao.
     */
    public List<FaeDecisao> getListaFaeDecisao() {
        return this.listaFaeDecisao;
    }

    /**
     * Adiciona um fae à lista de FaeDecisão.
     *
     * @param fae fae a ser adicionado.
     */
    public void addFaeDecisao(FAE fae) {
        if (valida(fae)) {
            this.listaFaeDecisao.add(new FaeDecisao(fae));
        }
    }

    /**
     * Valida o fae.
     *
     * @param fae fae a ser validado.
     * @return true se não encontrar p fae na lista de FaeDecisão. Caso
     * contrário retorna false.
     */
    private boolean valida(FAE fae) {
        for (FaeDecisao faeDecisao : this.listaFaeDecisao) {
            if (faeDecisao.getFAE().equals(fae)) {
                return false;
            }
        }
        return true;
    }

}
