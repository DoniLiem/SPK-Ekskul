
package DATA;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import koneksi.koneksiSPK;
import DATA.dataE;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class popupAnggotaE extends javax.swing.JFrame {
public String niss,cariitem;
private Connection conn = new koneksiSPK().connect();
private DefaultTableModel tabmode;
public dataE pAE; 
String lokasi = "src/LAPORAN/laporanAnggotaE.jasper";

    public popupAnggotaE() {
        initComponents();
        setLocationRelativeTo(null);
        datatableAE();
    }
    
    protected void datatableAE(){
    Object[] Baris ={"NIS","Nama","Kelas","Ekstrakurikuler "};
    tabmode = new DefaultTableModel(null, Baris);
    cariitem=cariE.getText();
        try {
            String sql = "SELECT * FROM anggotae where noidE like'%"+cariitem
                +"%' or ekskul like'%"+cariitem+"%' order by noidE asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String a=hasil.getString("nis");
                String b=hasil.getString("namaPD");
                String c=hasil.getString("kelas");
                String d=hasil.getString("ekskul");
                    String[] data={a,b,c,d};
                    tabmode.addRow(data);
            }
            tabelAE.setModel(tabmode);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);
        }
    }
//    public void jumlahAnggotaE() {
//
//        try {
//            // 2. Menyiapkan query untuk menghitung jumlah data di tabel b
//            String subquery = "SELECT namaPD, COUNT(*) AS jumlah_data FROM anggotae "
//                    + "where ekskul=? GROUP BY bb";
//            PreparedStatement stmt = conn.prepareStatement(subquery);
//            stmt.setString(1, cariE.getText());
//            ResultSet rs = stmt.executeQuery(subquery);
//
//            // 3. Menyiapkan query untuk memperbarui tabel a
//            String updateQuery = "UPDATE e SET ja = (SELECT COUNT(*) FROM anggotae"
//                    + " WHERE anggotae.bb = e.bb)";
//            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
//
//            // 4. Menjalankan query update
//            pstmt.executeUpdate();
//            System.out.println("Kolom 'ja' pada tabel 'a' berhasil diperbarui.");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } 
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelAE = new javax.swing.JTable();
        hapusAE = new javax.swing.JButton();
        cariE = new javax.swing.JTextField();
        cariAE = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        ja = new javax.swing.JTextField();
        Cetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("DATA ANGGOTA EKSKUL");

        tabelAE.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelAE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelAEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelAE);

        hapusAE.setText("Hapus");
        hapusAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusAEActionPerformed(evt);
            }
        });

        cariE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariEActionPerformed(evt);
            }
        });

        cariAE.setText("Cari");
        cariAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariAEActionPerformed(evt);
            }
        });

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        ja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaActionPerformed(evt);
            }
        });

        Cetak.setText("Cetak");
        Cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cariE, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cariAE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hapusAE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Cetak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(keluar)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ja, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cariE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cariAE))
                    .addComponent(hapusAE))
                .addGap(2, 2, 2)
                .addComponent(ja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keluar)
                    .addComponent(Cetak))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hapusAEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusAEActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","konfirmasidialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sqlUpdatePD = "update pd set ekskul = 'tidak ada' where nis ='"+niss+"'";
            String sqlHapusAnggotaE = "delete from anggotae where ekskul ='"+cariitem+"' and nis ='"+niss+"'";
            try{
                PreparedStatement stat1 = conn.prepareStatement(sqlUpdatePD);
                PreparedStatement stat2 = conn.prepareStatement(sqlHapusAnggotaE);
                stat1.executeUpdate();
                stat2.executeUpdate();

                JOptionPane.showMessageDialog(null, "data berhasil dihapus");

            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
            datatableAE();
        }
    }//GEN-LAST:event_hapusAEActionPerformed

    private void cariEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariEActionPerformed

    private void cariAEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariAEActionPerformed
        datatableAE();
    }//GEN-LAST:event_cariAEActionPerformed

    private void tabelAEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelAEMouseClicked
        int tabelA = tabelAE.getSelectedRow();
        niss = tabelAE.getValueAt(tabelA, 0).toString();
    }//GEN-LAST:event_tabelAEMouseClicked

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        this.dispose();
    }//GEN-LAST:event_keluarActionPerformed

    private void jaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jaActionPerformed

    private void CetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakActionPerformed
            try {
                String ekskul = cariE.getText();
                HashMap<String, Object> parameters=new HashMap<>();
                parameters.put("ekskul", ekskul);
                JasperPrint jp = JasperFillManager.fillReport(lokasi, parameters, conn);
                JasperViewer.viewReport(jp, false);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_CetakActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(popupAnggotaE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(popupAnggotaE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(popupAnggotaE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(popupAnggotaE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new popupAnggotaE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cetak;
    private javax.swing.JButton cariAE;
    private javax.swing.JTextField cariE;
    private javax.swing.JButton hapusAE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ja;
    private javax.swing.JButton keluar;
    private javax.swing.JTable tabelAE;
    // End of variables declaration//GEN-END:variables
}
