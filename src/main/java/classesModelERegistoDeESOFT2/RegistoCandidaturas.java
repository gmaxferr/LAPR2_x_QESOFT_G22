package classesModelERegistoDeESOFT;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class RegistoCandidaturas {
    
     /**
     * Atributo lista de candidaturas
     */
    private List<Candidatura> listaCandidaturas;
    
    public RegistoCandidaturas(){
        this.listaCandidaturas = new ArrayList<>();
    }
    
    /**
     * Método que devolve a lista de candidatuas
     * 
     * @return lista de candidatuas
     */
    public List<Candidatura> getListaCandidaturas() {
        return this.listaCandidaturas;
    }
    /**
     * Método que cria uma nova candidatura
     * 
     * @return nova candidatura
     */
    public Candidatura criarCandidatura() {
        Candidatura candidatura = new Candidatura();
        return candidatura;
    }
    
    /**
     * Método que valida dados da candidatura
     * 
     * @param c candidatura
     * 
     * @return boolean que confirma a validação dos dados
     */
    public boolean validarDadosCandidatura(Candidatura c) {
        //valida candidatura
        return true;
    }
     /**
     * Método que regista candidatura
     * 
     * @param c candidatura
     */
    public void registaCandidatura(Candidatura c){
        validaCandidatua(c);
        addCandidatura(c);
    }
    
    /**
     * Método que valida candidatura
     * 
     * @param c candidatura
     */
    public void validaCandidatua(Candidatura c){
        //validação global
    }
    
     /**
     * Método que valida a candidatura
     * 
     * @param c candidatura
     * 
     * @return boolean de confirmação da validação
     */
    private boolean validaCandidatura(Candidatura c) {
        //validaçao global
        return true;

    }
     /**
     * Método que adiciona uma candidatura
     * 
     * @param c candidatura a ser adicionada
     */
    void addCandidatura(Candidatura c) {
        if (validaCandidatura(c)) {
            addCandidatura(c);
        }
    }
}
