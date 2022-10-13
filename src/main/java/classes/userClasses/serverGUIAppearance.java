/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.userClasses;

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
public class serverGUIAppearance{
    protected Properties p;
    protected String direccion;
    
    /**
     * Initialize instance to get the config file and load look and feel.
     * 
     * @param dir Direction where the config file is located or will be located.
     */
    public serverGUIAppearance(String dir){
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
            JOptionPane.showMessageDialog(comp,"Error:\n"+e.getMessage());
            e.printStackTrace();
        }catch(InstantiationException x){
            JOptionPane.showMessageDialog(comp,"Error:\n"+x.getMessage());
            x.printStackTrace();
        }catch(IllegalAccessException n){
            JOptionPane.showMessageDialog(comp,"Error:\n"+n.getMessage());
            n.printStackTrace();
        }catch(UnsupportedLookAndFeelException k){
            JOptionPane.showMessageDialog(comp,"Error:\n"+k.getMessage());
            k.printStackTrace();
        }catch(NullPointerException s){
            JOptionPane.showMessageDialog(comp,"Error:\n"+s.getMessage());
            s.printStackTrace();
        }catch(FileNotFoundException j){
            JOptionPane.showMessageDialog(comp,"Error:\n"+j.getMessage());
            j.printStackTrace();
        }catch(IOException y){
            JOptionPane.showMessageDialog(comp,"Error:\n"+y.getMessage());
            y.printStackTrace();
        }
    }
}