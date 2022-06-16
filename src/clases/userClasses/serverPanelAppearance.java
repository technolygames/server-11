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
 * Class dedicated to the frame and panel appearance.
 * 
 * @author erick
 */
public class serverPanelAppearance{
    protected Properties p;
    protected String direccion;
    
    public serverPanelAppearance(String dir){
        this.direccion=dir;
    }
    
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