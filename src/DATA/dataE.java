
package DATA;
import java.sql.*;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import koneksi.koneksiSPK;
import MENU.menuAwal;
import DATA.popupAnggotaE;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dataE extends javax.swing.JPanel {
private Connection conn = new koneksiSPK().connect();
private DefaultTableModel tabmode;
public String jkPD,namP;
    public dataE() {
        initComponents();noUrut();
        datatable();
        
    }
    protected void kosong(){
        noidE.setText("");
        namaE.setText("");
        pembina.setText("");
        ja.setText("");
    }
    public void itemTerpilihP(){
        popupPembina pP = new popupPembina();
        pP.dE = this;
        pembina.setText(namP);
    }
    protected void datatable(){
    Object[] Baris ={"No. ID","Nama","Pembina","Jumlah Anggota"};
    tabmode = new DefaultTableModel(null, Baris);
    String cariitem=noidE.getText();

        try {
            String sql = "SELECT * FROM e order by noidE asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a=hasil.getString("noidE");
            String b=hasil.getString("namaE");
            String c=hasil.getString("pembina");
            String d=hasil.getString("ja");

        String[] data={a,b,c,d,};
        tabmode.addRow(data);
        }
        tabelE.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
    }
    public void noUrut(){
        try {
            // 2. Ambil Nomor Urutan Terakhir
            String query = "SELECT noidE FROM e ORDER BY noidE DESC LIMIT 1";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            String lastUrutan = "";
            if (resultSet.next()) {
                lastUrutan = resultSet.getString("noidE");
            }
            
            // 3. Parse dan Tingkatkan Nomor Urutan
            String newUrutan = generateNextUrutan(lastUrutan);
            noidE.setText(newUrutan);
            
            // 4. Tampilkan Nomor Urutan Baru
            System.out.println("Nomor Urutan Berikutnya: " + newUrutan);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   private static String generateNextUrutan(String lastUrutan) {
        if (lastUrutan == null || lastUrutan.isEmpty()) {
            return "E01";
        }

        String prefix = lastUrutan.substring(0, 2);
        String numberPart = lastUrutan.substring(2);
        
        int number = Integer.parseInt(numberPart);
        number++;
        
        return prefix + String.format("%1d", number);
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataE = new javax.swing.JPanel();
        noidE = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        namaE = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        pembina = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        ja = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelE = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cariAE = new javax.swing.JButton();
        tambahE = new javax.swing.JButton();
        editE = new javax.swing.JButton();
        hapusE = new javax.swing.JButton();
        Cari = new javax.swing.JButton();
        Update = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        dataE.setBackground(new java.awt.Color(255, 255, 255));

        noidE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noidEActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Nama");

        namaE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaEActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Pembina");

        pembina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pembinaActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Jumlah Anggota");

        ja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaActionPerformed(evt);
            }
        });

        tabelE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelEMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelE);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("DAFTAR EKSTRAKURIKULER");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("No. ID");

        cariAE.setText("Cari Anggota");
        cariAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariAEActionPerformed(evt);
            }
        });

        tambahE.setText("Tambah");
        tambahE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahEActionPerformed(evt);
            }
        });

        editE.setText("Edit");
        editE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEActionPerformed(evt);
            }
        });

        hapusE.setText("Hapus");
        hapusE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusEActionPerformed(evt);
            }
        });

        Cari.setText("Cari");
        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataELayout = new javax.swing.GroupLayout(dataE);
        dataE.setLayout(dataELayout);
        dataELayout.setHorizontalGroup(
            dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataELayout.createSequentialGroup()
                .addGroup(dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataELayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dataELayout.createSequentialGroup()
                                .addGroup(dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(dataELayout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(18, 18, 18)
                                        .addComponent(ja))
                                    .addGroup(dataELayout.createSequentialGroup()
                                        .addGroup(dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(dataELayout.createSequentialGroup()
                                                    .addComponent(jLabel19)
                                                    .addGap(68, 68, 68))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataELayout.createSequentialGroup()
                                                    .addComponent(jLabel23)
                                                    .addGap(64, 64, 64)))
                                            .addGroup(dataELayout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addGap(55, 55, 55)))
                                        .addGroup(dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(pembina)
                                            .addComponent(noidE)
                                            .addComponent(namaE, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(26, 26, 26)
                                .addGroup(dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Cari)
                                    .addComponent(Update)))
                            .addGroup(dataELayout.createSequentialGroup()
                                .addComponent(tambahE, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(editE, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hapusE, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60)
                        .addGroup(dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cariAE, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dataELayout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jLabel22)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        dataELayout.setVerticalGroup(
            dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataELayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel22)
                .addGap(28, 28, 28)
                .addComponent(cariAE)
                .addGap(18, 18, 18)
                .addGroup(dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataELayout.createSequentialGroup()
                        .addGroup(dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(noidE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(namaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pembina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cari))
                        .addGap(18, 18, 18)
                        .addGroup(dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(ja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Update))
                        .addGap(31, 31, 31)
                        .addGroup(dataELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tambahE)
                            .addComponent(editE)
                            .addComponent(hapusE)))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void noidEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noidEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noidEActionPerformed

    private void namaEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaEActionPerformed

    private void pembinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pembinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pembinaActionPerformed

    private void jaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jaActionPerformed

    private void tabelEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelEMouseClicked
        int bar = tabelE.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();

        noidE.setText(a);
        namaE.setText(b);
        pembina.setText(c);
        ja.setText(d);
    }//GEN-LAST:event_tabelEMouseClicked

    private void cariAEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariAEActionPerformed
        popupAnggotaE puAE = new popupAnggotaE();
        puAE.pAE = this;
        puAE.setVisible(true);
        puAE.setResizable(false);
    }//GEN-LAST:event_cariAEActionPerformed

    private void tambahEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahEActionPerformed

        String sql="Insert into e value(?,?,?,?)";
        String sqlP="Update p set ekskulP=? where LOWER(nama)= '"+
                pembina.getText()+"'";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noidE.getText());
            stat.setString(2, namaE.getText());
            stat.setString(3, pembina.getText());
            stat.setString(4, ja.getText());
            
            stat.executeUpdate();
            PreparedStatement statP = conn.prepareStatement(sqlP);
            statP.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosong();
            noidE.requestFocus();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
        }
        datatable();
    }//GEN-LAST:event_tambahEActionPerformed

    private void editEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEActionPerformed
        try{
            String sql = "update e set noidE=?,namaE=?,pembina=?,ja=?"+
                    "where noidE ='"+noidE.getText()+"'";
            String sqlP="Update p set ekskulP=? where LOWER(namaP)= '"+
                pembina.getText()+"'";
            
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noidE.getText());
            stat.setString(2, namaE.getText());
            stat.setString(3, pembina.getText());
            stat.setString(4, ja.getText());
            stat.executeUpdate();
            
            PreparedStatement statP = conn.prepareStatement(sqlP);
            statP.setString(1, namaE.getText());
            statP.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosong();
            noidE.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal diubah"+e);
        }
        datatable();
    }//GEN-LAST:event_editEActionPerformed

    private void hapusEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusEActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","konfirmasidialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from e where noidE ='"+noidE.getText()+"'";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "data berhasil dihapus");
            kosong();
            noidE.requestFocus();
        }
        catch (SQLException e){
        JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
        }
        datatable();
        }
    }//GEN-LAST:event_hapusEActionPerformed

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
        popupPembina puP = new popupPembina();
        puP.dE = this;
        puP.setVisible(true);
        puP.setResizable(false);
    }//GEN-LAST:event_CariActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        String sqlCount = "SELECT COUNT(*) AS jumlah_anggota FROM anggotae WHERE ekskul = ?";
        String sqlUpdate = "UPDATE e SET ja = ? WHERE LOWER(namaE) = ?";

        try {
            // Hitung jumlah anggota
            PreparedStatement statCount = conn.prepareStatement(sqlCount);
            statCount.setString(1, namaE.getText());
            ResultSet rs = statCount.executeQuery();

            int jumlahAnggota = 0;
            if (rs.next()) {
                jumlahAnggota = rs.getInt("jumlah_anggota");
            }

            rs.close();
            statCount.close();

            // Update data dengan jumlah anggota
            PreparedStatement statUpdate = conn.prepareStatement(sqlUpdate);
            statUpdate.setInt(1, jumlahAnggota);
            statUpdate.setString(2, namaE.getText().toLowerCase());

            statUpdate.executeUpdate();
            statUpdate.close();

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            kosong(); // Pastikan ini didefinisikan dengan benar
            noidE.requestFocus(); // Pastikan ini adalah komponen yang valid
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan: " + e.getMessage());
        }
        datatable(); // Pastikan ini didefinisikan dengan benar

    }//GEN-LAST:event_UpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cari;
    private javax.swing.JButton Update;
    private javax.swing.JButton cariAE;
    private javax.swing.JPanel dataE;
    private javax.swing.JButton editE;
    private javax.swing.JButton hapusE;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField ja;
    private javax.swing.JTextField namaE;
    private javax.swing.JTextField noidE;
    private javax.swing.JTextField pembina;
    private javax.swing.JTable tabelE;
    private javax.swing.JButton tambahE;
    // End of variables declaration//GEN-END:variables
}
