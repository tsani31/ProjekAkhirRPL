package Controller;

import DAOImplement.DAOItem;
import Frame.PanelItem;
import Model.DataItem;
import Model.TableItem;
import Notify.Notify;
import java.util.List;
import DAOInterface.DAOItemInterface;

public class ItemController {

    PanelItem frame;
    DAOItemInterface itemDAO;
    List<DataItem> dataItem;

    public ItemController(PanelItem frame) {
        this.frame = frame;
        itemDAO = new DAOItem();
        dataItem = itemDAO.getAll();
    }

    public void fillTable() {
        dataItem = itemDAO.getAll();
        TableItem ti = new TableItem(dataItem);
        frame.getTable().setModel(ti);
    }

    public void insert() {
        try {
            DataItem di = new DataItem();
            String nama = frame.getInputNama().getText();
            String strHarga = frame.getInputHarga().getText();
            String kategori = frame.getCmbKategori().getSelectedItem().toString();
            String lokasi = frame.getInputLokasi().getText();
            
            
            if (nama.isEmpty() || strHarga.isEmpty()) {
                Notify notify = new Notify("Isi semua kolom terlebih dahulu");
                notify.setVisible(true);
                return;
            }

            int harga = Integer.parseInt(strHarga);
            
            di.setNama(nama);
            di.setHarga(harga);
            di.setKategori(kategori);
            di.setLokasi(lokasi);
            itemDAO.insert(di);
            int id = itemDAO.getIdInput(nama, kategori, lokasi, harga);
            itemDAO.insertInv(id, harga);

        } catch (NumberFormatException ex) {
            Notify notify = new Notify("Masukan inputan berupa angka");
            notify.setVisible(true);
        }
    }

    public void update() {
        try {
            DataItem di = new DataItem();
            int id = frame.getId();
            if (id == 0) {
                Notify notify = new Notify("Pilih baris dulu");
                notify.setVisible(true);
            }
            String nama = frame.getInputNama().getText();
            String strHarga = frame.getInputHarga().getText();
            String kategori = frame.getCmbKategori().getSelectedItem().toString();
            String lokasi = frame.getInputLokasi().getText();
            if (nama.isEmpty() || strHarga.isEmpty()) {
                Notify notify = new Notify("Isi semua kolom terlebih dahulu");
                notify.setVisible(true);
                return;
            }

            int harga = Integer.parseInt(strHarga);

            di.setId(id);
            di.setNama(nama);
            di.setHarga(harga);
            di.setKategori(kategori);
            di.setLokasi(lokasi);
            itemDAO.update(di);

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
        itemDAO.delete(id);
    }

    public void search() {
        String inputSearch = frame.getSearch();
        dataItem = itemDAO.search(inputSearch);
        TableItem ti = new TableItem(dataItem);
        frame.getTable().setModel(ti);
    }
}
