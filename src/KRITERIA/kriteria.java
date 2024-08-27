
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
import KRITERIA.popupPBK;

public class kriteria extends javax.swing.JPanel {
private Connection conn = new koneksiSPK().connect();
private DefaultTableModel tabmode;
String[] k={"","","","",""};
String[] pk={"Sangat Penting","Penting","Cukup Penting",
             "Biasa","Tidak terlalu Penting"};
double[] nAwal = {1, 3, 5, 7, 9};
int n = nAwal.length;
double[]bobotPrioritas= new double[n];
 

    public kriteria() {
        initComponents();
        datatableK();
    }
    private boolean canCalculate() {
        Set<String> selectedItems = new HashSet<>();

        // Ambil item yang dipilih dari setiap JComboBox dan cek duplikasi
        for (JComboBox<String> comboBox : new JComboBox[]{K1, K2, K3, K4, K5}) {
            String selectedItem = (String) comboBox.getSelectedItem();
            if (selectedItem != null) {
                if (!selectedItems.add(selectedItem)) {
                    return false; // Duplikasi ditemukan
                }
            }
        }

        return true; // Tidak ada duplikasi
    }
    protected void datatableK(){
    Object[] Baris ={"No. ID","Kriteria","Prioritas","Bobot Prioritas"};
    tabmode = new DefaultTableModel(null, Baris);

        try {
            String sql = "SELECT * FROM k order by noidK asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a=hasil.getString("noidK");
            String b=hasil.getString("namaK");
            String c=hasil.getString("prioritasK");
            Double d=hasil.getDouble("bobotPK");

        Object[] data={a,b,c,d};
        tabmode.addRow(data);
        }
        tabelK.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
    }
    public String[] getKriteria() {
        k[0] = (String) K1.getSelectedItem();
        k[1] = (String) K2.getSelectedItem();
        k[2] = (String) K3.getSelectedItem();
        k[3] = (String) K4.getSelectedItem();
        k[4] = (String) K5.getSelectedItem();
        return k;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelK = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        K1 = new javax.swing.JComboBox<>();
        K2 = new javax.swing.JComboBox<>();
        K3 = new javax.swing.JComboBox<>();
        K4 = new javax.swing.JComboBox<>();
        K5 = new javax.swing.JComboBox<>();
        simpanK = new javax.swing.JButton();
        hapusP = new javax.swing.JButton();
        hitung = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tabelK.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelK);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("KRITERIA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Kriteria ke-1 Sangat Penting");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Kriteria ke-2 Penting");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Kriteria ke-4 Biasa");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Kriteria ke-3 Cukup Penting");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Kriteria ke-5 Tidak terlalu Penting  ");

        K1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- KRITERIA --", "Minat", "Bakat", "Hobi", "Pengalaman", "Tempat Kegiatan" }));
        K1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                K1ActionPerformed(evt);
            }
        });

        K2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- KRITERIA --", "Minat", "Bakat", "Hobi", "Pengalaman", "Tempat Kegiatan" }));
        K2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                K2ActionPerformed(evt);
            }
        });

        K3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- KRITERIA --", "Minat", "Bakat", "Hobi", "Pengalaman", "Tempat Kegiatan" }));
        K3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                K3ActionPerformed(evt);
            }
        });

        K4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- KRITERIA --", "Minat", "Bakat", "Hobi", "Pengalaman", "Tempat Kegiatan" }));
        K4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                K4ActionPerformed(evt);
            }
        });

        K5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- KRITERIA --", "Minat", "Bakat", "Hobi", "Pengalaman", "Tempat Kegiatan" }));
        K5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                K5ActionPerformed(evt);
            }
        });

        simpanK.setText("Simpan");
        simpanK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanKActionPerformed(evt);
            }
        });

        hapusP.setText("Hapus");
        hapusP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusPActionPerformed(evt);
            }
        });

        hitung.setText("Hitung");
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(simpanK, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hapusP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(K5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(K4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(K3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(K2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(K1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(414, 414, 414))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(K1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(K2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(K3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(K4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(K5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hitung)
                            .addComponent(simpanK)
                            .addComponent(hapusP))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void K1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_K1ActionPerformed
    getKriteria();
    }//GEN-LAST:event_K1ActionPerformed

    private void K2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_K2ActionPerformed
    getKriteria();
    }//GEN-LAST:event_K2ActionPerformed

    private void K3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_K3ActionPerformed
    getKriteria();
    }//GEN-LAST:event_K3ActionPerformed

    private void K4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_K4ActionPerformed
    getKriteria();
    }//GEN-LAST:event_K4ActionPerformed

    private void K5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_K5ActionPerformed
    getKriteria();
    }//GEN-LAST:event_K5ActionPerformed

    private void simpanKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanKActionPerformed
    // Ambil data dari JComboBox
    k[0] = (String) K1.getSelectedItem();
    k[1] = (String) K2.getSelectedItem();
    k[2] = (String) K3.getSelectedItem();
    k[3] = (String) K4.getSelectedItem();
    k[4] = (String) K5.getSelectedItem();

    // SQL untuk memeriksa keberadaan data
    String checkSql = "SELECT COUNT(*) FROM k WHERE noidK = ?";
    // SQL untuk memasukkan data
    String insertSql = "INSERT INTO k (noidK, namaK, prioritasK, bobotPK) VALUES (?, ?, ?, ?)";

    try {
        // Buat PreparedStatement untuk memeriksa data
        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
        // Buat PreparedStatement untuk memasukkan data
        PreparedStatement pstmt = conn.prepareStatement(insertSql);
        boolean hasDuplicate = false;

        for (int i = 0; i < n; i++) {
            String kID = "K" + (i + 1);

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
            pstmt.setString(1, "K" + kID); 
            pstmt.setString(2, k[i]); 
            pstmt.setString(3, pk[i]); 
            pstmt.setDouble(4, bobotPrioritas[i]); 
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
        datatableK();
//       System.out.println(k[0]+bk[0]);
    }//GEN-LAST:event_simpanKActionPerformed

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
            
            ahp.printMatrix(matriksBobot);
            ahp.printMatrix(normalisasiBobot);
            JOptionPane.showMessageDialog(null, "Berhasil melakukan perhitungan");
            
            System.out.print("Data"+Arrays.toString(k));
            popupPBK puPBK = new popupPBK();
            puPBK.setText(k);
            puPBK.setMatrix(matriksBobot);
            puPBK.setSumCol(ahp.getColumnSums());
            puPBK.setNormal(normalisasiBobot);
            puPBK.setSumBar(ahp.getRowSums());
            puPBK.setBobotP(ahp.getPriorityWeights());
            
//            puPBK.dK = this;
//            puPBK.setVisible(true);
//            puPBK.setResizable(false);
        } else {
            JOptionPane.showMessageDialog(null, "Terdapat kriteria yang sama atau Double");
        }
    }//GEN-LAST:event_hitungActionPerformed

    private void hapusPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusPActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","konfirmasidialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from k";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "data berhasil dihapus");
        }
        catch (SQLException e){
        JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
        }
        datatableK();
        }
    }//GEN-LAST:event_hapusPActionPerformed

    private void tabelKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKMouseClicked

    }//GEN-LAST:event_tabelKMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> K1;
    private javax.swing.JComboBox<String> K2;
    private javax.swing.JComboBox<String> K3;
    private javax.swing.JComboBox<String> K4;
    private javax.swing.JComboBox<String> K5;
    private javax.swing.JButton hapusP;
    private javax.swing.JButton hitung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton simpanK;
    private javax.swing.JTable tabelK;
    // End of variables declaration//GEN-END:variables
}
