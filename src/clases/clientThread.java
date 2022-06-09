package clases;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;
/**
 * Thread made to read files which sends to a server.
 * 
 * @author erick
 */
public class clientThread implements Runnable{
    protected InputStream is;
    protected OutputStream os;
    
    /**
     * Initialize instance to send data to the server.
     * 
     * @param is Input stream to read.
     * @param os Output stream to send.
     */
    public clientThread(InputStream is,OutputStream os){
        this.is=is;
        this.os=os;
    }
    
    /**
     * Thread to convert a file to byte array and send it to the server.
     */
    @Override
    public void run(){
        byte[] buffer=new byte[2048];
        int leido;
        try{
            while((leido=is.read(buffer))>0){
                os.write(buffer,0,leido);
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\nCausado por:\n"+e.getCause());
        }
    }
}