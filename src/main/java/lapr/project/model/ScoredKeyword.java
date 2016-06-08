package lapr.project.model;

import java.io.Serializable;

/**
 * Keyword com score.
 *
 * @author Ricardo Catalao
 */
public class ScoredKeyword extends Keyword implements Comparable<ScoredKeyword>, Serializable {

    /**
     * Score da componente keyword.
     */
    private int score;

    /**
     * Frequência desta keyword.
     */
    private int frequency;

    /**
     * Construtor da classe ScoredKeyword
     *
     * @param keyword keyword a atribuir
     * @param score score a atribuir
     */
    public ScoredKeyword(String keyword, int score) {
        super(keyword);
        this.score = score;
        this.frequency = 1;
    }

    /**
     * @return o score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score o score a atribuir
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the frequency
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof ScoredKeyword) {
            if (o == this) {
                return true;
            }
            ScoredKeyword obj = (ScoredKeyword) o;
            return obj.score == score && obj.frequency == frequency && super.equals(o);
        }
        return false;
    }

    @Override
    public int compareTo(ScoredKeyword o) {
        if (this.score < o.score) {
            return -1;
        } else if (this.score == o.score) {
            return 0;
        } else {
            return 1;
        }
    }
}
