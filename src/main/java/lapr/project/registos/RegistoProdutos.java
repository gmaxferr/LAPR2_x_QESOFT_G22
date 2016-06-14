package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.Produto;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Representação de um registo de produtos
 * 
 * @author Ana Leite Ricardo Osório
 */
public class RegistoProdutos implements Importable<RegistoProdutos>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "RegistoProdutos";

    /**
     * Lista de produtos 
     */
    private List<Produto> m_ProdutosExpor;

    /**
     * Construtor de objetos do tipo RegistoProdutos sem parâmetros
     */
    public RegistoProdutos() {
        m_ProdutosExpor = new ArrayList<>();
    }

    /**
     * Devolve a lista de organizadores
     * 
     * @return lista de organizadores
     */
    public List<Produto> getListaProdutosAExpor() {
        return this.m_ProdutosExpor;
    }

    /**
     * Devolve as caraterísticas dos produtos do registo de produtos.
     * 
     * @return caraterísticas dos produtos do registo de produtos
     */
    @Override
    public String toString() {
        String str = "";
        for (Produto produto : this.m_ProdutosExpor) {
            str += produto.getNome() + "\n";
        }
        return str;
    }

    /**
     * Cria um novo produto à Candidatura
     *
     * @param nome novo produto associado à Candidatura
     *
     * @return produto criado
     */
    public Produto criarProduto(String nome) {
        Produto produto = new Produto(nome);
        m_ProdutosExpor.add(produto);
        return produto;
    }

    /**
     * Valida e adiciona um novo produto
     *
     * @param produto produto a ser validado e adicionado
     * @return true se o produto foi adicionado, caso contrário retorna false
     */
    public boolean adicionaProduto(Produto produto) {
        boolean b = validarProduto(produto);
        if (b) {
            addProduto(produto);
        }
        return b;
    }

    /**
     * Adiciona um produto de Candidatura
     *
     * @param p produto a ser adicionado
     */
    public void addProduto(Produto p) {
        this.m_ProdutosExpor.add(p);
    }

    /**
     * Valida um produto.
     *
     * @param produtoCriado produto a validar.
     * @return true se não encontrar o produto na lista de produtos. Caso
     * contrário retorna false.
     */
    private boolean validarProduto(Produto produtoCriado) {
        for (Produto produto : this.m_ProdutosExpor) {
            if (produtoCriado.equals(produto)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Valida os dados repetidos pu invalidos de Candidatura
     *
     * @return boolean com a confirmação da validação
     */
    public boolean validarDadosRepetidosOuInvalidos() {
        return true;
    }

    /**
     * Modifica a lista de produtos
     * 
     * @param listaProdutos nova lista de produtos
     */
    public void setListaProdutos(List<Produto> listaProdutos) {
        this.m_ProdutosExpor = listaProdutos;
    }

    /**
     * Compara o RegistoProdutos a outro objecto passado por parametro. A comparação
     * entre dois RegistoProdutos é feita com atenção a alguns todos os atributos
     * desta.
     *
     * @param obj objecto a comparar com o RegistoProdutos
     * @return true se o objeto recebido representar um RegistoProdutos equivalente
     * ao RegistoProdutos. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof RegistoProdutos) {
            RegistoProdutos rp = (RegistoProdutos) obj;
            return this.getListaProdutosAExpor().containsAll(rp.getListaProdutosAExpor());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.m_ProdutosExpor);
        return hash;
    }

    @Override
    public RegistoProdutos importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_ProdutosExpor.clear();

                NodeList nList = elem.getElementsByTagName(Produto.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    Produto prod = new Produto();
                    prod.importContentFromXMLNode(n2);
                    m_ProdutosExpor.add(prod);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoProdutos.class.getName()).log(Level.SEVERE, null, ex);
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

            for (Produto p : m_ProdutosExpor) {
                Node n = p.exportContentToXMLNode();
                elementKeyword.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
