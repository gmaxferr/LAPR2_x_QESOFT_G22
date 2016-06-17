/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.List;
import lapr.project.registos.RegistoCandidaturaADemonstracoes;
import lapr.project.registos.RegistoConflitosDemonstracao;
import lapr.project.registos.RegistoFAE;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class MecanismoDetecaoConflitoDemonstracao {
    
    private final TipoConflitoDemonstracao tcd;

    public MecanismoDetecaoConflitoDemonstracao(TipoConflitoDemonstracao tcd) {
        this.tcd = tcd;
    }
    
    /**
     * Deteta conflitos entre Candidaturas e FAEs e regista-os no registo de
     * Conflitos da exposição correspondente.
     *
     * @param e Exposição onde serão detetados os conflitos
     */
    public void detetaConflitos(Demonstracao d) {
        RegistoConflitosDemonstracao rcf = d.getRegistoConflitosDemonstracao();
        RegistoFAE rfae = d.getExpo().getRegistoFAE();
        List<FAE> lfae = rfae.getListaFAE();
        RegistoCandidaturaADemonstracoes rcd= d.getRegistoCandidaturasADemonstracao();
        List<CandidaturaADemonstracao> lc = rcd.getListaCandidaturasADemonstracao();
        for (FAE fae : lfae) {
            for (CandidaturaADemonstracao cand : lc) {
                if (isConflito(fae, cand)) {
                    rcf.criarConflito(fae, cand, tcd);
                }
            }
        }
    }

    /**
     * Verifica se um FAE conflicte com uma candidatura.
     *
     * @param fae FAE
     * @param cand Candidatura
     * @return TRUE se o FAE e a Candidatura conflitem, FALSE caso contrário.
     */
    public boolean isConflito(FAE fae, CandidaturaADemonstracao cand) {
        //throw new UnsupportedOperationException("Não existe informação suficiente sobre como implementar este método");

        // Por razões de teste, este método retorna sempre true,
        return true;
    }
}
