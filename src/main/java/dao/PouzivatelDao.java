package dao;

import entities.Pouzivatel;
import java.util.List;

public interface PouzivatelDao {

    //pridanie pouzivatela
    Pouzivatel add(Pouzivatel pouzivatel) throws DaoException;

    //hľadanie pouzivatela podla mena
    Pouzivatel findById(String meno);

    //čítanie všetkých pouzivatelov
    List<Pouzivatel> getAll();

    //vymazanie pouzivatela podľa jeho mena
    Pouzivatel remove(String meno);
}
