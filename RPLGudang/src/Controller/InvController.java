package Controller;

import DAOImplement.DAOInv;
import DAOInterface.DAOInvInterface;
import Frame.PanelInv;
import Model.DataInv;
import Model.DataItem;
import Model.TableInv;
import Notify.Notify;
import java.util.List;

public class InvController {

    PanelInv frame;
    DAOInvInterface invDAO;
    List<DataInv> dataInv;
    List<DataItem> dataItem;

    public InvController(PanelInv frame) {
        this.frame = frame;
        invDAO = new DAOInv();
    }

    public void fillTable() {
        dataInv = invDAO.getAll();
        TableInv ti = new TableInv(dataInv);
        frame.getTable().setModel(ti);
    }

    public void filCmbItem() {
        dataItem = invDAO.getDataItem();
        int size = dataItem.size();
        for (int i = 0; i < size; i++) {
            String nama = dataItem.get(i).getNama();
            frame.getCmbItem().addItem(nama);
        }
    }

    public void cmbItemCS() {
        dataItem = invDAO.getDataItem();
        String item = frame.getCmbItem().getSelectedItem().toString();

        for (int i = 0; i < frame.getCmbItem().getItemCount(); i++) {

            String nama = dataItem.get(i).getNama();
            int harga = dataItem.get(i).getHarga();
            String kategori = dataItem.get(i).getKategori();
            String lokasi = dataItem.get(i).getLokasi();

            for (int j = 0; j < frame.getTable().getRowCount(); j++) {
                if (item.equals(frame.getTable().getValueAt(j, 1).toString())) {
                    frame.getInputJumlah().setText(frame.getTable().getValueAt(j, 5).toString());
                    frame.setId(Integer.parseInt(frame.getTable().getValueAt(j, 0).toString()));
                }
            }

            if (item.equals(nama)) {
                frame.getInputHarga().setText(String.valueOf(harga));
                frame.getInputKategori().setText(kategori);
                frame.getInputLokasi().setText(lokasi);
            }
        }
    }
    
    public void update() {
        try {
            int id = frame.getId();
            DataInv di = new DataInv();
            String nama = frame.getCmbItem().getSelectedItem().toString();
            String lokasi = frame.getInputLokasi().getText();
            String kategori = frame.getInputKategori().getText();
            int harga = Integer.parseInt(frame.getInputHarga().getText());
            int jumlah = Integer.parseInt(frame.getInputJumlah().getText());
            int subTotal = harga*jumlah;
            int idItem = invDAO.getIdItem(nama, lokasi, harga);
            
            di.setId(id);
            di.setNama(nama);
            di.setJumlah(jumlah);
            di.setSubTotal(subTotal);
            invDAO.update(di, idItem);

        } catch (NumberFormatException ex) {
            Notify notify = new Notify("Masukan inputan berupa angka");
            notify.setVisible(true);
        }
    }
    
    public void search() {
        String inputSearch = frame.getSearch();
        dataInv = invDAO.search(inputSearch);
        TableInv tp = new TableInv(dataInv);
        frame.getTable().setModel(tp);
    }
}
