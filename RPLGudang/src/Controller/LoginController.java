package Controller;

import DAOImplement.DAOLogin;
import DAOInterface.DAOLoginInterface;
import Frame.FrameLogin;
import Frame.FrameRoll;
import Notify.Notify;

public class LoginController {

    FrameLogin frame;
    DAOLoginInterface loginDAO;

    public LoginController(FrameLogin frame) {
        this.frame = frame;
        loginDAO = new DAOLogin();
    }

    public void login() {
        String username = frame.getInputUsername().getText();
        String password = frame.getInputPassword().getText();

        String result = loginDAO.login(username, password);
        switch (result) {
            case "Admin":
                FrameRoll frameBaru = new FrameRoll();
                frameBaru.setUser(1);
                frameBaru.setVisible(true);
                frame.dispose();
                break;
            case "Staff": 
                FrameRoll frameBaru2 = new FrameRoll();
                frameBaru2.setUser(0);
                frameBaru2.setVisible(true);
                frame.dispose();
                break;
            default :
                Notify notify3 = new Notify("Login Gagal");
                notify3.setVisible(true);
                break;
        }

    }
}
