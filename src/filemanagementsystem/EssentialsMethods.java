/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanagementsystem;

import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author kalilinux
 */
public class EssentialsMethods {
        public static String generateRandomNumbers(){
           String random = String.valueOf((int)Math.floor(Math.random()*1000)) ;
            return random;
        }
        public static int randomNumbers(){
            int random = (int) Math.floor(Math.random()*10);
            return random;
            
        }
        public static void updateUserInfo(String phoneNumbers, String userName, String password) throws ClassNotFoundException, SQLException{
            DatabaseConnection.DatabaseConnection();
            String updateInfo = "update UserLogin set User_Name = ?, Password = ? where Phone_Numbers = "+phoneNumbers;
            String selectAllInfo = "select Phone_Numbers from UserLogin";
            PreparedStatement stmt = DatabaseConnection.connection.prepareStatement(selectAllInfo);
            ResultSet result = stmt.executeQuery();
            String phoneNumber = null;
            while(result.next()){
                 phoneNumber = result.getString("Phone_Numbers");
//                System.out.println(phoneNumber);
                if(phoneNumber.equals(phoneNumbers)){
                    PreparedStatement stmtforSelect = DatabaseConnection.connection.prepareStatement(updateInfo);
                    stmtforSelect.setString(1, userName);
                    stmtforSelect.setString(2, password);
                    stmtforSelect.executeUpdate();
                    System.out.println("Updated successfully");
                    break;
                }else{
                    System.out.println("no records found");
                    
                }}
           
        }
        public static byte[] fetchUserProfile() throws ClassNotFoundException, SQLException{
            byte[] images = null;
            DatabaseConnection.DatabaseConnection();
            Statement stmt = DatabaseConnection.connection.createStatement();
            String userName = UserLoginForm_Index_Page.username;
            String prahlad = "Prahlad785";
            String selectQuery = "SELECT * FROM ImageTable";
            ResultSet res = stmt.executeQuery(selectQuery);
            while(res.next()){
//               String usName = res.getString("User_Name");
                 images = res.getBytes("Image_Blob");
//                System.out.println(images);
            }
            return images;
            
        }
        public static void fetchMixedFile() throws ClassNotFoundException, SQLException{
            DatabaseConnection.DatabaseConnection();
            ArrayList<byte[]> list = new ArrayList<>();
            Statement stmt = DatabaseConnection.connection.createStatement();
            String mixedQuery = "select * from ImageTable";
            ResultSet result = stmt.executeQuery(mixedQuery);
            while(result.next()){
            String imageName = result.getString("Image_Name");
                System.out.println(imageName);
            }
        }
        public static ArrayList<byte[]> index_Image() throws ClassNotFoundException, SQLException{
            DatabaseConnection.DatabaseConnection();
            ArrayList<byte[]> inedxImages = null;
            String indexQuery = "Select * from IndexTable";
            Statement stmt = DatabaseConnection.connection.createStatement();
            ResultSet result = stmt.executeQuery(indexQuery);
            while(result.next()){
                byte[] videoImage = result.getBytes("Index_Video");
                byte[] audioImage = result.getBytes("Index_Audio");
                byte[] pdfImage = result.getBytes("Index_Pdf");
                inedxImages = new ArrayList<>();
                inedxImages.add(videoImage);
                inedxImages.add(audioImage);
                inedxImages.add(pdfImage);
            }
            return inedxImages;
           
        }
        public static byte[] index_Video() throws ClassNotFoundException, SQLException{
            DatabaseConnection.DatabaseConnection();
            byte[] videoImage = null;
            String indexQuery = "Select Index_Video from IndexTable";
            Statement stmt = DatabaseConnection.connection.createStatement();
            ResultSet result = stmt.executeQuery(indexQuery);
            while(result.next()){
                videoImage = result.getBytes("Index_Video"); 
            }
            return videoImage;
        }
        public static byte[] index_Audio() throws ClassNotFoundException, SQLException{
            DatabaseConnection.DatabaseConnection();
            byte[] audioImage = null;
            String indexQuery = "Select Index_Audio from IndexTable";
            Statement stmt = DatabaseConnection.connection.createStatement();
            ResultSet result = stmt.executeQuery(indexQuery);
            while(result.next()){
                audioImage = result.getBytes("Index_Audio");
            }
            return audioImage;
        }
        public static byte[] index_Pdf() throws ClassNotFoundException, SQLException{
            DatabaseConnection.DatabaseConnection();
            byte[] pdfImage = null;
            String indexQuery = "Select Index_Pdf from IndexTable";
            Statement stmt = DatabaseConnection.connection.createStatement();
            ResultSet result = stmt.executeQuery(indexQuery);
            if(result.next()){
                pdfImage = result.getBytes("Index_Pdf");
            }
            return pdfImage;
        }
        
        public static void uploadFiles() throws IOException{
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
               
                JOptionPane.showMessageDialog(chooser, "Image Uploaded Successfull ");
            }

        }else if(extension.equals(".mp4")| extension.equals(".mkv")|extension.equals(".Webm")){
            if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user) ){
                UserDatabases.getConnection(UserLoginForm_Index_Page.user);
                 String  videoName =  EssentialsMethods.setName(path);
                HomePageForm.uploadVideo(path,videoName,extension);
            }
            
//            Video Message
            JOptionPane.showMessageDialog(chooser, "Video Uploaded Successfull");
        }else if(extension.equals(".pdf")|extension.equals(".txt")|extension.equals(".docx")|extension.equals(".ppt")){
            if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user) ){
                UserDatabases.getConnection(UserLoginForm_Index_Page.username);
                 String  pdfName =  EssentialsMethods.setName(path);
                HomePageForm.uploadDocuments(path,pdfName,extension);
            }

//            pdf message
            JOptionPane.showMessageDialog(chooser, "Pdf File was Uploaded Successfull");
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
        
        }catch(HeadlessException | SQLException e){

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                            
        public static void randomFiles() throws ClassNotFoundException, SQLException{
//            DatabaseConnection.DatabaseConnection();
            UserDatabases.getConnection(UserLoginForm_Index_Page.username);
            String sqlQueryImage = "SELECT Image_Blob FROM ImageTable WHERE Img_Id="+EssentialsMethods.randomNumbers()+"";
            String sqlQueryVideo = "SELECT Video_Blob FROM VideoTable WHERE Video_Id="+EssentialsMethods.randomNumbers()+"";
            String sqlQueryPDF = "SELECT Pdf_Blob FROM PdfFileTable WHERE Pdf_ID="+EssentialsMethods.randomNumbers()+"";
            String sqlQueryAudio = "SELECT Audio_Blob FROM AudioTable WHERE Audio_Id="+EssentialsMethods.randomNumbers()+"";
            Statement stmt = DatabaseConnection.connection.createStatement();
            Statement stmt1 = DatabaseConnection.connection.createStatement();
            Statement stmt2 = DatabaseConnection.connection.createStatement();
            Statement stmt3 = DatabaseConnection.connection.createStatement();
            ResultSet resultImage = stmt.executeQuery(sqlQueryImage);
            ResultSet resultVideo = stmt1.executeQuery(sqlQueryVideo);
            ResultSet resultPdf = stmt2.executeQuery(sqlQueryPDF);
            ResultSet resultAudio = stmt3.executeQuery(sqlQueryAudio);
            if(resultImage.next()){
                byte[] image = resultImage.getBytes("Image_Blob");
                System.out.println(image);
            }
             if(resultVideo.next()){
                 byte[] video = resultVideo.getBytes("Video_Blob");
                 ArrayList<byte[]> videoImage = EssentialsMethods.index_Image();
//               byte[] vdImage = videoImage.get(0);
                System.out.println(video);
                System.out.println(videoImage);
//                 scaleImage(vdImage, jlabel);
            }
             if(resultAudio.next()){
                 byte[] audio = resultAudio.getBytes("Audio_Blob");
                 ArrayList<byte[]> audioImage = EssentialsMethods.index_Image();
                 byte[] audImage = audioImage.get(1);
                 System.out.println(audio);
//                 scaleImage(audImage, jlabel);
             }
            if(resultPdf.next()){
                byte[] pdf = resultPdf.getBytes("Pdf_Blob");
                ArrayList<byte[]> pdfImage = EssentialsMethods.index_Image();
                byte[] pdfImag = pdfImage.get(2);
                System.out.println(pdf);
//                scaleImage(pdfImag, jlabel);
            }
        }
        public static void scaleImage(byte[] image, JLabel jlabel){
            ImageIcon icon = new ImageIcon(image);
            Image img = icon.getImage();
            Image scaleImg = img.getScaledInstance(jlabel.getWidth(), jlabel.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon originalImage = new ImageIcon(scaleImg);
            jlabel.setIcon(originalImage);
        }
        public static String setName(String path){
            String pathq = path;
            int firstindex = path.lastIndexOf("/");
            int lastindex = path.lastIndexOf(".");
            System.out.println(lastindex);
            String name = path.substring(firstindex);
            String name1 = path.substring(lastindex);
            System.out.println(name+"  "+name1);
            String fileName = path.substring(firstindex+1, lastindex);
            System.out.println(fileName);
            return fileName;
            
        }
        public static boolean fetchDocs() throws ClassNotFoundException, SQLException{
            byte[] docs = null;
            String username = UserLoginForm_Index_Page.username;
            UserDatabases.getConnection(UserLoginForm_Index_Page.username);
            String fetchQuery = "select * from Documents";
            Statement stmt = UserDatabases.userConnect.createStatement();
            ResultSet result = stmt.executeQuery(fetchQuery);
            while(result.next()){
                 docs = result.getBytes("Pdf_Blob");
                String pdfname = result.getString("Pdf_Name");
            }
            if(docs==null){
                return false;
            }else{
                return true;
            }
        }
        public static boolean audioFetch() throws ClassNotFoundException, SQLException{
            byte[] docs = null;
            String username = UserLoginForm_Index_Page.username;
            UserDatabases.getConnection(UserLoginForm_Index_Page.username);
            String fetchQuery = "select * from AudioTable";
            Statement stmt = UserDatabases.userConnect.createStatement();
            ResultSet result = stmt.executeQuery(fetchQuery);
            while(result.next()){
                 docs = result.getBytes("Audio_Blob");
                String pdfname = result.getString("Audio_Name");
              
            }
            if(docs==null){
            return false;
                    }
            else{
                return true;
            }
        }
        public static boolean ImageFetch() throws ClassNotFoundException, SQLException{
            byte[] docs = null;
            String username = UserLoginForm_Index_Page.username;
            UserDatabases.getConnection(UserLoginForm_Index_Page.username);
            String fetchQuery = "select * from ImageTable";
            Statement stmt = UserDatabases.userConnect.createStatement();
            ResultSet result = stmt.executeQuery(fetchQuery);
            while(result.next()){
                 docs = result.getBytes("Image_Blob");
                String pdfname = result.getString("Image_Name");
              
            }
            if(docs==null){
                return false;
            }else
            return true;
        }
        public static boolean videoFetch() throws ClassNotFoundException, SQLException{
            byte[] docs = null;
            String username = UserLoginForm_Index_Page.username;
            UserDatabases.getConnection(UserLoginForm_Index_Page.username);
            String fetchQuery = "select * from VideoTable";
            Statement stmt = UserDatabases.userConnect.createStatement();
            ResultSet result = stmt.executeQuery(fetchQuery);
            while(result.next()){
                 docs = result.getBytes("Video_Blob");
                String pdfname = result.getString("Video_Name");
              
            }
            if(docs==null){
            return false;
                    }
            else{
                return true;
            }
        }
       
        
        
        public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
            
//            System.out.println(Arrays.toString(EssentialsMethods.fetchDocs()));
//        EssentialsMethods randomNums = new EssentialsMethods();
//        EssentialsMethods.generateRandomNumbers();
//            System.out.println(EssentialsMethods.generateRandomNumbers());
//            EssentialsMethods.updateUserInfo("9812452155", "Ram", "Pothinenihari");
//        EssentialsMethods.fetchMixedFile();
//EssentialsMethods.uploadFiles();
//EssentialsMethods.fetchUserProfile();
//EssentialsMethods.randomFiles();
//            EssentialsMethods.index_Image();
//            System.out.println(EssentialsMethods.index_Image());
//    randomFiles();
//            System.out.println(index_Video());
//            System.out.println(index_Audio());
//            System.out.println(index_Pdf());
    }
}
