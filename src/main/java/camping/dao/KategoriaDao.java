package camping.dao;

import camping.entities.Kategoria;
import java.util.List;

public interface KategoriaDao {

    public void createKategoria(Kategoria kategoria);

    public List<Kategoria> getAll();

    public void updateKategoriu(Kategoria kategoria);

    public boolean deleteKategoriaById(long id);

    public List<Kategoria> findById(long id);

    public List<Kategoria> findByNazov(String kategoria);
}
