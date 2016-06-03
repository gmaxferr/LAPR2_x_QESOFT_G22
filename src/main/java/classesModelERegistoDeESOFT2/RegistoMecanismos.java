package classesModelERegistoDeESOFT;

import java.util.ArrayList;
import java.util.List;

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
