package camping.dao;

import camping.entities.Pozemok;
import java.util.List;

public interface PozemokDao {

    public void createPozemok(Pozemok pozemky);
    
    public List<Pozemok> getAll();

    public void updatePozemok(Pozemok pozemok);

    public boolean deletePozemokByCisloPozemku(long cisloPozemku);
    
    public boolean deletePozemokById(long id);

    public List<Pozemok> findById(long id);

    public List<Pozemok> findByCisloPozemku(long cisloPozemku);

}
