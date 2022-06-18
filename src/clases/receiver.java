package clases;

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
    protected String direccion;
    
    /**
     * Initialize instance to receive the data sent from client app and convert it to a readable file.
     * 
     * @param label sets a message with the port number to bind.
     * @param dir get the config file where is the port to be use.
     */
    public receiver(JLabel label,String dir){
        this.etiqueta=label;
        this.direccion=dir;
    }
    
    protected Socket s;
    protected InputStream is;
    protected OutputStream os;
    protected Properties p;
    protected ServerSocket ss;
    
    protected int puerto;
    
    /**
     * Receive data from the client and stores it on server PC.
     */
    @Override
    public void run(){
        try{
            p=new Properties();
            p.load(new FileInputStream(direccion));
            ss=new ServerSocket(Integer.parseInt(p.getProperty("port")));
            etiqueta.setText("El puerto "+ss.getLocalPort()+" está activo");
            while(true){
                s=ss.accept();
                is=s.getInputStream();
                DataInputStream dis=new DataInputStream(is);
                String filename=dis.readUTF();
                os=new FileOutputStream(System.getProperty("user.dir")+"/src/data/receivedData/"+filename);
                long size=dis.readLong();
                new serverThread(is,os,size).run();
                
                os.flush();
            }
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\nCausado por:\n"+e.getCause());
        }catch(IOException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage()+"\nCausado por:\n"+x.getCause());
        }catch(NullPointerException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage()+"\nCausado por:\n"+x.getCause());
        }
    }
}