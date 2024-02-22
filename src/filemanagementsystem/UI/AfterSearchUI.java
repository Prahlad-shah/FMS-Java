/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package filemanagementsystem.UI;

import filemanagementsystem.AudioFrame;
import filemanagementsystem.EssentialsMethods;
import static filemanagementsystem.EssentialsMethods.scaleImage;
import filemanagementsystem.PdfFrame;
import filemanagementsystem.UserDatabases;
import filemanagementsystem.UserLoginForm_Index_Page;
import filemanagementsystem.VideoFrame;
import filemanagementsystem.WritingBlobData;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.LabelUI;

/**
 *
 * @author kalilinux
 */
public class AfterSearchUI extends javax.swing.JFrame {
    private String getSearchItem;
    private byte[] imagePhoto;
    byte[] video;
    byte[] audio;
    byte[] pdf;
    byte[] indexVideo, indexAudio,indexPdf;
    String fileImage,fileVideo,fileAudio,filePdf;
    public AfterSearchUI() throws ClassNotFoundException, SQLException {
        initComponents();
        imageForTabbedPane();
        
    }
     private void imageForTabbedPane() throws ClassNotFoundException, SQLException{
         
//            DatabaseConnection.DatabaseConnection();
//            ArrayList<byte[]> Images = EssentialsMethods.index_Image();
       
            String sqlQueryImage = "SELECT Image_Blob,Image_Name FROM ImageTable WHERE Image_Id="+EssentialsMethods.randomNumbers()+"";
            String sqlQueryVideo = "SELECT Video_Blob,Video_Name FROM VideoTable";
            String sqlQueryPDF = "SELECT Pdf_Blob,Pdf_Name FROM Documents";
            String sqlQueryAudio = "SELECT Audio_Blob,Audio_Name FROM AudioTable";
//            Statement stmt = DatabaseConnection.connection.createStatement();
//            Statement stmt1 = DatabaseConnection.connection.createStatement();
//            Statement stmt2 = DatabaseConnection.connection.createStatement();
//            Statement stmt3 = DatabaseConnection.connection.createStatement();
            Statement stmt = UserDatabases.userConnect.createStatement();
            Statement stmt1 = UserDatabases.userConnect.createStatement();
            Statement stmt2 = UserDatabases.userConnect.createStatement();
            Statement stmt3 = UserDatabases.userConnect.createStatement();
            ResultSet resultImage = stmt.executeQuery(sqlQueryImage);
            ResultSet resultVideo = stmt1.executeQuery(sqlQueryVideo);
            ResultSet resultPdf = stmt2.executeQuery(sqlQueryPDF);
            ResultSet resultAudio = stmt3.executeQuery(sqlQueryAudio);
            
            while(resultImage.next()){
                 imagePhoto = resultImage.getBytes("Image_Blob");
                 fileImage = resultImage.getString("Image_Name");
                System.out.println(imagePhoto);
                scaleImage(imagePhoto, imageLabel);
            }
             while(resultVideo.next()){
                  video = resultVideo.getBytes("Video_Blob");
                 indexVideo = EssentialsMethods.index_Video();
               fileVideo = resultVideo.getString("Video_Name");
                System.out.println(video);
                
                 scaleImage(indexVideo,videoLabel);
            }
             while(resultAudio.next()){
                  audio = resultAudio.getBytes("Audio_Blob");
                 fileAudio = resultAudio.getString("Audio_Name");
                 indexAudio = EssentialsMethods.index_Audio();
                 System.out.println(audio);
                 scaleImage(indexAudio, audioLabel);
             }
            while(resultPdf.next()){
                 pdf = resultPdf.getBytes("Pdf_Blob");
                filePdf = resultPdf.getString("Pdf_Name");
                indexPdf  = EssentialsMethods.index_Pdf();
                scaleImage(indexPdf, pdfLabel);
                String indPath = "/home/kalilinux/NetBeansProjects/images/Index-Image/pdf.png";
                ImageIcon ic = new ImageIcon(indPath);
                Image img = ic.getImage();
                Image image = img.getScaledInstance(pdfLabel.getWidth(), pdfLabel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(image);
                pdfLabel.setIcon(icon);
                System.out.println(pdf);
            }
        }
       
     public void searchFile(String getFieldItem) throws ClassNotFoundException, SQLException{
//            DatabaseConnection.DatabaseConnection();
            UserDatabases.getConnection(UserLoginForm_Index_Page.username);
            String getSearchItems =getFieldItem;
            String sqlQueryImage = "SELECT Image_Blob,Image_Name FROM ImageTable WHERE Image_Name='"+getSearchItems+"'";
            String sqlQueryVideo = "SELECT Video_Blob FROM VideoTable WHERE Video_Name='"+getSearchItems+"'";
            String sqlQueryPDF = "SELECT Pdf_Blob FROM PdfFilesTable WHERE Pdf_Name='"+getSearchItems+"'";
            String sqlQueryAudio = "SELECT Audio_Blob FROM AudioTable WHERE Audio_Name='"+getSearchItems+"'";
//            Statement stmt = DatabaseConnection.connection.createStatement();
//            Statement stmt1 = DatabaseConnection.connection.createStatement();
//            Statement stmt2 = DatabaseConnection.connection.createStatement();
//            Statement stmt3 = DatabaseConnection.connection.createStatement();
            Statement stmt = UserDatabases.userConnect.createStatement();
            Statement stmt1 = UserDatabases.userConnect.createStatement();
            Statement stmt2 = UserDatabases.userConnect.createStatement();
            Statement stmt3 = UserDatabases.userConnect.createStatement();
            ResultSet resultImage = stmt.executeQuery(sqlQueryImage);
            ResultSet resultVideo = stmt1.executeQuery(sqlQueryVideo);
            ResultSet resultPdf = stmt2.executeQuery(sqlQueryPDF);
            ResultSet resultAudio = stmt3.executeQuery(sqlQueryAudio);
            if(resultImage.next()){
                byte[] image = resultImage.getBytes("Image_Blob");
                
                System.out.println(image);
//                ImageIcon icon = new ImageIcon(image);
//                Image imageimg = icon.getImage();
//                Image scaleImage = imageimg.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
//                ImageIcon imageOriginal = new ImageIcon(scaleImage);
//                jLabel1.setIcon(imageOriginal);
                    EssentialsMethods.scaleImage(image, photoLabel);
                    jLabel1.setText(getSearchItem);
            }
            else if(resultVideo.next()){
                 byte[] video = resultVideo.getBytes("Video_Blob");
                System.out.println(video);
              byte[] vid = EssentialsMethods.index_Video();
                 EssentialsMethods.scaleImage(vid, jLabel2);

            }
             else if(resultAudio.next()){
                 byte[] aud = resultAudio.getBytes("Audio_Blob");
                 System.out.println(aud);
                 byte[] audi = EssentialsMethods.index_Audio();
                 EssentialsMethods.scaleImage(audi, photoLabel);
             }
           else if(resultPdf.next()){
                byte[] pdf = resultPdf.getBytes("Pdf_Blob");
                System.out.println(pdf);
                byte[] pdff = EssentialsMethods.index_Pdf();
                EssentialsMethods.scaleImage(pdff, photoLabel);
            }else{
                JOptionPane.showMessageDialog(rootPane, "No Match Found :)");
           }
        }
     public static void downloadUniqueFile(String fileType) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException{
         
//            while(result.next()){
//                InputStream inpt = result.getBinaryStream(blobData);
////                extensionfromDB = result.getString(blobType);
//                while(inpt.read(buffer)>0){
//                    fos.write(buffer);
//                }
//                Desktop.getDesktop().open(new File(downloadLocation));
            }
       
     public void streamUniqueFile() throws ClassNotFoundException, SQLException, IOException{
//            DatabaseConnection.DatabaseConnection();
            UserDatabases.getConnection(UserLoginForm_Index_Page.username);
            getSearchItem =searchField.getText();
            String sqlQueryImage = "SELECT Image_Blob,Image_Name FROM ImageTable WHERE Image_Name='"+getSearchItem+"'";
            String sqlQueryVideo = "SELECT Video_Blob FROM VideoTable WHERE Video_Name='"+getSearchItem+"'";
            String sqlQueryPDF = "SELECT Pdf_Blob FROM Documents WHERE Pdf_Name='"+getSearchItem+"'";
            String sqlQueryAudio = "SELECT Audio_Blob FROM AudioTable WHERE Audio_Name='"+getSearchItem+"'";
//            Statement stmt = DatabaseConnection.connection.createStatement();
//            Statement stmt1 = DatabaseConnection.connection.createStatement();
//            Statement stmt2 = DatabaseConnection.connection.createStatement();
//            Statement stmt3 = DatabaseConnection.connection.createStatement();
            Statement stmt = UserDatabases.userConnect.createStatement();
            Statement stmt1 = UserDatabases.userConnect.createStatement();
            Statement stmt2 = UserDatabases.userConnect.createStatement();
            Statement stmt3 = UserDatabases.userConnect.createStatement();
            ResultSet resultImage = stmt.executeQuery(sqlQueryImage);
            ResultSet resultVideo = stmt1.executeQuery(sqlQueryVideo);
            ResultSet resultPdf = stmt2.executeQuery(sqlQueryPDF);
            ResultSet resultAudio = stmt3.executeQuery(sqlQueryAudio);
            
            if(resultImage.next()){
                byte[] image = resultImage.getBytes("Image_Blob");
                UseableFrame imageFrame = new UseableFrame();
                 EssentialsMethods.scaleImage(image, UseableFrame.useLabel);
                UseableFrame.usePanel.add(UseableFrame.useLabel);
                imageFrame.add(UseableFrame.usePanel);
                imageFrame.setVisible(rootPaneCheckingEnabled);
                }
            else if(resultVideo.next()){
                String downloadLocation = "/home/kalilinux/NetBeansProjects/filemanagementsystem/downloadedFromDBMS/fetch/video.mp4";
                File deviceLocation = new File(downloadLocation);
                FileOutputStream fos = new FileOutputStream(deviceLocation);
                byte[] buffer = new byte[1024];
                InputStream inpt = resultVideo.getBinaryStream("Video_Blob");
//                extensionfromDB = result.getString(blobType);
                while(inpt.read(buffer)>0){
                    fos.write(buffer);
                }
                Desktop.getDesktop().open(new File(downloadLocation));
            }
             else if(resultAudio.next()){
                 
                String downloadLocation = "/home/kalilinux/NetBeansProjects/filemanagementsystem/downloadedFromDBMS/fetch/audio.mp3";
                File deviceLocation = new File(downloadLocation);
                FileOutputStream fos = new FileOutputStream(deviceLocation);
                byte[] buffer = new byte[1024];
                InputStream inpt = resultVideo.getBinaryStream("Audio_Blob");
//                extensionfromDB = result.getString(blobType);
                while(inpt.read(buffer)>0){
                    fos.write(buffer);
                }
                Desktop.getDesktop().open(new File(downloadLocation));
             }
           else if(resultPdf.next()){
               String downloadLocation = "/home/kalilinux/NetBeansProjects/filemanagementsystem/downloadedFromDBMS/fetch/pdffile.pdf";
                File deviceLocation = new File(downloadLocation);
                FileOutputStream fos = new FileOutputStream(deviceLocation);
                byte[] buffer = new byte[1024];
                InputStream inpt = resultVideo.getBinaryStream("Pdf_Blob");
//                extensionfromDB = result.getString(blobType);
                while(inpt.read(buffer)>0){
                    fos.write(buffer);
                }
                Desktop.getDesktop().open(new File(downloadLocation));
   
           }else{
                JOptionPane.showMessageDialog(rootPane, "No Match Found :)");
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        photoLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        dropOn = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        videoLabel = new javax.swing.JLabel();
        audioLabel = new javax.swing.JLabel();
        pdfLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(40, 146, 252));
        jPanel1.setAutoscrolls(true);

        photoLabel.setText("photo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(photoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );

        jPanel3.setBackground(java.awt.Color.magenta);
        jPanel3.setFocusCycleRoot(true);

        dropOn.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.disabledShadow"));
        dropOn.setFont(new java.awt.Font("FreeSerif", 1, 24)); // NOI18N
        dropOn.setText("DropONN");

        jPanel8.setBackground(java.awt.Color.magenta);

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dropOn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dropOn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(59, 155, 251));

        jLabel2.setText("Details");

        jLabel3.setText("Name : ");

        jLabel5.setText("Type :");

        jLabel7.setText("Size");

        jButton1.setText("Download");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Stream");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jLabel10.setText("N/A");

        jLabel11.setText("N/A");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4))))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel5.setAutoscrolls(true);
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jTabbedPane1.setBackground(new java.awt.Color(52, 153, 254));
        jTabbedPane1.setOpaque(true);

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageLabelMouseClicked(evt);
            }
        });
        jPanel7.add(imageLabel);

        videoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                videoLabelMouseClicked(evt);
            }
        });
        jPanel7.add(videoLabel);

        audioLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                audioLabelMouseClicked(evt);
            }
        });
        jPanel7.add(audioLabel);

        pdfLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pdfLabelMouseClicked(evt);
            }
        });
        jPanel7.add(pdfLabel);

        jTabbedPane1.addTab("For You", jPanel7);

        jPanel5.add(jTabbedPane1);

        jLabel9.setText("Related Contents");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 604, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(54, 154, 253));
        jMenuBar1.setMargin(new java.awt.Insets(5, 15, 15, 15));

        jMenu1.setText("File");

        jMenuItem1.setText("Images");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Videos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Documents");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Audio");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.setMargin(new java.awt.Insets(0, 10, 0, 0));

        jMenuItem6.setText("Select");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Select All");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Delete");
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Recents");
        jMenu3.setMargin(new java.awt.Insets(0, 10, 0, 0));
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Most Visit");
        jMenu4.setMargin(new java.awt.Insets(0, 10, 0, 0));
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Liked");
        jMenu5.setMargin(new java.awt.Insets(0, 10, 0, 0));
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            
            String downloadPath = "/home/kalilinux/Downloads/FMSDownloads/"+getSearchItem+WritingBlobData.extensionfromDB+"";
            WritingBlobData.downloadFiles(getSearchItem,downloadPath);
            JOptionPane.showMessageDialog(rootPane, "The File Is Downloaded at\n"+downloadPath);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(AfterSearchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            streamUniqueFile();
            
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(AfterSearchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            ImageFrame image = new ImageFrame();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AfterSearchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            WritingBlobData.deletePicture(getSearchItem);
            JOptionPane.showMessageDialog(rootPane, "Deleted Success ");
        } catch (IOException ex) {
            Logger.getLogger(AfterSearchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            
            searchFile(searchField.getText());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AfterSearchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void videoLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videoLabelMouseClicked
        try{
            String path = "/home/kalilinux/NetBeansProjects/filemanagementsystem/downloadedFromDBMS/video.mp4";
            if(!video.equals("")){
//                UseableFrame use = new UseableFrame();
//                scaleImage(video, UseableFrame.useLabel);
//                use.setVisible(true);
                WritingBlobData.downloadFilesStream(fileVideo, path);
             
                Desktop.getDesktop().open(new File(path));
            }else{
                UseableFrame.useLabel.setText("No Contents");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(AfterSearchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_videoLabelMouseClicked

    private void imageLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageLabelMouseClicked
        try {
              if(!imagePhoto.equals("")){
                UseableFrame use = new UseableFrame();
                scaleImage(imagePhoto, UseableFrame.useLabel);
                use.setVisible(true);
               
            }else{
                UseableFrame.useLabel.setText("No Contents");
            }
        } catch (ClassNotFoundException | SQLException  ex) {
            Logger.getLogger(AfterSearchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_imageLabelMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            VideoFrame videoframe = new VideoFrame();
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(AfterSearchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            PdfFrame pdfframe = new PdfFrame();
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(AfterSearchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            AudioFrame audioframe = new AudioFrame();
            // TODO add your handling code here:
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(AfterSearchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void audioLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_audioLabelMouseClicked
         try{
            String path = "/home/kalilinux/NetBeansProjects/filemanagementsystem/downloadedFromDBMS/audio.mp3";
            if(!audio.equals("")){
           
                WritingBlobData.downloadFilesStream(fileAudio, path);
                Desktop.getDesktop().open(new File(path));
            }else{
//                UseableFrame.useLabel.setText("No Contents");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(AfterSearchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_audioLabelMouseClicked

    private void pdfLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdfLabelMouseClicked
        try{
            String path = "/home/kalilinux/NetBeansProjects/filemanagementsystem/downloadedFromDBMS/docs.pdf";
            if(!pdf.equals("")){
//                UseableFrame use = new UseableFrame();
//                scaleImage(video, UseableFrame.useLabel);
//                use.setVisible(true);
                WritingBlobData.downloadFilesStream(filePdf, path);
                Desktop.getDesktop().open(new File(path));
            }else{
                UseableFrame.useLabel.setText("No Contents");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(AfterSearchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pdfLabelMouseClicked

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
            java.util.logging.Logger.getLogger(AfterSearchUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AfterSearchUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AfterSearchUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AfterSearchUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new AfterSearchUI().setVisible(true);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(AfterSearchUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel audioLabel;
    private javax.swing.JLabel dropOn;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    public javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel pdfLabel;
    public static javax.swing.JLabel photoLabel;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel videoLabel;
    // End of variables declaration//GEN-END:variables
}
