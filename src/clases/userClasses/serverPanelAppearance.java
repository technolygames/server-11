package clases.userClasses;

import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Class made to set frame and panel appearance.
 * Gets selected look and feel from config file.
 * 
 * @author erick
 */
public class serverPanelAppearance{
    protected Properties p;
    protected String direccion;
    
    /**
     * Initialize instance to get the config file and load look and feel.
     * 
     * @param dir Direction where the config file is located or will be located.
     */
    public serverPanelAppearance(String dir){
        this.direccion=dir;
    }
    
    /**
     * Method made to display the selected look and feel previously chosed inf the config panel.
     * It can be null because it's used by GUI containers.
     * 
     * @param comp Component which will be load or display the look and feel. It can be set panel, frame or window container.
     */
    public void LookAndFeel(Component comp){
        p=new Properties();
        try{
            p.load(new FileInputStream(direccion));
            UIManager.setLookAndFeel(p.getProperty("laf"));
            SwingUtilities.updateComponentTreeUI(comp);
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage()+"\nCausado por:\n"+e.getCause());
        }catch(InstantiationException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage()+"\nCausado por:\n"+x.getCause());
        }catch(IllegalAccessException l){
            JOptionPane.showMessageDialog(null,"Error:\n"+l.getMessage()+"\nCausado por:\n"+l.getCause());
        }catch(UnsupportedLookAndFeelException z){
            JOptionPane.showMessageDialog(null,"Error:\n"+z.getMessage()+"\nCausado por:\n"+z.getCause());
        }catch(NullPointerException n){
            JOptionPane.showMessageDialog(null,"Error:\n"+n.getMessage()+"\nCausado por:\n"+n.getCause());
        }catch(FileNotFoundException v){
            JOptionPane.showMessageDialog(null,"Error:\n"+v.getMessage()+"\nCausado por:\n"+v.getCause());
        }catch(IOException o){
            JOptionPane.showMessageDialog(null,"Error:\n"+o.getMessage()+"\nCausado por:\n"+o.getCause());
        }
    }
}