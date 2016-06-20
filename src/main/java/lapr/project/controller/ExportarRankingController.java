package lapr.project.controller;

import java.io.File;
import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.RegistoExposicoes;

/**
 *
 * @author G29
 */
public class ExportarRankingController {

    /**
     * Centro de Exposições.
     */
    private final CentroExposicoes m_centroExposicoes;

    /**
     * Lista de Exposições cujo ranking está pronto para ser exportado.
     */
    private List<Exposicao> m_listaExpos;

    /**
     * Exposição seleccionada.
     */
    private Exposicao selectedExpo;

    /**
     * Ranking de Keywords da exposição seleccionada.
     */
    private KeywordRanking keywordRanking;

    /**
     * Construtor padrão.
     *
     * @param m_centroExposicoes Centro de Exposições
     */
    public ExportarRankingController(CentroExposicoes m_centroExposicoes) {
        this.m_centroExposicoes = m_centroExposicoes;
    }

    /**
     * @return Retorna uma lista de exposições cujo ranking de keywords está
     * pronto para ser exportado
     */
    public List<Exposicao> getListaExposicoesRankingPronto() {
        RegistoExposicoes re = m_centroExposicoes.getRegistoExposicoes();
        m_listaExpos = re.getListaExposicoesRankingPronto();
        return m_listaExpos;
    }

    /**
     * Selecciona uma exposição
     *
     * @param expo Exposição seleccionada
     */
    public void select(Exposicao expo) {
        selectedExpo = expo;
    }

    /**
     * Exporta o conteúdo para um ficheiro CSV
     *
     * @param file Ficheiro CSV para onde será exportada a informação
     * @return TRUE se a operação foi bem sucedida, FALSE caso contrário
     */
    public boolean export(File file) {
        return keywordRanking.exportCSV(file);
    }
}
