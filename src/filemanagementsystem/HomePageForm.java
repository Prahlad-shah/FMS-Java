/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package filemanagementsystem;

import filemanagementsystem.UI.AfterSearchUI;
import filemanagementsystem.UI.ContentNullPanel;
import filemanagementsystem.UI.UseableFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author kalilinux
 */
public class HomePageForm extends javax.swing.JFrame {
    String path;
    UploadedFiles upload = new UploadedFiles();
    /**
     * Creates new form HomePageForm
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public HomePageForm() throws ClassNotFoundException, SQLException {
        initComponents();
//        DatabaseConnection.DatabaseConnection();
        if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user) ){
                     UserDatabases.getConnection(UserLoginForm_Index_Page.username);
                 }
           if(!RecentsUploads.fetchRecents1().equals("")){
               ImageIcon icon = new ImageIcon(RecentsUploads.fetchRecents1());
               Image img = icon.getImage();
               Image imgScale = img.getScaledInstance(panelView1.getWidth(), panelView1.getHeight(), Image.SCALE_SMOOTH);
               ImageIcon image1 = new ImageIcon(imgScale);
               panelView1.setIcon(image1);
            
               ImageIcon icon2 = new ImageIcon(RecentsUploads.fetchRecents2());
               Image img2 = icon2.getImage();
               Image imgScale2 = img2.getScaledInstance(panelView2.getWidth(), panelView2.getHeight(), Image.SCALE_SMOOTH);
               ImageIcon image2 = new ImageIcon(imgScale2);
               panelView2.setIcon(image2);
               
               ImageIcon icon3 = new ImageIcon(RecentsUploads.fetchRecents3());
               Image img3 = icon3.getImage();
               Image imgScale3 = img3.getScaledInstance(panelView3.getWidth(), panelView3.getHeight(), Image.SCALE_SMOOTH);
               ImageIcon image3 = new ImageIcon(imgScale2);
            panelView3.setIcon(image3);
            
            if(panelView1.getIcon() != null){
                System.out.println(panelView1.getIcon());
            panelView1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                  if(panelView1.getIcon() != null){
                      UseableFrame rphoto  = new UseableFrame();
                      rphoto.photoFrame();
                      rphoto.setVisible(rootPaneCheckingEnabled);
                  }else{
                      
                  }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
                }
             
            }
       
            });
            }
            panelView2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                try {
                    if(panelView2.getIcon() != null){
                    UseableFrame rphoto  = new UseableFrame();
                    rphoto.photoFrame1();
                    rphoto.setVisible(rootPaneCheckingEnabled);
                    }else{
                        panelView2.setText("No Contents Yet");
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            });
            panelView3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                try {
                    if(panelView3.getIcon() != null){
                    UseableFrame rphoto  = new UseableFrame();
                    rphoto.photoFrame2();
                    rphoto.setVisible(rootPaneCheckingEnabled);
                    }else{
                        
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            });
            
    }else{
//               recentsUploadsPanel.add(new Label("No Contents Yet..."));
            jPanel6.remove(recentsUploadsPanel);
               ContentNullPanel empty = new ContentNullPanel();
               jPanel6.setLayout(new FlowLayout());
               jPanel6.add(empty,BorderLayout.CENTER);
               this.setResizable(false);
           }
    }
    
    private static byte[] readFile(String file) throws IOException {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        return bos != null ? bos.toByteArray() : null;
           
        }
     static void uploadVideo(String filenamevideo,String videoName,String videoType) throws IOException, SQLException{
         String insertVideo = "insert into VideoTable(Video_Blob,Video_Name,Video_Type) values (?,?,?)";
//         PreparedStatement videostmt = DatabaseConnection.connection.prepareStatement(insertVideo);
         PreparedStatement videostmtforUser = UserDatabases.userConnect.prepareStatement(insertVideo);
         videostmtforUser.setBytes(1, readFile(filenamevideo));
         videostmtforUser.setString(2, videoName);
         videostmtforUser.setString(3, videoType);
         videostmtforUser.executeUpdate();
            System.out.println("uploaded");
     }
     static void uploadImage(String filenamevideo,String imageName,String imageType) throws IOException, SQLException{
         String insertImage = "insert into ImageTable(Image_Blob,Image_Name,Image_Type) values (?,?,?)";
//         PreparedStatement videostmt = DatabaseConnection.connection.prepareStatement(insertVideo);
         PreparedStatement imageStmt = UserDatabases.userConnect.prepareStatement(insertImage);
         imageStmt.setBytes(1, readFile(filenamevideo));
         imageStmt.setString(2, imageName);
         imageStmt.setString(3, imageType);
         imageStmt.executeUpdate();
            System.out.println("uploaded");
     }
     static void uploadImageProfile(String filenamevideo,String userName) throws IOException, SQLException{
         String insertImage = "insert into UserProfile(Profile_Image,Profile_UserName) values (?,?)";
//         PreparedStatement videostmt = DatabaseConnection.connection.prepareStatement(insertVideo);
         PreparedStatement imageStmt = UserDatabases.userConnect.prepareStatement(insertImage);
         imageStmt.setBytes(1, readFile(filenamevideo));
         imageStmt.setString(2, userName);
         imageStmt.executeUpdate();
            System.out.println("uploaded");
     }
     static void uploadAudio(String audioFile, String audioName,String audioType) throws SQLException, IOException{
         String insertAudio = "insert into AudioTable(Audio_Blob,Audio_Name,Audio_Type) values (?,?,?)";
         PreparedStatement audioStmt = UserDatabases.userConnect.prepareStatement(insertAudio);
         audioStmt.setBytes(1, readFile(audioFile));
         audioStmt.setString(2, audioName);
         audioStmt.setString(3, audioType);
         audioStmt.executeUpdate();
         System.out.println("Audio Uploaded");
     }
     static void uploadDocuments(String pdfFiles, String pdfName,String docsType) throws IOException, SQLException{
         String insertPdf = "insert into Documents(Pdf_Blob,Pdf_Name,Pdf_Type) values (?,?,?)";
         PreparedStatement pdfStmt = UserDatabases.userConnect.prepareStatement(insertPdf);
         pdfStmt.setBytes(1, readFile(pdfFiles));
         pdfStmt.setString(2, pdfName);
         pdfStmt.setString(2, docsType);
         pdfStmt.executeUpdate();
         System.out.println("Pdf Files Are Uploaded");
     }
     private static void uploadTextFiles(String textFiles, String textName,String textType) throws SQLException, IOException{
         String insertText = "insert into TextTable (Text_Blob,Text_Name,Text_Type) values (?,?,?)";
         PreparedStatement textStmt = UserDatabases.userConnect.prepareStatement(insertText);
         textStmt.setBytes(1, readFile(textFiles));
         textStmt.setString(2, textName);
         textStmt.setString(2, textType);
         textStmt.executeUpdate();
         System.out.println("text file is uploaded");
     }
     
     private void searchFile() throws ClassNotFoundException, SQLException{
//            DatabaseConnection.DatabaseConnection();
            UserDatabases.getConnection(UserLoginForm_Index_Page.username);
        String getSearchItem = searchBar.getText();
            String sqlQueryImage = "SELECT Image_Blob FROM ImageTable WHERE Image_Name='"+getSearchItem+"'";
            String sqlQueryVideo = "SELECT Video_Blob FROM VideoTable WHERE Video_Name='"+getSearchItem+"'";
            String sqlQueryPDF = "SELECT Pdf_Blob FROM PdfFilesTable WHERE Pdf_Name='"+getSearchItem+"'";
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
                System.out.println(image);
//                            
                    AfterSearchUI serch = new AfterSearchUI();
                    serch.setVisible(true);
                    EssentialsMethods.scaleImage(image, AfterSearchUI.photoLabel);
            }
            else if(resultVideo.next()){
                 byte[] video = resultVideo.getBytes("Video_Blob");
                System.out.println(video);
                 
                 AfterSearchUI serch = new AfterSearchUI();
                    serch.setVisible(true);
                    EssentialsMethods.scaleImage(video, AfterSearchUI.photoLabel);
            }
             else if(resultAudio.next()){
                 byte[] audio = resultAudio.getBytes("Audio_Blob");
                 System.out.println(audio);
                 
                 AfterSearchUI serch = new AfterSearchUI();
                    serch.setVisible(true);
                    EssentialsMethods.scaleImage(audio, AfterSearchUI.photoLabel);
             }
           else if(resultPdf.next()){
                byte[] pdf = resultPdf.getBytes("Pdf_Blob");
                System.out.println(pdf);
                
                AfterSearchUI serch = new AfterSearchUI();
                    serch.setVisible(true);
                    EssentialsMethods.scaleImage(pdf, AfterSearchUI.photoLabel);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        dropOn = new javax.swing.JLabel();
        uPloadButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        searchBar = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        recentsUploadsPanel = new javax.swing.JPanel();
        panelView1 = new javax.swing.JLabel();
        panelView2 = new javax.swing.JLabel();
        panelView3 = new javax.swing.JLabel();
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(java.awt.Color.magenta);
        jPanel2.setFocusCycleRoot(true);

        dropOn.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.disabledShadow"));
        dropOn.setFont(new java.awt.Font("FreeSerif", 1, 24)); // NOI18N
        dropOn.setText("DropONN");

        uPloadButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        uPloadButton.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        uPloadButton.setText("Upload");
        uPloadButton.setFocusable(false);
        uPloadButton.setVerifyInputWhenFocusTarget(false);
        uPloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uPloadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dropOn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 443, Short.MAX_VALUE)
                .addComponent(uPloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropOn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uPloadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        jPanel4.setBackground(new java.awt.Color(236, 252, 252));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setBackground(new java.awt.Color(244, 234, 244));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setText("Your Recent Uploads");
        jLabel1.setOpaque(true);
        jPanel4.add(jLabel1, new java.awt.GridBagConstraints());

        jPanel1.setBackground(new java.awt.Color(61, 153, 244));

        jPanel5.setBackground(new java.awt.Color(56, 146, 241));

        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });

        searchBtn.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(searchBtn))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        recentsUploadsPanel.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        recentsUploadsPanel.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        panelView1.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.selectionBackground"));
        panelView1.setForeground(java.awt.Color.magenta);
        panelView1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelView1.setMaximumSize(new java.awt.Dimension(500, 250));
        panelView1.setMinimumSize(new java.awt.Dimension(200, 100));
        panelView1.setPreferredSize(new java.awt.Dimension(300, 250));
        recentsUploadsPanel.add(panelView1);

        panelView2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recentsUploadsPanel.add(panelView2);
        recentsUploadsPanel.add(panelView3);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(recentsUploadsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(recentsUploadsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
        );

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
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Documents");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseClicked(evt);
            }
        });
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Audio");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem4MouseClicked(evt);
            }
        });
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(544, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            UploadedFiles imagesFiles = new UploadedFiles();
            imagesFiles.setVisible(true);

            // TODO add your handling code here:
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void uPloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uPloadButtonActionPerformed
        ImageIcon iconimage = null;
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg","jpeg","png",".mp4",".webp",".pdf",".text");
            chooser.addChoosableFileFilter(filter);
            int result = chooser.showSaveDialog(null);
            if (result==JFileChooser.APPROVE_OPTION) {
                File selected = chooser.getSelectedFile();
                path = selected.getAbsolutePath();
                System.out.println(path);
                //                jLabel2.setText(path);
                iconimage = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(panelView1.getWidth(),
                    panelView1.getHeight(),Image.SCALE_SMOOTH));

        }else if(result==JFileChooser.CANCEL_OPTION){

        }
        int lastIndex = path.lastIndexOf(".");
        String extension = path.substring(lastIndex);
        if(extension.equals(".jpg")| extension.equals(".png")| extension.equals(".jpeg")|extension.equals("webp") ){
            System.out.println(UserLoginForm_Index_Page.username);
            System.out.println(UserLoginForm_Index_Page.user);
            
            if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user) ){
                UserDatabases.getConnection(UserLoginForm_Index_Page.username);
             String  ImageName =  EssentialsMethods.setName(path);
                HomePageForm.uploadImage(path,ImageName,extension);
                panelView1.setIcon(iconimage);
               
                JOptionPane.showMessageDialog(rootPane, "Image Uploaded Successfull ");
            }

        }else if(extension.equals(".mp4")| extension.equals(".mkv")|extension.equals(".Webm")){
            if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user) ){
                UserDatabases.getConnection(UserLoginForm_Index_Page.username);
                String  videoName =  EssentialsMethods.setName(path);
                HomePageForm.uploadVideo(path,videoName,extension);
//            Video Message
            JOptionPane.showMessageDialog(rootPane, "Video Uploaded Successfull");
            }
            
        }else if(extension.equals(".pdf")|extension.equals(".txt")|extension.equals(".docx")|extension.equals(".ppt")){
            if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user) ){
                UserDatabases.getConnection(UserLoginForm_Index_Page.username);
                String  pdfName =  EssentialsMethods.setName(path);
                HomePageForm.uploadDocuments(path,pdfName,extension);
            }

//            pdf message
            JOptionPane.showMessageDialog(rootPane, "Pdf File was Uploaded Successfull");
        }
        else if(extension.equals(".mp3")){
            if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user)){
                UserDatabases.getConnection(UserLoginForm_Index_Page.username);
                String  audioName =  EssentialsMethods.setName(path);
                HomePageForm.uploadAudio(path,audioName,extension);
                JOptionPane.showMessageDialog(rootPane, "Audio File was uploaded Successfull");
            }
            
        }
        //            panelView1.setIcon(iconimage);
        System.out.println("hello");

        System.out.println("hi");
        this.revalidate();
        }catch(HeadlessException | IOException | SQLException e){

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_uPloadButtonActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        try {
            searchFile();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
          try {
       if(EssentialsMethods.videoFetch()==true){
           VideoFrame video = new VideoFrame();
           
       }else{
            JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
       }
    } catch (SQLException | ClassNotFoundException | IOException ex) {
        Logger.getLogger(UploadedFiles.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
    }
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseClicked
        try {
       if(EssentialsMethods.fetchDocs()==true){
           PdfFrame audio = new PdfFrame();
          
       }else{
            JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
       }
    } catch (SQLException | ClassNotFoundException | IOException ex) {
        Logger.getLogger(UploadedFiles.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
    }
    }//GEN-LAST:event_jMenuItem3MouseClicked

    private void jMenuItem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MouseClicked
        try {
       if(EssentialsMethods.audioFetch()==true){
           AudioFrame audio = new AudioFrame();
          
       }else{
            JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
       }
    } catch (SQLException | ClassNotFoundException | IOException ex) {
        Logger.getLogger(UploadedFiles.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
       if(EssentialsMethods.videoFetch()==true){
           VideoFrame audio = new VideoFrame();
          
       }else{
            JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
       }
    } catch (SQLException | ClassNotFoundException | IOException ex) {
        Logger.getLogger(UploadedFiles.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
       if(EssentialsMethods.fetchDocs()==true){
           PdfFrame audio = new PdfFrame();
          
       }else{
            JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
       }
    } catch (SQLException | ClassNotFoundException | IOException ex) {
        Logger.getLogger(UploadedFiles.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
       if(EssentialsMethods.audioFetch()==true){
           AudioFrame audio = new AudioFrame();
          
       }else{
            JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
       }
    } catch (SQLException | ClassNotFoundException | IOException ex) {
        Logger.getLogger(UploadedFiles.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed
            
    
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
            java.util.logging.Logger.getLogger(HomePageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new HomePageForm().setVisible(true);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dropOn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
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
    private javax.swing.JLabel panelView1;
    private javax.swing.JLabel panelView2;
    private javax.swing.JLabel panelView3;
    private javax.swing.JPanel recentsUploadsPanel;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton uPloadButton;
    // End of variables declaration//GEN-END:variables
}
