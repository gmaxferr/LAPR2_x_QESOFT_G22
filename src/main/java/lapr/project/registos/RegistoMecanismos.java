package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Mecanismo;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class RegistoMecanismos {
    
    private List<Mecanismo> listaMecanismo;
    
    public RegistoMecanismos(){
        this.listaMecanismo=new ArrayList<>();
    }

    public List<Mecanismo> getListaMecanismos() {
        return this.listaMecanismo;
    }
}
