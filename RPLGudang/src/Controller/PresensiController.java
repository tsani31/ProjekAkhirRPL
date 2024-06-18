package Controller;

import DAOImplement.DAOPresensi;
import DAOInterface.DAOPresensiInterface;
import Frame.PanelPresensi;
import Model.DataMinggu;
import Model.DataPresensi;
import Model.DataTukang;
import Model.TablePresensi;
import Notify.Notify;
import java.util.List;

public class PresensiController {

    PanelPresensi frame;
    DAOPresensiInterface presensiDAO;
    List<DataPresensi> dataPresensi;
    List<DataTukang> dataTukang;
    List<DataMinggu> dataMinggu;

    public PresensiController(PanelPresensi frame) {
        this.frame = frame;
        presensiDAO = new DAOPresensi();
    }

    public void fillTable() {
        String awal = frame.getCmbMinggu().getSelectedItem().toString();
        int idMinggu = presensiDAO.getIdMinggu(awal);
        dataPresensi = presensiDAO.getAll(idMinggu);
        TablePresensi tp = new TablePresensi(dataPresensi);
        frame.getTable().setModel(tp);
    }

    public void filCmbTukang() {
        dataTukang = presensiDAO.getDataTukang();
        int size = dataTukang.size();
        for (int i = 0; i < size; i++) {
            String nama = dataTukang.get(i).getNama();
            frame.getCmbTukang().addItem(nama);
        }
    }

    public void fillCmbMinggu() {
        dataMinggu = presensiDAO.getDataMinggu();
        int size = dataMinggu.size();
        for (int i = 0; i < size; i++) {
            String awal = dataMinggu.get(i).getAwal();
            frame.getCmbMinggu().addItem(awal);
            dataPresensi = presensiDAO.getAll(dataMinggu.get(i).getId());
            TablePresensi tp = new TablePresensi(dataPresensi);
            frame.getTable().setModel(tp);
        }
    }

    public void cmbTukangCS() {
        dataTukang = presensiDAO.getDataTukang();
        for (int i = 0; i < frame.getCmbTukang().getItemCount(); i++) {
            String item = frame.getCmbTukang().getSelectedItem().toString();
            String nama = dataTukang.get(i).getNama();
            String gaji = String.valueOf(dataTukang.get(i).getGaji());
            if (item.equals(nama)) {
                frame.getInputGaji().setText(gaji);
            }
        }
    }

    public void cmbMingguCS() {
        dataMinggu = presensiDAO.getDataMinggu();
        for (int i = 0; i < frame.getCmbMinggu().getItemCount(); i++) {
            String item = frame.getCmbMinggu().getSelectedItem().toString();
            String awal = dataMinggu.get(i).getAwal();
            String akhir = dataMinggu.get(i).getAkhir();
            if (item.equals(awal)) {
                frame.getTextTanggalAkhir().setText(" Sampai - " + akhir);
            }
        }
    }

    public void insert() {
        try {
            String awal = frame.getCmbMinggu().getSelectedItem().toString();
            int idMinggu = presensiDAO.getIdMinggu(awal);
            int check = 0;
            DataPresensi dp = new DataPresensi();
            String nama = frame.getCmbTukang().getSelectedItem().toString();
            int gaji = Integer.parseInt(frame.getInputGaji().getText());
            int pengaliSubtotal = 0;
            String senin = "x", selasa = "x", rabu = "x", kamis = "x", jumat = "x", sabtu = "x", minggu = "x";

            if (frame.getCbSenin().isSelected()) {
                senin = "✓";
                pengaliSubtotal++;
            }
            if (frame.getCbSelasa().isSelected()) {
                selasa = "✓";
                pengaliSubtotal++;
            }
            if (frame.getCbRabu().isSelected()) {
                rabu = "✓";
                pengaliSubtotal++;
            }
            if (frame.getCbKamis().isSelected()) {
                kamis = "✓";
                pengaliSubtotal++;
            }
            if (frame.getCbJumat().isSelected()) {
                jumat = "✓";
                pengaliSubtotal++;
            }
            if (frame.getCbSabtu().isSelected()) {
                sabtu = "✓";
                pengaliSubtotal++;
            }
            if (frame.getCbMinggu().isSelected()) {
                minggu = "✓";
                pengaliSubtotal++;
            }

            int subtotal = pengaliSubtotal * gaji;
            int idTukang = presensiDAO.getIdTukang(nama);

            for (int i = 0; i < frame.getTable().getRowCount(); i++) {
                if (nama.equals(frame.getTable().getValueAt(i, 1))) {
                    Notify notify = new Notify("Tukang sudah ada di minggu ini");
                    notify.setVisible(true);
                    check = 1;
                }
            }
            if (check < 1) {
                dp.setNama(nama);
                dp.setGaji(gaji);
                dp.setSn(senin);
                dp.setSl(selasa);
                dp.setRb(rabu);
                dp.setKm(kamis);
                dp.setJm(jumat);
                dp.setSb(sabtu);
                dp.setMg(minggu);
                dp.setSubTotal(subtotal);
                presensiDAO.insert(dp, idTukang, idMinggu);
            }

        } catch (NumberFormatException ex) {
            Notify notify = new Notify("Masukan inputan berupa angka");
            notify.setVisible(true);
        }
    }

    public void update() {
        try {
            int id = frame.getId();
            if (id == 0) {
                Notify notify = new Notify("Pilih baris dulu");
                notify.setVisible(true);
            }
            String awal = frame.getCmbMinggu().getSelectedItem().toString();
            int idMinggu = presensiDAO.getIdMinggu(awal);
            DataPresensi dp = new DataPresensi();
            String nama = frame.getCmbTukang().getSelectedItem().toString();
            int gaji = Integer.parseInt(frame.getInputGaji().getText());
            int pengaliSubtotal = 0;
            String senin = "x", selasa = "x", rabu = "x", kamis = "x", jumat = "x", sabtu = "x", minggu = "x";

            if (frame.getCbSenin().isSelected()) {
                senin = "✓";
                pengaliSubtotal++;
            }
            if (frame.getCbSelasa().isSelected()) {
                selasa = "✓";
                pengaliSubtotal++;
            }
            if (frame.getCbRabu().isSelected()) {
                rabu = "✓";
                pengaliSubtotal++;
            }
            if (frame.getCbKamis().isSelected()) {
                kamis = "✓";
                pengaliSubtotal++;
            }
            if (frame.getCbJumat().isSelected()) {
                jumat = "✓";
                pengaliSubtotal++;
            }
            if (frame.getCbSabtu().isSelected()) {
                sabtu = "✓";
                pengaliSubtotal++;
            }
            if (frame.getCbMinggu().isSelected()) {
                minggu = "✓";
                pengaliSubtotal++;
            }

            int subtotal = pengaliSubtotal * gaji;
            int idTukang = presensiDAO.getIdTukang(nama);
            dp.setId(id);
            dp.setNama(nama);
            dp.setGaji(gaji);
            dp.setSn(senin);
            dp.setSl(selasa);
            dp.setRb(rabu);
            dp.setKm(kamis);
            dp.setJm(jumat);
            dp.setSb(sabtu);
            dp.setMg(minggu);
            dp.setSubTotal(subtotal);
            presensiDAO.update(dp, idTukang, idMinggu);

        } catch (NumberFormatException ex) {
            Notify notify = new Notify("Masukan inputan berupa angka");
            notify.setVisible(true);
        }
    }

    public void delete() {
        int id = frame.getId();
        if (id == 0) {
            Notify notify = new Notify("Pilih baris dulu");
            notify.setVisible(true);
        }
        presensiDAO.delete(id);
    }

    public void search() {
        String nama = frame.getSearch();
        String awal = frame.getCmbMinggu().getSelectedItem().toString();
        int idMinggu = presensiDAO.getIdMinggu(awal);
        dataPresensi = presensiDAO.search(nama, idMinggu);
        TablePresensi tp = new TablePresensi(dataPresensi);
        frame.getTable().setModel(tp);
    }
}
