
package PILIHAN;
import PILIHAN.pemilihan;
import javax.swing.JPanel;
import java.sql.*;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import koneksi.koneksiSPK;
import MENU.menuAwal;
import javax.swing.table.DefaultTableModel;

public class tampilP extends javax.swing.JPanel {
    private Connection conn = new koneksiSPK().connect();
    private DefaultTableModel tabmode;
    private pemilihan pilih;
    
    public tampilP() {
        initComponents();
        pilih = new pemilihan();
        //skriteria.datatableSK();
//        KRITERIA.removeAll();
//        KRITERIA.repaint();
//        KRITERIA.revalidate();
//
//        //ADD PANEL
//        KRITERIA.add(pilih);
//        KRITERIA.repaint();
//        KRITERIA.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        KRITERIA = new javax.swing.JPanel();

        KRITERIA.setBackground(new java.awt.Color(255, 102, 255));
        KRITERIA.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KRITERIA, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KRITERIA, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel KRITERIA;
    // End of variables declaration//GEN-END:variables
}
