package lapr.project.controller;

import java.util.List;
import lapr.project.model.Atribuicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Mecanismo;
import lapr.project.model.MecanismoIteragivel;
import lapr.project.model.MecanismoSimples;
import lapr.project.model.RegistoAtribuicoes;
import lapr.project.model.RegistoCandidaturas;
import lapr.project.model.RegistoExposicoes;
import lapr.project.model.RegistoMecanismos;

/**
 * Representação do Controller do caso de uso - atribuir candidatura
 *
 * @author Ricardo e Osório Ana Leite
 */
public class AtribuirCandidaturaController {

    /**
     * Registo de exposições.
     */
    private RegistoExposicoes re;

    /**
     * Registo de mecanismos.
     */
    private RegistoMecanismos rm;

    /**
     * Registo de candidaturas.
     */
    private RegistoCandidaturas rc;

    /**
     * Registo de atribuições.
     */
    private RegistoAtribuicoes ra;

    /**
     * Exposição escolhida.
     */
    private Exposicao exposicaoEscolhida;

    /**
     * Centro de exposições.
     */
    private CentroExposicoes centroExposicoes;

    /**
     * Constrói uma instância de AtribuirCandidaturaController recendo como
     * parâmentro o centro de esposições
     *
     * @param centroExposicoes centro de exposições
     */
    public AtribuirCandidaturaController(CentroExposicoes centroExposicoes) {
        this.centroExposicoes = centroExposicoes;
        this.ra = new RegistoAtribuicoes();
        this.rc = new RegistoCandidaturas();
        this.re = new RegistoExposicoes();
        this.rm = new RegistoMecanismos();
    }

    /**
     * Guarda o registo de exposições.
     */
    public void getRegistoExposicoes() {
        this.re = centroExposicoes.getRegistoExposicoes();
    }

    /**
     * Devolve a lista das exposições de um organizador.
     *
     * @return lista das exposições de um organizador.
     */
    public List<Exposicao> getListaExposicoesDoOrganizador(String identificacao) {
        return re.getListaExposicoesDoOrganizador(identificacao);
    }

    /**
     * Modifica a exposição.
     *
     * @param e nova exposição.
     */
    public void setExposicao(Exposicao e) {
        this.exposicaoEscolhida = e;
    }

    /**
     * Guarda o registo de mecanismos.
     */
    public void getRegistoMecanismos() {
        this.rm = centroExposicoes.getRegistoMecanismos();
    }

    /**
     * Devolve a lista de mecanismos.
     *
     * @return lista de mecanismos.
     */
    public List<Mecanismo> getListaMecanismos() {
        return rm.getListaMecanismos();
    }

    /**
     * Guarda o registo de candidaturas.
     */
    public void getRegistoCandidaturas() {
        this.rc = exposicaoEscolhida.getRegistoCandidaturas();
    }

    /**
     * Guarda o registo de atribuições.
     */
    public void getRegistoAtribuicoes() {
        this.ra = exposicaoEscolhida.getRegistoAtribuicoes();
    }

    /**
     * Devolve as atribuições geradas.
     *
     * @param mec mecanismo.
     *
     * @return atribuições geradas.
     */
    public List<Atribuicao> atribui(Mecanismo mec) {
        MecanismoSimples mecanismo = (MecanismoSimples) mec;
        return mecanismo.atribui(this.exposicaoEscolhida);
    }

    /**
     * Devolve as atribuições geradas.
     *
     * @param mec mecanismo.
     * @param numeroFAEOuExperiencia
     *
     * @return atribuições geradas.
     */
    public List<Atribuicao> atribui(Mecanismo mec, String numeroFAEOuExperiencia) {
        MecanismoIteragivel mecanismo = (MecanismoIteragivel) mec;
        return mecanismo.atribui(this.exposicaoEscolhida, numeroFAEOuExperiencia);
    }

    /**
     * Regista a atribuição.
     */
    public void registaAtribuicao(List<Atribuicao> listaAtribuicoesGerada) {
        this.ra.registaAtribuicao(listaAtribuicoesGerada);
    }
}
