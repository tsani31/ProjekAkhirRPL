package DAOInterface;

import Model.DataMinggu;
import Model.DataPresensi;
import Model.DataTukang;
import java.util.List;

public interface DAOPresensiInterface {
    public void insert(DataPresensi dp, int idTukang, int idMinggu);
    public void update(DataPresensi dp, int idTukang, int idMinggu);
    public void delete(int id);
    public List<DataPresensi> getAll(int idMinggu);
    public List<DataPresensi> search(String nama, int idMinggu);
    public List<DataTukang> getDataTukang();
    public List<DataMinggu> getDataMinggu();
    public int getIdTukang(String nama);
    public int getIdMinggu(String awal);
}
