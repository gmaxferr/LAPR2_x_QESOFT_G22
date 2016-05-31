package lapr.project.model;

import lapr.project.excecoes.TelemovelEmpresaErradoException;
import lapr.project.excecoes.NumeroConvitesErradoException;
import lapr.project.excecoes.AreaErradaException;
import java.io.Serializable;

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
     * Devolve o nome da empresa da candidatura.
     *
     * @return nome da empresa da candidatura.
     */
    public String getNomeEmpresa() {
        return this.nomeEmpresa;
    }

    /**
     * Devolve o número de telomóvel da empresa da candidatura.
     *
     * @return número de telemóvel da candidatura.
     */
    public int getNumeroTelemovel() {
        return this.telemovelEmpresa;
    }

    /**
     * Devolve a morada da empresa da candidatura.
     *
     * @return morada da empresa da candidatura.
     */
    public String getMoradaEmpresa() {
        return this.moradaEmpresa;
    }

    /**
     * Devolve o número de convites pretendidos pela empresa da candidatura.
     *
     * @return número de convites pretendidos pela empresa da candidatura.
     */
    public int getNumConvites() {
        return this.numConvites;
    }

    /**
     * Devolve a àrea pretendida pela empresa da candidatura.
     *
     * @return àrea pretendida pela empresa da candidatura.
     */
    public int getArea() {
        return this.area;
    }

    /**
     * Devolve o registo de produtos da candidatura.
     *
     * @return registo de produtos da candidatura.
     */
    public RegistoProdutos getRegistoProdutos() {
        return this.rp;
    }

    /**
     * Devolve o username do expositor da candidatura.
     *
     * @return username do expositor da candidatura.
     */
    public String getUsernameExpositor() {
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
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    /**
     * Modifica a morada da empresa da candidatura.
     *
     * @param moradaEmpresa nova morada da empresa da candidatura.
     */
    public void setMoradaEmpresa(String moradaEmpresa) {
        this.moradaEmpresa = moradaEmpresa;
    }

    /**
     * Modifica o número de telemóvel da empresa da candidatura.
     *
     * @param telemovelEmpresa novo número de telemovel da candidatura.
     */
    public void setTelemovelEmpresa(String telemovelEmpresa) throws TelemovelEmpresaErradoException {
        if (telemovelEmpresa.length() != 9) {
            throw new TelemovelEmpresaErradoException("O número de telemóvel da empresa não se encontra correto.");
        }
        int intTelemovel;
        try {
            intTelemovel = Integer.parseInt(telemovelEmpresa);
        } catch (IllegalArgumentException exception) {
            throw new TelemovelEmpresaErradoException("O número de telemóvel da empresa não se encontra correto.");
        }
        this.telemovelEmpresa = intTelemovel;
    }

    /**
     * Modifica a área pretendida pela empresa da candidatura.
     *
     * @param area nova area pretendida da candidatura.
     */
    public void setArea(String area) throws AreaErradaException {
        try {
            int intArea = Integer.parseInt(area);
            if (intArea < 0) {
                throw new AreaErradaException("A área introduzida não é válida.");
            }
            this.area = intArea;
        } catch (IllegalArgumentException exception) {
            throw new AreaErradaException("A área introduzida não é válida.");
        }

    }

    /**
     * Modifica o número de convites pretendido pela empresa da candidatura.
     *
     * @param numConvites novo número de convites da candidatura.
     */
    public void setNumConvites(String numConvites) throws NumeroConvitesErradoException {
        try {
            int intNumConvites = Integer.parseInt(numConvites);
            if (intNumConvites < 0) {
                throw new NumeroConvitesErradoException("O número de convites introduzido não é válido.");
            }
            this.numConvites = intNumConvites;
        } catch (IllegalArgumentException exception) {
            throw new NumeroConvitesErradoException("O número de convites introduzido não é válido.");
        }
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
        if (this.usernameExpositor.equalsIgnoreCase(cand.getUsernameExpositor())) {
            return true;
        } else {
            return false;
        }
    }
}
