package lapr.project.model;

import lapr.project.exceptions.*;
import java.io.Serializable;
import lapr.project.estados.EstadoCandidatura;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.registos.RegistoProdutos;

/**
 * Representa de uma Candidatura
 *
 * @author Ricardo Osório e Ana Leite
 */
public class Candidatura implements Serializable {

    /**
     * Username do expositor da candidatura.
     */
    private String usernameExpositor;

    /**
     * Nome da empresa da candidatura.
     */
    private String nomeEmpresa;

    /**
     * Morada da empresa da candidatura.
     */
    private String moradaEmpresa;

    /**
     * Telemóvel da empresa da. candidatura
     */
    private int telemovelEmpresa;

    /**
     * Área pretendida pela empresa da candidatura.
     */
    private int area;

    /**
     * Registo de produtos da candidatura.
     */
    private RegistoProdutos rp;

    /**
     * Registo de demonstrações da candidatura.
     */
    private RegistoDemonstracoes rd;

    /**
     * Número de convites da candidatura.
     */
    private int numConvites;

    private EstadoCandidatura estado;

    /**
     * Construtor de objetos do tipo Candidatura com o parâmetro expositor da
     * candidatura.
     *
     * @param usernameExpositor username do expositor da candidatura
     */
    public Candidatura(String usernameExpositor) {
        this.usernameExpositor = usernameExpositor;
        this.rp = new RegistoProdutos();
        this.rd = new RegistoDemonstracoes();
    }

    /**
     * Devolve o estado atual da candidatura
     *
     * @return - estado atual da candidatura
     */
    public EstadoCandidatura getEstado() {
        return estado;
    }

    /**
     * Devolve o nome da empresa da candidatura.
     *
     * @return nome da empresa da candidatura.
     */
    public String getM_NomeEmpresa() {
        return this.nomeEmpresa;
    }

    /**
     * Devolve o número de telomóvel da empresa da candidatura.
     *
     * @return número de telemóvel da candidatura.
     */
    public int getM_NumeroTelemovel() {
        return this.telemovelEmpresa;
    }

    /**
     * Devolve a morada da empresa da candidatura.
     *
     * @return morada da empresa da candidatura.
     */
    public String getM_MoradaEmpresa() {
        return this.moradaEmpresa;
    }

    /**
     * Devolve o número de convites pretendidos pela empresa da candidatura.
     *
     * @return número de convites pretendidos pela empresa da candidatura.
     */
    public int getM_NumConvites() {
        return this.numConvites;
    }

    /**
     * Devolve a àrea pretendida pela empresa da candidatura.
     *
     * @return àrea pretendida pela empresa da candidatura.
     */
    public int getM_Area() {
        return this.area;
    }

    /**
     * Devolve o registo de produtos da candidatura.
     *
     * @return registo de produtos da candidatura.
     */
    public RegistoProdutos getM_RegistoProdutos() {
        return this.rp;
    }

    /**
     * Devolve o username do expositor da candidatura.
     *
     * @return username do expositor da candidatura.
     */
    public String getM_UsernameExpositor() {
        return this.usernameExpositor;
    }

    /**
     * Devolve o registo de demonstrações da candidatura.
     *
     * @return registo de demonstrações da candidatura
     */
    public RegistoDemonstracoes getRegistoDemonstracoes() {
        return this.rd;
    }

    /**
     * Modifica o nome da empresa da candidatura.
     *
     * @param nomeEmpresa novo nome da empresa da candidatura.
     */
    public void setM_NomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    /**
     * Modifica a morada da empresa da candidatura.
     *
     * @param moradaEmpresa nova morada da empresa da candidatura.
     */
    public void setM_MoradaEmpresa(String moradaEmpresa) {
        this.moradaEmpresa = moradaEmpresa;
    }

    /**
     * Modifica o número de telemóvel da empresa da candidatura.
     *
     * @param telemovelEmpresa novo número de telemovel da candidatura.
     */
    public void setM_TelemovelEmpresa(int telemovelEmpresa) throws TelemovelEmpresaErradoException {
        if (telemovelEmpresa < 100_000_000 || telemovelEmpresa > 999_999_999) {
            throw new TelemovelEmpresaErradoException("O número de telemóvel da empresa não se encontra correto.");
        }
        this.telemovelEmpresa = telemovelEmpresa;
    }

    /**
     * Modifica a área pretendida pela empresa da candidatura.
     *
     * @param area nova area pretendida da candidatura.
     */
    public void setM_Area(int area) throws AreaErradaException {
        if (area <= 0) {
            throw new AreaErradaException("A área introduzida não é válida.");
        }
        this.area = area;
    }

    /**
     * Modifica o número de convites pretendido pela empresa da candidatura.
     *
     * @param numConvites novo número de convites da candidatura.
     */
    public void setM_NumConvites(int numConvites) throws NumeroConvitesErradoException {
        if (numConvites <= 0) {
            throw new NumeroConvitesErradoException("O número de convites introduzido não é válido.");
        }
        this.numConvites = numConvites;
    }

    /**
     * Compara a candidatura a outro objecto passado por parametro. A comparação
     * entre duas candidaturas é feita com atenção a alguns todos os atributos
     * desta.
     *
     * @param obj objecto a comparar com a candidatura
     * @return true se o objeto recebido representar uma candidatura equivalente
     * à candidatura. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }
        Candidatura cand = (Candidatura) obj;
        if (this.usernameExpositor.equalsIgnoreCase(cand.getM_UsernameExpositor())) {
            return true;
        } else {
            return false;
        }
    }

    public void setEstado(EstadoCandidatura ne) {
        this.estado = ne;
    }
}
