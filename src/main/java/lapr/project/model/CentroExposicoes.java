package lapr.project.model;

import java.util.List;
import lapr.project.registos.RegistoRecursos;
import lapr.project.registos.RegistoMecanismos;
import lapr.project.registos.RegistoTipoConflitos;
import lapr.project.registos.RegistoUtilizadores;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.registos.RegistoExpositores;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Node;

/**
 * Representação de um Centro de Exposições
 *
 * @author Ricardo Osório Ana Leite
 */
public class CentroExposicoes implements Importable<CentroExposicoes>, Exportable{

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
     * Devolve o registo de exposições
     * 
     * @return registo de exposições
     */
    public RegistoExposicoes getRegistoExposicoes() {
        return m_registoExposicoes;
    }

    /**
     * Devolve o registo de expositores
     * 
     * @return registo de expositores
     */
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
     * Devolve o registo de mecanismos
     * 
     * @return registo de mecanismos
     */
    public RegistoMecanismos getRegistoMecanismos() {
        return m_registoMecanismos;
    }

    /**
     * Devolve o registo de recursos
     * 
     * @return registo de recursos
     */
    public RegistoRecursos getRegistoRecursos() {
        return m_registoRecursos;
    }

    /**
     * Devolve o registo de tipos de conflitos
     * 
     * @return registo de tipos de conflitos
     */
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
            if (expositor.getM_strEmail().equalsIgnoreCase(m_StrUsername)) {
                return expositor;
            }
        }
        return null;
    }
    
     public List<Expositor> getListaExpositores() {
        return this.m_rExpositores.getListaExpositores();
    }

    @Override
    public CentroExposicoes importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node exportContentToXMLNode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}