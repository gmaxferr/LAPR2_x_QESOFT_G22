package classesModelERegistoDeESOFT;

import java.util.ArrayList;

/**
 * Representação de um Centro de Exposições
 *
 * @author Ricardo Osório Ana Leite
 */
public class CentroExposicoes {

    /**
     * Lista de Exposicoes usada segundo pedido de varias métodos
     */
    public static ArrayList<Exposicao> listaExpo;

    /**
     * Lista de registos de utilizadores usada segundo pedido de varias metodos
     */
    public static ArrayList<Utilizador> listaReg;

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
    /**
     * Construtor de objectos do tipo CentroExposicoes sem parametros
     */
    public CentroExposicoes() {
        this.registoExposicoes = new RegistoExposicoes();
        this.registoUtilizadores = new RegistoUtilizadores();
        this.registoMecanismos = new RegistoMecanismos();
        this.registoRecursos = new RegistoRecursos();
        this.registoTipoConflitos = new RegistoTipoConflitos();
    }

    /**
     *
     * @return
     */
    public RegistoExposicoes getRegistoExposicoes() {
        return registoExposicoes;
    }

    /**
     *
     * @return
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

    public RegistoTipoConflitos getRegistoTiposConflitos(){
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
}
