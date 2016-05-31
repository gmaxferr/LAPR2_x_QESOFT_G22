package lapr.project.model;

import java.io.Serializable;

/**
 * Representação de uma exposição.
 *
 * @author Ana Leite e Ricardo Osório
 */
public class Exposicao implements Serializable {

    /**
     * Título da exposição.
     */
    private String titulo;

    /**
     * Descrição da exposição.
     */
    private String descricao;

    /**
     * Data de inicio da exposição. Não foi usado Date por aparecer como classe
     * desactualizada no IDE
     */
    private String dataInicio;

    /**
     * Data de fim da exposição. Não foi usado Date por aparecer como classe
     * desactualizada no IDE
     */
    private String dataFim;

    /**
     * Local da exposição.
     */
    private Local local;

    /**
     * Registo de candidaturas da exposição.
     */
    private RegistoCandidaturas rc;

    /**
     * Registo de atribuições da exposição.
     */
    private RegistoAtribuicoes ra;

    /**
     * Registo de organizadores da exposição.
     */
    private RegistoOrganizadores ro;

    /**
     * Registo de demostrações da exposição.
     */
    private RegistoDemonstracoes rd;

    /**
     * Registo de fae da exposição.
     */
    private RegistoFAE rfae;

    /**
     * Centro de exposições que tem esta exposição
     */
    private CentroExposicoes centroExposicoes;

    /**
     * Construtor de objetos do tipo Exposição com os parâmetros título,
     * descrição, data de inicio, data de fim e local da exposição.
     *
     * @param titulo titulo da exposição.
     * @param descricao descrição da exposição.
     * @param dataInicio data de inicio da exposição.
     * @param dataFim data de fim da exposição.
     * @param local local da exposição.
     * @param centroExposicoes centro de exposições que contêm esta exposição
     */
    public Exposicao(String titulo, String descricao, String dataInicio, String dataFim, Local local, CentroExposicoes centroExposicoes) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.local = local;
        this.ra = new RegistoAtribuicoes();
        this.rc = new RegistoCandidaturas();
        this.rd = new RegistoDemonstracoes();
        this.rfae = new RegistoFAE(this);
        this.ro = new RegistoOrganizadores(this);
        this.centroExposicoes = centroExposicoes;
    }

    /**
     * Devolve o título da exposição.
     *
     * @return título da exposição.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Devolve a descrição da exposição.
     *
     * @return descrição da exposição.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Devolve a data de início da exposição.
     *
     * @return data de início da exposição.
     */
    public String getDataInicio() {
        return dataInicio;
    }

    /**
     * Devolve a data de fim da exposição.
     *
     * @return data de fim da exposição.
     */
    public String getDataFim() {
        return dataFim;
    }

    /**
     * Devolve o local da exposição.
     *
     * @return local da exposição.
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Devolve o registo de candidaturas da exposição.
     *
     * @return registo de candidaturas da exposição.
     */
    public RegistoCandidaturas getRegistoCandidaturas() {
        return this.rc;
    }

    /**
     * Devolve o registo de atribuições da exposição.
     *
     * @return registo de atribuições da exposição.
     */
    public RegistoAtribuicoes getRegistoAtribuicoes() {
        return this.ra;
    }

    /**
     * Devolve o registo de demonstrações da exposição.
     *
     * @return registo de demonstrações da exposição.
     */
    public RegistoDemonstracoes getRegistoDemonstracoes() {
        return this.rd;
    }

    /**
     * Devolve o resgisto de FAE da exposição.
     *
     * @return resgisto de FAE da exposição.
     */
    public RegistoFAE getRegistoFAE() {
        return this.rfae;
    }

    /**
     * Devolve o registo de organizadores da exposição.
     *
     * @return registo de organizadores da exposição.
     */
    public RegistoOrganizadores getRegistoOrganizadores() {
        return this.ro;
    }

    /**
     * Devolve o número de organizadores desta exposição
     *
     * @return verificação do número mínimo de organizadores da exposição.
     */
    public int getNumeroOrganizadores() {
        return this.ro.getSize();
    }

    /**
     * Modifica o título da exposição.
     *
     * @param titulo novo título da exposição.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Modifica a descrição da exposição.
     *
     * @param descricao nova descrição da exposição.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Modifica a data de início da exposição.
     *
     * @param dataInicio nova data de início da exposição.
     */
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * Modifica a data de fim da exposição.
     *
     * @param dataFim nova data de fim da exposição.
     */
    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * Modifica o local da exposição.
     *
     * @param local novo local da exposição.
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    /**
     * Compara a exposição a outro objecto passado por parâmetro. A comparação
     * entre duas exposições é feita com atenção a todos os atributos destas.
     *
     * @param obj objecto a comparar com a exposição
     * @return true se o objeto recebido representar uma exposição equivalente à
     * exposição. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        } else if (this == obj) {
            return true;
        }
        Exposicao exposicao = (Exposicao) obj;
        if (this.getTitulo().equalsIgnoreCase(exposicao.getTitulo())
                && this.getDescricao().equalsIgnoreCase(exposicao.getDescricao())
                && this.getLocal().getMorada().equalsIgnoreCase(exposicao.getLocal().getMorada())
                && this.getDataInicio().equals(exposicao.getDataInicio())
                && this.getDataFim().equals(exposicao.getDataFim())) {
            return true;
        }
        return false;
    }

    /**
     * Adiciona um utilizador como fae desta exposição recebendo como parametro
     * o username ou o email desse utilizador. Apenas adiciona se ainda não
     * existir como fae nesta exposição
     *
     * @param utilizador utilizador a ser adicionar como fae desta exposição
     * @param experiencia experiência do fae nesta posição
     */
    public void addFAE(Utilizador utilizador, int experiencia) {
        this.rfae.addFAE(utilizador, experiencia);
    }

    /**
     * Adiciona um utilizador como organizador desta exposição recebendo como
     * parametro o username ou o email desse utilizador. Apenas adiciona se
     * ainda não existir como organizador nesta exposição
     *
     * @param utilizador
     */
    public void addOrganizador(Utilizador utilizador) {
        this.ro.addOrganizador(utilizador);
    }

}
