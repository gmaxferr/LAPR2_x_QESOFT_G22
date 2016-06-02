package lapr.project.registos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstracao;

/**
 * Representação de um registo de demonstrações.
 *
 * @author Ana Leite e Ricardo Osório
 */
public class RegistoDemonstracoes implements Serializable{

    /**
     * Contador de demonstrações.
     */
    private int contadorDemonstracoes;

    /**
     * Lista de demonstrações.
     */
    private List<Demonstracao> listaDemonstracoes;

    /**
     * Construtor de objetos do tipo RegistoDemonstracoes sem parâmetros.
     */
    public RegistoDemonstracoes() {
        this.listaDemonstracoes = new ArrayList<>();
        this.contadorDemonstracoes = 0;
    }

    /**
     * Devolve a lista de demonstrações.
     *
     * @return lista de demonstrações.
     */
    public List<Demonstracao> getListaDemonstracoes() {
        return this.listaDemonstracoes;
    }

    /**
     * Modifica a lista de demonstrações.
     * 
     * @param listaDemonstracoesAdicionadas lista de demonstrações.
     */
    public void setListaDemonstracoes(List<Demonstracao> listaDemonstracoesAdicionadas) {
        this.listaDemonstracoes = listaDemonstracoesAdicionadas;
    }

    /**
     * Adiciona a demostração escolhida.
     *
     * @param demonstracaoEscolhida demostração escolhida.
     */
    public void adicionarDemonstracao(Demonstracao demonstracaoEscolhida) {
        if (validaDemonstracao(demonstracaoEscolhida)) {
            this.contadorDemonstracoes++;
            //Para poder definir o código de identificação de acordo com o número atual de demons já existentes. 
            this.listaDemonstracoes.add(new Demonstracao(demonstracaoEscolhida, contadorDemonstracoes));
        }
    }

    /**
     * Valida a demostração escolhida.
     *
     * @param demonstracaoEscolhida demostração escolhida.
     *
     * @return true se não encontrar a demonstração na lista de demonstrações.
     * Caso contrário retorna false.
     */
    private boolean validaDemonstracao(Demonstracao demonstracaoEscolhida) {
        for (Demonstracao demonstracao : this.listaDemonstracoes) {
            if (demonstracao.getCodigoIdentificacao().equalsIgnoreCase(demonstracaoEscolhida.getCodigoIdentificacao())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Remove uma demonstração. 
     * 
     * @param demoIdentificacao identificação da demonstração.
     */
    public void removerDemonstracao(String demoIdentificacao) {
        int index = procuraDemonstracaoPeloCodigoIdentificacao(demoIdentificacao);
        this.listaDemonstracoes.remove(index);
        this.contadorDemonstracoes--;
    }

    /**
     * Procura demonstração pelo código de identificação.
     * 
     * @param demoIdentificacao identificação da demonstração.
     * @return posição da demonstração a remover. Caso não encontre a demonstração
     * retorna -1.
     */
    private int procuraDemonstracaoPeloCodigoIdentificacao(String demoIdentificacao) {
        for (int i = 0; i < this.listaDemonstracoes.size(); i++) {
            if (this.listaDemonstracoes.get(i).getCodigoIdentificacao().equalsIgnoreCase(demoIdentificacao)) {
                return i;
            }
        }
        return -1;
    }

}
