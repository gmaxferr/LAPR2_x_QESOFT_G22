package lapr.project.model;

import classesModelERegistodePPROG.Utilizador;

/**
 * @author Ricardo Catalao
 */
public class GestorDeExposicoes {

    private Utilizador m_utilizador;

    /**
     * Construtor de objeto do tipo GestorDeExposicoes com discriminacao dos
     * seus atributos
     *
     * @param u - m_utilizador que será atribuido a este gestor de exposicoes
     */
    public GestorDeExposicoes(Utilizador u) {
        m_utilizador = u;
    }

    /**
     * @return Utilizador do gestor de exposições
     */
    public Utilizador getUtilizador() {
        return m_utilizador;
    }
}
