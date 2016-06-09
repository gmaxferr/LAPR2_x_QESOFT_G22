package lapr.project.controller;

import lapr.project.estados.Exposicao.EstadoExposicao;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do Controller do caso de uso - definir fae
 *
 * @author Ana Leite Ricardo Osório
 */
public class DefinirFAEController {

    private RegistoExposicoes m_re;
    private RegistoUtilizadores m_ru;
    private RegistoOrganizadores m_ro;
    private RegistoFAE m_rfae;
    private Utilizador m_u;
    private Exposicao m_exposicaoSelecionada;
    private final CentroExposicoes m_centroExposicoes;
    private final String m_usernameOrganizador;

    public DefinirFAEController(CentroExposicoes centroExposicoes, String usernameOrganizador) {
        this.m_centroExposicoes = centroExposicoes;
        this.m_usernameOrganizador = usernameOrganizador;
    }

    /**
     * Devolve uma lista com as exposições associadas ao organizador autenticado
     * no sistema
     *
     * @return lista com as exposições associadas ao organizador
     */
    public ArrayList<Exposicao> getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE() {
        return m_re.getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE(m_usernameOrganizador);
    }

    public void getRegistoOrganizadores() {
        this.m_ro = this.m_exposicaoSelecionada.getRegistoOrganizadores();
    }

    /**
     * Método que guarda a exposição escolhida pelo utilizador
     *
     * @param exposicao exposição escolhida
     */
    public void setExposicao(Exposicao exposicao) {
        this.m_exposicaoSelecionada = exposicao;
    }

    public void setRegistoOrganizadoresParaValidacoes() {
        this.m_rfae.setRegistoOrganizadoresParaValidacoes(this.m_ro);
    }

    /**
     * Adiciona um FAE recebendo por parametro o username do Utilizador que se
     * deseja promover ao cargo. O Utilizador é identificado e tentado adicionar
     * à lista de FAE existente. É validado se já existe um FAE com este
     * username ou um organizador.
     *
     * @param usernameUtilizador username do Utilizador a ser promovido a FAE
     * @return true se for adicionado com sucesso, false se não passar as
     * validações
     */
    public boolean setFaePeloUsername(String usernameUtilizador) {
        m_u = m_ru.identificarUtilizadorPeloUsername(usernameUtilizador);
        return m_rfae.adicionaFAE(m_u);
    }

    /**
     * Devolve a lista de utilizadores na totalidade existentes no centro de
     * exposições
     *
     * @return lista de utilizadores totais que existe no centro de exposições
     */
    public List<Utilizador> getListaUtilizadores() {
        return this.m_ru.getListaUtilizadores();
    }

    /**
     * Devolve uma lista de utilizadores que estão registados como FAE na
     * exposição em causa
     *
     * @return lista de utilizadores que estão registados como FAE na exposição
     * em causa
     */
    public List<Utilizador> getListaUtilizadoresCorrespondentesAosFae() {
        return this.m_rfae.getListaUtilizadoresCorrespondentesAosFae();
    }

    /**
     * Confirma a adição dos FAE definitivamente. Até aqui a lista de FAE éra
     * uma lista temporária
     *
     */
    public void confirmaAddFAE() {
        m_rfae.confirmaAddFAE();
    }

    public void getRegistoExposicoes() {
        this.m_re = this.m_centroExposicoes.getRegistoExposicoes();
    }

    public void getRegistoUtilizadores() {
        this.m_ru = this.m_centroExposicoes.getRegistoUtilizadores();
    }

    public void getRegistoFAE() {
        this.m_rfae = m_exposicaoSelecionada.getRegistoFAE();
    }

    public EstadoExposicao getEstadoExposicao() {
        return this.m_exposicaoSelecionada.getEstado();
    }

    public void setEstado() {
        EstadoExposicao estado = this.m_exposicaoSelecionada.getEstado();
        if (estado.isEstadoCriada()) {
            estado.setEstadoFAEDefinidosSemDemos();
        } else if (estado.isEstadoDemosDefinidasSemFAE()) {
            estado.setEstadoCompleta();
        }
    }

}
