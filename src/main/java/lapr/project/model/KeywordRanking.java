package lapr.project.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe resposável por guardar o ranking global de keywords e pela exportação
 * dessa informação para um ficheiro com o formato CSV.
 *
 * @author Ricardo Catalao
 */
public class KeywordRanking implements Serializable {

    /**
     * Lista de todas as keywords presentes no ranking de keywords.
     */
    private final List<ScoredKeyword> m_keywords;

    /**
     * Variável que informa se este ranking de keywords está ou não preparado
     * para ser exportado.
     */
    private boolean m_ready;

    /**
     * Construtor sem parametros.
     */
    public KeywordRanking() {
        m_keywords = new ArrayList<>();
        m_ready = false;
    }

    /**
     * A partir do momento em que este método é chamado, este ranking
     * considera-se pronto para ser exportado.
     */
    public void setReady() {
        m_ready = true;
    }

    /**
     * @return Retorna se este ranking está ou não pronto para ser exportado
     */
    public boolean isReady() {
        return m_ready;
    }

    /**
     * Adiciona uma keyword ao ranking e atribui-lhe um score.<!-- -->Se a
     * keyword já existir dentro do ranking apenas lhe é adicionado o novo
     * score.
     *
     * @param keyword keyword a adicionar
     * @param foiAceite boolean que informa se a keyword veio de uma candidatura
     * Aceite ou Rejeitada
     */
    public void addKeyword(String keyword, boolean foiAceite) {
        int score = foiAceite ? 1 : -1;
        int i = getKeywordIndex(keyword);
        if (i == -1) {
            m_keywords.add(new ScoredKeyword(keyword, score));
        } else {
            m_keywords.get(i).setScore(m_keywords.get(i).getScore() + score);
            m_keywords.get(i).setFrequency(m_keywords.get(i).getFrequency() + 1);
        }
    }

    /**
     * Procura uma keyword pelo seu valor.
     *
     * @param keyword valor da keyword a encontrar
     * @return Devolve o index da posição onde o resultado encontrado se
     * encontra na lista ou -1 caso não tenha sido encontrado
     */
    public int getKeywordIndex(String keyword) {
        for (int i = 0; i < m_keywords.size(); i++) {
            if (m_keywords.get(i).getValue().equals(keyword)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return Devolve a lista de ScoredKeywords guardadas por este objeto
     */
    public List<ScoredKeyword> getScoredKeywords() {
        return m_keywords;
    }

    /**
     * Ordena as keywords de acordo com o seu ranking e exporta o resultado num
     * formato CSV para um ficheiro passado como parametro.
     *
     * @param saveFile ficheiro onde será exportada a informação relativa às
     * keywords
     * @return Devolve TRUE se a operação foi bem sucedida e FALSE caso
     * contrário
     */
    public boolean exportCSV(File saveFile) {
        try (Formatter out = new Formatter(saveFile)) {
            Collections.sort(m_keywords);
            Collections.reverse(m_keywords);
            out.format("Ranking,Frequency,Keyword\n");
            for (int i = 0; i < m_keywords.size(); i++) {
                ScoredKeyword keyword = m_keywords.get(i);
                out.format("%d,%d,%s\n", i + 1, keyword.getFrequency(), convertStringToCSVReadable(keyword.getValue()));
            }
            out.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KeywordRanking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Converte uma String passada como argumento para uma String possível de
     * inserir entre aspas num campo de um ficheiro de formato CSV.
     *
     * @param str String a ser formatada
     * @return Devolve uma String equivalente à passada como argumento que pode
     * ser inserida entre aspas num campo de um ficheiro CSV
     */
    public String convertStringToCSVReadable(String str) {
        StringBuilder sb = new StringBuilder(str.length() * 2 + 2);
        sb.append('"');
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (i != 0 && i != str.length() - 1 && str.charAt(i) == '"') {
                sb.append('"');
            }
        }
        sb.append('"');
        return sb.toString();
    }
}
