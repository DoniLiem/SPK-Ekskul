
package KRITERIA;
import DATA.dataPD;
import KRITERIA.kriteria;
import KRITERIA.skriteria;
import javax.swing.JPanel;
import java.sql.*;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import koneksi.koneksiSPK;
import MENU.menuAwal;
import javax.swing.table.DefaultTableModel;

public class tampilKriteria extends javax.swing.JPanel {
    private Connection conn = new koneksiSPK().connect();
    private DefaultTableModel tabmode;
    private kriteria kriteria;
    private skriteria skriteria;
    
    public tampilKriteria() {
        initComponents();
        kriteria = new kriteria();
        kriteria.datatableK();
        skriteria = new skriteria();
        skriteria.datatableSK();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBarData = new javax.swing.JPanel();
        Kriteria = new javax.swing.JButton();
        SKriteria = new javax.swing.JButton();
        KRITERIA = new javax.swing.JPanel();

        menuBarData.setBackground(new java.awt.Color(0, 153, 153));

        Kriteria.setText("Kriteria");
        Kriteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KriteriaActionPerformed(evt);
            }
        });

        SKriteria.setText("Sub kriteria");
        SKriteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SKriteriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuBarDataLayout = new javax.swing.GroupLayout(menuBarData);
        menuBarData.setLayout(menuBarDataLayout);
        menuBarDataLayout.setHorizontalGroup(
            menuBarDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarDataLayout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(Kriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(SKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );
        menuBarDataLayout.setVerticalGroup(
            menuBarDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarDataLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(menuBarDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Kriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        KRITERIA.setBackground(new java.awt.Color(255, 255, 255));
        KRITERIA.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBarData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(KRITERIA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuBarData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(KRITERIA, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void KriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KriteriaActionPerformed
        KRITERIA.removeAll();
        KRITERIA.repaint();
        KRITERIA.revalidate();

        //ADD PANEL
        KRITERIA.add(kriteria);
        KRITERIA.repaint();
        KRITERIA.revalidate();
    }//GEN-LAST:event_KriteriaActionPerformed

    private void SKriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SKriteriaActionPerformed
        KRITERIA.removeAll();
        KRITERIA.repaint();
        KRITERIA.revalidate();

        //ADD PANEL
        KRITERIA.add(skriteria);
        KRITERIA.repaint();
        KRITERIA.revalidate();
    }//GEN-LAST:event_SKriteriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel KRITERIA;
    private javax.swing.JButton Kriteria;
    private javax.swing.JButton SKriteria;
    private javax.swing.JPanel menuBarData;
    // End of variables declaration//GEN-END:variables
}
