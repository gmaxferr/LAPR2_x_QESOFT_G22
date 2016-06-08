package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Utilizador;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistoUtilizadores {

    /**
     * Lista de utilizadores
     */
    private ArrayList<Utilizador> m_listaUtilizadores;

    /**
     * Utilizador
     */
    Utilizador u;

    public Utilizador identificarUtilizadorPeloUsername(String id) {
        Utilizador u = identificarUtilizadorID(id);
        boolean b = validaUtilizadorPeloID();
        if (b == true) {
            return u;
        } else {
            return null;
        }
    }

    private Utilizador identificarUtilizadorID(String ID) {
        for (Utilizador u : this.m_listaUtilizadores) {
            if (u.getID().equalsIgnoreCase("id")) {
                return u;
            }
        }
        return null;
    }

    /**
     * Valida o utilizador pelo username ou pelo email
     *
     * @param username username do utilizador
     * @param email email do utilizador
     *
     * @return true se os dados nao forem repetidos ou inválidos. Caso contrário
     * retorna false
     */
    private boolean validaUtilizador(String username, String email) {
        ArrayList<Utilizador> list = new ArrayList<>();
        for (Utilizador u : m_listaUtilizadores) {
            if (username.equals(u.getUsername()) || email.equals(u.getEmail())) {
                return false;
            }
        }
        return true;

    }

    public boolean validaUtilizadorPeloID() {
        return true;
    }

    /**
     * Ddevolve lista dos Utilizadores
     *
     * @return lista dos utilizadores
     */
    public List<Utilizador> getListaUtilizadores() {
        return m_listaUtilizadores;
    }

    /**
     * Devolve um Utilizador identificado pelo seu ID
     *
     * @param id forma de identificar o Utilizador, pode ser o seu nome ou email
     * @return o dado Utilizador se encontrar ou então devolve null
     */
    public Utilizador getUtilizador(String id) {
        for (Utilizador u : m_listaUtilizadores) {
            if (identificarUtilizadorPeloId(id, u.getEmail(), u.getUsername())) {
                return u;
}
        }
        return null;
    }

    /**
     * Retorna um Utilizador dado um ID (nome ou email)
     *
     * @param id forma de identificar o Utilizador, pode ser o seu nome ou email
     * @return o dado Utilizador se encontrar ou então devolve null
     */
    public boolean identificarUtilizadorPeloId(String id, String emailAVerificar, String usernameAVerificar) {
        if (id.equals(emailAVerificar) || id.equals(usernameAVerificar)) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * Cria um novo utilizador
     *
     * @return utilizador criado
     */
    public Utilizador novoUtilizador() {
        return new Utilizador();
    }

    /**
     * Valida (globalmente) e em caso de sucesso adiciona o Utilizador
     *
     * @param u Utilizador desejado
     */
    public boolean addUtilizador(Utilizador u) {
        if (validaUtilizador(u.getUsername(), u.getEmail())) {
            adicionaUtilizador(u);
            return true;
        }
        return false;
    }

    /**
     * Adiciona um utiliador à lista de utilizadores
     *
     * @param u utilizador a adicionar
     */
    private void adicionaUtilizador(Utilizador u) {
        m_listaUtilizadores.add(u);
    }

    /**
     * Devolve uma lista com os novos registos (registos ainda nao confirmados)
     *
     * @return lista de novos registos
     */
    public ArrayList<Utilizador> getListaNovosRegistos() {
        ArrayList<Utilizador> list = new ArrayList<>();
        for (Utilizador u : m_listaUtilizadores) {
            if (u.getBoolConfirmaRegisto() == false) {
                list.add(u);
            }
        }
        return list;
    }

    public Utilizador identificarUtilizador(String username) {
        for (Utilizador utilizador : this.m_listaUtilizadores) {
            if (utilizador.getUsername().equalsIgnoreCase(username)) {
                return utilizador;
            }
        }
        return null;
    }

    public boolean validaDadosUnicos(String username, String email) {
        return true;
    }
}
