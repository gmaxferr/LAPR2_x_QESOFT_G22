package classesModelERegistodePPROG;

import crypt.CaesarsCypher;
import exceptions.InvalidPasswordException;
import java.io.Serializable;
import java.util.Arrays;
import lapr.project.model.GestorDeExposicoes;

/**
 * Utilizador. Um utilizador registado no sistema é constituído por nome,
 * e-mail, username e password. O username e o e-mail, num sistema, têm de ser
 * únicos para cada utilizador, podendo ser iguais em sistemas diferentes,
 * enquanto que a password e o nome podem não o ser, pois não os representam, no
 * entanto são necessários para a correta criação de um perfil de Utilizador
 *
 * @author Ricardo Catalao
 */
public class Utilizador implements Serializable {

    /**
     * E-mail único do utilizador.
     */
    private String e_mail;

    /**
     * Username único do utilizador.
     */
    private String username;

    /**
     * Nome do utilizador.
     */
    private String nome;

    /**
     * Password secreta do utilizador (encriptada por razoes de segurança).
     */
    private char[] password;

    /**
     * Numero de avaliações realizadas por este utilizador com o papel de FAE.
     */
    private int nAvaliacoesDesdeSempre;

    /**
     * Variavel que diz se um utilizador é ou não FAE.
     */
    public boolean isFAE = false;

    /**
     * Variavel que diz se um utilizador é ou não Organizador.
     */
    public boolean isOrganizdor = false;

    /**
     * Variavel que diz se um utilizador é ou não Gestor de Exposições.
     */
    public boolean isGestorExposicoes = false;

    /**
     * Variavel que diz se um utilizador é ou não Representante do Expositor.
     */
    public boolean isRepresentanteExpositor = false;

    private boolean confirmacaoDoRegisto;

    /**
     * Construtor por defeito.
     */
    public Utilizador() {
        nAvaliacoesDesdeSempre = 0;
        confirmacaoDoRegisto = false;
    }

    /**
     * Construtor com todos os parametros do utilizador.
     *
     * @param nome - Nome do utilizador
     * @param e_mail - E-mail único do utilizador
     * @param username - Username do utilizador
     * @param password - Password do utilizador
     */
    public Utilizador(String nome, String e_mail, String username, String password) {
        this();
        this.nome = nome;
        this.e_mail = e_mail;
        this.username = username;
        setPassword(password.toCharArray());
    }

    /**
     * @return Retorna um objeto Gestor de exposições representado por este
     * utilizador
     */
    public GestorDeExposicoes createGestorDeExposicoes() {
        GestorDeExposicoes ge = new GestorDeExposicoes(this);
        return ge;
    }

    /**
     * @return Retorna o nome do utilizador
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return Retorna o e-mail do utilizador
     */
    public String getE_mail() {
        return e_mail;
    }

    /**
     * @return Retorna o username deste utilizador
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retorna se o utilizador tem o seu registo confirmado
     *
     * @return true se estiver já confirmado e false caso contrário
     */
    public boolean getConfirmacaoRegisto() {
        return this.confirmacaoDoRegisto;
    }

    /**
     * @return Retorna TRUE se o utilizador for válido localmente, FALSE caso
     * contrário. Um utilizador é valido se tiver todos os atributos preenchidos
     */
    public boolean isValid() {
        return !nome.trim().equals("")
                || !e_mail.trim().equals("")
                || !username.trim().equals("")
                || password.length > 0;
    }

    /**
     * Verifica se um utilizador é igual a outro.
     *
     * @param utilizador - Utilizador de comparação
     * @return true se todos os atributos forem iguais; false caso contrário
     */
    @Override
    public boolean equals(Object utilizador) {
        if (utilizador instanceof Utilizador) {
            Utilizador u = (Utilizador) utilizador;
            if (getE_mail().equals(u.getE_mail())
                    && getUsername().equals(u.getUsername())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return Retorna a password deste utilizador, encriptada.
     */
    public String getPassword(){
        return password.toString();
    }
    
    /**
     * Altera o nome do utilizador.
     *
     * @param nome Novo nome a atribuir ao utilizador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Altera o email do utilizador.
     *
     * @param e_mail Novo e-mail a atribuir ao utilizador
     */
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    /**
     * Altera o username do utilizador.
     *
     * @param username a atribuir ao utilizador
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Altera o password do utilizador.
     *
     * @param password a atribuir ao utilizador
     */
    public void setPassword(char[] password) {
        if (password.length > 0) {
            this.password = CaesarsCypher.encrypt(password, password[0]);
        } else {
            throw new InvalidPasswordException("A nova password nao pode ser vazia.");
        }
    }

    /**
     * Altera a palavra-passe de um utilizador.
     *
     * @param oldPassword - palavra-passe antiga (por razões de segurança)
     * @param newPassword - nova palavra-passe
     */
    public void changePassword(char[] oldPassword, char[] newPassword) {
        if (Arrays.equals(CaesarsCypher.encrypt(oldPassword, oldPassword[0]), this.password)) {
            setPassword(newPassword);
        }
    }

    /**
     * Verifica se uma palavra-passe passada por parâmetro corresponde à que
     * está guardada no sistema.
     *
     * @param password - Password a verificar
     * @return Retorna TRUE se a palavra-passe passada como parâmetro for igual
     * à armazenada no sistema, FALSE caso contrário
     */
    public boolean isValidPassword(char[] password) {
        return Arrays.equals(CaesarsCypher.decrypt(this.password, password[0]), password);
    }

    /**
     * @return Retorna o numero de avaliacoes realizadas por este utilizador
     * desde sempre
     */
    public int getNAvaliacoesDesdeSempre() {
        return nAvaliacoesDesdeSempre;
    }

    /**
     * Incrementa em 1 o numero de avaliacoes realizadas por este utilizador
     * deste sempre.
     */
    public void incrementAvaliacoesRegistadas() {
        nAvaliacoesDesdeSempre++;
    }

    /**
     * @return informação de um utilizador (exceto password)
     */
    public String toStringInfo() {
        return "Nome: " + this.getNome()
                + "\nUserName: " + this.getUsername()
                + "\nEmail: " + this.getE_mail();
    }

    /**
     * @return the isFAE
     */
    public boolean checkFAE() {
        return isFAE;
    }

    /**
     * @param isFAE the isFAE to set
     */
    public void setFAE(boolean isFAE) {
        this.isFAE = isFAE;
    }

    /**
     * @return the isOrganizdor
     */
    public boolean checkOrganizdor() {
        return isOrganizdor;
    }

    /**
     * @param isOrganizdor the isOrganizdor to set
     */
    public void setOrganizdor(boolean isOrganizdor) {
        this.isOrganizdor = isOrganizdor;
    }

    /**
     * @return the isGestorExposicoes
     */
    public boolean checkGestorExposicoes() {
        return isGestorExposicoes;
    }

    /**
     * @param isGestorExposicoes the isGestorExposicoes to set
     */
    public void setGestorExposicoes(boolean isGestorExposicoes) {
        this.isGestorExposicoes = isGestorExposicoes;
    }

    /**
     * @return the isRepresentanteExpositor
     */
    public boolean checkRepresentanteExpositor() {
        return isRepresentanteExpositor;
    }

    /**
     * @param isRepresentanteExpositor the isRepresentanteExpositor to set
     */
    public void setRepresentanteExpositor(boolean isRepresentanteExpositor) {
        this.isRepresentanteExpositor = isRepresentanteExpositor;
    }

    /**
     * Confirma o registo de todos os utilizadores registados atualmente.
     * Procedimento necessário para estarem aptos a exercerem qualquer função no
     * centro de exposições. Este processo é realizado por um expositor mas está
     * automatizado para facilitar os testes
     */
    public void confirmarRegistoUtilizador() {
        this.confirmacaoDoRegisto = true;
    }

}
