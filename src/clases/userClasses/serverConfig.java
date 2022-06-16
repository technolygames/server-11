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
 * Class dedicated to configurate ip address and port used by server.
 * 
 * @author erick
 */
public class serverConfig{
    protected Properties p;
    protected String direccion;
    
    public serverConfig(String dir){
        this.direccion=dir;
    }
    
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
    
    public void configOut(JTextField textField1,JTextField textField2,JComboBox combobox){
        p=new Properties();
        try{
            File f=new File(direccion);
            if(f.exists()==true){
                p.setProperty("port",textField1.getText());
                p.setProperty("ip",textField2.getText());
                p.setProperty("laf",combobox.getSelectedItem().toString());
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