package lapr.project.model;

import classesModelERegistodePPROG.Demonstracao;
import java.util.ArrayList;
import java.util.List;

/**
 * Representação de uma lista de demostrações.
 *
 * @author Ricardo Osório e Ana Leite
 */
public class ListaDemonstracoes {

    /**
     * Lista de demostrações adicionadas.
     */
    private List<Demonstracao> listaDemonstracoesAdicionadas;

    /**
     * Construtor de objetos do tipo ListaDemonstrações sem parâmatros.
     */
    public ListaDemonstracoes() {
        this.listaDemonstracoesAdicionadas = new ArrayList<>();
    }

    /**
     * Devolve o tamanho da lista de demonstrações adicionadas.
     *
     * @return tamanho da lista de demonstrações adicionadas.
     */
    public int getSize() {
        return this.listaDemonstracoesAdicionadas.size();
    }

    /**
     * Devolce a lista de demonstrações adicionadas.
     *
     * @return lista de demonstrações adicionadas.
     */
    public List<Demonstracao> getListaDemonstracoesAdicionadas() {
        return this.listaDemonstracoesAdicionadas;
    }

    /**
     * Devolve a demonstração pela posição.
     *
     * @param index posição da demonstração.
     * @return demonstração.
     */
    public Demonstracao getDemonstracaoAt(int index) {
        return this.listaDemonstracoesAdicionadas.get(index);
    }

    /**
     * Adiciona uma demonstração à lista de demonstrações adicionadas.
     *
     * @param demonstracao demonstração a ser adicionada.
     * @return boolean que indica se foi adiciona ou não (true - foi adicionada)
     */
    public boolean adicionarDemonstracao(Demonstracao demonstracao) {
        if (validarDemonstracao(demonstracao.getCodigoIdentificacao())) {
            this.listaDemonstracoesAdicionadas.add(demonstracao);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Valida a demonstração verificando se ela existe na lista de demonstrações
     * adicionadas.
     *
     * @param codigoIdentificacao código de identificação da demonstração.
     * @return true se não encontrar a demonstração na lista de demonstrações
     * adicionadas. Caso contrário retorna false.
     */
    private boolean validarDemonstracao(String codigoIdentificacao) {
        for (Demonstracao demonstracao : this.listaDemonstracoesAdicionadas) {
            if (demonstracao.getCodigoIdentificacao().equalsIgnoreCase(codigoIdentificacao)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Remove uma demonstração.
     *
     * @param codigoIdentificacao código de identificação da demonstração.
     * @return posição da demonstração removida.
     */
    public int removeDemonstracao(String codigoIdentificacao) {
        int index = localizarDemonstracaoParaRemover(codigoIdentificacao);
        this.listaDemonstracoesAdicionadas.remove(index);
        return index;
    }

    /**
     * Localiza a demonstração para remover através do código de identificação
     *
     * @param codigoIdentificacao código de identificação da demonstração.
     * @return posição da demonstração a remover. Caso não encontre a
     * demonstração retorna -1.
     */
    public int localizarDemonstracaoParaRemover(String codigoIdentificacao) {
        for (int i = 0; i < this.listaDemonstracoesAdicionadas.size(); i++) {
            if (this.listaDemonstracoesAdicionadas.get(i).getCodigoIdentificacao().equalsIgnoreCase(codigoIdentificacao)) {
                return i;
            }
        }
        return -1;
    }

}
