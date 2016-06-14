package lapr.project.controller;

import java.util.List;
import lapr.project.exceptions.AreaErradaException;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Stand;
import lapr.project.registos.RegistoStands;

/**
 *
 * @author G29
 */
public class CriarStandsController {

    /**
     * Centro de exposições sobre o qual está a ser executado este UC
     */
    private final CentroExposicoes centroExposicoes;

    /**
     * Registo dos stands deste centro de exposições
     */
    private RegistoStands rStands;

    /**
     * Construtor do controller do UC23
     *
     * @param ce Centro de exposições atual
     */
    public CriarStandsController(CentroExposicoes ce) {
        this.centroExposicoes = ce;
    }

    /**
     * Busca e guarda o registo de stands deste centro de exposições
     */
    public void getRegistoStands() {
        this.rStands = this.centroExposicoes.getRegistoStands();
    }

    /**
     * Devolve uma lista com todos os stands do centro de exposições atual
     *
     * @return lista com todos os stands
     */
    public List<Stand> getListaStands() {
        return this.rStands.getListaStands();
    }

    /**
     * Valida e cria um novo stand
     *
     * @param ID ID do novo stand
     * @param area área do novo stand
     * @throws AreaErradaException exceção lançada se a área não for válida
     */
    public void criarStand(String ID, String area) throws AreaErradaException {
        this.rStands.criarStand(ID, area);
    }

}
