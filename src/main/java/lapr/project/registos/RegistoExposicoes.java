package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.Estado;
import lapr.project.estados.EstadoExposicaoCandidaturasAbertas;
import lapr.project.estados.EstadoExposicaoCandidaturasFechadas;
import lapr.project.model.Agendavel;
import lapr.project.model.Exposicao;
import lapr.project.model.Organizador;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistoExposicoes implements Agendavel {

    /**
     * Lista de exposições existentes
     */
    private ArrayList<Exposicao> m_listaExposicoes;

    public RegistoExposicoes() {
        m_listaExposicoes = new ArrayList<Exposicao>();

    }

    /**
     * Método que devolve lista das Exposições
     *
     * @return lista das Exposições
     */
    public List<Exposicao> getExposicao() {
        return m_listaExposicoes;
    }

    /**
     * Devolve uma nova exposição criada
     *
     * @return nova exposição
     */
    public Exposicao novaExposicao() {
        return new Exposicao();
    }

    /**
     * Valida a exposição e no caso positivo adiciona à lista de exposições
     *
     * @param e exposição recebida
     * @return boolean que representa o sucesso da operação
     */
    public boolean registaExposicao(Exposicao e) {
        if (validaExposicao(e)) {
            addExposicao(e);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Método que adiciona uma exposição
     *
     * @param e exposição para adicionar
     */
    private void addExposicao(Exposicao e) {
        m_listaExposicoes.add(e);
    }

    /**
     * Método para validar exposição
     *
     * @param e exposição pretendida
     * @return boolean que representa o sucesso da operação
     */
    public boolean validaExposicao(Exposicao e) {
        return e.valida();
    }

    /**
     * Deolve uma lista com todas as exposições associadas a um centro de
     * exposições
     *
     * @return lista com todas as exposições associadas a um centro de
     * exposições
     */
    public ArrayList<Exposicao> getlistaExposicoesValidas() {
        ArrayList<Exposicao> lista = new ArrayList<>();
        for (Exposicao exposicao : this.m_listaExposicoes) {
            if (exposicao.dadosMinimosObrigatorios() == true) {
                lista.add(exposicao);
            }
        }
        return lista;
    }

    /**
     * Método que devolve a lista de exposições do organizador autenticado no
     * sistema
     *
     * @return lista de exposições do organizador
     */
    public ArrayList<Exposicao> getlistaExposicoesDoOrganizador() {
        //Organizador autenticado no sistema atualmente como organizador
        Organizador organizadorNoSistema = new Organizador();

        ArrayList<Exposicao> listaExpoDoOrg = new ArrayList<>();

        //encontra as exposições do organizador autenticado no sistema.
        for (int i = 0; i < m_listaExposicoes.size(); i++) {
            if (m_listaExposicoes.get(i).getOrganizadores() == organizadorNoSistema) {
                listaExpoDoOrg.add(m_listaExposicoes.get(i));
            }
        }

        //remove as exposições que se repetem
        removerExposiçõesRepetidas(listaExpoDoOrg);

        return listaExpoDoOrg;

    }

    /**
     * Método que remove exposições repetidas de um ArrayList
     *
     * @param array ArrayList desejado
     */
    public void removerExposiçõesRepetidas(ArrayList array) {
        //remove as exposições repetidas dentro do arrayList
    }

    @Override
    public void Agendavel(Estado estado, String dataAbertura) {
        /*
            Converte a string para Date
            Cria o timer
            Associa o timer ao Estado
         */
    }

    public void setEstadoCandidaturasAbertas(Exposicao exposicao) {
        Estado estado = new EstadoExposicaoCandidaturasAbertas(exposicao);
        String dataAbertura = exposicao.getM_strDataInicio();
        Agendavel(estado, dataAbertura);
    }

    public void setEstadoCandidaturasFechadas(Exposicao exposicao) {
        Estado estado = new EstadoExposicaoCandidaturasFechadas(exposicao);
        String dataFecho = exposicao.getM_strDataFim();
        Agendavel(estado, dataFecho);
    }

    public void setEstadoExposicaoConflitosDetetados(Exposicao exposicao) {
        Estado estado = new EstadoExposicaoCandidaturasFechadas(exposicao);
        String dataLimite = exposicao.getM_strDataFim();
        Agendavel(estado, dataLimite);
    }

}
