package ventanas;

import java.awt.BorderLayout;
import paneles.serverConfig;
import paneles.serverPanel;
import paneles.serverSender;

public class sendFiles extends javax.swing.JFrame{
    public sendFiles(){
        initComponents();
        
        botones();
    }
    
    protected final void botones(){
        closeButton.addActionListener((a)->{
            System.exit(0);
        });
        
        jMenuItem1.addActionListener((a)->{
            this.getContentPane().setLayout(new BorderLayout());
            this.getContentPane().add(new serverConfig(),BorderLayout.CENTER);
        });
        
        jMenuItem2.addActionListener((a)->{
            this.getContentPane().setLayout(new BorderLayout());
            this.getContentPane().add(new serverPanel(),BorderLayout.CENTER);
        });
        
        jMenuItem3.addActionListener((a)->{
            this.getContentPane().setLayout(new BorderLayout());
            this.getContentPane().add(new serverSender(),BorderLayout.CENTER);
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        closeButton.setText("Cerrar programa");

        jMenu1.setText("Ventanas");

        jMenuItem1.setText("Configurar servidor");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Servidor");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Enviar datos");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(277, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(245, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public static void main(String args[]){
        new sendFiles().setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables
}