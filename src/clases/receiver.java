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
public class receiver extends Thread implements Runnable{
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
    protected JLabel etiqueta;
    protected JLabel etiEstado;
    protected InputStream is;
    protected OutputStream os;
    
    /**
     * This class gets file sent from a client with the specified port and IP address of the server machine.
     * 
     * @param label sets a message with the port number to bind.
     * @param label2 sets the actual state running of the server. If is true, means the server is running. If is false, you'll need to restart the server application
     */
    public receiver(JLabel label,JLabel label2){
        this.etiqueta=label;
        this.etiEstado=label2;
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
                puerto=s.getPort();
                is=s.getInputStream();
                os=new FileOutputStream(System.getProperty("user.dir")+"/src/data/receivedData/test"+(int)(Math.random()*10000)+".txt");
                new serverThread(is,os).run();
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\nCausado por:\n"+e.getCause());
        }catch(NullPointerException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage()+"\nCausado por:\n"+x.getCause());
        }
    }
    
    /**
     * Close the server.
     */
    public void closeServer(){
        try{
            ss.close();
            /*s.close();
            os.flush();
            is.close();
            os.close();*/
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
    public void state(){
        if(ss.isClosed()==true){
            etiEstado.setText(String.valueOf(ss.isClosed()));
        }else if(ss.isClosed()==false){
            etiEstado.setText(String.valueOf(ss.isClosed()));
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
}