package Controller;

import DAOImplement.DAOAddForm;
import DAOInterface.DAOAddFormInterface;
import Frame.PanelAddForm;
import Model.DataMinggu;
import Model.TableMinggu;
import Notify.Notify;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AddFormController {

    PanelAddForm frame;
    DAOAddFormInterface addFormDAO;
    List<DataMinggu> dataMinggu;

    public AddFormController(PanelAddForm frame) {
        this.frame = frame;
        addFormDAO = new DAOAddForm();
    }

    public void insert() {
        try {
            String tanggal = frame.getInputTanggal().getText();
            String bulan = frame.getInputBulan().getText();
            String tahun = frame.getInputTahun().getText();
            String deskripsi = frame.getInputKeterangan().getText();
            
            String awal = tahun+"-"+bulan+"-"+tanggal;
            LocalDate ldAwal = LocalDate.parse(awal);
            LocalDate ldAkhir = ldAwal.plusDays(7);
            String akhir = ldAkhir.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
            addFormDAO.insert(awal, akhir, deskripsi);
        } catch (NumberFormatException ex) {
            Notify notify = new Notify("Masukan inputan berupa angka");
            notify.setVisible(true);
        }
    }
    
    public void fillTable() {
        dataMinggu = addFormDAO.getAll();
        TableMinggu tm = new TableMinggu(dataMinggu);
        frame.getTable().setModel(tm);
    }
    
    public void delete() {
        int id = frame.getId();
        if (id == 0) {
            Notify notify = new Notify("Pilih baris dulu");
            notify.setVisible(true);
        }
        addFormDAO.delete(id);
    }
    
    public void update() {
        try {
            int id = frame.getId();
            if (id == 0) {
                Notify notify = new Notify("Pilih baris dulu");
                notify.setVisible(true);
            }
            String tanggal = frame.getInputTanggal().getText();
            String bulan = frame.getInputBulan().getText();
            String tahun = frame.getInputTahun().getText();
            String deskripsi = frame.getInputKeterangan().getText();
            
            String awal = tahun+"-"+bulan+"-"+tanggal;
            LocalDate ldAwal = LocalDate.parse(awal);
            LocalDate ldAkhir = ldAwal.plusDays(7);
            String akhir = ldAkhir.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
            addFormDAO.update(awal, akhir, deskripsi, id);
        } catch (NumberFormatException ex) {
            Notify notify = new Notify("Masukan inputan berupa angka");
            notify.setVisible(true);
        }
    }
}
