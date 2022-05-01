/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Service.DocgiaService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Docgia;

/**
 *
 * @author Admin
 */
public class QuanlidocgiaFrame extends javax.swing.JFrame {
     DocgiaService docgiaService;
    DefaultTableModel defaultTableModel;
    /**
     * Creates new form QuanlidocgiaFrame
     */
    public QuanlidocgiaFrame() {
        initComponents();
         docgiaService = new DocgiaService();
         defaultTableModel = new DefaultTableModel(){
           @Override
            public boolean isCellEditable(int row, int column){
               
                return false;
            }
        };
        docgiaTable.setModel(defaultTableModel);
        
        
        defaultTableModel.addColumn("Mã đọc giả");
        defaultTableModel.addColumn("Tên đọc giả");
        defaultTableModel.addColumn("Tên đăng nhập");
        defaultTableModel.addColumn("Mật khẩu");
        defaultTableModel.addColumn("Năm sinh");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Lớp");

        //setTableData(userService.getAllUsers());
        
        List<Docgia> docgias = docgiaService.getAllDocgias();
        for (Docgia docgia : docgias){
            
            defaultTableModel.addRow(new Object[]{docgia.getMadocgia(), docgia.getTendocgia(), docgia.getTendangnhap(), docgia.getMatkhau(), docgia.getNamsinh(), docgia.getGioitinh(), docgia.getLop()});
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
        docgiaTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        trolaiButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        docgiaTable.setModel(new javax.swing.table.DefaultTableModel(
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
        docgiaTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(docgiaTable);

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
                .addContainerGap(25, Short.MAX_VALUE))
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
        new ThemdocgiaFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        int row = docgiaTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(QuanlidocgiaFrame.this, "Vui long chon user truoc","loi",JOptionPane.ERROR_MESSAGE);
            
        }
        else {
            
            String docgiaId = String.valueOf(String.valueOf(docgiaTable.getValueAt(row, 0)));
            new Suadocgia(docgiaId).setVisible(true);
            this.dispose();
                
                
            
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int row = docgiaTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(QuanlidocgiaFrame.this, "Vui long chon user truoc","loi",JOptionPane.ERROR_MESSAGE);
            
        }
        else {
            int confirm = JOptionPane.showConfirmDialog(QuanlidocgiaFrame.this,"Ban co chac muon xoa khong?");
            if (confirm == JOptionPane.YES_OPTION){
                String docgiaId = String.valueOf(String.valueOf(docgiaTable.getValueAt(row, 0)));
            
                docgiaService.deleteDocgia(docgiaId);
                defaultTableModel.setRowCount(0);
         
                List<Docgia> docgias = docgiaService.getAllDocgias();
                for (Docgia docgia : docgias){
                   defaultTableModel.addRow(new Object[]{docgia.getMadocgia(), docgia.getTendocgia(), docgia.getTendangnhap(), docgia.getMatkhau(), docgia.getNamsinh(), docgia.getGioitinh()});
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
            java.util.logging.Logger.getLogger(QuanlidocgiaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanlidocgiaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanlidocgiaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanlidocgiaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanlidocgiaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTable docgiaTable;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton trolaiButton;
    // End of variables declaration//GEN-END:variables
}