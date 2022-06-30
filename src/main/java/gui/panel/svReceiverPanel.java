package gui.panel;

import classes.receiver;
import classes.userClasses.serverGUIAppearance;
import gui.frame.mainFrame;

public class svReceiverPanel extends javax.swing.JPanel{
    public svReceiverPanel(){
        initComponents();
        
        new serverGUIAppearance(System.getProperty("user.dir")+"/src/main/resources/config/config.properties").LookAndFeel(this);
        botones();
        
        setSize(new mainFrame().getWidth(),new mainFrame().getHeight());
    }
    
    protected final void botones(){
        closeButton.addActionListener((a)->{
            setVisible(false);
        });
        
        cbStatusServer.addActionListener((a)->{
            if(cbStatusServer.isSelected()==true){
                new Thread(new receiver(jLabel1,jLabel2)).start();
                new receiver(jLabel1,jLabel2).getState();
            }else if(cbStatusServer.isSelected()==false){
                new receiver(jLabel1,jLabel2).closeServer();
                new receiver(jLabel1,jLabel2).getState();
                cbStatusServer.setEnabled(false);
                closeButton.setEnabled(false);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbStatusServer = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        cbStatusServer.setText("Activar sever");

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        closeButton.setText("Cerrar panel");

        jLabel3.setText("Para reiniciar, cierra el programa.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbStatusServer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addComponent(closeButton)
                            .addComponent(jLabel3))
                        .addGap(0, 214, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbStatusServer)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbStatusServer;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}