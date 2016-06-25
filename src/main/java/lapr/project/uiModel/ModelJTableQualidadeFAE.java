package lapr.project.uiModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lapr.project.model.FAE;
import lapr.project.utils.QualidadeFaeCalculo.Media;

/**
 *
 * @author Ricardo Catalao
 */
public class ModelJTableQualidadeFAE extends AbstractTableModel {

    private final transient List<Media<FAE>> infoFAEs;

    public ModelJTableQualidadeFAE(List<Media<FAE>> infoFAEs) {
        this.infoFAEs = infoFAEs;
    }

    @Override
    public int getRowCount() {
        return infoFAEs.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        Media<FAE> sel = infoFAEs.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sel.getObject().getUsernameFae();
            case 1:
                return String.valueOf(sel.getN());
            case 2:
                return String.valueOf(sel.getMediaDesvios());
            case 3:
                return String.valueOf(sel.getZ0());
            case 4:
                return sel.getDecisao() ? "Sim" : "Nao";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "FAE";
            case 1:
                return "N. submissoes";
            case 2:
                return "Média dos desvios";
            case 3:
                return "Valor observado da estatística de teste";
            case 4:
                return "Decisão alerta: (Sim / Nao)";
            default:
                return "";
        }
    }
}
