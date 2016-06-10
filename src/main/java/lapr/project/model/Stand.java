package lapr.project.model;

import java.util.Objects;

/**
 *
 * @author Ricardo Catalao
 */
public class Stand {

    private String m_ID;
    private int m_area;

    public Stand(String m_ID, int m_area) {
        this.m_ID = m_ID;
        this.m_area = m_area;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return m_ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.m_ID = ID;
    }

    /**
     * @return the area
     */
    public int getArea() {
        return m_area;
    }

    /**
     * @param area the area to set
     */
    public void setM_area(int area) {
        this.m_area = area;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof Stand) {
            Stand stand = (Stand) obj;
            if (this.m_ID.equals(stand.getID())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.m_ID);
        hash = 11 * hash + this.m_area;
        return hash;
    }
}
