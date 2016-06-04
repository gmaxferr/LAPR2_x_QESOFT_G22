package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Utilizador;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistoUtilizadores {

    private ArrayList<Utilizador> listaUtilizadores;

    Utilizador u;

    public Utilizador identificarUtilizadorPeloID(String id) {
        Utilizador u = identificarUtilizadorID(id);
        boolean b = validaUtilizador();
        if (b == true) {
            return u;
        } else {
            return null;
        }
    }

    private Utilizador identificarUtilizadorID(String ID) {
        for (Utilizador u : this.listaUtilizadores) {
            if (u.getID().equalsIgnoreCase("id")) {
                return u;
            }
        }
        return null;
    }

    private boolean validaUtilizador() {
        //valida o utilizador globalmente (repetido, etc).
        return true;
    }

    /**
     * Lista de utilizadores registados
     */
    private ArrayList<Utilizador> m_listaUtilizadores;

    /**
     * Método que devolve lista dos Utilizadores
     *
     * @return lista dos utilizadores
     */
    public List<Utilizador> getListaUtilizadores() {
        return m_listaUtilizadores;
    }

    /**
     * Método que devolve um Utilizador identificado pelo seu ID
     *
     * @param id forma de identificar o Utilizador, pode ser o seu nome ou email
     * @return o dado Utilizador se encontrar ou então devolve null
     */
    public Utilizador getUtilizador(String id) {
        for (int i = 0; i < m_listaUtilizadores.size(); i++) {
            if (identificarUtilizadorPeloId(id)) {
                return m_listaUtilizadores.get(i);
            }
        }
        return null;
    }

    /**
     * Método que retorna um Utilizador dado um ID (nome ou email)
     *
     * @param id forma de identificar o Utilizador, pode ser o seu nome ou email
     * @return o dado Utilizador se encontrar ou então devolve null
     */
    public boolean identificarUtilizadorPeloId(String id) {
        //verifica no arraylist de todos os utilziadores
        return true;
    }

    public Utilizador novoUtilizador() {
        return new Utilizador();
    }

    /**
     * Métdo que valida (globalmente) e em caso de sucesso adiciona o Utilizador
     *
     * @param u Utilizador desejado
     */
    public void addUtilizador(Utilizador u) {
        if (validaUtilizador() == true) {
            adicionaUtilizador(u);
        } else {
            //reverte as alterações da adição deste utilizador
        }
    }

    private void adicionaUtilizador(Utilizador u) {
        listaUtilizadores.add(u);
    }

    /**
     * Método que devolve uma lista com os novos registos (registos ainda nao
     * confirmados)
     *
     * @return lista de novos registos
     */
    public ArrayList<Utilizador> getListaNovosRegistos() {
        ArrayList<Utilizador> list = new ArrayList<>();
        for (Utilizador u : listaUtilizadores) {
            if (u.getM_boolConfirmaRegisto() == false) {
                list.add(u);
            }
        }
        return list;
    }

    public Utilizador identificarUtilizador(String username) {
        for (Utilizador utilizador : this.listaUtilizadores) {
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
