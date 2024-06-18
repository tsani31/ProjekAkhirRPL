package DAOImplement;

import Config.Connector;
import DAOInterface.DAOPresensiInterface;
import Model.DataMinggu;
import Model.DataPresensi;
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

public class DAOPresensi implements DAOPresensiInterface {

    Connection conn;
    final String select = "SELECT * FROM presensi INNER JOIN tukang ON presensi.idTukang = tukang.id "
                        + "INNER JOIN minggu ON presensi.idMinggu = minggu.id WHERE presensi.idMinggu = ?";
    final String search = "SELECT * FROM presensi INNER JOIN tukang ON presensi.idTukang = tukang.id WHERE nama LIKE ? AND idMinggu = ?";
    final String insert = "INSERT INTO presensi (idTukang, sn, sl, rb, km, jm, sb, mg, subtotal, idMinggu) VALUES (?,?,?,?,?,?,?,?,?,?)";
    final String update = "UPDATE presensi SET idTukang=?, sn=?, sl=?, rb=?, km=?, jm=?, sb=?, mg=?, subtotal=?, idMinggu=? WHERE id=?";
    final String delete = "DELETE FROM presensi WHERE id=?";
    final String selectDataTukang = "SELECT * FROM tukang";
    final String selectIdTukang = "SELECT * FROM tukang where nama = ?";
    final String selectDataMinggu = "SELECT * FROM minggu";
    final String selectIdMinggu = "SELECT * FROM minggu where awal = ?";

    public DAOPresensi() {
        conn = Connector.getConnection();
    }

    @Override
    public void insert(DataPresensi dp, int idTukang, int idMinggu) {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(insert);
            statement.setInt(1, idTukang);
            statement.setString(2, dp.getSn());
            statement.setString(3, dp.getSl());
            statement.setString(4, dp.getRb());
            statement.setString(5, dp.getKm());
            statement.setString(6, dp.getJm());
            statement.setString(7, dp.getSb());
            statement.setString(8, dp.getMg());
            statement.setInt(9, dp.getSubTotal());
            statement.setInt(10, idMinggu);
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
    public void update(DataPresensi dp, int idTukang, int idMinggu) {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(update);
            statement.setInt(1, idTukang);
            statement.setString(2, dp.getSn());
            statement.setString(3, dp.getSl());
            statement.setString(4, dp.getRb());
            statement.setString(5, dp.getKm());
            statement.setString(6, dp.getJm());
            statement.setString(7, dp.getSb());
            statement.setString(8, dp.getMg());
            statement.setInt(9, dp.getSubTotal());
            statement.setInt(10, idMinggu);
            statement.setInt(11, dp.getId());
            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                Notify notify = new Notify("Data berhasil diperbarui");
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
    public List<DataPresensi> getAll(int idMinggu) {
        List<DataPresensi> dataPresensi = null;
        int pengaliGaji=0;
        try {
            dataPresensi = new ArrayList<DataPresensi>();
            PreparedStatement statement = conn.prepareStatement(select);
            statement.setInt(1, idMinggu);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                DataPresensi presensi = new DataPresensi();
                presensi.setId(result.getInt("presensi.id"));
                presensi.setNama(result.getString("tukang.nama"));
                presensi.setGaji(result.getInt("tukang.gaji"));
                presensi.setSn(result.getString("presensi.sn"));
                presensi.setSl(result.getString("presensi.sl"));
                presensi.setRb(result.getString("presensi.rb"));
                presensi.setKm(result.getString("presensi.km"));
                presensi.setJm(result.getString("presensi.jm"));
                presensi.setSb(result.getString("presensi.sb"));
                presensi.setMg(result.getString("presensi.mg"));
                if (presensi.getSn().equals("✓")) {
                    pengaliGaji++;
                }
                if (presensi.getSl().equals("✓")) {
                    pengaliGaji++;
                }
                if (presensi.getRb().equals("✓")) {
                    pengaliGaji++;
                }
                if (presensi.getKm().equals("✓")) {
                    pengaliGaji++;
                }
                if (presensi.getJm().equals("✓")) {
                    pengaliGaji++;
                }
                if (presensi.getSb().equals("✓")) {
                    pengaliGaji++;
                }
                if (presensi.getMg().equals("✓")) {
                    pengaliGaji++;
                }
                int subTotal = pengaliGaji * presensi.getGaji();
                presensi.setSubTotal(subTotal);
                dataPresensi.add(presensi);
                pengaliGaji = 0;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPresensi.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return dataPresensi;
    }

    @Override
    public List<DataTukang> getDataTukang() {
        List<DataTukang> dataTukang = null;
        try {
            dataTukang = new ArrayList<DataTukang>();
            PreparedStatement statement = conn.prepareStatement(selectDataTukang);
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
            Logger.getLogger(DAOPresensi.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return dataTukang;
    }

    @Override
    public int getIdTukang(String nama) {
        int id=0;
        try{
            PreparedStatement statement = conn.prepareStatement(selectIdTukang);
            statement.setString(1, nama);
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

    @Override
    public List<DataPresensi> search(String nama, int idMinggu) {
        List<DataPresensi> dataPresensi = null;
        try {
            int pengaliGaji=0;
            dataPresensi = new ArrayList<DataPresensi>();
            PreparedStatement statement = conn.prepareStatement(search);
            statement.setString(1, "%"+nama+"%");
            statement.setInt(2, idMinggu);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                DataPresensi presensi = new DataPresensi();
                presensi.setId(result.getInt("presensi.id"));
                presensi.setNama(result.getString("tukang.nama"));
                presensi.setGaji(result.getInt("tukang.gaji"));
                presensi.setSn(result.getString("presensi.sn"));
                presensi.setSl(result.getString("presensi.sl"));
                presensi.setRb(result.getString("presensi.rb"));
                presensi.setKm(result.getString("presensi.km"));
                presensi.setJm(result.getString("presensi.jm"));
                presensi.setSb(result.getString("presensi.sb"));
                presensi.setMg(result.getString("presensi.mg"));
                if (presensi.getSn().equals("✓")) {
                    pengaliGaji++;
                }
                if (presensi.getSl().equals("✓")) {
                    pengaliGaji++;
                }
                if (presensi.getRb().equals("✓")) {
                    pengaliGaji++;
                }
                if (presensi.getKm().equals("✓")) {
                    pengaliGaji++;
                }
                if (presensi.getJm().equals("✓")) {
                    pengaliGaji++;
                }
                if (presensi.getSb().equals("✓")) {
                    pengaliGaji++;
                }
                if (presensi.getMg().equals("✓")) {
                    pengaliGaji++;
                }
                int subTotal = pengaliGaji * presensi.getGaji();
                presensi.setSubTotal(subTotal);
                dataPresensi.add(presensi);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPresensi.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return dataPresensi;
    }

    @Override
    public List<DataMinggu> getDataMinggu() {
        List<DataMinggu> dataMinggu = null;
        try {
            dataMinggu = new ArrayList<DataMinggu>();
            PreparedStatement statement = conn.prepareStatement(selectDataMinggu);
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
            Logger.getLogger(DAOPresensi.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return dataMinggu;
    }

    @Override
    public int getIdMinggu(String awal) {
        int id=0;
        try{
            PreparedStatement statement = conn.prepareStatement(selectIdMinggu);
            statement.setString(1, awal);
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