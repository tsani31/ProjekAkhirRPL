package DAOImplement;

import Config.Connector;
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
import DAOInterface.DAOItemInterface;

public class DAOItem implements DAOItemInterface {

    Connection conn;
    final String select = "SELECT * FROM item";
    final String selectIdItem = "SELECT * FROM item WHERE nama=? && kategori=? && lokasi=? && harga=?";
    final String search = "SELECT * FROM item WHERE nama LIKE ? OR lokasi LIKE ? OR kategori LIKE ? OR harga = ?";
    final String insert = "INSERT INTO item (nama, harga, kategori, lokasi) VALUES (?,?,?,?)";
    final String update = "UPDATE item SET nama=?, harga=?, kategori=?, lokasi=? WHERE id=?";
    final String delete = "DELETE FROM item WHERE id=?";
    final String insertInv = "INSERT INTO inventory (idItem, jumlah, subtotal) VALUES (?,?,?)";
    final String deleteInv = "DELETE FROM inventory WHERE idItem=?";

    public DAOItem() {
        conn = Connector.getConnection();
    }

    @Override
    public void insert(DataItem di) {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(insert);
            statement.setString(1, di.getNama());
            statement.setInt(2, di.getHarga());
            statement.setString(3, di.getKategori());
            statement.setString(4, di.getLokasi());

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                Notify notify = new Notify("Data berhasil ditambahkan");
                notify.setVisible(true);
            }
        } catch (SQLException ex) {
            Notify notify = new Notify("Error saat menambahkan data");
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
    public void update(DataItem di) {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(update);
            statement.setString(1, di.getNama());
            statement.setInt(2, di.getHarga());
            statement.setString(3, di.getKategori());
            statement.setString(4, di.getLokasi());
            statement.setInt(5, di.getId());
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
    public void delete(int id) {
        PreparedStatement statement = null;
        PreparedStatement statementInv = null;
        try {
            statement = conn.prepareStatement(delete);
            statement.setInt(1, id);
            statementInv = conn.prepareStatement(deleteInv);
            statementInv.setInt(1, id);
            statementInv.executeUpdate();
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                Notify notify = new Notify("Data berhasil dihapus");
                notify.setVisible(true);
            }
        } catch (SQLException ex) {
            Notify notify = new Notify("Gagal menghapus data");
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
    public List<DataItem> getAll() {
        List<DataItem> dataItem = null;
        try {
            dataItem = new ArrayList<DataItem>();
            PreparedStatement statement = conn.prepareStatement(select);
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
            Logger.getLogger(DAOItem.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return dataItem;
    }

    @Override
    public List<DataItem> search(String inputSearch) {
        List<DataItem> dataItem = null;
        try {
            dataItem = new ArrayList<DataItem>();
            PreparedStatement statement = conn.prepareStatement(search);
            statement.setString(1, "%" + inputSearch + "%");
            statement.setString(2, "%" + inputSearch + "%");
            statement.setString(3, "%" + inputSearch + "%");
            statement.setString(4, inputSearch);
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
            Logger.getLogger(DAOItem.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return dataItem;
    }

    @Override
    public int getIdInput(String nama, String kategori, String lokasi, int harga) {
        int id = 0;
        try {
            PreparedStatement statement = conn.prepareStatement(selectIdItem);
            statement.setString(1, nama);
            statement.setString(2, kategori);
            statement.setString(3, lokasi);
            statement.setInt(4, harga);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                id = result.getInt("id");
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOItem.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return id;
    }

    @Override
    public void insertInv(int id, int harga) {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(insertInv);
            statement.setInt(1, id);
            statement.setInt(2, 1);
            statement.setInt(3, harga);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Notify notify = new Notify("Error saat menambahkan data");
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
}
