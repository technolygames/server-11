package clases.userClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Class made to configurate ip address and port used by server and client.
 * 
 * @author erick
 */
public class serverConfig{
    protected Properties p;
    protected String direccion;
    
    /**
     * Initialize instance to specify port which will use both server and client to send data and ip address which will bind client application.
     * 
     * @param dir Direction where the config file is located or will be located.
     */
    public serverConfig(String dir){
        this.direccion=dir;
    }
    
    /**
     * Method adapted to display application config in a GUI.
     * It can be use with text fields or set null. This is only to display info.
     * You'll need to set .properties extension to set configuration.
     * 
     * @param textField1 Text field to display which is using port.
     * @param textField2 Text field to display which ip address is used to bind.
     * @param combobox Combo box to display which look and feel is set.
     */
    public void configIn(JTextField textField1,JTextField textField2,JComboBox combobox){
        try{
            p=new Properties();
            p.load(new FileInputStream(direccion));
            textField1.setText(p.getProperty("port"));
            textField2.setText(p.getProperty("ip"));
            combobox.getModel().setSelectedItem(p.getProperty("laf"));
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\nCausado por:\n"+e.getCause());
        }catch(IOException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage()+"\nCausado por:\n"+x.getCause());
        }catch(NullPointerException n){
            JOptionPane.showMessageDialog(null,"Error:\n"+n.getMessage()+"\nCausado por:\n"+n.getCause());
        }
    }
    
    /**
     * Method adapted to store server and client configuration.
     * This method is important to be able to use the server.
     * 
     * @param port Port which will use the server to receive files and client to bind and send files to the server.
     * @param ipAddress IP address which will use the client to bind to the server.
     * @param laf look and feel if you use a GUI to use the server.
     */
    public void configOut(String port,String ipAddress,String laf){
        p=new Properties();
        try{
            File f=new File(direccion);
            if(f.exists()==true){
                p.setProperty("port",port);
                p.setProperty("ip",ipAddress);
                p.setProperty("laf",laf);
                p.store(new FileWriter(direccion),"server_config");
            }else{
                f.createNewFile();
            }
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\nCausado por:\n"+e.getCause());
        }catch(IOException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage()+"\nCausado por:\n"+x.getCause());
        }
    }
    
    /**
     * Method adapted to store server and client configuration.
     * This method is important to be able to use the server. 
     * Specifically, this method is only to set the important config data if you aren't using a GUI.
     * 
     * @param port Port which will use the server to receive files and client to bind and send files to the server.
     * @param ipAddress IP address which will use the client to bind to the server.
     */
    public void configOut(String port,String ipAddress){
        p=new Properties();
        try{
            File f=new File(direccion);
            if(f.exists()==true){
                p.setProperty("port",port);
                p.setProperty("ip",ipAddress);
                p.store(new FileWriter(direccion),"server_config");
            }else{
                f.createNewFile();
            }
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\nCausado por:\n"+e.getCause());
        }catch(IOException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage()+"\nCausado por:\n"+x.getCause());
        }
    }
}