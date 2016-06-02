package lapr.project.registos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Utilizador;

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

    /**
     * Identifica um utilizador com o dado username e retorna-o
     *
     * @param username Username do utilizador a encontrar
     * @return Retorna o utilizador cujo username é igual ao passado como
     * argumento, se existir. Se não existir, retorna null.
     */
    public Utilizador identificarUtilizador(String username) {
        for (Utilizador u : listaUtilizadores) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Valida se o username e o email passados como argumento são únicos, isto
     * é, não existe sequer um utilizador com qualquer um destes dados na lista
     * de utilizadores guardada por este registo.
     *
     * @param username username a verificar se é única
     * @param email email a verificar se é único
     * @return Retorna TRUE se ambos forem únicos, FALSE caso contrário
     */
    public boolean validaDadosUnicos(String username, String email) {
        for (Utilizador u : listaUtilizadores) {
            if (u.getUsername().equals(username)
                    || u.getE_mail().equals(email)) {
                return false;
            }
        }
        return true;
    }
}
