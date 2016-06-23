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

    private transient ListaDemonstracoes listaDemonstracoes;

    public ModeloListaDemonstracoes(ListaDemonstracoes listaDemonstracoes) {
        this.listaDemonstracoes = listaDemonstracoes;
    }

    public List<Demonstracao> getListaDemonstracoesAdicionadas() {
        return this.listaDemonstracoes.getListaDemonstracoesAdicionadas();
    }

    @Override
    public int getSize() {
        return this.listaDemonstracoes.getSize();
    }

    @Override
    public Object getElementAt(int index) {
        return this.listaDemonstracoes.getDemonstracaoAt(index).getCodigoIdentificacao();
    }

    public boolean adicionaDemonstracao(Demonstracao demonstracao) {
        boolean b = this.listaDemonstracoes.adicionarDemonstracao(demonstracao);
        if (b) {
            fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        }
        return b;
    }

    public void removeDemonstracao(String codigoIdentificacao) {
        int index = this.listaDemonstracoes.removeDemonstracao(codigoIdentificacao);
        fireIntervalRemoved(this, index, index);
    }

}
