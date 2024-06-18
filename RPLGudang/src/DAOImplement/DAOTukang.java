package DAOImplement;

import Config.Connector;
import DAOInterface.DAOTukangInterface;
import Model.DataTukang;
import Notify.Notify;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOTukang implements DAOTukangInterface{
    
    Connection conn;
    final String select = "SELECT * FROM Tukang";
    final String search = "SELECT * FROM Tukang WHERE nama LIKE ? OR alamat LIKE ? OR notelp LIKE ?";
    final String insert = "INSERT INTO Tukang (nama, alamat, notelp, gaji) VALUES (?,?,?,?)";
    final String update = "UPDATE Tukang SET nama=?, alamat=?, notelp=?, gaji=? WHERE id=?";
    final String delete = "DELETE FROM Tukang WHERE id=?";
    
    public DAOTukang() {
        conn = Connector.getConnection();
    }
    
    @Override
    public void insert(DataTukang dt) {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(insert);
            statement.setString(1, dt.getNama());
            statement.setString(2, dt.getAlamat());
            statement.setString(3, dt.getNoTelp());
            statement.setInt(4, dt.getGaji());
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                Notify notify = new Notify("Data berhasil ditambahkan");
                notify.setVisible(true);
            }
        }
        catch (SQLException ex) {
            Notify notify = new Notify("Error saat menambahkan data");
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
    public void update(DataTukang dt) {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(update);
            statement.setString(1, dt.getNama());
            statement.setString(2, dt.getAlamat());
            statement.setString(3, dt.getNoTelp());
            statement.setInt(4, dt.getGaji());
            statement.setInt(5, dt.getId());
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                Notify notify = new Notify("Data berhasil diperbarui");
                notify.setVisible(true);
            }
        }
        catch (SQLException ex) {
            Notify notify = new Notify("Error saat memperbarui data");
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
    public List<DataTukang> getAll() {
        List<DataTukang> dataTukang = null;
        try {
            dataTukang = new ArrayList<DataTukang>();
            PreparedStatement statement = conn.prepareStatement(select);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                DataTukang tukang = new DataTukang();
                tukang.setId(result.getInt("id"));
                tukang.setNama(result.getString("nama"));
                tukang.setAlamat(result.getString("alamat"));
                tukang.setNoTelp(result.getString("notelp"));
                tukang.setGaji(result.getInt("gaji"));
                dataTukang.add(tukang);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTukang.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return dataTukang;
    }

    @Override
    public List<DataTukang> search(String inputSearch) {
        List<DataTukang> dataTukang = null;
        try {
            dataTukang = new ArrayList<DataTukang>();
            PreparedStatement statement = conn.prepareStatement(search);
            statement.setString(1, "%"+inputSearch+"%");
            statement.setString(2, "%"+inputSearch+"%");
            statement.setString(3, "%"+inputSearch+"%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                DataTukang tukang = new DataTukang();
                tukang.setId(result.getInt("id"));
                tukang.setNama(result.getString("nama"));
                tukang.setAlamat(result.getString("alamat"));
                tukang.setNoTelp(result.getString("notelp"));
                tukang.setGaji(result.getInt("gaji"));
                dataTukang.add(tukang);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTukang.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return dataTukang;
    }
    
}
