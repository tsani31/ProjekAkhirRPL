package Frame;

import Controller.PresensiController;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PanelPresensi extends javax.swing.JPanel {
    
    int id;
    String search; 
    PresensiController control;
    
    public PanelPresensi() {
        initComponents();
        control = new PresensiController(this);
        control.fillCmbMinggu();
        control.filCmbTukang();
        control.fillTable();
        hitungTotal();
    }
    
    public void hitungTotal() {
        int total = 0;
        int jumlah = table.getRowCount();
        for (int i = 0; i < jumlah; i++) {
            total = total + Integer.parseInt(table.getValueAt(i, 10).toString());
        }
        outputTotal.setText(" " + String.valueOf(total));
    }
    
    private void resetForm(){
        id = 0;
        cbSenin.setSelected(false);
        cbSelasa.setSelected(false);
        cbRabu.setSelected(false);
        cbKamis.setSelected(false);
        cbJumat.setSelected(false);
        cbSabtu.setSelected(false);
        cbMinggu.setSelected(false); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanelPresensi = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inputGaji = new javax.swing.JTextField();
        btTambah = new javax.swing.JButton();
        btPerbarui = new javax.swing.JButton();
        btBatal = new javax.swing.JButton();
        btHapus = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cbSenin = new javax.swing.JCheckBox();
        cbSelasa = new javax.swing.JCheckBox();
        cbRabu = new javax.swing.JCheckBox();
        cbKamis = new javax.swing.JCheckBox();
        cbJumat = new javax.swing.JCheckBox();
        cbSabtu = new javax.swing.JCheckBox();
        cbMinggu = new javax.swing.JCheckBox();
        cmbTukang = new javax.swing.JComboBox<>();
        outputTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbMinggu = new javax.swing.JComboBox<>();
        textTanggalAkhir = new javax.swing.JLabel();

        setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nama Tukang", "Gaji Perdatang", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel5.setText("Nama");

        jLabel8.setText("Gaji Perdatang");

        inputGaji.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        inputGaji.setEnabled(false);

        btTambah.setText("Tambah");
        btTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTambahActionPerformed(evt);
            }
        });

        btPerbarui.setText("Perbarui");
        btPerbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPerbaruiActionPerformed(evt);
            }
        });

        btBatal.setText("Clear");
        btBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatalActionPerformed(evt);
            }
        });

        btHapus.setText("Hapus");
        btHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusActionPerformed(evt);
            }
        });

        jLabel12.setText("Total gaji ");

        cbSenin.setText("Senin");

        cbSelasa.setText("Selasa");

        cbRabu.setText("Rabu");

        cbKamis.setText("Kamis");

        cbJumat.setText("Jumat");

        cbSabtu.setText("Sabtu");

        cbMinggu.setText("Minggu");

        cmbTukang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTukangItemStateChanged(evt);
            }
        });

        outputTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        outputTotal.setEnabled(false);

        jLabel6.setText("Kehadiran");

        jLabel1.setText("Tanggal : ");

        cmbMinggu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMingguItemStateChanged(evt);
            }
        });

        textTanggalAkhir.setText("- Sampai ");

        javax.swing.GroupLayout mainPanelPresensiLayout = new javax.swing.GroupLayout(mainPanelPresensi);
        mainPanelPresensi.setLayout(mainPanelPresensiLayout);
        mainPanelPresensiLayout.setHorizontalGroup(
            mainPanelPresensiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelPresensiLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(mainPanelPresensiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(mainPanelPresensiLayout.createSequentialGroup()
                        .addGroup(mainPanelPresensiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelPresensiLayout.createSequentialGroup()
                                .addComponent(btTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPerbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelPresensiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelPresensiLayout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbSenin, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbSelasa, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbRabu, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbKamis, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbJumat, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbSabtu, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbMinggu, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelPresensiLayout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cmbTukang, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(inputGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(24, 24, 24)
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(outputTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(mainPanelPresensiLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMinggu, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textTanggalAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelPresensiLayout.setVerticalGroup(
            mainPanelPresensiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelPresensiLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(mainPanelPresensiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbMinggu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTanggalAkhir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelPresensiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(inputGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTukang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(10, 10, 10)
                .addGroup(mainPanelPresensiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSenin)
                    .addComponent(cbSelasa)
                    .addComponent(cbRabu)
                    .addComponent(cbKamis)
                    .addComponent(cbJumat)
                    .addComponent(cbSabtu)
                    .addComponent(cbMinggu)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(mainPanelPresensiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btTambah)
                    .addComponent(btPerbarui)
                    .addComponent(btBatal)
                    .addComponent(btHapus))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 753, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(mainPanelPresensi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(mainPanelPresensi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(7, 7, 7)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        resetForm();
        int row = table.getSelectedRow();
        id = Integer.parseInt(table.getValueAt(row, 0).toString());
        String nama = table.getValueAt(row, 1).toString();
        String gaji = table.getValueAt(row, 2).toString();
        String senin = table.getValueAt(row, 3).toString();
        String selasa = table.getValueAt(row, 4).toString();
        String rabu = table.getValueAt(row, 5).toString();
        String kamis = table.getValueAt(row, 6).toString();
        String jumat = table.getValueAt(row, 7).toString();
        String sabtu = table.getValueAt(row, 8).toString();
        String minggu = table.getValueAt(row, 9).toString();
        
        if (senin.equals("✓")) {
            cbSenin.setSelected(true);
        }
        if (selasa.equals("✓")) {
            cbSelasa.setSelected(true);
        }
        if (rabu.equals("✓")) {
            cbRabu.setSelected(true);
        }
        if (kamis.equals("✓")) {
            cbKamis.setSelected(true);
        }
        if (jumat.equals("✓")) {
            cbJumat.setSelected(true);
        }
        if (sabtu.equals("✓")) {
            cbSabtu.setSelected(true);
        }
        if (minggu.equals("✓")) {
            cbMinggu.setSelected(true);
        }

        for (int i = 0; i < cmbTukang.getItemCount(); i++) {
            String item = cmbTukang.getItemAt(i);
            if (item.equals(nama)) {
                cmbTukang.setSelectedIndex(i);
                control.cmbTukangCS();
            }
        }
    }//GEN-LAST:event_tableMouseClicked

    private void btTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTambahActionPerformed
        control.insert();
        control.fillTable();
        hitungTotal();
        resetForm();
    }//GEN-LAST:event_btTambahActionPerformed

    private void btPerbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPerbaruiActionPerformed
        control.update();
        control.fillTable();
        hitungTotal();
        resetForm();
    }//GEN-LAST:event_btPerbaruiActionPerformed

    private void btBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatalActionPerformed
        resetForm();
    }//GEN-LAST:event_btBatalActionPerformed

    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        control.delete();
        control.fillTable();
        hitungTotal();
        resetForm();
    }//GEN-LAST:event_btHapusActionPerformed

    private void cmbTukangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTukangItemStateChanged
        control.cmbTukangCS();
    }//GEN-LAST:event_cmbTukangItemStateChanged

    private void cmbMingguItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMingguItemStateChanged
        control.cmbMingguCS();
        control.fillTable();
        hitungTotal();
    }//GEN-LAST:event_cmbMingguItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBatal;
    private javax.swing.JButton btHapus;
    private javax.swing.JButton btPerbarui;
    private javax.swing.JButton btTambah;
    private javax.swing.JCheckBox cbJumat;
    private javax.swing.JCheckBox cbKamis;
    private javax.swing.JCheckBox cbMinggu;
    private javax.swing.JCheckBox cbRabu;
    private javax.swing.JCheckBox cbSabtu;
    private javax.swing.JCheckBox cbSelasa;
    private javax.swing.JCheckBox cbSenin;
    private javax.swing.JComboBox<String> cmbMinggu;
    private javax.swing.JComboBox<String> cmbTukang;
    private javax.swing.JTextField inputGaji;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanelPresensi;
    private javax.swing.JTextField outputTotal;
    private javax.swing.JTable table;
    private javax.swing.JLabel textTanggalAkhir;
    // End of variables declaration//GEN-END:variables

    public JTextField getOutputTotal() {
        return outputTotal;
    }

    public void setOutputTotal(JTextField OutputTotal) {
        this.outputTotal = OutputTotal;
    }

    public JCheckBox getCbJumat() {
        return cbJumat;
    }

    public void setCbJumat(JCheckBox cbJumat) {
        this.cbJumat = cbJumat;
    }

    public JCheckBox getCbKamis() {
        return cbKamis;
    }

    public void setCbKamis(JCheckBox cbKamis) {
        this.cbKamis = cbKamis;
    }

    public JCheckBox getCbMinggu() {
        return cbMinggu;
    }

    public void setCbMinggu(JCheckBox cbMinggu) {
        this.cbMinggu = cbMinggu;
    }

    public JCheckBox getCbRabu() {
        return cbRabu;
    }

    public void setCbRabu(JCheckBox cbRabu) {
        this.cbRabu = cbRabu;
    }

    public JCheckBox getCbSabtu() {
        return cbSabtu;
    }

    public void setCbSabtu(JCheckBox cbSabtu) {
        this.cbSabtu = cbSabtu;
    }

    public JCheckBox getCbSelasa() {
        return cbSelasa;
    }

    public void setCbSelasa(JCheckBox cbSelasa) {
        this.cbSelasa = cbSelasa;
    }

    public JCheckBox getCbSenin() {
        return cbSenin;
    }

    public void setCbSenin(JCheckBox cbSenin) {
        this.cbSenin = cbSenin;
    }

    public JComboBox<String> getCmbMinggu() {
        return cmbMinggu;
    }

    public void setCmbMinggu(JComboBox<String> cmbMinggu) {
        this.cmbMinggu = cmbMinggu;
    }

    public JComboBox<String> getCmbTukang() {
        return cmbTukang;
    }

    public void setCmbTukang(JComboBox<String> cmbTukang) {
        this.cmbTukang = cmbTukang;
    }

    public JTextField getInputGaji() {
        return inputGaji;
    }

    public void setInputGaji(JTextField inputGaji) {
        this.inputGaji = inputGaji;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JLabel getTextTanggalAkhir() {
        return textTanggalAkhir;
    }

    public void setTextTanggalAkhir(JLabel textTanggalAkhir) {
        this.textTanggalAkhir = textTanggalAkhir;
    }
    
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
