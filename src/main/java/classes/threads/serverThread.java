/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.threads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;

/**
 * Thread class made to write files which the server has received from a client.
 * 
 * @author erick
 */
public class serverThread implements Runnable{
    protected InputStream is;
    protected OutputStream os;
    protected long size;
    
    /**
     * Initialize instance to write the file was sent data to the server.
     * 
     * @param is Input stream to read.
     * @param os Output stream to write.
     * @param size Size of the file.
     */
    public serverThread(InputStream is,OutputStream os,long size){
        this.is=is;
        this.os=os;
        this.size=size;
    }
    
    /**
     * Thread to convert byte array to a readable file.
     */
    @Override
    public void run(){
        int leido;
        byte[] buffer;
        try{
            buffer=new byte[2048];
            while(size>0&&(leido=is.read(buffer,0,(int)Math.min(buffer.length,size)))!=-1){
                os.write(buffer,0,leido);
                size-=leido;
            }
            
            is.close();
            os.flush();
            os.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage());
            e.printStackTrace();
        }
    }
}