package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableTukang extends AbstractTableModel{
    List<DataTukang> dataTukang;

    public TableTukang(List<DataTukang> dataTukang) {
        this.dataTukang = dataTukang;
    }

    @Override
    public int getRowCount() {
        return dataTukang.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Alamat";
            case 3:
                return "No Telp.";
            case 4:
                return "Gaji Perdatang";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return dataTukang.get(row).getId();
            case 1:
                return dataTukang.get(row).getNama();
            case 2:
                return dataTukang.get(row).getAlamat();
            case 3:
                return dataTukang.get(row).getNoTelp();
            case 4:
                return dataTukang.get(row).getGaji();
            default:
                return null;
        }
    }
}
