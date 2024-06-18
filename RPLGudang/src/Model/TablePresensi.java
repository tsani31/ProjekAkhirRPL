package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TablePresensi extends AbstractTableModel {

    List<DataPresensi> dataPresensi;

    public TablePresensi(List<DataPresensi> dataPresensi) {
        this.dataPresensi = dataPresensi;
    }

    @Override
    public int getRowCount() {
        return dataPresensi.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Gaji Perdatang";
            case 3:
                return "Senin";
            case 4:
                return "Selasa";
            case 5:
                return "Rabu";
            case 6:
                return "Kamis";
            case 7:
                return "Jumat";
            case 8:
                return "Sabtu";
            case 9:
                return "Minggu";
            case 10:
                return "SubTotal";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return dataPresensi.get(row).getId();
            case 1:
                return dataPresensi.get(row).getNama();
            case 2:
                return dataPresensi.get(row).getGaji();
            case 3:
                return dataPresensi.get(row).getSn();
            case 4:
                return dataPresensi.get(row).getSl();
            case 5:
                return dataPresensi.get(row).getRb();
            case 6:
                return dataPresensi.get(row).getKm();
            case 7:
                return dataPresensi.get(row).getJm();
            case 8:
                return dataPresensi.get(row).getSb();
            case 9:
                return dataPresensi.get(row).getMg();
            case 10:
                return dataPresensi.get(row).getSubTotal();

            default:
                return null;
        }
    }
}
