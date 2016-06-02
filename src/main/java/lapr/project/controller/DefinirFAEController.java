package lapr.project.controller;

import java.util.ArrayList;

/**
 * Representação do Controller do caso de uso - definir fae
 *
 * @author Ana Leite Ricardo Osório
 */
public class DefinirFAEController {

    private RegistoExposicoes re;
    private RegistoUtilizadores ru;
    private RegistoFAE rfae;
    /*as variaveis seguintes são de instância para evitar problemas 
    caso fossem de classe quando duas pessoas ou mais executam este UC ao 
    mesmo tempo. Os dados guardados do primeiro utilizador seriam 
    sobrepostos pelos do segundo*/
    private Utilizador u;
    private Exposicao e;
    private ArrayList<Exposicao> listExpo = new ArrayList<>();

    //Este programa nao tem implementação suficiente para interagir com o utilizador. Estes parametros foram assumidos para nao criar erros de compilação do java
    CentroExposicoes centroExpo = new CentroExposicoes();

    /**
     * Devolve uma lista com as exposições associadas ao organizador autenticado
     * no sistema
     *
     * @return lista com as exposições associadas ao organizador
     */
    public ArrayList<Exposicao> getlistaExposicoesDoOrganizador() {
        listExpo = re.getlistaExposicoesDoOrganizador();
        return listExpo;
    }

    /**
     * Método que guarda a exposição escolhida pelo utilizador
     *
     * @param exposicao exposição escolhida
     */
    public void setExposicao(Exposicao exposicao) {
        e = exposicao;
    }

    /**
     * Método que adiciona fae
     *
     * @param id identificador do fae
     */
    public void setFaePeloID(String id) {
        u = ru.identificarUtilizadorPeloID(id);
        rfae.adicionaFAE(u);
    }

    /**
     * Método que confirma addição de fae
     *
     * @param b confirmação da validação
     */
    public void confirmaAddFAE(boolean b) {
        rfae.confirmaAddFAE(b);
    }

    public void getRegistoExposicoes() {
        this.re = centroExpo.getRegistoExposicoes();
    }

    public void getRegistoUtilizadores() {
        this.ru = centroExpo.getRegistoUtilizadores();
    }

    public void getRegistoFAE() {
        this.rfae = e.getRfae();
    }

    public void setEstado() {
        EstadoExposicao estado = this.e.getEstadoExposicao();
        if (estado instanceof EstadoExposicaoCriada) {
            estado.setEstadoFAEDefinidosSemDemos();
        } else if (estado instanceof EstadoExposicaoDemosDefinidasSemFAE) {
            estado.setEstadoCompleta();
        }
    }

    public EstadoExposicao getEstadoExposicao() {
        return this.e.getEstadoExposicao();
    }
}
