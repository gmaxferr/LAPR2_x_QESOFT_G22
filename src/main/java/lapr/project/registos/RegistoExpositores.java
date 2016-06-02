package lapr.project.registos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representação de um registo de expositor.
 *
 * @author Ana Leite e Ricardo Osório
 */
public class RegistoExpositores implements Cargo, Serializable {

    /**
     * Lista de expositores.
     */
    private List<Expositor> listaExpositores;

    /**
     * Construtor de objetos do tipo RegistoExpositor
     */
    public RegistoExpositores() {
        this.listaExpositores = new ArrayList<>();
    }

    /**
     * Devolve a lista de expositores deste centro de exposições
     *
     * @return lista de expositores
     */
    public List<Expositor> getListaExpositor() {
        return this.listaExpositores;
    }

    /**
     * Adicina um expoitor ao RegistoExpostores recebendo o utilizador por
     * parametro e apenas se já não existir na lista de Expositores e tiver o
     * seu registo confirmado
     *
     * @param utilizador utilizador a ser adicionado com expositor
     */
    public void addExpositor(Utilizador utilizador) {
        if (validaUtilizador(utilizador)) {
            this.listaExpositores.add(new Expositor(utilizador));
        }
    }

    /**
     * Verifica se o utilizador recebido por parametro já consta na lista de
     * expositores deste centro de exposições ou se o utilizador não tem o seu
     * registo confirmado
     *
     * @param utilizador utilizador a verificar
     * @return true se não existir e poder ser adicionado. False se já existir
     */
    private boolean validaUtilizador(Utilizador utilizador) {
        if (utilizador.getConfirmacaoRegisto() == false) {
            return false;
        }
        for (Expositor expositor : this.listaExpositores) {
            if (expositor.getUtilizador().equals(utilizador)) {
                return false;
            }
        }
        return true;
    }

}
