package Frame;

import Notify.Notify;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class FrameRoll extends javax.swing.JFrame {

    static int user;

    public static int getUser() {
        return user;
    }

    public static void setUser(int user) {
        FrameRoll.user = user;
    }
    int item, tukang, inv, presensi;

    public FrameRoll() {
        initComponents();
        initMoving(this);
        initMovingBorder(this);
        this.setLocationRelativeTo(null);
    }

    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    public void initMovingBorder(JFrame fram) {
        Border.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        Border.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    public void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelMoving = new javax.swing.JPanel();
        btPresensi = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btItem = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        btnTukang = new javax.swing.JLabel();
        btInv = new javax.swing.JLabel();
        btAddForm = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        Border = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        inputSearch = new javax.swing.JTextField();
        btExit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelMoving.setBackground(new java.awt.Color(153, 255, 0));

        btPresensi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btPresensi.setText("- Presensi");
        btPresensi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btPresensiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btPresensiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btPresensiMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Harlow Solid Italic", 1, 24)); // NOI18N
        jLabel3.setText("Menu");

        btItem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btItem.setText("- Item");
        btItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btItemMouseExited(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogout.setText("- Logout");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });

        btnTukang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTukang.setText("- Tukang");
        btnTukang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTukangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTukangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTukangMouseExited(evt);
            }
        });

        btInv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btInv.setText("- Inventory");
        btInv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btInvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btInvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btInvMouseExited(evt);
            }
        });

        btAddForm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btAddForm.setText("- Data Mingguan");
        btAddForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAddFormMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAddFormMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAddFormMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btPresensi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTukang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAddForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btInv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTukang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPresensi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAddForm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addContainerGap(325, Short.MAX_VALUE))
        );

        mainPanel.setLayout(new java.awt.BorderLayout());

        Border.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setText("Search");

        inputSearch.setText("Cari disini..");
        inputSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inputSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inputSearchMouseExited(evt);
            }
        });
        inputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputSearchKeyTyped(evt);
            }
        });

        btExit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btExit.setForeground(new java.awt.Color(255, 0, 51));
        btExit.setText("x");
        btExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BorderLayout = new javax.swing.GroupLayout(Border);
        Border.setLayout(BorderLayout);
        BorderLayout.setHorizontalGroup(
            BorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BorderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 392, Short.MAX_VALUE)
                .addComponent(btExit)
                .addContainerGap())
        );
        BorderLayout.setVerticalGroup(
            BorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BorderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BorderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Border, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Border, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btExitMouseClicked

    private void btPresensiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPresensiMouseEntered
        btPresensi.setForeground(Color.red);
    }//GEN-LAST:event_btPresensiMouseEntered

    private void btPresensiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPresensiMouseExited
        btPresensi.setForeground(Color.black);
    }//GEN-LAST:event_btPresensiMouseExited

    private void btPresensiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPresensiMouseClicked
        if (user == 0) {
            Notify notify = new Notify("Aksesibilitas Terbatas");
            notify.setVisible(true);

        } else {
            PanelPresensi panelBaru = new PanelPresensi();
            setForm(panelBaru);
            inputSearch.setEnabled(true);
            presensi = 1;
            tukang = 0;
            item = 0;
            inv = 0;
        }
    }//GEN-LAST:event_btPresensiMouseClicked

    private void inputSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputSearchMouseEntered
        inputSearch.setText("");
    }//GEN-LAST:event_inputSearchMouseEntered

    private void inputSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputSearchMouseExited
        inputSearch.setText("Cari disini..");
        if (presensi == 1) {
            PanelPresensi panelBaru = new PanelPresensi();
            setForm(panelBaru);
            panelBaru.control.fillTable();
            panelBaru.hitungTotal();
        }
        if (tukang == 1) {
            PanelTukang panelBaru = new PanelTukang();
            setForm(panelBaru);
            panelBaru.control.fillTable();
        }
        if (item == 1) {
            PanelItem panelBaru = new PanelItem();
            setForm(panelBaru);
            panelBaru.control.fillTable();
        }
        if (inv == 1) {
            PanelInv panelBaru = new PanelInv();
            setForm(panelBaru);
            panelBaru.control.fillTable();
            panelBaru.hitungTotal();
        }
    }//GEN-LAST:event_inputSearchMouseExited

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        btnLogout.setForeground(Color.red);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        btnLogout.setForeground(Color.black);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        FrameLogin panelBaru = new FrameLogin();
        panelBaru.setVisible(true);
        Notify notify = new Notify("Logout Berhasil");
        notify.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btItemMouseClicked
        PanelItem panelBaru = new PanelItem();
        setForm(panelBaru);
        inputSearch.setEnabled(true);
        presensi = 0;
        tukang = 0;
        item = 1;
        inv = 0;
    }//GEN-LAST:event_btItemMouseClicked

    private void btItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btItemMouseEntered
        btItem.setForeground(Color.red);
    }//GEN-LAST:event_btItemMouseEntered

    private void btItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btItemMouseExited
        btItem.setForeground(Color.black);
    }//GEN-LAST:event_btItemMouseExited

    private void btnTukangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTukangMouseClicked
        if (user == 0) {
            Notify notify = new Notify("Aksesibilitas Terbatas");
            notify.setVisible(true);

        } else {
            PanelTukang panelBaru = new PanelTukang();
            setForm(panelBaru);
            inputSearch.setEnabled(true);
            presensi = 0;
            tukang = 1;
            item = 0;
            inv = 0;

        }
    }//GEN-LAST:event_btnTukangMouseClicked

    private void btnTukangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTukangMouseEntered
        btnTukang.setForeground(Color.red);
    }//GEN-LAST:event_btnTukangMouseEntered

    private void btnTukangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTukangMouseExited
        btnTukang.setForeground(Color.black);
    }//GEN-LAST:event_btnTukangMouseExited

    private void inputSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputSearchKeyTyped
        String search = inputSearch.getText();
        if (presensi == 1) {
            PanelPresensi panelBaru = new PanelPresensi();
            setForm(panelBaru);
            panelBaru.setSearch(search);
            panelBaru.control.search();
            panelBaru.hitungTotal();
        }
        if (tukang == 1) {
            PanelTukang panelBaru = new PanelTukang();
            setForm(panelBaru);
            panelBaru.setSearch(search);
            panelBaru.control.search();
        }
        if (item == 1) {
            PanelItem panelBaru = new PanelItem();
            setForm(panelBaru);
            panelBaru.setSearch(search);
            panelBaru.control.search();
        }
        if (inv == 1) {
            PanelInv panelBaru = new PanelInv();
            setForm(panelBaru);
            panelBaru.setSearch(search);
            panelBaru.control.search();
            panelBaru.hitungTotal();
        }
    }//GEN-LAST:event_inputSearchKeyTyped

    private void btInvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btInvMouseClicked
        PanelInv panelBaru = new PanelInv();
        setForm(panelBaru);
        inputSearch.setEnabled(true);
        presensi = 0;
        tukang = 0;
        item = 0;
        inv = 1;
    }//GEN-LAST:event_btInvMouseClicked

    private void btInvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btInvMouseEntered
        btInv.setForeground(Color.red);
    }//GEN-LAST:event_btInvMouseEntered

    private void btInvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btInvMouseExited
        btInv.setForeground(Color.black);
    }//GEN-LAST:event_btInvMouseExited

    private void btAddFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddFormMouseClicked
        if (user == 0) {
            Notify notify = new Notify("Aksesibilitas Terbatas");
            notify.setVisible(true);

        } else {
            PanelAddForm panelBaru = new PanelAddForm();
            inputSearch.setEnabled(false);
            setForm(panelBaru);
            presensi = 0;
            tukang = 0;
            item = 0;
            inv = 0;
        }
    }//GEN-LAST:event_btAddFormMouseClicked

    private void btAddFormMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddFormMouseEntered
        btAddForm.setForeground(Color.red);
    }//GEN-LAST:event_btAddFormMouseEntered

    private void btAddFormMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddFormMouseExited
        btAddForm.setForeground(Color.black);
    }//GEN-LAST:event_btAddFormMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameRoll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameRoll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameRoll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameRoll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameRoll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Border;
    private javax.swing.JLabel btAddForm;
    private javax.swing.JLabel btExit;
    private javax.swing.JLabel btInv;
    private javax.swing.JLabel btItem;
    private javax.swing.JLabel btPresensi;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnTukang;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables

}
