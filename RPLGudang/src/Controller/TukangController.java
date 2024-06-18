package Controller;

import DAOImplement.DAOTukang;
import DAOInterface.DAOTukangInterface;
import Frame.PanelTukang;
import Model.DataTukang;
import Model.TableTukang;
import Notify.Notify;
import java.util.List;

public class TukangController {

    PanelTukang frame;
    DAOTukangInterface tukangDAO;
    List<DataTukang> dataTukang;

    public TukangController(PanelTukang frame) {
        this.frame = frame;
        tukangDAO = new DAOTukang();
        dataTukang = tukangDAO.getAll();
    }

    public void fillTable() {
        dataTukang = tukangDAO.getAll();
        TableTukang tt = new TableTukang(dataTukang);
        frame.getTable().setModel(tt);
    }

    public void insert() {
        try {
            DataTukang dt = new DataTukang();
            String nama = frame.getInputNama().getText();
            String alamat = frame.getInputAlamat().getText();
            String noTelp = frame.getInputNoTelp().getText();
            String strGaji = frame.getInputGaji().getText();

            if (nama.isEmpty() || alamat.isEmpty() || noTelp.isEmpty() || strGaji.isEmpty()) {
                Notify notify = new Notify("Isi semua kolom terlebih dahulu");
                notify.setVisible(true);
                return;
            }

            int gaji = Integer.parseInt(strGaji);

            dt.setNama(nama);
            dt.setAlamat(alamat);
            dt.setNoTelp(noTelp);
            dt.setGaji(gaji);
            tukangDAO.insert(dt);

        } catch (NumberFormatException ex) {
            Notify notify = new Notify("Masukan inputan berupa angka");
            notify.setVisible(true);
        }
    }

    public void update() {
        try {
            DataTukang dt = new DataTukang();
            int id = frame.getId();
            if (id == 0) {
                Notify notify = new Notify("Pilih baris dulu");
                notify.setVisible(true);
            }
            String nama = frame.getInputNama().getText();
            String alamat = frame.getInputAlamat().getText();
            String noTelp = frame.getInputNoTelp().getText();
            String strGaji = frame.getInputGaji().getText();

            if (nama.isEmpty() || alamat.isEmpty() || noTelp.isEmpty() || strGaji.isEmpty()) {
                Notify notify = new Notify("Isi semua kolom terlebih dahulu");
                notify.setVisible(true);
                return;
            }

            int gaji = Integer.parseInt(strGaji);

            dt.setNama(nama);
            dt.setAlamat(alamat);
            dt.setNoTelp(noTelp);
            dt.setGaji(gaji);
            dt.setId(id);
            tukangDAO.update(dt);

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
        tukangDAO.delete(id);
    }

    public void search() {
        String inputSearch = frame.getSearch();
        dataTukang = tukangDAO.search(inputSearch);
        TableTukang ti = new TableTukang(dataTukang);
        frame.getTable().setModel(ti);
    }
}
