/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanagementsystem;

import java.sql.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 *
 * @author kalilinux
 */
public class WritingBlobData {
        
    DatabaseConnection connect = null;
  public static String extensionfromDB = null;
    public WritingBlobData() throws ClassNotFoundException, SQLException {
        DatabaseConnection.DatabaseConnection();
    }
    
        private byte[] readFile(String file) throws IOException {
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
        public void downloadFile(String fileName, String downloadLocation) throws SQLException, FileNotFoundException, IOException{
            String downloadQuery = "select Video_Blob from VideoTable where Video_Name=?";
            PreparedStatement preDownload = DatabaseConnection.connection.prepareStatement(downloadQuery);
            preDownload.setString(1, fileName);
            ResultSet res = preDownload.executeQuery();
            File deviceLocation = new File(downloadLocation);
            FileOutputStream fos = new FileOutputStream(deviceLocation);
            byte[] buffer = new byte[1024];
            while(res.next()){
                InputStream inpt = res.getBinaryStream("Video_Blob");
                while(inpt.read(buffer)>0){
                    fos.write(buffer);
                }
            }
        }
        public static void downloadFiles(String fileName, String downloadLocation) throws SQLException, FileNotFoundException, IOException{
            String downloadQueryvideo = "select Video_Blob,Video_Type from VideoTable where Video_Name=?";
            String downloadQueryImage = "select Image_Blob,Image_Type from ImageTable where Image_Name=?";
            String downloadQueryPdf = "select Pdf_Blob,Pdf_Type from PdfFilesTable where Pdf_Name=?";
            String downloadQueryDocuments = "select Pdf_Blob,Pdf_Type from Documents where Pdf_Name=?";
            String downloadQueryAudio = "select Audio_Blob,Audio_Type from AudioTable where Audio_Name=?";
            
//            PreparedStatement preDownload = DatabaseConnection.connection.prepareStatement(downloadQuery);
                PreparedStatement downloadVideo = UserDatabases.userConnect.prepareStatement(downloadQueryvideo);
                PreparedStatement downloadImage = UserDatabases.userConnect.prepareStatement(downloadQueryImage);
                PreparedStatement downloadPdf = UserDatabases.userConnect.prepareStatement(downloadQueryPdf);
                PreparedStatement downloadDocs = UserDatabases.userConnect.prepareStatement(downloadQueryDocuments);
                PreparedStatement downloadAudio = UserDatabases.userConnect.prepareStatement(downloadQueryAudio);
            downloadVideo.setString(1, fileName);
            downloadImage.setString(1, fileName);
            downloadPdf.setString(1, fileName);
            downloadDocs.setString(1, fileName);
            downloadAudio.setString(1, fileName);
            
            ResultSet resVideo = downloadVideo.executeQuery();
            ResultSet resImage = downloadImage.executeQuery();
            ResultSet resPdf = downloadPdf.executeQuery();
            ResultSet resDocs = downloadDocs.executeQuery();
            ResultSet resAudio = downloadAudio.executeQuery();
            File deviceLocation = new File(downloadLocation);
            FileOutputStream fos = new FileOutputStream(deviceLocation);
            byte[] buffer = new byte[1024];
           if(!resVideo.equals("")){
            while(resVideo.next()){
                InputStream inpt = resVideo.getBinaryStream("Video_Blob");
                extensionfromDB = resVideo.getString("Video_Type");
                int len;
                while((len = inpt.read(buffer))!= -1){
                    fos.write(buffer,0,len);
                    
                }
                System.out.println(extensionfromDB);
            }}
           else if(!resImage.equals("")){
            while(resImage.next()){
                InputStream inpt = resImage.getBinaryStream("Image_Blob");
                extensionfromDB = resImage.getString("Image_Type");
                while(inpt.read(buffer)>0){
                    fos.write(buffer);
                }
                System.out.println(extensionfromDB);
            }}
          else if(!resPdf.equals("")){
            while(resPdf.next()){
                InputStream inpt = resPdf.getBinaryStream("Pdf_Blob");
                extensionfromDB = resPdf.getString("Pdf_Type");
               int len;
                while((len = inpt.read(buffer))!= -1){
                    fos.write(buffer,0,len);
                System.out.println(extensionfromDB);
            }}}
          else if(!resDocs.equals("")){
            while(resDocs.next()){
                InputStream inpt = resDocs.getBinaryStream("Pdf_Blob");
                extensionfromDB = resDocs.getString("Pdf_Type");
                int len;
                while((len = inpt.read(buffer))!= -1){
                    fos.write(buffer,0,len);
            }}}
          else if(!resAudio.equals("")){
            while(resAudio.next()){
                InputStream inpt = resAudio.getBinaryStream("Audio_Blob");
                extensionfromDB = resAudio.getString("Audio_Type");
                while(inpt.read(buffer)>0){
                    fos.write(buffer);
                }
            }}else{
               System.out.println("No data found");
          }
        }
        public static void downloadFilesStream(String fileName, String downloadLocation) throws SQLException, FileNotFoundException, IOException{
            String downloadQueryvideo = "select Video_Blob,Video_Type from VideoTable where Video_Name=?";
            String downloadQueryImage = "select Image_Blob,Image_Type from ImageTable where Image_Name=?";
            String downloadQueryPdf = "select Pdf_Blob,Pdf_Type from PdfFilesTable where Pdf_Name=?";
            String downloadQueryDocuments = "select Pdf_Blob,Pdf_Type from Documents where Pdf_Name=?";
            String downloadQueryAudio = "select Audio_Blob,Audio_Type from AudioTable where Audio_Name=?";
            
//            PreparedStatement preDownload = DatabaseConnection.connection.prepareStatement(downloadQuery);
                PreparedStatement downloadVideo = UserDatabases.userConnect.prepareStatement(downloadQueryvideo);
                PreparedStatement downloadImage = UserDatabases.userConnect.prepareStatement(downloadQueryImage);
                PreparedStatement downloadPdf = UserDatabases.userConnect.prepareStatement(downloadQueryPdf);
                PreparedStatement downloadDocs = UserDatabases.userConnect.prepareStatement(downloadQueryDocuments);
                PreparedStatement downloadAudio = UserDatabases.userConnect.prepareStatement(downloadQueryAudio);
            downloadVideo.setString(1, fileName);
            downloadImage.setString(1, fileName);
            downloadPdf.setString(1, fileName);
            downloadDocs.setString(1, fileName);
            downloadAudio.setString(1, fileName);
            
            ResultSet resVideo = downloadVideo.executeQuery();
            ResultSet resImage = downloadImage.executeQuery();
            ResultSet resPdf = downloadPdf.executeQuery();
            ResultSet resDocs = downloadDocs.executeQuery();
            ResultSet resAudio = downloadAudio.executeQuery();
            File deviceLocation = new File(downloadLocation);
            FileOutputStream fos = new FileOutputStream(deviceLocation);
            byte[] buffer = new byte[1024];
           if(!resVideo.equals("")){
            while(resVideo.next()){
                InputStream inpt = resVideo.getBinaryStream("Video_Blob");
                extensionfromDB = resVideo.getString("Video_Type");
                int len;
                while((len = inpt.read(buffer))!= -1){
                    fos.write(buffer,0,len);
                    
                }
                System.out.println(extensionfromDB);
            }}
            if(!resImage.equals("")){
            while(resImage.next()){
                InputStream inpt = resImage.getBinaryStream("Image_Blob");
                extensionfromDB = resImage.getString("Image_Type");
                while(inpt.read(buffer)>0){
                    fos.write(buffer);
                }
                System.out.println(extensionfromDB);
            }}
           if(!resPdf.equals("")){
            while(resPdf.next()){
                InputStream inpt = resPdf.getBinaryStream("Pdf_Blob");
                extensionfromDB = resPdf.getString("Pdf_Type");
               int len;
                while((len = inpt.read(buffer))!= -1){
                    fos.write(buffer,0,len);
                System.out.println(extensionfromDB);
            }}}
           if(!resDocs.equals("")){
            while(resDocs.next()){
                InputStream inpt = resDocs.getBinaryStream("Pdf_Blob");
                extensionfromDB = resDocs.getString("Pdf_Type");
                int len;
                while((len = inpt.read(buffer))!= -1){
                    fos.write(buffer,0,len);
            }}}
           if(!resAudio.equals("")){
            while(resAudio.next()){
                InputStream inpt = resAudio.getBinaryStream("Audio_Blob");
                extensionfromDB = resAudio.getString("Audio_Type");
               int len;
                while((len = inpt.read(buffer))!= -1){
                    fos.write(buffer,0,len);
            }}
          
        }}
        
     public  void updatePicture(int imageId, String filename) throws IOException {
        // update sql
        String updateSQL = "UPDATE ImageTable "
                + "SET Image_Blob = ? "
                + "WHERE Img_Id=?";

        try ( PreparedStatement pstmt = DatabaseConnection.connection.prepareStatement(updateSQL)) {

            // set parameters
            pstmt.setBytes(1, readFile(filename));
            pstmt.setInt(2, imageId);
            
            pstmt.executeUpdate();
            System.out.println("Stored the file in the BLOB column.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
     public static void deletePicture(String FileName) throws IOException {
        // update sql
        String deletSQLImage = "DELETE FROM ImageTable WHERE Image_Name = ?";
        String deletSQLVideo = "DELETE FROM VideoTable WHERE Video_Name = ?";
        String deletSQLPdf = "DELETE FROM PdfFilesTable WHERE Pdf_Name = ?";
        String deletSQLDocuments = "DELETE FROM Documents WHERE Pdf_Name = ?";
        String deletSQLAudio = "DELETE FROM AudioTable WHERE Audio_Name = ?";

        try ( PreparedStatement pstmtImage = UserDatabases.userConnect.prepareStatement(deletSQLImage)) {
            PreparedStatement pstmtVideo = UserDatabases.userConnect.prepareStatement(deletSQLVideo);
            PreparedStatement pstmtPdf = UserDatabases.userConnect.prepareStatement(deletSQLPdf);
            PreparedStatement pstmtDocs = UserDatabases.userConnect.prepareStatement(deletSQLDocuments);
            PreparedStatement pstmtAudio = UserDatabases.userConnect.prepareStatement(deletSQLAudio);
            // set parameters
            if(!pstmtImage.equals("")){
            pstmtImage.setString(1, FileName);
            pstmtImage.executeUpdate();
            System.out.println("Stored the file in the BLOB column.");
            }
            if(!pstmtImage.equals("")){
            pstmtImage.setString(1, FileName);
            pstmtImage.executeUpdate();
            System.out.println("Stored the file in the BLOB column.");
            }
            if(!pstmtVideo.equals("")){
            pstmtVideo.setString(1, FileName);
            pstmtImage.executeUpdate();
            System.out.println("Stored the file in the BLOB column.");
            }
            if(!pstmtPdf.equals("")){
            pstmtImage.setString(1, FileName);
            pstmtImage.executeUpdate();
            System.out.println("Stored the file in the BLOB column.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

     public void uploadVideo(String filenamevideo) throws IOException, SQLException{
         String insertVideo = "insert into VideoTable(Video_Blob) values (?)";
         PreparedStatement videostmt = DatabaseConnection.connection.prepareStatement(insertVideo);
         videostmt.setBytes(1, readFile(filenamevideo));
         videostmt.executeUpdate();
     }
     public void uploadVideoMoreFeature(String filenamevideo, String videoName, String videoType, String videoSize) throws SQLException, IOException{
         String insertVideo = "insert into VideoTable(Video_Blob,Video_Name,Video_Size,Video_Type) values (?,?,?,?)";
//         PreparedStatement videostmt = DatabaseConnection.connection.prepareStatement(insertVideo);
         PreparedStatement videostmt = UserDatabases.userConnect.prepareStatement(insertVideo);
         videostmt.setBytes(1, readFile(filenamevideo));
         videostmt.setString(2, videoName);
         videostmt.setString(3, videoSize);
         videostmt.setString(4, videoType);
         videostmt.executeUpdate();
     }
     private void uploadIndexImage(String videoImage, String audioImage, String pdfImage) throws SQLException, IOException{
         String uploadQuery = "INSERT INTO IndexTable(Index_Video,Index_Audio,Index_Pdf) VALUES (?,?,?)";
         PreparedStatement stmt = DatabaseConnection.connection.prepareStatement(uploadQuery);
         stmt.setBytes(1, readFile(videoImage));
         stmt.setBytes(2, readFile(audioImage));
         stmt.setBytes(3, readFile(pdfImage));
         stmt.executeUpdate();
     }
     
        public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
           WritingBlobData blob = new WritingBlobData();
          /* blob.uploadVideo("/home/kalilinux/NetBeansProjects/filemanagementsystem/videos/minion360.mp4");
            System.out.println("inserted");
            */
//          blob.updatePicture(5, "/home/kalilinux/NetBeansProjects/filemanagementsystem/images/stupid.jpg");
        
//          blob.downloadFile(2, "/home/kalilinux/NetBeansProjects/filemanagementsystem/downloadedFromDBMS/dd.mp4");
//            blob.uploadIndexImage("/home/kalilinux/Documents/Index-Image/video-take.png", "/home/kalilinux/Documents/Index-Image/unnamed.png", "/home/kalilinux/Documents/Index-Image/PDF_file_icon.svg.webp");
//        blob.uploadVideoMoreFeature("/home/kalilinux/Downloads/emoji.mp4", "emoji", ".mp4", "1265kb");
        
        }
}
