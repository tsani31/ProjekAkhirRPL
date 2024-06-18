package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableItem extends AbstractTableModel {

    List<DataItem> dataItem;

    public TableItem(List<DataItem> dataItem) {
        this.dataItem = dataItem;
    }

    @Override
    public int getRowCount() {
        return dataItem.size();
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
                return "Harga";
            case 3:
                return "Kategori";
            case 4:
                return "Lokasi penyimpanan";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return dataItem.get(row).getId();
            case 1:
                return dataItem.get(row).getNama();
            case 2:
                return dataItem.get(row).getHarga();
            case 3:
                return dataItem.get(row).getKategori();
            case 4: 
                return dataItem.get(row).getLokasi();
            default:
                return null;
        }
    }
}
