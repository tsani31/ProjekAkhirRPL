package DAOImplement;

import Config.Connector;
import DAOInterface.DAOLoginInterface;

import Notify.Notify;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOLogin implements DAOLoginInterface {

    Connection conn;
    final String loginAdmin = "SELECT * FROM admin WHERE username=? AND password=?";
    final String loginStaff = "SELECT * FROM staff WHERE username=? AND password=?";

    public DAOLogin() {
        conn = Connector.getConnection();
    }

    @Override
    public String login(String username, String password) {
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        String result = "";
        try {
            statement = conn.prepareStatement(loginAdmin);
            statement.setString(1, username);
            statement.setString(2, password);
            statement2 = conn.prepareStatement(loginStaff);
            statement2.setString(1, username);
            statement2.setString(2, password);

            if (statement.executeQuery().next()) {
                result = "Admin";
            }
            if (statement2.executeQuery().next()) {
                result = "Staff";
            }

        } catch (SQLException ex) {
            Notify notify = new Notify("Error saat login");
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
        return result;
    }

}
