
package BACKUP;
import javax.swing.JPanel;
import java.sql.*;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import koneksi.koneksiSPK;
import MENU.menuAwal;
import javax.swing.table.DefaultTableModel;

public class pemilihan extends javax.swing.JPanel {

    
    public pemilihan() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SK17 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        SK18 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        kriteria2 = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelSK4 = new javax.swing.JTable();
        namE4 = new javax.swing.JTextField();
        cariSK2 = new javax.swing.JButton();
        simpan2 = new javax.swing.JButton();
        cariSKE2 = new javax.swing.JTextField();
        hapus2 = new javax.swing.JButton();
        hitung2 = new javax.swing.JButton();
        namE5 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        SK19 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        SK20 = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        SK21 = new javax.swing.JComboBox<>();
        SK22 = new javax.swing.JComboBox<>();
        SK23 = new javax.swing.JComboBox<>();
        SK24 = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelSK5 = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 255, 153));

        SK17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- HOBI --" }));
        SK17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SK1ActionPerformed(evt);
            }
        });

        jLabel22.setText("Bakat");

        SK18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        SK18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SK2ActionPerformed(evt);
            }
        });

        jLabel23.setText("Ekstrakurikuler Pilihan");

        jLabel24.setText("Hobi");

        jLabel25.setText("Pilihan 1");

        jLabel26.setText("Nama Peserta Didik");

        kriteria2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- BAKAT --" }));
        kriteria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kriteriaActionPerformed(evt);
            }
        });

        tabelSK4.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelSK4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSKMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelSK4);

        namE4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namEActionPerformed(evt);
            }
        });

        cariSK2.setText("Cari");
        cariSK2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariSKActionPerformed(evt);
            }
        });

        simpan2.setText("Simpan");
        simpan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        cariSKE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariSKEActionPerformed(evt);
            }
        });

        hapus2.setText("Hapus");
        hapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        hitung2.setText("Hitung");
        hitung2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });

        namE5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namE1ActionPerformed(evt);
            }
        });

        jLabel27.setText("No.ID");

        SK19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        SK19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SK3ActionPerformed(evt);
            }
        });

        jLabel28.setText("Pilihan 1");

        jLabel29.setText("Pilihan 1");

        SK20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        SK20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SK4ActionPerformed(evt);
            }
        });

        jLabel30.setText("Tempat Kegiatan Pilihan");

        SK21.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        SK21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SK5ActionPerformed(evt);
            }
        });

        SK22.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minat" }));
        SK22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SK6ActionPerformed(evt);
            }
        });

        SK23.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minat" }));
        SK23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SK7ActionPerformed(evt);
            }
        });

        SK24.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minat" }));
        SK24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SK8ActionPerformed(evt);
            }
        });

        jLabel31.setText("PEMILIHAN EKSTRAKURIKULER");

        tabelSK5.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelSK5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSK1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabelSK5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cariSKE2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cariSK2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(namE5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel26)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(kriteria2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SK17, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(namE4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel25)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(SK18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel29)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(SK20, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel28)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(SK19, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(jLabel30))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SK21, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(SK22, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(SK24, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(SK23, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(46, 46, 46)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(simpan2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hapus2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hitung2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(200, 200, 200))))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namE5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namE4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(kriteria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(SK17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel25)
                                            .addComponent(SK18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel28)
                                            .addComponent(SK19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel29)
                                            .addComponent(SK20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SK22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(SK23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(SK24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(SK21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(137, 137, 137)))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan2)
                    .addComponent(hapus2)
                    .addComponent(hitung2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cariSKE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariSK2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabelSK1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSK1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelSK1MouseClicked

    private void SK8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SK8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SK8ActionPerformed

    private void SK7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SK7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SK7ActionPerformed

    private void SK6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SK6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SK6ActionPerformed

    private void SK5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SK5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SK5ActionPerformed

    private void SK4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SK4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SK4ActionPerformed

    private void SK3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SK3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SK3ActionPerformed

    private void namE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namE1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namE1ActionPerformed

    private void hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungActionPerformed

    }//GEN-LAST:event_hitungActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed

    }//GEN-LAST:event_hapusActionPerformed

    private void cariSKEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariSKEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariSKEActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed

    }//GEN-LAST:event_simpanActionPerformed

    private void cariSKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariSKActionPerformed

    }//GEN-LAST:event_cariSKActionPerformed

    private void namEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namEActionPerformed

    private void tabelSKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSKMouseClicked

    }//GEN-LAST:event_tabelSKMouseClicked

    private void kriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kriteriaActionPerformed

    }//GEN-LAST:event_kriteriaActionPerformed

    private void SK2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SK2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SK2ActionPerformed

    private void SK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SK1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SK1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> SK17;
    private javax.swing.JComboBox<String> SK18;
    private javax.swing.JComboBox<String> SK19;
    private javax.swing.JComboBox<String> SK20;
    private javax.swing.JComboBox<String> SK21;
    private javax.swing.JComboBox<String> SK22;
    private javax.swing.JComboBox<String> SK23;
    private javax.swing.JComboBox<String> SK24;
    private javax.swing.JButton cariSK2;
    private javax.swing.JTextField cariSKE2;
    private javax.swing.JButton hapus2;
    private javax.swing.JButton hitung2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JComboBox<String> kriteria2;
    private javax.swing.JTextField namE4;
    private javax.swing.JTextField namE5;
    private javax.swing.JButton simpan2;
    private javax.swing.JTable tabelSK4;
    private javax.swing.JTable tabelSK5;
    // End of variables declaration//GEN-END:variables
}
