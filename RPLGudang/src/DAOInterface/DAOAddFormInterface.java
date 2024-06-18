package DAOInterface;

import Model.DataMinggu;
import java.util.List;

public interface DAOAddFormInterface {
    public void insert(String awal, String akhir, String deskripsi);
    public List<DataMinggu> getAll();
    public void delete(int id);
    public void update(String awal, String akhir, String deskripsi, int id);
}
