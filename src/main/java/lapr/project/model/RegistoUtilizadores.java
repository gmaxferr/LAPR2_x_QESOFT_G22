package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representação de um Registo de Utilizadores.
 *
 * @author Ricardo Osório e Ana Leite
 */
public class RegistoUtilizadores implements Serializable {

    /**
     * Lista de utilizadores.
     */
    private List<Utilizador> listaUtilizadores;

    /**
     * Construtor de objetos do tipo RegistoUtilizadores sem paramentros.
     */
    public RegistoUtilizadores() {
        this.listaUtilizadores = new ArrayList<>();
    }

    /**
     * Devolve a lista de utilizadores.
     *
     * @return lista de utilizadores.
     */
    public List<Utilizador> getListaUtilizadores() {
        return this.listaUtilizadores;
    }

    /**
     * Adiciona um utilizador àmlista de utilizadores.
     *
     * @param utilizador utilizador a ser adicionado.
     */
    public void addUtilizador(Utilizador utilizador) {
        if (validarUtilizador(utilizador)) {
            this.listaUtilizadores.add(utilizador);
        }
    }

    /**
     * Validar o utilizador através do email ou do username.
     *
     * @param utilizador utilizador a validar.
     * @return true se não encontrar o utilizador na lista de utilizadores. Caso
     * contrário retorna false.
     */
    private boolean validarUtilizador(Utilizador utilizador) {
        for (Utilizador u : listaUtilizadores) {
            if (u.getE_mail().equalsIgnoreCase(utilizador.getE_mail())
                    || u.getUsername().equalsIgnoreCase(utilizador.getUsername())) {
                return false;
            }
        }
        return true;
    }
}
