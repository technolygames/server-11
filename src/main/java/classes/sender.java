/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Properties;
import javax.swing.JOptionPane;
import classes.threads.clientThread;

/**
 * Send files between a device client to a device server.
 * 
 * @author erick
 */
public class sender{
    /**
     * Send a specified file to a server using internet through an specified port and ip address.
     * it is possible to send a filename and entire file without failures.
     * 
     * @param dir File to send to the server.
     */
    public void sendFiles(String dir){
        try{
            Properties p=new Properties();
            p.load(new FileInputStream(dirs.userdir+"/data/config/config.properties"));
            
            Socket s=new Socket(p.getProperty("ip"),Integer.parseInt(p.getProperty("port")));
            
            File f=new File(dir);
            InputStream is=new FileInputStream(f);
            OutputStream os=s.getOutputStream();
            BufferedInputStream bis=new BufferedInputStream(is);
            DataInputStream dis=new DataInputStream(bis);
            DataOutputStream dos=new DataOutputStream(os);
            
            byte[] flujo=new byte[(int)f.length()];
            
            dis.readFully(flujo,0,flujo.length);
            dos.write(flujo,0,flujo.length);
            dos.writeUTF(f.getName());
            dos.writeLong(flujo.length);
            
            new Thread(new clientThread(is,os)).start();
            
            os.flush();
            dos.flush();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\nCausado por:\n"+e.getCause());
        }
    }
}