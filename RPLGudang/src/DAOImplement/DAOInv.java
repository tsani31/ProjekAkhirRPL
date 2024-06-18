package DAOImplement;

import Config.Connector;
import DAOInterface.DAOInvInterface;
import Model.DataInv;
import Model.DataItem;
import Notify.Notify;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOInv implements DAOInvInterface {

    Connection conn;
    final String select = "SELECT * FROM inventory INNER JOIN item ON inventory.idItem = item.id";
    final String search = "SELECT * FROM inventory INNER JOIN item ON inventory.idItem = item.id WHERE nama LIKE ? OR lokasi LIKE ? OR kategori LIKE ? OR jumlah = ? OR harga = ?";
    final String update = "UPDATE inventory SET idItem=?, jumlah=?, subtotal=? WHERE id=?";
    final String selectDataItem = "SELECT * FROM item";
    final String selectIdItem = "SELECT * FROM item where nama = ? && lokasi = ? && harga = ?";

    public DAOInv() {
        conn = Connector.getConnection();
    }

    @Override
    public void update(DataInv di, int idItem) {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(update);
            statement.setInt(1, idItem);
            statement.setInt(2, di.getJumlah());
            statement.setInt(3, di.getSubTotal());
            statement.setInt(4, di.getId());
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                Notify notify = new Notify("Data berhasil diperbarui");
                notify.setVisible(true);
            }
        } catch (SQLException ex) {
            Notify notify = new Notify("Error saat memperbarui data");
            notify.setVisible(true);
            Logger.getLogger(DAOItem.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOItem.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<DataInv> getAll() {
        List<DataInv> dataInv = null;
        int subTotal;
        try {
            dataInv = new ArrayList<DataInv>();
            PreparedStatement statement = conn.prepareStatement(select);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                DataInv inv = new DataInv();
                inv.setId(result.getInt("inventory.id"));
                inv.setNama(result.getString("item.nama"));
                inv.setHarga(result.getInt("item.harga"));
                inv.setKategori(result.getString("item.kategori"));
                inv.setLokasi(result.getString("item.lokasi"));
                inv.setJumlah(result.getInt("inventory.jumlah"));
                subTotal = result.getInt("item.harga") * result.getInt("inventory.jumlah");
                inv.setSubTotal(subTotal);
                dataInv.add(inv);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOInv.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return dataInv;
    }

    @Override
    public List<DataInv> search(String inputSearch) {
        List<DataInv> dataInv = null;
        int subTotal;
        try {
            dataInv = new ArrayList<DataInv>();
            PreparedStatement statement = conn.prepareStatement(search);
            statement.setString(1, "%"+inputSearch+"%");
            statement.setString(2, "%" + inputSearch + "%");
            statement.setString(3, "%" + inputSearch + "%");
            statement.setString(4, inputSearch);
            statement.setString(5, inputSearch);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                DataInv inv = new DataInv();
                inv.setId(result.getInt("inventory.id"));
                inv.setNama(result.getString("item.nama"));
                inv.setHarga(result.getInt("item.harga"));
                inv.setKategori(result.getString("item.kategori"));
                inv.setLokasi(result.getString("item.lokasi"));
                inv.setJumlah(result.getInt("inventory.jumlah"));
                subTotal = result.getInt("item.harga") * result.getInt("inventory.jumlah");
                inv.setSubTotal(subTotal);
                dataInv.add(inv);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOInv.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return dataInv;
    }

    @Override
    public List<DataItem> getDataItem() {
        List<DataItem> dataItem = null;
        try {
            dataItem = new ArrayList<DataItem>();
            PreparedStatement statement = conn.prepareStatement(selectDataItem);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                DataItem item = new DataItem();
                item.setId(result.getInt("id"));
                item.setNama(result.getString("nama"));
                item.setHarga(result.getInt("harga"));
                item.setKategori(result.getString("kategori"));
                item.setLokasi(result.getString("lokasi"));
                dataItem.add(item);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOInv.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return dataItem;
    }

    @Override
    public int getIdItem(String nama, String lokasi, int harga) {
        int id=0;
        try{
            PreparedStatement statement = conn.prepareStatement(selectIdItem);
            statement.setString(1, nama);
            statement.setString(2, lokasi);
            statement.setInt(3, harga);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                id = result.getInt("id");
                return id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPresensi.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return id;
    }

}