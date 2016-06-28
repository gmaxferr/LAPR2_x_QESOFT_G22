package lapr.project.controller;

import java.util.ArrayList;
import lapr.project.estados.Exposicao.EstadoExposicao;
import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;
import lapr.project.utils.Data;

/**
 * Representação do Controller do caso de uso - criar exposição
 *
 * @author G29
 */
public class CriarExposicaoController {

    /**
     * Centro de exposições atual
     */
    private final CentroExposicoes m_centro_exposicoes;

    /**
     * Registo de exposições existentes no centro de exposições atual
     */
    private final RegistoExposicoes m_re;

    /**
     * Registo de utilizadores existentes no centro de exposições
     */
    private final RegistoUtilizadores m_ru;

    /**
     * Lista de organizadores selecionados pela UI
     */
    private List<Organizador> m_organizadoresSelecionados = new ArrayList<>();

    /**
     * Exposição a ser criada durante este UC
     */
    private Exposicao m_exposicao;

    /**
     * Estado da exposição alvo deste UC (a que está a ser criada)
     */
    private EstadoExposicao m_estadoExposicao;

    /**
     * Construtor de objetos do tipo CriarExposicaoController com o paramentro
     * centro de exposições
     *
     * @param centro_exposicoes centro de exposições atual
     */
    public CriarExposicaoController(CentroExposicoes centro_exposicoes) {
        m_centro_exposicoes = centro_exposicoes;
        m_re = centro_exposicoes.getRegistoExposicoes();
        m_ru = centro_exposicoes.getRegistoUtilizadoresConfirmados();
    }

    /**
     * Guarda o registo de exposições existentes no centro de exposições
     */
    public void getRegistoExposicao() {
        m_centro_exposicoes.getRegistoExposicoes();
    }

    /**
     * Guarda o registo de utilizadores existentes no centro de exposições
     */
    public void getRegistoUtilizadores() {
        m_centro_exposicoes.getRegistoUtilizadoresConfirmados();
    }

    /**
     * Cria uma nova exposição
     */
    public void novaExposicao() {
        m_exposicao = m_re.novaExposicao();
    }

    /**
     * Devolve uma lista com todos os utilizadores
     *
     * @return lista de todos os utilizadores
     */
    public List<Utilizador> getListaUtilizadores() {
        return m_ru.getListaUtilizadores();
    }

    /**
     * Define os dados da exposição
     *
     * @param strTitulo Titulo da exposição
     * @param strDescricao Descrição da exposição
     * @param dataInicio
     * @param dataFim
     * @param dataAberturaSubCand
     * @param dataEncerramentoSubCand
     * @param dataFimDetecaoConflitos
     * @param strLocal Local de realização da exposição
     * @return o objecto Exposição criado com estes parametros ou null se não
     * foi possivel criar com esses parametros
     */
    public Exposicao setDados(String strTitulo, String strDescricao, Data dataInicio, Data dataFim, Data dataAberturaSubCand, Data dataEncerramentoSubCand, Data dataFimDetecaoConflitos, Local strLocal) {
        m_exposicao.setTitulo(strTitulo);
        m_exposicao.setDescricao(strDescricao);
        m_exposicao.setPeriodo(dataInicio, dataFim);
        m_exposicao.setDataAberturaSubCand(dataAberturaSubCand);
        m_exposicao.setDataEncerramentoSubCand(dataEncerramentoSubCand);
        m_exposicao.setDataFimDetecaoConflitos(dataFimDetecaoConflitos);
        m_exposicao.setLocal(strLocal);
        if (!m_exposicao.valida()) {
            m_exposicao = null;
        }
        return m_exposicao;
    }

    /**
     * Devolve um boolean que representa o sucesso da operação que é registar
     * uma nova exposição
     *
     * @return boolean que representa o sucesso da operação que é registar uma
     * nova exposição
     */
    public boolean registaExposicao() {

        return m_re.registaExposicao(m_exposicao);

    }

    /**
     * Adiciona novo organizador à exposição
     *
     * @param utilizador utilizador a ser designado como organizador da
     * exposição caso seja válido
     */
    public void addOrganizador(Organizador utilizador) {
        m_organizadoresSelecionados.add(utilizador);
    }

    /**
     * Regista os organizadores selecionados na exposição
     */
    public void registarOrganizadores() {
        m_exposicao.addOrganizadores(m_organizadoresSelecionados);
    }

    /**
     * Remove organizador pendente
     *
     * @param o organizador pendente
     */
    public void removerOrganizador(Organizador o) {
        m_organizadoresSelecionados.remove(o);
    }

    /**
     * Tenta a transição do estado ca exposição para criada
     */
    public void setEstadoCriada() {
        this.m_estadoExposicao = this.m_exposicao.getEstado();
        m_estadoExposicao.setEstadoCriada();
    }

    /**
     * Regista como organizadores para a exposição todos os utilizadores
     * (válidos) de uma lista de utilizadores recebida por parametro
     *
     * @param listaDeUtilizadoresAdicionados
     */
    public void registarOrganizadores(List<Utilizador> listaDeUtilizadoresAdicionados) {
        for (Utilizador utilizador : listaDeUtilizadoresAdicionados) {
            this.m_exposicao.getRegistoOrganizadores().addOrganizador(utilizador);
        }
    }

    /**
     * Devolve o utilizador do qual apenas é passado, por parametro, o username
     *
     * @param username username do utilizador a procurar
     * @return o Utilizador com o username passado por parametro ou então null,
     * caso não seja encontrado nenhum utilizador com esse username
     */
    public Utilizador identificarUtilizadorPeloUsername(String username) {
        return this.m_ru.identificarUtilizadorPeloUsername(username);
    }
}
