package lapr.project.model;

import java.util.List;
import lapr.project.registos.*;

/**
 * Representação de um mecanismo deteção de conflitos
 * 
 * @author G29
 */
public class MecanismoDetecaoConflito {

    /**
     * Tipo de conflito
     */
    private final TipoConflito tc;

    /**
     * Construtor de objetos do tipo MecanismoDetecaoConflitos
     * 
     * @param tc tipo de conflito
     */
    public MecanismoDetecaoConflito(TipoConflito tc) {
        this.tc = tc;
    }
    
    /**
     * Deteta conflitos entre Candidaturas e FAEs e regista-os no registo de
     * Conflitos da exposição correspondente.
     *
     * @param e Exposição onde serão detetados os conflitos
     */
    public void detetaConflitos(Exposicao e) {
        RegistoConflitos rcf = e.getRegistoConflitos();
        RegistoFAE rfae = e.getRegistoFAE();
        List<FAE> lfae = rfae.getListaFAE();
        RegistoCandidaturasAExposicao rc = e.getRegistoCandidaturasAExposicao();
        List<CandidaturaAExposicao> lc = rc.getListaCandidaturas();
        for (FAE fae : lfae) {
            for (CandidaturaAExposicao cand : lc) {
                if (isConflito(fae, cand)) {
                    rcf.criarConflito(fae, cand, tc);
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
    public boolean isConflito(FAE fae, CandidaturaAExposicao cand) {
        //throw new UnsupportedOperationException("Não existe informação suficiente sobre como implementar este método");

        // Por razões de teste, este método retorna sempre true,
        return true;
    }
}
