package DAOInterface;

import Model.DataItem;
import java.util.List;

public interface DAOItemInterface {
    public void insert(DataItem di);
    public void insertInv(int id, int harga);
    public void update(DataItem di);
    public void delete(int id);
    public List<DataItem> getAll();
    public List<DataItem> search(String inputSearch);
    public int getIdInput(String nama, String kategori, String lokasi, int harga);
}
