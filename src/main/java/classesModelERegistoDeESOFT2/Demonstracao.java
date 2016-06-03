/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesModelERegistoDeESOFT;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class Demonstracao {

    private String descricao;
    private RegistoRecursos rrr;

    public Demonstracao() {
        this.rrr = new RegistoRecursos();
    }

    void setDescricao(String descricaoIntroduzidaPeloUtilizador) {
        this.descricao = descricaoIntroduzidaPeloUtilizador;
    }

    RegistoRecursos getRegistoRecursosDemo() {
        return this.rrr;
    }
}
