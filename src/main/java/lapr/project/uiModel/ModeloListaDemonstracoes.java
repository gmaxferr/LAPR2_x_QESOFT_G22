package lapr.project.uiModel;
import java.util.List;
import javax.swing.AbstractListModel;
import lapr.project.model.Demonstracao;
import lapr.project.model.ListaDemonstracoes;

/**
 * Representação de um Modelo Lista de Demonstrações.
 * 
 * @author G29
 */
public class ModeloListaDemonstracoes extends AbstractListModel {

    /**
     * Lista de demonstrações
     */
    private transient ListaDemonstracoes listaDemonstracoes;

    /**
     * Construtor de obejtos do tipo ModeloListaDemonstracoes com o parametro
     * lista de demonstrações
     * 
     * @param listaDemonstracoes lista de demonstrações
     */
    public ModeloListaDemonstracoes(ListaDemonstracoes listaDemonstracoes) {
        this.listaDemonstracoes = listaDemonstracoes;
    }

    /**
     * Devolve a lista de demonstrações
     * 
     * @return lista de demonstrações
     */
    public List<Demonstracao> getListaDemonstracoesAdicionadas() {
        return this.listaDemonstracoes.getListaDemonstracoesAdicionadas();
    }

    /**
     * Devolve o tamanho da lista de demonstrações
     * 
     * @return tamanho da lista de demonstrações
     */
    @Override
    public int getSize() {
        return this.listaDemonstracoes.getSize();
    }

    /**
     * Devolvr uma demontração
     * 
     * @param index posição da demonstração
     * @return demonstração na posição index da lista
     */
    @Override
    public Object getElementAt(int index) {
        return this.listaDemonstracoes.getDemonstracaoAt(index).getCodigoIdentificacao();
    }

    /**
     * Adiciona uma demonstração à lista de demonstrações
     * 
     * @param demonstracao demonstração a ser adicionada
     * @return true se foi adicionada.Caso contrário retorna false
     */
    public boolean adicionaDemonstracao(Demonstracao demonstracao) {
        boolean b = this.listaDemonstracoes.adicionarDemonstracao(demonstracao);
        if (b) {
            fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        }
        return b;
    }

    /**
     * Remove uma demonstração da lista de demonstrações
     * 
     * @param codigoIdentificacao código de identificação da demonstração
     */
    public void removeDemonstracao(String codigoIdentificacao) {
        int index = this.listaDemonstracoes.removeDemonstracao(codigoIdentificacao);
        fireIntervalRemoved(this, index, index);
    }

}
