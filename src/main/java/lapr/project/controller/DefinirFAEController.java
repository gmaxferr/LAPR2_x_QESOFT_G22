package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.*;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do Controller do caso de uso - definir fae
 *
 * @author Ana Leite Ricardo Osório
 */
public class DefinirFAEController {

    private RegistoExposicoes re;
    private RegistoUtilizadores ru;
    private RegistoOrganizadores ro;
    private RegistoFAE rfae;
    private Utilizador u;
    private Exposicao exposicaoSelecionada;
    private final CentroExposicoes centroExposicoes;
    private final String usernameOrganizador;

    public DefinirFAEController(CentroExposicoes centroExposicoes, String usernameOrganizador) {
        this.centroExposicoes = centroExposicoes;
        this.usernameOrganizador = usernameOrganizador;
    }

    /**
     * Devolve uma lista com as exposições associadas ao organizador autenticado
     * no sistema
     *
     * @return lista com as exposições associadas ao organizador
     */
    public ArrayList<Exposicao> getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE() {
        return re.getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE(usernameOrganizador);
    }

    public void getRegistoOrganizadores() {
        this.ro = this.exposicaoSelecionada.getRegistoOrganizadores();
    }

    /**
     * Método que guarda a exposição escolhida pelo utilizador
     *
     * @param exposicao exposição escolhida
     */
    public void setExposicao(Exposicao exposicao) {
        this.exposicaoSelecionada = exposicao;
    }

    public void setRegistoOrganizadoresParaValidacoes() {
        this.rfae.setRegistoOrganizadoresParaValidacoes(this.ro);
    }

    /**
     * Método que adiciona fae
     *
     * @param usernameUtilizador identificador do fae
     */
    public void setFaePeloUsername(String usernameUtilizador) {
        u = ru.identificarUtilizadorPeloUsername(usernameUtilizador);
        rfae.adicionaFAE(u);
    }

    public List<Utilizador> getListaUtilizadores() {
        return this.ru.getListaUtilizadores();
    }

    /**
     * Método que confirma addição de fae
     *
     */
    public void confirmaAddFAE() {
        rfae.confirmaAddFAE();
    }

    public void getRegistoExposicoes() {
        this.re = this.centroExposicoes.getRegistoExposicoes();
    }

    public void getRegistoUtilizadores() {
        this.ru = this.centroExposicoes.getRegistoUtilizadores();
    }

    public void getRegistoFAE() {
        this.rfae = exposicaoSelecionada.getRegistoFAE();
    }

    public EstadoExposicao getEstadoExposicao() {
        return this.exposicaoSelecionada.getEstado();
    }

    public void setEstado() {
        EstadoExposicao estado = this.exposicaoSelecionada.getEstado();
        if (estado.isEstadoCriada()) {
            estado.setEstadoFAEDefinidosSemDemos();
        } else if (estado.isEstadoDemosDefinidasSemFAE()) {
            estado.setEstadoCompleta();
        }
    }

}
