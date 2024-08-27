
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


public class tampilUntukP extends javax.swing.JPanel {
    private Connection conn = new koneksiSPK().connect();
    private DefaultTableModel tabmode;
    private dataPD dataPD;
    private dataE dataE;
    private dataP dataP;
    

    public tampilUntukP() {
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

        jPanel1 = new javax.swing.JPanel();
        menuBarData = new javax.swing.JPanel();
        btnDE = new javax.swing.JButton();
        btnP = new javax.swing.JButton();
        DATA = new javax.swing.JPanel();

        jPanel1.setPreferredSize(new java.awt.Dimension(735, 494));

        menuBarData.setBackground(new java.awt.Color(0, 153, 153));

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
                .addGap(224, 224, 224)
                .addComponent(btnDE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnP, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(337, Short.MAX_VALUE))
        );
        menuBarDataLayout.setVerticalGroup(
            menuBarDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarDataLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(menuBarDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        DATA.setBackground(new java.awt.Color(255, 255, 255));
        DATA.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBarData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DATA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(menuBarData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(DATA, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 879, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDEActionPerformed
        DATA.removeAll();
        DATA.repaint();
        DATA.revalidate();

        //ADD PANEL
        DATA.add(dataE);
        DATA.repaint();
        DATA.revalidate();
    }//GEN-LAST:event_btnDEActionPerformed

    private void btnPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPActionPerformed
        DATA.removeAll();
        DATA.repaint();
        DATA.revalidate();

        //ADD PANEL
        DATA.add(dataP);
        DATA.repaint();
        DATA.revalidate();
    }//GEN-LAST:event_btnPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DATA;
    private javax.swing.JButton btnDE;
    private javax.swing.JButton btnP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel menuBarData;
    // End of variables declaration//GEN-END:variables
}
