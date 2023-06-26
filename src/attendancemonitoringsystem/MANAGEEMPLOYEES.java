/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancemonitoringsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ADMIN
 */
public class MANAGEEMPLOYEES extends javax.swing.JFrame {
  Connection conn = null;   
PreparedStatement pst = null;
    PreparedStatement pst1 = null;
ResultSet rs = null;

    public MANAGEEMPLOYEES() {
        initComponents();
       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        position = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dept = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        fname = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Full Name", "Age", "Contact", "Address", "Position", "Department"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 880, -1));

        id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 90, 41));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Full Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 95, 41));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Age:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, 50, 41));

        age.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ageKeyTyped(evt);
            }
        });
        jPanel1.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 530, 120, 41));

        contact.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactKeyTyped(evt);
            }
        });
        jPanel1.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 530, 120, 41));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Contact:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 530, 80, 41));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Address:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 530, 80, 41));

        address.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 530, 120, 41));

        position.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(position, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 600, 110, 41));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Position:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, 80, 41));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Department:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 600, 110, 41));

        dept.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 600, 120, 41));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 600, 80, 40));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 600, 80, 40));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 600, 80, 40));

        fname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 110, 41));

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
   conn = DBConnection.getConnection();
   retrieve();
    }//GEN-LAST:event_formWindowOpened

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
         DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRowIndex = table.getSelectedRow();
        id.setText(model.getValueAt(selectedRowIndex, 0).toString());
        fname.setText(model.getValueAt(selectedRowIndex, 1).toString());
        age.setText(model.getValueAt(selectedRowIndex, 2).toString());
        contact.setText(model.getValueAt(selectedRowIndex, 3).toString());
        address.setText(model.getValueAt(selectedRowIndex, 4).toString());
        position.setText(model.getValueAt(selectedRowIndex, 5).toString());
        dept.setText(model.getValueAt(selectedRowIndex, 6).toString());
    }//GEN-LAST:event_tableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     save_data();
     retrieve();
        id.setText("");
        fname.setText("");
        age.setText("");
        contact.setText("");
        address.setText("");
        position.setText("");
        dept.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        update();
          retrieve();
        id.setText("");
        fname.setText("");
        age.setText("");
        contact.setText("");
        address.setText("");
        position.setText("");
        dept.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    delete();
      retrieve();
        id.setText("");
        fname.setText("");
        age.setText("");
        contact.setText("");
        address.setText("");
        position.setText("");
        dept.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     ADMINPAGE s= new  ADMINPAGE();
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageKeyTyped
 char vchar = evt.getKeyChar();
      
        if (!(Character.isDigit(vchar))) {
            evt.consume();
        }    // TODO add your handling code here:
    }//GEN-LAST:event_ageKeyTyped

    private void contactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactKeyTyped
   char vchar = evt.getKeyChar();
      
        if (!(Character.isDigit(vchar))) {
            evt.consume();
        }  
    }//GEN-LAST:event_contactKeyTyped

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
            java.util.logging.Logger.getLogger(MANAGEEMPLOYEES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MANAGEEMPLOYEES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MANAGEEMPLOYEES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MANAGEEMPLOYEES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MANAGEEMPLOYEES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField age;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField dept;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField position;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
private void retrieve(){
try {
   String sql = "SELECT employee_id AS 'Employee ID', fullname AS 'Full Name',age AS 'Age',contact AS 'Contact Number',address AS 'Address',position AS 'Position',department AS 'Department'  FROM employee_info";
pst = conn.prepareStatement(sql);
rs =pst.executeQuery();
table.setModel(DbUtils.resultSetToTableModel(rs));
}catch(Exception e){
   JOptionPane.showMessageDialog(rootPane, e);
}
}
private void save_data(){
   
    String one = fname.getText();
    String two = age.getText();
    String three = contact.getText();
    String four = address.getText();
    String five = position.getText();
    String six = dept.getText();
    
   if (one.equals("")||two.equals("")||three.equals("")||four.equals("")||five.equals("")||six.equals("")){
       JOptionPane.showMessageDialog(null, "SOME FIELDS ARE EMPTY");
   }else{
       try{
        
  String sql= "INSERT INTO employee_info(fullname,age,contact,address,position,department)VALUE(?,?,?,?,?,?)";
   pst = conn.prepareStatement(sql);
 
   pst.setString(1,fname.getText()); 
   pst.setString(2,age.getText());  
   pst.setString(3,contact.getText());
   pst.setString(4,address.getText());
   pst.setString(5,position.getText());
    pst.setString(6,dept.getText());
       pst.execute();
      JOptionPane.showMessageDialog(null,"Data Added");
    }catch(Exception e){
      JOptionPane.showMessageDialog(null,e);
    }
}
   }
   private void update(){
     String one = fname.getText();
    String two = age.getText();
    String three = contact.getText();
    String four = address.getText();
    String five = position.getText();
    String six = dept.getText();
    
   if (one.equals("")||two.equals("")||three.equals("")||four.equals("")||five.equals("")||six.equals("")){
       JOptionPane.showMessageDialog(null, "SOME FIELDS ARE EMPTY");
   }else{
    try{
        String sql="UPDATE employee_info SET employee_id = ?,fullname=?, age=?,contact=?,address=?,position=?,department=? WHERE employee_id = '"+id.getText()+"'";
   pst = conn.prepareStatement(sql);
   pst.setString(1,id.getText());  
   pst.setString(2,fname.getText()); 
   pst.setString(3,age.getText());  
   pst.setString(4,contact.getText());
   pst.setString(5,address.getText());
   pst.setString(6,position.getText());
    pst.setString(7,dept.getText());
       pst.execute();
        JOptionPane.showMessageDialog(null, "Data Updated Successfully");
    }catch(Exception e){
        JOptionPane.showMessageDialog(rootPane, e);
    }
}
   }
private void delete(){
    try{
        String sql = "SELECT * FROM employee_info WHERE employee_id='"+id.getText()+"'";
         pst = conn.prepareStatement(sql);
         rs=pst.executeQuery();
         if (rs.next()){
             String sql1 = "DELETE FROM employee_info WHERE employee_id='"+id.getText()+"'";
               pst = conn.prepareStatement(sql1);
             pst.execute();
             JOptionPane.showMessageDialog(null, "Data Deleted Permanently");
         }else{
             JOptionPane.showMessageDialog(null, "No Existing Data");
         }
    }catch(Exception e){
        JOptionPane.showMessageDialog(rootPane, e);
}
}}
