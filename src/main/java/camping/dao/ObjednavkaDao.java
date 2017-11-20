package camping.dao;

import camping.entities.Objednavka;
import java.time.LocalDate;
import java.util.List;

public interface ObjednavkaDao {

    public void createObjednavku(Objednavka objednavka);

    public List<Objednavka> getAll();

    public void updateObjednavku(Objednavka objednavka);

    public boolean deleteObjednavku(Objednavka objednavka);

    public List<Objednavka> findById(Long id);

    public List<Objednavka> findByPozemokId(Long pozemok_id);

    public List<Objednavka> findByPouzivatelId(Long pouzivatel_id);

    public List<Objednavka> findByDatumObjednavky(LocalDate datumObjednavky);

    public List<Objednavka> findByDatumPrichodu(LocalDate datumPrichodu);

    public List<Objednavka> findByDatumOdchodu(LocalDate datumOdchodu);
    
     public List<Objednavka> findByPocetDni(int pocetDni);
     
      public List<Objednavka> findByPlatba(boolean platba);
   
   

}
