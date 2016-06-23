package lapr.project.model;


/**
 * Representação de um gestor de exposições
 * 
 * @author G29
 */
public class GestorDeExposicoes {

    /**
     * Utilizador por detrás do papel de gestor de exposições
     */
    private Utilizador m_utilizador;

    /**
     * Construtor de objeto do tipo GestorDeExposicoes com o parâmetro 
     * utilizador
     *
     * @param u - m_utilizador que será atribuido a este gestor de exposicoes
     */
    public GestorDeExposicoes(Utilizador u) {
        m_utilizador = u;
    }

    /**
     * Devolve o utilizador por detrás do papel de utilizador
     * 
     * @return Utilizador do gestor de exposições
     */
    public Utilizador getUtilizador() {
        return m_utilizador;
    }
}
