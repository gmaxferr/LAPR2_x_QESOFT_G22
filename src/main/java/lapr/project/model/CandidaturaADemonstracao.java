package lapr.project.model;

import lapr.project.estados.EstadoCandidaturaADemonstracao;
import lapr.project.estados.EstadoCandidaturaADemonstracaoInstanciada;

/**
 *
 * @author guima
 */
public class CandidaturaADemonstracao {

    /**
     * Não sabemos como é constituida uma candidatura a uma demonstração, por
     * isso optamos apenas por descreve-la com uma string que representa todos
     * os possíveis atributos que esta candidtura possa ter.
     */
    private String m_dados;
    private String m_usernameExpositor;

    private EstadoCandidaturaADemonstracao m_estado;

    public CandidaturaADemonstracao(String dados, String username) {
        this.m_dados = dados;
        m_estado = new EstadoCandidaturaADemonstracaoInstanciada(this);
        m_usernameExpositor = username;
    }

    /**
     * 
     * @return dados da candidatura 
     */
    public String getM_dadosCandidatura(){
        return m_dados;
    }
    
    /**
     * 
     * @return username do expositor 
     */
    public String getM_usernameExpositor(){
        return m_usernameExpositor;
    }
    
    /**
     * @return estado desta candidatura a demonstracao
     */
    public EstadoCandidaturaADemonstracao getEstado() {
        return m_estado;
    }

    /**
     * Altera o estado da candidatura
     *
     * @param estado2 - novo estado da candidatura
     */
    public void setEstado(EstadoCandidaturaADemonstracao novoEstado) {
        m_estado = novoEstado;
    }
}
