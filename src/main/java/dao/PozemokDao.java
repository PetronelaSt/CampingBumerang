package dao;

import dao.DaoException;
import entities.Pozemok;
import java.util.List;

public interface PozemokDao {

    //pridanie pozemku
    Pozemok add(Pozemok pozemok) throws DaoException;

    //hľadanie pozemku podľa id
    Pozemok findById(Long id);

    //hľadanie pozemku podľa kategorie
    Pozemok findById(String kategoria);

    //čítanie všetkých pozemkov
    List<Pozemok> getAll();

    //vymazanie pozemku podľa jeho id
    Pozemok remove(Long id);

    //bude tu aj niečo s obsadenosťou? 
}
