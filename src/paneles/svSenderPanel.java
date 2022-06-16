package paneles;

import clases.sender;
import clases.userClasses.serverPanelAppearance;
import java.io.File;
import javax.swing.JFileChooser;
import ventanas.mainFrame;

public class svSenderPanel extends javax.swing.JPanel{
    public svSenderPanel(){
        initComponents();
        
        new serverPanelAppearance(System.getProperty("user.dir")+"/src/data/config/config.properties").LookAndFeel(this);
        botones();
        
        setSize(new mainFrame().getWidth(),new mainFrame().getHeight());
    }
    
    protected final void botones(){
        chooserButton.addActionListener((a)->{
            JFileChooser fileChooser=new JFileChooser();
            if(JFileChooser.APPROVE_OPTION==fileChooser.showOpenDialog(null)){
                File f=fileChooser.getSelectedFile();
                jTextField1.setText(f.getAbsolutePath());
            }
        });
        
        closeButton.addActionListener((a)->{
            setVisible(false);
        });
        
        sendButton.addActionListener((a)->{
            new sender().sendFiles(jTextField1.getText());
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        chooserButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        jLabel1.setText("Dirección:");

        sendButton.setText("Enviar");

        chooserButton.setText("Seleccionar");

        closeButton.setText("Cerrar panel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chooserButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sendButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton)
                        .addGap(0, 215, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(chooserButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendButton)
                    .addComponent(closeButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooserButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables
}