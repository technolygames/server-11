package clases;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author erick
 */
public class serverThread implements Runnable{
    protected InputStream is;
    protected OutputStream os;
    public serverThread(InputStream is,OutputStream os){
        this.is=is;
        this.os=os;
    }
    
    @Override
    public void run(){
        int leido;
        byte[] buffer;
        try{
            buffer=new byte[2048];
            while((leido=is.read(buffer))>0){
                os.write(buffer,0,leido);
            }
            
            is.close();
            os.flush();
            os.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\n Causado por:\n"+e.getCause());
        }
    }
}