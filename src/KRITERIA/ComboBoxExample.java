
package KRITERIA;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ComboBoxExample extends JFrame {
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox3;

    private List<String> items;

    public ComboBoxExample() {
        items = new ArrayList<>();
        items.add("a");
        items.add("b");
        items.add("c");

        comboBox1 = new JComboBox<>(new DefaultComboBoxModel<>(items.toArray(new String[0])));
        comboBox2 = new JComboBox<>(new DefaultComboBoxModel<>(items.toArray(new String[0])));
        comboBox3 = new JComboBox<>(new DefaultComboBoxModel<>(items.toArray(new String[0])));

        comboBox1.addActionListener(new ComboBoxListener());
        comboBox2.addActionListener(new ComboBoxListener());
        comboBox3.addActionListener(new ComboBoxListener());

        setLayout(new java.awt.FlowLayout());
        add(comboBox1);
        add(comboBox2);
        add(comboBox3);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private class ComboBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateComboBoxes();
        }
    }

    private void updateComboBoxes() {
        List<String> selectedItems = new ArrayList<>();
        selectedItems.add((String) comboBox1.getSelectedItem());
        selectedItems.add((String) comboBox2.getSelectedItem());
        selectedItems.add((String) comboBox3.getSelectedItem());

        updateComboBox(comboBox1, selectedItems);
        updateComboBox(comboBox2, selectedItems);
        updateComboBox(comboBox3, selectedItems);
    }

    private void updateComboBox(JComboBox<String> comboBox, List<String> selectedItems) {
        String selectedItem = (String) comboBox.getSelectedItem();
        comboBox.removeAllItems();
        for (String item : items) {
            if (!selectedItems.contains(item) || item.equals(selectedItem)) {
                comboBox.addItem(item);
            }
        }
        comboBox.setSelectedItem(selectedItem);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ComboBoxExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComboBoxExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComboBoxExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComboBoxExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        SwingUtilities.invokeLater(() -> new ComboBoxExample());
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComboBoxExample().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
