/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package filemanagementsystem.UI;

import filemanagementsystem.DatabaseConnection;
import filemanagementsystem.UserDatabases;
import filemanagementsystem.UserLoginForm_Index_Page;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author kalilinux
 */
public class ImageFrame extends javax.swing.JFrame {

    /**
     * Creates new form ImageFrame
     */
    public ImageFrame() throws ClassNotFoundException, SQLException {
        initComponents();
        fetchContents();
    }
    private void fetchContents() throws ClassNotFoundException, SQLException{
//        DatabaseConnection.DatabaseConnection();
        UserDatabases.getConnection(UserLoginForm_Index_Page.username);
        UserDatabases.getConnection(UserLoginForm_Index_Page.username);
        Statement stmt = DatabaseConnection.connection.createStatement();
        ResultSet result = stmt.executeQuery("select * from ImageTable");
        byte[] blob = null;
        
        while(result.next()){
            blob =  result.getBytes("Image_Blob");
            System.out.println(blob);
            ImageIcon icon = new ImageIcon(blob);
            Image img = icon.getImage();
            JLabel l1 = new JLabel();
            l1.setSize(200, 200);
            Image scaleImg = img.getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(scaleImg);
            l1.setIcon(image); 
           this.add(l1);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new java.awt.GridLayout(0, 4, 5, 5));

        pack();
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ImageFrame().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ImageFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ImageFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
