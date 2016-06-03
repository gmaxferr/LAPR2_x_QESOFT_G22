package lapr.project.model;

/**
 * Representação de um FAE
 *
 * @author Ricardo Osório Ana Leite
 */
public class FAE {

    /**
     * Atributo do FAE que representa o utilizador associado a este
     */
   private Utilizador m_Utilizador;
   
   private TipoConflito tipoConflito;
    /**
     * Construtor de objectos do tipo FAE com parametro Utilizador
     *
     * @param u Utilizador associado ao FAE
     */
    public FAE(Utilizador u) {
        //copiar todos os dados das variaveis de instância
    }

    /**
     * Construtor de objectos do tipo FAE sem parametros
     */
    public FAE() {

    }

    /**
     * Devolve o Utilizador atualmente associado ao FAE
     *
     * @return Utilizador associado ao FAE
     */
    public Utilizador getUtilizador() {
        return m_Utilizador;
    }

    /**
     * Define um novo utilizador associado ao FAE
     *
     * @param u novo Utilizador
     */
    public void setUtilizador(Utilizador u) {
        this.m_Utilizador = u;
    }

    /**
     * Devolve uma string com a descrição do objecto FAE, isto é, com os seus
     * atributos
     *
     * @return descrição do FAE
     */
    @Override
    public String toString() {
        String str = "FAE:\n";
        str += "\tUser: " + this.m_Utilizador.getM_strNome() + "\n";

        return str;
    }

    public boolean validaTipoConflito(TipoConflito tipoConflito) {
    //verifica o tipo de conflito
        return true;
    }

    public void setTipoConflitoFAE(TipoConflito tipoConflito) {
        this.tipoConflito = tipoConflito;
    }
}
