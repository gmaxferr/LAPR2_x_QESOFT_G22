package lapr.project.registos;

import java.util.*;
import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.exceptions.*;
import lapr.project.model.Utilizador;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação um registo de utilizadores
 * 
 * @author Ricardo Osório Ana Leite
 */
public class RegistoUtilizadores implements Importable<RegistoUtilizadores>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "RegistoUtilizadores";

    /**
     * Lista de utilizadores
     */
    private final ArrayList<Utilizador> m_listaUtilizadores;

    /**
     * Construtor de objectos do tipo RegistoUtilizadores sem parametros
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
    private boolean validaUsernameEEmailDoUtilizador(String username, String email) {
        return validaUsername(username)
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
     * Para o email ser válido é necessário que nenhum outro utilizador seja
     * portador deste mesmo email.
     *
     * @param email - email a validar
     * @return true se for válido; false caso contrário.
     */
    public boolean validaEmail(String email) {
        boolean valido = true;
        if ((email == null) || (email.trim().length() == 0)) {
            for (Utilizador u : m_listaUtilizadores) {
                if (u.getEmail().equals(email)) {
                    valido = false;
                }
            }
        }
        return valido;

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
        return valido;
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
     * Cria um novo utilizador
     *
     * @return utilizador criado
     */
    public Utilizador novoUtilizador() {
        return new Utilizador();
    }

    /**
     * Confirma o registo de todos os utilizadores registados no centro de
     * exposições atual. Este método é usado apenas na primeira execução do
     * programa.
     */
    public void confirmarRegistoTodosUtilizadores() {
        for (Utilizador utilizador : m_listaUtilizadores) {
            utilizador.confirmarRegistoDoUtilizador();
        }
    }

    /**
     * Valida (globalmente) e em caso de sucesso adiciona o Utilizador
     *
     * @param u Utilizador a adicionar
     * @return TRUE se foi adicionado com sucesso, FALSE caso contrário
     */
    public boolean addUtilizador(Utilizador u) throws InvalidPasswordException, InvalidEmailException {
        if (validaUsernameEEmailDoUtilizador(u.getUsername(), u.getEmail()) && u.validaPassword()) {
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
            if (u.getConfirmacaoRegisto() == false) {
                list.add(u);
            }
        }
        return list;
    }

    @Override
    public RegistoUtilizadores importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_listaUtilizadores.clear();

                NodeList nList = elem.getElementsByTagName(Utilizador.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    Utilizador u = new Utilizador();
                    u.importContentFromXMLNode(n2);
                    m_listaUtilizadores.add(u);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoUtilizadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element elementKeyword = document.createElement(ROOT_ELEMENT_NAME);

            for (Utilizador u : m_listaUtilizadores) {
                Node n = u.exportContentToXMLNode();
                elementKeyword.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoUtilizadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
