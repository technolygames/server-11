/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.threads.serverThread;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Claas made to receive data from client application and stores it on server PC.
 * 
 * @author erick
 */
public class receiver implements Runnable{
    protected JLabel etiqueta;
    protected Properties p;
    protected ServerSocket ss;
    
    protected boolean state=true;
    
    /**
     * Initialize instance to receive the data sent from client app and convert it to a readable file.
     * 
     * @param label sets a message with the port number to bind.
     */
    public receiver(JLabel label){
        this.etiqueta=label;
    }
    
    public void startServer(){
        try{
            p=new Properties();
            p.load(new FileInputStream("data/config/config.properties"));
            ss=new ServerSocket(Integer.parseInt(p.getProperty("port")));
            this.run();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Close the server.
     */
    public void stopServer(){
        state=false;
        etiqueta.setText("Se apagó el servidor");
    }
    
    /**
     * Receive data from the client and stores it on server PC.
     */
    @Override
    public void run(){
        try{
            etiqueta.setText("El puerto "+ss.getLocalPort()+" está activo");
            while(state){
                p=new Properties();
                p.load(new FileInputStream("data/config/config.properties"));
                Socket s=ss.accept();
                InputStream is=s.getInputStream();
                DataInputStream dis=new DataInputStream(is);
                String filename=dis.readUTF();
                OutputStream os=new FileOutputStream("data/receivedData/"+filename);
                long size=dis.readLong();
                new serverThread(is,os,size).run();
                
                os.flush();
            }
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage());
            e.printStackTrace();
        }catch(IOException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage());
            x.printStackTrace();
        }catch(NullPointerException n){
            JOptionPane.showMessageDialog(null,"Error:\n"+n.getMessage());
            n.printStackTrace();
        }
    }
}