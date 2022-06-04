package clases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * 
 * @author erick
 */
public class sender{
    public void sendFiles(String dir){
        try{
            Properties p=new Properties();
            p.load(new FileInputStream(System.getProperty("user.dir")+"/src/data/config/config.properties"));
            Socket s=new Socket(p.getProperty("ip"),Integer.parseInt(p.getProperty("port")));
            InputStream is=new FileInputStream(dir);
            OutputStream os=s.getOutputStream();
            new clientThread(is,os).run();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\n Causado por:\n"+e.getCause());
        }
    }
}