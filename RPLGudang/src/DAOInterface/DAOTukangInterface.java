package DAOInterface;

import Model.DataTukang;
import java.util.List;

public interface DAOTukangInterface {
    public void insert(DataTukang dt);
    public void update(DataTukang dt);
    public void delete(int id);
    public List<DataTukang> getAll();
    public List<DataTukang> search(String inputSearch);
}
