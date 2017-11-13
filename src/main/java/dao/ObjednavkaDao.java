package dao;

import entities.Objednavka;
import java.util.List;

public interface ObjednavkaDao {

    //pridanie objednavky
    Objednavka add(Objednavka Objednavka) throws DaoException;

    //hľadanie objednavky podla id
    Objednavka findById(long id);

    //hľadanie objednavky podla datumu objednavky - bude treba pretypovat na locattime
    Objednavka findById(String datumObjednavky);

    //čítanie všetkých objednavok
    List<Objednavka> getAll();

    //vymazanie objednavky podľa jej id
    Objednavka remove(String meno);
}
