package camping.dao;

import camping.entities.Pouzivatel;
import java.util.List;

public interface PouzivatelDao {

    public void createPouzivatela(Pouzivatel pouzivatel);

    public List<Pouzivatel> getAll();

    public void updatePouzivatela(Pouzivatel pouzivatel);

    public boolean deletePouzivatela(Pouzivatel pouzivatel);

    public void findById(Long id);
}
