package clases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Receive data from an application and stores it on server PC.
 * 
 * @author erick
 */
public class receiver{
    protected ServerSocket ss;
    protected int puerto;
    protected boolean estado;
    protected JTextArea area;
    
    public receiver(JTextArea textArea){
        this.area=textArea;
    }
    /**
     * Receive data from a client and store it on server PC.
     */
    public void receiveFiles(){
        try{
            Properties p=new Properties();
            p.load(new FileInputStream(System.getProperty("user.dir")+"/src/data/config/config.properties"));
            ss=new ServerSocket(Integer.parseInt(p.getProperty("port")));
            System.out.println("El puerto "+ss.getLocalPort()+" está activo");
            PrintStream ps=new PrintStream(new CustomOutputStream(area));
            System.setOut(ps);
            System.setErr(ps);
            while(true){
                Socket s=ss.accept();
                estado=s.isConnected();
                puerto=s.getPort();
                InputStream is=s.getInputStream();
                OutputStream os=new FileOutputStream(System.getProperty("user.dir")+"/src/data/receivedData/test"+(int)(Math.random()*10000)+".txt");
                new serverThread(is,os).run();
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\n Causado por:\n"+e.getCause());
        }
    }
    
    /**
     * Close the server.
     */
    public void closeServer(){
        try{
            ss.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\n Causado por:\n"+e.getCause());
        }
    }
    
    /**
     * Gets port where can connect it.
     * 
     * @return used port
     */
    public int getPort(){
        return puerto;
    }
    
    /**
     * Gets actual state of the server if is connected or not.
     * 
     * @return status if is connected
     */
    public boolean getStatus(){
        return estado;
    }
}