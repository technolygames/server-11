/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.threads.serverThread;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Claas made to receive data from client application and stores it on server PC.
 * 
 * @author erick
 */
public class receiver implements Runnable{
    protected JLabel etiqueta;
    protected JLabel etiEstado;
    protected JCheckBox caja;
    protected Properties p;
    protected ServerSocket ss;
    
    {
        try{
            p=new Properties();
            p.load(new FileInputStream(getClass().getResource("classes/userClasses/config/config.properties").getFile()));
            ss=new ServerSocket(Integer.parseInt(p.getProperty("port")));
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\nCausado por:\n"+e.getCause());
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\nCausado por:\n"+e.getCause());
        }
    }
    
    /**
     * Initialize instance to receive the data sent from client app and convert it to a readable file.
     * 
     * @param label sets a message with the port number to bind.
     * @param label2 sets the actual state running of the server. If is true, means the server is running. If is false, you'll need to restart the server application
     */
    public receiver(JLabel label,JLabel label2,JCheckBox checkBox){
        this.etiqueta=label;
        this.etiEstado=label2;
        this.caja=checkBox;
    }
    
    /**
     * Receive data from the client and stores it on server PC.
     */
    @Override
    public void run(){
        try{
            etiqueta.setText("El puerto "+ss.getLocalPort()+" está activo");
            while(true){
                Socket s=ss.accept();
                InputStream is=s.getInputStream();
                DataInputStream dis=new DataInputStream(is);
                String filename=dis.readUTF();
                OutputStream os=new FileOutputStream(System.getProperty("user.dir")+"/src/main/java/classes/userClasses/receivedData/"+filename);
                long size=dis.readLong();
                new serverThread(is,os,size).run();
                
                os.flush();
            }
        }catch(EOFException k){
            JOptionPane.showMessageDialog(null,"Error:\n"+k.getMessage()+"\nCausado por:\n"+k.getCause());
            k.printStackTrace();
            System.out.println(k.getCause());
            closeServer();
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\nCausado por:\n"+e.getCause());
            e.printStackTrace();
            System.out.println(e.getCause());
            closeServer();
        }catch(IOException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage()+"\nCausado por:\n"+x.getCause());
            x.printStackTrace();
            System.out.println(x.getCause());
            closeServer();
        }catch(NullPointerException f){
            JOptionPane.showMessageDialog(null,"Error:\n"+f.getMessage()+"\nCausado por:\n"+f.getCause());
            f.printStackTrace();
            System.out.println(f.getCause());
            closeServer();
        }
    }
    
    /**
     * Close the server.
     */
    public void closeServer(){
        try{
            ss.close();
            caja.setEnabled(false);
            caja.setSelected(false);
            etiqueta.setText("Se apagó el servidor");
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\nCausado por:\n"+e.getCause());
        }catch(NullPointerException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage()+"\nCausado por:\n"+x.getCause());
        }
    }
    
    /**
     * Set on a label actual state running of the server.
     */
    public void getState(){
        if(ss.isClosed()==true){
            etiEstado.setText(String.valueOf(ss.isClosed()));
        }else if(ss.isClosed()==false){
            etiEstado.setText(String.valueOf(ss.isClosed()));
        }
    }
}