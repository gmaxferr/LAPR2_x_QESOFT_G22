package classesREMOVIDAS;

import java.io.Serializable;
import lapr.project.registos.RegistoMecanismos;

/**
 * Representação de um Centro de Exposições
 *
 * @author Ricardo Osório e Ana Leite
 */
public class CentroExposicoes implements Serializable {

    /**
     * Registo de exposições do centro de exposições.
     */
    private RegistoExposicoes re;

    /**
     * Registo de mecanismos do centro de exposições.
     */
    private RegistoMecanismos rm;

    /**
     * Registo de utilizadores do centro de exposições.
     */
    private RegistoUtilizadores ru;

    /**
     * Registo de recursos do centro de exposições.
     */
    private RegistoRecursos rr;

    /**
     * Registo de expositores do centro de exposições.
     */
    private RegistoExpositores rExpositor;

    /**
     * Construtor de objectos do tipo CentroExposições sem parâmetros.
     */
    public CentroExposicoes() {
        this.re = new RegistoExposicoes();
        this.rm = new RegistoMecanismos();
        this.ru = new RegistoUtilizadores();
        this.rr = new RegistoRecursos();
        this.rExpositor = new RegistoExpositores();
    }

    /**
     * Devolve o registo de exposições do centro de exposições.
     *
     * @return registo de exposições do centro de exposições.
     */
    public RegistoExposicoes getRegistoExposicoes() {
        return this.re;
    }

    /**
     * Devolve o registo de expositor do centro de exposições.
     *
     * @return registo de expositor do centro de exposições.
     */
    public RegistoExpositores getRegistoExpositor() {
        return this.rExpositor;
    }

    /**
     * Devolve o registo de mecanismos do centro de exposições.
     *
     * @return registo de mecanismos do centro de exposições.
     */
    public RegistoMecanismos getRegistoMecanismos() {
        return this.rm;
    }

    /**
     * Devolve o registo de utilizadores do centro de exposições.
     *
     * @return registo de utilizadores do centro de exposições.
     */
    public RegistoUtilizadores getRegistoUtilizadores() {
        return this.ru;
    }

    /**
     * Devolve o registo de recursos do centro de exposições.
     *
     * @return reigisto de recursos do centro de exposições.
     */
    public RegistoRecursos getRegistoRecursos() {
        return this.rr;
    }

    /**
     * Adicina um expoitor ao RegistoExpostores recebendo o utilizador por
     * parametro e apenas se já não existir na lista de Expositores e tiver o
     * seu registo confirmado
     *
     * @param utilizador utilizador a ser adicionado com expositor
     */
    public void addExpositor(Utilizador utilizador) {
        this.rExpositor.addExpositor(utilizador);
    }
}
