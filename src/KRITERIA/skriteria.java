
package KRITERIA;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksiSPK;
import KRITERIA.pembobotanAHP;
import java.awt.Dimension;
import java.util.*;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import KRITERIA.popupPBSK;

public class skriteria extends javax.swing.JPanel {
private Connection conn = new koneksiSPK().connect();
private DefaultTableModel tabmode;
String[] sk={"","",""};
String[] pk={"Penting","Cukup Penting","Biasa"};
double[] nAwal = {1, 5, 7};
int n = nAwal.length;
double[]bobotPrioritas= new double[n];
double[]bobotPrioritasSK= new double[n];
public String namaE,pilihE,pilihK;

    public skriteria() {
        initComponents();
        datatableSK();
    }
    private boolean canCalculate() {
        Set<String> selectedItems = new HashSet<>();
        // Ambil item yang dipilih dari setiap JComboBox dan cek duplikasi
        for (JComboBox<String> comboBox : new JComboBox[]{SK1, SK2, SK3}) {
            String selectedItem = (String) comboBox.getSelectedItem();
            if (selectedItem != null) {
                if (!selectedItems.add(selectedItem)) {
                    return false; // Duplikasi ditemukan
                }
            }
        }
        return true; // Tidak ada duplikasi
    }
    
    public void itemTerpilihE(){
        popupE pE = new popupE();
        pE.dE = this;
        namE.setText(namaE);
    }
    
    protected void datatableSK(){
    Object[] Baris ={"Ekstrakurikuler","Kriteria","No. ID","Sub Kriteria","Prioritas","Bobot Prioritas"};
    tabmode = new DefaultTableModel(null, Baris);

        try {
            String sql = "SELECT * FROM sk order by namaK asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a=hasil.getString("ekskul");
            String b=hasil.getString("namaK");
            String c=hasil.getString("noidSK");
            String d=hasil.getString("namaSK");
            String e=hasil.getString("prioritasSK");
            Double f=hasil.getDouble("bobotSK");

        Object[] data={a,b,c,d,e,f};
        tabmode.addRow(data);
        }
        tabelSK.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
    }
    public String[] getSKriteria() {
        sk[0] = (String) SK1.getSelectedItem();
        sk[1] = (String) SK2.getSelectedItem();
        sk[2] = (String) SK3.getSelectedItem();
        return sk;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kriteria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelSK = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        hitung = new javax.swing.JButton();
        SK1 = new javax.swing.JComboBox<>();
        SK2 = new javax.swing.JComboBox<>();
        SK3 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cariE = new javax.swing.JButton();
        namE = new javax.swing.JTextField();
        cariSK = new javax.swing.JButton();
        cariSKE = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Pilih Kriteria");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Sub kriteria ke-2  Cukup Penting");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Sub kriteria ke-1  Penting");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Sub kriteria ke-3 Biasa");

        kriteria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- KRITERIA --", "Minat", "Bakat", "Hobi", "Pengalaman", "Tempat Kegiatan" }));
        kriteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kriteriaActionPerformed(evt);
            }
        });

        tabelSK.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelSK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSKMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelSK);

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        hitung.setText("Hitung");
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });

        SK1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SUB KRITERIA --" }));
        SK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SK1ActionPerformed(evt);
            }
        });

        SK2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SUB KRITERIA --" }));
        SK2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SK2ActionPerformed(evt);
            }
        });

        SK3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SUB KRITERIA --", " " }));
        SK3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SK3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("SUB-KRITERIA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Pilih Ekstrakurikuler");

        cariE.setText("Cari");
        cariE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariEActionPerformed(evt);
            }
        });

        cariSK.setText("Cari");
        cariSK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariSKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SK3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(kriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(namE, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cariE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cariSKE, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cariSK))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(jLabel1)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cariSK)
                    .addComponent(cariSKE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cariE)
                            .addComponent(namE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(kriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(SK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(SK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(SK3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simpan)
                            .addComponent(hapus)
                            .addComponent(hitung))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void kriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kriteriaActionPerformed
        if (kriteria.getSelectedItem().equals("Minat")){
            SK1.removeAllItems();SK1.addItem("-- SUB KRITERIA --");
            SK2.removeAllItems();SK2.addItem("-- SUB KRITERIA --");
            SK3.removeAllItems();SK3.addItem("-- SUB KRITERIA --");
            SK1.addItem("Sangat Berminat");SK1.addItem("Berminat");SK1.addItem("Cukup Berminat");
            SK2.addItem("Sangat Berminat");SK2.addItem("Berminat");SK2.addItem("Cukup Berminat");
            SK3.addItem("Sangat Berminat");SK3.addItem("Berminat");SK3.addItem("Cukup Berminat");
        }else
            if (kriteria.getSelectedItem().equals("Bakat")){
                SK1.removeAllItems();SK1.addItem("-- SUB KRITERIA --");
                SK2.removeAllItems();SK2.addItem("-- SUB KRITERIA --");
                SK3.removeAllItems();SK3.addItem("-- SUB KRITERIA --");
                SK1.addItem("Olahraga");SK1.addItem("Akademis");SK1.addItem("Seni dan Karya");
                SK2.addItem("Olahraga");SK2.addItem("Akademis");SK2.addItem("Seni dan Karya");
                SK3.addItem("Olahraga");SK3.addItem("Akademis");SK3.addItem("Seni dan Karya");
        }else
            if (kriteria.getSelectedItem().equals("Hobi")){
                SK1.removeAllItems();SK1.addItem("-- SUB KRITERIA --");
                SK2.removeAllItems();SK2.addItem("-- SUB KRITERIA --");
                SK3.removeAllItems();SK3.addItem("-- SUB KRITERIA --");
                SK1.addItem("Olahraga/Aktivitas Fisik");SK1.addItem("Studi dan Pengetahuan");SK1.addItem("Seni dan Kreativitas");
                SK2.addItem("Olahraga/Aktivitas Fisik");SK2.addItem("Studi dan Pengetahuan");SK2.addItem("Seni dan Kreativitas");
                SK3.addItem("Olahraga/Aktivitas Fisik");SK3.addItem("Studi dan Pengetahuan");SK3.addItem("Seni dan Kreativitas");
        }else
            if (kriteria.getSelectedItem().equals("Pengalaman")){
                SK1.removeAllItems();SK1.addItem("-- SUB KRITERIA --");
                SK2.removeAllItems();SK2.addItem("-- SUB KRITERIA --");
                SK3.removeAllItems();SK3.addItem("-- SUB KRITERIA --");
                SK1.addItem("2 Tahun");SK1.addItem("1 Tahun");SK1.addItem("Tidak ada");
                SK2.addItem("2 Tahun");SK2.addItem("1 Tahun");SK2.addItem("Tidak ada");
                SK3.addItem("2 Tahun");SK3.addItem("1 Tahun");SK3.addItem("Tidak ada");
        }else 
            if (kriteria.getSelectedItem().equals("Tempat Kegiatan")){
                SK1.removeAllItems();SK1.addItem("-- SUB KRITERIA --");
                SK2.removeAllItems();SK2.addItem("-- SUB KRITERIA --");
                SK3.removeAllItems();SK3.addItem("-- SUB KRITERIA --");
                SK1.addItem("Ruang Terbuka");SK1.addItem("Ruang Tertutup");SK1.addItem("Keduanya");
                SK2.addItem("Ruang Terbuka");SK2.addItem("Ruang Tertutup");SK2.addItem("Keduanya");
                SK3.addItem("Ruang Terbuka");SK3.addItem("Ruang Tertutup");SK3.addItem("Keduanya");
        }
    }//GEN-LAST:event_kriteriaActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // Ambil data dari JComboBox
    String K = (String) kriteria.getSelectedItem();  
    sk[0] = (String) SK1.getSelectedItem();
    sk[1] = (String) SK2.getSelectedItem();
    sk[2] = (String) SK3.getSelectedItem();

    // SQL untuk memeriksa keberadaan data
    String checkSql = "SELECT COUNT(*) FROM sk WHERE noidSK = ?";
    // SQL untuk memasukkan data
    String insertSql = "INSERT INTO sk (ekskul, namaK, noidSK, namaSK, prioritasSK, "
                     + "bobotSK) VALUES (?, ?, ?, ?, ?, ?)";

    try {
        // Buat PreparedStatement untuk memeriksa data
        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
        // Buat PreparedStatement untuk memasukkan data
        PreparedStatement pstmt = conn.prepareStatement(insertSql);
        boolean hasDuplicate = false;

        for (int i = 0; i < n; i++) {
            String kID = "SK" + (i + 1);
            // Periksa apakah data sudah ada
            checkStmt.setString(1, kID);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            // Jika data sudah ada, tampilkan pesan dialog dan set flag duplikasi
            if (count > 0) {
                hasDuplicate = true;
                break;
            }
            // Jika data belum ada, masukkan ke database
            pstmt.setString(1, namaE);
            pstmt.setString(2, K);
            pstmt.setString(3, "K" + kID); 
            
            pstmt.setString(4, sk[i]); 
            pstmt.setString(5, pk[i]); 
            pstmt.setDouble(6, bobotPrioritasSK[i]); 
            pstmt.addBatch();
        }

        if (hasDuplicate) {
            JOptionPane.showMessageDialog(null, "Data tidak bisa sama atau duplikat");
        } else {
            // Eksekusi batch hanya jika tidak ada duplikasi
            pstmt.executeBatch();
            System.out.println("Data berhasil dimasukkan");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data gagal dimasukkan: " + e);
        e.printStackTrace();
    }
        datatableSK();
//       System.out.println(k[0]+bk[0]);
    }//GEN-LAST:event_simpanActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","konfirmasidialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from sk where ekskul ='"+pilihE+
                         "' and namaK ='"+pilihK+"'";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "data berhasil dihapus");
            namE.requestFocus();
        }
        catch (SQLException e){
        JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
        }
        datatableSK();
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungActionPerformed
        if (canCalculate()) {
            pembobotanAHP ahp = new pembobotanAHP(n,nAwal);//buat objek untuk akses class
            double[][] matriksBobot=ahp.getMatrix(); //ambil matriks yang sudah diinisialisasi
            ahp.sumColumns();//menjumlahkan nilai kolom
            
            double[] jmlhKolom=ahp.getColumnSums();//ambil nilai jumlah kolom
            ahp.normalizeMatrix();//normalisasi nilai
            
            double[][] normalisasiBobot=ahp.getNormalizedMatrix();//ambil nilai normalisasi
            ahp.sumRows();//menjumlahkan nilai baris
            
            double[] jmlhBaris=ahp.getRowSums();//amnil niali jumlah baris
            ahp.calculatePriorityWeights();//menghitung bobot prioritas
            bobotPrioritas=ahp.getPriorityWeights();//ambil nilai bobot prioritas
            
            for (int i=0; i<bobotPrioritasSK.length; i++){
                double nilai=bobotPrioritas[i]/bobotPrioritas[0];
                bobotPrioritasSK[i] = Math.round(nilai * 100.0) / 100.0;
            }
            
            ahp.printMatrix(matriksBobot);
            ahp.printMatrix(normalisasiBobot);
            JOptionPane.showMessageDialog(null, "Berhasil melakukan perhitungan");
            
            System.out.print("Data"+Arrays.toString(sk));
            popupPBSK puPBSK = new popupPBSK();
            puPBSK.setText(sk);
            puPBSK.setMatrix(matriksBobot);
            puPBSK.setSumCol(ahp.getColumnSums());
            puPBSK.setNormal(normalisasiBobot);
            puPBSK.setSumBar(ahp.getRowSums());
            puPBSK.setBobotP(ahp.getPriorityWeights());
            
//            puPBSK.dSK = this;
//            puPBSK.setVisible(true);
//            puPBSK.setResizable(false);
        } else {
            JOptionPane.showMessageDialog(null, "Terdapat kriteria yang sama atau Double");
        }
    }//GEN-LAST:event_hitungActionPerformed

    private void SK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SK1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SK1ActionPerformed

    private void SK2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SK2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SK2ActionPerformed

    private void SK3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SK3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SK3ActionPerformed

    private void cariEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariEActionPerformed
        popupE puE = new popupE();
        puE.dE = this;
        puE.setVisible(true);
        puE.setResizable(false);
    }//GEN-LAST:event_cariEActionPerformed

    private void cariSKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariSKActionPerformed
        Object[] Baris ={"Ekstrakurikuler","Kriteria","No. ID","Sub Kriteria","Prioritas","Bobot Prioritas"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem=cariSKE.getText();
        
        try {
            String sql = "SELECT * FROM sk where ekskul like '%"+cariitem
                    +"%' or namaK like'%"+cariitem+"%' order by namaK asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a=hasil.getString("ekskul");
            String b=hasil.getString("namaK");
            String c=hasil.getString("noidSK");
            String d=hasil.getString("namaSK");
            String e=hasil.getString("prioritasSK");
            Double f=hasil.getDouble("bobotSK");

        Object[] data={a,b,c,d,e,f};
        tabmode.addRow(data);
        }
        tabelSK.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
    }//GEN-LAST:event_cariSKActionPerformed

    private void tabelSKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSKMouseClicked
        int bar = tabelSK.getSelectedRow();
        pilihE = tabmode.getValueAt(bar, 0).toString();
        pilihK = tabmode.getValueAt(bar, 1).toString();
    }//GEN-LAST:event_tabelSKMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> SK1;
    private javax.swing.JComboBox<String> SK2;
    private javax.swing.JComboBox<String> SK3;
    private javax.swing.JButton cariE;
    private javax.swing.JButton cariSK;
    private javax.swing.JTextField cariSKE;
    private javax.swing.JButton hapus;
    private javax.swing.JButton hitung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kriteria;
    private javax.swing.JTextField namE;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabelSK;
    // End of variables declaration//GEN-END:variables
}
