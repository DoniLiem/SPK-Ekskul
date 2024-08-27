
package LAPORAN;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksiSPK;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class cetakLaporan extends javax.swing.JPanel {
private Connection conn = new koneksiSPK().connect();
private DefaultTableModel tabmode;
String lokasi;
    public cetakLaporan() {
        initComponents();
        Locale locale = new Locale("id","ID");
        Locale.setDefault(locale);
    }
protected void datatableAE(){
    Object[] Baris ={"NIS","Nama","Kelas","Ekstrakurikuler "};
    tabmode = new DefaultTableModel(null, Baris);
        try {
            String sql = "SELECT * FROM anggotae order by noidE asc";
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
            tabelC.setModel(tabmode);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);
        }
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
        tabelC.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
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
        tabelC.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
    }

protected void datatableE(){
    Object[] Baris ={"No. ID","Nama","Pembina","Jumlah Anggota"};
    tabmode = new DefaultTableModel(null, Baris);

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
        tabelC.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
    }

protected void datatableRank(){
    Object[] Baris ={"No. ID","Rank","Nama","Ekstrakurikuler","Hasil Perhitungan"};
    tabmode = new DefaultTableModel(null, Baris);

        try {
            String sql = "SELECT * FROM pe  order by rank asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a=hasil.getString("noidPE");
            String b=hasil.getString("rank");
            String c=hasil.getString("namaPD");
            String d=hasil.getString("ekskul");
            String e=hasil.getString("hasilBobot");

        String[] data={a,b,c,d,e};
        tabmode.addRow(data);
        }
        tabelC.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        dataAE = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelC = new javax.swing.JTable();
        dataK = new javax.swing.JButton();
        dataSK = new javax.swing.JButton();
        dataPE = new javax.swing.JButton();
        Cetak = new javax.swing.JButton();
        dataE = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        dataAE.setText("Data Anggota Esktrakurikuler");
        dataAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataAEsimpanActionPerformed(evt);
            }
        });

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setText("LAPORAN");

        tabelC.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelCtabelSK1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelC);

        dataK.setText("Data Kriteria ");
        dataK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataKsimpanActionPerformed(evt);
            }
        });

        dataSK.setText("Data Sub-Kriteria ");
        dataSK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataSKsimpanActionPerformed(evt);
            }
        });

        dataPE.setText("Data Pemilihan Ekstrakurikuler");
        dataPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataPEsimpanActionPerformed(evt);
            }
        });

        Cetak.setText("Cetak");
        Cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakActionPerformed(evt);
            }
        });

        dataE.setText("Data Ekstrakurikuler");
        dataE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataEsimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Cetak))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 56, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane7)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dataAE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataK)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataSK)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataPE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataE)))))
                .addGap(50, 50, 50))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(jLabel40)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataAE, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataK, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataSK, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataPE, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataE, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cetak)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 856, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dataAEsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataAEsimpanActionPerformed
        lokasi = "src/LAPORAN/laporanAnggotaE.jasper";
        datatableAE();
    }//GEN-LAST:event_dataAEsimpanActionPerformed

    private void tabelCtabelSK1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelCtabelSK1MouseClicked
        
    }//GEN-LAST:event_tabelCtabelSK1MouseClicked

    private void dataKsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataKsimpanActionPerformed
        lokasi = "src/LAPORAN/laporanKriteria.jasper";
        datatableK();
    }//GEN-LAST:event_dataKsimpanActionPerformed

    private void dataSKsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataSKsimpanActionPerformed
        lokasi = "src/LAPORAN/laporanSubKriteria.jasper";
        datatableSK();
    }//GEN-LAST:event_dataSKsimpanActionPerformed

    private void dataPEsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataPEsimpanActionPerformed
        lokasi = "src/LAPORAN/laporanPlemilihanEkskul.jasper";
        datatableRank();
    }//GEN-LAST:event_dataPEsimpanActionPerformed

    private void CetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakActionPerformed
        try {
            HashMap<String, Object> parameters=new HashMap<>();
            JasperPrint jp = JasperFillManager.fillReport(lokasi, parameters, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_CetakActionPerformed

    private void dataEsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataEsimpanActionPerformed
        lokasi = "src/LAPORAN/laporanEkskul.jasper";
        datatableE();
    }//GEN-LAST:event_dataEsimpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cetak;
    private javax.swing.JButton dataAE;
    private javax.swing.JButton dataE;
    private javax.swing.JButton dataK;
    private javax.swing.JButton dataPE;
    private javax.swing.JButton dataSK;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tabelC;
    // End of variables declaration//GEN-END:variables
}
