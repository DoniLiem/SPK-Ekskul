
package DATA;
import java.sql.*;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import koneksi.koneksiSPK;
import MENU.menuAwal;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dataPD extends javax.swing.JPanel {
private Connection conn = new koneksiSPK().connect();
private DefaultTableModel tabmode;
public String jkPD;
    public dataPD() {
        initComponents();
        datatable();
    }
    protected void kosong(){
        nis.setText("");
        namaPD.setText("");
        kelas.setText("");
        alamatPD.setText("");
    }
    protected void datatable(){
    Object[] Baris ={"NIS","Nama","Kelas","Jenis Kelamin","Ekskul","Alamat"};
    tabmode = new DefaultTableModel(null, Baris);
    String cariitem=nis.getText();

        try {
            String sql = "SELECT * FROM pd where nis like '%"+cariitem
                    +"%' or nama like'%"+cariitem+"%' order by nis asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a=hasil.getString("nis");
            String b=hasil.getString("nama");
            String c=hasil.getString("kelas");
            String d=hasil.getString("jkPD");
            String e=hasil.getString("ekskul");
            String f=hasil.getString("alamat");

        String[] data={a,b,c,d,e,f};
        tabmode.addRow(data);
        }
        tabelPD.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgJK = new javax.swing.ButtonGroup();
        dataPD = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPD = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nis = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        namaPD = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        kelas = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        LPD = new javax.swing.JRadioButton();
        PPD = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        alamatPD = new javax.swing.JTextArea();
        cariPD = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        hapusPD = new javax.swing.JButton();
        tambahPD = new javax.swing.JButton();
        editPD = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        dataPD.setBackground(new java.awt.Color(255, 255, 255));

        tabelPD.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPD);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("DATA PESERTA DIDIK");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("NIS");

        nis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nisActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Nama");

        namaPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaPDActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Kelas");

        kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelasActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Jenis Kelamin");

        bgJK.add(LPD);
        LPD.setText("Laki-laki");
        LPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LPDActionPerformed(evt);
            }
        });

        bgJK.add(PPD);
        PPD.setText("Perempuan");
        PPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPDActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Alamat");

        alamatPD.setColumns(20);
        alamatPD.setRows(5);
        jScrollPane5.setViewportView(alamatPD);

        cariPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariPDActionPerformed(evt);
            }
        });

        cari.setText("Cari");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        hapusPD.setText("Hapus");
        hapusPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusPDActionPerformed(evt);
            }
        });

        tambahPD.setText("Tambah");
        tambahPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahPDActionPerformed(evt);
            }
        });

        editPD.setText("Edit");
        editPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataPDLayout = new javax.swing.GroupLayout(dataPD);
        dataPD.setLayout(dataPDLayout);
        dataPDLayout.setHorizontalGroup(
            dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPDLayout.createSequentialGroup()
                .addGroup(dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataPDLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dataPDLayout.createSequentialGroup()
                                .addGroup(dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(dataPDLayout.createSequentialGroup()
                                        .addComponent(LPD)
                                        .addGap(18, 18, 18)
                                        .addComponent(PPD))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dataPDLayout.createSequentialGroup()
                                .addComponent(tambahPD, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editPD, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hapusPD, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dataPDLayout.createSequentialGroup()
                                .addGroup(dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addGap(54, 54, 54)
                                .addGroup(dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nis, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namaPD, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(61, 61, 61)
                        .addGroup(dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dataPDLayout.createSequentialGroup()
                                .addComponent(cariPD, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cari))))
                    .addGroup(dataPDLayout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(jLabel6)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        dataPDLayout.setVerticalGroup(
            dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPDLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addGroup(dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataPDLayout.createSequentialGroup()
                        .addGroup(dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cariPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cari))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dataPDLayout.createSequentialGroup()
                        .addGroup(dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(nis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(namaPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(LPD)
                            .addComponent(PPD))
                        .addGap(18, 18, 18)
                        .addGroup(dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dataPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tambahPD)
                            .addComponent(editPD)
                            .addComponent(hapusPD))))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 865, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(dataPD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(dataPD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabelPDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPDMouseClicked

        int bar = tabelPD.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();

        nis.setText(a);
        namaPD.setText(b);
        kelas.setText(c);
        if(d.equalsIgnoreCase("Laki-laki")){
            LPD.setSelected(true);
            PPD.setSelected(false);
        }else if(d.equalsIgnoreCase("Perempuan")){
            PPD.setSelected(true);
            LPD.setSelected(false);
        }
        alamatPD.setText(f);
    }//GEN-LAST:event_tabelPDMouseClicked

    private void nisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nisActionPerformed

    private void namaPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaPDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaPDActionPerformed

    private void kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kelasActionPerformed

    private void LPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LPDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LPDActionPerformed

    private void PPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PPDActionPerformed

    private void cariPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariPDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariPDActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
    Object[] Baris ={"NIS","Nama","Kelas","Jenis Kelamin","Ekskul","Alamat"};
    tabmode = new DefaultTableModel(null, Baris);
    String cariitem=cariPD.getText();

        try {
            String sql = "SELECT * FROM pd where LOWER(kelas) like '%"+cariitem
                    +"%' or LOWER(jkPD) like'%"+cariitem+"%' order by nis asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a=hasil.getString("nis");
            String b=hasil.getString("nama");
            String c=hasil.getString("kelas");
            String d=hasil.getString("jkPD");
            String e=hasil.getString("ekskul");
            String f=hasil.getString("alamat");

        String[] data={a,b,c,d,e,f};
        tabmode.addRow(data);
        }
        tabelPD.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
    }//GEN-LAST:event_cariActionPerformed

    private void hapusPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusPDActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","konfirmasidialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from pd where nis ='"+nis.getText()+"'";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "data berhasil dihapus");
            kosong();
            nis.requestFocus();
        }
        catch (SQLException e){
        JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
        }
        bgJK.clearSelection();
        datatable();
        }
    }//GEN-LAST:event_hapusPDActionPerformed

    private void tambahPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahPDActionPerformed
        String ekskulPD="Tidak ada";
        String jkPD;
        String sql="Insert into pd value(?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nis.getText());
            stat.setString(2, namaPD.getText());
            stat.setString(3, kelas.getText());
            if(LPD.isSelected()){
                stat.setString(4, jkPD="Laki-laki");
            }else if(PPD.isSelected()){
                stat.setString(4, jkPD="Perempuan");
            }
            stat.setString(5, ekskulPD);
            stat.setString(6, alamatPD.getText());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosong();
            nis.requestFocus();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
        }
        bgJK.clearSelection();
        datatable();
    }//GEN-LAST:event_tambahPDActionPerformed

    private void editPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPDActionPerformed

        try{
            String sql = "update pd set nis=?,nama=?,kelas=?,jkPD=?"+
                    ",alamat=?  where nis ='"+nis.getText()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nis.getText());
            stat.setString(2, namaPD.getText());
            stat.setString(3, kelas.getText());
            if(LPD.isSelected()){
                stat.setString(4, jkPD="Laki-laki");
            }else if(PPD.isSelected()){
                stat.setString(4, jkPD="Perempuan");
            }
            stat.setString(5, alamatPD.getText());
            stat.executeUpdate();
 
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosong();
            nis.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal diubah"+e);
        }
        bgJK.clearSelection();
        datatable();
    }//GEN-LAST:event_editPDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton LPD;
    private javax.swing.JRadioButton PPD;
    private javax.swing.JTextArea alamatPD;
    private javax.swing.ButtonGroup bgJK;
    private javax.swing.JButton cari;
    private javax.swing.JTextField cariPD;
    private javax.swing.JPanel dataPD;
    private javax.swing.JButton editPD;
    private javax.swing.JButton hapusPD;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField kelas;
    private javax.swing.JTextField namaPD;
    private javax.swing.JTextField nis;
    private javax.swing.JTable tabelPD;
    private javax.swing.JButton tambahPD;
    // End of variables declaration//GEN-END:variables
}
