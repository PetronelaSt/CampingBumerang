package camping.dao;

import camping.entities.Heslo;
import java.util.List;

public interface HesloDao {

    public void createHeslo(Heslo heslo);

    public void updateHeslo(Heslo heslo);

    public List<Heslo> getAll();

    public List<String> findByUzivatel(String uzivatel);

    public boolean deleteHesloById(long id);

}
