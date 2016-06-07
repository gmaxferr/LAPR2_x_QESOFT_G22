/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.registos.RegistoExposicoes;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class DecidirDemonstracaoController {

    private CentroExposicoes ce;
    private String usernameOrganizador;
    private RegistoExposicoes re;
    private RegistoDemonstracoes rd;
    private List<Demonstracao> lstDemonstracoes;
    private boolean[] decisoesTemp;

    public DecidirDemonstracaoController(CentroExposicoes ce, String username) {
        this.ce = ce;
        re = ce.getRegistoExposicoes();
        usernameOrganizador = username;

    }

    /**
     *
     * @return lista de decisões para as demonstrações pendentes da exposição
     * selecionada
     */
    public boolean[] getDecisoesTemp() {
        return decisoesTemp;
    }

    public List<Exposicao> getListaExposOrganizador() {
        return re.getlistaExposicoesDoOrganizadorComDemos(usernameOrganizador);
    }

    /**
     * Seleciona a exposição pretendida e devolve demonstrações pendentes da
     * mesma
     *
     * @param e - exposição selecionada
     * @return demonstrações pendentes da exposição selecionada
     */
    public List<Demonstracao> setExposicao(Exposicao e) {
        rd = e.getRegistoDemonstracoes();
        List<Demonstracao> demosPendentes = rd.getDemonstracoesPendentes();
        decisoesTemp = new boolean[demosPendentes.size()];
        return demosPendentes;
    }

    /**
     * Regista decisões para as demonstrações pendentes da exposição
     */
    public void registarDecisoes() {
        for (int i = 0; i < lstDemonstracoes.size(); i++) {
            if (decisoesTemp[i]) {
                lstDemonstracoes.get(i).getEstadoDemo().setEstadoDemonstracaoConfirmada();
            } else {
                lstDemonstracoes.get(i).getEstadoDemo().setEstadoDemonstracaoCancelada();
            }
        }
    }
}
