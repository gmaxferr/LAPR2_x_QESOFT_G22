package lapr.project.model;

import lapr.project.registos.RegistoRecursos;
import lapr.project.registos.RegistoMecanismos;
import lapr.project.registos.RegistoTipoConflitos;
import lapr.project.registos.RegistoUtilizadores;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.registos.RegistoExpositores;

/**
 * Representação de um Centro de Exposições
 *
 * @author Ricardo Osório Ana Leite
 */
public class CentroExposicoes {

    /**
     *
     */
    private RegistoExposicoes registoExposicoes;

    /**
     *
     */
    private RegistoUtilizadores registoUtilizadores;

    /**
     *
     */
    private RegistoMecanismos registoMecanismos;

    /**
     *
     */
    private RegistoRecursos registoRecursos;

    private RegistoTipoConflitos registoTipoConflitos;
    private final RegistoExpositores rExpositores;

    /**
     * Construtor de objectos do tipo CentroExposicoes sem parametros
     */
    public CentroExposicoes() {
        this.registoExposicoes = new RegistoExposicoes();
        this.registoUtilizadores = new RegistoUtilizadores();
        this.registoMecanismos = new RegistoMecanismos();
        this.registoRecursos = new RegistoRecursos();
        this.registoTipoConflitos = new RegistoTipoConflitos();
        this.rExpositores = new RegistoExpositores();
    }

    /**
     *
     * @return
     */
    public RegistoExposicoes getRegistoExposicoes() {
        return registoExposicoes;
    }

    public RegistoExpositores getRegistoExpositores() {
        return this.rExpositores;
    }

    /**
     * Devolve o registo de utilizadores.
     * 
     * @return registo de utilizadores
     */
    public RegistoUtilizadores getRegistoUtilizadores() {
        return registoUtilizadores;
    }

    /**
     *
     * @return
     */
    public RegistoMecanismos getRegistoMecanismos() {
        return registoMecanismos;
    }

    public RegistoRecursos getRegistoRecursos() {
        return registoRecursos;
    }

    public RegistoTipoConflitos getRegistoTiposConflitos() {
        return registoTipoConflitos;
    }

    /**
     * Método que regista a confirmação de um registo de utilizador
     *
     * @param u Utilizador desejado
     */
    public void setUtilizadorRegistado(Utilizador u) {
        //para testar
        Exposicao expo = new Exposicao();
        u.setUtilizadorRegistado();

    }

    /**
     * Método que devolve um novo Utilizador
     *
     * @return novo Utilizador
     */
    public Utilizador novoUtilizador() {
        return new Utilizador();
    }

    public Expositor getExpositorPeloUsername(String m_StrUsername) {
        for (Expositor expositor : this.getRegistoExpositores().getListaExpositores()) {
            if (expositor.getM_strUsername().equalsIgnoreCase(m_StrUsername)) {
                return expositor;
            }
        }
        return null;
    }
}
