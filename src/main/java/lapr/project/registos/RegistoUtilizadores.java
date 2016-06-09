package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lapr.project.model.Utilizador;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistoUtilizadores {

    /**
     * Lista de utilizadores
     */
    private final ArrayList<Utilizador> m_listaUtilizadores;

    /**
     * Construtor padrão
     */
    public RegistoUtilizadores() {
        m_listaUtilizadores = new ArrayList<>();
    }

    /**
     * Procura e retorna o Utilizador com o username recebido por parametro. Se
     * não for encontrado nenhum utilizador com esse username é devolvido null
     *
     * @param username username do utilizador a ser encontrado
     * @return Utilizador com o username caso seja encontrado. Null caso não
     * seja encontrado nenhum utilizador com esse username
     */
    public Utilizador identificarUtilizadorPeloUsername(String username) {
        for (Utilizador u : this.m_listaUtilizadores) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Método de validação: Verifica se existe algum utilizador já registado no
     * centro de exposições com o mesmo username ou com o email (estes dois
     * atributos devem ser únicos).
     *
     * @param username - username do utilizador
     * @param email - email do utilizador
     *
     * @return true se os dados nao forem repetidos ou inválidos. Caso contrário
     * retorna false
     */
    private boolean validaUtilizador(String username, String email, String nome) {
        return validaNome(nome)
                && validaUsername(username)
                && validaEmail(email);
    }

    /**
     * Verifica se o nome do utilizador é valido
     *
     * @param nome - nome a verificar
     * @return
     */
    public boolean validaNome(String nome) {
        return !nome.isEmpty();
    }

    /**
     * Para um email ser válido tem que conter, de uma forma simplificada,
     * letras seguido de um "@" com mais letras seguidas, um ponto (".") e mais
     * letras. Não pode ser vazio nem uma string null, evidentemente.
     *
     * Além desta verificação, é necessário que nenhum outro utilizador seja
     * portador deste mesmo email.
     *
     * @param email - email a validar
     * @return true se for válido; false caso contrário.
     */
    public boolean validaEmail(String email) {
        if ((email == null) || (email.trim().length() == 0)) {
            return false;
        }

        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        boolean valido = true;
        for (Utilizador u : m_listaUtilizadores) {
            if (u.getEmail().equals(email)) {
                valido = false;
            }
        }

        return matcher.matches() && valido; //se o padrão coincidir, retorna true; senão retorna false.
    }

    /**
     * valida o username verificando se já existe algum utilizador portador do
     * mesmo e se a string que contem o username não está vazia.
     *
     * @param username - username a validar.
     * @return true se for válida; false caso contrário.
     */
    public boolean validaUsername(String username) {
        boolean valido = true;
        for (Utilizador u : m_listaUtilizadores) {
            if (u.getUsername().equals(username)) {
                valido = false;
            }
        }
        return valido && !username.isEmpty();
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
        } else {
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
     * @param u Utilizador a adicionar
     * @return TRUE se foi adicionado com sucesso, FALSE caso contrário
     */
    public boolean addUtilizador(Utilizador u) {
        if (validaUtilizador(u.getUsername(), u.getEmail(), u.getNome()) && u.validaPassword(u.getPwd())) {
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

    /**
     * Procura um utilizador através do seu username
     *
     * @param username - username do utilizador a procurar
     * @return utilizador com o username enviado; null caso não encontre o
     * utilizador com esse username
     */
    public Utilizador identificarUtilizador(String username) {
        for (Utilizador utilizador : this.m_listaUtilizadores) {
            if (utilizador.getUsername().equalsIgnoreCase(username)) {
                return utilizador;
            }
        }
        return null;
    }

}
