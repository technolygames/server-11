package clases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * Sends files between a device to a server.
 * 
 * @author erick
 */
public class sender{
    
    /**
     * Send a specified file to a server using internet through an specified port and ip address.
     * 
     * @param dir File to send to the server.
     */
    public void sendFiles(String dir){
        try{
            Properties p=new Properties();
            p.load(new FileInputStream(System.getProperty("user.dir")+"/src/data/config/config.properties"));
            Socket s=new Socket(p.getProperty("ip"),Integer.parseInt(p.getProperty("port")));
            InputStream is=new FileInputStream(dir);
            OutputStream os=s.getOutputStream();
            new Thread(new clientThread(is,os)).start();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\nCausado por:\n"+e.getCause());
        }
    }
}