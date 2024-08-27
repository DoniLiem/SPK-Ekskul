
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

public class dataP extends javax.swing.JPanel {
private Connection conn = new koneksiSPK().connect();
private DefaultTableModel tabmode;
public String jkP;

    public dataP() {
        initComponents();
        datatable();
    }
    protected void kosong(){
        noidP.setText("");
        namaP.setText("");
        posisi.setText("");
        alamatP.setText("");
    }
    protected void datatable(){
    Object[] Baris ={"No. ID","Nama","Posisi","Jenis Kelamin","Ekskul","Alamat"};
    tabmode = new DefaultTableModel(null, Baris);
    String cariitem=noidP.getText();

        try {
            String sql = "SELECT * FROM p where noidP like '%"+cariitem
                    +"%' or namaP like'%"+cariitem+"%' order by noidP asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a=hasil.getString("noidP");
            String b=hasil.getString("namaP");
            String c=hasil.getString("posisi");
            String d=hasil.getString("jkP");
            String e=hasil.getString("ekskulP");
            String f=hasil.getString("alamatP");

        String[] data={a,b,c,d,e,f};
        tabmode.addRow(data);
        }
        tabelP.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgJK = new javax.swing.ButtonGroup();
        dataP = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelP = new javax.swing.JTable();
        tambahP = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        editP = new javax.swing.JButton();
        hapusP = new javax.swing.JButton();
        posisi = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        LP = new javax.swing.JRadioButton();
        PP = new javax.swing.JRadioButton();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        alamatP = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        noidP = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        namaP = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        cari = new javax.swing.JButton();
        cariP = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        dataP.setBackground(new java.awt.Color(255, 255, 255));

        tabelP.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelP);

        tambahP.setText("Tambah");
        tambahP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahPActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("DATA PEMBINA");

        editP.setText("Edit");
        editP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPActionPerformed(evt);
            }
        });

        hapusP.setText("Hapus");
        hapusP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusPActionPerformed(evt);
            }
        });

        posisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posisiActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Jenis Kelamin");

        bgJK.add(LP);
        LP.setText("Laki-laki");
        LP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LPActionPerformed(evt);
            }
        });

        bgJK.add(PP);
        PP.setText("Perempuan");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Alamat");

        alamatP.setColumns(20);
        alamatP.setRows(5);
        jScrollPane8.setViewportView(alamatP);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("No. ID");

        noidP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noidPActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("Nama");

        namaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaPActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setText("Posisi");

        cari.setText("Cari");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        cariP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataPLayout = new javax.swing.GroupLayout(dataP);
        dataP.setLayout(dataPLayout);
        dataPLayout.setHorizontalGroup(
            dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataPLayout.createSequentialGroup()
                        .addGroup(dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addGap(53, 53, 53)
                        .addGroup(dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(posisi, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namaP, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noidP, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dataPLayout.createSequentialGroup()
                        .addGroup(dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dataPLayout.createSequentialGroup()
                                .addComponent(LP)
                                .addGap(18, 18, 18)
                                .addComponent(PP))))
                    .addGroup(dataPLayout.createSequentialGroup()
                        .addComponent(tambahP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hapusP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataPLayout.createSequentialGroup()
                        .addComponent(cariP, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cari))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
            .addGroup(dataPLayout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dataPLayout.setVerticalGroup(
            dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel13)
                .addGap(21, 21, 21)
                .addGroup(dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataPLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(noidP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(namaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(posisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(LP)
                            .addComponent(PP))
                        .addGap(18, 18, 18)
                        .addGroup(dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tambahP)
                            .addComponent(editP)
                            .addComponent(hapusP)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataPLayout.createSequentialGroup()
                        .addGroup(dataPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cariP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cari))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabelPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPMouseClicked
        int bar = tabelP.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();

        noidP.setText(a);
        namaP.setText(b);
        posisi.setText(c);
        if(d.equalsIgnoreCase("Laki-laki")){
            LP.setSelected(true);
            PP.setSelected(false);
        }else if(d.equalsIgnoreCase("Perempuan")){
            PP.setSelected(true);
            LP.setSelected(false);
        }
        alamatP.setText(f);
    }//GEN-LAST:event_tabelPMouseClicked

    private void tambahPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahPActionPerformed
        String ekskulP="Tidak ada";
        String jkP;
        String sql="Insert into p value(?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noidP.getText());
            stat.setString(2, namaP.getText());
            stat.setString(3, posisi.getText());
            if(LP.isSelected()){
                stat.setString(4, jkP="Laki-laki");
            }else if(PP.isSelected()){
                stat.setString(4, jkP="Perempuan");
            }
            stat.setString(5, ekskulP);
            stat.setString(6, alamatP.getText());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosong();
            noidP.requestFocus();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
        }
        bgJK.clearSelection();
        datatable();
    }//GEN-LAST:event_tambahPActionPerformed

    private void editPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPActionPerformed
        try{
            String sql = "update p set noidP=?,namaP=?,posisi=?,jkP=?"+
                    ",alamatP=?  where noidP ='"+noidP.getText()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noidP.getText());
            stat.setString(2, namaP.getText());
            stat.setString(3, posisi.getText());
            if(LP.isSelected()){
                stat.setString(4, jkP="Laki-laki");
            }else if(PP.isSelected()){
                stat.setString(4, jkP="Perempuan");
            }
            stat.setString(5, alamatP.getText());
            stat.executeUpdate();
 
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosong();
            noidP.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal diubah"+e);
        }
        bgJK.clearSelection();
        datatable();
    }//GEN-LAST:event_editPActionPerformed

    private void hapusPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusPActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","konfirmasidialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from p where noidP ='"+noidP.getText()+"'";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "data berhasil dihapus");
            kosong();
            noidP.requestFocus();
        }
        catch (SQLException e){
        JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
        }
        bgJK.clearSelection();
        datatable();
        }
    }//GEN-LAST:event_hapusPActionPerformed

    private void posisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_posisiActionPerformed

    private void LPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LPActionPerformed

    private void noidPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noidPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noidPActionPerformed

    private void namaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaPActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
    Object[] Baris ={"No. ID","Nama","Posisi","Jenis Kelamin","Ekskul","Alamat"};
    tabmode = new DefaultTableModel(null, Baris);
    String cariitem=cariP.getText();

        try {
            String sql = "SELECT * FROM p where LOWER(ekskul) like '%"+cariitem
                    +"%' or LOWER(jkP) like'%"+cariitem+"%' order by nis asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a=hasil.getString("noidP");
            String b=hasil.getString("namaP");
            String c=hasil.getString("posisi");
            String d=hasil.getString("jkP");
            String e=hasil.getString("ekskulP");
            String f=hasil.getString("alamatP");

        String[] data={a,b,c,d,e,f};
        tabmode.addRow(data);
        }
        tabelP.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
    }//GEN-LAST:event_cariActionPerformed

    private void cariPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton LP;
    private javax.swing.JRadioButton PP;
    private javax.swing.JTextArea alamatP;
    private javax.swing.ButtonGroup bgJK;
    private javax.swing.JButton cari;
    private javax.swing.JTextField cariP;
    private javax.swing.JPanel dataP;
    private javax.swing.JButton editP;
    private javax.swing.JButton hapusP;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField namaP;
    private javax.swing.JTextField noidP;
    private javax.swing.JTextField posisi;
    private javax.swing.JTable tabelP;
    private javax.swing.JButton tambahP;
    // End of variables declaration//GEN-END:variables
}
