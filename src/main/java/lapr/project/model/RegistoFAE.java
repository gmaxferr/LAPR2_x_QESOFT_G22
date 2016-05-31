package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representação de um registo de FAE.
 *
 * @author Ana Leite e Ricardo Osório
 */
public class RegistoFAE implements Serializable {

    /**
     * Lista de FAE
     */
    private List<FAE> listaFAE;

    /**
     * Exposição que tem este registo de FAE
     */
    private Exposicao exposicao;

    /**
     * Construtor de objetos do tipo RegistoFAE sem parâmetros.
     *
     * @param exposicao
     */
    public RegistoFAE(Exposicao exposicao) {
        this.listaFAE = new ArrayList<>();
        this.exposicao = exposicao;
    }

    /**
     * Devolve a lista de FAE.
     *
     * @return lista de FAE.
     */
    public List<FAE> getListaFAE() {
        return this.listaFAE;
    }

    /**
     * Adiciona um fae à lista de FAE da exposição. Método unicamente usado para
     * instanciação inicial de vários objectos para testar o programa - não
     * recorre a nenhuma verificação.
     *
     * @param fae FAE a ser adicionado.
     */
    public void addFAE(FAE fae) {
        this.listaFAE.add(fae);
    }

    /**
     * Adiciona um utilizador à lista de FAE se não existir já na lista de FAE
     * desta exposição
     *
     * @param utilizador utilizador a ser adiciona como fae desta exposição
     * @param experiencia experiência do fae nesta posição
     */
    public void addFAE(Utilizador utilizador, int experiencia) {
        if (validarUtilizador(utilizador)) {
            this.listaFAE.add(new FAE(utilizador, experiencia));
        }
    }

    /**
     * Verifica se o utilizador recebido por parametro já não esta associado
     * como FAE a esta exposição ou se o utilizador não tem o seu registo
     * confirmado
     *
     * @param utilizador utilizador a validar
     * @return true se não encontrar o utilizador na lista de FAE. Caso
     * contrário retorna false.
     */
    private boolean validarUtilizador(Utilizador utilizador) {
        if (utilizador.getConfirmacaoRegisto() == false) {
            return false;
        }
        for (FAE fae : this.listaFAE) {
            if (fae.getUtilizador().equals(utilizador)) {
                return false;
            }
        }
        return true;
    }

}
