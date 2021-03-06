/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Service.DocgiaService;
import Service.SachService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Docgia;
import model.Sach;

/**
 *
 * @author Admin
 */
public class QuanlisachFrame extends javax.swing.JFrame {
     SachService sachService;
    DefaultTableModel defaultTableModel;
    /**
     * Creates new form QuanlisachFrame
     */
    public QuanlisachFrame() {
        initComponents();
        sachService = new SachService();
         defaultTableModel = new DefaultTableModel(){
           @Override
            public boolean isCellEditable(int row, int column){
               
                return false;
            }
        };
        sachTable.setModel(defaultTableModel);
        
        
        defaultTableModel.addColumn("Mã sách");
        defaultTableModel.addColumn("Tên sách");
        defaultTableModel.addColumn("Tác giả");
        defaultTableModel.addColumn("Nhà xuất bản");
        defaultTableModel.addColumn("Năm xuất bản");
        

        //setTableData(userService.getAllUsers());
        
        List<Sach> sachs = sachService.getAllSachs();
        for (Sach sach : sachs){
            
            defaultTableModel.addRow(new Object[]{sach.getMasach(), sach.getTensach(), sach.getTacgia(),sach.getNhaxuatban(), sach.getNamxuatban()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sachTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        trolaiButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sachTable.setModel(new javax.swing.table.DefaultTableModel(
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
        sachTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(sachTable);

        addButton.setText("Thêm");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Sửa");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Xoá");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        trolaiButton.setText("Trở lại");
        trolaiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trolaiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(62, 62, 62)
                        .addComponent(editButton)
                        .addGap(43, 43, 43)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trolaiButton)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton)
                    .addComponent(trolaiButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        new ThemSachFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        int row = sachTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(QuanlisachFrame.this, "Vui long chon user truoc","loi",JOptionPane.ERROR_MESSAGE);

        }
        else {

            String sachId = String.valueOf(String.valueOf(sachTable.getValueAt(row, 0)));
            //new SuaSachFrame(sachId).setVisible(true);
            new SuaSachFrame(sachId).setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int row = sachTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(QuanlisachFrame.this, "Vui long chon user truoc","loi",JOptionPane.ERROR_MESSAGE);

        }
        else {
            int confirm = JOptionPane.showConfirmDialog(QuanlisachFrame.this,"Ban co chac muon xoa khong?");
            if (confirm == JOptionPane.YES_OPTION){
                String docgiaId = String.valueOf(String.valueOf(sachTable.getValueAt(row, 0)));

                sachService.deleteSach(docgiaId);
                defaultTableModel.setRowCount(0);

                List<Sach> sachs = sachService.getAllSachs();
                for (Sach sach : sachs){
                    defaultTableModel.addRow(new Object[]{sach.getMasach(), sach.getTensach(), sach.getTacgia(), sach.getNamxuatban()});
                }

            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void trolaiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trolaiButtonActionPerformed
        // TODO add your handling code here:
        new NhanVienFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_trolaiButtonActionPerformed

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
            java.util.logging.Logger.getLogger(QuanlisachFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanlisachFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanlisachFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanlisachFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanlisachFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable sachTable;
    private javax.swing.JButton trolaiButton;
    // End of variables declaration//GEN-END:variables
}
