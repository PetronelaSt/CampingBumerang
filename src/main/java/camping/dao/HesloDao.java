package camping.dao;

import camping.entities.Heslo;
import java.util.List;

public interface HesloDao {
    public void createHeslo (Heslo heslo);
    
    public void updateHeslo (Heslo heslo);
    
    public List<Heslo> getHeslo(String uzivatel);

    
}
