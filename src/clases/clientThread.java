package clases;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;

public class clientThread implements Runnable{
    protected InputStream is;
    protected OutputStream os;
    
    public clientThread(InputStream is,OutputStream os){
        this.is=is;
        this.os=os;
    }
    
    @Override
    public void run(){
        byte[] buffer=new byte[2048];
        int leido;
        try{
            while((leido=is.read(buffer))>0){
                os.write(buffer,0,leido);
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\n Causado por:\n"+e.getCause());
        }
    }
}