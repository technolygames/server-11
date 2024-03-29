package gui.panel;

import classes.userClasses.serverConfig;
import java.awt.Frame;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class svConfigPanel extends javax.swing.JPanel{
    public svConfigPanel(){
        initComponents();
        
        new serverConfig("data/config/config.properties").configIn(jTextField1,jTextField2,jComboBox1);
        
        botones();
        combo();
    }
    
    protected Properties p;
    
    protected final void botones(){
        closeButton.addActionListener((a)->{
            setVisible(false);
        });
        
        jComboBox1.addActionListener((a)->{
            try{
                String design=jComboBox1.getSelectedItem().toString();
                UIManager.setLookAndFeel(design);
                for(Frame frame:Frame.getFrames()){
                    SwingUtilities.updateComponentTreeUI(frame);
                    frame.pack();
                }
            }catch(ClassNotFoundException e){
                JOptionPane.showMessageDialog(this,"Error:\n"+e.getMessage());
                e.printStackTrace();
            }catch(IllegalAccessException x){
                JOptionPane.showMessageDialog(this,"Error:\n"+x.getMessage());
                x.printStackTrace();
            }catch(InstantiationException n){
                JOptionPane.showMessageDialog(this,"Error:\n"+n.getMessage());
                n.printStackTrace();
            }catch(UnsupportedLookAndFeelException k){
                JOptionPane.showMessageDialog(this,"Error:\n"+k.getMessage());
                k.printStackTrace();
            }
        });
        
        storeButton.addActionListener((a)->{
            new serverConfig("data/config/config.properties").configOut(jTextField1.getText(),jTextField2.getText(),jComboBox1.getSelectedItem().toString());
        });
    }
    
    static{
        UIManager.installLookAndFeel("FlatLafDark","com.formdev.flatlaf.FlatDarkLaf");
    }
    
    protected final void combo(){
        try{
            for(UIManager.LookAndFeelInfo lafi1:UIManager.getInstalledLookAndFeels()){
                jComboBox1.addItem(lafi1.getClassName());
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Error:\n"+e.getMessage());
            e.printStackTrace();
        }catch(IllegalArgumentException x){
            JOptionPane.showMessageDialog(this,"Error:\n"+x.getMessage());
            x.printStackTrace();
        }catch(NullPointerException n){
            JOptionPane.showMessageDialog(this,"Error:\n"+n.getMessage());
            n.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        storeButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        storeButton.setText("Guardar");

        closeButton.setText("Cerrar panel");

        jLabel1.setText("Puerto:");

        jLabel2.setText("Dirección IP:");

        jLabel3.setText("Diseños:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(storeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(storeButton)
                    .addComponent(closeButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton storeButton;
    // End of variables declaration//GEN-END:variables
}