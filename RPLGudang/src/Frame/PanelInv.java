package Frame;

import Controller.InvController;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PanelInv extends javax.swing.JPanel {
    
    int id;
    String search;
    InvController control;
    
    public PanelInv() {
        initComponents();
        control = new InvController(this);
        control.fillTable();
        control.filCmbItem();
        control.cmbItemCS();
        hitungTotal();
    }
    
    public void hitungTotal() {
        int total = 0;
        int jumlah = table.getRowCount();
        for (int i = 0; i < jumlah; i++) {
            total = total + Integer.parseInt(table.getValueAt(i, 6).toString());
        }
        outputTotal.setText(" " + String.valueOf(total));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanelInven = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inputHarga = new javax.swing.JTextField();
        btPerbarui = new javax.swing.JButton();
        cmbItem = new javax.swing.JComboBox<>();
        inputKategori = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        inputLokasi = new javax.swing.JTextField();
        inputJumlah = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        btMin = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        outputTotal = new javax.swing.JTextField();

        setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nama Barang", "Jumlah Barang", "Harga Satuan", "Tanggal Masuk", "Sub Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        jLabel7.setText("Harga Satuan");

        jLabel8.setText("Kategori");

        inputHarga.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        inputHarga.setEnabled(false);

        btPerbarui.setText("Perbarui");
        btPerbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPerbaruiActionPerformed(evt);
            }
        });

        cmbItem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbItemItemStateChanged(evt);
            }
        });

        inputKategori.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        inputKategori.setEnabled(false);

        jLabel9.setText("Lokasi");

        inputLokasi.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        inputLokasi.setEnabled(false);

        btAdd.setText("+");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btMin.setText("-");
        btMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMinActionPerformed(evt);
            }
        });

        jLabel10.setText("Jumlah");

        jLabel11.setText("Total");

        outputTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        outputTotal.setEnabled(false);

        javax.swing.GroupLayout mainPanelInvenLayout = new javax.swing.GroupLayout(mainPanelInven);
        mainPanelInven.setLayout(mainPanelInvenLayout);
        mainPanelInvenLayout.setHorizontalGroup(
            mainPanelInvenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelInvenLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(mainPanelInvenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelInvenLayout.createSequentialGroup()
                        .addGroup(mainPanelInvenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelInvenLayout.createSequentialGroup()
                                .addGroup(mainPanelInvenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelInvenLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputHarga))
                                    .addGroup(mainPanelInvenLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(39, 39, 39)
                                        .addComponent(cmbItem, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35)
                                .addGroup(mainPanelInvenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelInvenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(mainPanelInvenLayout.createSequentialGroup()
                                        .addComponent(btMin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btAdd))
                                    .addComponent(inputKategori)))
                            .addComponent(btPerbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelInvenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelInvenLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelInvenLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelInvenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outputTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(inputLokasi))
                        .addGap(1, 1, 1)))
                .addGap(42, 42, 42))
        );
        mainPanelInvenLayout.setVerticalGroup(
            mainPanelInvenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelInvenLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelInvenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(inputKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(inputLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelInvenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelInvenLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(mainPanelInvenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(inputHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAdd)
                            .addComponent(btMin)
                            .addComponent(jLabel10)))
                    .addGroup(mainPanelInvenLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelInvenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(outputTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btPerbarui)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(mainPanelInven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(mainPanelInven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int row = table.getSelectedRow();
        id = Integer.parseInt(table.getValueAt(row, 0).toString());
        for (int i = 0; i < cmbItem.getItemCount(); i++) {
            String item = cmbItem.getItemAt(i);
            if (item.equals(table.getValueAt(row, 1).toString())) {
                cmbItem.setSelectedIndex(i);
                control.cmbItemCS();
            }
        }
    }//GEN-LAST:event_tableMouseClicked

    private void btPerbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPerbaruiActionPerformed
        control.update();
        control.fillTable();
        hitungTotal();
    }//GEN-LAST:event_btPerbaruiActionPerformed

    private void cmbItemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbItemItemStateChanged
        control.cmbItemCS();
    }//GEN-LAST:event_cmbItemItemStateChanged

    private void btMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMinActionPerformed
        int jumlah = Integer.parseInt(inputJumlah.getText());
        jumlah--;
        String strJumlah = String.valueOf(jumlah);
        inputJumlah.setText(strJumlah);
    }//GEN-LAST:event_btMinActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        int jumlah = Integer.parseInt(inputJumlah.getText());
        jumlah++;
        String strJumlah = String.valueOf(jumlah);
        inputJumlah.setText(strJumlah);
    }//GEN-LAST:event_btAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btMin;
    private javax.swing.JButton btPerbarui;
    private javax.swing.JComboBox<String> cmbItem;
    private javax.swing.JTextField inputHarga;
    private javax.swing.JTextField inputJumlah;
    private javax.swing.JTextField inputKategori;
    private javax.swing.JTextField inputLokasi;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanelInven;
    private javax.swing.JTextField outputTotal;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public JComboBox<String> getCmbItem() {
        return cmbItem;
    }

    public void setCmbItem(JComboBox<String> cmbItem) {
        this.cmbItem = cmbItem;
    }

    public JTextField getInputHarga() {
        return inputHarga;
    }

    public void setInputHarga(JTextField inputHarga) {
        this.inputHarga = inputHarga;
    }

    public JTextField getInputJumlah() {
        return inputJumlah;
    }

    public void setInputJumlah(JTextField inputJumlah) {
        this.inputJumlah = inputJumlah;
    }

    public JTextField getInputKategori() {
        return inputKategori;
    }

    public void setInputKategori(JTextField inputKategori) {
        this.inputKategori = inputKategori;
    }

    public JTextField getInputLokasi() {
        return inputLokasi;
    }

    public void setInputLokasi(JTextField inputLokasi) {
        this.inputLokasi = inputLokasi;
    }

    public JTextField getInputTotal() {
        return outputTotal;
    }

    public void setInputTotal(JTextField inputTotal) {
        this.outputTotal = inputTotal;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
}
