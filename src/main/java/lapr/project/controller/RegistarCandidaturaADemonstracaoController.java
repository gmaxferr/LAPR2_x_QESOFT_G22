package lapr.project.controller;

import java.util.List;
import lapr.project.estados.*;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 *
 * @author guima
 */
public class RegistarCandidaturaADemonstracaoController {
    
    private Exposicao e; //exposição selecionada
    private Demonstracao d; //demonstração selecionada
    private String dados; //dados do formulário
    private CandidaturaADemonstracao cand; //nova candidatura a uma demonstração

    private CentroExposicoes ce;
    private String usernameRep; //username do representante

    private RegistoExposicoes re;
    private RegistoDemonstracoes rd;
    private RegistoCandidaturaADemonstracoes rcd;
    
    private List<Demonstracao> listDemos; //lista de demonstrações da exposição selecionada
    private List<Exposicao> listExpos; //lista de exposicoes em que o representante entra

    private EstadoCandidaturaADemonstracao estado;
    
    public RegistarCandidaturaADemonstracaoController(CentroExposicoes ce, String usernameRep) {
        this.ce = ce;
        this.usernameRep = usernameRep;
    }

    /**
     * @return lista de exposiçoes (nas quais o representante foi integradp) do
     * registo de exposições do centro de exposições. selecionada previamente
     */
    public List<Exposicao> getListaDeExposicoes() {
        re = ce.getRegistoExposicoes();
        listExpos = re.getListaExposicoesComCanditaturasAceitesRepresentante(usernameRep);
        return listExpos;
    }

    /**
     * Guarda a exposição selecionada pelo representante.
     *
     * @param e - exposição selecionada
     */
    public void setExpo(Exposicao e) {
        this.e = e;
    }

    /**
     * Guarda a demonstração selecionada pelo representante
     *
     * @param indexSelectedDemo - indice da demonstração selecionada
     */
    public void setDemo(int indexSelectedDemo) {
        this.d = listDemos.get(indexSelectedDemo);
    }

    /**
     * @return lista de demonstrações do registo de demonstrações da exposição
     * selecionada previamente
     */
    public List<Demonstracao> getListaDemos() {
        rd = e.getRegistoDemonstracoes();
        listDemos = rd.getListaDemonstracoes();
        return listDemos;
    }

    /**
     * Valida os dados conforme estes estejam ou não preenchidos. (Ainda não
     * temos outra forma de validar estes dados)
     *
     * @param dados - dados do formulário
     * @return true se forem válidos; false caso contrário
     */
    public boolean isValidDados(String dados) {
        return !dados.isEmpty();
    }

    /**
     * Armazena os dados do formulário, introduzidos pelo utilizador (se forem
     * válidos).
     *
     * @param dados - daods do formulário, introduzidos pelo utilizador
     * @return true se forem válidos e, por tanto, armazenados com sucesso;
     * false caso contrário.
     */
    public boolean setFormularioDados(String dados) {
        boolean valido = false;
        if (isValidDados(dados)) {
            this.dados = dados;
            valido = true;
        }
        return valido;
    }

    /**
     * Valida globalmente uma candidatura e regista-a se for válida.
     *
     * @return true se a adição foi efetuada com sucesso; false caso contrário
     */
    public boolean RegistaCandADemo() {
        cand = new CandidaturaADemonstracao(dados);
        return rcd.adiciona(cand);
    }
    
    /**
     * Muda o estado da candidatura à demonstração
     */
    public void transitaEstado() {
        this.estado = cand.getEstado();
        if (estado.setEstadoCandidaturaCriada()) {
            EstadoCandidaturaADemonstracaoCriada estado2 = new EstadoCandidaturaADemonstracaoCriada(cand);
            cand.setEstado(estado2);
        }
    }
    
}
