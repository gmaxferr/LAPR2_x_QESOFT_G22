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

    private EstadoCandidaturaADemonstracao m_estado;

    public CandidaturaADemonstracao(String dados) {
        this.m_dados = dados;
        m_estado = new EstadoCandidaturaADemonstracaoInstanciada();
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
    public void setEstado(EstadoCandidaturaADemonstracao estado2) {
        m_estado = estado2;
    }
}
