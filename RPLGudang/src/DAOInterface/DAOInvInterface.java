package DAOInterface;

import Model.DataInv;
import Model.DataItem;
import java.util.List;

public interface DAOInvInterface {
    public void update(DataInv di, int idItem);
    public List<DataInv> getAll();
    public List<DataInv> search(String inputSearch);
    public List<DataItem> getDataItem();
    public int getIdItem(String nama, String lokasi, int harga);
}
