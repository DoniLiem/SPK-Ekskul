
package DATA;
import DATA.popupAnggotaE;
import DATA.dataPD;
import DATA.dataE;
import DATA.dataP;
import java.sql.*;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import koneksi.koneksiSPK;
import MENU.menuAwal;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class tampilData extends javax.swing.JPanel {
    private Connection conn = new koneksiSPK().connect();
    private DefaultTableModel tabmode;
    private dataPD dataPD;
    private dataE dataE;
    private dataP dataP;
    

    public tampilData() {
        initComponents();
        dataPD = new dataPD();
        dataPD.datatable();
        dataE = new dataE();
        dataE.datatable();
        dataP = new dataP();
        dataP.datatable();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel10 = new javax.swing.JLabel();
        menuBarData = new javax.swing.JPanel();
        btnDPD = new javax.swing.JButton();
        btnDE = new javax.swing.JButton();
        btnP = new javax.swing.JButton();
        DATA = new javax.swing.JPanel();

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Selamat Datang di Aplikasi Sistem Pendukung Keputusan ");

        setPreferredSize(new java.awt.Dimension(735, 494));

        menuBarData.setBackground(new java.awt.Color(0, 153, 153));

        btnDPD.setText("Data Peserta Didik");
        btnDPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDPDActionPerformed(evt);
            }
        });

        btnDE.setText("Data Ekstrakurikuler");
        btnDE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDEActionPerformed(evt);
            }
        });

        btnP.setText("Data Pembina");
        btnP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuBarDataLayout = new javax.swing.GroupLayout(menuBarData);
        menuBarData.setLayout(menuBarDataLayout);
        menuBarDataLayout.setHorizontalGroup(
            menuBarDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarDataLayout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(btnDPD, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btnDE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnP, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        menuBarDataLayout.setVerticalGroup(
            menuBarDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarDataLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(menuBarDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDPD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        DATA.setBackground(new java.awt.Color(255, 255, 255));
        DATA.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBarData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DATA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuBarData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(DATA, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPActionPerformed
        DATA.removeAll();
        DATA.repaint();
        DATA.revalidate();

        //ADD PANEL
        DATA.add(dataP);
        DATA.repaint();
        DATA.revalidate();
    }//GEN-LAST:event_btnPActionPerformed

    private void btnDEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDEActionPerformed
        DATA.removeAll();
        DATA.repaint();
        DATA.revalidate();

        //ADD PANEL
        DATA.add(dataE);
        DATA.repaint();
        DATA.revalidate();
    }//GEN-LAST:event_btnDEActionPerformed

    private void btnDPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDPDActionPerformed
        DATA.removeAll();
        DATA.repaint();
        DATA.revalidate();

        //ADD PANEL
        DATA.add(dataPD);
        DATA.repaint();
        DATA.revalidate();
    }//GEN-LAST:event_btnDPDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DATA;
    private javax.swing.JButton btnDE;
    private javax.swing.JButton btnDPD;
    private javax.swing.JButton btnP;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel menuBarData;
    // End of variables declaration//GEN-END:variables
}
