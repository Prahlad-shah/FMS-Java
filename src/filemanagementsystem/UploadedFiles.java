/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package filemanagementsystem;

import filemanagementsystem.UI.AfterSearchUI;
import filemanagementsystem.UI.ContentNullPanel;
import filemanagementsystem.UI.ImageFrame;
import filemanagementsystem.UI.UseableFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author kalilinux
 */
public class UploadedFiles extends javax.swing.JFrame {
ArrayList<byte[]> list;
    /**
     * Creates new form UploadedFiles
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public UploadedFiles() throws ClassNotFoundException, SQLException {
        initComponents();
//        DatabaseConnection.DatabaseConnection();
            UserDatabases.getConnection(UserLoginForm_Index_Page.username);
         list =  RecentsUploads.fetchFiles();
        one();
        two();
        three();
        four();
        five();
        six();
        setImage();
        profileNameLabel.setText(UserLoginForm_Index_Page.user);
//        profileNameLabel.setText("Saina Sanjal");
    }
    private void fetchContents() throws ClassNotFoundException, SQLException{
        DatabaseConnection.DatabaseConnection();
        UserDatabases.getConnection(UserLoginForm_Index_Page.username);
        Statement stmt = DatabaseConnection.connection.createStatement();
        ResultSet result = stmt.executeQuery("select Index_Pdf from IndexTable");
        byte[] blob = null;
        
        while(result.next()){
            blob =  result.getBytes("Index_Pdf");
            System.out.println(blob);
            //byte[] indexPdf = EssentialsMethods.index_Pdf();
            ImageIcon icon = new ImageIcon(blob);
            Image img = icon.getImage();
            JLabel l1 = new JLabel();
            l1.setSize(200, 200);
            Image scaleImg = img.getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(scaleImg);
            l1.setIcon(image); 
            ImageFrame frame = new ImageFrame();
            frame.setVisible(true);
           frame.add(l1);
    }
    }
    
    private void setImage() throws ClassNotFoundException, SQLException{
        if(!EssentialsMethods.fetchUserProfile().equals("")){
            byte[] profile = EssentialsMethods.fetchUserProfile();
            ImageIcon icon = new ImageIcon(profile);
            Image img = icon.getImage();
            Image scaleImage = img.getScaledInstance(profileLabebl.getWidth(), profileLabebl.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageOriginal = new ImageIcon(scaleImage);
            profileLabebl.setIcon(imageOriginal);
        }else{
//            this.remove(profileLabebl);
            jPanel1.remove(HintsPanel);
            ContentNullPanel empty = new ContentNullPanel();
            jPanel1.setLayout(new FlowLayout());
            jPanel1.add(empty,BorderLayout.CENTER);
        }
    }
    private void one(){
        ImageIcon icon = new ImageIcon(list.get(0));
        Image img = icon.getImage();
        Image scaleImg = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(scaleImg);
        jLabel1.setIcon(image);
        System.out.println(list);
    }
    private void two(){
        ImageIcon icon = new ImageIcon(list.get(1));
        Image img = icon.getImage();
        Image scaleImg = img.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(scaleImg);
        jLabel2.setIcon(image);
        System.out.println(list);
    }
    private void three(){
        ImageIcon icon = new ImageIcon(list.get(2));
        Image img = icon.getImage();
        Image scaleImg = img.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(scaleImg);
        jLabel3.setIcon(image);
        System.out.println(list);
    }
    private void four(){
        ImageIcon icon = new ImageIcon(list.get(3));
        Image img = icon.getImage();
        Image scaleImg = img.getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(scaleImg);
        jLabel4.setIcon(image);
        System.out.println(list);
    }
    private void five(){
        ImageIcon icon = new ImageIcon(list.get(4));
        Image img = icon.getImage();
        Image scaleImg = img.getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(scaleImg);
        jLabel5.setIcon(image);
        System.out.println(list);
    }
    private void six(){
        ImageIcon icon = new ImageIcon(list.get(5));
        Image img = icon.getImage();
        Image scaleImg = img.getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(scaleImg);
        jLabel6.setIcon(image);
        System.out.println(list);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        FramePanelRoot = new javax.swing.JPanel();
        DropONNPanel = new javax.swing.JPanel();
        dropOn = new javax.swing.JLabel();
        uPloadButton = new javax.swing.JButton();
        profileNameLabel = new javax.swing.JLabel();
        profileLabebl = new javax.swing.JLabel();
        ButtonsPanel = new javax.swing.JPanel();
        imageButton = new javax.swing.JButton();
        videoButton = new javax.swing.JButton();
        documentsButton = new javax.swing.JButton();
        favouriteButton = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        searchBar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        HintsPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        FramePanelRoot.setBackground(new java.awt.Color(17, 135, 254));

        DropONNPanel.setBackground(java.awt.Color.magenta);
        DropONNPanel.setFocusCycleRoot(true);

        dropOn.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.disabledShadow"));
        dropOn.setFont(new java.awt.Font("FreeSerif", 1, 24)); // NOI18N
        dropOn.setText("DropONN");

        uPloadButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        uPloadButton.setText("Upload");
        uPloadButton.setFocusable(false);
        uPloadButton.setVerifyInputWhenFocusTarget(false);
        uPloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uPloadButtonActionPerformed(evt);
            }
        });

        profileNameLabel.setText("prahlad shah");
        profileNameLabel.setOpaque(true);

        profileLabebl.setText("Add Profile");
        profileLabebl.setOpaque(true);
        profileLabebl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileLabeblMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout DropONNPanelLayout = new javax.swing.GroupLayout(DropONNPanel);
        DropONNPanel.setLayout(DropONNPanelLayout);
        DropONNPanelLayout.setHorizontalGroup(
            DropONNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DropONNPanelLayout.createSequentialGroup()
                .addComponent(dropOn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(uPloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(profileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileLabebl, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        DropONNPanelLayout.setVerticalGroup(
            DropONNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DropONNPanelLayout.createSequentialGroup()
                .addComponent(dropOn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(DropONNPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(uPloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DropONNPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(profileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(profileLabebl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ButtonsPanel.setBackground(new java.awt.Color(16, 113, 249));
        ButtonsPanel.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        imageButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        imageButton.setText("Images");
        imageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageButtonActionPerformed(evt);
            }
        });
        ButtonsPanel.add(imageButton);

        videoButton.setText("Videos");
        videoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                videoButtonActionPerformed(evt);
            }
        });
        ButtonsPanel.add(videoButton);

        documentsButton.setText("Documents");
        documentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                documentsButtonActionPerformed(evt);
            }
        });
        ButtonsPanel.add(documentsButton);

        favouriteButton.setText("Audio");
        favouriteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favouriteButtonActionPerformed(evt);
            }
        });
        ButtonsPanel.add(favouriteButton);

        searchBtn.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(41, 113, 247));

        HintsPanel.setBackground(new java.awt.Color(21, 136, 251));
        HintsPanel.setLayout(new java.awt.GridLayout(2, 0, 5, 5));
        HintsPanel.add(jLabel2);
        HintsPanel.add(jLabel5);
        HintsPanel.add(jLabel3);
        HintsPanel.add(jLabel1);
        HintsPanel.add(jLabel4);
        HintsPanel.add(jLabel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(HintsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(HintsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout FramePanelRootLayout = new javax.swing.GroupLayout(FramePanelRoot);
        FramePanelRoot.setLayout(FramePanelRootLayout);
        FramePanelRootLayout.setHorizontalGroup(
            FramePanelRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DropONNPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FramePanelRootLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FramePanelRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FramePanelRootLayout.createSequentialGroup()
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 323, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        FramePanelRootLayout.setVerticalGroup(
            FramePanelRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FramePanelRootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DropONNPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FramePanelRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(java.awt.Color.blue);
        jMenuBar1.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jMenuBar1.setName(""); // NOI18N

        jMenu1.setText("File");

        jMenuItem1.setText("Images");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
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
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Documents");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseClicked(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Audio");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem4MouseClicked(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

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

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FramePanelRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FramePanelRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageButtonActionPerformed
       try {
       if(EssentialsMethods.ImageFetch()==true){
           ImageFrame image = new ImageFrame();
           image.setVisible(rootPaneCheckingEnabled);
       }else{
            JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
       }
    } catch (SQLException | ClassNotFoundException  ex) {
        Logger.getLogger(UploadedFiles.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
    }
    }//GEN-LAST:event_imageButtonActionPerformed

    private void videoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_videoButtonActionPerformed
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
    }//GEN-LAST:event_videoButtonActionPerformed

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
        String path = null;
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
//                iconimage = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(panelView1.getWidth(),
//                    panelView1.getHeight(),Image.SCALE_SMOOTH));

        }else if(result==JFileChooser.CANCEL_OPTION){

        }
        int lastIndex = path.lastIndexOf(".");
        String extension = path.substring(lastIndex);
        if(extension.equals(".jpg")| extension.equals(".png")| extension.equals(".jpeg")|extension.equals("webp") ){
            System.out.println(UserLoginForm_Index_Page.username);
            System.out.println(UserLoginForm_Index_Page.user);
            if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user) ){
                UserDatabases.getConnection(UserLoginForm_Index_Page.user);
                 String  ImageName =  EssentialsMethods.setName(path);
                HomePageForm.uploadImage(path,ImageName,extension);
//                panelView1.setIcon(iconimage);

                JOptionPane.showMessageDialog(rootPane, "Image Uploaded Successfull ");
            }

        }else if(extension.equals(".mp4")| extension.equals(".mkv")|extension.equals(".Webm")){
            if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user) ){
                UserDatabases.getConnection(UserLoginForm_Index_Page.user);
             String  videoName =  EssentialsMethods.setName(path);
            HomePageForm.uploadVideo(path,videoName,extension);
            }
            //            Video Message
            JOptionPane.showMessageDialog(rootPane, "Video Uploaded Successfull");
        }else if(extension.equals(".pdf")|extension.equals(".txt")|extension.equals(".docx")|extension.equals(".ppt")){
            if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user) ){
                UserDatabases.getConnection(UserLoginForm_Index_Page.username);
                 String  pdfName =  EssentialsMethods.setName(path);
                HomePageForm.uploadDocuments(path,pdfName,extension);
            }

            //            pdf message
            JOptionPane.showMessageDialog(rootPane, "Pdf File was Uploaded Successfull");
        }
        else if(extension.equals(".audio")){
            if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user)){
                UserDatabases.getConnection(UserLoginForm_Index_Page.user);
                 String  audioName =  EssentialsMethods.setName(path);
                HomePageForm.uploadAudio(path,audioName,extension);
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

    private void profileLabeblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileLabeblMouseClicked
       String path;
        JFileChooser chooser = new JFileChooser();
       chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg","jpeg","png",".webp");
            chooser.addChoosableFileFilter(filter);
            int result = chooser.showSaveDialog(null);
            if (result==JFileChooser.APPROVE_OPTION) {
                File selected = chooser.getSelectedFile();
                path = selected.getAbsolutePath();
               int indexof  = path.lastIndexOf(".");
                String extension  = path.substring(indexof);
                ImageIcon icon = new ImageIcon(path);
                Image scaleImage = icon.getImage();
                Image image = scaleImage.getScaledInstance(profileLabebl.getWidth(), profileLabebl.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon originalIcon = new ImageIcon(image);
                profileLabebl.setIcon(originalIcon);
                if(!profileLabebl.getIcon().equals("")){
                    try {
                        UserDatabases.getConnection(UserLoginForm_Index_Page.username);
                        HomePageForm.uploadImageProfile(path, UserLoginForm_Index_Page.username);
                    } catch (ClassNotFoundException | SQLException | IOException ex) {
                        Logger.getLogger(UploadedFiles.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }else if(result==JFileChooser.CANCEL_OPTION){
           
        }else{
             JOptionPane.showMessageDialog(rootPane, "File Format Not Supported !!!");
        }
    }//GEN-LAST:event_profileLabeblMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        AfterSearchUI after;
        String search = searchBar.getText();
    try {
        after = new AfterSearchUI();
        after.searchFile(search);
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(UploadedFiles.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_searchBtnActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void documentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentsButtonActionPerformed
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
    
    }//GEN-LAST:event_documentsButtonActionPerformed

    private void favouriteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favouriteButtonActionPerformed
    try {
       if(EssentialsMethods.audioFetch()==true){
           AudioFrame audio = new AudioFrame();
       }else{
            JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
       }
    } catch (SQLException | ClassNotFoundException | IOException ex) {
//        Logger.getLogger(UploadedFiles.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
    }
    }//GEN-LAST:event_favouriteButtonActionPerformed

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
       if(EssentialsMethods.audioFetch()){
           AudioFrame audio = new AudioFrame();
       }else{
            JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
       }
    } catch (SQLException | ClassNotFoundException | IOException ex) {
        Logger.getLogger(UploadedFiles.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(rootPane, "NO Contents Available");
    }
        // TODO add your handling code here:
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

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
    try {
        if(EssentialsMethods.ImageFetch()==true){
            ImageFrame image = new ImageFrame();
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(UploadedFiles.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jMenuItem1MouseClicked

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
            java.util.logging.Logger.getLogger(UploadedFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UploadedFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UploadedFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UploadedFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new UploadedFiles().setVisible(true);
                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UploadedFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonsPanel;
    private javax.swing.JPanel DropONNPanel;
    private javax.swing.JPanel FramePanelRoot;
    private javax.swing.JPanel HintsPanel;
    private javax.swing.JButton documentsButton;
    private javax.swing.JLabel dropOn;
    private javax.swing.JButton favouriteButton;
    private javax.swing.JButton imageButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel profileLabebl;
    private javax.swing.JLabel profileNameLabel;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton uPloadButton;
    private javax.swing.JButton videoButton;
    // End of variables declaration//GEN-END:variables
}
