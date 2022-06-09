package clases;

import java.io.FileInputStream;
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
 * Receive data from an application and stores it on server PC.
 * 
 * @author erick
 */
public class receiver implements Runnable{
    protected static Properties p;
    protected static ServerSocket ss;
    
    static{
        try{
            p=new Properties();
            p.load(new FileInputStream(System.getProperty("user.dir")+"/src/data/config/config.properties"));
            ss=new ServerSocket(Integer.parseInt(p.getProperty("port")));
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\nCausado por:\n"+e.getCause());
        }
    }
    
    protected Socket s;
    protected int puerto;
    protected boolean estado;
    protected JLabel etiqueta;
    protected InputStream is;
    protected OutputStream os;
    
    public receiver(JLabel label){
        this.etiqueta=label;
    }
    
    /**
     * Receive data from a client and store it on server PC.
     */
    @Override
    public void run(){
        try{
            String mensaje="El puerto "+ss.getLocalPort()+" está activo";
            etiqueta.setText(mensaje);
            while(true){
                s=ss.accept();
                estado=s.isConnected();
                puerto=s.getPort();
                is=s.getInputStream();
                os=new FileOutputStream(System.getProperty("user.dir")+"/src/data/receivedData/test"+(int)(Math.random()*10000)+".txt");
                new serverThread(is,os).run();
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\n Causado por:\n"+e.getCause());
        }catch(NullPointerException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage()+"\n Causado por:\n"+x.getCause());
        }
    }
    
    /**
     * Close the server.
     */
    public synchronized void closeServer(){
        try{
            ss.close();
            /*s.close();
            os.flush();
            is.close();
            os.close();*/
            etiqueta.setText("Se apagó el servidor");
        }catch(IOException e){
            //JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\n Causado por:\n"+e.getCause());
        }catch(NullPointerException x){
            //JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage()+"\n Causado por:\n"+x.getCause());
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