package camping.dao;

import camping.entities.Objednavka;
import java.util.List;

public interface ObjednavkaDao {
    public void createObjednavku(Objednavka objednavka);
    
    public List<Objednavka> getAll();
    
    public void updateObjednavku(Objednavka objednavka);

    public void deleteObjednavku(Objednavka objednavka);

    public void findById(Long id);
}
