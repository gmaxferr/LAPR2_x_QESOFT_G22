package lapr.project.model;

import java.util.List;
import lapr.project.registos.*;

/**
 *
 * @author G29
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
     * @param d demonstração a detetar conflitos
     */
    public void detetaConflitos(Demonstracao d) {
        RegistoConflitosDemonstracao rcf = d.getRegistoConflitosDemonstracao();
        RegistoFAE rfae = d.getExpo().getRegistoFAE();
        List<FAE> lfae = rfae.getListaFAE();
        RegistoCandidaturasADemonstracoes rcd= d.getRegistoCandidaturasADemonstracao();
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
