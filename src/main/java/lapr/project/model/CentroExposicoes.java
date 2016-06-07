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
    private final RegistoExposicoes m_registoExposicoes;

    /**
     *
     */
    private final RegistoUtilizadores m_registoUtilizadores;

    /**
     *
     */
    private final RegistoMecanismos m_registoMecanismos;

    /**
     *
     */
    private final RegistoRecursos m_registoRecursos;

    private final RegistoTipoConflitos m_registoTipoConflitos;
    private final RegistoExpositores m_rExpositores;

    /**
     * Construtor de objectos do tipo CentroExposicoes sem parametros
     */
    public CentroExposicoes() {
        this.m_registoExposicoes = new RegistoExposicoes();
        this.m_registoUtilizadores = new RegistoUtilizadores();
        this.m_registoMecanismos = new RegistoMecanismos();
        this.m_registoRecursos = new RegistoRecursos();
        this.m_registoTipoConflitos = new RegistoTipoConflitos();
        this.m_rExpositores = new RegistoExpositores();
    }

    /**
     *
     * @return
     */
    public RegistoExposicoes getRegistoExposicoes() {
        return m_registoExposicoes;
    }

    public RegistoExpositores getRegistoExpositores() {
        return this.m_rExpositores;
    }

    /**
     * Devolve o registo de utilizadores.
     * 
     * @return registo de utilizadores
     */
    public RegistoUtilizadores getRegistoUtilizadores() {
        return m_registoUtilizadores;
    }

    /**
     *
     * @return
     */
    public RegistoMecanismos getRegistoMecanismos() {
        return m_registoMecanismos;
    }

    public RegistoRecursos getRegistoRecursos() {
        return m_registoRecursos;
    }

    public RegistoTipoConflitos getRegistoTiposConflitos() {
        return m_registoTipoConflitos;
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
