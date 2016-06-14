package lapr.project.controller;

import lapr.project.estados.Exposicao.EstadoExposicao;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Controller do UC02 - definir fae
 *
 * @author G29
 */
public class DefinirFAEController {

    /**
     * Registo de exposições
     */
    private RegistoExposicoes m_re;

    /**
     * Registo de utilizadores
     */
    private RegistoUtilizadores m_ru;

    /**
     * Registo de organizadores
     */
    private RegistoOrganizadores m_ro;
    private RegistoFAE m_rfae;

    /**
     * Utilizador - usado para guardar o utilizador depois de identificado pelo
     * seu username
     */
    private Utilizador m_u;

    /**
     * Exposição selecionada pelo utilizador deste UC na UI
     */
    private Exposicao m_exposicaoSelecionada;

    /**
     * Centro de exposições sobre o qual este UC está a ser executado
     */
    private final CentroExposicoes m_centroExposicoes;

    /**
     * Username do organizador que está a executar esta UC
     */
    private final String m_usernameOrganizador;

    /**
     * Construtor do controller do UC02
     *
     * @param centroExposicoes centro de exposições sobre o qual este UC esta a
     * ser executado
     * @param usernameOrganizador username do organizador que esta a executar
     * este UC
     */
    public DefinirFAEController(CentroExposicoes centroExposicoes, String usernameOrganizador) {
        this.m_centroExposicoes = centroExposicoes;
        this.m_usernameOrganizador = usernameOrganizador;
    }

    /**
     * Devolve uma lista com as exposições associadas ao organizador que esta a
     * executar o UC
     *
     * @return lista com as exposições associadas ao organizador
     */
    public ArrayList<Exposicao> getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE() {
        return m_re.getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE(m_usernameOrganizador);
    }

    /**
     * Devolve o registo dos organizadores da exposição selecionada na UI
     */
    public void getRegistoOrganizadores() {
        this.m_ro = this.m_exposicaoSelecionada.getRegistoOrganizadores();
    }

    /**
     * Guarda a exposição selecionada pelo organizador na UI
     *
     * @param exposicao exposição selecionada pelo organizador na UI
     */
    public void setExposicao(Exposicao exposicao) {
        this.m_exposicaoSelecionada = exposicao;
    }

    /**
     * Define o registo de organizadores da exposição selecionada na UI no
     * registo de FAE de forma a permitir recorrer a este nessa classe
     */
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
    public boolean criarEAdicionarFaePeloUsername(String usernameUtilizador) {
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

    /**
     * Devolve o registo de exposições existentes
     */
    public void getRegistoExposicoes() {
        this.m_re = this.m_centroExposicoes.getRegistoExposicoes();
    }

    /**
     * Devolve o registo de utilizadores existentes no centro de exposições
     */
    public void getRegistoUtilizadores() {
        this.m_ru = this.m_centroExposicoes.getRegistoUtilizadores();
    }

    /**
     * Devolve o registo de fae associado à exposição selecionda na UI
     */
    public void getRegistoFAE() {
        this.m_rfae = m_exposicaoSelecionada.getRegistoFAE();
    }

    /**
     * Devolve o estado atual da exposição selecionada na UI
     *
     * @return estado da exposição selecionada
     */
    public EstadoExposicao getEstadoExposicao() {
        return this.m_exposicaoSelecionada.getEstado();
    }

    /**
     * Atualiza o estado atual da exposição selecionada. Caso esta se
     * encontrasse no estado Criada passará a estar ao estado
     * FAEDefninidosSemDemos. Senão, se estiver no estado DemosDefinidasSemFAE
     * então passará a estar no estado Completa
     */
    public void setEstado() {
        EstadoExposicao estado = this.m_exposicaoSelecionada.getEstado();
        if (estado.isEstadoCriada()) {
            estado.setEstadoFAEDefinidosSemDemos();
        } else if (estado.isEstadoDemosDefinidasSemFAE()) {
            estado.setEstadoCompleta();
        }
    }

}
