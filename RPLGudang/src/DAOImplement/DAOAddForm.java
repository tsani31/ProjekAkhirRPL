package DAOImplement;

import Config.Connector;
import DAOInterface.DAOAddFormInterface;
import Model.DataMinggu;
import Notify.Notify;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOAddForm implements DAOAddFormInterface{
    Connection conn;
    final String insert = "INSERT INTO minggu (awal, akhir, deskripsi) VALUES (?,?,?)";
    final String select = "SELECT * FROM minggu";
    final String delete = "DELETE FROM minggu WHERE id=?";
    final String update = "UPDATE minggu SET awal=?, akhir=?, deskripsi=? WHERE id=?";
    
    public DAOAddForm() {
        conn = Connector.getConnection();
        
    }

    @Override
    public void insert(String awal, String akhir, String deskripsi) {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(insert);
            statement.setString(1, awal);
            statement.setString(2, akhir);
            statement.setString(3, deskripsi);
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                Notify notify = new Notify("Data berhasil ditambahkan");
                notify.setVisible(true);
            }
        } 
        catch (SQLException ex) {
            Notify notify = new Notify("Error saat menambahkan data");
            notify.setVisible(true);
            Logger.getLogger(DAOItem.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } 
        finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOItem.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<DataMinggu> getAll() {
        List<DataMinggu> dataMinggu = null;
        try {
            dataMinggu = new ArrayList<DataMinggu>();
            PreparedStatement statement = conn.prepareStatement(select);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                DataMinggu minggu = new DataMinggu();
                minggu.setId(result.getInt("id"));
                minggu.setAwal(result.getString("awal"));
                minggu.setAkhir(result.getString("akhir"));
                minggu.setDeskripsi(result.getString("deskripsi"));
                dataMinggu.add(minggu);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAddForm.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return dataMinggu;
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(delete);
            statement.setInt(1, id);
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                Notify notify = new Notify("Data berhasil dihapus");
                notify.setVisible(true);
            }
        }
        catch (SQLException ex) {
            Notify notify = new Notify("Gagal menghapus data");
                notify.setVisible(true);
            Logger.getLogger(DAOTukang.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } 
        finally {
            try {
                statement.close();
            } catch (SQLException ex) {

                Logger.getLogger(DAOTukang.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(String awal, String akhir, String deskripsi, int id) {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(update);
            statement.setString(1, awal);
            statement.setString(2, akhir);
            statement.setString(3, deskripsi);
            statement.setInt(4, id);
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                Notify notify = new Notify("Data berhasil diperbaarui");
                notify.setVisible(true);
            }
        } 
        catch (SQLException ex) {
            Notify notify = new Notify("Error saat memperbarui data");
            notify.setVisible(true);
            Logger.getLogger(DAOItem.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } 
        finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOItem.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
    }
}
