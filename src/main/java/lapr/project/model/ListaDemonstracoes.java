package lapr.project.model;

import java.util.*;

/**
 * Representação de uma lista de demostrações.
 *
 * @author G29
 */
public class ListaDemonstracoes {

    /**
     * Lista de demostrações adicionadas.
     */
    private List<Demonstracao> m_listaDemonstracoesAdicionadas;

    /**
     * Construtor de objetos do tipo ListaDemonstrações sem parâmatros.
     */
    public ListaDemonstracoes() {
        this.m_listaDemonstracoesAdicionadas = new ArrayList<>();
    }

    /**
     * Devolve o tamanho da lista de demonstrações adicionadas.
     *
     * @return tamanho da lista de demonstrações adicionadas.
     */
    public int getSize() {
        return this.m_listaDemonstracoesAdicionadas.size();
    }

    /**
     * Devolce a lista de demonstrações adicionadas.
     *
     * @return lista de demonstrações adicionadas.
     */
    public List<Demonstracao> getListaDemonstracoesAdicionadas() {
        return this.m_listaDemonstracoesAdicionadas;
    }

    /**
     * Devolve a demonstração pela posição.
     *
     * @param index posição da demonstração.
     * @return demonstração.
     */
    public Demonstracao getDemonstracaoAt(int index) {
        return this.m_listaDemonstracoesAdicionadas.get(index);
    }

    /**
     * Adiciona uma demonstração à lista de demonstrações adicionadas.
     *
     * @param demonstracao demonstração a ser adicionada.
     * @return boolean que indica se foi adiciona ou não (true - foi adicionada)
     */
    public boolean adicionarDemonstracao(Demonstracao demonstracao) {
        if (validarDemonstracao(demonstracao.getCodigoIdentificacao())) {
            this.m_listaDemonstracoesAdicionadas.add(demonstracao);
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
        for (Demonstracao demonstracao : this.m_listaDemonstracoesAdicionadas) {
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
        this.m_listaDemonstracoesAdicionadas.remove(index);
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
        for (int i = 0; i < this.m_listaDemonstracoesAdicionadas.size(); i++) {
            if (this.m_listaDemonstracoesAdicionadas.get(i).getCodigoIdentificacao().equalsIgnoreCase(codigoIdentificacao)) {
                return i;
            }
        }
        return -1;
    }

}
