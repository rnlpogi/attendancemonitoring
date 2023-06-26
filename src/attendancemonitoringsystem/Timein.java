/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancemonitoringsystem;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.proteanit.sql.DbUtils;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author ADMIN
 */
public class Timein extends javax.swing.JFrame implements Runnable,ThreadFactory {
      int hour, second, minute;
 private WebcamPanel panel = null;
 private Webcam webcam = null;
 private Executor executor = Executors.newSingleThreadExecutor(this);
   Connection conn = null;   
PreparedStatement pst = null;
    PreparedStatement pst1 = null;
ResultSet rs = null;
    /**
     * Creates new form Timein  
     */
    public Timein() {
        initComponents();
        initWebcam();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        age = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        dept = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        position = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                jPanel1AncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 510, 260));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Contact:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 560, 80, 20));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setForeground(new java.awt.Color(51, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 35)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ATTENDANCE MONITORING SYSTEM");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 680, 69));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendancemonitoringsystem/icons/tboli.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 200, 170));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendancemonitoringsystem/icons/sc.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 200, 170));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendancemonitoringsystem/icons/Lake_Holon_Shoreline.jpg"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, -400, 1090, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1070, 180));

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 460, 200));

        age.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ageKeyTyped(evt);
            }
        });
        jPanel1.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 560, 70, -1));

        id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 560, 70, -1));

        fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fnameKeyTyped(evt);
            }
        });
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 560, 70, -1));

        dept.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dept.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                deptKeyTyped(evt);
            }
        });
        jPanel1.add(dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 600, 70, -1));

        address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        address.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addressKeyTyped(evt);
            }
        });
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 600, 70, -1));

        contact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactKeyTyped(evt);
            }
        });
        jPanel1.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 560, 70, -1));

        position.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        position.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                positionKeyTyped(evt);
            }
        });
        jPanel1.add(position, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 600, 70, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Employee ID:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 80, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Address:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 600, 80, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Full Name:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, 80, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Position:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 600, 80, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Department:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 600, 80, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Age:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 80, 20));

        jButton1.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendancemonitoringsystem/icons/icons8-time-30.png"))); // NOI18N
        jButton1.setText("Time in");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 600, 130, 50));

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 60, 30));

        date.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        date.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 190, 60));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel13.setText("DATE:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 100, 60));

        time.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        time.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 290, 60));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel14.setText("TIME:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 140, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1AncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jPanel1AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1AncestorMoved

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       conn = DBConnection.getConnection();
   retrieve();
    }//GEN-LAST:event_formWindowOpened

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FrontPage s= new  FrontPage();
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       save_data();
         retrieve();
          id.setText("");
        fname.setText("");
        age.setText("");
        contact.setText("");
        address.setText("");
        position.setText("");
        dept.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
       char vchar = evt.getKeyChar();
        char bchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar))) {
            evt.consume();
        } else if (!(Character.isAlphabetic(bchar))) {
            evt.consume();
        }
    }//GEN-LAST:event_idKeyTyped

    private void fnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameKeyTyped
      char vchar = evt.getKeyChar();
        char bchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar))) {
            evt.consume();
        } else if (!(Character.isAlphabetic(bchar))) {
            evt.consume();
        }
    }//GEN-LAST:event_fnameKeyTyped

    private void ageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageKeyTyped
      char vchar = evt.getKeyChar();
        char bchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar))) {
            evt.consume();
        } else if (!(Character.isAlphabetic(bchar))) {
            evt.consume();
        }
    }//GEN-LAST:event_ageKeyTyped

    private void contactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactKeyTyped
        char vchar = evt.getKeyChar();
        char bchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar))) {
            evt.consume();
        } else if (!(Character.isAlphabetic(bchar))) {
            evt.consume();
        }
    }//GEN-LAST:event_contactKeyTyped

    private void addressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressKeyTyped
   char vchar = evt.getKeyChar();
        char bchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar))) {
            evt.consume();
        } else if (!(Character.isAlphabetic(bchar))) {
            evt.consume();
        }
    }//GEN-LAST:event_addressKeyTyped

    private void positionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_positionKeyTyped
    char vchar = evt.getKeyChar();
        char bchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar))) {
            evt.consume();
        } else if (!(Character.isAlphabetic(bchar))) {
            evt.consume();
        }
    }//GEN-LAST:event_positionKeyTyped

    private void deptKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deptKeyTyped
     char vchar = evt.getKeyChar();
        char bchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar))) {
            evt.consume();
        } else if (!(Character.isAlphabetic(bchar))) {
            evt.consume();
        }
    }//GEN-LAST:event_deptKeyTyped

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
            java.util.logging.Logger.getLogger(Timein.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Timein.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Timein.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Timein.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
   /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Timein().setVisible(true);
            }
        });
      
    }
private void initWebcam() {
    Dimension size = WebcamResolution.QVGA.getSize();
    List<Webcam> webcams = Webcam.getWebcams();
    
    if (webcams.isEmpty()) {
        // Handle case when no webcams are available
        System.out.println("No webcam found!");
        return;
    }
    
    webcam = webcams.get(0);
    
    panel = new WebcamPanel(webcam);
    panel.setPreferredSize(size);
    panel.setFPSDisplayed(true);
    
    jPanel2.setLayout(new AbsoluteLayout()); // Set appropriate layout manager for jPanel2
    jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));
  
    webcam.open(); // Open the webcam
    
    executor.execute(this); // Assuming this is correctly set up
    
    // If jPanel2 is already displayed on a frame, you may need to revalidate/repaint it
    jPanel2.revalidate();
    jPanel2.repaint();
}
@Override
public void run() {
    do {
          Calendar cal  = Calendar.getInstance();
           //get current hour
           hour = cal.get(Calendar.HOUR_OF_DAY);
           minute =cal.get(Calendar.MINUTE);
           second =cal.get(Calendar.SECOND);
           
           //SIMPLE DATE FOPRMAT for 24 hours
          SimpleDateFormat sdf24 = new SimpleDateFormat("HH:mm:ss");
Date dat = cal.getTime();
String time24 = sdf24.format(dat);
         //set to LABEL
           time.setText(time24); //time is a label
       Date currentDate = new Date();

        // Create a SimpleDateFormat object to define the date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Format the current date using the defined format
        String formattedDate = dateFormat.format(currentDate);

        // set the formatted date to label 
        date.setText(formattedDate);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Timein.class.getName()).log(Level.SEVERE, null, ex);
        }
        Result result = null;
        BufferedImage image = null;

        if (webcam.isOpen()) {
            if ((image = webcam.getImage()) == null) {
                continue;
            }
        }
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        try {
            result = new MultiFormatReader().decode(bitmap);
        } catch (NotFoundException ex) {
            Logger.getLogger(Timein.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (result != null) {
            // Disseminate the result to the text fields
            String qrContent = result.getText();
            String[] data = qrContent.split(",");
            if (data.length == 7) { // Make sure the QR code contains all expected fields
                SwingUtilities.invokeLater(() -> {
                    id.setText(data[0]);
                    fname.setText(data[1]);
                    age.setText(data[2]);
                    contact.setText(data[3]);
                    address.setText(data[4]);
                    position.setText(data[5]);
                    dept.setText(data[6]);
                });
            } else {
                JOptionPane.showMessageDialog(null, "QR code does not contain all expected fields");
            }
        }
    } while (true);
   
}

@Override
public Thread newThread(Runnable r){
    Thread t = new Thread(r, "My Thread");
    t.setDaemon(true);
    return t;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField age;
    private javax.swing.JTextField contact;
    private javax.swing.JLabel date;
    private javax.swing.JTextField dept;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField position;
    private javax.swing.JTable table;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
private void save_data(){
       try{
        
  String sql= "INSERT INTO attendance(employee_id,fullname,contact,position,department,Date,checkin,checkout)VALUE(?,?,?,?,?,?,?,?)";
   pst = conn.prepareStatement(sql);
   pst.setString(1,id.getText());
   pst.setString(2,fname.getText()); 
   pst.setString(3,contact.getText());  
   pst.setString(4,position.getText());
   pst.setString(5,dept.getText());
   pst.setString(6,date.getText());
    pst.setString(7,time.getText());
    pst.setString(8,time.getText());
       pst.execute();
      JOptionPane.showMessageDialog(null,"Data Added");
    }catch(Exception e){
      JOptionPane.showMessageDialog(null,e);
    }

   }
private void retrieve(){
try {
   String sql = "SELECT employee_id AS 'Employee ID', fullname AS 'Full Name',contact AS 'Contact Number',position AS 'Position',department AS 'Department',Date AS 'Date',checkin AS 'Time in' FROM attendance WHERE Date = CURDATE()";
pst = conn.prepareStatement(sql);
rs =pst.executeQuery();
table.setModel(DbUtils.resultSetToTableModel(rs));
}catch(Exception e){
   JOptionPane.showMessageDialog(rootPane, e);
}
}
      
 }